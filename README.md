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
