package com.github.odinggg.tools.controller;

import com.github.odinggg.tools.Configuration;
import com.github.odinggg.tools.enums.HttpParamEnum;
import com.github.odinggg.tools.model.APIEntity;
import com.github.odinggg.tools.model.WeChatModel;
import com.github.odinggg.tools.model.WorkWeChatMessageXML;
import com.github.odinggg.tools.util.JacksonConvertUtil;
import com.github.odinggg.tools.util.wechat.WXBizMsgCrypt;
import com.github.odinggg.tools.wechat.WeChatInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.nio.ByteBuffer;
import java.util.Base64;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@CrossOrigin
public class WeChatController extends BaseController {
    private Logger logger = LoggerFactory.getLogger(WeChatController.class);
    @Autowired
    private Configuration configuration;
    @Autowired
    private WeChatInterface weChatInterface;

    public static final ConcurrentHashMap<String, WeChatModel> MAP = new ConcurrentHashMap<>();

    /**
     * wechat check
     *
     * @param msgSignature
     * @param timestamp
     * @param nonce
     * @param echostr
     * @return
     */
    @GetMapping(value = "/receiveWechatMessage")
    public String wxPush(@RequestParam(value = "msg_signature") String msgSignature, @RequestParam(value = "timestamp") String timestamp, @RequestParam(value = "nonce") String nonce, @RequestParam(value = "echostr") String echostr) {

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

    /**
     * wechat receive message
     *
     * @param msgSignature
     * @param timestamp
     * @param nonce
     * @param echostr
     * @param request
     * @return
     */
    @PostMapping(value = "/receiveWechatMessage")
    public String receiveWechatMessage(@RequestParam(value = "msg_signature", required = false) String msgSignature, @RequestParam(value = "timestamp", required = false) String timestamp, @RequestParam(value = "nonce", required = false) String nonce, @RequestParam(value = "echostr", required = false) String echostr, HttpServletRequest request) {
        try {
            String sReqData = readRequest(request);
            Configuration.Param param = configuration.getHttpParam().get(HttpParamEnum.WORK_WECHAT_SAFE);
            WXBizMsgCrypt wxcpt = new WXBizMsgCrypt(param.getAccessKey(), param.getSecret(), param.getPassword());
            String sMsg = wxcpt.DecryptMsg(msgSignature, timestamp, nonce, sReqData);
            logger.info("微信消息: " + sMsg);
            WorkWeChatMessageXML workWeChatMessageXML = JacksonConvertUtil.xmlToObject(sMsg, WorkWeChatMessageXML.class);
            WorkWeChatMessageXML responseXml = new WorkWeChatMessageXML();
            responseXml.setToUserName(workWeChatMessageXML.getFromUserName());
            responseXml.setFromUserName(workWeChatMessageXML.getToUserName());
            responseXml.setCreateTime(String.valueOf(System.currentTimeMillis() / 1000));
            responseXml.setMsgType("text");
            responseXml.setContent(workWeChatMessageXML.getContent());
            return wxcpt.EncryptMsg(JacksonConvertUtil.objectToXml(responseXml), timestamp, nonce);
        } catch (Exception e) {
            logger.error("微信校验异常：", e);
        }
        return "";
    }

    @GetMapping("/wxQrcode")
    public Object getQrcode() {
        try {
            String uuid = weChatInterface.getUuid();
            if (StringUtils.isEmpty(uuid)) {
                return new APIEntity<>(200, "get qrcode uuid false");
            }
            ByteBuffer qrcode = weChatInterface.getQrcode(uuid);
            if (qrcode == null) {
                return new APIEntity<>(200, "get qrcode image false");
            }
            return new APIEntity<>(200, "success", new WeChatModel.SecurityBean(uuid, Base64.getEncoder()
                    .encodeToString(qrcode.array())));
        } catch (Exception e) {
            logger.error("微信获取二维码异常：", e);
            return new APIEntity<>(109, "system error");
        }
    }

    @GetMapping("/checkLogin/{uuid}")
    public Object checkLogin(@PathVariable String uuid) {
        try {
            String s = weChatInterface.checkLogin(uuid);
            return new APIEntity<>(200,"success",s);
        } catch (Exception e) {
            logger.error("微信获取二维码异常：", e);
            return new APIEntity<>(109, "system error");
        }
    }
}
