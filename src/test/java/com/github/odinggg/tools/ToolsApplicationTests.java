package com.github.odinggg.tools;

import com.github.odinggg.tools.bilibili.BilibiliVedioDownload;
import com.github.odinggg.tools.enums.HttpParamEnum;
import com.github.odinggg.tools.model.Aria2Request;
import com.github.odinggg.tools.model.BilibiliAira2Data;
import com.github.odinggg.tools.model.GetSubmitVideoResponse;
import com.github.odinggg.tools.model.WorkWeChatMessage;
import com.github.odinggg.tools.model.WorkWeChatResponse;
import com.github.odinggg.tools.tasks.Aria2DownloadTask;
import com.github.odinggg.tools.util.JacksonConvertUtil;
import com.github.odinggg.tools.wechat.WorkWeChatInterface;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ToolsApplicationTests {
    private Logger logger = LoggerFactory.getLogger(ToolsApplicationTests.class);

    @Test
    public void contextLoads() {
    }

    @Test
    public void test1() {
        String s = "从Tumblr来的优秀原创博主们";
        boolean matches = s.matches("^从Tumblr来的优秀原创博主们$");
        System.out.println(matches);
    }

    @Autowired
    private BilibiliVedioDownload bilibiliVedioDownload;

    @Test
    public void test2() {
        List<GetSubmitVideoResponse.DataBean.VlistBean> downloadUrl = bilibiliVedioDownload.getDownloadUrl("362268332");
        int aid = downloadUrl.get(0).getAid();
        List<BilibiliAira2Data> dataList = bilibiliVedioDownload.startVideoDownload(String.valueOf(aid), null);
        dataList.forEach(data -> bilibiliVedioDownload.sendAria2(data));
    }

    private ExecutorService executorService = Executors.newWorkStealingPool(10);

    @Test
    public void test3() {
        ArrayList<BilibiliAira2Data> collect = new ArrayList<>();
        for (int i = 0; i < 35; i++) {
            BilibiliAira2Data bilibiliAira2Data = new BilibiliAira2Data();
            bilibiliAira2Data.setUri("" + i);
            bilibiliAira2Data.setStartUri("" + i);
            bilibiliAira2Data.setFileName("" + i);
            bilibiliAira2Data.setFileDir("" + i);
            collect.add(bilibiliAira2Data);
        }

        List<FutureTask<Aria2Request>> futureTasks = collect.stream()
                .map(Aria2DownloadTask::new)
                .map(FutureTask::new).collect(Collectors.toList());
        futureTasks.forEach(aria2RequestFutureTask -> executorService.submit(aria2RequestFutureTask));
        futureTasks.parallelStream().forEach(aria2RequestFutureTask -> {
            try {
                Aria2Request aria2Request = aria2RequestFutureTask.get();
                logger.info("{}：任务完成，aria2 Id:{}", aria2Request.getTitle(), aria2Request.getResult());
            } catch (InterruptedException | ExecutionException e) {
                logger.error("aria2同步下载异常：", e);
            }
        });
        System.out.println("hhh");
    }

    @Test
    public void test4() {
        List<GetSubmitVideoResponse.DataBean.VlistBean> downloadUrl = bilibiliVedioDownload.getDownloadUrl("362268332");
        if (!CollectionUtils.isEmpty(downloadUrl)) {
//            List<BilibiliAira2Data> collect = downloadUrl.stream().flatMap(vlistBean -> {
//                List<BilibiliAira2Data> dataList = bilibiliVedioDownload.startVideoDownload(String.valueOf(vlistBean.getAid()));
//                if (!CollectionUtils.isEmpty(dataList)) {
//                    return dataList.stream();
//                } else {
//                    return null;
//                }
//            }).filter(Objects::nonNull).collect(Collectors.toList());
            GetSubmitVideoResponse.DataBean.VlistBean vlistBean = downloadUrl.get(0);
            List<BilibiliAira2Data> collect = bilibiliVedioDownload.startVideoDownload(String.valueOf(vlistBean.getAid()), null);
            List<BilibiliAira2Data> dataList = collect.subList(0, 1);
            bilibiliVedioDownload.synchronousSendAria2(dataList);
        }
    }

    @Autowired
    private Configuration configuration;

    @Test
    public void test5() {
        Map<HttpParamEnum, Configuration.Param> httpParam = configuration.getHttpParam();
        Configuration.Param param = httpParam.get(HttpParamEnum.WORK_WECHAT_SEND);
        System.out.println(JacksonConvertUtil.objectToJson(param));
    }

    @Autowired
    private WorkWeChatInterface workWeChatInterface;

    @Test
    public void test6() {
        WorkWeChatMessage workWeChatMessage = new WorkWeChatMessage();
        WorkWeChatMessage.TextBean textBean = new WorkWeChatMessage.TextBean();
        textBean.setContent("jlkajlkajlk ");
        workWeChatMessage.setText(textBean);
        WorkWeChatResponse workWeChatResponse = workWeChatInterface.sendMessage(workWeChatMessage);
        System.out.println(JacksonConvertUtil.objectToJson(workWeChatResponse));
    }
}

