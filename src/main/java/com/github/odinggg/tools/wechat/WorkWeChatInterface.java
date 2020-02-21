package com.github.odinggg.tools.wechat;

import com.github.odinggg.tools.model.WorkWeChatMessage;
import com.github.odinggg.tools.model.WorkWeChatResponse;

public interface WorkWeChatInterface {
    WorkWeChatResponse sendMessage(WorkWeChatMessage workWeChatMessage);

    WorkWeChatResponse sendMessage(String text);

    WorkWeChatMessage receiveMessage();
}
