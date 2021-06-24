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
