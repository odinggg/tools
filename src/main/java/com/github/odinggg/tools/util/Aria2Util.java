package com.github.odinggg.tools.util;

import com.github.odinggg.tools.model.Aria2Request;
import com.github.odinggg.tools.model.Aria2StatusResponse;
import com.github.odinggg.tools.model.BilibiliAira2Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

/**
 * 描述:
 *
 * @author Hansen
 * @version 2019-11-06 17:30
 */
public class Aria2Util {
    private final static Logger LOGGER = LoggerFactory.getLogger(Aria2Util.class);

    public static Aria2Request addUri(BilibiliAira2Data data) {
        try {
            Aria2Request aria2Request = new Aria2Request();
            aria2Request.setId(UUID.randomUUID().toString().replaceAll("-", ""));
            aria2Request.setJsonrpc("2.0");
            aria2Request.setMethod("aria2.addUri");
            ArrayList<Object> objects = new ArrayList<>();
            ArrayList<String> uris = new ArrayList<>();
            uris.add(data.getUri());
            objects.add(uris);
            HashMap<String, Object> headers = new HashMap<>();
            ArrayList<String> strings = new ArrayList<>();
            strings.add("User-Agent:Mozilla/5.0 (Macintosh; Intel Mac OS X 10.13; rv:56.0) Gecko/20100101 Firefox/56.0");
            strings.add("Accept:*/*");
            strings.add("Accept-Language:en-US,en;q=0.5");
            strings.add("Accept-Encoding:gzip, deflate, br");
            strings.add("Range:bytes=0-");
            strings.add("Referer:" + data.getStartUri());
            strings.add("Origin:https://www.bilibili.com");
            strings.add("Connection:keep-alive");
            headers.put("header", strings);
            if (!StringUtils.isEmpty(data.getFileDir())) {
                headers.put("dir", data.getFileDir());
            }
            if (!StringUtils.isEmpty(data.getFileName())) {
                headers.put("out", data.getFileName());
            }
            objects.add(headers);
            aria2Request.setParams(objects);
            String response = HttpClientUtil.sendAndFormatResponse("http://localhost:6800/jsonrpc", RequestMethod.POST, aria2Request, null, true);
            return JacksonConvertUtil.jsonToObject(response, Aria2Request.class);
        } catch (Exception e) {
            LOGGER.error("aria2添加下载异常：", e);
        }
        return new Aria2Request();
    }

    public static Aria2Request addUri(String uri, List<String> stringHeaders, String fileDir, String fileName) {
        try {
            Aria2Request aria2Request = new Aria2Request();
            aria2Request.setId(UUID.randomUUID().toString().replaceAll("-", ""));
            aria2Request.setJsonrpc("2.0");
            aria2Request.setMethod("aria2.addUri");
            ArrayList<Object> objects = new ArrayList<>();
            ArrayList<String> uris = new ArrayList<>();
            uris.add(uri);
            objects.add(uris);
            HashMap<String, Object> headers = new HashMap<>();
            if (!CollectionUtils.isEmpty(stringHeaders)) {
                headers.put("header", stringHeaders);
            }
            if (!StringUtils.isEmpty(fileDir)) {
                headers.put("dir", fileDir);
            }
            if (!StringUtils.isEmpty(fileName)) {
                headers.put("out", fileName);
            }
            objects.add(headers);
            aria2Request.setParams(objects);
            String response = HttpClientUtil.sendAndFormatResponse("http://localhost:6800/jsonrpc", RequestMethod.POST, aria2Request, null, true);
            return JacksonConvertUtil.jsonToObject(response, Aria2Request.class);
        } catch (Exception e) {
            LOGGER.error("aria2添加下载异常：", e);
        }
        return new Aria2Request();
    }

    public static Aria2StatusResponse tellStatus(String gid) {
        try {
            Aria2Request aria2Request = new Aria2Request();
            aria2Request.setId(UUID.randomUUID().toString().replaceAll("-", ""));
            aria2Request.setJsonrpc("2.0");
            aria2Request.setMethod("aria2.tellStatus");
            ArrayList<Object> objects = new ArrayList<>();
            objects.add(gid);
            aria2Request.setParams(objects);
            String response = HttpClientUtil.sendAndFormatResponse("http://localhost:6800/jsonrpc", RequestMethod.POST, aria2Request, null, true);
            return JacksonConvertUtil.jsonToObject(response, Aria2StatusResponse.class);
        } catch (Exception e) {
            LOGGER.error("aria2添加下载异常：", e);
        }
        return new Aria2StatusResponse();
    }

    public static void main(String[] args) {
//        Aria2Request aria2Request = addUri("https://mirrors.tuna.tsinghua.edu.cn/docker-ce/win/static/stable/x86_64/docker-17.06.1-ce.zip", null, null, null);
        tellStatus("b61c39e7d320f05e");
    }
}
