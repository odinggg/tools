package com.github.odinggg.tools.tasks;

import com.github.odinggg.tools.model.Aria2Request;
import com.github.odinggg.tools.model.Aria2StatusResponse;
import com.github.odinggg.tools.model.BilibiliAira2Data;
import com.github.odinggg.tools.util.Aria2Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Callable;

/**
 * 描述:
 *
 * @author Hansen
 * @version 2019-11-06 13:32
 */
public class Aria2DownloadTask implements Callable<Aria2Request> {

    private Logger logger = LoggerFactory.getLogger(Aria2DownloadTask.class);

    private BilibiliAira2Data data;

    public BilibiliAira2Data getData() {
        return data;
    }

    public void setData(BilibiliAira2Data data) {
        this.data = data;
    }

    public Aria2DownloadTask(BilibiliAira2Data data) {
        this.data = data;
    }

    @Override
    public Aria2Request call() throws Exception {
        try {
            Aria2Request aria2Request = Aria2Util.addUri(this.data);
            aria2Request.setTitle(this.data.getFileName());
            long start = System.currentTimeMillis();
            while (true) {
                Aria2StatusResponse aria2StatusResponse = Aria2Util.tellStatus(aria2Request.getResult());
                String status = aria2StatusResponse.getResult().getStatus();
                boolean b = status.equalsIgnoreCase(Aria2StatusResponse.STATUS_COMPLETE) || status.equalsIgnoreCase(Aria2StatusResponse.STATUS_ERROR) ||
                        status.equalsIgnoreCase(Aria2StatusResponse.STATUS_PAUSED) || status.equalsIgnoreCase(Aria2StatusResponse.STATUS_REMOVED);
                if (b) {
                    break;
                }
                Thread.sleep(1000);
            }
            long end = System.currentTimeMillis();
            aria2Request.setUseTime(String.valueOf((end - start) / 1000.00));
            return aria2Request;
        } catch (Exception e) {
            logger.error("aria2下载异常：", e);
            throw e;
        }
    }
}
