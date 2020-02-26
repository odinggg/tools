package com.github.odinggg.tools.wechat.impl;

import com.github.odinggg.tools.constant.WeChatConstant;
import com.github.odinggg.tools.controller.WeChatController;
import com.github.odinggg.tools.model.WeChatInitRequest;
import com.github.odinggg.tools.model.WeChatMember;
import com.github.odinggg.tools.model.WeChatMessageModel;
import com.github.odinggg.tools.model.WeChatMessageRequest;
import com.github.odinggg.tools.model.WeChatModel;
import com.github.odinggg.tools.model.WorkWeChatMessageFormatModel;
import com.github.odinggg.tools.tasks.WeChatMessageListenTask;
import com.github.odinggg.tools.util.HttpClientUtil;
import com.github.odinggg.tools.util.JacksonConvertUtil;
import com.github.odinggg.tools.util.SpringBeansUtil;
import com.github.odinggg.tools.wechat.WeChatInterface;
import org.apache.http.HttpEntity;
import org.apache.http.client.CookieStore;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.aspectj.util.FileUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.InputStream;
import java.io.StringReader;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 描述:
 *
 * @author Hansen
 * @version 2020-02-25 12:44
 */
@Service
public class WeChatInterfaceImpl implements WeChatInterface {
    private final Logger logger = LoggerFactory.getLogger(WeChatInterfaceImpl.class);

    private ExecutorService executorService = Executors.newFixedThreadPool(4);

    @Override
    public String getUuid() {
        try {
            HashMap<String, String> map = new HashMap<>();
            map.put("appid", "wx782c26e4c19acffb");
            map.put("fun", "new");
            map.put("land", "zh_CN");
            String responseString = HttpClientUtil.get(WeChatConstant.login_prefix + WeChatConstant.uuidUrl, map);
            if (responseString.contains("uuid")) {
                int uuidIndex = responseString.indexOf("uuid");
                String substring = responseString.substring(uuidIndex);
                return substring.substring(substring.indexOf("\"") + 1, substring.lastIndexOf("\""));
            }
        } catch (Exception e) {
            logger.error("获取uuid异常：", e);
        }
        return null;
    }

    @Override
    public ByteBuffer getQrcode(String uuid) {
        try {
            HashMap<String, String> map = new HashMap<>();
            map.put("t", "webwx");
            HttpEntity entity = HttpClientUtil.getEntity(WeChatConstant.login_prefix + WeChatConstant.qrcode + uuid, map);
            if (entity != null && MediaType.IMAGE_JPEG_VALUE.equals(entity.getContentType().getValue())) {
                InputStream content = entity.getContent();
                byte[] bytes = FileUtil.readAsByteArray(content);
                return ByteBuffer.wrap(bytes);
            }
        } catch (Exception e) {
            logger.error("获取二维码异常：", e);
        }
        return null;
    }

    @Override
    public String checkLogin(String uuid) {
        try {
            HashMap<String, String> map = new HashMap<>();
            map.put("tip", "1");
            map.put("uuid", uuid);
            String s = HttpClientUtil.get(1800000, 1800000, WeChatConstant.login_prefix + WeChatConstant.check_login, map);
            if (s.contains("code")) {
                Properties properties = new Properties();
                properties.load(new StringReader(s));
                String code = properties.getProperty("window.code");
                if (!StringUtils.isEmpty(code) && code.startsWith("200")) {
                    // 进入登录逻辑
                    BasicCookieStore basicCookieStore = new BasicCookieStore();
                    String uri = properties.getProperty("window.redirect_uri").replaceAll("\"", "").replaceAll(";", "");
                    String loginResponse = HttpClientUtil.get(basicCookieStore, uri + "&fun=new&version=v2");
                    if (loginResponse.startsWith("<error")) {
                        WeChatModel.SecurityBean securityBean = JacksonConvertUtil.xmlToObject(loginResponse, WeChatModel.SecurityBean.class);
                        List<Cookie> cookies = basicCookieStore.getCookies();
                        if (!CollectionUtils.isEmpty(cookies)) {
                            cookies.stream()
                                    .filter(cookie -> cookie.getName().equalsIgnoreCase("webwx_data_ticket"))
                                    .findAny()
                                    .ifPresent(cookie -> securityBean.setWebwxAuthTicket(cookie.getValue()));
                            cookies.stream()
                                    .filter(cookie -> cookie.getName().equalsIgnoreCase("webwx_auth_ticket"))
                                    .findAny()
                                    .ifPresent(cookie -> securityBean.setWebwxAuthTicket(cookie.getValue()));
                        }
                        WeChatModel weChatModel = loginInit(securityBean, basicCookieStore);
                        if (weChatModel == null) {
                            return "";
                        }
                        weChatModel = memberInit(weChatModel);
                        // 存放用户信息
                        WeChatController.MAP.putIfAbsent(uuid, weChatModel);
                        // 启动异步获取消息线程
                        executorService.execute(SpringBeansUtil.getBean(WeChatMessageListenTask.class)
                                .setWeChatModel(weChatModel).setBasicCookieStore(basicCookieStore));
                        return "success";
                    }
                } else if (!StringUtils.isEmpty(code) && code.startsWith("408") || code.startsWith("201")) {
                    checkLogin(uuid);
                }
            }
        } catch (Exception e) {
            logger.error("获取二维码异常：", e);
        }
        return null;
    }

