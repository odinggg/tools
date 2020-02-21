package com.github.odinggg.tools.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * 描述:
 * aria2请求体
 *
 * @author Hansen
 * @version 2019-11-06 11:14
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Aria2Request {

    /**
     * jsonrpc : 2.0
     * method : aria2.addUri
     * id : QXJpYU5nXzE1NzMwMDg3MzNfMC41NDA2MzI1MjU1NDMxNTY4
     * params : [["https://mirrors.tuna.tsinghua.edu.cn/docker-ce/win/static/stable/x86_64/docker-17.06.1-ce.zip"],{"header":["Referer:https://mirrors.tuna.tsinghua.edu.cn/docker-ce/win/static/stable/x86_64/","Sec-Fetch-Site:cross-site"]}]
     */

    @JsonProperty("jsonrpc")
    private String jsonrpc;
    @JsonProperty("method")
    private String method;
    @JsonProperty("id")
    private String id;
    @JsonProperty("params")
    private List<Object> params;
    @JsonProperty("result")
    private String result;
    @JsonProperty("title")
    private String title;
    @JsonProperty("useTime")
    private String useTime;

    public String getUseTime() {
        return useTime;
    }

    public void setUseTime(String useTime) {
        this.useTime = useTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getJsonrpc() {
        return jsonrpc;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public void setJsonrpc(String jsonrpc) {
        this.jsonrpc = jsonrpc;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Object> getParams() {
        return params;
    }

    public void setParams(List<Object> params) {
        this.params = params;
    }
}
