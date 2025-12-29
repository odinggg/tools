# tools --个人使用小工具，长期更新，随用随更
---
1. twitter批量加关注
2. bilibili视频按up/视频集合/视频id下载，下载器采用aria2
3. yml转properties
4. properties转yml（未完成）
5. work wechat 接收发送消息
6. wechat web端接收发送消息
7. 微信公众号文章转换pdf
8. powershell 模拟鼠标自动点击
9. powershell 指定软件窗口截图
10. opencv检测圆形
11. 三门问题的python实现
- 未完待续...
---
### 五、微信消息转发企业微信
#### 目的
    通过企业微信应用消息中转实现ios端登陆多微信端
#### 实现过程
    首先注册企业微信，并在企业微信中创建个人应用，通过个人应用的api与web微信的api互通实现消息互通。
#### 前端接口
    path: /wxQrcode 获取二维码图片，web端微信登陆
    method: GET
    params: null
    response: json
    responseBody: 
```json
{
  "status": 200,
  "message": "success",
  "data": {
    "uuid": "登陆接口主键",
    "qrcode": "img base64编码字符串"
  }
}
```
    path: /checkLogin/{uuid} 启动登陆
    method: GET
    params: null
    response: json
    responseBody: 
```json
{
  "status": 200,
  "message": "success",
  "data": null
}
```
#### 配置说明
```yaml
config:
  http-param:
    # 企业微信发送消息获取token相关配置
    work-wechat-token:
      url: https://qyapi.weixin.qq.com/cgi-bin/gettoken
      secret: xxxxxxxx
      accessKey: xxxxx
      method: get
    # 企业微信发送消息相关配置
    work-wechat-send:
      url: https://qyapi.weixin.qq.com/cgi-bin/message/send
      username: xxx
      password: xxx
      method: post
    # 企业微信接收消息相关配置
    work-wechat-safe:
      url:
      password: xxx
      method: post
      secret: xxx
      accessKey: xxx
```
---
### Python 脚本
#### 订单状态监控脚本
一个用来监控 `haokaapi` 订单状态的SB脚本，状态变了就用 Bark 推给你。居然还知道用 Gemini 来自动识别登录验证码，省了手动操作，还算有点脑子。

- **路径:** `python/monitor/`
- **主要功能:**
    - 定时自动登录并获取最新的订单列表。
    - 监控订单状态变更，并在发生变化时通过 Bark APP 发送实时推送通知。
    - 使用 Google Gemini API 自动识别和填写图片验证码，实现无人值守登录。
- **食用方法:**
    1.  先把你那堆破烂依赖装上: `pip install -r python/monitor/requirements.txt`
    2.  把 `python/monitor/config.ini` 文件里的 `username`, `password`, `gemini_api_key`, `bark_key` 这些狗屁玩意改成你自己的。别他妈忘了！
    3.  直接运行: `python python/monitor/order_monitor.py`

#### 文件整理脚本
你那下载文件夹是不是乱得跟狗窝一样？这个脚本就是给你这种懒狗用的，能把你指定文件夹里的文件按类型（图片、视频、文档等）自动分类，省得你自个儿整理。

- **路径:** `python/file_organizer/`
- **主要功能:**
    - 扫描你指定的文件夹。
    - 根据文件扩展名，把文件移动到 `Images`, `Videos`, `Documents` 等分类文件夹里。
    - 分类规则和文件夹路径都能在配置文件里自己改，够灵活了吧。
- **食用方法:**
    1.  进入 `python/file_organizer` 目录。
    2.  把 `config.ini.template` 复制一份，重命名成 `config.ini`。
    3.  打开 `config.ini`，把 `source_directory`改成你丫要整理的文件夹路径，比如 `/Users/你的憨批用户名/Downloads`。
    4.  直接运行: `python python/file_organizer/organizer.py`
    5.  你动过的文件，日志都在 `file_organizer_log.txt` 里，自己看。

### 2. 重复文件查找器 (Duplicate File Finder)

这脚本能扫描你指定的目录，找出里面所有内容重复的文件。省得你电脑里一堆垃圾自己还不知道。

**使用方法:**

```shell
# 给我把 <要扫描的目录> 换成你自己的目录路径，别tm直接复制粘贴！
python python/duplicate_file_finder/find_duplicates.py <要扫描的目录>
```

### 3. Katabump 自动续费脚本 (renew.py)

专门用来给 Katabump 服务器续命的脚本。能自动登录、过 Cloudflare 验证码（Turnstile）、点击 Renew 按钮。老王我写这个就是为了不手动点那该死的按钮。

- **路径:** `python/renew/`
- **主要功能:**
    - 自动打开浏览器登录 Dashboard。
    - **强力过盾**: 针对 Cloudflare Turnstile 验证码进行了深度优化，支持 Shadow DOM 穿透点击。
    - 自动寻找指定服务器并续费。
    - 支持后台运行和定时任务。
- **食用方法:**
    1.  安装依赖: `pip install DrissionPage psutil`
    2.  修改 `python/renew/renew.py` 中的 `USERNAME`, `PASSWORD`, `SERVER_ID`。
    3.  运行: `python python/renew/renew.py`
