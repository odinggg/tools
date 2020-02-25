package com.github.odinggg.tools;

import com.github.odinggg.tools.enums.HttpParamEnum;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * 描述:
 * 配置类
 *
 * @author Hansen
 * @version 2019-10-21 20:19
 */
@Component
@ConfigurationProperties(prefix = "config")
public class Configuration {
    private Map<HttpParamEnum, Param> httpParam;

    public static class Param {
        private String url;

        private String secret;

        private String accessKey;

        private String username;

        private String password;

        private RequestMethod method;

        public RequestMethod getMethod() {
            return method;
        }

        public void setMethod(RequestMethod method) {
            this.method = method;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getSecret() {
            return secret;
        }

        public void setSecret(String secret) {
            this.secret = secret;
        }

        public String getAccessKey() {
            return accessKey;
        }

        public void setAccessKey(String accessKey) {
            this.accessKey = accessKey;
        }
    }

    public Map<HttpParamEnum, Param> getHttpParam() {
        return httpParam;
    }

    public void setHttpParam(Map<HttpParamEnum, Param> httpParam) {
        this.httpParam = httpParam;
    }
}
