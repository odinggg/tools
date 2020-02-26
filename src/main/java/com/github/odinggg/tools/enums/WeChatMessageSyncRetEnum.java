package com.github.odinggg.tools.enums;

/**
 * 描述:
 *
 * @author Hansen
 * @version 2020-02-26 9:49
 */
public enum WeChatMessageSyncRetEnum {
    SUCCESS("0", "成功"),
    TICKET_ERROR("-14", "ticket错误"),
    PARAM_ERROR("1", "传入参数错误"),
    NOT_LOGIN_WARN("1100", "未登录提示"),
    NOT_LOGIN_CHECK("1101", "未检测到登录"),
    COOKIE_INVALID_ERROR("1102", "cookie值无效"),
    LOGIN_ENV_ERROR("1203", "当前登录环境异常，为了安全起见请不要在web端进行登录"),
    TOO_OFEN("1205", "操作频繁");
    private String code;

    private String text;

    WeChatMessageSyncRetEnum(String code, String text) {
        this.code = code;
        this.text = text;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
