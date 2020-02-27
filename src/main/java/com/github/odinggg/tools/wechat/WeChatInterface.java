package com.github.odinggg.tools.wechat;

import com.github.odinggg.tools.model.WeChatMessageModel;
import com.github.odinggg.tools.model.WeChatModel;
import com.github.odinggg.tools.model.WorkWeChatMessageFormatModel;
import org.apache.http.client.CookieStore;
import org.apache.http.impl.client.BasicCookieStore;

import java.nio.ByteBuffer;

public interface WeChatInterface {
    String getUuid();

    ByteBuffer getQrcode(String uuid);

    String checkLogin(String uuid);

    WeChatModel loginInit(WeChatModel.SecurityBean securityBean, CookieStore cookieStore);

    WeChatModel memberInit(WeChatModel weChatModel);

    WeChatMessageModel getMessage(WeChatModel weChatModel, BasicCookieStore basicCookieStore);

    String formatMessage(WeChatMessageModel.AddMsgListBean weChatMessageModel, WeChatModel weChatModel);

    boolean sendMessage(WeChatModel model, WorkWeChatMessageFormatModel formatModel);
}
