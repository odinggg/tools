package com.github.odinggg.tools.controller;

import com.github.odinggg.tools.bilibili.BilibiliVedioDownload;
import com.github.odinggg.tools.model.BilibiliAira2Data;
import com.github.odinggg.tools.model.GetSubmitVideoResponse;
import com.github.odinggg.tools.model.Text;
import com.github.odinggg.tools.service.ToolService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 描述:
 *
 * @author Hansen
 * @version 2019-11-06 13:12
 */
@RestController
public class MainController {
    private Logger logger = LoggerFactory.getLogger(MainController.class);
    @Autowired
    private BilibiliVedioDownload bilibiliVedioDownload;
    @Autowired
    private ToolService toolService;

    @GetMapping("/download/bilibili/{mid}")
    public Object downBilibiliVedio(@PathVariable String mid, @RequestParam(required = false) String num) {
        HashMap<String, Object> result = new HashMap<>();
        try {
            List<GetSubmitVideoResponse.DataBean.VlistBean> downloadUrl = bilibiliVedioDownload.getDownloadUrl(mid);
            List<BilibiliAira2Data> collect = null;
            if (StringUtils.isEmpty(num)) {
                GetSubmitVideoResponse.DataBean.VlistBean vlistBean = downloadUrl.get(0);
                collect = bilibiliVedioDownload.startVideoDownload(String.valueOf(vlistBean.getAid()), null);
            } else if (num.equalsIgnoreCase("xxx")) {
                if (!CollectionUtils.isEmpty(downloadUrl)) {
                    collect = downloadUrl.stream().flatMap(vlistBean -> {
                        List<BilibiliAira2Data> dataList = bilibiliVedioDownload.startVideoDownload(String.valueOf(vlistBean
                                .getAid()), null);
                        if (!CollectionUtils.isEmpty(dataList)) {
                            return dataList.stream();
                        } else {
                            return null;
                        }
                    }).filter(Objects::nonNull).collect(Collectors.toList());
                }
            } else {
                collect = downloadUrl.subList(0, Integer.parseInt(num)).stream().flatMap(vlistBean -> {
                    List<BilibiliAira2Data> dataList = bilibiliVedioDownload.startVideoDownload(String.valueOf(vlistBean
                            .getAid()), null);
                    if (!CollectionUtils.isEmpty(dataList)) {
                        return dataList.stream();
                    } else {
                        return null;
                    }
                }).filter(Objects::nonNull).collect(Collectors.toList());
            }
            if (!CollectionUtils.isEmpty(collect)) {
                bilibiliVedioDownload.synchronousSendAria2(collect);
            }
            result.put("status", 200);
            result.put("message", "success");
        } catch (Exception e) {
            logger.error("bilibili视频下载异常");
        }
        return result;
    }

    @GetMapping("/download/bilibili/aid/{aid}")
    public Object downBilibiliVedioByAid(@PathVariable String aid, @RequestParam(required = false) String filePath) {
        HashMap<String, Object> result = new HashMap<>();
        try {
            List<BilibiliAira2Data> dataList = bilibiliVedioDownload.startVideoDownload(aid, filePath);
            bilibiliVedioDownload.synchronousSendAria2(dataList);
            result.put("status", 200);
            result.put("message", "success");
        } catch (Exception e) {
            logger.error("bilibili视频下载异常");
        }
        return result;
    }

    @PostMapping("/yml2properties")
    public Object yml2properties(@RequestBody Text text) {
        try {
            return toolService.yml2properties(text.getContent());
        } catch (Exception e) {
            logger.error("yml转properties异常", e);
            return null;
        }
    }

    @PostMapping("/properties2yml")
    public Object properties2yml(@RequestBody Text text) {
        try {
            return toolService.properties2yml(text.getContent());
        } catch (Exception e) {
            logger.error("yml转properties异常", e);
            return null;
        }
    }

    @PostMapping("/wechatArticle2PDF")
    public ByteBuffer wechatArticle2PDF(String url) {
        try {
            return toolService.wechatArticle2PDF(url);
        } catch (Exception e) {
            logger.error("yml转properties异常", e);
            return null;
        }
    }
}
