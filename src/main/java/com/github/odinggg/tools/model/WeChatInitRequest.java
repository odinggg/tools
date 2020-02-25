package com.github.odinggg.tools.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 描述:
 *
 * @author Hansen
 * @version 2020-02-25 15:58
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeChatInitRequest {

    /**
     * BaseRequest : {"Uin":"503397695","Sid":"g3dS6kT9lxeZxVTj","Skey":"@crypt_a51bc2d6_135ea0489dc3c4bb3467d8012d6b4bc7","DeviceID":"e714116258711348"}
     */

    @JsonProperty("BaseRequest")
    private BaseRequestBean BaseRequest;

    public BaseRequestBean getBaseRequest() {
        return BaseRequest;
    }

    public void setBaseRequest(BaseRequestBean BaseRequest) {
        this.BaseRequest = BaseRequest;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class BaseRequestBean {
        /**
         * Uin : 503397695
         * Sid : g3dS6kT9lxeZxVTj
         * Skey : @crypt_a51bc2d6_135ea0489dc3c4bb3467d8012d6b4bc7
         * DeviceID : e714116258711348
         */

        @JsonProperty("Uin")
        private String Uin;
        @JsonProperty("Sid")
        private String Sid;
        @JsonProperty("Skey")
        private String Skey;
        @JsonProperty("DeviceID")
        private String DeviceID;

        public String getUin() {
            return Uin;
        }

        public void setUin(String Uin) {
            this.Uin = Uin;
        }

        public String getSid() {
            return Sid;
        }

        public void setSid(String Sid) {
            this.Sid = Sid;
        }

        public String getSkey() {
            return Skey;
        }

        public void setSkey(String Skey) {
            this.Skey = Skey;
        }

        public String getDeviceID() {
            return DeviceID;
        }

        public void setDeviceID(String DeviceID) {
            this.DeviceID = DeviceID;
        }
    }
}
