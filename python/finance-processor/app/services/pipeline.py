import asyncio
import json
from pathlib import Path
from typing import Any, Callable, Dict, List, Optional

from fastapi import HTTPException

from app.core.oss import OracleOSSClient
from app.core.pdf import PDFProcessor
from app.parsers.factory import create_parser
from app.schemas.models import OutputFormat, ParserType, RegexRule


def _parse_rules(raw: Any) -> List[RegexRule]:
    if raw is None:
        return []
    if isinstance(raw, list):
        return [RegexRule(**x) if not isinstance(x, RegexRule) else x for x in raw]
    if isinstance(raw, str):
        raw = raw.strip()
        if not raw:
            return []
        data = json.loads(raw)
        if not isinstance(data, list):
            raise ValueError("extra_config must be a JSON array")
        return [RegexRule(**x) for x in data]
    raise ValueError("Unsupported extra_config format")


def _run_pipeline_sync(
    *,
    task_id: str,
    pdf_path: Path,
    page_range: str,
    max_image_side: int,
    output_format: OutputFormat,
    parser_type: ParserType,
    rules: List[RegexRule],
    progress_cb: Callable[[int, str], None],
) -> Dict[str, str]:
    progress_cb(15, "ocr_layout_processing")
    processor = PDFProcessor(task_id, max_image_side)
    markdown_dir = processor.process_pdf_file(pdf_path, page_range)

    progress_cb(80, "parsing")
    try:
        parser = create_parser(parser_type=parser_type, input_dir=markdown_dir, rules=rules, output_format=output_format)
    except ValueError as e:
        raise HTTPException(status_code=400, detail=str(e))

    result_files = parser.run()
    if not result_files:
        raise RuntimeError("No result files generated")

    progress_cb(95, "uploading_to_oci")
    oss_client = OracleOSSClient()
    upload_urls: Dict[str, str] = {}
    for res_file in result_files:
        object_name = f"{task_id}/{res_file.name}"
        url = oss_client.upload_file(res_file, object_name)
        upload_urls[res_file.name] = url

    return upload_urls


async def run_pipeline(
    *,
    task_id: str,
    payload: Dict[str, Any],
    progress_cb: Callable[[int, str], None],
) -> Dict[str, str]:
    pdf_path = Path(payload["pdf_path"])
    page_range = payload.get("page_range", "all")
    max_image_side = int(payload.get("max_image_side", 1024))
    output_format = OutputFormat(payload.get("output_format", OutputFormat.BOTH))
    parser_type = ParserType(payload.get("parser_type", ParserType.CMB))
    rules = _parse_rules(payload.get("extra_config"))

    return await asyncio.to_thread(
        _run_pipeline_sync,
        task_id=task_id,
        pdf_path=pdf_path,
        page_range=page_range,
        max_image_side=max_image_side,
        output_format=output_format,
        parser_type=parser_type,
        rules=rules,
        progress_cb=progress_cb,
    )

