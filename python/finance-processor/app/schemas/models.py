from enum import Enum
from typing import List, Optional, Dict
from pydantic import BaseModel

class OutputFormat(str, Enum):
    BEAN = "bean"
    CAMT = "camt"
    BOTH = "both"

class ParserType(str, Enum):
    CMB = "cmb" # 招商银行

class RegexRule(BaseModel):
    """正则匹配规则模型"""
    regex: str
    rowNumber: str  # 实际代表列索引字符串，如 "3,4"
    addTag: Optional[str] = None
    addMeta: Optional[str] = None

class ProcessResponse(BaseModel):
    """API 响应模型"""
    status: str
    task_id: str
    results: Dict[str, str]  # filename -> url