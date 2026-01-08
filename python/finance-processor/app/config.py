import os
from pathlib import Path
from pydantic_settings import BaseSettings

class Settings(BaseSettings):
    # 应用基础配置
    APP_TITLE: str = "Finance PDF Processor"
    APP_VERSION: str = "1.0.0"

    # 路径配置
    TEMP_ROOT: Path = Path("/tmp/finance_processor")

    # 外部服务配置
    LAYOUT_API_URL: str = "http://localhost:8080/layout-parsing"

    # Oracle OSS 配置 (支持从环境变量自动加载，也可在此硬编码默认值)
    OCI_BUCKET_NAME: str = "finance-bucket"
    OCI_REGION: str = "us-ashburn-1"

    # 业务常量
    DEFAULT_CURRENCY: str = "CNY"
    NS_CAMT: str = "urn:iso:std:iso:20022:tech:xsd:camt.053.001.02"

    class Config:
        env_file = ".env"
        case_sensitive = True

settings = Settings()

# 确保临时根目录存在
settings.TEMP_ROOT.mkdir(parents=True, exist_ok=True)