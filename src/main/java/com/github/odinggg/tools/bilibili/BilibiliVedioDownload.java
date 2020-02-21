package com.github.odinggg.tools.bilibili;

import com.github.odinggg.tools.model.Aria2Request;
import com.github.odinggg.tools.model.BilibiliAira2Data;
import com.github.odinggg.tools.model.GetSubmitVideoResponse;
import com.github.odinggg.tools.model.VideoDetailResponse;
import com.github.odinggg.tools.model.VideoDownloadResponse;
import com.github.odinggg.tools.tasks.Aria2DownloadTask;
import com.github.odinggg.tools.util.Aria2Util;
import com.github.odinggg.tools.util.HttpClientUtil;
import com.github.odinggg.tools.util.JacksonConvertUtil;
import com.github.odinggg.tools.util.MD5Util;
import com.google.common.collect.Lists;
import org.apache.http.client.utils.URIBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.stream.Collectors;

/**
 * 描述:
 *
 * @author Hansen
 * @version 2019-11-05 12:45
 */
@Service
public class BilibiliVedioDownload {
    public static final String GET_SUBMIT_VIDEOS = "https://space.bilibili.com/ajax/member/getSubmitVideos";
    public static final String START_URL = "https://api.bilibili.com/x/web-interface/view";
    public static final String BILIBILI_INTERFACE = "https://interface.bilibili.com/v2/playurl";
    private Logger logger = LoggerFactory.getLogger(BilibiliVedioDownload.class);
    @Value("${file.dir:}")
    private String fileDir;
    @Value("${bilibili.appKey:}")
    private String appKey;
    @Value("${bilibili.secret:}")
    private String secret;

    public String getFileDir() {
        return fileDir;
    }

    public void setFileDir(String fileDir) {
        this.fileDir = fileDir;
    }

