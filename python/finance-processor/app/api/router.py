import uuid
import shutil
import logging
from pathlib import Path
from typing import List, Any, Dict
from fastapi import APIRouter, UploadFile, File, Form, BackgroundTasks, HTTPException
from pydantic import Json

from app.config import settings
from app.schemas.models import (
    ProcessResponse,
    OutputFormat,
    ParserType,
    RegexRule,
    TaskSubmitResponse,
    TaskStatusResponse,
    TaskStatus,
)
from app.core.pdf import PDFProcessor
from app.core.oss import OracleOSSClient
from app.parsers.factory import create_parser
from app.tasks.manager import task_manager

router = APIRouter()
logger = logging.getLogger(__name__)

def _save_upload_to_path(file: UploadFile, dest: Path) -> None:
    dest.parent.mkdir(parents=True, exist_ok=True)
    try:
        # 确保从头读取
        try:
            file.file.seek(0)
        except Exception:
            pass
        written = 0
        with open(dest, "wb") as f:
            while True:
                chunk = file.file.read(1024 * 1024)
                if not chunk:
                    break
                written += len(chunk)
                if written > settings.MAX_UPLOAD_BYTES:
                    raise HTTPException(status_code=413, detail="File too large")
                f.write(chunk)
    except HTTPException:
        try:
            if dest.exists():
                dest.unlink()
        except Exception:
            pass
        raise
    except Exception as e:
        try:
            if dest.exists():
                dest.unlink()
        except Exception:
            pass
        raise HTTPException(status_code=400, detail=f"Failed to save upload: {e}")

def cleanup_task(folder_path: Path):
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

    # 注册清理任务
    background_tasks.add_task(cleanup_task, processor.work_dir)

    try:
        oss_client = OracleOSSClient()
        # 2. 保存文件
        pdf_path = processor.work_dir / "input.pdf"
        _save_upload_to_path(file, pdf_path)

        # 3. PDF 处理与 OCR
        logger.info(f"Task {task_id}: Processing PDF...")
        markdown_dir = processor.process_pdf_file(pdf_path, page_range)

        # 4. 解析与生成
        logger.info(f"Task {task_id}: Parsing statements with {parser_type}...")

        # 这里可以使用工厂模式根据 parser_type 选择解析器，目前只有一个
        try:
            parser = create_parser(
                parser_type=parser_type,
                input_dir=markdown_dir,
                rules=extra_config,
                output_format=output_format,
            )
        except ValueError as e:
            raise HTTPException(status_code=400, detail=str(e))

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


@router.post("/tasks", response_model=TaskSubmitResponse, summary="提交银行流水处理任务（异步）")
async def submit_task(
    file: UploadFile = File(..., description="银行流水PDF文件"),
    page_range: str = Form("all", description="页码范围，如 1-5, all"),
    max_image_side: int = Form(1024, description="图片最大边长"),
    output_format: OutputFormat = Form(OutputFormat.BOTH, description="输出格式"),
    parser_type: ParserType = Form(ParserType.CMB, description="解析器类型"),
    extra_config: str = Form("[]", description="正则规则JSON配置（数组）"),
):
    task_id = str(uuid.uuid4())
    logger.info(f"Enqueue task {task_id}, filename: {file.filename}")

    # 初始化任务状态
    await task_manager.create_task(task_id)

    # 落盘到临时目录（后续 pipeline 从路径读取）
    pdf_work_dir = settings.TEMP_ROOT / task_id
    pdf_work_dir.mkdir(parents=True, exist_ok=True)
    pdf_path = pdf_work_dir / "input.pdf"

    _save_upload_to_path(file, pdf_path)

    payload: Dict[str, Any] = {
        "pdf_path": str(pdf_path),
        "page_range": page_range,
        "max_image_side": max_image_side,
        "output_format": output_format.value,
        "parser_type": parser_type.value,
        "extra_config": extra_config,
    }
    await task_manager.enqueue(task_id, payload)

    return TaskSubmitResponse(task_id=task_id, status=TaskStatus.QUEUED)


@router.get("/tasks/{task_id}", response_model=TaskStatusResponse, summary="查询任务状态/进度")
async def get_task(task_id: str):
    st = await task_manager.get_state(task_id)
    if not st:
        raise HTTPException(status_code=404, detail="Task not found")
    return TaskStatusResponse(
        task_id=st.task_id,
        status=st.status,
        progress=st.progress,
        message=st.message,
        results=st.results,
        error=st.error,
    )


@router.get("/tasks", summary="列出任务（内存队列）")
async def list_tasks():
    states = await task_manager.list_states()
    # 简单返回：task_id -> 状态摘要
    return {
        tid: {
            "status": st.status,
            "progress": st.progress,
            "message": st.message,
        }
        for tid, st in states.items()
    }