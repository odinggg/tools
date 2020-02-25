package com.github.odinggg.tools.util;

import org.apache.http.Consts;
import org.apache.http.HeaderIterator;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicHeader;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.net.ssl.SSLContext;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * 描述:
 * http工具类
 *
 * @outhor Hansen
 * @create 2018-09-03 10:04
 */
public class HttpClientUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(HttpClientUtil.class);
    private static final String HTTP = "http";
    private static final String HTTPS = "https";
    private static SSLConnectionSocketFactory sslsf = null;
    private static PoolingHttpClientConnectionManager cm = null;
    private static SSLContextBuilder builder = null;
    private static RequestConfig config = null;

    public HttpClientUtil() {
    }

    public static String post(String url, String content) throws IOException {
        return postHeader(url, content, null);
    }

    public static String postHeader(String url, String content, Map<String, String> map) throws IOException {
        HttpEntity entity = new StringEntity(content, ContentType.create("application/json", Consts.UTF_8));
        String result = "";
        CloseableHttpClient httpClient = null;
        try {
            httpClient = getHttpClient();
            HttpPost httpPost = new HttpPost(url);
            setHeaders(map, httpPost);
            if (entity != null) {
                httpPost.setEntity(entity);
            }
            HttpResponse httpResponse = httpClient.execute(httpPost);
            int statusCode = httpResponse.getStatusLine().getStatusCode();
            if (statusCode == 200) {
                HttpEntity resEntity = httpResponse.getEntity();
                result = EntityUtils.toString(resEntity);
            } else {
                result = readHttpResponse(httpResponse);
            }
        } catch (IOException var12) {
            throw var12;
        } finally {
            if (httpClient != null) {
                httpClient.close();
            }

        }

        return result;
    }

    public static String getHeader(String url, Map<String, String> map) throws IOException {
        String result = "";
        CloseableHttpClient httpClient = null;

        try {
            httpClient = getHttpClient();
            HttpGet httpPost = new HttpGet(url);
            setHeaders(map, httpPost);
            HttpResponse httpResponse = httpClient.execute(httpPost);
            int statusCode = httpResponse.getStatusLine().getStatusCode();
            if (statusCode == 200) {
                HttpEntity resEntity = httpResponse.getEntity();
                result = EntityUtils.toString(resEntity);
            } else {
                result = readHttpResponse(httpResponse);
            }
        } catch (IOException var12) {
            throw var12;
        } finally {
            if (httpClient != null) {
                httpClient.close();
            }
        }
        return result;
    }

    public static String putHeader(String url, String content, Map<String, String> map) throws IOException {
        HttpEntity entity = new StringEntity(content, ContentType.create("application/json", Consts.UTF_8));
        String result = "";
        CloseableHttpClient httpClient = null;

        try {
            httpClient = getHttpClient();
            HttpPut httpPost = new HttpPut(url);
            setHeaders(map, httpPost);
            if (entity != null) {
                httpPost.setEntity(entity);
            }

            HttpResponse httpResponse = httpClient.execute(httpPost);
            int statusCode = httpResponse.getStatusLine().getStatusCode();
            if (statusCode == 200) {
                HttpEntity resEntity = httpResponse.getEntity();
                result = EntityUtils.toString(resEntity);
            } else {
                result = readHttpResponse(httpResponse);
            }
        } catch (IOException var12) {
            throw var12;
        } finally {
            if (httpClient != null) {
                httpClient.close();
            }

        }

        return result;
    }

    private static void setHeaders(Map<String, String> map, HttpUriRequest httpUriRequest) {
        if (map != null) {
            ArrayList<BasicHeader> headers = new ArrayList<>();
            map.forEach((key, value) -> {
                BasicHeader basicHeader = new BasicHeader(key, value);
                headers.add(basicHeader);
            });
            httpUriRequest.setHeaders(headers.toArray(new BasicHeader[0]));
        }
    }

    public static CloseableHttpClient getHttpClient() {
        return HttpClients.custom()
                .setSSLSocketFactory(sslsf)
                .setConnectionManager(cm)
                .setConnectionManagerShared(true)
                .build();
    }

    public static CloseableHttpClient getHttpClient(CookieStore cookieStore) {
        return HttpClients.custom()
                .setSSLSocketFactory(sslsf)
                .setConnectionManager(cm)
                .setConnectionManagerShared(true)
                .setDefaultCookieStore(cookieStore)
                .build();
    }

    public static String readHttpResponse(HttpResponse httpResponse) throws ParseException, IOException {
        StringBuilder builder = new StringBuilder();
        HttpEntity entity = httpResponse.getEntity();
        HashMap<String, Object> map = new HashMap<>();
        map.put("status", httpResponse.getStatusLine());
        ArrayList<Object> strings = new ArrayList<>();
        builder.append("status:" + httpResponse.getStatusLine());
        builder.append("headers:");
        HeaderIterator iterator = httpResponse.headerIterator();

        while (iterator.hasNext()) {
//            builder.append("\t" + iterator.next());
            strings.add(iterator.next());
        }
        map.put("headers", strings);

        if (entity != null) {
            String responseString = EntityUtils.toString(entity);
            map.put("length", responseString.length());
            map.put("content", responseString.replace("\r\n", ""));
            builder.append("response length:" + responseString.length());
            builder.append("response content:" + responseString.replace("\r\n", ""));
        }
        LOGGER.info("response:{}", builder.toString());
        return JacksonConvertUtil.objectToJson(map);
    }

    public static String getHeaders(String url, Map<String, String> headers) {
        return sendAndFormatResponse(url, RequestMethod.GET, null, null, headers, false);
    }

    public static String get(String url) {
        return sendAndFormatResponse(url, RequestMethod.GET, null, null, null, false);
    }

    public static String get(String url, Map<String, String> params) {
        return sendAndFormatResponse(url, RequestMethod.GET, null, params, null, false);
    }

    public static String get(int connectTimeout, int readTimeout, String url, Map<String, String> params) {
        config = RequestConfig.custom()
                .setSocketTimeout(readTimeout)
                .setConnectTimeout(connectTimeout)
                .setConnectionRequestTimeout(2000)
                .build();
        return sendAndFormatResponse(url, RequestMethod.GET, null, params, null, false);
    }

    public static HttpEntity getEntity(String url, Map<String, String> params) {
        return send(url, RequestMethod.GET, null, params, null, false, null);
    }

    public static String get(String url, Map<String, String> params, Map<String, String> headers) {
        if (!CollectionUtils.isEmpty(params)) {
            try {
                List<NameValuePair> collect = params.entrySet()
                        .stream()
                        .map(stringStringEntry -> new BasicHeader(stringStringEntry.getKey(), stringStringEntry.getValue()))
                        .collect(Collectors.toList());
                URIBuilder uriBuilder = new URIBuilder(url);
                uriBuilder.setParameters(collect);
                url = uriBuilder.build().toString();
            } catch (Exception e) {
                LOGGER.error("uri error:", e);
            }
        }
        return sendAndFormatResponse(url, RequestMethod.GET, null, null, headers, false);
    }

    public static String sendAndFormatResponse(String url, RequestMethod type, Object data, Map<String, String> params, Map<String, String> headers, boolean isJson) {
        return sendAndFormatResponse(url, type, data, params, headers, isJson, null);
    }

    public static String sendAndFormatResponse(String url, RequestMethod type, Object data, Map<String, String> params, Map<String, String> headers, boolean isJson, String mimeType) {
        if (!CollectionUtils.isEmpty(params)) {
            try {
                List<NameValuePair> collect = params.entrySet()
                        .stream()
                        .map(stringStringEntry -> new BasicHeader(stringStringEntry.getKey(), stringStringEntry.getValue()))
                        .collect(Collectors.toList());
                URIBuilder uriBuilder = new URIBuilder(url);
                uriBuilder.setParameters(collect);
                url = uriBuilder.build().toString();
            } catch (Exception e) {
                LOGGER.error("uri error:", e);
            }
        }
        LOGGER.info("http请求地址：{}", url);
        HttpRequestBase request = null;
        HttpEntity entity = null;
        String result = "";
        switch (type) {
            case GET:
                request = new HttpGet();
                break;
            case PUT:
                request = new HttpPut();
                break;
            case POST:
                request = new HttpPost();
                break;
            case DELETE:
                request = new HttpDelete();
                break;
            default:
                break;
        }
        if (request == null) {
            return "";
        }
        if (headers != null && headers.size() > 0) {
            setHeaders(headers, request);
        } else if (isJson) {
            HashMap<String, String> stringStringHashMap = new HashMap<>();
            stringStringHashMap.put("Content-Type", "application/json");
            setHeaders(stringStringHashMap, request);
        }
        request.setURI(URI.create(url));
        if (isJson) {
            if (!(data instanceof String)) {
                data = JacksonConvertUtil.toJsonString(data);
            }
            entity = new StringEntity((String) data, ContentType.create("application/json", Consts.UTF_8));
            LOGGER.info("http请求内容：{}", data);
        } else if (data instanceof byte[]) {
            entity = new ByteArrayEntity((byte[]) data, 0, ((byte[]) data).length);
            LOGGER.debug("http请求内容：{}", JacksonConvertUtil.toJsonString(data));
        } else if (!StringUtils.isEmpty(mimeType)) {
            entity = new StringEntity((String) data, ContentType.create(mimeType, Consts.UTF_8));
        }
        if (entity != null) {
            if (request instanceof HttpEntityEnclosingRequestBase) {
                ((HttpEntityEnclosingRequestBase) request).setEntity(entity);
            }
        }
        try (CloseableHttpClient httpClient = getHttpClient()) {
            if (config == null) {
                config = RequestConfig.custom()
                        .setSocketTimeout(5000)
                        .setConnectTimeout(5000)
                        .setConnectionRequestTimeout(2000)
                        .build();
            }
            request.setConfig(config);
            HttpResponse httpResponse = httpClient.execute(request);
            int statusCode = httpResponse.getStatusLine().getStatusCode();
            if (statusCode == 200 || statusCode == 202) {
                HttpEntity resEntity = httpResponse.getEntity();
                InputStream content = resEntity.getContent();
                result = EntityUtils.toString(resEntity);
            } else {
                result = readHttpResponse(httpResponse);
            }
        } catch (IOException var12) {
            LOGGER.error("请求提交异常:", var12);
        }
        LOGGER.info("请求结果：{}", result);
        return result;
    }

    public static String sendAndFormatResponse(CookieStore cookieStore, String url, RequestMethod type, Object data, Map<String, String> params, Map<String, String> headers, boolean isJson, String mimeType) {
        if (!CollectionUtils.isEmpty(params)) {
            try {
                List<NameValuePair> collect = params.entrySet()
                        .stream()
                        .map(stringStringEntry -> new BasicHeader(stringStringEntry.getKey(), stringStringEntry.getValue()))
                        .collect(Collectors.toList());
                URIBuilder uriBuilder = new URIBuilder(url);
                uriBuilder.setParameters(collect);
                url = uriBuilder.build().toString();
            } catch (Exception e) {
                LOGGER.error("uri error:", e);
            }
        }
        LOGGER.info("http请求地址：{}", url);
        HttpRequestBase request = null;
        HttpEntity entity = null;
        String result = "";
        switch (type) {
            case GET:
                request = new HttpGet();
                break;
            case PUT:
                request = new HttpPut();
                break;
            case POST:
                request = new HttpPost();
                break;
            case DELETE:
                request = new HttpDelete();
                break;
            default:
                break;
        }
        if (request == null) {
            return "";
        }
        if (headers != null && headers.size() > 0) {
            setHeaders(headers, request);
        } else if (isJson) {
            HashMap<String, String> stringStringHashMap = new HashMap<>();
            stringStringHashMap.put("Content-Type", "application/json");
            setHeaders(stringStringHashMap, request);
        }
        request.setURI(URI.create(url));
        if (isJson) {
            if (!(data instanceof String)) {
                data = JacksonConvertUtil.toJsonString(data);
            }
            entity = new StringEntity((String) data, ContentType.create("application/json", Consts.UTF_8));
            LOGGER.info("http请求内容：{}", data);
        } else if (data instanceof byte[]) {
            entity = new ByteArrayEntity((byte[]) data, 0, ((byte[]) data).length);
            LOGGER.debug("http请求内容：{}", JacksonConvertUtil.toJsonString(data));
        } else if (!StringUtils.isEmpty(mimeType)) {
            entity = new StringEntity((String) data, ContentType.create(mimeType, Consts.UTF_8));
        }
        if (entity != null) {
            if (request instanceof HttpEntityEnclosingRequestBase) {
                ((HttpEntityEnclosingRequestBase) request).setEntity(entity);
            }
        }
        try (CloseableHttpClient httpClient = getHttpClient(cookieStore)) {
            if (config == null) {
                config = RequestConfig.custom()
                        .setSocketTimeout(5000)
                        .setConnectTimeout(5000)
                        .setConnectionRequestTimeout(2000)
                        .build();
            }
            request.setConfig(config);
            HttpResponse httpResponse = httpClient.execute(request);
            int statusCode = httpResponse.getStatusLine().getStatusCode();
            if (statusCode == 200 || statusCode == 202) {
                HttpEntity resEntity = httpResponse.getEntity();
                InputStream content = resEntity.getContent();
                result = EntityUtils.toString(resEntity);
            } else {
                result = readHttpResponse(httpResponse);
            }
        } catch (IOException var12) {
            LOGGER.error("请求提交异常:", var12);
        }
        LOGGER.info("请求结果：{}", result);
        return result;
    }

    public static HttpEntity send(String url, RequestMethod type, Object data, Map<String, String> params, Map<String, String> headers, boolean isJson, String mimeType) {
        if (!CollectionUtils.isEmpty(params)) {
            try {
                List<NameValuePair> collect = params.entrySet()
                        .stream()
                        .map(stringStringEntry -> new BasicHeader(stringStringEntry.getKey(), stringStringEntry.getValue()))
                        .collect(Collectors.toList());
                URIBuilder uriBuilder = new URIBuilder(url);
                uriBuilder.setParameters(collect);
                url = uriBuilder.build().toString();
            } catch (Exception e) {
                LOGGER.error("uri error:", e);
            }
        }
        LOGGER.info("http请求地址：{}", url);
        HttpRequestBase request = null;
        HttpEntity entity = null;
        String result = "";
        switch (type) {
            case GET:
                request = new HttpGet();
                break;
            case PUT:
                request = new HttpPut();
                break;
            case POST:
                request = new HttpPost();
                break;
            case DELETE:
                request = new HttpDelete();
                break;
            default:
                break;
        }
        if (request == null) {
            return null;
        }
        if (headers != null && headers.size() > 0) {
            setHeaders(headers, request);
        } else if (isJson) {
            HashMap<String, String> stringStringHashMap = new HashMap<>();
            stringStringHashMap.put("Content-Type", "application/json");
            setHeaders(stringStringHashMap, request);
        }
        request.setURI(URI.create(url));
        if (isJson) {
            if (!(data instanceof String)) {
                data = JacksonConvertUtil.toJsonString(data);
            }
            entity = new StringEntity((String) data, ContentType.create("application/json", Consts.UTF_8));
            LOGGER.info("http请求内容：{}", data);
        } else if (data instanceof byte[]) {
            entity = new ByteArrayEntity((byte[]) data, 0, ((byte[]) data).length);
            LOGGER.debug("http请求内容：{}", JacksonConvertUtil.toJsonString(data));
        } else if (!StringUtils.isEmpty(mimeType)) {
            entity = new StringEntity((String) data, ContentType.create(mimeType, Consts.UTF_8));
        }
        if (entity != null) {
            if (request instanceof HttpEntityEnclosingRequestBase) {
                ((HttpEntityEnclosingRequestBase) request).setEntity(entity);
            }
        }
        try (CloseableHttpClient httpClient = getHttpClient()) {
            if (config == null) {
                config = RequestConfig.custom()
                        .setSocketTimeout(5000)
                        .setConnectTimeout(5000)
                        .setConnectionRequestTimeout(2000)
                        .build();
            }
            request.setConfig(config);
            HttpResponse httpResponse = httpClient.execute(request);
            int statusCode = httpResponse.getStatusLine().getStatusCode();
            if (statusCode == 200 || statusCode == 202) {
                return httpResponse.getEntity();
            } else {
                result = readHttpResponse(httpResponse);
                LOGGER.info("请求结果：{}", result);
            }
        } catch (IOException var12) {
            LOGGER.error("请求提交异常:", var12);
        }
        LOGGER.info("请求结果：{}", result);
        return null;
    }

    public static String sendAndFormatResponse(int connectTimeout, int readTimeout, String url, RequestMethod type, Object data, Map<String, String> params, Map<String, String> headers, boolean isJson, String mimeType) {
        config = RequestConfig.custom()
                .setSocketTimeout(readTimeout)
                .setConnectTimeout(connectTimeout)
                .setConnectionRequestTimeout(2000)
                .build();
        return sendAndFormatResponse(url, type, data, params, headers, isJson, mimeType);
    }

    static {
        try {
            KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
            TrustStrategy anyTrustStrategy = (x509Certificates, s) -> true;
            SSLContext sslContext = SSLContexts.custom()
                    .setProtocol("TLS")
                    .loadTrustMaterial(trustStore, anyTrustStrategy)
                    .build();
            sslsf = new SSLConnectionSocketFactory(sslContext, NoopHostnameVerifier.INSTANCE);
            Registry<ConnectionSocketFactory> registry = RegistryBuilder.<ConnectionSocketFactory>create().register("http", new PlainConnectionSocketFactory())
                    .register("https", sslsf)
                    .build();
            cm = new PoolingHttpClientConnectionManager(registry);
            cm.setMaxTotal(200);
        } catch (Exception var4) {
            var4.printStackTrace();
        }

    }

    public static String sendAndFormatResponse(String url, RequestMethod type, Object data, Map<String, String> headers, boolean isJson) {
        return sendAndFormatResponse(url, type, data, null, headers, isJson);
    }

    public static String get(BasicCookieStore basicCookieStore, int readTimeout, int connectTimeout, String url, HashMap<String, String> params) {
        config = RequestConfig.custom()
                .setSocketTimeout(readTimeout)
                .setConnectTimeout(connectTimeout)
                .setConnectionRequestTimeout(2000)
                .build();
        return sendAndFormatResponse(basicCookieStore, url, RequestMethod.GET, null, params, null, false, null);
    }

    public static String get(BasicCookieStore basicCookieStore, String url) {
        return get(basicCookieStore, 10000, 10000, url, null);
    }

    public static String sendAndFormatResponse(BasicCookieStore basicCookieStore, int connectTimeout, int readTimeout, String url, RequestMethod type, Object data, Map<String, String> params, Map<String, String> headers, boolean isJson, String mimeType) {
        config = RequestConfig.custom()
                .setSocketTimeout(readTimeout)
                .setConnectTimeout(connectTimeout)
                .setConnectionRequestTimeout(2000)
                .build();
        return sendAndFormatResponse(basicCookieStore, url, type, data, params, headers, isJson, mimeType);
    }
}
