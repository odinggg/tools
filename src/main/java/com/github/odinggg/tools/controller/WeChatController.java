package com.github.odinggg.tools.controller;

import com.github.odinggg.tools.Configuration;
import com.github.odinggg.tools.enums.HttpParamEnum;
import com.github.odinggg.tools.util.wechat.WXBizMsgCrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class WeChatController extends BaseController {
    private Logger logger = LoggerFactory.getLogger(WeChatController.class);
    @Autowired
    private Configuration configuration;

    @RequestMapping(value = "/cgi-bin/wxpush")
    public String wxPush(@RequestParam(value = "msg_signature") String msgSignature, @RequestParam(value = "timestamp") String timestamp, @RequestParam(value = "nonce") String nonce, @RequestParam(value = "echostr") String echostr, HttpServletResponse response) {

        try {
            Configuration.Param param = configuration.getHttpParam().get(HttpParamEnum.WORK_WECHAT_SAFE);
            WXBizMsgCrypt wxcpt = new WXBizMsgCrypt(param.getAccessKey(), param.getSecret(), param.getPassword());
            String sEchoStr = wxcpt.VerifyURL(msgSignature, timestamp, nonce, echostr);
            logger.info("verifyurl echostr: " + sEchoStr);
            return sEchoStr;
        } catch (Exception e) {
            logger.error("微信校验异常：", e);
        }
        return null;
    }

    @PostMapping(value = "/receiveWechatMessage", consumes = {
            MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE
    }, produces = {
            MediaType.APPLICATION_ATOM_XML_VALUE
    })
    public void receiveWechatMessage(@RequestParam(value = "msg_signature") String msgSignature, @RequestParam(value = "timestamp") String timestamp, @RequestParam(value = "nonce") String nonce, HttpServletRequest request, HttpServletResponse response) {
        try {
            String sReqData = readRequest(request);
            Configuration.Param param = configuration.getHttpParam().get(HttpParamEnum.WORK_WECHAT_SAFE);
            WXBizMsgCrypt wxcpt = new WXBizMsgCrypt(param.getAccessKey(), param.getSecret(), param.getPassword());
            String sMsg = wxcpt.DecryptMsg(msgSignature, timestamp, nonce, sReqData);
            logger.info("微信消息: " + sMsg);
        } catch (Exception e) {
            logger.error("微信校验异常：", e);
        }
    }
}
