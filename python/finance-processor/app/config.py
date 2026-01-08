import os
from pathlib import Path
from pydantic_settings import BaseSettings

class Settings(BaseSettings):
    # 应用基础配置
    APP_TITLE: str = "Finance PDF Processor"
    APP_VERSION: str = "1.0.0"

    # 路径配置
    TEMP_ROOT: Path = Path("/tmp/finance_processor")

    # 资源限制
    MAX_UPLOAD_BYTES: int = 50 * 1024 * 1024  # 50MB
    MAX_PAGE_RANGE_PAGES: int = 50

    # 外部服务配置
    LAYOUT_API_URL: str = "http://localhost:8080/layout-parsing"
    LAYOUT_API_TIMEOUT_SECONDS: float = 30.0
    LAYOUT_API_RETRIES: int = 2
    LAYOUT_API_BACKOFF_SECONDS: float = 0.5
    # True: 任一页/任一分片失败即中止任务；False: 尽量继续，但最终可能无可用输出
    LAYOUT_API_FAIL_FAST: bool = True

    # Oracle OSS 配置 (支持从环境变量自动加载，也可在此硬编码默认值)
    OCI_BUCKET_NAME: str = "finance-bucket"
    OCI_REGION: str = "us-ashburn-1"
    # OCI 认证方式：
    # - config_file: 读取 ~/.oci/config（Docker 可挂载到 /root/.oci/config）
    # - instance_principal: 适用于 OCI 计算实例（Instance Principal）
    OCI_AUTH_METHOD: str = "config_file"
    OCI_CONFIG_FILE: str = os.path.expanduser("~/.oci/config")
    OCI_CONFIG_PROFILE: str = "DEFAULT"

    # 业务常量
    DEFAULT_CURRENCY: str = "CNY"
    NS_CAMT: str = "urn:iso:std:iso:20022:tech:xsd:camt.053.001.02"

    class Config:
        env_file = ".env"
        case_sensitive = True

def _load_settings() -> "Settings":
    """
    在某些运行环境中（如受限沙箱/只读文件系统），.env 可能存在但不可读；
    这里做降级：读不了就仅使用环境变量与默认值，避免应用启动失败。
    """
    env_path = Path(".env")
    try:
        if env_path.exists() and os.access(str(env_path), os.R_OK):
            return Settings()
    except Exception:
        pass
    return Settings(_env_file=None)


settings = _load_settings()

# 确保临时根目录存在
settings.TEMP_ROOT.mkdir(parents=True, exist_ok=True)