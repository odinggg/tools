package com.github.odinggg.tools.enums;

import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * 描述:
 *
 * @author Hansen
 * @version 2020-02-26 9:49
 */
public enum WeChatMessageTypeEnum {
    UNDEFINE(-1, "未定义"),
    TEXT(1, "文本消息类型"),
    IMAGE(3, "图片消息"),
    VOICE(34, "语音消息"),
    VIDEO(43, "小视频消息"),
    MICRO_VIDEO(62, "短视频消息"),
    EMOTI_CON(47, "表情消息"),
    MEDIA(49, "多媒体消息"),
    VOIP_MSG(50, ""),
    VOIP_NOTIFY(52, ""),
    VOIP_INVITE(53, ""),
    LOCATION(48, ""),
    STATUS_NOTIFY(51, "状态通知，自己访问了某一个聊天页面"),
    SYS_NOTICE(9999, ""),
    POSSIBLE_FRIEND_MSG(40, ""),
    VERIFY_MSG(37, "好友请求"),
    SHARE_CARD(42, "分享名片"),
    SYS(10000, "系统消息"),
    RECALLED(10002, "撤回消息");
    private Integer code;

    private String text;

    public static WeChatMessageTypeEnum parse(Integer str) {
        Predicate<WeChatMessageTypeEnum> statusFilter = element -> element.getCode().equals(str);
        Optional<WeChatMessageTypeEnum> status = Stream.of(WeChatMessageTypeEnum.values())
                .filter(statusFilter)
                .findAny();
        return status.orElse(UNDEFINE);
    }

    WeChatMessageTypeEnum(Integer code, String text) {
        this.code = code;
        this.text = text;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
