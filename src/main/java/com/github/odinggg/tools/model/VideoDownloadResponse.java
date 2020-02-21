package com.github.odinggg.tools.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * 描述:
 * 下载详情实体
 *
 * @author Hansen
 * @version 2019-11-05 16:58
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class VideoDownloadResponse {

    /**
     * from : local
     * result : suee
     * quality : 80
     * format : flv
     * timelength : 825578
     * accept_format : flv,flv720,flv480,flv360
     * accept_description : ["高清 1080P","高清 720P","清晰 480P","流畅 360P"]
     * accept_quality : [80,64,32,16]
     * video_codecid : 7
     * video_project : true
     * seek_param : start
     * seek_type : offset
     * durl : [{"order":1,"length":825578,"size":22544499,"url":"http://cn-hbsjz2-cmcc-bcache-11.acgvideo.com/upgcxcode/42/49/126664942/126664942-1-80.flv?e=ig8euxZM2rNcNbTa7WdVtWTa7WdVNEVEuCIv29hEn0lqXg8Y2ENvNCImNEVEUJ1miI7MT96fqj3E9r1qNCNEto8g2ENvN03eN0B5tZlqNxTEto8BTrNvNeZVuJ10Kj_g2UB02J0mN0B5tZlqNCNEto8BTrNvNC7MTX502C8f2jmMQJ6mqF2fka1mqx6gqj0eN0B599M=&deadline=1572951397&gen=playurl&nbs=1&oi=2029286349&os=bcache&platform=pc&trid=447385f38eb046bc8fd021a2cd8c7d91&uipk=5&upsig=edb3c1a667c04b455544b16af9bdf4f9&uparams=e,deadline,gen,nbs,oi,os,platform,trid,uipk&mid=0&origin_cdn=ks3","backup_url":["http://cn-hbsjz-cmcc-bcache-05.acgvideo.com/upgcxcode/42/49/126664942/126664942-1-80.flv?e=ig8euxZM2rNcNbTa7WdVtWTa7WdVNEVEuCIv29hEn0lqXg8Y2ENvNCImNEVEUJ1miI7MT96fqj3E9r1qNCNEto8g2ENvN03eN0B5tZlqNxTEto8BTrNvNeZVuJ10Kj_g2UB02J0mN0B5tZlqNCNEto8BTrNvNC7MTX502C8f2jmMQJ6mqF2fka1mqx6gqj0eN0B599M=&deadline=1572951397&gen=playurl&nbs=1&oi=2029286349&os=bcache&platform=pc&trid=447385f38eb046bc8fd021a2cd8c7d91&uipk=5&upsig=edb3c1a667c04b455544b16af9bdf4f9&uparams=e,deadline,gen,nbs,oi,os,platform,trid,uipk&mid=0&origin_cdn=ks3","http://cn-nmghhht-cmcc-bcache-09.acgvideo.com/upgcxcode/42/49/126664942/126664942-1-80.flv?e=ig8euxZM2rNcNbTa7WdVtWTa7WdVNEVEuCIv29hEn0lqXg8Y2ENvNCImNEVEUJ1miI7MT96fqj3E9r1qNCNEto8g2ENvN03eN0B5tZlqNxTEto8BTrNvNeZVuJ10Kj_g2UB02J0mN0B5tZlqNCNEto8BTrNvNC7MTX502C8f2jmMQJ6mqF2fka1mqx6gqj0eN0B599M=&deadline=1572951397&gen=playurl&nbs=1&oi=2029286349&os=bcache&platform=pc&trid=447385f38eb046bc8fd021a2cd8c7d91&uipk=5&upsig=edb3c1a667c04b455544b16af9bdf4f9&uparams=e,deadline,gen,nbs,oi,os,platform,trid,uipk&mid=0&origin_cdn=ks3"]}]
     */

    @JsonProperty("from")
    private String from;
    @JsonProperty("result")
    private String result;
    @JsonProperty("quality")
    private int quality;
    @JsonProperty("format")
    private String format;
    @JsonProperty("timelength")
    private int timelength;
    @JsonProperty("accept_format")
    private String acceptFormat;
    @JsonProperty("video_codecid")
    private int videoCodecid;
    @JsonProperty("video_project")
    private boolean videoProject;
    @JsonProperty("seek_param")
    private String seekParam;
    @JsonProperty("seek_type")
    private String seekType;
    @JsonProperty("accept_description")
    private List<String> acceptDescription;
    @JsonProperty("accept_quality")
    private List<Integer> acceptQuality;
    @JsonProperty("durl")
    private List<DurlBean> durl;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public int getTimelength() {
        return timelength;
    }

    public void setTimelength(int timelength) {
        this.timelength = timelength;
    }

    public String getAcceptFormat() {
        return acceptFormat;
    }

    public void setAcceptFormat(String acceptFormat) {
        this.acceptFormat = acceptFormat;
    }

    public int getVideoCodecid() {
        return videoCodecid;
    }

    public void setVideoCodecid(int videoCodecid) {
        this.videoCodecid = videoCodecid;
    }

    public boolean isVideoProject() {
        return videoProject;
    }

    public void setVideoProject(boolean videoProject) {
        this.videoProject = videoProject;
    }

    public String getSeekParam() {
        return seekParam;
    }

    public void setSeekParam(String seekParam) {
        this.seekParam = seekParam;
    }

    public String getSeekType() {
        return seekType;
    }

    public void setSeekType(String seekType) {
        this.seekType = seekType;
    }

    public List<String> getAcceptDescription() {
        return acceptDescription;
    }

    public void setAcceptDescription(List<String> acceptDescription) {
        this.acceptDescription = acceptDescription;
    }

    public List<Integer> getAcceptQuality() {
        return acceptQuality;
    }

    public void setAcceptQuality(List<Integer> acceptQuality) {
        this.acceptQuality = acceptQuality;
    }

    public List<DurlBean> getDurl() {
        return durl;
    }

    public void setDurl(List<DurlBean> durl) {
        this.durl = durl;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class DurlBean {
        /**
         * order : 1
         * length : 825578
         * size : 22544499
         * url : http://cn-hbsjz2-cmcc-bcache-11.acgvideo.com/upgcxcode/42/49/126664942/126664942-1-80.flv?e=ig8euxZM2rNcNbTa7WdVtWTa7WdVNEVEuCIv29hEn0lqXg8Y2ENvNCImNEVEUJ1miI7MT96fqj3E9r1qNCNEto8g2ENvN03eN0B5tZlqNxTEto8BTrNvNeZVuJ10Kj_g2UB02J0mN0B5tZlqNCNEto8BTrNvNC7MTX502C8f2jmMQJ6mqF2fka1mqx6gqj0eN0B599M=&deadline=1572951397&gen=playurl&nbs=1&oi=2029286349&os=bcache&platform=pc&trid=447385f38eb046bc8fd021a2cd8c7d91&uipk=5&upsig=edb3c1a667c04b455544b16af9bdf4f9&uparams=e,deadline,gen,nbs,oi,os,platform,trid,uipk&mid=0&origin_cdn=ks3
         * backup_url : ["http://cn-hbsjz-cmcc-bcache-05.acgvideo.com/upgcxcode/42/49/126664942/126664942-1-80.flv?e=ig8euxZM2rNcNbTa7WdVtWTa7WdVNEVEuCIv29hEn0lqXg8Y2ENvNCImNEVEUJ1miI7MT96fqj3E9r1qNCNEto8g2ENvN03eN0B5tZlqNxTEto8BTrNvNeZVuJ10Kj_g2UB02J0mN0B5tZlqNCNEto8BTrNvNC7MTX502C8f2jmMQJ6mqF2fka1mqx6gqj0eN0B599M=&deadline=1572951397&gen=playurl&nbs=1&oi=2029286349&os=bcache&platform=pc&trid=447385f38eb046bc8fd021a2cd8c7d91&uipk=5&upsig=edb3c1a667c04b455544b16af9bdf4f9&uparams=e,deadline,gen,nbs,oi,os,platform,trid,uipk&mid=0&origin_cdn=ks3","http://cn-nmghhht-cmcc-bcache-09.acgvideo.com/upgcxcode/42/49/126664942/126664942-1-80.flv?e=ig8euxZM2rNcNbTa7WdVtWTa7WdVNEVEuCIv29hEn0lqXg8Y2ENvNCImNEVEUJ1miI7MT96fqj3E9r1qNCNEto8g2ENvN03eN0B5tZlqNxTEto8BTrNvNeZVuJ10Kj_g2UB02J0mN0B5tZlqNCNEto8BTrNvNC7MTX502C8f2jmMQJ6mqF2fka1mqx6gqj0eN0B599M=&deadline=1572951397&gen=playurl&nbs=1&oi=2029286349&os=bcache&platform=pc&trid=447385f38eb046bc8fd021a2cd8c7d91&uipk=5&upsig=edb3c1a667c04b455544b16af9bdf4f9&uparams=e,deadline,gen,nbs,oi,os,platform,trid,uipk&mid=0&origin_cdn=ks3"]
         */

        @JsonProperty("order")
        private int order;
        @JsonProperty("length")
        private int length;
        @JsonProperty("size")
        private int size;
        @JsonProperty("url")
        private String url;
        @JsonProperty("backup_url")
        private List<String> backupUrl;

        public int getOrder() {
            return order;
        }

        public void setOrder(int order) {
            this.order = order;
        }

        public int getLength() {
            return length;
        }

        public void setLength(int length) {
            this.length = length;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public List<String> getBackupUrl() {
            return backupUrl;
        }

        public void setBackupUrl(List<String> backupUrl) {
            this.backupUrl = backupUrl;
        }
    }
}
