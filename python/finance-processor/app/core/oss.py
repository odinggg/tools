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
            self.bucket_name = settings.OCI_BUCKET_NAME

            if settings.OCI_AUTH_METHOD == "instance_principal":
                signer = oci.auth.signers.InstancePrincipalsSecurityTokenSigner()
                self.config = {"region": settings.OCI_REGION}
                self.object_storage = oci.object_storage.ObjectStorageClient(self.config, signer=signer)
            else:
                # 默认：config_file（Docker 可将 ~/.oci 挂载到 /root/.oci）
                self.config = oci.config.from_file(
                    file_location=settings.OCI_CONFIG_FILE,
                    profile_name=settings.OCI_CONFIG_PROFILE,
                )
                self.object_storage = oci.object_storage.ObjectStorageClient(self.config)

            self.namespace = self.object_storage.get_namespace().data
        except Exception as e:
            # OCI 上传是强依赖：初始化失败应直接失败
            logger.error(f"OCI init failed: {e}", exc_info=True)
            raise RuntimeError(f"OCI init failed: {e}")

    def upload_file(self, file_path: Path, object_name: str) -> str:
        """上传文件并返回访问 URL"""
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
            region = (self.config or {}).get("region", settings.OCI_REGION)
            return f"https://objectstorage.{region}.oraclecloud.com/n/{self.namespace}/b/{self.bucket_name}/o/{object_name}"
        except Exception as e:
            logger.error(f"OSS Upload failed: {e}")
            raise HTTPException(status_code=500, detail=f"OSS Upload failed: {str(e)}")