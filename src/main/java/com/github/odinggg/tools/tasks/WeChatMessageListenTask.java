package com.github.odinggg.tools.tasks;

import com.fasterxml.jackson.core.type.TypeReference;
import com.github.odinggg.tools.constant.WeChatConstant;
import com.github.odinggg.tools.controller.WeChatController;
import com.github.odinggg.tools.enums.WeChatMessageTypeEnum;
import com.github.odinggg.tools.model.WeChatMessageModel;
import com.github.odinggg.tools.model.WeChatModel;
import com.github.odinggg.tools.util.HttpClientUtil;
import com.github.odinggg.tools.util.JacksonConvertUtil;
import com.github.odinggg.tools.wechat.WeChatInterface;
import com.github.odinggg.tools.wechat.WorkWeChatInterface;
import org.apache.http.impl.client.BasicCookieStore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.StringReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * 描述:
 *
 * @author Hansen
 * @version 2020-02-25 16:37
 */
@Component("weChatMessageListenTask")
@Scope("prototype")
public class WeChatMessageListenTask implements Runnable {
    private final Logger logger = LoggerFactory.getLogger(WeChatMessageListenTask.class);
    @Autowired
    private WeChatInterface weChatInterface;
    @Autowired
    private WorkWeChatInterface workWeChatInterface;

    private WeChatModel weChatModel;

    private BasicCookieStore basicCookieStore;

    @Override
    public void run() {
        try {
            Properties properties = new Properties();
            while (true) {
                properties.clear();
                WeChatModel.SecurityBean securityBean = weChatModel.getSecurityBean();
                HashMap<String, String> params = new HashMap<>();
                params.put("sid", securityBean.getWxsid());
                params.put("uin", securityBean.getWxuin());
                params.put("skey", securityBean.getSkey());
                params.put("deviceid", weChatModel.getDeviceId());
                params.put("synckey", weChatModel.getSyncKey().toString());
                String response = HttpClientUtil.sendAndFormatResponse(basicCookieStore, 30000, 30000, WeChatConstant.login_prefix + WeChatConstant.sync, RequestMethod.POST, null, params, null, false, null);
                if (StringUtils.isEmpty(response) || !response.contains("synccheck")) {
                    logger.error("同步接口请求异常");
                    break;
                }
                properties.load(new StringReader(response));
                String property = properties.getProperty("window.synccheck");
                if (StringUtils.isEmpty(property)) {
                    logger.error("同步接口返回异常");
                }
                Map<String, Object> stringObjectMap = JacksonConvertUtil.jsonToObject(property, new TypeReference<Map<String, Object>>() {
                });
                String retcode = String.valueOf(stringObjectMap.get("retcode"));
                if (Integer.parseInt(retcode) != 0) {
                    break;
                }
                String selector = String.valueOf(stringObjectMap.get("selector"));
                if (Integer.parseInt(selector) > 0) {
                    // 有新消息获取信息内容
                    WeChatMessageModel weChatMessageModel = weChatInterface.getMessage(weChatModel, basicCookieStore);
                    if (weChatMessageModel.getAddMsgCount() > 0 && !CollectionUtils.isEmpty(weChatMessageModel.getAddMsgList())) {
                        List<WeChatMessageModel.AddMsgListBean> addMsgList = weChatMessageModel.getAddMsgList();
                        addMsgList.forEach(addMsgListBean -> {
                            switch (WeChatMessageTypeEnum.parse(addMsgListBean.getMsgType())) {
                                case TEXT:
                                case IMAGE:
                                    addMsgListBean.setContent("图片消息");
                                    break;
                                case VOICE:
                                    addMsgListBean.setContent("语音消息");
                                    break;
                                case VIDEO:
                                    addMsgListBean.setContent("视频消息");
                                    break;
                                case MICRO_VIDEO:
                                    addMsgListBean.setContent("短视频消息");
                                    break;
                                case EMOTI_CON:
                                    addMsgListBean.setContent("表情消息");
                                    break;
                                case MEDIA:
                                    addMsgListBean.setContent("多媒体消息");
                                    break;
                                default:
                                    break;
                            }
                            // 转发企业微信
                            String message = weChatInterface.formatMessage(addMsgListBean, weChatModel);
                            workWeChatInterface.sendMessage(message);
                        });

                    }
                    // 更新内存同步数据
                    WeChatModel.SyncKeyBean syncCheckKey = weChatMessageModel.getSyncCheckKey();
                    weChatModel.setSyncKey(syncCheckKey);
                }
            }
            WeChatController.MAP.remove(weChatModel.getSecurityBean().getUuid());
        } catch (Throwable e) {
            logger.error("同步消息异常：", e);
        }
    }


    public WeChatModel getWeChatModel() {
        return weChatModel;
    }

    public WeChatMessageListenTask setWeChatModel(WeChatModel weChatModel) {
        this.weChatModel = weChatModel;
        return this;
    }

    public BasicCookieStore getBasicCookieStore() {
        return basicCookieStore;
    }

    public WeChatMessageListenTask setBasicCookieStore(BasicCookieStore basicCookieStore) {
        this.basicCookieStore = basicCookieStore;
        return this;
    }
}