    public WeChatModel memberInit(WeChatModel weChatModel) {
        WeChatModel.SecurityBean securityBean = weChatModel.getSecurityBean();
        HashMap<String, String> params = new HashMap<>();
        params.put("pass_ticket", securityBean.getPassTicket());
        params.put("skey", securityBean.getSkey());
        BasicCookieStore basicCookieStore = new BasicCookieStore();
        basicCookieStore.addCookie(new BasicClientCookie("webwx_data_ticket", securityBean.getWebwxDataTicket()));
        basicCookieStore.addCookie(new BasicClientCookie("webwx_auth_ticket", securityBean.getWebwxAuthTicket()));
        WeChatInitRequest weChatInitRequest = new WeChatInitRequest();
        WeChatInitRequest.BaseRequestBean baseRequestBean = new WeChatInitRequest.BaseRequestBean();
        baseRequestBean.setUin(securityBean.getWxuin());
        baseRequestBean.setSid(securityBean.getWxsid());
        baseRequestBean.setSkey(securityBean.getSkey());
        baseRequestBean.setDeviceID(weChatModel.getDeviceId());
        weChatInitRequest.setBaseRequest(baseRequestBean);
        String response = HttpClientUtil.sendAndFormatResponse(basicCookieStore, WeChatConstant.prefix + WeChatConstant.memeber_init, RequestMethod.POST, weChatInitRequest, params, null, true, null);
        if (StringUtils.isEmpty(response) || !response.contains("MemberList")) {
            return weChatModel;
        }
        WeChatMember weChatMember = JacksonConvertUtil.jsonToObject(response, WeChatMember.class);
        weChatModel.setMemberCount(weChatMember.getMemberCount());
        weChatModel.setMemberList(weChatMember.getMemberList());
        return weChatModel;
    }

    @Override
    public WeChatMessageModel getMessage(WeChatModel weChatModel) {
        WeChatModel.SecurityBean securityBean = weChatModel.getSecurityBean();
        BasicCookieStore basicCookieStore = new BasicCookieStore();
//        basicCookieStore.addCookie(new BasicClientCookie("webwx_data_ticket", securityBean.getWebwxDataTicket()));
//        basicCookieStore.addCookie(new BasicClientCookie("webwx_auth_ticket", securityBean.getWebwxAuthTicket()));
        HashMap<String, String> params = new HashMap<>();
        params.put("sid", securityBean.getWxsid());
        params.put("skey", securityBean.getSkey());
        params.put("uin", securityBean.getWxuin());
        WeChatMessageRequest weChatMessageRequest = new WeChatMessageRequest();
        WeChatMessageRequest.BaseRequestBean baseRequestBean = new WeChatMessageRequest.BaseRequestBean();
        baseRequestBean.setUin(Long.parseLong(securityBean.getWxuin()));
        baseRequestBean.setSid(securityBean.getWxsid());
        baseRequestBean.setSkey(securityBean.getSkey());
        baseRequestBean.setDeviceID(weChatModel.getDeviceId());
        weChatMessageRequest.setBaseRequest(baseRequestBean);
        weChatMessageRequest.setSyncKey(weChatModel.getSyncKey());
        String response = HttpClientUtil.sendAndFormatResponse(basicCookieStore, WeChatConstant.prefix + WeChatConstant.get_message, RequestMethod.POST, weChatMessageRequest, params, null, true, null);
        if (StringUtils.isEmpty(response) || !response.contains("BaseResponse")) {
            return null;
        }
        return JacksonConvertUtil.jsonToObject(response, WeChatMessageModel.class);
    }

    @Override
    public String formatMessage(WeChatMessageModel.AddMsgListBean weChatMessageModel, WeChatModel weChatModel) {
        List<WeChatMember.MemberListBean> memberList = weChatModel.getMemberList();
        if (!CollectionUtils.isEmpty(memberList)) {
            WorkWeChatMessageFormatModel workWeChatMessageFormatModel = new WorkWeChatMessageFormatModel();
            workWeChatMessageFormatModel.setContent(weChatMessageModel.getContent());
            memberList.stream()
                    .filter(memberListBean -> memberListBean.getUserName().equals(weChatMessageModel.getFromUserName()))
                    .findAny()
                    .ifPresent(memberListBean -> {
                        workWeChatMessageFormatModel.setName(memberListBean.getNickName());
                        workWeChatMessageFormatModel.setRemarkName(memberListBean.getRemarkName());
                        workWeChatMessageFormatModel.setWeChatName(memberListBean.getUserName());
                    });
            return workWeChatMessageFormatModel.toString();
        }
        return "";
    }

    @Override
    public WeChatModel loginInit(WeChatModel.SecurityBean securityBean, CookieStore cookieStore) {
        HashMap<String, String> map = new HashMap<>();
        map.put("pass_ticket", securityBean.getPassTicket());
        WeChatInitRequest weChatInitRequest = new WeChatInitRequest();
        WeChatInitRequest.BaseRequestBean baseRequestBean = new WeChatInitRequest.BaseRequestBean();
        baseRequestBean.setUin(securityBean.getWxuin());
        baseRequestBean.setSid(securityBean.getWxsid());
        baseRequestBean.setSkey(securityBean.getSkey());
        baseRequestBean.setDeviceID("e" + String.valueOf(new Random().nextLong()).substring(1, 16));
        weChatInitRequest.setBaseRequest(baseRequestBean);
        securityBean.setDeviceId(baseRequestBean.getDeviceID());
        String response = HttpClientUtil.sendAndFormatResponse(cookieStore, WeChatConstant.prefix + WeChatConstant.login_init, RequestMethod.POST, weChatInitRequest, map, null, true, null);
        if (StringUtils.isEmpty(response) || !response.contains("BaseResponse")) {
            return null;
        }
        WeChatModel weChatModel = JacksonConvertUtil.jsonToObject(response, WeChatModel.class);
        weChatModel.setSecurityBean(securityBean);
        return weChatModel;
    }
}
