import io
import base64
import logging
import requests
from pathlib import Path
from pdf2image import convert_from_bytes
from pdf2image import convert_from_path
from PIL import Image
from fastapi import HTTPException
from app.config import settings
from requests.adapters import HTTPAdapter
from urllib3.util.retry import Retry

logger = logging.getLogger(__name__)

class PDFProcessor:
    def __init__(self, task_id: str, max_image_side: int = 1024):
        self.task_id = task_id
        self.work_dir = settings.TEMP_ROOT / task_id
        self.output_dir = self.work_dir / "ocr_output"
        self.max_image_side = max_image_side
        self._session = self._build_http_session()

        # 初始化目录
        self.work_dir.mkdir(parents=True, exist_ok=True)
        self.output_dir.mkdir(parents=True, exist_ok=True)

    def _build_http_session(self) -> requests.Session:
        session = requests.Session()
        retries = Retry(
            total=max(settings.LAYOUT_API_RETRIES, 0),
            connect=max(settings.LAYOUT_API_RETRIES, 0),
            read=max(settings.LAYOUT_API_RETRIES, 0),
            status=max(settings.LAYOUT_API_RETRIES, 0),
            backoff_factor=max(settings.LAYOUT_API_BACKOFF_SECONDS, 0.0),
            status_forcelist=(429, 500, 502, 503, 504),
            allowed_methods=frozenset(["POST"]),
            raise_on_status=False,
        )
        adapter = HTTPAdapter(max_retries=retries)
        session.mount("http://", adapter)
        session.mount("https://", adapter)
        return session

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

        except HTTPException:
            raise
        except Exception as e:
            logger.error(f"PDF Processing failed: {e}", exc_info=True)
            raise HTTPException(status_code=500, detail=f"PDF Processing failed: {str(e)}")

    def process_pdf_file(self, pdf_path: Path, page_range: str = "all") -> Path:
        """从文件路径将PDF转图片并调用 Layout API，返回包含 markdown 的目录"""
        try:
            if not pdf_path.exists():
                raise HTTPException(status_code=400, detail="PDF file not found")

            first_page, last_page = self._parse_page_range(page_range)

            images = convert_from_path(
                str(pdf_path),
                first_page=first_page,
                last_page=last_page,
                fmt="jpeg",
            )

            for idx, img in enumerate(images):
                img_bytes = self._resize_and_convert_image(img)
                self._call_layout_api(img_bytes, idx)

            return self.output_dir

        except HTTPException:
            raise
        except Exception as e:
            logger.error(f"PDF Processing failed: {e}", exc_info=True)
            raise HTTPException(status_code=500, detail=f"PDF Processing failed: {str(e)}")

    def _parse_page_range(self, page_range: str):
        if not page_range or page_range == "all":
            return None, None
        page_range = page_range.strip()
        if "-" in page_range:
            parts = page_range.split("-", 1)
            try:
                start = int(parts[0])
                end = int(parts[1])
            except ValueError:
                raise HTTPException(status_code=400, detail=f"Invalid page_range: {page_range}")
            if start <= 0 or end <= 0 or start > end:
                raise HTTPException(status_code=400, detail=f"Invalid page_range: {page_range}")
            if (end - start + 1) > settings.MAX_PAGE_RANGE_PAGES:
                raise HTTPException(status_code=400, detail="page_range too large")
            return start, end
        try:
            p = int(page_range)
        except ValueError:
            raise HTTPException(status_code=400, detail=f"Invalid page_range: {page_range}")
        if p <= 0:
            raise HTTPException(status_code=400, detail=f"Invalid page_range: {page_range}")
        return p, p

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
            resp = self._session.post(
                settings.LAYOUT_API_URL,
                json=payload,
                timeout=settings.LAYOUT_API_TIMEOUT_SECONDS,
            )

            if resp.status_code >= 400:
                msg = f"Layout API HTTP {resp.status_code}: {resp.text[:500]}"
                logger.error(f"{msg} (page={page_index})")
                if settings.LAYOUT_API_FAIL_FAST:
                    raise HTTPException(status_code=502, detail=msg)
                return

            try:
                body = resp.json()
            except Exception:
                msg = f"Layout API returned non-JSON response (page={page_index})"
                logger.error(msg)
                if settings.LAYOUT_API_FAIL_FAST:
                    raise HTTPException(status_code=502, detail=msg)
                return

            res_json = (body or {}).get("result") or {}
            results = res_json.get("layoutParsingResults") or []
            if not results:
                msg = f"Layout API returned empty layoutParsingResults (page={page_index})"
                logger.error(msg)
                if settings.LAYOUT_API_FAIL_FAST:
                    raise HTTPException(status_code=502, detail=msg)
                return

            wrote_any = False
            for i, item in enumerate(results):
                page_dir = self.output_dir / f"page_{page_index}_{i}"
                page_dir.mkdir(parents=True, exist_ok=True)
                md = (item or {}).get("markdown") or {}
                md_text = md.get("text")
                if md_text:
                    (page_dir / "doc.md").write_text(md_text, encoding="utf-8")
                    wrote_any = True

            if not wrote_any:
                msg = f"Layout API returned results without markdown.text (page={page_index})"
                logger.error(msg)
                if settings.LAYOUT_API_FAIL_FAST:
                    raise HTTPException(status_code=502, detail=msg)
                return
        except Exception as e:
            logger.error(f"Layout API Error on page {page_index}: {e}", exc_info=True)
            if settings.LAYOUT_API_FAIL_FAST:
                if isinstance(e, HTTPException):
                    raise
                raise HTTPException(status_code=502, detail=f"Layout API Error: {str(e)}")
            # 非 fail-fast: 不阻断整个流程，记录错误即可