    /**
     * 根据用户编号获取用户全部视频
     *
     * @param mid 用户编号
     */
    public List<GetSubmitVideoResponse.DataBean.VlistBean> getDownloadUrl(String mid) {
        try {
            // uri
            URIBuilder uriBuilder = new URIBuilder(GET_SUBMIT_VIDEOS);
            uriBuilder.addParameter("mid", mid);
            uriBuilder.addParameter("pagesize", "50");
            uriBuilder.addParameter("page", "1");
            uriBuilder.addParameter("keyword", "");
            uriBuilder.addParameter("order", "pubdate");// 按更新时间排序
            // header
            HashMap<String, String> headers = new HashMap<>();
            headers.put("Accept", "application/json, text/plain, */*");
            headers.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/77.0.3865.120 Safari/537.36");
            headers.put("Sec-Fetch-Mode", "cors");
            headers.put("Sec-Fetch-Site", "same-origin");
            String response = HttpClientUtil.get(uriBuilder.build().toString(), headers);
            GetSubmitVideoResponse submitVideoResponse = JacksonConvertUtil.jsonToObject(response, GetSubmitVideoResponse.class);
            // 总数
            int count = submitVideoResponse.getData().getTlist().get$36().getCount();
            int ceil = (int) Math.ceil(count / 50.0);
            ArrayList<GetSubmitVideoResponse.DataBean.VlistBean> vlistBeans = new ArrayList<>(submitVideoResponse.getData()
                    .getVlist());
            for (int i = 0; i < ceil; i++) {
                uriBuilder.setParameter("page", String.valueOf(i + 1));
                response = HttpClientUtil.get(uriBuilder.build().toString(), headers);
                submitVideoResponse = JacksonConvertUtil.jsonToObject(response, GetSubmitVideoResponse.class);
                vlistBeans.addAll(submitVideoResponse.getData().getVlist());
            }
            return vlistBeans;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<BilibiliAira2Data> startVideoDownload(String aid, String fileDir) {
        List<BilibiliAira2Data> dataList = Lists.newArrayList();
        try {
            URIBuilder uri = new URIBuilder(START_URL);
            uri.addParameter("aid", aid);
            HashMap<String, String> headers = new HashMap<>();
            headers.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/77.0.3865.120 Safari/537.36");
            String urlString = uri.build().toString();
            String response = HttpClientUtil.get(urlString, headers);
            VideoDetailResponse videoDetailResponse = JacksonConvertUtil.jsonToObject(response, VideoDetailResponse.class);
            List<VideoDetailResponse.DataBean.PagesBean> pages = videoDetailResponse.getData().getPages();
            int i = 1;
            for (VideoDetailResponse.DataBean.PagesBean item : pages) {
                int cid = item.getCid();
                String title = item.getPart().replaceAll("[/:*?\"<>|]", "");
                int page = item.getPage();
                String startUrl = urlString + "/?p=" + page;
                List<String> playList = getPlayList(startUrl, String.valueOf(cid), "80");
                int finalI = i;
                if (!CollectionUtils.isEmpty(playList)) {
                    List<BilibiliAira2Data> collect = playList.stream().map(s -> {
                        BilibiliAira2Data bilibiliAira2Data = new BilibiliAira2Data();
                        bilibiliAira2Data.setFileName(title + "-" + finalI + ".flv");
                        if (StringUtils.isEmpty(fileDir)) {
                            bilibiliAira2Data.setFileDir(this.fileDir);
                        } else {
                            bilibiliAira2Data.setFileDir(fileDir);
                        }
                        bilibiliAira2Data.setUri(s);
                        bilibiliAira2Data.setStartUri(startUrl);
                        return bilibiliAira2Data;
                    }).collect(Collectors.toList());
                    if (!collect.isEmpty()) {
                        dataList.addAll(collect);
                    }
                }
                i++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataList;
    }

    public void sendAria2(BilibiliAira2Data data) {
        Aria2Request aria2Request = Aria2Util.addUri(data);
    }

    public List<String> getPlayList(String uri, String cid, String quality) {
        try {
            URIBuilder uriBuilder = new URIBuilder(BILIBILI_INTERFACE);
            uriBuilder.addParameter("appkey", appKey);
            uriBuilder.addParameter("cid", cid);
            uriBuilder.addParameter("otype", "json");
            uriBuilder.addParameter("qn", quality);
            uriBuilder.addParameter("quality", quality);
            uriBuilder.addParameter("type", "");
            String params = "appkey=" + appKey + "&cid=" + cid + "&otype=json&qn=" + quality + "&quality=" + quality + "&type=";
            String sign = MD5Util.md5(params, secret);
            uriBuilder.addParameter("sign", sign);
            HashMap<String, String> headers = new HashMap<>();
            headers.put("Referer", uri);
            headers.put("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36");
            String response = HttpClientUtil.get(uriBuilder.build().toString(), headers);
            VideoDownloadResponse videoDownloadResponse = JacksonConvertUtil.jsonToObject(response, VideoDownloadResponse.class);
            return videoDownloadResponse.getDurl()
                    .stream()
                    .map(VideoDownloadResponse.DurlBean::getUrl)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Lists.newArrayList();
    }

    private ExecutorService executorService = Executors.newWorkStealingPool(10);

    public void synchronousSendAria2(List<BilibiliAira2Data> collect) {
        List<FutureTask<Aria2Request>> futureTasks = collect.stream()
                .map(Aria2DownloadTask::new)
                .map(FutureTask::new).collect(Collectors.toList());
        futureTasks.forEach(aria2RequestFutureTask -> executorService.submit(aria2RequestFutureTask));
        futureTasks.parallelStream().forEach(aria2RequestFutureTask -> {
            try {
                Aria2Request aria2Request = aria2RequestFutureTask.get();
                logger.info("{}：任务完成，aria2 Id:{}，执行时间：{}", aria2Request.getTitle(), aria2Request.getResult(), aria2Request
                        .getUseTime());
            } catch (InterruptedException | ExecutionException e) {
                logger.error("aria2同步下载异常：", e);
            }
        });
    }
}
