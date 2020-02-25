package com.github.odinggg.tools.wechat;

import com.github.odinggg.tools.model.WeChatModel;
import org.apache.http.client.CookieStore;


import java.nio.ByteBuffer;

public interface WeChatInterface {
    String getUuid();

    ByteBuffer getQrcode(String uuid);

    String checkLogin(String uuid);

    WeChatModel loginInit(WeChatModel.SecurityBean securityBean, CookieStore cookieStore);

    WeChatModel memberInit(WeChatModel weChatModel);
}
