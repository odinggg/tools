package com.github.odinggg.tools.wechat.impl;

import com.github.odinggg.tools.Configuration;
import com.github.odinggg.tools.enums.HttpParamEnum;
import com.github.odinggg.tools.model.WorkWeChatMessage;
import com.github.odinggg.tools.model.WorkWeChatResponse;
import com.github.odinggg.tools.util.HttpClientUtil;
import com.github.odinggg.tools.util.JacksonConvertUtil;
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
        String send = HttpClientUtil.send(sendParam.getUrl(), RequestMethod.POST, workWeChatMessage, params, null, true);
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
}
