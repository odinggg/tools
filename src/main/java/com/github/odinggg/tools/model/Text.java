package com.github.odinggg.tools.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

/**
 * 描述:
 *
 * @author Hansen
 * @version 2019-12-27 16:35
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Text implements Serializable {
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
