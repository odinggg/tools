import io
import base64
import logging
import requests
from pathlib import Path
from pdf2image import convert_from_bytes
from PIL import Image
from fastapi import HTTPException
from app.config import settings

logger = logging.getLogger(__name__)

class PDFProcessor:
    def __init__(self, task_id: str, max_image_side: int = 1024):
        self.task_id = task_id
        self.work_dir = settings.TEMP_ROOT / task_id
        self.output_dir = self.work_dir / "ocr_output"
        self.max_image_side = max_image_side

        # 初始化目录
        self.work_dir.mkdir(parents=True, exist_ok=True)
        self.output_dir.mkdir(parents=True, exist_ok=True)

    def process_pdf(self, pdf_bytes: bytes, page_range: str = "all") -> Path:
        """将PDF转图片并调用 Layout API，返回包含 markdown 的目录"""
        try:
            first_page, last_page = self._parse_page_range(page_range)

            # 转换图片
            images = convert_from_bytes(
                pdf_bytes,
                first_page=first_page,
                last_page=last_page,
                fmt='jpeg'
            )

            for idx, img in enumerate(images):
                img_bytes = self._resize_and_convert_image(img)
                self._call_layout_api(img_bytes, idx)

            return self.output_dir

        except Exception as e:
            logger.error(f"PDF Processing failed: {e}")
            raise HTTPException(status_code=500, detail=f"PDF Processing failed: {str(e)}")

    def _parse_page_range(self, page_range: str):
        if page_range == "all":
            return None, None
        if "-" in page_range:
            parts = page_range.split("-")
            return int(parts[0]), int(parts[1])
        return int(page_range), int(page_range)

    def _resize_and_convert_image(self, img: Image.Image) -> bytes:
        w, h = img.size
        if max(w, h) > self.max_image_side:
            scale = self.max_image_side / max(w, h)
            new_w, new_h = int(w * scale), int(h * scale)
            img = img.resize((new_w, new_h), Image.Resampling.LANCZOS)

        img_byte_arr = io.BytesIO()
        img.save(img_byte_arr, format='JPEG', quality=95)
        return img_byte_arr.getvalue()

    def _call_layout_api(self, image_bytes: bytes, page_index: int):
        image_data = base64.b64encode(image_bytes).decode("ascii")
        payload = {"file": image_data, "fileType": 1}

        try:
            resp = requests.post(settings.LAYOUT_API_URL, json=payload)
            resp.raise_for_status()
            res_json = resp.json().get("result", {})

            for i, item in enumerate(res_json.get("layoutParsingResults", [])):
                page_dir = self.output_dir / f"page_{page_index}_{i}"
                page_dir.mkdir(parents=True, exist_ok=True)

                if "markdown" in item:
                    (page_dir / "doc.md").write_text(item["markdown"]["text"], encoding="utf-8")
        except Exception as e:
            logger.error(f"Layout API Error on page {page_index}: {e}")
            # 不阻断整个流程，记录错误即可