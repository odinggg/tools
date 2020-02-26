package com.github.odinggg.tools.model;

import org.springframework.util.StringUtils;

import java.util.ArrayList;

/**
 * 描述:
 *
 * @author Hansen
 * @version 2020-02-26 10:38
 */
public class WorkWeChatMessageFormatModel {
    private final String templateString = "### {1}/{2}\n[{3}]";
    private String name;
    private String weChatName;
    private String remarkName;
    private String content;

    @Override
    public String toString() {
        ArrayList<String> list = new ArrayList<>();
        String formatName;
        if (StringUtils.isEmpty(remarkName)) {
            list.add(name);
        } else {
            list.add(remarkName);
        }
        list.add(weChatName);
        list.add(content);
        return String.format(templateString, list.toArray());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWeChatName() {
        return weChatName;
    }

    public void setWeChatName(String weChatName) {
        this.weChatName = weChatName;
    }

    public String getRemarkName() {
        return remarkName;
    }

    public void setRemarkName(String remarkName) {
        this.remarkName = remarkName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
