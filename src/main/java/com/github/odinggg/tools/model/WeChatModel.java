package com.github.odinggg.tools.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * 描述:
 * 微信实体
 *
 * @author Hansen
 * @version 2020-02-25 14:34
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeChatModel {


    /**
     * BaseResponse : {"Ret":0,"ErrMsg":""}
     * Count : 11
     * ContactList : [{"Uin":0,"UserName":"filehelper","NickName":"æ\u2013\u2021ä»¶ä¼ è¾\u201cåŠ©æ\u2030\u2039","HeadImgUrl":"/cgi-bin/mmwebwx-bin/webwxgeticon?seq=679390142&username=filehelper&skey=@crypt_a51bc2d6_135ea0489dc3c4bb3467d8012d6b4bc7","ContactFlag":3,"MemberCount":0,"MemberList":[],"RemarkName":"","HideInputBarFlag":0,"Sex":0,"Signature":"","VerifyFlag":0,"OwnerUin":0,"PYInitial":"WJCSZS","PYQuanPin":"wenjianchuanshuzhushou","RemarkPYInitial":"","RemarkPYQuanPin":"","StarFriend":0,"AppAccountFlag":0,"Statues":0,"AttrStatus":0,"Province":"","City":"","Alias":"","SnsFlag":0,"UniFriend":0,"DisplayName":"","ChatRoomId":0,"KeyWord":"fil","EncryChatRoomId":"","IsOwner":0},{"Uin":0,"UserName":"@be9e66a38295cf8896ac3ad980ff420c","NickName":"CSDNå­¦é™¢ç²¾å\u201c\u0081è¯¾","HeadImgUrl":"/cgi-bin/mmwebwx-bin/webwxgeticon?seq=679298127&username=@be9e66a38295cf8896ac3ad980ff420c&skey=@crypt_a51bc2d6_135ea0489dc3c4bb3467d8012d6b4bc7","ContactFlag":3,"MemberCount":0,"MemberList":[],"RemarkName":"","HideInputBarFlag":0,"Sex":0,"Signature":"CSDNå­¦é™¢ç²¾å\u201c\u0081è¯¾","VerifyFlag":24,"OwnerUin":0,"PYInitial":"CSDNXYJPK","PYQuanPin":"CSDNxueyuanjingpinke","RemarkPYInitial":"","RemarkPYQuanPin":"","StarFriend":0,"AppAccountFlag":0,"Statues":0,"AttrStatus":0,"Province":"åŒ\u2014äº¬","City":"æœ\u009dé˜³","Alias":"","SnsFlag":0,"UniFriend":0,"DisplayName":"","ChatRoomId":0,"KeyWord":"gh_","EncryChatRoomId":"","IsOwner":0},{"Uin":0,"UserName":"@9c9a55a5f6d2f5e9bbd8eb56160418d4","NickName":"èŠ\u2019æžœç\u201dµå\u008d\u2022è½¦è®¢é˜\u2026å\u008f·","HeadImgUrl":"/cgi-bin/mmwebwx-bin/webwxgeticon?seq=679268617&username=@9c9a55a5f6d2f5e9bbd8eb56160418d4&skey=@crypt_a51bc2d6_135ea0489dc3c4bb3467d8012d6b4bc7","ContactFlag":3,"MemberCount":0,"MemberList":[],"RemarkName":"","HideInputBarFlag":0,"Sex":0,"Signature":"èŠ\u2019æžœç\u201dµå\u008d\u2022è½¦ï¼Œä½Žä»·ä¾¿åˆ©ï¼Œéš\u008få\u008f\u2013éš\u008fè¿˜ï¼Œæ™ºèƒ½å¼\u20acå\u2026³é\u201d\u0081ç³»ç»Ÿï¼Œè½»æ\u009d¾è§£å\u2020³æ\u201a¨çš\u201eä¸­çŸ­é\u20ac\u201då\u2021ºè¡Œéš¾é¢˜ï¼\u0081èŠ\u2019æžœç\u201dµå\u008d\u2022è½¦é\u201a\u20acæ\u201a¨æ\u2013\u2021æ˜Žå\u2021ºè¡Œï¼Œå\u2026±å\u0090Œæˆ\u0090ä¸ºåŸŽå¸\u201aé\u2021Œè\u20ac\u20acçœ¼çš\u201eæµ\u0081åŠ¨é£Žæ™¯ï¼\u0081","VerifyFlag":24,"OwnerUin":0,"PYInitial":"MGDDCDYH","PYQuanPin":"mangguodiandanchedingyuehao","RemarkPYInitial":"","RemarkPYQuanPin":"","StarFriend":0,"AppAccountFlag":0,"Statues":0,"AttrStatus":0,"Province":"æ¹\u2013åŒ\u2014","City":"æ­¦æ±\u2030","Alias":"","SnsFlag":0,"UniFriend":0,"DisplayName":"","ChatRoomId":0,"KeyWord":"gh_","EncryChatRoomId":"","IsOwner":0},{"Uin":0,"UserName":"@ea851bb6de4c2924433d0d27a5128eca","NickName":"æœºå™¨ä¹\u2039å¿ƒ","HeadImgUrl":"/cgi-bin/mmwebwx-bin/webwxgeticon?seq=679350080&username=@ea851bb6de4c2924433d0d27a5128eca&skey=@crypt_a51bc2d6_135ea0489dc3c4bb3467d8012d6b4bc7","ContactFlag":3,"MemberCount":0,"MemberList":[],"RemarkName":"","HideInputBarFlag":0,"Sex":0,"Signature":"ä¸\u201cä¸šçš\u201eäººå·¥æ™ºèƒ½åª\u2019ä½\u201cå\u2019Œäº§ä¸šæœ\u008dåŠ¡å¹³å\u008f°","VerifyFlag":24,"OwnerUin":0,"PYInitial":"JQZX","PYQuanPin":"jiqizhixin","RemarkPYInitial":"","RemarkPYQuanPin":"","StarFriend":0,"AppAccountFlag":0,"Statues":0,"AttrStatus":0,"Province":"åŒ\u2014äº¬","City":"æœ\u009dé˜³","Alias":"","SnsFlag":0,"UniFriend":0,"DisplayName":"","ChatRoomId":0,"KeyWord":"gh_","EncryChatRoomId":"","IsOwner":0},{"Uin":0,"UserName":"@dc583842ebcd8c431d7fa75df99c4067","NickName":"æœºå™¨å­¦ä¹ ç®\u2014æ³\u2022ä¸ŽPythonå­¦ä¹ ","HeadImgUrl":"/cgi-bin/mmwebwx-bin/webwxgeticon?seq=679251731&username=@dc583842ebcd8c431d7fa75df99c4067&skey=@crypt_a51bc2d6_135ea0489dc3c4bb3467d8012d6b4bc7","ContactFlag":3,"MemberCount":0,"MemberList":[],"RemarkName":"","HideInputBarFlag":0,"Sex":0,"Signature":"ä½œä¸ºæ²Ÿé\u20acšå­¦ä¹ çš\u201eå¹³å\u008f°ï¼Œå\u008f\u2018å¸ƒæœºå™¨å­¦ä¹ ä¸Žæ\u2022°æ\u008d®æŒ\u2013æŽ˜ã\u20ac\u0081æ·±åº¦å­¦ä¹ ã\u20ac\u0081Pythonå®žæˆ˜çš\u201eå\u2030\u008dæ²¿ä¸ŽåŠ¨æ\u20ac\u0081ï¼Œæ¬¢è¿Žæœºå™¨å­¦ä¹ çˆ±å¥½è\u20ac\u2026çš\u201eåŠ å\u2026¥ï¼Œå¸Œæœ\u203aå¸®åŠ©ä½ åœ¨AIé¢\u2020åŸŸæ\u203a´å¥½çš\u201eå\u008f\u2018å±\u2022ï¼ŒæœŸå¾\u2026ä¸Žä½ ç\u203a¸é\u0081\u2021ï¼\u0081","VerifyFlag":8,"OwnerUin":0,"PYInitial":"JQXXSFYPYTHONXX","PYQuanPin":"jiqixuexisuanfayuPythonxuexi","RemarkPYInitial":"","RemarkPYQuanPin":"","StarFriend":0,"AppAccountFlag":0,"Statues":0,"AttrStatus":0,"Province":"è¾½å®\u0081","City":"æ²ˆé˜³","Alias":"","SnsFlag":0,"UniFriend":0,"DisplayName":"","ChatRoomId":0,"KeyWord":"gh_","EncryChatRoomId":"","IsOwner":0},{"Uin":0,"UserName":"@29ed8f8c3d3c44e894e7e60e5c69d93c","NickName":"ä¸ºä½ å\u2020™ä¸\u20acä¸ªæ\u2022\u2026äº\u2039","HeadImgUrl":"/cgi-bin/mmwebwx-bin/webwxgeticon?seq=679354548&username=@29ed8f8c3d3c44e894e7e60e5c69d93c&skey=@crypt_a51bc2d6_135ea0489dc3c4bb3467d8012d6b4bc7","ContactFlag":3,"MemberCount":0,"MemberList":[],"RemarkName":"","HideInputBarFlag":0,"Sex":0,"Signature":"é\u203a·æ\u2013¯æž\u2014çš\u201eæ\u2013°å\u008f·ï¼Œæ¬¢è¿Žå\u2026³æ³¨ã\u20ac\u201a","VerifyFlag":8,"OwnerUin":0,"PYInitial":"WNXYGGS","PYQuanPin":"weinixieyigegushi","RemarkPYInitial":"","RemarkPYQuanPin":"","StarFriend":0,"AppAccountFlag":0,"Statues":0,"AttrStatus":0,"Province":"ä¸Šæµ·","City":"å\u008d¢æ¹¾","Alias":"","SnsFlag":0,"UniFriend":0,"DisplayName":"","ChatRoomId":0,"KeyWord":"gh_","EncryChatRoomId":"","IsOwner":0},{"Uin":0,"UserName":"@6afd8eb61599aa8f0ff18c39ea0cf442","NickName":"æž\u0081éªŒ","HeadImgUrl":"/cgi-bin/mmwebwx-bin/webwxgeticon?seq=679281682&username=@6afd8eb61599aa8f0ff18c39ea0cf442&skey=@crypt_a51bc2d6_135ea0489dc3c4bb3467d8012d6b4bc7","ContactFlag":3,"MemberCount":0,"MemberList":[],"RemarkName":"","HideInputBarFlag":0,"Sex":0,"Signature":"æž\u0081éªŒï¼Œå\u2026¨ç\u0090ƒäº¤äº\u2019å®\u2030å\u2026¨åˆ\u203aé¢\u2020è\u20ac\u2026ï¼Œåˆ©ç\u201d¨åˆ\u203aæ\u2013°æŠ\u20acæœ¯ï¼Œå¸®åŠ©ä¼\u0081ä¸šé\u2030´åˆ«å¼\u201aå¸¸æµ\u0081é\u2021\u008fï¼Œå\u0090Œæ\u2014¶æ´žå¯Ÿä»·å\u20ac¼æ\u2022°æ\u008d®ï¼Œå°\u2020æ\u2022°æ\u008d®ä»·å\u20ac¼æœ\u20acå¤§åŒ\u2013çš\u201eæœ\u008dåŠ¡å\u2022\u2020ã\u20ac\u201aä¸\u201cæ³¨äº¤äº\u2019å®\u2030å\u2026¨é¢\u2020åŸŸ7å¹´ï¼Œæ¯\u008få¤©ä¸ºå\u2026¨ç\u0090ƒ29ä¸\u2021å®¶ç½\u2018ç«™ä¸ŽAPPæ\u008f\u0090ä¾\u203aè¶\u2026è¿\u202112äº¿æ¬¡äº¤äº\u2019å®\u2030å\u2026¨æœ\u008dåŠ¡ä¿\u009déšœã\u20ac\u201a","VerifyFlag":24,"OwnerUin":0,"PYInitial":"JY","PYQuanPin":"jiyan","RemarkPYInitial":"","RemarkPYQuanPin":"","StarFriend":0,"AppAccountFlag":0,"Statues":0,"AttrStatus":0,"Province":"æ¹\u2013åŒ\u2014","City":"æ­¦æ±\u2030","Alias":"","SnsFlag":0,"UniFriend":0,"DisplayName":"","ChatRoomId":0,"KeyWord":"gh_","EncryChatRoomId":"","IsOwner":0},{"Uin":0,"UserName":"@9707c083bffd82a0988e2281d0e34aba","NickName":"æ\u009d\u201aç²¥","HeadImgUrl":"/cgi-bin/mmwebwx-bin/webwxgeticon?seq=709854285&username=@9707c083bffd82a0988e2281d0e34aba&skey=@crypt_a51bc2d6_135ea0489dc3c4bb3467d8012d6b4bc7","ContactFlag":3,"MemberCount":0,"MemberList":[],"RemarkName":"","HideInputBarFlag":0,"Sex":0,"Signature":"ç\u201dŸæ´»æ\u009d\u201aä¹±å¤šèˆ¬ï¼Œè\u2030²å\u2018³å¦\u201aå\u0090ŒèŠ±ç²¥","VerifyFlag":24,"OwnerUin":0,"PYInitial":"ZY","PYQuanPin":"zayu","RemarkPYInitial":"","RemarkPYQuanPin":"","StarFriend":0,"AppAccountFlag":0,"Statues":0,"AttrStatus":0,"Province":"åŒ\u2014äº¬","City":"ä¸œåŸŽ","Alias":"","SnsFlag":0,"UniFriend":0,"DisplayName":"","ChatRoomId":0,"KeyWord":"gh_","EncryChatRoomId":"","IsOwner":0},{"Uin":0,"UserName":"@fe404abe1fe1a19b440fef09493ad5f8","NickName":"è¾¾è¾¾å½±é™¢","HeadImgUrl":"/cgi-bin/mmwebwx-bin/webwxgeticon?seq=658574467&username=@fe404abe1fe1a19b440fef09493ad5f8&skey=@crypt_a51bc2d6_135ea0489dc3c4bb3467d8012d6b4bc7","ContactFlag":3,"MemberCount":0,"MemberList":[],"RemarkName":"","HideInputBarFlag":0,"Sex":0,"Signature":"æ¯\u008fæ\u2014¥æ\u0090žç¬\u2018é\u20ac\u2014å\u203a¾","VerifyFlag":8,"OwnerUin":0,"PYInitial":"DDYY","PYQuanPin":"dadayingyuan","RemarkPYInitial":"","RemarkPYQuanPin":"","StarFriend":0,"AppAccountFlag":0,"Statues":0,"AttrStatus":0,"Province":"ä¸Šæµ·","City":"æ™®é™\u20ac","Alias":"","SnsFlag":0,"UniFriend":0,"DisplayName":"","ChatRoomId":0,"KeyWord":"gh_","EncryChatRoomId":"","IsOwner":0},{"Uin":0,"UserName":"@7a8f020f04e5489c58d0cd6ee6e32687","NickName":"ITå\u201cˆå\u201cˆ","HeadImgUrl":"/cgi-bin/mmwebwx-bin/webwxgeticon?seq=658531575&username=@7a8f020f04e5489c58d0cd6ee6e32687&skey=@crypt_a51bc2d6_135ea0489dc3c4bb3467d8012d6b4bc7","ContactFlag":3,"MemberCount":0,"MemberList":[],"RemarkName":"","HideInputBarFlag":0,"Sex":0,"Signature":"æž¶æž\u201eå¸ˆæˆ\u0090é\u2022¿ä¹\u2039è·¯","VerifyFlag":8,"OwnerUin":0,"PYInitial":"ITHH","PYQuanPin":"IThaha","RemarkPYInitial":"","RemarkPYQuanPin":"","StarFriend":0,"AppAccountFlag":0,"Statues":0,"AttrStatus":0,"Province":"åŒ\u2014äº¬","City":"ä¸°å\u008f°","Alias":"","SnsFlag":0,"UniFriend":0,"DisplayName":"","ChatRoomId":0,"KeyWord":"gh_","EncryChatRoomId":"","IsOwner":0},{"Uin":0,"UserName":"@82431d7bf62aa588bf10b2a76e315f94e5a5dbdcc531f6895e45fd22bb4d0592","NickName":"æž\u2014æŸ\u0090æŸ\u0090","HeadImgUrl":"/cgi-bin/mmwebwx-bin/webwxgeticon?seq=709858293&username=@82431d7bf62aa588bf10b2a76e315f94e5a5dbdcc531f6895e45fd22bb4d0592&skey=@crypt_a51bc2d6_135ea0489dc3c4bb3467d8012d6b4bc7","ContactFlag":67,"MemberCount":0,"MemberList":[],"RemarkName":"è\u20ac\u0081å©\u2020","HideInputBarFlag":0,"Sex":2,"Signature":"","VerifyFlag":0,"OwnerUin":0,"PYInitial":"LMM","PYQuanPin":"linmoumou","RemarkPYInitial":"","RemarkPYQuanPin":"","StarFriend":0,"AppAccountFlag":0,"Statues":0,"AttrStatus":233765,"Province":"","City":"","Alias":"","SnsFlag":273,"UniFriend":0,"DisplayName":"","ChatRoomId":0,"KeyWord":"","EncryChatRoomId":"","IsOwner":0}]
     * SyncKey : {"Count":4,"List":[{"Key":1,"Val":709863258},{"Key":2,"Val":709863684},{"Key":3,"Val":709863685},{"Key":1000,"Val":1582606922}]}
     * User : {"Uin":503397695,"UserName":"@389f7b1b2b2e016321a1610e152704e4","NickName":"ç´ è´¨è¯\u2014äºº","HeadImgUrl":"/cgi-bin/mmwebwx-bin/webwxgeticon?seq=677697958&username=@389f7b1b2b2e016321a1610e152704e4&skey=@crypt_a51bc2d6_135ea0489dc3c4bb3467d8012d6b4bc7","RemarkName":"","PYInitial":"","PYQuanPin":"","RemarkPYInitial":"","RemarkPYQuanPin":"","HideInputBarFlag":0,"StarFriend":0,"Sex":1,"Signature":"","AppAccountFlag":0,"VerifyFlag":0,"ContactFlag":0,"WebWxPluginSwitch":0,"HeadImgFlag":1,"SnsFlag":17}
     * ChatSet : filehelper,@be9e66a38295cf8896ac3ad980ff420c,@9c9a55a5f6d2f5e9bbd8eb56160418d4,@ea851bb6de4c2924433d0d27a5128eca,@dc583842ebcd8c431d7fa75df99c4067,@29ed8f8c3d3c44e894e7e60e5c69d93c,@6afd8eb61599aa8f0ff18c39ea0cf442,@9707c083bffd82a0988e2281d0e34aba,@fe404abe1fe1a19b440fef09493ad5f8,@7a8f020f04e5489c58d0cd6ee6e32687,@82431d7bf62aa588bf10b2a76e315f94e5a5dbdcc531f6895e45fd22bb4d0592,@dcb91022b34eb7f97bd49bfd952f9f20,@292591d64d5b301ba0469a14f8a854be,@cd0a54ac838f11b326f419a8cade3327,@05014d29f4023e49a85998cff35ecdc1,@db32f2de029702f4da2743ab7b973665,@c1350ccdc908ea30b54ec8fa2fd0240e,@ee93a0f238f88680b7d6498a59a831a2,@64031324c57722618d088f4198d715d7,@26e0dfc1f5e8cf004b48bc9687d57029,@00828c94dcadc5694ac075c27b5a567e,@2151b03edcfb5feff8b8112e23af0466,@62bdb43c0bfbd025f952a797a93600bd,@@718ef670ceaa2719512e9eea375d278f6bd5c3cc189edb63d07dbf46e366c818,@11de227dfef7440725951b158ad11b0d763fda28010f7794ac5aaf91e0158e10,@d77bd583e7d70d26e42c79ed842b9bd8c68030219e506d293090831af8a9dd5f,
     * SKey : @crypt_a51bc2d6_135ea0489dc3c4bb3467d8012d6b4bc7
     * ClientVersion : 385878573
     * SystemTime : 1582609097
     * GrayScale : 1
     * InviteStartCount : 40
     * MPSubscribeMsgCount : 17
     * MPSubscribeMsgList : [{"UserName":"@be9e66a38295cf8896ac3ad980ff420c","MPArticleCount":3,"MPArticleList":[{"Title":"æŸ\u0090äº\u2019è\u0081\u201dç½\u2018ä¼\u0081ä¸šï¼šç \u201då\u008f\u2018äººå\u2018˜è¦\u0081ä¹ˆæ\u2014 è\u2013ªè½¬é\u201d\u20acå\u201d®å²\u2014ï¼\u0081è¦\u0081ä¹ˆä¸»åŠ¨è¾žé\u20ac\u20acï¼\u0081","Digest":"ç\u2013«æƒ\u2026ä¸\u2039ï¼Œä¼\u0081ä¸šçœŸå®žçŽ°çŠ¶ï¼\u0081","Cover":"https://mmbiz.qpic.cn/sz_mmbiz_jpg/HChpp7QY6Gd3vCOq9uia7LONAWEb7RUPt8W7d7RsWAer7wNZunJGaUqFc0bSgYnPEIEia07JPN74e4Tlg71zObFA/640?wxtype=jpeg&wxfrom=0","Url":"http://mp.weixin.qq.com/s?__biz=MzU3Njc1MDAxNg==&mid=2247486344&idx=1&sn=7e493f6aeb1df633c4348182b1a33b9c&chksm=fd0e6327ca79ea31ac8d1f9513091565a9d2e834a1357a5aa624466a23fb6eaa6ce4051dcac0&scene=0&xtrack=1#rd"},{"Title":"ç¡®è®¤ï¼\u0081åˆ«å\u2020\u008dç\u203a¸ä¿¡Pythonäº\u2020ï¼\u0081 ç¨\u2039åº\u008få\u2018˜ï¼šå°±ä½ æ\u2022¢è¯´...","Digest":"Pythonäººçº¢æ˜¯é\u009džå¤šï¼\u0081","Cover":"https://mmbiz.qpic.cn/mmbiz_jpg/jtj44vboaF288K1ibAXoctdJUOIldLufMsNDAh8UwW2JiaFSE4DMWM1sz9DIryoib79Qv9buDjgDpI4lASjgYU6JQ/300?wxtype=jpeg&wxfrom=0","Url":"http://mp.weixin.qq.com/s?__biz=MzU3Njc1MDAxNg==&mid=2247486344&idx=2&sn=e4ab0eb6d05f8acb80d43bbd90abaebc&chksm=fd0e6327ca79ea31929e485d7d51204530c98047ef93cb1a4201db6c55d4686abf937b0216e1&scene=0&xtrack=1#rd"},{"Title":"2020å¹´æœ\u20acæ\u2013°é£Žå\u008f£ï¼\u0081200ä¸\u2021ç¼ºå\u008f£ï¼Œå\u0081šå¯¹è¿™å\u2021 ç\u201a¹ï¼ŒåŠ©ä½ å\u008d\u2021è\u0081ŒåŠ è\u2013ªï¼\u0081","Digest":"å¦\u201aæžœä½ æ\u2014 æ³\u2022è¡¡é\u2021\u008fï¼Œä½ å°±æ\u2014 æ³\u2022å¢žé\u2022¿ã\u20ac\u201a","Cover":"https://mmbiz.qpic.cn/mmbiz_jpg/Z0mwlhqia2u56F1m7c2sQouiav0oib6DrTqLP1LdSHYrkt4Nco0Y36uyVt4hlYOlgGky3clGxBv60w6ia0pnmuRjtA/300?wxtype=jpeg&wxfrom=0","Url":"http://mp.weixin.qq.com/s?__biz=MzU3Njc1MDAxNg==&mid=2247486344&idx=3&sn=4a771a4acdd3bfc44f54b26390a3b93f&chksm=fd0e6327ca79ea310379942975087bfef63bbae5e20b14f17a0c3ffb087bcf2208c6498fa272&scene=0&xtrack=1#rd"}],"Time":1582608855,"NickName":"CSDNå­¦é™¢ç²¾å\u201c\u0081è¯¾"},{"UserName":"@9c9a55a5f6d2f5e9bbd8eb56160418d4","MPArticleCount":1,"MPArticleList":[{"Title":"12å¼ æœ\u2039å\u008f\u2039åœˆå\u0081·æ\u2039\u008dç\u2026§ï¼šç\u2013«æƒ\u2026ä¹\u2039ä¸\u2039çš\u201eæ­¦æ±\u2030äºº","Digest":"â\u20acœå¸Œæœ\u203aæ˜¯ä»¶ç¾Žå¥½çš\u201eäº\u2039ï¼Œä¹Ÿè®¸æ˜¯äººé\u2014´è\u2021³ç¾Žã\u20ac\u201aâ\u20ac\u009d","Cover":"https://mmbiz.qpic.cn/mmbiz_jpg/FGeXrA5mTW8QuQa1lmId4hdzbz8ja5Nia2cSkMYMJajyVoVuCbarWbiap52ib49TnInbdtMmia1cyAvxm3w6xic5OZA/640?wxtype=jpeg&wxfrom=0","Url":"http://mp.weixin.qq.com/s?__biz=MzI5NDY0OTgzOA==&mid=2247489527&idx=1&sn=49392524cad48cb077f948ebc510fe0f&chksm=ec5efd76db2974604bf8d9128102d86964689aa77b29a9929ecb4bab37c523ff1709f33c5884&scene=0&xtrack=1#rd"}],"Time":1582606918,"NickName":"èŠ\u2019æžœç\u201dµå\u008d\u2022è½¦è®¢é˜\u2026å\u008f·"},{"UserName":"@ea851bb6de4c2924433d0d27a5128eca","MPArticleCount":5,"MPArticleList":[{"Title":"CVPR 2020æ\u201d¾æ¦œï¼Œå½\u2022å\u008f\u2013çŽ\u2021é™\u008dè\u2021³22%ï¼Œæ¸¯ä¸­æ\u2013\u2021å\u2018¨å\u008dšç£Šå\u008f\u2018æ\u2013\u2021æ\u201eŸæ\u2026¨å\u008d\u0081å¹´å\u008f˜è¿\u0081","Digest":"ä»Žè®ºæ\u2013\u2021æŽ¥æ\u201d¶çŽ\u2021æ\u009d¥çœ\u2039ï¼ŒCVPRå¤§ä¼šçš\u201eè®ºæ\u2013\u2021è¢«æŽ¥æ\u201d¶éš¾åº¦ä¼¼ä¹Žåœ¨é\u20ac\u0090å¹´å¢žå¤§ã\u20ac\u201a","Cover":"https://mmbiz.qpic.cn/mmbiz_jpg/KmXPKA19gWicICwD2WbOLia1LubBk3gmWHICRa5oX6kQwbiaXicPcD9Sf8Mw8mGHt7t94bkFUcsuerOoCMqvLELkRw/640?wxtype=jpeg&wxfrom=0","Url":"http://mp.weixin.qq.com/s?__biz=MzA3MzI4MjgzMw==&mid=2650781347&idx=1&sn=3ce13ea5c1dc5663765f5e039ba5bf84&chksm=871a72ddb06dfbcbfb4d7d991f70e7cc01e51d8ff40beb22a6b1c9dff27711796e7a228adcda&scene=0&xtrack=1#rd"},{"Title":"ç™¾åº¦é£žæ¡¨å\u008f£ç½©äººè\u201e¸æ£\u20acæµ\u2039ä¸Žè¯\u2020åˆ«æ¨¡åž\u2039å\u2020\u008då\u008d\u2021çº§ï¼Œè§\u2020é¢\u2018æ\u2022™å­¦å¸¦ä½ å®žæˆ˜","Digest":"ç\u203a¸ä¿¡è¿™ç¯\u2021æ\u2013\u2021ç« èƒ½å¤Ÿå¸®åŠ©å¼\u20acå\u008f\u2018è\u20ac\u2026å¯¹ç™¾åº¦å¼\u20acæº\u0090çš\u201eäººè\u201e¸å\u008f£ç½©æ£\u20acæµ\u2039å\u008fŠè¯\u2020åˆ«æ¨¡åž\u2039çš\u201eå\u008d\u2021çº§æœ\u2030æ\u203a´æ·±å\u2026¥çš\u201eäº\u2020è§£ã\u20ac\u201a","Cover":"https://mmbiz.qpic.cn/mmbiz_jpg/KmXPKA19gWicICwD2WbOLia1LubBk3gmWHxwxK0kShLia19GfjvH3XqibXNmpayWY36KdmIZp9OpWYdQy4N8LRlsGw/300?wxtype=jpeg&wxfrom=0","Url":"http://mp.weixin.qq.com/s?__biz=MzA3MzI4MjgzMw==&mid=2650781347&idx=2&sn=995045bad10f596051ebb4c5448a4eee&chksm=871a72ddb06dfbcb1551b5859210d1d448a5b7275ae6d8f09890ad9de3c54ac186e8aadf36e8&scene=0&xtrack=1#rd"},{"Title":"å\u008dŽä¸ºå\u008f\u2018å¸ƒæŠ˜å\u008f å±\u008fæ\u2030\u2039æœºMate Xsï¼Œåº\u201dç\u201d¨æœ\u008dåŠ¡AppGalleryé\u2021\u008dç£\u2026ç™»åœº","Digest":"å\u008dŽä¸ºå\u2026¨ç\u0090ƒç¬¬ä¸\u2030çš\u201eåº\u201dç\u201d¨ç\u201dŸæ\u20ac\u0081èƒ½å\u0090¦ä¸Žè°·æ­Œã\u20ac\u0081è\u2039¹æžœæŠ\u2014è¡¡ï¼Ÿ","Cover":"https://mmbiz.qpic.cn/mmbiz_jpg/KmXPKA19gWicICwD2WbOLia1LubBk3gmWHqAJMPefEEZy3a2NJbMh5ribg4iaQt1AKPdKup7wTFKic4S7FiakXYSy8ew/300?wxtype=jpeg&wxfrom=0","Url":"http://mp.weixin.qq.com/s?__biz=MzA3MzI4MjgzMw==&mid=2650781347&idx=3&sn=9cb4bf100729204a550838d19d023588&chksm=871a72ddb06dfbcbc6da71f66aff6c2e1f10e57f47c5962f8f90c5a72bccd2d19a0c6e3980ff&scene=0&xtrack=1#rd"},{"Title":"æ\u2018\u2020è\u201e±ç\u201dµç¼\u2020ã\u20ac\u0081å\u008f¯ç§»é™¤å\u203a\u203aè\u201a¢ï¼ŒNASA äººå½¢æœºå™¨äººã\u20acŒå¥³æ­¦ç¥žã\u20ac\u008dæ\u203a¿äººç±»å¥\u201dèµ´ç\u0081¾éš¾åœºæ™¯","Digest":"Valkyrieå¹¶ä¸\u008dæ˜¯ä¸ºå¤ªç©ºè®¾è®¡çš\u201eæœºå™¨äººï¼Œè\u20acŒæ˜¯ä¸\u20acä¸ªä¸ºåœ°ç\u0090ƒä¸Šçš\u201eç\u0081¾éš¾åœºæ™¯è®¾è®¡çš\u201eæœºå™¨äººã\u20ac\u201a","Cover":"https://mmbiz.qpic.cn/mmbiz_jpg/KmXPKA19gWicICwD2WbOLia1LubBk3gmWH4ynGbOhoPOFRMLtPaVX8VibTgBHT3UUXz2jR8t2icARu5e9mRjYEUAYw/300?wxtype=jpeg&wxfrom=0","Url":"http://mp.weixin.qq.com/s?__biz=MzA3MzI4MjgzMw==&mid=2650781347&idx=4&sn=73cd8fabc7c4d3a5b85c5d2c761221ec&chksm=871a72ddb06dfbcbe0f84084fc4ec8e88e04fbde83c4db46c9f3737b88473820c5cd97dc1e2e&scene=0&xtrack=1#rd"},{"Title":"æ™ºèƒ½æˆ˜ç\u2013«åŠ¨æ\u20ac\u0081ç²¾é\u20ac\u2030ï¼šå\u008d«å\u0081¥å§\u201dç§°æœ\u20acå¿«4-5æœˆä»½æœ\u2030éƒ¨åˆ\u2020ç\u2013«è\u2039\u2014è¿\u203aå\u2026¥ä¸´åºŠè¯\u2022éªŒï¼\u203aè\u2039¹æžœæŽ¨è¿Ÿä½Žä»·iPhoneå\u008f\u2018å¸ƒæ\u2014¶é\u2014´ï¼Œå¯Œå£«åº·äº§èƒ½ä¸\u008dè¶³50ï¼\u2026","Digest":"è·Ÿè¸ªAIåº\u201dç\u201d¨åŠ¨æ\u20ac\u0081ï¼Œå¯¹æŽ¥AIæŠ\u2014ç\u2013«èµ\u201eæº\u0090","Cover":"https://mmbiz.qpic.cn/mmbiz_jpg/KmXPKA19gWicICwD2WbOLia1LubBk3gmWHYeSXoEDMBicErn2eiaCRqcHXP9LHvk2OEaUB8hQT4nodULibfZlWA0DJQ/300?wxtype=jpeg&wxfrom=0","Url":"http://mp.weixin.qq.com/s?__biz=MzA3MzI4MjgzMw==&mid=2650781347&idx=5&sn=967c174c57c570356dc38b6be1b91e26&chksm=871a72ddb06dfbcbf24c70e7334e3fe74413b6a86b3fae0ea17565d622fd07b63f3771a5f09a&scene=0&xtrack=1#rd"}],"Time":1582606279,"NickName":"æœºå™¨ä¹\u2039å¿ƒ"},{"UserName":"@dc583842ebcd8c431d7fa75df99c4067","MPArticleCount":3,"MPArticleList":[{"Title":"9å²\u0081ç¥žç«¥å¤§å­¦æ¯\u2022ä¸šå\u2030\u008dçª\u0081ç\u201e¶é\u20ac\u20acå­¦ï¼Œè½¬èµ´ç¾Žå\u203a½æ\u201d»è¯»ç\u201dµæ°\u201då·¥ç¨\u2039å\u008dšå£«","Digest":"æ™ºå\u2022\u2020145æ\u2014 ç¼˜â\u20acœæœ\u20acå°\u008få¤§å­¦æ¯\u2022ä¸šç\u201dŸâ\u20ac\u009dï¼Œå®¶é\u2022¿è®©è¯»å\u008dšé\u0081­ç½\u2018å\u008f\u2039ç\u201a®è½°ï¼šè®©ä»\u2013å\u0081šä¸ªå­©å­\u0090ï¼\u0081","Cover":"https://mmbiz.qpic.cn/mmbiz_jpg/KdayOo3PqHAiazqbAbMAibBMuUuicGQKXWpibjjw5h08uHGYF5ibDr2N9BRsW4Gge2ibic9ITJ1otEQ8ZY7lO1vFH4eNg/640?wxtype=jpeg&wxfrom=0","Url":"http://mp.weixin.qq.com/s?__biz=MzIxODM4MjA5MA==&mid=2247492786&idx=1&sn=237f712eb35d5747089972ddf84a90b9&chksm=97e9ced7a09e47c1612d7e6d7345b15abc46ea429d9b1824750876112047cceb62e49060fcbb&scene=0&xtrack=1#rd"},{"Title":"èµ\u201eæº\u0090 | æ\u2013°ä¹¦400é¡µPDFã\u20acŠTensorFlowæ·±åº¦å­¦ä¹ ã\u20ac\u2039å\u2026\u008dè´¹ä¸\u2039è½½ï¼\u0081","Digest":"é¾™é¾™è\u20ac\u0081å¸ˆã\u20acŠTensorFlowæ·±åº¦å­¦ä¹ ã\u20ac\u2039æŽ¨è\u008d\u0090","Cover":"https://mmbiz.qpic.cn/mmbiz_jpg/KdayOo3PqHAibrhcGnasqd0MxLZLiaibLROp9UgbPVmJKTiavf88SianVubzGEwWPR7FNlWkHdGnEvnOTQMDVxH1DNg/300?wxtype=jpeg&wxfrom=0","Url":"http://mp.weixin.qq.com/s?__biz=MzIxODM4MjA5MA==&mid=2247492786&idx=2&sn=07dad372ff0d92830e76e6af7c5028d7&chksm=97e9ced7a09e47c19e4e28a9b3d37695a7d5aa8eda2fc2841f6ed6b230d98508ef7bf228c895&scene=0&xtrack=1#rd"},{"Title":"â\u20ac\u2039æ\u2013°é¢\u201eè®­ç»ƒæ¨¡åž\u2039CodeBERTå\u2021ºä¸\u2013ï¼Œç¼\u2013ç¨\u2039è¯­è¨\u20acå\u2019Œè\u2021ªç\u201e¶è¯­è¨\u20acéƒ½ä¸\u008dåœ¨è¯\u009dä¸\u2039ï¼Œå\u201cˆå·¥å¤§ã\u20ac\u0081ä¸­å±±å¤§å­¦ã\u20ac\u0081MSRAå\u2021ºå\u201c\u0081","Digest":"æ\u009d¥è\u2021ªå\u201cˆå°\u201dæ»¨å·¥ä¸šå¤§å­¦ã\u20ac\u0081ä¸­å±±å¤§å­¦å\u2019Œå¾®è½¯äºšæ´²ç \u201dç©¶é™¢çš\u201eç \u201dç©¶è\u20ac\u2026å\u0090ˆä½œæ\u008f\u0090å\u2021ºäº\u2020ä¸\u20acä¸ªå\u008f¯å¤\u201eç\u0090\u2020å\u008fŒæ¨¡æ\u20ac\u0081æ\u2022°æ\u008d®çš\u201eæ\u2013°é¢\u201eè®­ç»ƒæ¨¡åž\u2039 CodeBERTï¼Œé™¤äº\u2020è\u2021ªç\u201e¶è¯­è¨\u20acï¼ˆNLï¼\u2030ï¼Œç¼\u2013ç¨\u2039è¯­è¨\u20acï¼ˆPLï¼\u2030å¦\u201aä»Šä¹Ÿå\u008f¯ä»¥è¿\u203aè¡Œé¢\u201eè®­ç»ƒäº\u2020ã\u20ac\u201a","Cover":"https://mmbiz.qpic.cn/mmbiz_jpg/KmXPKA19gWicBavC9X8Sd3XQPRF4seQaN8m0DCYXwdl5bwlm4NFzqE8YkqOgJgkGSlyE20WImYKXrO0SzgzTc7A/300?wxtype=jpeg&wxfrom=0","Url":"http://mp.weixin.qq.com/s?__biz=MzIxODM4MjA5MA==&mid=2247492786&idx=3&sn=3c2c1ffc9e5e2836582f6576067a802f&chksm=97e9ced7a09e47c138a0f36978dfe198d31882235a0545aba97e23a9b46ee3f85187abdd6234&scene=0&xtrack=1#rd"}],"Time":1582605626,"NickName":"æœºå™¨å­¦ä¹ ç®\u2014æ³\u2022ä¸ŽPythonå­¦ä¹ "},{"UserName":"@29ed8f8c3d3c44e894e7e60e5c69d93c","MPArticleCount":1,"MPArticleList":[{"Title":"ä»Šå¤©çš\u201eæ\u2014¥æœ¬é˜²ç\u2013«å·¥ä½œï¼Œè®©æˆ\u2018æƒ³åˆ°äº\u2020ä¸\u20acä¸ªæœˆå\u2030\u008dçš\u201eæ­¦æ±\u2030","Digest":"å¤§å\u0090ƒä¸\u20acæƒŠã\u20ac\u201a","Cover":"https://mmbiz.qpic.cn/mmbiz_jpg/rHlibCaxYvnN9GKT0KicvVHAd2rwz5mibIOMU0nPibuEJYIvja7icVEdqX2mFIGsdeKrYkdvZiajKOfOCjPs5kUzA9Hw/640?wxtype=jpeg&wxfrom=0","Url":"http://mp.weixin.qq.com/s?__biz=MzA5MzAyMzE4Nw==&mid=2457486841&idx=1&sn=343a28e3bae11f59d66a13a8d8e0767b&chksm=87eadb45b09d5253c94bedd339603ebc9d545a7402456a2ae7da6f36a831354859e6818eaa67&scene=0&xtrack=1#rd"}],"Time":1582605424,"NickName":"ä¸ºä½ å\u2020™ä¸\u20acä¸ªæ\u2022\u2026äº\u2039"},{"UserName":"@6afd8eb61599aa8f0ff18c39ea0cf442","MPArticleCount":1,"MPArticleList":[{"Title":"æž\u0081éªŒXæ\u2014 ç³\u2013åœ¨çº¿åˆ\u2020äº«ï¼šç\u2013«æƒ\u2026ä¸\u2039çš\u201eçˆ¬è™«","Digest":"æœ¬å\u2018¨äº\u201dï¼Œè®ºé\u0081\u201cå\u008f\u008dçˆ¬è™«ã\u20ac\u201a","Cover":"https://mmbiz.qpic.cn/mmbiz_jpg/8VOiack4f29d8ZMebqGqtSaWpqAaTKo2ozFFwrmRrNDd4Vqz8jRFSpKWMW4Mh4yNzXicJAkRictNaagAgUMV85ODg/640?wxtype=jpeg&wxfrom=0","Url":"http://mp.weixin.qq.com/s?__biz=MzI2MDE5MTQxNg==&mid=2649699341&idx=1&sn=fda7d8436c18eada366395ac77a44b45&chksm=f276f1dac50178cc3784479d9c9bd6f26de8f729bc4dc4b3ac98576f3ecd81d5ec4cb846c7e5&scene=0&xtrack=1#rd"}],"Time":1582605010,"NickName":"æž\u0081éªŒ"},{"UserName":"@9707c083bffd82a0988e2281d0e34aba","MPArticleCount":4,"MPArticleList":[{"Title":"æ\u2014¥æœ¬äººï¼Œä¹Ÿä¹°ä¸\u008dåˆ°å\u008f£ç½©äº\u2020ï¼\u0081â\u20acœæ´»è¯¥â\u20ac\u009d","Digest":"ä¸ºäººè¯·å\u2013\u201eè\u2030¯","Cover":"https://mmbiz.qpic.cn/mmbiz_jpg/EDZz1ZbdgicXBB3II2EMIA6qC4ocl4QSkcbxWWxHRhvOErz3dK29OxYkA15eGoZ90SqPyURjMmVEOBiafqyB1LvQ/640?wxtype=jpeg&wxfrom=0","Url":"http://mp.weixin.qq.com/s?__biz=MzIwNTk2Mzk3OQ==&mid=2247494809&idx=1&sn=4ef3fb5288db5cddc29b4a68e08c5103&chksm=972a7b3da05df22ba496ce935d6d32e6fff94be84c854badf8c4fdc2e1dbdd91ffd8355e6731&scene=0&xtrack=1#rd"},{"Title":"ä¸\u20acå\u2019¬å°±çˆ\u2020æ±\u0081ï¼Œå¥¹ä¸\u2018å¾\u2014è¾£çœ¼ï¼Œå\u008d´ç\u201dœå¾\u2014æƒŠè\u2030³ï¼\u0081","Digest":"æœ\u20acè¿\u2018äºŒåˆ·äº\u2020ä¸\u20acéƒ¨ç\u201dµå½±â\u20ac\u201dâ\u20ac\u201dã\u20acŠç©¿æ™®æ\u2039\u2030è¾¾çš\u201eå¥³çŽ\u2039ã\u20ac\u2039è¿™éƒ¨ç\u201dµå½±æ˜¯çŸ¥ä¹Žä¸Šé«˜å\u2018¼çš\u201eæ¯\u008fä¸ªå¥³å­©éƒ½åº\u201dè¯¥çœ\u2039çš\u201eå½±ç\u2030\u2021ä¹\u2039ä¸\u20acï¼Œè±\u2020ç\u201c£è¯\u201eåˆ\u2020é«˜è¾¾8.0","Cover":"https://mmbiz.qpic.cn/mmbiz_jpg/EDZz1ZbdgicVeW9pzGicNDEMH1bKUiceIr5XjvSbkS2uZsYpptZkSmPoEnBoChibjEQ563jRNQ5BnxyjnqicNzX8Dpw/300?wxtype=jpeg&wxfrom=0","Url":"http://mp.weixin.qq.com/s?__biz=MzIwNTk2Mzk3OQ==&mid=2247494809&idx=2&sn=7f094090bb9222c490a566e6e8950c2f&chksm=972a7b3da05df22bdc9124d660608015b3c49f89e26c9c77d868b5058c95e6957fc5066275d5&scene=0&xtrack=1#rd"},{"Title":"å¯¹ä½ å¥½å\u2019Œä¸ºä½ å¥½çš\u201eåŒºåˆ«","Digest":"å¯¹ä½ å¥½å\u2019Œä¸ºä½ å¥½çš\u201eåŒºåˆ«â\u20ac¦â\u20ac¦","Cover":"https://mmbiz.qpic.cn/mmbiz_jpg/EDZz1ZbdgicVeW9pzGicNDEMH1bKUiceIr5IPibicO0LxyYbficxWXqkdJOKFVneoyEc4qo40pGf6gFAQ9jRnLEef4KA/300?wxtype=jpeg&wxfrom=0","Url":"http://mp.weixin.qq.com/s?__biz=MzIwNTk2Mzk3OQ==&mid=2247494809&idx=3&sn=7074e314ed509416e71747b3218f9323&chksm=972a7b3da05df22be7fcbc43743bfd8b9eafb2147f40810b488901afe4e8fd3ab3926f4a5d76&scene=0&xtrack=1#rd"},{"Title":"2020å\u2020™è¿\u203aå¿ƒçª\u009dçš\u201eä¸\u20acæ®µè¯\u009dï¼\u0081","Digest":"2020å\u2020™è¿\u203aå¿ƒçª\u009dçš\u201eä¸\u20acæ®µè¯\u009dï¼\u0081â\u20ac¦â\u20ac¦","Cover":"https://mmbiz.qpic.cn/mmbiz_jpg/EDZz1ZbdgicVeW9pzGicNDEMH1bKUiceIr5tnkqycR4DicooLpP7qvcczJ9AKQu7n2tytOcEmoGUDMJqrqtgSk3lEg/300?wxtype=jpeg&wxfrom=0","Url":"http://mp.weixin.qq.com/s?__biz=MzIwNTk2Mzk3OQ==&mid=2247494809&idx=4&sn=eb1753f1485a429dc78e3be84163e6f3&chksm=972a7b3da05df22b9b75c0a27472fa71e4a34b71cc8cf50676cfd0b0621bef9a82bbace95dd9&scene=0&xtrack=1#rd"}],"Time":1582603638,"NickName":"æ\u009d\u201aç²¥"},{"UserName":"@fe404abe1fe1a19b440fef09493ad5f8","MPArticleCount":2,"MPArticleList":[{"Title":"æ°¸è¿œä¹Ÿä¸\u008dè¦\u0081è¯´ä¸\u20acä¸ªç\u201d·äººä¸\u008dè¡Œï¼\u0081","Digest":"ï¼ˆå\u2020\u2026å®¹æ\u009d¥æº\u0090äºŽç½\u2018ç»œï¼Œä¾µåˆ ï¼\u2030","Cover":"https://mmbiz.qpic.cn/mmbiz_jpg/N0wibRlKibox3t4mSfAic0BX04fzJG4icVIZibPvf5op2ZpIYiaLnIN0bTH2mbPr2zbQkjWPllMJrvJY5DdGSavLfeoQ/300?wxtype=jpeg&wxfrom=0","Url":"http://mp.weixin.qq.com/s?__biz=MzIwODI1MTkwOA==&mid=2649598540&idx=3&sn=f4ef19478e5c1f587376a9b7eebf09d3&chksm=8f1cf727b86b7e31aaf1bc0007e0f77b5ce3606e6c75e0f0297a3dfc911c4bddd9b4f1aa12df&scene=0&xtrack=1#rd"},{"Title":"è\u201ašå­\u0090é¥¿äº\u2020å°±æ\u2030\u201cç\u201dµè¯\u009dç»™æˆ\u2018","Digest":"å\u203a ä¸ºä½ å¤ªä¹\u2026æ²¡å¯¹è±¡ä½ çš\u201eå¤´å\u008f\u2018è\u2021ªè®¤ä¸ºä½ å\u2021ºå®¶äº\u2020æ\u2030\u20acä»¥å¼\u20acå§\u2039è\u201e±è\u0090½äº\u2020","Cover":"https://mmbiz.qpic.cn/mmbiz_png/N0wibRlKibox3t4mSfAic0BX04fzJG4icVIZPicShgX1X76iaQjXyu1BNmD9n7PtLsnbT9XafX4byYyiaGP29JQ18N6Ww/300?wxtype=png&wxfrom=0","Url":"http://mp.weixin.qq.com/s?__biz=MzIwODI1MTkwOA==&mid=2649598540&idx=4&sn=d06f4cceecf002a0adbe43b70d205caf&chksm=8f1cf727b86b7e31d1894dd2e2232d74266e137b7dfdc466e66ce3dcb53e2535d7696be9537e&scene=0&xtrack=1#rd"}],"Time":1582603618,"NickName":"è¾¾è¾¾å½±é™¢"},{"UserName":"@dcb91022b34eb7f97bd49bfd952f9f20","MPArticleCount":2,"MPArticleList":[{"Title":"é\u009d¢è¯\u2022ä¸­è¢«é\u2014®åˆ°HashMapçš\u201eç»\u201cæž\u201eï¼Œ1.7å\u2019Œ1.8æœ\u2030å\u201cªäº\u203aåŒºåˆ«ï¼Ÿè¿™ç¯\u2021å\u0081šæ·±å\u2026¥åˆ\u2020æž\u0090ï¼\u0081","Digest":"ç¾Žå\u203a¢é\u009d¢è¯\u2022é¢˜ï¼šHashmapçš\u201eç»\u201cæž\u201eï¼Œ1.7å\u2019Œ1.8æœ\u2030å\u201cªäº\u203aåŒºåˆ«ï¼Œå\u008f²ä¸Šæœ\u20acæ·±å\u2026¥çš\u201eåˆ\u2020æž\u0090","Cover":"https://mmbiz.qpic.cn/mmbiz_jpg/eQPyBffYbucW9LWmQZZjEFTv8UDxHd4bp1DVVTAjXUOrkpnPiakjNcibsLLBCeTmibicributTXm1FCLj9BNQNMvSUQ/640?wxtype=jpeg&wxfrom=0","Url":"http://mp.weixin.qq.com/s?__biz=MzI4Njc5NjM1NQ==&mid=2247491589&idx=1&sn=34009f91dbe0369e1ab02761ac786c4f&chksm=ebd5df29dca2563f2ef2707798997ff88dd1fc7bba6c7eaec59ef4d8341a332241770936c300&scene=0&xtrack=1#rd"},{"Title":"å¼\u20acå·¥å\u0090Žç¬¬ä¸\u20acæ¬¡é\u009d¢è¯\u2022ï¼Œå\u008f\u2018çŽ°è\u2021ªå·±è\u0090½ä¼\u008däº\u2020ï¼\u0081","Digest":"ä¸\u008då°\u2018å\u008d\u2022ä½\u008då·²ç»\u008få¼\u20acå§\u2039å¤\u008då·¥äº\u2020ï¼Œè·³æ§½å­£ä¹Ÿå\u008d³å°\u2020å¼\u20acå§\u2039ã\u20ac\u201a2020ï¼Œä¼\u0081ä¸šæ\u2039\u203aè\u0081˜å»¶è¿Ÿï¼Œå\u0090\u008dé¢\u009dç¼©å\u2021\u008fï¼Œå¯¼è\u2021´æœ¬å°±åƒ§å¤šç²¥å°\u2018çš\u201eå±\u20acé\u009d¢è¿\u203aä¸\u20acæ­¥æ\u0081¶åŒ\u2013","Cover":"https://mmbiz.qpic.cn/mmbiz_jpg/eQPyBffYbucW9LWmQZZjEFTv8UDxHd4b2BHWzQk5G7VcnDibOOOIBZL5geuxepZKxaQElbyfjfaYOtFcFZo2etg/300?wxtype=jpeg&wxfrom=0","Url":"http://mp.weixin.qq.com/s?__biz=MzI4Njc5NjM1NQ==&mid=2247491589&idx=2&sn=be826f3125e28ef878b82edb8351d349&chksm=ebd5df29dca2563fa0c4f0d4fcefe521e2fee8ce609876670f830cbd6f3a70c96c54b8439502&scene=0&xtrack=1#rd"}],"Time":1582602540,"NickName":"JavaçŸ¥éŸ³"},{"UserName":"@05014d29f4023e49a85998cff35ecdc1","MPArticleCount":1,"MPArticleList":[{"Title":"æ\u2013°å\u2020 ç\u2013«æƒ\u2026ä¹\u2039ä¸\u2039ï¼Œé™¤äº\u2020å\u008f£ç½©å\u2019Œé\u2026\u2019ç²¾ï¼Œæˆ\u2018ä»¬è¿˜åº\u201dè¯¥çŸ¥é\u0081\u201cTAï¼\u0081","Digest":"å½\u201cå\u2030\u008dæ\u2013°å\u2020 ç\u2013«æƒ\u2026ï¼Œå¤\u2013åŠ ç©ºæ°\u201dæ±¡æŸ\u201cï¼Œç\u201dŸæ´»ä¸­çš\u201eâ\u20acœéš\u0090å½¢æ\u009d\u20acæ\u2030\u2039â\u20ac\u009dç\u201e¡å¤\u201eä¸\u008dåœ¨ï¼šç»\u2020è\u008fŒã\u20ac\u0081é\u203a¾éœ¾ã\u20ac\u0081å¼\u201aå\u2018³ã\u20ac\u0081ç\u0081°å°˜ã\u20ac\u0081ç\u2014\u2026æ¯\u2019â\u20ac¦â\u20ac¦å¯¹äºŽå\u2026\u008dç\u2013«åŠ\u203aå¼±çš\u201eæˆ\u0090äºº","Cover":"https://mmbiz.qpic.cn/mmbiz_jpg/yYlN34YrPz7tfuseOh3DEOTnF5XNfNICYTsWOZtibA9tEUKWIYO7qW7EAsId9icTcyRPDpv8qj4F6QpOIWl5h9vQ/300?wxtype=jpeg&wxfrom=0","Url":"http://mp.weixin.qq.com/s?__biz=MzI5MzYwODI1Mw==&mid=2247487790&idx=2&sn=bd26fa66fdb94a4a247ca189f77e5c29&chksm=ec6edf7cdb19566aca9f2aaed4b26c1cdd4dbca93751b0530df0991f8aba4c203ff88d34e1d9&scene=0&xtrack=1#rd"}],"Time":1582600253,"NickName":"ç™½çŽ\u2030ç\u203a˜"},{"UserName":"@db32f2de029702f4da2743ab7b973665","MPArticleCount":5,"MPArticleList":[{"Title":"çŽ°åœ¨æ˜¯ç\u2014\u2026æ¯\u2019æœ\u20acå®¹æ˜\u201cå\u0081·è¢­çš\u201eæ\u2014¶å\u20ac™ï¼\u0081å\u2026³äºŽå½\u201cä¸\u2039ç\u2013«æƒ\u2026çš\u201e6ä¸ªå\u2026³é\u201d®äº\u2039å®ž","Digest":"å\u2030\u008dçº¿è¿˜åœ¨æ\u0090\u008få\u2018½ï¼Œå\u0090Žæ\u2013¹å\u008d´åœ¨ç\u2039\u201aæ¬¢ã\u20ac\u201a","Cover":"https://mmbiz.qpic.cn/mmbiz_jpg/mmF0rTjMmmJUw24UTvKLETSaDzibYHicia2ic3nIApS7qV6lNbm9OUprdZX4pLAX4zlu0rF2DnoZuw6IWAEicnsQFiaQ/640?wxtype=jpeg&wxfrom=0","Url":"http://mp.weixin.qq.com/s?__biz=MzA5NTU0NzY2Mg==&mid=2651291322&idx=1&sn=fd45946fe1de6068407cbe48a685c7d6&chksm=8b4e66dbbc39efcd8b93af8859ecc54713a914f9d529d9b076c2ce4501423697e964a8c0ca9b&scene=0&xtrack=1#rd"},{"Title":"è\u2030¾æ»\u2039æš´éœ² 24 å°\u008fæ\u2014¶å\u0090Ž ï¼Œæˆ\u2018å®Œæˆ\u0090äº\u2020è\u2021ªæ\u2022\u2018","Digest":"è\u008d\u0090å\u008f·","Cover":"https://mmbiz.qpic.cn/mmbiz_jpg/mmF0rTjMmmJUw24UTvKLETSaDzibYHicia2JevmUNIH5l7IyUWCFTqAibJQCuIoy1e3FholnFSajtCt1E6NfYDs1xQ/300?wxtype=jpeg&wxfrom=0","Url":"http://mp.weixin.qq.com/s?__biz=MzA5NTU0NzY2Mg==&mid=2651291322&idx=2&sn=f6561b37ee6f5cedde17def48b3d52bc&chksm=8b4e66dbbc39efcd7ac0bbabe9b1f9ee2e6c2f2c228b5b12fa72f80fb7effd488c8bc30e992c&scene=0&xtrack=1#rd"},{"Title":"æ\u2013°åž£ç»\u201cè¡£ã\u20ac\u0081çŸ³åŽŸé\u2021Œç¾Žï¼Œå¥¹ä»¬ç¬\u2018èµ·æ\u009d¥è¿™ä¹ˆç¾Žï¼Œç§˜å¯\u2020ç«Ÿç\u201e¶æ˜¯è¿™ä¸ª...","Digest":"çˆ±ç¬\u2018çš\u201eå¥³ç\u201dŸï¼Œè¿\u0090æ°\u201déƒ½ä¸\u008dä¼šå¤ªå·®å\u201c¦ã\u20ac\u201a","Cover":"https://mmbiz.qpic.cn/mmbiz_jpg/mmF0rTjMmmJUw24UTvKLETSaDzibYHicia2SP15bZaZajgJ3Grsy4DKICS4RjOAVCWC4HWccF1McTQzaBgKelCM8g/300?wxtype=jpeg&wxfrom=0","Url":"http://mp.weixin.qq.com/s?__biz=MzA5NTU0NzY2Mg==&mid=2651291322&idx=3&sn=dbe8a249fd9d2376166e1590de0f24cc&chksm=8b4e66dbbc39efcdca270885f66e3bc31a804752688c16807ddd0fce6464848206e27df375b6&scene=0&xtrack=1#rd"},{"Title":"ç\u2030¹æ®Šæƒ\u2026å\u2020µçš\u201eè¶\u2026é\u2022¿å\u0081\u2021æœŸï¼Œ90å\u0090Žå®\u2026å®¶çš\u201eæ­£ç¡®æ\u2030\u201cå¼\u20acæ\u2013¹å¼\u008f","Digest":"è\u008d\u0090å\u008f·","Cover":"https://mmbiz.qpic.cn/mmbiz_jpg/mmF0rTjMmmJUw24UTvKLETSaDzibYHicia2r63uCJpV3kkn04ICF9sv1Cm8ubacL2tedTYmLkcuqCfulxARfa41oQ/300?wxtype=jpeg&wxfrom=0","Url":"http://mp.weixin.qq.com/s?__biz=MzA5NTU0NzY2Mg==&mid=2651291322&idx=4&sn=6a8b1f599f6c1753f2f7f2e6411feb4a&chksm=8b4e66dbbc39efcd1b93be0be615f598950149228301e6f6302c8344f10ebf74f001f1a15d86&scene=0&xtrack=1#rd"},{"Title":"é\u20ac\u0081ä¹¦ï¼š2000ä½\u008dCEOæŽ¨è\u008d\u0090ï¼Œå\u008dŽä¸ºäººäººéƒ½èƒ½æˆ\u0090ä¸ºå¥\u2039æ\u2013\u2014è\u20ac\u2026çš\u201eç§˜å¯\u2020","Digest":"èµ ä¹¦","Cover":"https://mmbiz.qpic.cn/mmbiz_jpg/mmF0rTjMmmJUw24UTvKLETSaDzibYHicia2QkFRDsPicAJBfoT6LibeStibxHYicPOhXK54wJbu488dQ3N0IAXQdDS0nw/300?wxtype=jpeg&wxfrom=0","Url":"http://mp.weixin.qq.com/s?__biz=MzA5NTU0NzY2Mg==&mid=2651291322&idx=5&sn=d629b9f2c3bcb63e5add874fd7b6d994&chksm=8b4e66dbbc39efcdedfe0dd7a46c3c6fc575518c03a6fdcb2beed4e0b918d2f59966b43ca9e3&scene=0&xtrack=1#rd"}],"Time":1582595810,"NickName":"ä¹¦å\u008d\u2022"},{"UserName":"@c1350ccdc908ea30b54ec8fa2fd0240e","MPArticleCount":2,"MPArticleList":[{"Title":"ç\u2030©è\u0081\u201dç½\u2018å°\u2020æˆ\u0090ä¸ºå\u2026¨ç\u0090ƒç»\u008fæµŽé¢ è¦\u2020è\u20ac\u2026ï¼Œè\u20acŒè¿™ä¸\u2030ç§\u008dç¼\u2013ç¨\u2039è¯­è¨\u20acåŠ¿ä¸\u008då\u008f¯æŒ¡ï¼\u0081","Digest":"éš\u008fç\u009d\u20acç\u2030©è\u0081\u201dç½\u2018è¶Šæ\u009d¥è¶Šèž\u008då\u2026¥æˆ\u2018ä»¬çš\u201eæ\u2014¥å¸¸ç\u201dŸæ´»ä¸­ï¼Œå®ƒç»™ç§\u2018å­¦ä¸Žå·¥ç¨\u2039å¸¦æ\u009d¥äº\u2020ä¼\u2014å¤šæŒ\u2018æˆ˜å\u2019Œæœºé\u0081\u2021ã\u20ac\u201a","Cover":"https://mmbiz.qpic.cn/mmbiz_jpg/X36HLl2EicOexpt1BWgfMH3HgTQCVfj7yo49MYYp4Q7QSkAG4pDeo5dlqxHYDmibKkqBjYryGgicBxCxW0TnQd9dw/640?wxtype=jpeg&wxfrom=0","Url":"http://mp.weixin.qq.com/s?__biz=MzI0NjM3NjI1NQ==&mid=2247491339&idx=1&sn=e11553f8ccb460356625e5410757172c&chksm=e9416d5bde36e44d1190f85c2931346be667c4baf337f9bd911366d53f1ae8da614a8fdc36eb&scene=0&xtrack=1#rd"},{"Title":"ä¼ æ™ºçº¿ä¸Šæ\u2022™å­¦å¥½è¯\u201eå¦\u201aæ½®ï¼Œåœ¨çº¿æ\u2022™è\u201a²å­\u0090å\u201c\u0081ç\u2030Œå\u008dšå­¦è°·åŽšç§¯è\u2013\u201eå\u008f\u2018æ\u2039\u2026é\u2021\u008dä»»","Digest":"4å¹´åŽšç§¯è\u2013\u201eå\u008f\u2018ï¼Œ9å¤©çª\u0081å\u2021»ç­¹å¤\u2021ï¼Œå­¦å\u2018˜å¥½è¯\u201eå¦\u201aæ½®ï¼Œå\u008dšå­¦è°·åœ¨çº¿æ\u2022™è\u201a²æ­£è¿Žæ\u009d¥å±žäºŽè\u2021ªå·±çš\u201eâ\u20acœæ˜¥å¤©â\u20ac\u009d","Cover":"https://mmbiz.qpic.cn/mmbiz_jpg/EibqicLiaLZ06ePxm2cRhYnxBe7FXjoZZfPGACnpL5pk36icOfGDVuXObOkKibMFTpoMNcC59YLGaeOUzBoTWobcalg/300?wxtype=jpeg&wxfrom=0","Url":"http://mp.weixin.qq.com/s?__biz=MzI0NjM3NjI1NQ==&mid=2247491339&idx=2&sn=0123543f3c95dc62f09102bd220180cf&chksm=e9416d5bde36e44da401d43326d81ef9a40d4990d72917b8894e52dc266908dd136a6fae99e2&scene=0&xtrack=1#rd"}],"Time":1582594690,"NickName":"é»\u2018é©¬ç¨\u2039åº\u008få\u2018˜"},{"UserName":"@ee93a0f238f88680b7d6498a59a831a2","MPArticleCount":3,"MPArticleList":[{"Title":"å\u2026¬å\u008f¸æ\u009d¥äº\u2020ä¸\u20acä½\u008då¤§ç¥žï¼Œæœ\u008dåŠ¡å™¨ç¼©å\u2021\u008fä¸\u20acå\u008dŠï¼Œæ\u20ac§èƒ½å\u008f\u008dè\u20acŒæ\u008f\u0090å\u008d\u2021ï¼\u0081","Digest":"è¿™å°±æ˜¯ä¸ºä»\u20acä¹ˆä½ ä¸\u20acç\u203a´è¿\u203aä¸\u008däº\u2020å¤§åŽ\u201açš\u201eåŽŸå\u203a ï¼\u0081","Cover":"https://mmbiz.qpic.cn/mmbiz_jpg/TNUwKhV0JpQLicibXZDfGzALqRIAQM0U5xALHsUibdO43mqbPiaUQ4OjzicEJEOaOkPdicpx543lUuwVTsoJJo9InRBQ/640?wxtype=jpeg&wxfrom=0","Url":"http://mp.weixin.qq.com/s?__biz=MzI3ODcxMzQzMw==&mid=2247492793&idx=1&sn=7968488f4bbce290db426cd88d419669&chksm=eb50618fdc27e899fa88dfa5190333d8e068c3c41a5b765b3c00a8a1c5e31f63af660781ec46&scene=0&xtrack=1#rd"},{"Title":"Git æ\u008f\u0090äº¤ä»£ç \u0081æ¯\u008fæ¬¡è¾\u201cå¯\u2020ç \u0081ï¼ŒçœŸå\u008f«ä¸\u20acä¸ªçƒ¦ï¼\u0081","Digest":"æ\u008f\u0090äº¤ä»£ç \u0081é\u201a£å\u008f«ä¸\u20acä¸ªçˆ½ï¼\u0081","Cover":"https://mmbiz.qpic.cn/mmbiz_jpg/TNUwKhV0JpQHQIjhTia8v3xZBcn6Xiaw53YBBmrlk7ic1q6q8OgASJYJQM1Sia3VSlyCUQlib4kWutILCBpkUutDXhw/300?wxtype=jpeg&wxfrom=0","Url":"http://mp.weixin.qq.com/s?__biz=MzI3ODcxMzQzMw==&mid=2247492793&idx=2&sn=70bba1a60a9035767b7c297158e393fc&chksm=eb50618fdc27e8992cd43cc1e95cc9b8232ef1bae5f38243fcc0727c298e3f5a7ffcbb7eeb84&scene=0&xtrack=1#rd"},{"Title":"å¦\u201aä½\u2022å\u0081œæ­¢ä¸\u20acä¸ªæ­£åœ¨è¿\u0090è¡Œçš\u201eçº¿ç¨\u2039ï¼Ÿ","Digest":"è¿™æ˜¯ä¸ªå¥½é\u2014®é¢˜ã\u20ac\u201a","Cover":"https://mmbiz.qpic.cn/mmbiz_jpg/TNUwKhV0JpStaEWo8ffk7Qr18hBibFsibX33qrMMEyOKdVjUfNN9pShBQ7dGVniahBuavneVMZqia5NibpOjE3zvVKw/300?wxtype=jpeg&wxfrom=0","Url":"http://mp.weixin.qq.com/s?__biz=MzI3ODcxMzQzMw==&mid=2247492793&idx=3&sn=9571d56e627ff5783500649c5b409109&chksm=eb50618fdc27e89943d3d267858d1ae5c6752b7aef9d269ec9759f19487ee70a43100e2bc341&scene=0&xtrack=1#rd"}],"Time":1582594455,"NickName":"JavaæŠ\u20acæœ¯æ ˆ"},{"UserName":"@64031324c57722618d088f4198d715d7","MPArticleCount":3,"MPArticleList":[{"Title":"Redisä¸ºä»\u20acä¹ˆè¿™ä¹ˆå¿«ï¼Ÿä¸\u20acæ\u2013\u2021æ·±å\u2026¥äº\u2020è§£Redisï¼\u0081","Digest":"ä¸\u008dè¦\u0081å°\u008fçœ\u2039ä¸\u20acä¸ªredis","Cover":"https://mmbiz.qpic.cn/mmbiz_jpg/R3InYSAIZkHOgsm8EusrpX10Hq5XrKBFD0RNJAcTKc170WMutibWdE7EFebkODBiayIebS5dCIUv2Kj3ibv7krDPw/640?wxtype=jpeg&wxfrom=0","Url":"http://mp.weixin.qq.com/s?__biz=MzAxODcyNjEzNQ==&mid=2247489704&idx=1&sn=fabffa5341e53418196d8f0960ba7b75&chksm=9bd0b530aca73c268260120b88ae0f4cb275900bcd2ffb4d1e63c803e08c28f1a42e973d3307&scene=0&xtrack=1#rd"},{"Title":"Spring Boot 2.xåŸºç¡\u20acæ\u2022™ç¨\u2039ï¼šä½¿ç\u201d¨ ECharts ç»˜åˆ¶å\u0090\u201eç§\u008då\u008dŽä¸½çš\u201eæ\u2022°æ\u008d®å\u203a¾è¡¨","Digest":"ç³»åˆ\u2014è¿žè½½ç»§ç»­~~å\u2026³æ³¨æˆ\u2018ï¼Œä¸\u20acèµ·æŒ\u0081ç»­å­¦ä¹ è¿\u203aæ­¥~","Cover":"https://mmbiz.qpic.cn/mmbiz_jpg/R3InYSAIZkHOgsm8EusrpX10Hq5XrKBF1SusFSibuHSicmwrz7YEmpiaTqTvicia0HJmJWj6TyhkpicVXnorGzicp8K5A/300?wxtype=jpeg&wxfrom=0","Url":"http://mp.weixin.qq.com/s?__biz=MzAxODcyNjEzNQ==&mid=2247489704&idx=2&sn=1278bc4776abb37fb04bc4872d04f616&chksm=9bd0b530aca73c26ffd4b273aafd7e2a43124fcad44a8a05919289f1a39d14bf0674eb2e90c4&scene=0&xtrack=1#rd"},{"Title":"MySQLå¦\u201aä½\u2022åˆ\u2020ç»\u201eæ\u2039¼æŽ¥å­\u2014ç¬¦ä¸²ï¼Ÿ","Digest":"åˆ\u2020äº«ä¸\u20acç¯\u2021æ\u2013\u2021ç« ã\u20ac\u201a","Cover":"https://mmbiz.qpic.cn/mmbiz_jpg/N1knSK6wthrU727f3FhYI5M3tHFfwGxGsLrAy6UibiaPltzgasCz4VjN67dnxYRibXcgzAOeJgu2Pu2bwX90BUPNg/300?wxtype=jpeg&wxfrom=0","Url":"http://mp.weixin.qq.com/s?__biz=MzAxODcyNjEzNQ==&mid=2247489704&idx=3&sn=3d62862cfbc2b7db8ac7a043e6ed66d7&chksm=9bd0b530aca73c265cfed8042ab6bb1b2a5e440c2909be558e593c4707ff4873fd38bd024350&scene=0&xtrack=1#rd"}],"Time":1582594253,"NickName":"ç¨\u2039åº\u008fçŒ¿DD"},{"UserName":"@26e0dfc1f5e8cf004b48bc9687d57029","MPArticleCount":2,"MPArticleList":[{"Title":"æœ\u20acè¿\u2018è¿œç¨\u2039é\u009d¢è¯\u2022äº\u2020å\u2021 å®¶å¤§åŽ\u201aå\u0090Žï¼Œæˆ\u2018æ\u20ac»ç»\u201cä¸\u20acä»½é\u009d¢è¯\u2022æ\u2013\u2021æ¡£ç»™å¤§å®¶å\u008f\u201aè\u20acƒï¼\u0081","Digest":"æ\u20acŽæ ·æ\u2030\u008dèƒ½æ\u2039¿åˆ°å¤§åŽ\u201açš\u201eofferï¼Ÿ","Cover":"https://mmbiz.qpic.cn/mmbiz_jpg/NtO5sialJZGqvwQtolwSTScSSxuZ1vgsyFoXzra3aQxbvEj3ezWZZ8y9oYiaKJxwawdSt3O7D5JmnIicK84YHDOfw/640?wxtype=jpeg&wxfrom=0","Url":"http://mp.weixin.qq.com/s?__biz=MzIxMjE5MTE1Nw==&mid=2653201726&idx=1&sn=e6ac034fa84be11a3d29b91f0decb17b&chksm=8c99d7e4bbee5ef20b40925b63ae46ff62671f2bb6ff899c6e5bcdf61a73f650d8a465fe2b5d&scene=0&xtrack=1#rd"},{"Title":"å¦\u201aä½\u2022æ\u201d¹å\u008f˜Redisç\u201d¨ä¸\u008då¥½çš\u201eè¯¯åŒº","Digest":"ä¸\u008dè¦\u0081å°\u008fçœ\u2039ä¸\u20acä¸ªredis","Cover":"https://mmbiz.qpic.cn/mmbiz_jpg/NtO5sialJZGqvwQtolwSTScSSxuZ1vgsyKiaIs3bEqn3t0mvutTicjbTnddPpUO64MvASWd8XktzWRLGwhEt2AC0A/300?wxtype=jpeg&wxfrom=0","Url":"http://mp.weixin.qq.com/s?__biz=MzIxMjE5MTE1Nw==&mid=2653201726&idx=2&sn=81ac5bf24ad95d64d06a5d0596a9d37b&chksm=8c99d7e4bbee5ef2a83b8c2495f8bd708b1026a6f9c6bf3118d06c78fde0ba8cb40d26166128&scene=0&xtrack=1#rd"}],"Time":1582593336,"NickName":"ç¨\u2039åº\u008få\u2018˜å°\u008fç\u0081°"},{"UserName":"@00828c94dcadc5694ac075c27b5a567e","MPArticleCount":5,"MPArticleList":[{"Title":"å\u008dŽä¸ºå\u2021Œæ™¨å\u008f\u2018å¸ƒä¼šï¼šèŠ¯ç\u2030\u2021å¦\u201aæœŸæœªè\u2021³ï¼Œè¦\u0081å½»åº\u2022è·Ÿè°·æ­Œè¯´æ\u2039œæ\u2039œï¼Ÿ","Digest":"ä¸Šä¸\u20acå\u203ažæ\u008f\u0090å\u2030\u008dä¸\u20acå¤©å\u008f\u2013æ¶ˆåŽŸå\u008f\u2018å¸ƒè®¡åˆ\u2019ï¼Œè¿˜æ˜¯åŽ»å¹´è\u008d£è\u20ac\u20ac20å\u008f\u2018å¸ƒä¼šé\u2021Œçš\u201eç\u201dµè\u201e\u2018è®¡åˆ\u2019","Cover":"https://mmbiz.qpic.cn/mmbiz_jpg/YriaiaJPb26VNbqQovVppUjfNOQ8YjMiazkZcibmYALKZct6Wkezp01SUeY9tS4QQmyYH40FhFYpBlf7flaJqSdHZA/640?wxtype=jpeg&wxfrom=0","Url":"http://mp.weixin.qq.com/s?__biz=MjM5MDE0Mjc4MA==&mid=2651024496&idx=1&sn=d1f25359b5f1a34f8603ffe51dda2b35&chksm=bdbe94238ac91d35ee1674fafad5a25769908696bba180de11a8971eada8f79a9566f335f9ad&scene=0&xtrack=1#rd"},{"Title":"å¦\u201aä½\u2022å°\u2020ç \u201då\u008f\u2018å\u203a¢é˜Ÿçš\u201eå­¦ä¹ æˆ\u0090æœ¬é™\u008dè\u2021³æ¯\u008få¹´300å\u2026ƒ/äººï¼Ÿ| æž\u0081å®¢æ\u2014¶é\u2014´ä¼\u0081ä¸šç\u2030ˆ","Digest":"2 æœˆ 6 æ\u2014¥ï¼Œå\u203a½å®¶å\u008f\u2018å±\u2022æ\u201d¹é\u009d©å§\u201dåŠžå\u2026¬åŽ\u2026ã\u20ac\u0081äººåŠ\u203aèµ\u201eæº\u0090ç¤¾ä¼šä¿\u009déšœéƒ¨åŠžå\u2026¬åŽ\u2026ã\u20ac\u0081å·¥ä¸šå\u2019Œä¿¡æ\u0081¯åŒ\u2013éƒ¨åŠžå\u2026¬åŽ\u2026ã\u20ac\u0081å\u2026¨å\u203a½æ\u20ac»å·¥ä¼šåŠžå\u2026¬åŽ\u2026å\u203a\u203aéƒ¨é\u2014¨è\u0081\u201då\u0090ˆå\u008d°å\u008f\u2018ã\u20acŠå\u2026³äºŽåº\u201då¯¹æ\u2013°åž\u2039å\u2020 çŠ¶ç\u2014\u2026æ¯\u2019æ\u201eŸæŸ\u201cè\u201aºç\u201aŽç\u2013«æƒ\u2026æ\u201d¯æŒ\u0081é¼\u201cåŠ±åŠ³åŠ¨è\u20ac\u2026å\u008f\u201aä¸Žçº¿ä¸Šè\u0081Œä¸šæŠ\u20acèƒ½åŸ¹è®­çš\u201eé\u20acšçŸ¥ã\u20ac\u2039","Cover":"https://mmbiz.qpic.cn/mmbiz_jpg/YriaiaJPb26VMBoe0NOYmeZP441jYNKe0rnGWPPw2GlopHI3FfFibnGEAia4x9tqJfOVvic9MSiclGwOtalxERqIibv2A/300?wxtype=jpeg&wxfrom=0","Url":"http://mp.weixin.qq.com/s?__biz=MjM5MDE0Mjc4MA==&mid=2651024496&idx=2&sn=3b16a0517403d9ca782ae5abad1978c6&chksm=bdbe94238ac91d35b73699c34b9b764718289dad7d7c5a500f8f5008bc61672a03be89543dbb&scene=0&xtrack=1#rd"},{"Title":"èŠ¯ç\u2030\u2021äº§ä¸šé\u201c¾å\u2020°ç\u0081«ä¸¤é\u2021\u008då¤©ï¼šå°\u0081æµ\u2039é\u0081\u2021éš¾å\u2026³ï¼ŒAI èŠ¯ç\u2030\u2021è¿Žåˆ©å¥½","Digest":"æ\u2013°åž\u2039å\u2020 çŠ¶ç\u2014\u2026æ¯\u2019ç\u2013«æƒ\u2026å¸­å\u008d·æ\u20ac\u0081åŠ¿ä¸\u2039ï¼Œä»»ä½\u2022ä¸\u20acä¸ªè¡Œä¸šéƒ½éš¾ä»¥ç\u2039¬å\u2013\u201eå\u2026¶èº«ï¼ŒèŠ¯ç\u2030\u2021è¡Œä¸šä¹Ÿå\u008f\u2014åˆ°äº\u2020ä¸\u20acå®šç¨\u2039åº¦çš\u201eæ³¢å\u008fŠï¼Œä½\u2020æ\u2013½åŠ åœ¨äº§ä¸šé\u201c¾ä¸Šä¸\u008då\u0090ŒçŽ¯èŠ\u201açš\u201eâ\u20acœä½œç\u201d¨åŠ\u203aâ\u20ac\u009dä¸\u008dä¸\u20acã\u20ac\u201a","Cover":"https://mmbiz.qpic.cn/mmbiz_jpg/YriaiaJPb26VMBoe0NOYmeZP441jYNKe0r0ic6RpPzaFFbOCibx15gtkjU8ATJfVpEoBNJPBa2tcibtibGvtCq3tQC2w/300?wxtype=jpeg&wxfrom=0","Url":"http://mp.weixin.qq.com/s?__biz=MjM5MDE0Mjc4MA==&mid=2651024496&idx=3&sn=ab712e081d2c1f1ad6440c8a1bcf463d&chksm=bdbe94238ac91d35e5f15355ec8a703512680eb25c90bbbd2c2c9ec289ae2d105dbb92936755&scene=0&xtrack=1#rd"},{"Title":"å·¨å¤´å\u2026¥å±\u20acã\u20ac\u0081åŽ\u201aå\u2022\u2020å\u008f\u2018åŠ\u203aï¼Œè¢«â\u20acœæ¿\u20acæ´»â\u20ac\u009dçš\u201eè§\u2020é¢\u2018ä¼šè®®æ\u2039¼çš\u201eæ˜¯ä»\u20acä¹ˆï¼Ÿ","Digest":"å¯¹æ \u2021 Zoomï¼Œå\u2026¨æ\u2014¶äº\u2018çš\u201eç\u203a®æ \u2021æ˜¯æˆ\u0090ä¸ºå\u203a½å\u2020\u2026æœ\u20acå¥½çš\u201eè§\u2020é¢\u2018ä¼šè®®ä¾\u203aåº\u201då\u2022\u2020ã\u20ac\u201a","Cover":"https://mmbiz.qpic.cn/mmbiz_jpg/YriaiaJPb26VMBoe0NOYmeZP441jYNKe0rxqhLnpgOf1QJY5zmAOtwClxW3Q3sJXPJ0ATj3LJEuYFbK4HHsmFezQ/300?wxtype=jpeg&wxfrom=0","Url":"http://mp.weixin.qq.com/s?__biz=MjM5MDE0Mjc4MA==&mid=2651024496&idx=4&sn=bc0e28e3b2265857b593ccc88d43e1ab&chksm=bdbe94238ac91d35ccefd6b42fe49cf02f9dc6fe40f7b20f1725e7032e0b5eb8f12f9171ef3f&scene=0&xtrack=1#rd"},{"Title":"Npm, Inc. å\u008f\u2018å¸ƒ Npm Proï¼Œé\u009d¢å\u0090\u2018ç\u2039¬ç«\u2039 JavaScript å¼\u20acå\u008f\u2018äººå\u2018˜","Digest":"npm, Inc. æœ\u20acè¿\u2018å\u008f\u2018å¸ƒäº\u2020 npm Pro ï¼Œå®ƒæ˜¯ä¸\u201cé\u2014¨ä¸ºç\u2039¬ç«\u2039 JavaScript å¼\u20acå\u008f\u2018äººå\u2018˜æ\u2030\u20acè®¾è®¡çš\u201eã\u20ac\u201a","Cover":"https://mmbiz.qpic.cn/mmbiz_jpg/YriaiaJPb26VMBoe0NOYmeZP441jYNKe0rFLSV0oP4FXSSzgFtfpPL1y29f2nIG3AjQ8xXxY5bRpk002oT4wicRkg/300?wxtype=jpeg&wxfrom=0","Url":"http://mp.weixin.qq.com/s?__biz=MjM5MDE0Mjc4MA==&mid=2651024496&idx=5&sn=fbb4e198ee3da8a49955de11d158b6ff&chksm=bdbe94238ac91d35c319d0b1592fe0a98c80eed788061e9b19fdf58925505222f5ee87f46365&scene=0&xtrack=1#rd"}],"Time":1582593222,"NickName":"InfoQ"},{"UserName":"@2151b03edcfb5feff8b8112e23af0466","MPArticleCount":2,"MPArticleList":[{"Title":"Redis æœªæ­»ï¼Œä¾\u009dç\u201e¶å¾ˆç\u2030\u203aé\u20ac¼ï¼\u0081","Digest":"ä¸\u008dè¦\u0081å°\u008fçœ\u2039ä¸\u20acä¸ªredis","Cover":"https://mmbiz.qpic.cn/mmbiz_jpg/PgqYrEEtEnqkQvf72792vtXrq97uE59ibv7GANhzEaVzS6ULUfdQBVNlNKYFJG456ml0ds2VeXib1Db6sRNnGRnQ/640?wxtype=jpeg&wxfrom=0","Url":"http://mp.weixin.qq.com/s?__biz=MzI4NDY5Mjc1Mg==&mid=2247490844&idx=1&sn=1a5f3e87e75564617ecba7824436d3c4&chksm=ebf6c563dc814c756caf567dbd4d4be8f3ed04c01ff268708082b2392ed72815c04fe356b970&scene=0&xtrack=1#rd"},{"Title":"å¦\u201aä½\u2022ä½¿ç\u201d¨ Python çˆ¬å\u008f\u2013å¾®ä¿¡å\u2026¬ä¼\u2014å\u008f·æ\u2013\u2021ç« ï¼Ÿ","Digest":"å®žç\u201d¨æŠ\u20acå·§","Cover":"https://mmbiz.qpic.cn/mmbiz_jpg/SAy0yVjKWyyC4zjhZqeia0fgxGoCE44DeOZnI7caQUk8vu6vJnXm906lhlYD6JmnPUy3vicjXVpGwTQXppt4FHicA/300?wxtype=jpeg&wxfrom=0","Url":"http://mp.weixin.qq.com/s?__biz=MzI4NDY5Mjc1Mg==&mid=2247490844&idx=2&sn=6ace124e32880bc6f6842934b84d2aa2&chksm=ebf6c563dc814c754b0eac726f451021801f40c7453a7fd8ea45efcc283d2118d47503f14ecc&scene=0&xtrack=1#rd"}],"Time":1582593050,"NickName":"çº¯æ´\u0081çš\u201eå¾®ç¬\u2018"}]
     * ClickReportInterval : 600000
     */

    @JsonProperty("BaseResponse")
    private BaseResponseBean BaseResponse;
    @JsonProperty("Count")
    private Long Count;
    @JsonProperty("SyncKey")
    private SyncKeyBean SyncKey;
    @JsonProperty("User")
    private UserBean User;
    @JsonProperty("ChatSet")
    private String ChatSet;
    @JsonProperty("SKey")
    private String SKey;
    @JsonProperty("ClientVersion")
    private Long ClientVersion;
    @JsonProperty("SystemTime")
    private Long SystemTime;
    @JsonProperty("GrayScale")
    private Long GrayScale;
    @JsonProperty("InviteStartCount")
    private Long InviteStartCount;
    @JsonProperty("MPSubscribeMsgCount")
    private Long MPSubscribeMsgCount;
    @JsonProperty("ClickReportInterval")
    private Long ClickReportInterval;
    @JsonProperty("ContactList")
    private List<ContactListBean> ContactList;
    @JsonProperty("MPSubscribeMsgList")
    private List<MPSubscribeMsgListBean> MPSubscribeMsgList;
    @JsonProperty("SecurityBean")
    private SecurityBean securityBean;
    @JsonProperty("MemberCount")
    private Long MemberCount;
    @JsonProperty("Seq")
    private Long Seq;
    @JsonProperty("MemberList")
    private List<WeChatMember.MemberListBean> MemberList;

    public Long getMemberCount() {
        return MemberCount;
    }

    public void setMemberCount(Long MemberCount) {
        this.MemberCount = MemberCount;
    }

    public Long getSeq() {
        return Seq;
    }

    public void setSeq(Long Seq) {
        this.Seq = Seq;
    }

    public List<WeChatMember.MemberListBean> getMemberList() {
        return MemberList;
    }

    public void setMemberList(List<WeChatMember.MemberListBean> MemberList) {
        this.MemberList = MemberList;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class MemberListBean {
        /**
         * Uin : 0
         * UserName : @21e145a55443f6afd65b966dac0de934
         * NickName : æ™“å½¬
         * HeadImgUrl : /cgi-bin/mmwebwx-bin/webwxgeticon?seq=641588&username=@21e145a55443f6afd65b966dac0de934&skey=@crypt_a51bc2d6_9db2b7c2373534bd4507d821353cb51b
         * ContactFlag : 3
         * MemberCount : 0
         * MemberList : []
         * RemarkName : å°æ¯”
         * HideInputBarFlag : 0
         * Sex : 1
         * Signature :
         * VerifyFlag : 0
         * OwnerUin : 0
         * PYInitial : XB
         * PYQuanPin : xiaobin
         * RemarkPYInitial : XB
         * RemarkPYQuanPin : xiaobi
         * StarFriend : 0
         * AppAccountFlag : 0
         * Statues : 0
         * AttrStatus : 99
         * Province :
         * City :
         * Alias :
         * SnsFlag : 0
         * UniFriend : 0
         * DisplayName :
         * ChatRoomId : 0
         * KeyWord : sun
         * EncryChatRoomId :
         * IsOwner : 0
         */

        @JsonProperty("Uin")
        private Long Uin;
        @JsonProperty("UserName")
        private String UserName;
        @JsonProperty("NickName")
        private String NickName;
        @JsonProperty("HeadImgUrl")
        private String HeadImgUrl;
        @JsonProperty("ContactFlag")
        private Long ContactFlag;
        @JsonProperty("MemberCount")
        private Long MemberCount;
        @JsonProperty("RemarkName")
        private String RemarkName;
        @JsonProperty("HideInputBarFlag")
        private Long HideInputBarFlag;
        @JsonProperty("Sex")
        private Long Sex;
        @JsonProperty("Signature")
        private String Signature;
        @JsonProperty("VerifyFlag")
        private Long VerifyFlag;
        @JsonProperty("OwnerUin")
        private Long OwnerUin;
        @JsonProperty("PYInitial")
        private String PYInitial;
        @JsonProperty("PYQuanPin")
        private String PYQuanPin;
        @JsonProperty("RemarkPYInitial")
        private String RemarkPYInitial;
        @JsonProperty("RemarkPYQuanPin")
        private String RemarkPYQuanPin;
        @JsonProperty("StarFriend")
        private Long StarFriend;
        @JsonProperty("AppAccountFlag")
        private Long AppAccountFlag;
        @JsonProperty("Statues")
        private Long Statues;
        @JsonProperty("AttrStatus")
        private Long AttrStatus;
        @JsonProperty("Province")
        private String Province;
        @JsonProperty("City")
        private String City;
        @JsonProperty("Alias")
        private String Alias;
        @JsonProperty("SnsFlag")
        private Long SnsFlag;
        @JsonProperty("UniFriend")
        private Long UniFriend;
        @JsonProperty("DisplayName")
        private String DisplayName;
        @JsonProperty("ChatRoomId")
        private Long ChatRoomId;
        @JsonProperty("KeyWord")
        private String KeyWord;
        @JsonProperty("EncryChatRoomId")
        private String EncryChatRoomId;
        @JsonProperty("IsOwner")
        private Long IsOwner;
        @JsonProperty("MemberList")
        private List<?> MemberList;

        public Long getUin() {
            return Uin;
        }

        public void setUin(Long Uin) {
            this.Uin = Uin;
        }

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

        public String getHeadImgUrl() {
            return HeadImgUrl;
        }

        public void setHeadImgUrl(String HeadImgUrl) {
            this.HeadImgUrl = HeadImgUrl;
        }

        public Long getContactFlag() {
            return ContactFlag;
        }

        public void setContactFlag(Long ContactFlag) {
            this.ContactFlag = ContactFlag;
        }

        public Long getMemberCount() {
            return MemberCount;
        }

        public void setMemberCount(Long MemberCount) {
            this.MemberCount = MemberCount;
        }

        public String getRemarkName() {
            return RemarkName;
        }

        public void setRemarkName(String RemarkName) {
            this.RemarkName = RemarkName;
        }

        public Long getHideInputBarFlag() {
            return HideInputBarFlag;
        }

        public void setHideInputBarFlag(Long HideInputBarFlag) {
            this.HideInputBarFlag = HideInputBarFlag;
        }

        public Long getSex() {
            return Sex;
        }

        public void setSex(Long Sex) {
            this.Sex = Sex;
        }

        public String getSignature() {
            return Signature;
        }

        public void setSignature(String Signature) {
            this.Signature = Signature;
        }

        public Long getVerifyFlag() {
            return VerifyFlag;
        }

        public void setVerifyFlag(Long VerifyFlag) {
            this.VerifyFlag = VerifyFlag;
        }

        public Long getOwnerUin() {
            return OwnerUin;
        }

        public void setOwnerUin(Long OwnerUin) {
            this.OwnerUin = OwnerUin;
        }

        public String getPYInitial() {
            return PYInitial;
        }

        public void setPYInitial(String PYInitial) {
            this.PYInitial = PYInitial;
        }

        public String getPYQuanPin() {
            return PYQuanPin;
        }

        public void setPYQuanPin(String PYQuanPin) {
            this.PYQuanPin = PYQuanPin;
        }

        public String getRemarkPYInitial() {
            return RemarkPYInitial;
        }

        public void setRemarkPYInitial(String RemarkPYInitial) {
            this.RemarkPYInitial = RemarkPYInitial;
        }

        public String getRemarkPYQuanPin() {
            return RemarkPYQuanPin;
        }

        public void setRemarkPYQuanPin(String RemarkPYQuanPin) {
            this.RemarkPYQuanPin = RemarkPYQuanPin;
        }

        public Long getStarFriend() {
            return StarFriend;
        }

        public void setStarFriend(Long StarFriend) {
            this.StarFriend = StarFriend;
        }

        public Long getAppAccountFlag() {
            return AppAccountFlag;
        }

        public void setAppAccountFlag(Long AppAccountFlag) {
            this.AppAccountFlag = AppAccountFlag;
        }

        public Long getStatues() {
            return Statues;
        }

        public void setStatues(Long Statues) {
            this.Statues = Statues;
        }

        public Long getAttrStatus() {
            return AttrStatus;
        }

        public void setAttrStatus(Long AttrStatus) {
            this.AttrStatus = AttrStatus;
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

        public String getAlias() {
            return Alias;
        }

        public void setAlias(String Alias) {
            this.Alias = Alias;
        }

        public Long getSnsFlag() {
            return SnsFlag;
        }

        public void setSnsFlag(Long SnsFlag) {
            this.SnsFlag = SnsFlag;
        }

        public Long getUniFriend() {
            return UniFriend;
        }

        public void setUniFriend(Long UniFriend) {
            this.UniFriend = UniFriend;
        }

        public String getDisplayName() {
            return DisplayName;
        }

        public void setDisplayName(String DisplayName) {
            this.DisplayName = DisplayName;
        }

        public Long getChatRoomId() {
            return ChatRoomId;
        }

        public void setChatRoomId(Long ChatRoomId) {
            this.ChatRoomId = ChatRoomId;
        }

        public String getKeyWord() {
            return KeyWord;
        }

        public void setKeyWord(String KeyWord) {
            this.KeyWord = KeyWord;
        }

        public String getEncryChatRoomId() {
            return EncryChatRoomId;
        }

        public void setEncryChatRoomId(String EncryChatRoomId) {
            this.EncryChatRoomId = EncryChatRoomId;
        }

        public Long getIsOwner() {
            return IsOwner;
        }

        public void setIsOwner(Long IsOwner) {
            this.IsOwner = IsOwner;
        }

        public List<?> getMemberList() {
            return MemberList;
        }

        public void setMemberList(List<?> MemberList) {
            this.MemberList = MemberList;
        }
    }

    public SecurityBean getSecurityBean() {
        return securityBean;
    }

    public void setSecurityBean(SecurityBean securityBean) {
        this.securityBean = securityBean;
    }

    public BaseResponseBean getBaseResponse() {
        return BaseResponse;
    }

    public String getDeviceId() {
        return "e" + String.valueOf(new Random().nextLong()).substring(1, 16);
    }

    public void setBaseResponse(BaseResponseBean BaseResponse) {
        this.BaseResponse = BaseResponse;
    }

    public Long getCount() {
        return Count;
    }

    public void setCount(Long Count) {
        this.Count = Count;
    }

    public SyncKeyBean getSyncKey() {
        return SyncKey;
    }

    public void setSyncKey(SyncKeyBean SyncKey) {
        this.SyncKey = SyncKey;
    }

    public UserBean getUser() {
        return User;
    }

    public void setUser(UserBean User) {
        this.User = User;
    }

    public String getChatSet() {
        return ChatSet;
    }

    public void setChatSet(String ChatSet) {
        this.ChatSet = ChatSet;
    }

    public String getSKey() {
        return SKey;
    }

    public void setSKey(String SKey) {
        this.SKey = SKey;
    }

    public Long getClientVersion() {
        return ClientVersion;
    }

    public void setClientVersion(Long ClientVersion) {
        this.ClientVersion = ClientVersion;
    }

    public Long getSystemTime() {
        return SystemTime;
    }

    public void setSystemTime(Long SystemTime) {
        this.SystemTime = SystemTime;
    }

    public Long getGrayScale() {
        return GrayScale;
    }

    public void setGrayScale(Long GrayScale) {
        this.GrayScale = GrayScale;
    }

    public Long getInviteStartCount() {
        return InviteStartCount;
    }

    public void setInviteStartCount(Long InviteStartCount) {
        this.InviteStartCount = InviteStartCount;
    }

    public Long getMPSubscribeMsgCount() {
        return MPSubscribeMsgCount;
    }

    public void setMPSubscribeMsgCount(Long MPSubscribeMsgCount) {
        this.MPSubscribeMsgCount = MPSubscribeMsgCount;
    }

    public Long getClickReportInterval() {
        return ClickReportInterval;
    }

    public void setClickReportInterval(Long ClickReportInterval) {
        this.ClickReportInterval = ClickReportInterval;
    }

    public List<ContactListBean> getContactList() {
        return ContactList;
    }

    public void setContactList(List<ContactListBean> ContactList) {
        this.ContactList = ContactList;
    }

    public List<MPSubscribeMsgListBean> getMPSubscribeMsgList() {
        return MPSubscribeMsgList;
    }

    public void setMPSubscribeMsgList(List<MPSubscribeMsgListBean> MPSubscribeMsgList) {
        this.MPSubscribeMsgList = MPSubscribeMsgList;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class BaseResponseBean {
        /**
         * Ret : 0
         * ErrMsg :
         */

        @JsonProperty("Ret")
        private Long Ret;
        @JsonProperty("ErrMsg")
        private String ErrMsg;

        public Long getRet() {
            return Ret;
        }

        public void setRet(Long Ret) {
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
    public static class SyncKeyBean {
        /**
         * Count : 4
         * List : [{"Key":1,"Val":709863258},{"Key":2,"Val":709863684},{"Key":3,"Val":709863685},{"Key":1000,"Val":1582606922}]
         */

        @JsonProperty("Count")
        private Long Count;
        @JsonProperty("List")
        private java.util.List<ListBean> List;

        @Override
        public String toString() {
            if (CollectionUtils.isEmpty(List)) {
                return "";
            }
            return List.stream()
                    .map(listBean -> listBean.getKey() + "_" + listBean.getVal())
                    .collect(Collectors.joining("|"));
        }

        public Long getCount() {
            return Count;
        }

        public void setCount(Long Count) {
            this.Count = Count;
        }

        public List<ListBean> getList() {
            return List;
        }

        public void setList(List<ListBean> List) {
            this.List = List;
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class ListBean {
            /**
             * Key : 1
             * Val : 709863258
             */

            @JsonProperty("Key")
            private Long Key;
            @JsonProperty("Val")
            private Long Val;

            public Long getKey() {
                return Key;
            }

            public void setKey(Long Key) {
                this.Key = Key;
            }

            public Long getVal() {
                return Val;
            }

            public void setVal(Long Val) {
                this.Val = Val;
            }
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class UserBean {
        /**
         * Uin : 503397695
         * UserName : @389f7b1b2b2e016321a1610e152704e4
         * NickName : ç´ è´¨è¯—äºº
         * HeadImgUrl : /cgi-bin/mmwebwx-bin/webwxgeticon?seq=677697958&username=@389f7b1b2b2e016321a1610e152704e4&skey=@crypt_a51bc2d6_135ea0489dc3c4bb3467d8012d6b4bc7
         * RemarkName :
         * PYInitial :
         * PYQuanPin :
         * RemarkPYInitial :
         * RemarkPYQuanPin :
         * HideInputBarFlag : 0
         * StarFriend : 0
         * Sex : 1
         * Signature :
         * AppAccountFlag : 0
         * VerifyFlag : 0
         * ContactFlag : 0
         * WebWxPluginSwitch : 0
         * HeadImgFlag : 1
         * SnsFlag : 17
         */

        @JsonProperty("Uin")
        private Long Uin;
        @JsonProperty("UserName")
        private String UserName;
        @JsonProperty("NickName")
        private String NickName;
        @JsonProperty("HeadImgUrl")
        private String HeadImgUrl;
        @JsonProperty("RemarkName")
        private String RemarkName;
        @JsonProperty("PYInitial")
        private String PYInitial;
        @JsonProperty("PYQuanPin")
        private String PYQuanPin;
        @JsonProperty("RemarkPYInitial")
        private String RemarkPYInitial;
        @JsonProperty("RemarkPYQuanPin")
        private String RemarkPYQuanPin;
        @JsonProperty("HideInputBarFlag")
        private Long HideInputBarFlag;
        @JsonProperty("StarFriend")
        private Long StarFriend;
        @JsonProperty("Sex")
        private Long Sex;
        @JsonProperty("Signature")
        private String Signature;
        @JsonProperty("AppAccountFlag")
        private Long AppAccountFlag;
        @JsonProperty("VerifyFlag")
        private Long VerifyFlag;
        @JsonProperty("ContactFlag")
        private Long ContactFlag;
        @JsonProperty("WebWxPluginSwitch")
        private Long WebWxPluginSwitch;
        @JsonProperty("HeadImgFlag")
        private Long HeadImgFlag;
        @JsonProperty("SnsFlag")
        private Long SnsFlag;

        public Long getUin() {
            return Uin;
        }

        public void setUin(Long Uin) {
            this.Uin = Uin;
        }

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

        public String getHeadImgUrl() {
            return HeadImgUrl;
        }

        public void setHeadImgUrl(String HeadImgUrl) {
            this.HeadImgUrl = HeadImgUrl;
        }

        public String getRemarkName() {
            return RemarkName;
        }

        public void setRemarkName(String RemarkName) {
            this.RemarkName = RemarkName;
        }

        public String getPYInitial() {
            return PYInitial;
        }

        public void setPYInitial(String PYInitial) {
            this.PYInitial = PYInitial;
        }

        public String getPYQuanPin() {
            return PYQuanPin;
        }

        public void setPYQuanPin(String PYQuanPin) {
            this.PYQuanPin = PYQuanPin;
        }

        public String getRemarkPYInitial() {
            return RemarkPYInitial;
        }

        public void setRemarkPYInitial(String RemarkPYInitial) {
            this.RemarkPYInitial = RemarkPYInitial;
        }

        public String getRemarkPYQuanPin() {
            return RemarkPYQuanPin;
        }

        public void setRemarkPYQuanPin(String RemarkPYQuanPin) {
            this.RemarkPYQuanPin = RemarkPYQuanPin;
        }

        public Long getHideInputBarFlag() {
            return HideInputBarFlag;
        }

        public void setHideInputBarFlag(Long HideInputBarFlag) {
            this.HideInputBarFlag = HideInputBarFlag;
        }

        public Long getStarFriend() {
            return StarFriend;
        }

        public void setStarFriend(Long StarFriend) {
            this.StarFriend = StarFriend;
        }

        public Long getSex() {
            return Sex;
        }

        public void setSex(Long Sex) {
            this.Sex = Sex;
        }

        public String getSignature() {
            return Signature;
        }

        public void setSignature(String Signature) {
            this.Signature = Signature;
        }

        public Long getAppAccountFlag() {
            return AppAccountFlag;
        }

        public void setAppAccountFlag(Long AppAccountFlag) {
            this.AppAccountFlag = AppAccountFlag;
        }

        public Long getVerifyFlag() {
            return VerifyFlag;
        }

        public void setVerifyFlag(Long VerifyFlag) {
            this.VerifyFlag = VerifyFlag;
        }

        public Long getContactFlag() {
            return ContactFlag;
        }

        public void setContactFlag(Long ContactFlag) {
            this.ContactFlag = ContactFlag;
        }

        public Long getWebWxPluginSwitch() {
            return WebWxPluginSwitch;
        }

        public void setWebWxPluginSwitch(Long WebWxPluginSwitch) {
            this.WebWxPluginSwitch = WebWxPluginSwitch;
        }

        public Long getHeadImgFlag() {
            return HeadImgFlag;
        }

        public void setHeadImgFlag(Long HeadImgFlag) {
            this.HeadImgFlag = HeadImgFlag;
        }

        public Long getSnsFlag() {
            return SnsFlag;
        }

        public void setSnsFlag(Long SnsFlag) {
            this.SnsFlag = SnsFlag;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ContactListBean {
        /**
         * Uin : 0
         * UserName : filehelper
         * NickName : æ–‡ä»¶ä¼ è¾“åŠ©æ‰‹
         * HeadImgUrl : /cgi-bin/mmwebwx-bin/webwxgeticon?seq=679390142&username=filehelper&skey=@crypt_a51bc2d6_135ea0489dc3c4bb3467d8012d6b4bc7
         * ContactFlag : 3
         * MemberCount : 0
         * MemberList : []
         * RemarkName :
         * HideInputBarFlag : 0
         * Sex : 0
         * Signature :
         * VerifyFlag : 0
         * OwnerUin : 0
         * PYInitial : WJCSZS
         * PYQuanPin : wenjianchuanshuzhushou
         * RemarkPYInitial :
         * RemarkPYQuanPin :
         * StarFriend : 0
         * AppAccountFlag : 0
         * Statues : 0
         * AttrStatus : 0
         * Province :
         * City :
         * Alias :
         * SnsFlag : 0
         * UniFriend : 0
         * DisplayName :
         * ChatRoomId : 0
         * KeyWord : fil
         * EncryChatRoomId :
         * IsOwner : 0
         */

        @JsonProperty("Uin")
        private Long Uin;
        @JsonProperty("UserName")
        private String UserName;
        @JsonProperty("NickName")
        private String NickName;
        @JsonProperty("HeadImgUrl")
        private String HeadImgUrl;
        @JsonProperty("ContactFlag")
        private Long ContactFlag;
        @JsonProperty("MemberCount")
        private Long MemberCount;
        @JsonProperty("RemarkName")
        private String RemarkName;
        @JsonProperty("HideInputBarFlag")
        private Long HideInputBarFlag;
        @JsonProperty("Sex")
        private Long Sex;
        @JsonProperty("Signature")
        private String Signature;
        @JsonProperty("VerifyFlag")
        private Long VerifyFlag;
        @JsonProperty("OwnerUin")
        private Long OwnerUin;
        @JsonProperty("PYInitial")
        private String PYInitial;
        @JsonProperty("PYQuanPin")
        private String PYQuanPin;
        @JsonProperty("RemarkPYInitial")
        private String RemarkPYInitial;
        @JsonProperty("RemarkPYQuanPin")
        private String RemarkPYQuanPin;
        @JsonProperty("StarFriend")
        private Long StarFriend;
        @JsonProperty("AppAccountFlag")
        private Long AppAccountFlag;
        @JsonProperty("Statues")
        private Long Statues;
        @JsonProperty("AttrStatus")
        private Long AttrStatus;
        @JsonProperty("Province")
        private String Province;
        @JsonProperty("City")
        private String City;
        @JsonProperty("Alias")
        private String Alias;
        @JsonProperty("SnsFlag")
        private Long SnsFlag;
        @JsonProperty("UniFriend")
        private Long UniFriend;
        @JsonProperty("DisplayName")
        private String DisplayName;
        @JsonProperty("ChatRoomId")
        private Long ChatRoomId;
        @JsonProperty("KeyWord")
        private String KeyWord;
        @JsonProperty("EncryChatRoomId")
        private String EncryChatRoomId;
        @JsonProperty("IsOwner")
        private Long IsOwner;
        @JsonProperty("MemberList")
        private List<?> MemberList;

        public Long getUin() {
            return Uin;
        }

        public void setUin(Long Uin) {
            this.Uin = Uin;
        }

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

        public String getHeadImgUrl() {
            return HeadImgUrl;
        }

        public void setHeadImgUrl(String HeadImgUrl) {
            this.HeadImgUrl = HeadImgUrl;
        }

        public Long getContactFlag() {
            return ContactFlag;
        }

        public void setContactFlag(Long ContactFlag) {
            this.ContactFlag = ContactFlag;
        }

        public Long getMemberCount() {
            return MemberCount;
        }

        public void setMemberCount(Long MemberCount) {
            this.MemberCount = MemberCount;
        }

        public String getRemarkName() {
            return RemarkName;
        }

        public void setRemarkName(String RemarkName) {
            this.RemarkName = RemarkName;
        }

        public Long getHideInputBarFlag() {
            return HideInputBarFlag;
        }

        public void setHideInputBarFlag(Long HideInputBarFlag) {
            this.HideInputBarFlag = HideInputBarFlag;
        }

        public Long getSex() {
            return Sex;
        }

        public void setSex(Long Sex) {
            this.Sex = Sex;
        }

        public String getSignature() {
            return Signature;
        }

        public void setSignature(String Signature) {
            this.Signature = Signature;
        }

        public Long getVerifyFlag() {
            return VerifyFlag;
        }

        public void setVerifyFlag(Long VerifyFlag) {
            this.VerifyFlag = VerifyFlag;
        }

        public Long getOwnerUin() {
            return OwnerUin;
        }

        public void setOwnerUin(Long OwnerUin) {
            this.OwnerUin = OwnerUin;
        }

        public String getPYInitial() {
            return PYInitial;
        }

        public void setPYInitial(String PYInitial) {
            this.PYInitial = PYInitial;
        }

        public String getPYQuanPin() {
            return PYQuanPin;
        }

        public void setPYQuanPin(String PYQuanPin) {
            this.PYQuanPin = PYQuanPin;
        }

        public String getRemarkPYInitial() {
            return RemarkPYInitial;
        }

        public void setRemarkPYInitial(String RemarkPYInitial) {
            this.RemarkPYInitial = RemarkPYInitial;
        }

        public String getRemarkPYQuanPin() {
            return RemarkPYQuanPin;
        }

        public void setRemarkPYQuanPin(String RemarkPYQuanPin) {
            this.RemarkPYQuanPin = RemarkPYQuanPin;
        }

        public Long getStarFriend() {
            return StarFriend;
        }

        public void setStarFriend(Long StarFriend) {
            this.StarFriend = StarFriend;
        }

        public Long getAppAccountFlag() {
            return AppAccountFlag;
        }

        public void setAppAccountFlag(Long AppAccountFlag) {
            this.AppAccountFlag = AppAccountFlag;
        }

        public Long getStatues() {
            return Statues;
        }

        public void setStatues(Long Statues) {
            this.Statues = Statues;
        }

        public Long getAttrStatus() {
            return AttrStatus;
        }

        public void setAttrStatus(Long AttrStatus) {
            this.AttrStatus = AttrStatus;
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

        public String getAlias() {
            return Alias;
        }

        public void setAlias(String Alias) {
            this.Alias = Alias;
        }

        public Long getSnsFlag() {
            return SnsFlag;
        }

        public void setSnsFlag(Long SnsFlag) {
            this.SnsFlag = SnsFlag;
        }

        public Long getUniFriend() {
            return UniFriend;
        }

        public void setUniFriend(Long UniFriend) {
            this.UniFriend = UniFriend;
        }

        public String getDisplayName() {
            return DisplayName;
        }

        public void setDisplayName(String DisplayName) {
            this.DisplayName = DisplayName;
        }

        public Long getChatRoomId() {
            return ChatRoomId;
        }

        public void setChatRoomId(Long ChatRoomId) {
            this.ChatRoomId = ChatRoomId;
        }

        public String getKeyWord() {
            return KeyWord;
        }

        public void setKeyWord(String KeyWord) {
            this.KeyWord = KeyWord;
        }

        public String getEncryChatRoomId() {
            return EncryChatRoomId;
        }

        public void setEncryChatRoomId(String EncryChatRoomId) {
            this.EncryChatRoomId = EncryChatRoomId;
        }

        public Long getIsOwner() {
            return IsOwner;
        }

        public void setIsOwner(Long IsOwner) {
            this.IsOwner = IsOwner;
        }

        public List<?> getMemberList() {
            return MemberList;
        }

        public void setMemberList(List<?> MemberList) {
            this.MemberList = MemberList;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class MPSubscribeMsgListBean {
        /**
         * UserName : @be9e66a38295cf8896ac3ad980ff420c
         * MPArticleCount : 3
         * MPArticleList : [{"Title":"æŸ\u0090äº\u2019è\u0081\u201dç½\u2018ä¼\u0081ä¸šï¼šç \u201då\u008f\u2018äººå\u2018˜è¦\u0081ä¹ˆæ\u2014 è\u2013ªè½¬é\u201d\u20acå\u201d®å²\u2014ï¼\u0081è¦\u0081ä¹ˆä¸»åŠ¨è¾žé\u20ac\u20acï¼\u0081","Digest":"ç\u2013«æƒ\u2026ä¸\u2039ï¼Œä¼\u0081ä¸šçœŸå®žçŽ°çŠ¶ï¼\u0081","Cover":"https://mmbiz.qpic.cn/sz_mmbiz_jpg/HChpp7QY6Gd3vCOq9uia7LONAWEb7RUPt8W7d7RsWAer7wNZunJGaUqFc0bSgYnPEIEia07JPN74e4Tlg71zObFA/640?wxtype=jpeg&wxfrom=0","Url":"http://mp.weixin.qq.com/s?__biz=MzU3Njc1MDAxNg==&mid=2247486344&idx=1&sn=7e493f6aeb1df633c4348182b1a33b9c&chksm=fd0e6327ca79ea31ac8d1f9513091565a9d2e834a1357a5aa624466a23fb6eaa6ce4051dcac0&scene=0&xtrack=1#rd"},{"Title":"ç¡®è®¤ï¼\u0081åˆ«å\u2020\u008dç\u203a¸ä¿¡Pythonäº\u2020ï¼\u0081 ç¨\u2039åº\u008få\u2018˜ï¼šå°±ä½ æ\u2022¢è¯´...","Digest":"Pythonäººçº¢æ˜¯é\u009džå¤šï¼\u0081","Cover":"https://mmbiz.qpic.cn/mmbiz_jpg/jtj44vboaF288K1ibAXoctdJUOIldLufMsNDAh8UwW2JiaFSE4DMWM1sz9DIryoib79Qv9buDjgDpI4lASjgYU6JQ/300?wxtype=jpeg&wxfrom=0","Url":"http://mp.weixin.qq.com/s?__biz=MzU3Njc1MDAxNg==&mid=2247486344&idx=2&sn=e4ab0eb6d05f8acb80d43bbd90abaebc&chksm=fd0e6327ca79ea31929e485d7d51204530c98047ef93cb1a4201db6c55d4686abf937b0216e1&scene=0&xtrack=1#rd"},{"Title":"2020å¹´æœ\u20acæ\u2013°é£Žå\u008f£ï¼\u0081200ä¸\u2021ç¼ºå\u008f£ï¼Œå\u0081šå¯¹è¿™å\u2021 ç\u201a¹ï¼ŒåŠ©ä½ å\u008d\u2021è\u0081ŒåŠ è\u2013ªï¼\u0081","Digest":"å¦\u201aæžœä½ æ\u2014 æ³\u2022è¡¡é\u2021\u008fï¼Œä½ å°±æ\u2014 æ³\u2022å¢žé\u2022¿ã\u20ac\u201a","Cover":"https://mmbiz.qpic.cn/mmbiz_jpg/Z0mwlhqia2u56F1m7c2sQouiav0oib6DrTqLP1LdSHYrkt4Nco0Y36uyVt4hlYOlgGky3clGxBv60w6ia0pnmuRjtA/300?wxtype=jpeg&wxfrom=0","Url":"http://mp.weixin.qq.com/s?__biz=MzU3Njc1MDAxNg==&mid=2247486344&idx=3&sn=4a771a4acdd3bfc44f54b26390a3b93f&chksm=fd0e6327ca79ea310379942975087bfef63bbae5e20b14f17a0c3ffb087bcf2208c6498fa272&scene=0&xtrack=1#rd"}]
         * Time : 1582608855
         * NickName : CSDNå­¦é™¢ç²¾å“è¯¾
         */

        @JsonProperty("UserName")
        private String UserName;
        @JsonProperty("MPArticleCount")
        private Long MPArticleCount;
        @JsonProperty("Time")
        private Long Time;
        @JsonProperty("NickName")
        private String NickName;
        @JsonProperty("MPArticleList")
        private List<MPArticleListBean> MPArticleList;

        public String getUserName() {
            return UserName;
        }

        public void setUserName(String UserName) {
            this.UserName = UserName;
        }

        public Long getMPArticleCount() {
            return MPArticleCount;
        }

        public void setMPArticleCount(Long MPArticleCount) {
            this.MPArticleCount = MPArticleCount;
        }

        public Long getTime() {
            return Time;
        }

        public void setTime(Long Time) {
            this.Time = Time;
        }

        public String getNickName() {
            return NickName;
        }

        public void setNickName(String NickName) {
            this.NickName = NickName;
        }

        public List<MPArticleListBean> getMPArticleList() {
            return MPArticleList;
        }

        public void setMPArticleList(List<MPArticleListBean> MPArticleList) {
            this.MPArticleList = MPArticleList;
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class MPArticleListBean {
            /**
             * Title : æŸäº’è”ç½‘ä¼ä¸šï¼šç ”å‘äººå‘˜è¦ä¹ˆæ— è–ªè½¬é”€å”®å²—ï¼è¦ä¹ˆä¸»åŠ¨è¾žé€€ï¼
             * Digest : ç–«æƒ…ä¸‹ï¼Œä¼ä¸šçœŸå®žçŽ°çŠ¶ï¼
             * Cover : https://mmbiz.qpic.cn/sz_mmbiz_jpg/HChpp7QY6Gd3vCOq9uia7LONAWEb7RUPt8W7d7RsWAer7wNZunJGaUqFc0bSgYnPEIEia07JPN74e4Tlg71zObFA/640?wxtype=jpeg&wxfrom=0
             * Url : http://mp.weixin.qq.com/s?__biz=MzU3Njc1MDAxNg==&mid=2247486344&idx=1&sn=7e493f6aeb1df633c4348182b1a33b9c&chksm=fd0e6327ca79ea31ac8d1f9513091565a9d2e834a1357a5aa624466a23fb6eaa6ce4051dcac0&scene=0&xtrack=1#rd
             */

            @JsonProperty("Title")
            private String Title;
            @JsonProperty("Digest")
            private String Digest;
            @JsonProperty("Cover")
            private String Cover;
            @JsonProperty("Url")
            private String Url;

            public String getTitle() {
                return Title;
            }

            public void setTitle(String Title) {
                this.Title = Title;
            }

            public String getDigest() {
                return Digest;
            }

            public void setDigest(String Digest) {
                this.Digest = Digest;
            }

            public String getCover() {
                return Cover;
            }

            public void setCover(String Cover) {
                this.Cover = Cover;
            }

            public String getUrl() {
                return Url;
            }

            public void setUrl(String Url) {
                this.Url = Url;
            }
        }
    }

    @JacksonXmlRootElement(localName = "error")
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class SecurityBean {
        @JacksonXmlProperty(localName = "skey")
        private String skey;
        @JacksonXmlProperty(localName = "wxsid")
        private String wxsid;
        @JacksonXmlProperty(localName = "wxuin")
        private String wxuin;
        @JacksonXmlProperty(localName = "pass_ticket")
        private String passTicket;
        @JacksonXmlProperty(localName = "message")
        private String message;

        private String webwxDataTicket;
        private String webwxAuthTicket;
        private String uuid;
        private String qrcode;
        private String deviceId;

        public String getDeviceId() {
            return deviceId;
        }

        public void setDeviceId(String deviceId) {
            this.deviceId = deviceId;
        }

        public SecurityBean() {
        }

        public SecurityBean(String uuid, String qrcode) {
            this.uuid = uuid;
            this.qrcode = qrcode;
        }

        public String getQrcode() {
            return qrcode;
        }

        public void setQrcode(String qrcode) {
            this.qrcode = qrcode;
        }

        public String getUuid() {
            return uuid;
        }

        public void setUuid(String uuid) {
            this.uuid = uuid;
        }

        public String getSkey() {
            return skey;
        }

        public void setSkey(String skey) {
            this.skey = skey;
        }

        public String getWxsid() {
            return wxsid;
        }

        public void setWxsid(String wxsid) {
            this.wxsid = wxsid;
        }

        public String getWxuin() {
            return wxuin;
        }

        public void setWxuin(String wxuin) {
            this.wxuin = wxuin;
        }

        public String getPassTicket() {
            return passTicket;
        }

        public void setPassTicket(String passTicket) {
            this.passTicket = passTicket;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getWebwxDataTicket() {
            return webwxDataTicket;
        }

        public void setWebwxDataTicket(String webwxDataTicket) {
            this.webwxDataTicket = webwxDataTicket;
        }

        public String getWebwxAuthTicket() {
            return webwxAuthTicket;
        }

        public void setWebwxAuthTicket(String webwxAuthTicket) {
            this.webwxAuthTicket = webwxAuthTicket;
        }
    }
}
