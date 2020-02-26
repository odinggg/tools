package com.github.odinggg.tools.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * 描述:
 *
 * @author QinHaoChun
 * @version 2020-02-26 10:10
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeChatMessageRequest {

    /**
     * BaseRequest : {"Uin":211722515,"Sid":"+FhlgkGS3wD/GKQw","Skey":"@crypt_8b4f09cc_1b827f84b1535b6be801f00427499050","DeviceID":"e304534670317808"}
     * SyncKey : {"Count":4,"List":[{"Key":1,"Val":700722177},{"Key":2,"Val":700724323},{"Key":3,"Val":700724315},{"Key":1000,"Val":1520925834}]}
     * rr : -508959981
     */

    @JsonProperty("BaseRequest")
    private BaseRequestBean BaseRequest;
    @JsonProperty("SyncKey")
    private WeChatModel.SyncKeyBean SyncKey;
    @JsonProperty("rr")
    private Long rr = -(Long) (System.currentTimeMillis() / 1000);

    public BaseRequestBean getBaseRequest() {
        return BaseRequest;
    }

    public void setBaseRequest(BaseRequestBean BaseRequest) {
        this.BaseRequest = BaseRequest;
    }

    public WeChatModel.SyncKeyBean getSyncKey() {
        return SyncKey;
    }

    public void setSyncKey(WeChatModel.SyncKeyBean SyncKey) {
        this.SyncKey = SyncKey;
    }

    public Long getRr() {
        return rr;
    }

    public void setRr(Long rr) {
        this.rr = rr;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class BaseRequestBean {
        /**
         * Uin : 211722515
         * Sid : +FhlgkGS3wD/GKQw
         * Skey : @crypt_8b4f09cc_1b827f84b1535b6be801f00427499050
         * DeviceID : e304534670317808
         */

        @JsonProperty("Uin")
        private Long Uin;
        @JsonProperty("Sid")
        private String Sid;
        @JsonProperty("Skey")
        private String Skey;
        @JsonProperty("DeviceID")
        private String DeviceID;

        public Long getUin() {
            return Uin;
        }

        public void setUin(Long Uin) {
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
