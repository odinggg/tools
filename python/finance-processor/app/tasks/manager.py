import asyncio
import logging
import shutil
from dataclasses import dataclass
from datetime import datetime
from pathlib import Path
from typing import Any, Callable, Dict, Optional, Tuple

from app.schemas.models import TaskStatus
from app.services.pipeline import run_pipeline

logger = logging.getLogger(__name__)


@dataclass
class _TaskState:
    task_id: str
    status: TaskStatus
    progress: int
    message: str
    results: Optional[Dict[str, str]] = None
    error: Optional[Any] = None
    created_at: datetime = datetime.utcnow()
    updated_at: datetime = datetime.utcnow()


class TaskManager:
    """
    进程内任务队列：单 worker 串行执行（同一时间只能一个任务 running）。
    不做持久化：进程重启任务状态会丢失。
    """

    def __init__(self) -> None:
        self._queue: "asyncio.Queue[Tuple[str, Dict[str, Any]]]" = asyncio.Queue()
        self._states: Dict[str, _TaskState] = {}
        self._lock = asyncio.Lock()
        self._worker_task: Optional[asyncio.Task] = None

    async def start(self) -> None:
        if self._worker_task and not self._worker_task.done():
            return
        self._worker_task = asyncio.create_task(self._worker_loop(), name="finance_processor_task_worker")
        logger.info("Task worker started (single concurrency).")

    async def create_task(self, task_id: str) -> None:
        async with self._lock:
            self._states[task_id] = _TaskState(
                task_id=task_id,
                status=TaskStatus.QUEUED,
                progress=0,
                message="queued",
            )

    async def enqueue(self, task_id: str, payload: Dict[str, Any]) -> None:
        await self._queue.put((task_id, payload))

    async def get_state(self, task_id: str) -> Optional[_TaskState]:
        async with self._lock:
            return self._states.get(task_id)

    async def list_states(self) -> Dict[str, _TaskState]:
        async with self._lock:
            return dict(self._states)

    async def _update(
        self,
        task_id: str,
        *,
        status: Optional[TaskStatus] = None,
        progress: Optional[int] = None,
        message: Optional[str] = None,
        results: Optional[Dict[str, str]] = None,
        error: Optional[Any] = None,
    ) -> None:
        async with self._lock:
            st = self._states.get(task_id)
            if not st:
                return
            if status is not None:
                st.status = status
            if progress is not None:
                st.progress = max(0, min(100, int(progress)))
            if message is not None:
                st.message = message
            if results is not None:
                st.results = results
            if error is not None:
                st.error = error
            st.updated_at = datetime.utcnow()

    async def _worker_loop(self) -> None:
        while True:
            task_id, payload = await self._queue.get()
            work_dir: Optional[Path] = None
            try:
                await self._update(task_id, status=TaskStatus.RUNNING, progress=1, message="running")

                loop = asyncio.get_running_loop()

                def progress_cb(p: int, msg: str) -> None:
                    # pipeline 在 to_thread 中运行，回调会从非事件循环线程触发
                    # 这里用 call_soon_threadsafe 安全地把更新调度回主事件循环
                    loop.call_soon_threadsafe(
                        asyncio.create_task,
                        self._update(task_id, progress=p, message=msg),
                    )

                try:
                    work_dir = Path(str(payload.get("pdf_path", ""))).parent
                except Exception:
                    work_dir = None

                results = await run_pipeline(task_id=task_id, payload=payload, progress_cb=progress_cb)
                await self._update(
                    task_id,
                    status=TaskStatus.SUCCESS,
                    progress=100,
                    message="success",
                    results=results,
                    error=None,
                )
            except Exception as e:
                logger.error(f"Task {task_id} failed: {e}", exc_info=True)
                await self._update(
                    task_id,
                    status=TaskStatus.FAILED,
                    progress=100,
                    message="failed",
                    error=str(e),
                )
            finally:
                # 清理临时目录，避免 /tmp 堆积（不要求持久化）
                if work_dir and work_dir.exists():
                    try:
                        shutil.rmtree(work_dir)
                        logger.info(f"Cleaned up temp dir: {work_dir}")
                    except Exception as e:
                        logger.warning(f"Cleanup failed for {work_dir}: {e}")
                self._queue.task_done()


task_manager = TaskManager()

