package com.github.odinggg.tools.enums;

/**
 * 描述:
 *
 * @author Hansen
 * @version 2020-02-26 9:49
 */
public enum WeChatMessageSyncSelectorEnum {
    NORMAL("0", "正常"),
    NEW_MSG("2", "有新消息"),
    MOD_CONTACT("4", "有人修改了自己的昵称或你修改了别人的备注"),
    ADD_OR_DEL_CONTACT("6", "存在删除或者新增的好友信息"),
    ENTER_OR_LEAVE_CHAT("7", "进入或离开聊天界面");
    private String code;

    private String text;

    WeChatMessageSyncSelectorEnum(String code, String text) {
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
