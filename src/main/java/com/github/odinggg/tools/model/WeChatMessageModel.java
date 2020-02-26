package com.github.odinggg.tools.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * 描述:
 * 微信消息实体
 *
 * @author QinHaoChun
 * @version 2020-02-26 9:40
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeChatMessageModel {

    /**
     * BaseResponse : {"Ret":0,"ErrMsg":""}
     * AddMsgCount : 1
     * AddMsgList : [{"MsgId":"7359156884180255876","FromUserName":"@753f1c7de5909fb02cbf3f83d172c5f8cd66cef753d856ef81c28e110714e120","ToUserName":"@26f33d504c49e1a11bb477aca7723cf2","MsgType":1,"Content":"å˜»å˜»","Status":3,"ImgStatus":1,"CreateTime":1582681535,"VoiceLength":0,"PlayLength":0,"FileName":"","FileSize":"","MediaId":"","Url":"","AppMsgType":0,"StatusNotifyCode":0,"StatusNotifyUserName":"","RecommendInfo":{"UserName":"","NickName":"","QQNum":0,"Province":"","City":"","Content":"","Signature":"","Alias":"","Scene":0,"VerifyFlag":0,"AttrStatus":0,"Sex":0,"Ticket":"","OpCode":0},"ForwardFlag":0,"AppInfo":{"AppID":"","Type":0},"HasProductId":0,"Ticket":"","ImgHeight":0,"ImgWidth":0,"SubMsgType":0,"NewMsgId":7359156884180255876,"OriContent":"","EncryFileName":""}]
     * ModContactCount : 0
     * ModContactList : []
     * DelContactCount : 0
     * DelContactList : []
     * ModChatRoomMemberCount : 0
     * ModChatRoomMemberList : []
     * Profile : {"BitFlag":0,"UserName":{"Buff":""},"NickName":{"Buff":""},"BindUin":0,"BindEmail":{"Buff":""},"BindMobile":{"Buff":""},"Status":0,"Sex":0,"PersonalCard":0,"Alias":"","HeadImgUpdateFlag":0,"HeadImgUrl":"","Signature":""}
     * ContinueFlag : 0
     * SyncKey : {"Count":9,"List":[{"Key":1,"Val":709863874},{"Key":2,"Val":709863971},{"Key":3,"Val":709863952},{"Key":11,"Val":709863506},{"Key":19,"Val":194},{"Key":201,"Val":1582681535},{"Key":206,"Val":1},{"Key":1000,"Val":1582675945},{"Key":1001,"Val":1582675949}]}
     * SKey :
     * SyncCheckKey : {"Count":9,"List":[{"Key":1,"Val":709863874},{"Key":2,"Val":709863971},{"Key":3,"Val":709863952},{"Key":11,"Val":709863506},{"Key":19,"Val":194},{"Key":201,"Val":1582681535},{"Key":206,"Val":1},{"Key":1000,"Val":1582675945},{"Key":1001,"Val":1582675949}]}
     */

    @JsonProperty("BaseResponse")
    private BaseResponseBean BaseResponse;
    @JsonProperty("AddMsgCount")
    private int AddMsgCount;
    @JsonProperty("ModContactCount")
    private int ModContactCount;
    @JsonProperty("DelContactCount")
    private int DelContactCount;
    @JsonProperty("ModChatRoomMemberCount")
    private int ModChatRoomMemberCount;
    @JsonProperty("Profile")
    private ProfileBean Profile;
    @JsonProperty("ContinueFlag")
    private int ContinueFlag;
    @JsonProperty("SyncKey")
    private WeChatModel.SyncKeyBean SyncKey;
    @JsonProperty("SKey")
    private String SKey;
    @JsonProperty("SyncCheckKey")
    private WeChatModel.SyncKeyBean SyncCheckKey;
    @JsonProperty("AddMsgList")
    private List<AddMsgListBean> AddMsgList;
    @JsonProperty("ModContactList")
    private List<?> ModContactList;
    @JsonProperty("DelContactList")
    private List<?> DelContactList;
    @JsonProperty("ModChatRoomMemberList")
    private List<?> ModChatRoomMemberList;

    public BaseResponseBean getBaseResponse() {
        return BaseResponse;
    }

    public void setBaseResponse(BaseResponseBean BaseResponse) {
        this.BaseResponse = BaseResponse;
    }

    public int getAddMsgCount() {
        return AddMsgCount;
    }

    public void setAddMsgCount(int AddMsgCount) {
        this.AddMsgCount = AddMsgCount;
    }

    public int getModContactCount() {
        return ModContactCount;
    }

    public void setModContactCount(int ModContactCount) {
        this.ModContactCount = ModContactCount;
    }

    public int getDelContactCount() {
        return DelContactCount;
    }

    public void setDelContactCount(int DelContactCount) {
        this.DelContactCount = DelContactCount;
    }

    public int getModChatRoomMemberCount() {
        return ModChatRoomMemberCount;
    }

    public void setModChatRoomMemberCount(int ModChatRoomMemberCount) {
        this.ModChatRoomMemberCount = ModChatRoomMemberCount;
    }

    public ProfileBean getProfile() {
        return Profile;
    }

    public void setProfile(ProfileBean Profile) {
        this.Profile = Profile;
    }

    public int getContinueFlag() {
        return ContinueFlag;
    }

    public void setContinueFlag(int ContinueFlag) {
        this.ContinueFlag = ContinueFlag;
    }

    public WeChatModel.SyncKeyBean getSyncKey() {
        return SyncKey;
    }

    public void setSyncKey(WeChatModel.SyncKeyBean SyncKey) {
        this.SyncKey = SyncKey;
    }

    public String getSKey() {
        return SKey;
    }

    public void setSKey(String SKey) {
        this.SKey = SKey;
    }

    public WeChatModel.SyncKeyBean getSyncCheckKey() {
        return SyncCheckKey;
    }

    public void setSyncCheckKey(WeChatModel.SyncKeyBean SyncCheckKey) {
        this.SyncCheckKey = SyncCheckKey;
    }

    public List<AddMsgListBean> getAddMsgList() {
        return AddMsgList;
    }

    public void setAddMsgList(List<AddMsgListBean> AddMsgList) {
        this.AddMsgList = AddMsgList;
    }

    public List<?> getModContactList() {
        return ModContactList;
    }

    public void setModContactList(List<?> ModContactList) {
        this.ModContactList = ModContactList;
    }

    public List<?> getDelContactList() {
        return DelContactList;
    }

    public void setDelContactList(List<?> DelContactList) {
        this.DelContactList = DelContactList;
    }

    public List<?> getModChatRoomMemberList() {
        return ModChatRoomMemberList;
    }

    public void setModChatRoomMemberList(List<?> ModChatRoomMemberList) {
        this.ModChatRoomMemberList = ModChatRoomMemberList;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class BaseResponseBean {
        /**
         * Ret : 0
         * ErrMsg :
         */

        @JsonProperty("Ret")
        private int Ret;
        @JsonProperty("ErrMsg")
        private String ErrMsg;

        public int getRet() {
            return Ret;
        }

        public void setRet(int Ret) {
            this.Ret = Ret;
        }

        public String getErrMsg() {
            return ErrMsg;
        }

        public void setErrMsg(String ErrMsg) {
            this.ErrMsg = ErrMsg;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ProfileBean {
        /**
         * BitFlag : 0
         * UserName : {"Buff":""}
         * NickName : {"Buff":""}
         * BindUin : 0
         * BindEmail : {"Buff":""}
         * BindMobile : {"Buff":""}
         * Status : 0
         * Sex : 0
         * PersonalCard : 0
         * Alias :
         * HeadImgUpdateFlag : 0
         * HeadImgUrl :
         * Signature :
         */

        @JsonProperty("BitFlag")
        private int BitFlag;
        @JsonProperty("UserName")
        private UserNameBean UserName;
        @JsonProperty("NickName")
        private NickNameBean NickName;
        @JsonProperty("BindUin")
        private int BindUin;
        @JsonProperty("BindEmail")
        private BindEmailBean BindEmail;
        @JsonProperty("BindMobile")
        private BindMobileBean BindMobile;
        @JsonProperty("Status")
        private int Status;
        @JsonProperty("Sex")
        private int Sex;
        @JsonProperty("PersonalCard")
        private int PersonalCard;
        @JsonProperty("Alias")
        private String Alias;
        @JsonProperty("HeadImgUpdateFlag")
        private int HeadImgUpdateFlag;
        @JsonProperty("HeadImgUrl")
        private String HeadImgUrl;
        @JsonProperty("Signature")
        private String Signature;

        public int getBitFlag() {
            return BitFlag;
        }

        public void setBitFlag(int BitFlag) {
            this.BitFlag = BitFlag;
        }

        public UserNameBean getUserName() {
            return UserName;
        }

        public void setUserName(UserNameBean UserName) {
            this.UserName = UserName;
        }

        public NickNameBean getNickName() {
            return NickName;
        }

        public void setNickName(NickNameBean NickName) {
            this.NickName = NickName;
        }

        public int getBindUin() {
            return BindUin;
        }

        public void setBindUin(int BindUin) {
            this.BindUin = BindUin;
        }

        public BindEmailBean getBindEmail() {
            return BindEmail;
        }

        public void setBindEmail(BindEmailBean BindEmail) {
            this.BindEmail = BindEmail;
        }

        public BindMobileBean getBindMobile() {
            return BindMobile;
        }

        public void setBindMobile(BindMobileBean BindMobile) {
            this.BindMobile = BindMobile;
        }

        public int getStatus() {
            return Status;
        }

        public void setStatus(int Status) {
            this.Status = Status;
        }

        public int getSex() {
            return Sex;
        }

        public void setSex(int Sex) {
            this.Sex = Sex;
        }

        public int getPersonalCard() {
            return PersonalCard;
        }

        public void setPersonalCard(int PersonalCard) {
            this.PersonalCard = PersonalCard;
        }

        public String getAlias() {
            return Alias;
        }

        public void setAlias(String Alias) {
            this.Alias = Alias;
        }

        public int getHeadImgUpdateFlag() {
            return HeadImgUpdateFlag;
        }

        public void setHeadImgUpdateFlag(int HeadImgUpdateFlag) {
            this.HeadImgUpdateFlag = HeadImgUpdateFlag;
        }

        public String getHeadImgUrl() {
            return HeadImgUrl;
        }

        public void setHeadImgUrl(String HeadImgUrl) {
            this.HeadImgUrl = HeadImgUrl;
        }

        public String getSignature() {
            return Signature;
        }

        public void setSignature(String Signature) {
            this.Signature = Signature;
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class UserNameBean {
            /**
             * Buff :
             */

            @JsonProperty("Buff")
            private String Buff;

            public String getBuff() {
                return Buff;
            }

            public void setBuff(String Buff) {
                this.Buff = Buff;
            }
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class NickNameBean {
            /**
             * Buff :
             */

            @JsonProperty("Buff")
            private String Buff;

            public String getBuff() {
                return Buff;
            }

            public void setBuff(String Buff) {
                this.Buff = Buff;
            }
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class BindEmailBean {
            /**
             * Buff :
             */

            @JsonProperty("Buff")
            private String Buff;

            public String getBuff() {
                return Buff;
            }

            public void setBuff(String Buff) {
                this.Buff = Buff;
            }
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class BindMobileBean {
            /**
             * Buff :
             */

            @JsonProperty("Buff")
            private String Buff;

            public String getBuff() {
                return Buff;
            }

            public void setBuff(String Buff) {
                this.Buff = Buff;
            }
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class AddMsgListBean {
        /**
         * MsgId : 7359156884180255876
         * FromUserName : @753f1c7de5909fb02cbf3f83d172c5f8cd66cef753d856ef81c28e110714e120
         * ToUserName : @26f33d504c49e1a11bb477aca7723cf2
         * MsgType : 1
         * Content : å˜»å˜»
         * Status : 3
         * ImgStatus : 1
         * CreateTime : 1582681535
         * VoiceLength : 0
         * PlayLength : 0
         * FileName :
         * FileSize :
         * MediaId :
         * Url :
         * AppMsgType : 0
         * StatusNotifyCode : 0
         * StatusNotifyUserName :
         * RecommendInfo : {"UserName":"","NickName":"","QQNum":0,"Province":"","City":"","Content":"","Signature":"","Alias":"","Scene":0,"VerifyFlag":0,"AttrStatus":0,"Sex":0,"Ticket":"","OpCode":0}
         * ForwardFlag : 0
         * AppInfo : {"AppID":"","Type":0}
         * HasProductId : 0
         * Ticket :
         * ImgHeight : 0
         * ImgWidth : 0
         * SubMsgType : 0
         * NewMsgId : 7359156884180255876
         * OriContent :
         * EncryFileName :
         */

        @JsonProperty("MsgId")
        private String MsgId;
        @JsonProperty("FromUserName")
        private String FromUserName;
        @JsonProperty("ToUserName")
        private String ToUserName;
        @JsonProperty("MsgType")
        private int MsgType;
        @JsonProperty("Content")
        private String Content;
        @JsonProperty("Status")
        private int Status;
        @JsonProperty("ImgStatus")
        private int ImgStatus;
        @JsonProperty("CreateTime")
        private int CreateTime;
        @JsonProperty("VoiceLength")
        private int VoiceLength;
        @JsonProperty("PlayLength")
        private int PlayLength;
        @JsonProperty("FileName")
        private String FileName;
        @JsonProperty("FileSize")
        private String FileSize;
        @JsonProperty("MediaId")
        private String MediaId;
        @JsonProperty("Url")
        private String Url;
        @JsonProperty("AppMsgType")
        private int AppMsgType;
        @JsonProperty("StatusNotifyCode")
        private int StatusNotifyCode;
        @JsonProperty("StatusNotifyUserName")
        private String StatusNotifyUserName;
        @JsonProperty("RecommendInfo")
        private RecommendInfoBean RecommendInfo;
        @JsonProperty("ForwardFlag")
        private int ForwardFlag;
        @JsonProperty("AppInfo")
        private AppInfoBean AppInfo;
        @JsonProperty("HasProductId")
        private int HasProductId;
        @JsonProperty("Ticket")
        private String Ticket;
        @JsonProperty("ImgHeight")
        private int ImgHeight;
        @JsonProperty("ImgWidth")
        private int ImgWidth;
        @JsonProperty("SubMsgType")
        private int SubMsgType;
        @JsonProperty("NewMsgId")
        private long NewMsgId;
        @JsonProperty("OriContent")
        private String OriContent;
        @JsonProperty("EncryFileName")
        private String EncryFileName;

        public String getMsgId() {
            return MsgId;
        }

        public void setMsgId(String MsgId) {
            this.MsgId = MsgId;
        }

        public String getFromUserName() {
            return FromUserName;
        }

        public void setFromUserName(String FromUserName) {
            this.FromUserName = FromUserName;
        }

        public String getToUserName() {
            return ToUserName;
        }

        public void setToUserName(String ToUserName) {
            this.ToUserName = ToUserName;
        }

        public int getMsgType() {
            return MsgType;
        }

        public void setMsgType(int MsgType) {
            this.MsgType = MsgType;
        }

        public String getContent() {
            return Content;
        }

        public void setContent(String Content) {
            this.Content = Content;
        }

        public int getStatus() {
            return Status;
        }

        public void setStatus(int Status) {
            this.Status = Status;
        }

        public int getImgStatus() {
            return ImgStatus;
        }

        public void setImgStatus(int ImgStatus) {
            this.ImgStatus = ImgStatus;
        }

        public int getCreateTime() {
            return CreateTime;
        }

        public void setCreateTime(int CreateTime) {
            this.CreateTime = CreateTime;
        }

        public int getVoiceLength() {
            return VoiceLength;
        }

        public void setVoiceLength(int VoiceLength) {
            this.VoiceLength = VoiceLength;
        }

        public int getPlayLength() {
            return PlayLength;
        }

        public void setPlayLength(int PlayLength) {
            this.PlayLength = PlayLength;
        }

        public String getFileName() {
            return FileName;
        }

        public void setFileName(String FileName) {
            this.FileName = FileName;
        }

        public String getFileSize() {
            return FileSize;
        }

        public void setFileSize(String FileSize) {
            this.FileSize = FileSize;
        }

        public String getMediaId() {
            return MediaId;
        }

        public void setMediaId(String MediaId) {
            this.MediaId = MediaId;
        }

        public String getUrl() {
            return Url;
        }

        public void setUrl(String Url) {
            this.Url = Url;
        }

        public int getAppMsgType() {
            return AppMsgType;
        }

        public void setAppMsgType(int AppMsgType) {
            this.AppMsgType = AppMsgType;
        }

        public int getStatusNotifyCode() {
            return StatusNotifyCode;
        }

        public void setStatusNotifyCode(int StatusNotifyCode) {
            this.StatusNotifyCode = StatusNotifyCode;
        }

        public String getStatusNotifyUserName() {
            return StatusNotifyUserName;
        }

        public void setStatusNotifyUserName(String StatusNotifyUserName) {
            this.StatusNotifyUserName = StatusNotifyUserName;
        }

        public RecommendInfoBean getRecommendInfo() {
            return RecommendInfo;
        }

        public void setRecommendInfo(RecommendInfoBean RecommendInfo) {
            this.RecommendInfo = RecommendInfo;
        }

        public int getForwardFlag() {
            return ForwardFlag;
        }

        public void setForwardFlag(int ForwardFlag) {
            this.ForwardFlag = ForwardFlag;
        }

        public AppInfoBean getAppInfo() {
            return AppInfo;
        }

        public void setAppInfo(AppInfoBean AppInfo) {
            this.AppInfo = AppInfo;
        }

        public int getHasProductId() {
            return HasProductId;
        }

        public void setHasProductId(int HasProductId) {
            this.HasProductId = HasProductId;
        }

        public String getTicket() {
            return Ticket;
        }

        public void setTicket(String Ticket) {
            this.Ticket = Ticket;
        }

        public int getImgHeight() {
            return ImgHeight;
        }

        public void setImgHeight(int ImgHeight) {
            this.ImgHeight = ImgHeight;
        }

        public int getImgWidth() {
            return ImgWidth;
        }

        public void setImgWidth(int ImgWidth) {
            this.ImgWidth = ImgWidth;
        }

        public int getSubMsgType() {
            return SubMsgType;
        }

        public void setSubMsgType(int SubMsgType) {
            this.SubMsgType = SubMsgType;
        }

        public long getNewMsgId() {
            return NewMsgId;
        }

        public void setNewMsgId(long NewMsgId) {
            this.NewMsgId = NewMsgId;
        }

        public String getOriContent() {
            return OriContent;
        }

        public void setOriContent(String OriContent) {
            this.OriContent = OriContent;
        }

        public String getEncryFileName() {
            return EncryFileName;
        }

        public void setEncryFileName(String EncryFileName) {
            this.EncryFileName = EncryFileName;
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class RecommendInfoBean {
            /**
             * UserName :
             * NickName :
             * QQNum : 0
             * Province :
             * City :
             * Content :
             * Signature :
             * Alias :
             * Scene : 0
             * VerifyFlag : 0
             * AttrStatus : 0
             * Sex : 0
             * Ticket :
             * OpCode : 0
             */

            @JsonProperty("UserName")
            private String UserName;
            @JsonProperty("NickName")
            private String NickName;
            @JsonProperty("QQNum")
            private int QQNum;
            @JsonProperty("Province")
            private String Province;
            @JsonProperty("City")
            private String City;
            @JsonProperty("Content")
            private String Content;
            @JsonProperty("Signature")
            private String Signature;
            @JsonProperty("Alias")
            private String Alias;
            @JsonProperty("Scene")
            private int Scene;
            @JsonProperty("VerifyFlag")
            private int VerifyFlag;
            @JsonProperty("AttrStatus")
            private int AttrStatus;
            @JsonProperty("Sex")
            private int Sex;
            @JsonProperty("Ticket")
            private String Ticket;
            @JsonProperty("OpCode")
            private int OpCode;

            public String getUserName() {
                return UserName;
            }

            public void setUserName(String UserName) {
                this.UserName = UserName;
            }

            public String getNickName() {
                return NickName;
            }

            public void setNickName(String NickName) {
                this.NickName = NickName;
            }

            public int getQQNum() {
                return QQNum;
            }

            public void setQQNum(int QQNum) {
                this.QQNum = QQNum;
            }

            public String getProvince() {
                return Province;
            }

            public void setProvince(String Province) {
                this.Province = Province;
            }

            public String getCity() {
                return City;
            }

            public void setCity(String City) {
                this.City = City;
            }

            public String getContent() {
                return Content;
            }

            public void setContent(String Content) {
                this.Content = Content;
            }

            public String getSignature() {
                return Signature;
            }

            public void setSignature(String Signature) {
                this.Signature = Signature;
            }

            public String getAlias() {
                return Alias;
            }

            public void setAlias(String Alias) {
                this.Alias = Alias;
            }

            public int getScene() {
                return Scene;
            }

            public void setScene(int Scene) {
                this.Scene = Scene;
            }

            public int getVerifyFlag() {
                return VerifyFlag;
            }

            public void setVerifyFlag(int VerifyFlag) {
                this.VerifyFlag = VerifyFlag;
            }

            public int getAttrStatus() {
                return AttrStatus;
            }

            public void setAttrStatus(int AttrStatus) {
                this.AttrStatus = AttrStatus;
            }

            public int getSex() {
                return Sex;
            }

            public void setSex(int Sex) {
                this.Sex = Sex;
            }

            public String getTicket() {
                return Ticket;
            }

            public void setTicket(String Ticket) {
                this.Ticket = Ticket;
            }

            public int getOpCode() {
                return OpCode;
            }

            public void setOpCode(int OpCode) {
                this.OpCode = OpCode;
            }
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class AppInfoBean {
            /**
             * AppID :
             * Type : 0
             */

            @JsonProperty("AppID")
            private String AppID;
            @JsonProperty("Type")
            private int Type;

            public String getAppID() {
                return AppID;
            }

            public void setAppID(String AppID) {
                this.AppID = AppID;
            }

            public int getType() {
                return Type;
            }

            public void setType(int Type) {
                this.Type = Type;
            }
        }
    }
}
