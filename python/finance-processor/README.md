## Finance Processor

一个基于 **FastAPI + PDF2Image + Layout API（OCR/版面解析） + OCI Object Storage** 的银行流水 PDF 解析服务。

- **Web 页面**：打开 `/` 上传 PDF，配置参数，显示进度条与结果链接
- **异步接口**：`POST /api/v1/tasks` 提交任务，`GET /api/v1/tasks/{task_id}` 查询进度/结果
- **单并发队列**：同一时间只执行一个任务，其余排队（进程内队列；重启会丢任务状态）

---

### 1) 快速开始（Docker Compose）

1) 准备环境变量文件：

```bash
cp env.example .env
```

2) 准备 OCI 配置（强依赖）

- 默认 `docker-compose.yml` 会挂载 `./oci -> /root/.oci`，所以请把 OCI 配置放到：
  - `oci/config`
  - `oci/oci_api_key.pem`（若使用 API Key）

3) 启动：

```bash
docker compose up --build
```

4) 访问：

- Web UI：`http://localhost:8000/`
- Swagger：`http://localhost:8000/docs`
- Health：`http://localhost:8000/health`

---

### 2) 核心接口

#### 2.1 提交任务（异步）

`POST /api/v1/tasks`（multipart/form-data）

- **file**：PDF 文件
- **page_range**：`all` 或 `1-5` 或 `3`
- **max_image_side**：图片最大边长（默认 1024）
- **output_format**：`bean|camt|both`
- **parser_type**：`cmb`（当前仅支持招商）
- **extra_config**：JSON 数组字符串（默认 `[]`）

返回示例：

```json
{"task_id":"...","status":"queued"}
```

curl 示例：

```bash
curl -s -X POST "http://localhost:8000/api/v1/tasks" \
  -F "file=@/path/to/statement.pdf" \
  -F "page_range=all" \
  -F "max_image_side=1024" \
  -F "output_format=both" \
  -F "parser_type=cmb" \
  -F 'extra_config=[{"regex":"外卖","rowNumber":"4,5","addTag":"#food","addMeta":"source: meituan"}]'
```

#### 2.2 查询任务状态/进度

`GET /api/v1/tasks/{task_id}`

返回字段：

- **status**：`queued|running|success|failed|cancelled`
- **progress**：0-100
- **message**：阶段描述（例如 `ocr_layout_processing`/`parsing`/`uploading_to_oci`）
- **results**：成功时 OSS URL 映射（`filename -> url`）
- **error**：失败信息

---

### 3) 配置说明（环境变量）

#### 3.1 Layout API

- `LAYOUT_API_URL`：Layout API 地址（例如 `http://layout-api:8080/layout-parsing`）
- `LAYOUT_API_TIMEOUT_SECONDS`：单次请求超时
- `LAYOUT_API_RETRIES`：重试次数（对 429/5xx 生效）
- `LAYOUT_API_BACKOFF_SECONDS`：退避系数
- `LAYOUT_API_FAIL_FAST`：任何页失败是否直接失败（建议 `true`）

#### 3.2 OCI Object Storage（强依赖）

- `OCI_BUCKET_NAME`：Bucket 名
- `OCI_REGION`：Region
- `OCI_AUTH_METHOD`：`config_file` 或 `instance_principal`
- `OCI_CONFIG_FILE`：当 `config_file` 时的配置路径（容器内默认 `/root/.oci/config`）
- `OCI_CONFIG_PROFILE`：配置 profile（默认 `DEFAULT`）

#### 3.3 资源限制

- `MAX_UPLOAD_BYTES`：最大上传字节数，超限返回 413
- `MAX_PAGE_RANGE_PAGES`：`page_range` 指定区间的最大页数，超限返回 400

---

### 4) 重要行为说明

- **队列单并发**：同时只能一个任务执行，其余任务排队。
- **进程内状态**：任务状态仅存在内存中，服务重启后 `task_id` 查询会 404。
- **临时目录**：任务完成（成功/失败）后会自动清理 `/tmp/finance_processor/{task_id}`。

---

### 5) 常见问题排查

- **Layout API 超时/返回结构不符合预期**：会返回 502 并在任务 error 中看到原因。
- **OCI 初始化失败**：服务/任务会失败并提示 `OCI init failed`；请检查挂载的 `oci/config`、region、权限。
- **pdf2image 失败**：容器内已安装 `poppler-utils`；若本地运行，请确保系统安装了 poppler。

