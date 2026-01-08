import logging
from pathlib import Path
from fastapi import FastAPI
from fastapi.middleware.cors import CORSMiddleware
from fastapi.responses import HTMLResponse

from app.config import settings
from app.api.router import router as api_router
from app.tasks.manager import task_manager

# 配置日志
logging.basicConfig(
    level=logging.INFO,
    format='%(asctime)s - %(name)s - %(levelname)s - %(message)s'
)

def create_app() -> FastAPI:
    app = FastAPI(
        title=settings.APP_TITLE,
        version=settings.APP_VERSION,
        description="基于OCR与LLM的银行流水智能解析服务"
    )

    # 跨域配置 (根据需要调整)
    app.add_middleware(
        CORSMiddleware,
        allow_origins=["*"],
        allow_credentials=True,
        allow_methods=["*"],
        allow_headers=["*"],
    )

    # 注册路由
    app.include_router(api_router, prefix="/api/v1")

    @app.on_event("startup")
    async def _startup():
        await task_manager.start()

    @app.get("/", include_in_schema=False)
    async def index():
        html_path = Path(__file__).resolve().parent / "web" / "index.html"
        return HTMLResponse(html_path.read_text(encoding="utf-8"))

    @app.get("/health", tags=["Health"])
    async def health_check():
        return {"status": "ok", "version": settings.APP_VERSION}

    return app

app = create_app()

if __name__ == "__main__":
    import uvicorn
    uvicorn.run("app.main:app", host="0.0.0.0", port=8000, reload=True)