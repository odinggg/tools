package com.github.odinggg.tools.websocket;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.odinggg.tools.util.JacksonConvertUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 描述:
 *
 * @author Hansen
 * @version 2019-11-06 9:38
 */
@Service
public class CustomWebSocketHandler extends TextWebSocketHandler implements WebSocketHandler {
    private Logger logger = LoggerFactory.getLogger(CustomWebSocketHandler.class);
    // 在线用户列表
    private static final Map<String, WebSocketSession> users;
    // 用户标识
    private static final String CLIENT_ID = "mchNo";

    static {
        users = new HashMap<>();
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        logger.info("成功建立websocket-spring连接");
        String mchNo = getMchNo(session);
        if (!StringUtils.isEmpty(mchNo)) {
            users.put(mchNo, session);
            session.sendMessage(new TextMessage("成功建立websocket-spring连接"));
            logger.info("用户标识：{}，Session：{}", mchNo, session.toString());
        }
    }

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) {
        logger.info("收到客户端消息：{}", message.getPayload());
        JsonNode json = JacksonConvertUtil.getJSON(message.getPayload());
        String to = JacksonConvertUtil.getJSONString(json, "to");
        String msg = JacksonConvertUtil.getJSONString(json, "msg");
        WebSocketMessage<?> webSocketMessageServer = new TextMessage("server:" + message);
        try {
            session.sendMessage(webSocketMessageServer);
            if ("all".equals(to.toLowerCase())) {
                sendMessageToAllUsers(new TextMessage(getMchNo(session) + ":" + msg));
            } else {
                sendMessageToUser(to, new TextMessage(getMchNo(session) + ":" + msg));
            }
        } catch (IOException e) {
            logger.info("handleTextMessage method error：{}", e);
        }
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        if (session.isOpen()) {
            session.close();
        }
        logger.info("连接出错");
        users.remove(getMchNo(session));
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        logger.info("连接已关闭：" + status);
        users.remove(getMchNo(session));
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }

    public void sendMessage(String jsonData) {
        logger.info("收到客户端消息sendMessage：{}", jsonData);
        JsonNode json = JacksonConvertUtil.getJSON(jsonData);
        String mchNo = StringUtils.isEmpty(JacksonConvertUtil.getJSONString(json, CLIENT_ID)) ? "陌生人" : JacksonConvertUtil
                .getJSONString(json, CLIENT_ID);
        String to = JacksonConvertUtil.getJSONString(json, "to");
        String msg = JacksonConvertUtil.getJSONString(json, "msg");
        if ("all".equals(to.toLowerCase())) {
            sendMessageToAllUsers(new TextMessage(mchNo + ":" + msg));
        } else {
            sendMessageToUser(to, new TextMessage(mchNo + ":" + msg));
        }
    }

    /**
     * 发送信息给指定用户
     *
     * @param mchNo
     * @param message
     * @return
     * @Title: sendMessageToUser
     * @Description: TODO
     * @Date 2018年8月21日 上午11:01:08
     * @author huangk
     */
    public boolean sendMessageToUser(String mchNo, TextMessage message) {
        if (users.get(mchNo) == null)
            return false;
        WebSocketSession session = users.get(mchNo);
        logger.info("sendMessage：{} ,msg：{}", session, message.getPayload());
        if (!session.isOpen()) {
            logger.info("客户端:{},已断开连接，发送消息失败", mchNo);
            return false;
        }
        try {
            session.sendMessage(message);
        } catch (IOException e) {
            logger.info("sendMessageToUser method error：{}", e);
            return false;
        }
        return true;
    }

    /**
     * 广播信息
     *
     * @param message
     * @return
     * @Title: sendMessageToAllUsers
     * @Description: TODO
     * @Date 2018年8月21日 上午11:01:14
     * @author huangk
     */
    public boolean sendMessageToAllUsers(TextMessage message) {
        boolean allSendSuccess = true;
        Set<String> mchNos = users.keySet();
        WebSocketSession session = null;
        for (String mchNo : mchNos) {
            try {
                session = users.get(mchNo);
                if (session.isOpen()) {
                    session.sendMessage(message);
                } else {
                    logger.info("客户端:{},已断开连接，发送消息失败", mchNo);
                }
            } catch (IOException e) {
                logger.info("sendMessageToAllUsers method error：{}", e);
                allSendSuccess = false;
            }
        }

        return allSendSuccess;
    }

    /**
     * 获取用户标识
     *
     * @param session
     * @return
     * @Title: getMchNo
     * @Description: TODO
     * @Date 2018年8月21日 上午11:01:01
     * @author huangk
     */
    private String getMchNo(WebSocketSession session) {
        try {
            String mchNo = session.getAttributes().get(CLIENT_ID).toString();
            return mchNo;
        } catch (Exception e) {
            return null;
        }
    }
}
