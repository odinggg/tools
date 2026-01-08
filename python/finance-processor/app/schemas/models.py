from enum import Enum
from typing import Optional, Dict, Any
import re
from pydantic import BaseModel, field_validator

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

    @field_validator("regex")
    @classmethod
    def _validate_regex(cls, v: str) -> str:
        v = (v or "").strip()
        if not v:
            raise ValueError("regex must not be empty")
        try:
            re.compile(v)
        except re.error as e:
            raise ValueError(f"invalid regex: {e}")
        return v

    @field_validator("rowNumber")
    @classmethod
    def _validate_row_number(cls, v: str) -> str:
        v = (v or "").strip()
        if not v:
            raise ValueError("rowNumber must not be empty")
        parts = [p.strip() for p in v.split(",") if p.strip()]
        if not parts:
            raise ValueError("rowNumber must contain at least one column index")
        for p in parts:
            if not p.isdigit():
                raise ValueError("rowNumber must be comma-separated integers")
        return ",".join(parts)

class ProcessResponse(BaseModel):
    """API 响应模型"""
    status: str
    task_id: str
    results: Dict[str, str]  # filename -> url


class TaskStatus(str, Enum):
    QUEUED = "queued"
    RUNNING = "running"
    SUCCESS = "success"
    FAILED = "failed"
    CANCELLED = "cancelled"


class TaskSubmitResponse(BaseModel):
    task_id: str
    status: TaskStatus


class TaskStatusResponse(BaseModel):
    task_id: str
    status: TaskStatus
    progress: int  # 0-100
    message: str
    results: Optional[Dict[str, str]] = None
    error: Optional[Any] = None