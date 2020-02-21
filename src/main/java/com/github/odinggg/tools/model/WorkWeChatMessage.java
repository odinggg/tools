package com.github.odinggg.tools.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WorkWeChatMessage {


    /**
     * touser : qinhaochun
     * msgtype : text
     * agentid : 1000002
     * text : {"content":"你的快递已到，请携带工卡前往邮件中心领取。\n出发前可查看<a href=\"http://work.weixin.qq.com\">邮件中心视频实况<\/a>，聪明避开排队。"}
     * safe : 0
     * enable_id_trans : 0
     * enable_duplicate_check : 0
     */

    @JsonProperty("touser")
    private String touser;
    @JsonProperty("msgtype")
    private String msgtype;
    @JsonProperty("agentid")
    private Integer agentid;
    @JsonProperty("text")
    private TextBean text;
    @JsonProperty("safe")
    private Integer safe = 0;
    @JsonProperty("enable_id_trans")
    private Integer enableIdTrans = 0;
    @JsonProperty("enable_duplicate_check")
    private Integer enableDuplicateCheck = 0;

    public String getTouser() {
        return touser;
    }

    public void setTouser(String touser) {
        this.touser = touser;
    }

    public String getMsgtype() {
        return msgtype;
    }

    public void setMsgtype(String msgtype) {
        this.msgtype = msgtype;
    }

    public Integer getAgentid() {
        return agentid;
    }

    public void setAgentid(Integer agentid) {
        this.agentid = agentid;
    }

    public TextBean getText() {
        return text;
    }

    public void setText(TextBean text) {
        this.text = text;
    }

    public Integer getSafe() {
        return safe;
    }

    public void setSafe(Integer safe) {
        this.safe = safe;
    }

    public Integer getEnableIdTrans() {
        return enableIdTrans;
    }

    public void setEnableIdTrans(Integer enableIdTrans) {
        this.enableIdTrans = enableIdTrans;
    }

    public Integer getEnableDuplicateCheck() {
        return enableDuplicateCheck;
    }

    public void setEnableDuplicateCheck(Integer enableDuplicateCheck) {
        this.enableDuplicateCheck = enableDuplicateCheck;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class TextBean {
        /**
         * content : 你的快递已到，请携带工卡前往邮件中心领取。
         * 出发前可查看<a href="http://work.weixin.qq.com">邮件中心视频实况</a>，聪明避开排队。
         */

        @JsonProperty("content")
        private String content;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }
}
