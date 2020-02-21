package com.github.odinggg.tools.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * 描述:
 *
 * @author Hansen
 * @version 2019-11-07 10:13
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Aria2StatusResponse {
    public static final String STATUS_ACTIVE = "active";
    public static final String STATUS_COMPLETE = "complete";
    public static final String STATUS_PAUSED = "paused";
    public static final String STATUS_ERROR = "error";
    public static final String STATUS_REMOVED = "removed";

    /**
     * id : 69b897bfd38f4c43935f3604721dcc44
     * jsonrpc : 2.0
     * result : {"completedLength":"0","connections":"1","dir":"./downloads","downloadSpeed":"0","files":[{"completedLength":"0","index":"1","length":"0","path":"","selected":"true","uris":[{"status":"used","uri":"https://mirrors.tuna.tsinghua.edu.cn/docker-ce/win/static/stable/x86_64/docker-17.06.1-ce.zip"},{"status":"waiting","uri":"https://mirrors.tuna.tsinghua.edu.cn/docker-ce/win/static/stable/x86_64/docker-17.06.1-ce.zip"},{"status":"waiting","uri":"https://mirrors.tuna.tsinghua.edu.cn/docker-ce/win/static/stable/x86_64/docker-17.06.1-ce.zip"},{"status":"waiting","uri":"https://mirrors.tuna.tsinghua.edu.cn/docker-ce/win/static/stable/x86_64/docker-17.06.1-ce.zip"},{"status":"waiting","uri":"https://mirrors.tuna.tsinghua.edu.cn/docker-ce/win/static/stable/x86_64/docker-17.06.1-ce.zip"}]}],"gid":"b61c39e7d320f05e","numPieces":"0","pieceLength":"1048576","status":"active","totalLength":"0","uploadLength":"0","uploadSpeed":"0"}
     */

    @JsonProperty("id")
    private String id;
    @JsonProperty("jsonrpc")
    private String jsonrpc;
    @JsonProperty("result")
    private ResultBean result;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJsonrpc() {
        return jsonrpc;
    }

    public void setJsonrpc(String jsonrpc) {
        this.jsonrpc = jsonrpc;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ResultBean {
        /**
         * completedLength : 0
         * connections : 1
         * dir : ./downloads
         * downloadSpeed : 0
         * files : [{"completedLength":"0","index":"1","length":"0","path":"","selected":"true","uris":[{"status":"used","uri":"https://mirrors.tuna.tsinghua.edu.cn/docker-ce/win/static/stable/x86_64/docker-17.06.1-ce.zip"},{"status":"waiting","uri":"https://mirrors.tuna.tsinghua.edu.cn/docker-ce/win/static/stable/x86_64/docker-17.06.1-ce.zip"},{"status":"waiting","uri":"https://mirrors.tuna.tsinghua.edu.cn/docker-ce/win/static/stable/x86_64/docker-17.06.1-ce.zip"},{"status":"waiting","uri":"https://mirrors.tuna.tsinghua.edu.cn/docker-ce/win/static/stable/x86_64/docker-17.06.1-ce.zip"},{"status":"waiting","uri":"https://mirrors.tuna.tsinghua.edu.cn/docker-ce/win/static/stable/x86_64/docker-17.06.1-ce.zip"}]}]
         * gid : b61c39e7d320f05e
         * numPieces : 0
         * pieceLength : 1048576
         * status : active
         * totalLength : 0
         * uploadLength : 0
         * uploadSpeed : 0
         */

        @JsonProperty("completedLength")
        private String completedLength;
        @JsonProperty("connections")
        private String connections;
        @JsonProperty("dir")
        private String dir;
        @JsonProperty("downloadSpeed")
        private String downloadSpeed;
        @JsonProperty("gid")
        private String gid;
        @JsonProperty("numPieces")
        private String numPieces;
        @JsonProperty("pieceLength")
        private String pieceLength;
        @JsonProperty("status")
        private String status;
        @JsonProperty("totalLength")
        private String totalLength;
        @JsonProperty("uploadLength")
        private String uploadLength;
        @JsonProperty("uploadSpeed")
        private String uploadSpeed;
        @JsonProperty("files")
        private List<FilesBean> files;

        public String getCompletedLength() {
            return completedLength;
        }

        public void setCompletedLength(String completedLength) {
            this.completedLength = completedLength;
        }

        public String getConnections() {
            return connections;
        }

        public void setConnections(String connections) {
            this.connections = connections;
        }

        public String getDir() {
            return dir;
        }

        public void setDir(String dir) {
            this.dir = dir;
        }

        public String getDownloadSpeed() {
            return downloadSpeed;
        }

        public void setDownloadSpeed(String downloadSpeed) {
            this.downloadSpeed = downloadSpeed;
        }

        public String getGid() {
            return gid;
        }

        public void setGid(String gid) {
            this.gid = gid;
        }

        public String getNumPieces() {
            return numPieces;
        }

        public void setNumPieces(String numPieces) {
            this.numPieces = numPieces;
        }

        public String getPieceLength() {
            return pieceLength;
        }

        public void setPieceLength(String pieceLength) {
            this.pieceLength = pieceLength;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getTotalLength() {
            return totalLength;
        }

        public void setTotalLength(String totalLength) {
            this.totalLength = totalLength;
        }

        public String getUploadLength() {
            return uploadLength;
        }

        public void setUploadLength(String uploadLength) {
            this.uploadLength = uploadLength;
        }

        public String getUploadSpeed() {
            return uploadSpeed;
        }

        public void setUploadSpeed(String uploadSpeed) {
            this.uploadSpeed = uploadSpeed;
        }

        public List<FilesBean> getFiles() {
            return files;
        }

        public void setFiles(List<FilesBean> files) {
            this.files = files;
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class FilesBean {
            /**
             * completedLength : 0
             * index : 1
             * length : 0
             * path :
             * selected : true
             * uris : [{"status":"used","uri":"https://mirrors.tuna.tsinghua.edu.cn/docker-ce/win/static/stable/x86_64/docker-17.06.1-ce.zip"},{"status":"waiting","uri":"https://mirrors.tuna.tsinghua.edu.cn/docker-ce/win/static/stable/x86_64/docker-17.06.1-ce.zip"},{"status":"waiting","uri":"https://mirrors.tuna.tsinghua.edu.cn/docker-ce/win/static/stable/x86_64/docker-17.06.1-ce.zip"},{"status":"waiting","uri":"https://mirrors.tuna.tsinghua.edu.cn/docker-ce/win/static/stable/x86_64/docker-17.06.1-ce.zip"},{"status":"waiting","uri":"https://mirrors.tuna.tsinghua.edu.cn/docker-ce/win/static/stable/x86_64/docker-17.06.1-ce.zip"}]
             */

            @JsonProperty("completedLength")
            private String completedLength;
            @JsonProperty("index")
            private String index;
            @JsonProperty("length")
            private String length;
            @JsonProperty("path")
            private String path;
            @JsonProperty("selected")
            private String selected;
            @JsonProperty("uris")
            private List<UrisBean> uris;

            public String getCompletedLength() {
                return completedLength;
            }

            public void setCompletedLength(String completedLength) {
                this.completedLength = completedLength;
            }

            public String getIndex() {
                return index;
            }

            public void setIndex(String index) {
                this.index = index;
            }

            public String getLength() {
                return length;
            }

            public void setLength(String length) {
                this.length = length;
            }

            public String getPath() {
                return path;
            }

            public void setPath(String path) {
                this.path = path;
            }

            public String getSelected() {
                return selected;
            }

            public void setSelected(String selected) {
                this.selected = selected;
            }

            public List<UrisBean> getUris() {
                return uris;
            }

            public void setUris(List<UrisBean> uris) {
                this.uris = uris;
            }

            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class UrisBean {
                /**
                 * status : used
                 * uri : https://mirrors.tuna.tsinghua.edu.cn/docker-ce/win/static/stable/x86_64/docker-17.06.1-ce.zip
                 */

                @JsonProperty("status")
                private String status;
                @JsonProperty("uri")
                private String uri;

                public String getStatus() {
                    return status;
                }

                public void setStatus(String status) {
                    this.status = status;
                }

                public String getUri() {
                    return uri;
                }

                public void setUri(String uri) {
                    this.uri = uri;
                }
            }
        }
    }
}
