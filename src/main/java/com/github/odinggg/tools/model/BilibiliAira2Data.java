package com.github.odinggg.tools.model;

/**
 * 描述:
 *
 * @author Hansen
 * @version 2019-11-06 12:46
 */
public class BilibiliAira2Data {
    // 请求uri
    private String uri;
    // Referer uri
    private String startUri;
    // 保存文件名
    private String fileName;
    // 保存文件路径
    private String fileDir;

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getStartUri() {
        return startUri;
    }

    public void setStartUri(String startUri) {
        this.startUri = startUri;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileDir() {
        return fileDir;
    }

    public void setFileDir(String fileDir) {
        this.fileDir = fileDir;
    }
}
