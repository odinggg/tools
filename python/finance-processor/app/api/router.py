import uuid
import shutil
import logging
from typing import List
from fastapi import APIRouter, UploadFile, File, Form, BackgroundTasks, HTTPException
from pydantic import Json

from app.schemas.models import ProcessResponse, OutputFormat, ParserType, RegexRule
from app.core.pdf import PDFProcessor
from app.core.oss import OracleOSSClient
from app.parsers.cmb import CMBStatementParser

router = APIRouter()
logger = logging.getLogger(__name__)

def cleanup_task(folder_path):
    """后台任务：清理临时文件"""
    if folder_path.exists():
        try:
            shutil.rmtree(folder_path)
            logger.info(f"Cleaned up temp dir: {folder_path}")
        except Exception as e:
            logger.error(f"Cleanup failed: {e}")

@router.post("/process_statement", response_model=ProcessResponse, summary="处理银行流水PDF")
async def process_statement(
        background_tasks: BackgroundTasks,
        file: UploadFile = File(..., description="银行流水PDF文件"),
        page_range: str = Form("all", description="页码范围，如 1-5, all"),
        max_image_side: int = Form(1024, description="图片最大边长"),
        output_format: OutputFormat = Form(OutputFormat.BOTH, description="输出格式"),
        parser_type: ParserType = Form(ParserType.CMB, description="解析器类型"),
        extra_config: Json[List[RegexRule]] = Form(..., description='正则规则JSON配置'),
):
    # 1. 初始化任务上下文
    task_id = str(uuid.uuid4())
    logger.info(f"Received task {task_id}, filename: {file.filename}")

    processor = PDFProcessor(task_id, max_image_side)
    oss_client = OracleOSSClient()

    # 注册清理任务
    background_tasks.add_task(cleanup_task, processor.work_dir)

    try:
        # 2. 保存文件
        pdf_path = processor.work_dir / "input.pdf"
        with open(pdf_path, "wb") as f:
            content = await file.read()
            f.write(content)

        # 3. PDF 处理与 OCR
        logger.info(f"Task {task_id}: Processing PDF...")
        markdown_dir = processor.process_pdf(content, page_range)

        # 4. 解析与生成
        logger.info(f"Task {task_id}: Parsing statements with {parser_type}...")

        # 这里可以使用工厂模式根据 parser_type 选择解析器，目前只有一个
        if parser_type == ParserType.CMB:
            parser = CMBStatementParser(markdown_dir, extra_config, output_format)
        else:
            raise HTTPException(status_code=400, detail="Unsupported parser type")

        result_files = parser.run()

        # 5. 上传结果
        upload_urls = {}
        for res_file in result_files:
            object_name = f"{task_id}/{res_file.name}"
            url = oss_client.upload_file(res_file, object_name)
            upload_urls[res_file.name] = url

        return ProcessResponse(
            status="success",
            task_id=task_id,
            results=upload_urls
        )

    except Exception as e:
        logger.error(f"Task {task_id} failed: {e}", exc_info=True)
        raise HTTPException(status_code=500, detail=str(e))