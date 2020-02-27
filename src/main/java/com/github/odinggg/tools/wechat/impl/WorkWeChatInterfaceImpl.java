package com.github.odinggg.tools.wechat.impl;

import com.github.odinggg.tools.Configuration;
import com.github.odinggg.tools.controller.WeChatController;
import com.github.odinggg.tools.enums.HttpParamEnum;
import com.github.odinggg.tools.model.WeChatModel;
import com.github.odinggg.tools.model.WorkWeChatMessage;
import com.github.odinggg.tools.model.WorkWeChatMessageFormatModel;
import com.github.odinggg.tools.model.WorkWeChatResponse;
import com.github.odinggg.tools.util.HttpClientUtil;
import com.github.odinggg.tools.util.JacksonConvertUtil;
import com.github.odinggg.tools.wechat.WeChatInterface;
import com.github.odinggg.tools.wechat.WorkWeChatInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;

@Service
public class WorkWeChatInterfaceImpl implements WorkWeChatInterface {
    @Autowired
    private Configuration configuration;
    @Autowired
    private WeChatInterface weChatInterface;

    @Override
    public WorkWeChatResponse sendMessage(WorkWeChatMessage workWeChatMessage) {
        Configuration.Param param = configuration.getHttpParam().get(HttpParamEnum.WORK_WECHAT_TOKEN);
        HashMap<String, String> params = new HashMap<>();
        params.put("corpid", param.getAccessKey());
        params.put("corpsecret", param.getSecret());
        String response = HttpClientUtil.get(param.getUrl(), params, null);
        WorkWeChatResponse workWeChatResponse = JacksonConvertUtil.jsonToObject(response, WorkWeChatResponse.class);
        if (workWeChatResponse == null || StringUtils.isEmpty(workWeChatResponse.getAccessToken())) {
            return null;
        }
        Configuration.Param sendParam = configuration.getHttpParam().get(HttpParamEnum.WORK_WECHAT_SEND);
        if (StringUtils.isEmpty(workWeChatMessage.getAgentid())) {
            workWeChatMessage.setAgentid(Integer.parseInt(sendParam.getPassword()));
        }
        if (StringUtils.isEmpty(workWeChatMessage.getTouser())) {
            workWeChatMessage.setTouser(sendParam.getUsername());
        }
        if (StringUtils.isEmpty(workWeChatMessage.getMsgtype())) {
            workWeChatMessage.setMsgtype("text");
        }
        params.clear();
        params.put("access_token", workWeChatResponse.getAccessToken());
        String send = HttpClientUtil.sendAndFormatResponse(sendParam.getUrl(), RequestMethod.POST, workWeChatMessage, params, null, true);
        return JacksonConvertUtil.jsonToObject(send, WorkWeChatResponse.class);
    }

    @Override
    public WorkWeChatResponse sendMessage(String text) {
        WorkWeChatMessage workWeChatMessage = new WorkWeChatMessage();
        WorkWeChatMessage.TextBean textBean = new WorkWeChatMessage.TextBean();
        textBean.setContent(text);
        workWeChatMessage.setText(textBean);
        return sendMessage(workWeChatMessage);
    }

    @Override
    public WorkWeChatMessage receiveMessage() {
        return null;
    }

    @Override
    public void toWeChat(String content) {
        WorkWeChatMessageFormatModel formatModel = parseMessage(content);
        if (formatModel == null) {
            return;
        }
        WeChatModel model = WeChatController.MAP.get(formatModel.getUuid());
        if (model == null) {
            return;
        }
        weChatInterface.sendMessage(model, formatModel);
    }

    @Override
    public WorkWeChatMessageFormatModel parseMessage(String content) {
        if (StringUtils.isEmpty(content) || !content.startsWith("@")) {
            return null;
        }
        WorkWeChatMessageFormatModel model = new WorkWeChatMessageFormatModel();
        int i = content.indexOf("@@@");
        model.setContent(content.substring(i + 3));
        String[] split = content.substring(0, i).split(",");
        model.setUuid(split[0]);
        model.setWeChatName(split[1]);
        return model;
    }
}
