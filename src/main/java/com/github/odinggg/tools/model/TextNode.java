package com.github.odinggg.tools.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.Map;

/**
 * 描述:
 *
 * @author Hansen
 * @version 2020-01-06 19:42
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TextNode implements Serializable {
    private String key;

    private String pKey;

    private Object value;

    private Map<String, TextNode> childrenList;

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public TextNode(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public TextNode(String key, String pKey, Map<String, TextNode> childrenList) {
        this.key = key;
        this.pKey = pKey;
        this.childrenList = childrenList;
    }

    public TextNode(String key, Map<String, TextNode> childrenList) {
        this.key = key;
        this.childrenList = childrenList;
    }

    public TextNode() {
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getpKey() {
        return pKey;
    }

    public void setpKey(String pKey) {
        this.pKey = pKey;
    }

    public Map<String, TextNode> getChildrenList() {
        return childrenList;
    }

    public void setChildrenList(Map<String, TextNode> childrenList) {
        this.childrenList = childrenList;
    }
}
