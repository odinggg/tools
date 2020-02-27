package com.github.odinggg.tools.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 描述:
 *
 * @author QinHaoChun
 * @version 2020-02-27 18:54
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeChatSendMessageRequest {

    /**
     * BaseRequest : {"Uin":211722515,"Sid":"+FhlgkGS3wD/GKQw","Skey":"@crypt_8b4f09cc_1b827f84b1535b6be801f00427499050","DeviceID":"e107694022625701"}
     * Msg : {"Type":1,"Content":"呵呵","FromUserName":"@abf90232027117affa7f0c0df3d1bf20","ToUserName":"filehelper","LocalID":"15209344559450477","ClientMsgId":"15209344559450477","MediaId":"如果是图片才传这个值"}
     * Scene : 0
     */

    @JsonProperty("BaseRequest")
    private BaseRequestBean BaseRequest;
    @JsonProperty("Msg")
    private MsgBean Msg;
    @JsonProperty("Scene")
    private Long Scene;

    public BaseRequestBean getBaseRequest() {
        return BaseRequest;
    }

    public void setBaseRequest(BaseRequestBean BaseRequest) {
        this.BaseRequest = BaseRequest;
    }

    public MsgBean getMsg() {
        return Msg;
    }

    public void setMsg(MsgBean Msg) {
        this.Msg = Msg;
    }

    public Long getScene() {
        return Scene;
    }

    public void setScene(Long Scene) {
        this.Scene = Scene;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class BaseRequestBean {
        /**
         * Uin : 211722515
         * Sid : +FhlgkGS3wD/GKQw
         * Skey : @crypt_8b4f09cc_1b827f84b1535b6be801f00427499050
         * DeviceID : e107694022625701
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

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class MsgBean {
        /**
         * Type : 1
         * Content : 呵呵
         * FromUserName : @abf90232027117affa7f0c0df3d1bf20
         * ToUserName : filehelper
         * LocalID : 15209344559450477
         * ClientMsgId : 15209344559450477
         * MediaId : 如果是图片才传这个值
         */

        @JsonProperty("Type")
        private Long Type;
        @JsonProperty("Content")
        private String Content;
        @JsonProperty("FromUserName")
        private String FromUserName;
        @JsonProperty("ToUserName")
        private String ToUserName;
        @JsonProperty("LocalID")
        private String LocalID;
        @JsonProperty("ClientMsgId")
        private String ClientMsgId;
        @JsonProperty("MediaId")
        private String MediaId;

        public Long getType() {
            return Type;
        }

        public void setType(Long Type) {
            this.Type = Type;
        }

        public String getContent() {
            return Content;
        }

        public void setContent(String Content) {
            this.Content = Content;
        }

        public String getFromUserName() {
            return FromUserName;
        }

        public void setFromUserName(String FromUserName) {
            this.FromUserName = FromUserName;
        }

        public String getToUserName() {
            return ToUserName;
        }

        public void setToUserName(String ToUserName) {
            this.ToUserName = ToUserName;
        }

        public String getLocalID() {
            return LocalID;
        }

        public void setLocalID(String LocalID) {
            this.LocalID = LocalID;
        }

        public String getClientMsgId() {
            return ClientMsgId;
        }

        public void setClientMsgId(String ClientMsgId) {
            this.ClientMsgId = ClientMsgId;
        }

        public String getMediaId() {
            return MediaId;
        }

        public void setMediaId(String MediaId) {
            this.MediaId = MediaId;
        }
    }
}
