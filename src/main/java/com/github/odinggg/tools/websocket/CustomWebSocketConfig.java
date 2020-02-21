package com.github.odinggg.tools.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * 描述:
 *
 * @author Hansen
 * @version 2019-11-06 10:07
 */

@Configuration
@EnableWebSocket
public class CustomWebSocketConfig implements WebSocketConfigurer {
    @Autowired
    private CustomWebSocketHandler customWebSocketHandler;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {
        webSocketHandlerRegistry.addHandler(customWebSocketHandler, "/webSocketBySpring/customWebSocketHandler")
                .addInterceptors(new CustomWebSocketInterceptor())
                .setAllowedOrigins("*");
        webSocketHandlerRegistry.addHandler(customWebSocketHandler, "/sockjs/webSocketBySpring/customWebSocketHandler")
                .addInterceptors(new CustomWebSocketInterceptor())
                .setAllowedOrigins("*")
                .withSockJS();
    }
}
