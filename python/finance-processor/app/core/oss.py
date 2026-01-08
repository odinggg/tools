import os
import logging
from pathlib import Path
import oci
from fastapi import HTTPException
from app.config import settings

logger = logging.getLogger(__name__)

class OracleOSSClient:
    def __init__(self):
        try:
            # 尝试加载默认配置 (~/.oci/config) 或 Instance Principal
            # 生产环境建议使用 Instance Principal 以避免本地文件依赖
            self.config = oci.config.from_file()
            self.object_storage = oci.object_storage.ObjectStorageClient(self.config)
            self.namespace = self.object_storage.get_namespace().data
            self.bucket_name = settings.OCI_BUCKET_NAME
            self.is_ready = True
        except Exception as e:
            logger.warning(f"OCI Config load failed: {e}. Uploads will fail gracefully.")
            self.object_storage = None
            self.is_ready = False
            self.namespace = "mock_namespace"

    def upload_file(self, file_path: Path, object_name: str) -> str:
        """上传文件并返回访问 URL"""
        if not self.is_ready or not self.object_storage:
            logger.info(f"Mock Upload: {object_name}")
            return f"mock_url_oci_not_configured/{object_name}"

        try:
            with open(file_path, "rb") as f:
                self.object_storage.put_object(
                    self.namespace,
                    self.bucket_name,
                    object_name,
                    f
                )
            # 构造标准 OCI 对象 URL
            # 注意：若 Bucket 为 Private，这里可能需要生成 PAR (Pre-Authenticated Request) URL
            region = self.config.get("region", settings.OCI_REGION)
            return f"https://objectstorage.{region}.oraclecloud.com/n/{self.namespace}/b/{self.bucket_name}/o/{object_name}"
        except Exception as e:
            logger.error(f"OSS Upload failed: {e}")
            raise HTTPException(status_code=500, detail=f"OSS Upload failed: {str(e)}")