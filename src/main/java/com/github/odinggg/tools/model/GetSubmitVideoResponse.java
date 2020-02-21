package com.github.odinggg.tools.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * 描述:
 * 获取用户视频返回实体
 *
 * @author Hansen
 * @version 2019-11-05 14:17
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetSubmitVideoResponse {

    /**
     * status : true
     * data : {"tlist":{"36":{"tid":36,"count":305,"name":"科技"}},"vlist":[{"comment":1,"typeid":39,"play":576,"pic":"//i0.hdslb.com/bfs/archive/c4415d5c5014d635e0e096f29f3c9e32ade3d7d9.jpg","subtitle":"","description":"编程技术交流群：167399488（勿吹水闲聊）\n视频教程源于网络仅供学习，若有侵权，私信删除。\n【请勿相信视频中出现的网址和企鹅号及二维码等联系信息，以防上当受骗】\nup的编程技术交流小组在主页，资料也在小组中，大家一起交流哦。","copyright":"","title":"【薪资突破20K】JavaEE在职加薪课之大数据转型必备课程-Hadoop3","review":0,"author":"真全栈程序员","mid":362268332,"is_union_video":0,"created":1572616842,"length":"1296:22","video_review":0,"is_pay":0,"favorites":75,"aid":74044043,"is_steins_gate":0,"hide_click":false},{"comment":2,"typeid":39,"play":360,"pic":"//i1.hdslb.com/bfs/archive/b2fd1403f6b701298a85c5e34ee1b4dc146665cf.jpg","subtitle":"","description":"编程技术交流群：167399488（勿吹水闲聊）\n视频教程源于网络仅供学习，若有侵权，私信删除。\n【请勿相信视频中出现的网址和企鹅号及二维码等联系信息，以防上当受骗】\nup的编程技术交流小组在主页，资料也在小组中，大家一起交流哦。","copyright":"","title":"【薪资突破20K】JavaEE在职加薪课之互联网全终端微服务项目-好客租房","review":0,"author":"真全栈程序员","mid":362268332,"is_union_video":0,"created":1572591646,"length":"3614:44","video_review":0,"is_pay":0,"favorites":86,"aid":74030429,"is_steins_gate":0,"hide_click":false},{"comment":1,"typeid":39,"play":253,"pic":"//i0.hdslb.com/bfs/archive/672f72d400a6dda7f18266b558bdb547bca569af.jpg","subtitle":"","description":"编程技术交流群：167399488（勿吹水闲聊）\n视频教程源于网络仅供学习，若有侵权，私信删除。\n【请勿相信视频中出现的网址和企鹅号及二维码等联系信息，以防上当受骗】\nup的编程技术交流小组在主页，资料也在小组中，大家一起交流哦。","copyright":"","title":"【薪资突破20K】JavaEE在职加薪课之传统行业解决方案SaaS-HRM项目","review":0,"author":"真全栈程序员","mid":362268332,"is_union_video":0,"created":1572573623,"length":"3141:10","video_review":0,"is_pay":0,"favorites":52,"aid":74019610,"is_steins_gate":0,"hide_click":false},{"comment":3,"typeid":39,"play":299,"pic":"//i1.hdslb.com/bfs/archive/0f21c61a639bc01de39f981cd51cc1d27e48c17a.jpg","subtitle":"","description":"编程技术交流群：167399488（勿吹水闲聊）\n视频教程源于网络仅供学习，若有侵权，私信删除。\n【请勿相信视频中出现的网址和企鹅号及二维码等联系信息，以防上当受骗】\nup的编程技术交流小组在主页，资料也在小组中，大家一起交流哦。","copyright":"","title":"【薪资突破20K】JavaEE在职加薪课之Netty网络编程","review":0,"author":"真全栈程序员","mid":362268332,"is_union_video":0,"created":1572530725,"length":"322:10","video_review":0,"is_pay":0,"favorites":49,"aid":74016796,"is_steins_gate":0,"hide_click":false},{"comment":1,"typeid":39,"play":172,"pic":"//i2.hdslb.com/bfs/archive/ab2071fa40e39bb7a14ba9dccc3c8ca4482538c6.jpg","subtitle":"","description":"编程技术交流群：167399488（勿吹水闲聊）\n视频教程源于网络仅供学习，若有侵权，私信删除。\n【请勿相信视频中出现的网址和企鹅号及二维码等联系信息，以防上当受骗】\nup的编程技术交流小组在主页，资料也在小组中，大家一起交流哦。","copyright":"","title":"【薪资突破20K】JavaEE在职加薪课之ORM思想及相关框架实现原理","review":0,"author":"真全栈程序员","mid":362268332,"is_union_video":0,"created":1572530421,"length":"473:09","video_review":0,"is_pay":0,"favorites":26,"aid":74015037,"is_steins_gate":0,"hide_click":false},{"comment":1,"typeid":39,"play":219,"pic":"//i1.hdslb.com/bfs/archive/190cf326eb3b52b323f77ecde53f035847a61ce2.jpg","subtitle":"","description":"编程技术交流群：167399488（勿吹水闲聊）\n视频教程源于网络仅供学习，若有侵权，私信删除。\n【请勿相信视频中出现的网址和企鹅号及二维码等联系信息，以防上当受骗】\nup的编程技术交流小组在主页，资料也在小组中，大家一起交流哦。","copyright":"","title":"【薪资突破20K】JavaEE在职加薪课之NIO与Netty编程","review":0,"author":"真全栈程序员","mid":362268332,"is_union_video":0,"created":1572527414,"length":"559:13","video_review":0,"is_pay":0,"favorites":38,"aid":74017593,"is_steins_gate":0,"hide_click":false},{"comment":1,"typeid":39,"play":200,"pic":"//i2.hdslb.com/bfs/archive/f8ade4729b53c08e3c179aa0460bf1eb3479018d.jpg","subtitle":"","description":"编程技术交流群：167399488（勿吹水闲聊）\n视频教程源于网络仅供学习，若有侵权，私信删除。\n【请勿相信视频中出现的网址和企鹅号及二维码等联系信息，以防上当受骗】\nup的编程技术交流小组在主页，资料也在小组中，大家一起交流哦。","copyright":"","title":"【薪资突破20K】JavaEE在职加薪课之MVC模式详解","review":0,"author":"真全栈程序员","mid":362268332,"is_union_video":0,"created":1572517819,"length":"343:53","video_review":0,"is_pay":0,"favorites":27,"aid":74013574,"is_steins_gate":0,"hide_click":false},{"comment":1,"typeid":39,"play":249,"pic":"//i0.hdslb.com/bfs/archive/9d8bc932a5e8f202664dd2b483b7975c2e0a0979.jpg","subtitle":"","description":"编程技术交流群：167399488（勿吹水闲聊）\n视频教程源于网络仅供学习，若有侵权，私信删除。\n【请勿相信视频中出现的网址和企鹅号及二维码等联系信息，以防上当受骗】\nup的编程技术交流小组在主页，资料也在小组中，大家一起交流哦。","copyright":"","title":"【薪资突破20K】JavaEE在职加薪课之MySQL数据库优化","review":0,"author":"真全栈程序员","mid":362268332,"is_union_video":0,"created":1572514854,"length":"609:08","video_review":0,"is_pay":0,"favorites":65,"aid":74011321,"is_steins_gate":0,"hide_click":false},{"comment":1,"typeid":39,"play":234,"pic":"//i0.hdslb.com/bfs/archive/20818e3e7f1b0f3470da83fe10afcae45dab945d.jpg","subtitle":"","description":"编程技术交流群：167399488（勿吹水闲聊）\n视频教程源于网络仅供学习，若有侵权，私信删除。\n【请勿相信视频中出现的网址和企鹅号及二维码等联系信息，以防上当受骗】\nup的编程技术交流小组在主页，资料也在小组中，大家一起交流哦。","copyright":"","title":"【薪资突破20K】JavaEE在职加薪课之JVM优化","review":0,"author":"真全栈程序员","mid":362268332,"is_union_video":0,"created":1572512744,"length":"461:37","video_review":1,"is_pay":0,"favorites":52,"aid":74007143,"is_steins_gate":0,"hide_click":false},{"comment":1,"typeid":39,"play":200,"pic":"//i1.hdslb.com/bfs/archive/4cb39bfd513a265a451e11e6335641b429d929cf.jpg","subtitle":"","description":"编程技术交流群：167399488（勿吹水闲聊）\n视频教程源于网络仅供学习，若有侵权，私信删除。\n【请勿相信视频中出现的网址和企鹅号及二维码等联系信息，以防上当受骗】\nup的编程技术交流小组在主页，资料也在小组中，大家一起交流哦。","copyright":"","title":"【薪资突破20K】JavaEE在职加薪课之华为云PaaS微服务治理课程（CSE Mesher开发）","review":0,"author":"真全栈程序员","mid":362268332,"is_union_video":0,"created":1572487816,"length":"912:09","video_review":0,"is_pay":0,"favorites":25,"aid":73988821,"is_steins_gate":0,"hide_click":false},{"comment":1,"typeid":39,"play":59,"pic":"//i2.hdslb.com/bfs/archive/d746866d23044d38e230a90024ef27bbbb491478.jpg","subtitle":"","description":"编程技术交流群：167399488（勿吹水闲聊）\n视频教程源于网络仅供学习，若有侵权，私信删除。\n【请勿相信视频中出现的网址和企鹅号及二维码等联系信息，以防上当受骗】\nup的编程技术交流小组在主页，资料也在小组中，大家一起交流哦。","copyright":"","title":"【薪资突破20K】JavaEE在职加薪课之容器化进阶K8S","review":0,"author":"真全栈程序员","mid":362268332,"is_union_video":0,"created":1572487514,"length":"153:41","video_review":0,"is_pay":0,"favorites":18,"aid":73987567,"is_steins_gate":0,"hide_click":false},{"comment":1,"typeid":39,"play":105,"pic":"//i1.hdslb.com/bfs/archive/361014ebb0ab5e6f8d517dfd04aabb8bdb2ed553.jpg","subtitle":"","description":"编程技术交流群：167399488（勿吹水闲聊）\n视频教程源于网络仅供学习，若有侵权，私信删除。\n【请勿相信视频中出现的网址和企鹅号及二维码等联系信息，以防上当受骗】\nup的编程技术交流小组在主页，资料也在小组中，大家一起交流哦。","copyright":"","title":"【薪资突破20K】JavaEE在职加薪课之Apache ServiceComb课程","review":0,"author":"真全栈程序员","mid":362268332,"is_union_video":0,"created":1572487207,"length":"371:00","video_review":0,"is_pay":0,"favorites":18,"aid":73984460,"is_steins_gate":0,"hide_click":false},{"comment":3,"typeid":39,"play":400,"pic":"//i1.hdslb.com/bfs/archive/544d0f9051f315fc9a99c1b5bfe8feb4fbb34312.jpg","subtitle":"","description":"编程技术交流群：167399488（勿吹水闲聊）\n视频教程源于网络仅供学习，若有侵权，私信删除。\n【请勿相信视频中出现的网址和企鹅号及二维码等联系信息，以防上当受骗】\nup的编程技术交流小组在主页，资料也在小组中，大家一起交流哦。","copyright":"","title":"【薪资突破20K】JavaEE在职加薪课之微服务实战项目学成在线","review":0,"author":"真全栈程序员","mid":362268332,"is_union_video":0,"created":1572450033,"length":"3575:46","video_review":0,"is_pay":0,"favorites":92,"aid":73943722,"is_steins_gate":0,"hide_click":false},{"comment":1,"typeid":39,"play":192,"pic":"//i1.hdslb.com/bfs/archive/18dcb07d92a23422c51153e044d97d16190885e5.jpg","subtitle":"","description":"编程技术交流群：167399488（勿吹水闲聊）\n视频教程源于网络仅供学习，若有侵权，私信删除。\n【请勿相信视频中出现的网址和企鹅号及二维码等联系信息，以防上当受骗】\nup的编程技术交流小组在主页，资料也在小组中，大家一起交流哦。","copyright":"","title":"【薪资突破20K】JavaEE在职加薪课之Git版本控制","review":0,"author":"真全栈程序员","mid":362268332,"is_union_video":0,"created":1572449432,"length":"160:03","video_review":0,"is_pay":0,"favorites":32,"aid":73934404,"is_steins_gate":0,"hide_click":false},{"comment":1,"typeid":39,"play":351,"pic":"//i1.hdslb.com/bfs/archive/06af42e8fd4c75faf87a48e51be59abda8c41ce0.jpg","subtitle":"","description":"编程技术交流群：167399488（勿吹水闲聊）\n视频教程源于网络仅供学习，若有侵权，私信删除。\n【请勿相信视频中出现的网址和企鹅号及二维码等联系信息，以防上当受骗】\nup的编程技术交流小组在主页，资料也在小组中，大家一起交流哦。","copyright":"","title":"【薪资突破20K】JavaEE在职加薪课之Docker容器化","review":0,"author":"真全栈程序员","mid":362268332,"is_union_video":0,"created":1572427440,"length":"142:02","video_review":0,"is_pay":0,"favorites":55,"aid":73933339,"is_steins_gate":0,"hide_click":false},{"comment":1,"typeid":39,"play":109,"pic":"//i1.hdslb.com/bfs/archive/f25025150848e257b433cbfd2ce02ce9316eea18.jpg","subtitle":"","description":"编程技术交流群：167399488（勿吹水闲聊）\n视频教程源于网络仅供学习，若有侵权，私信删除。\n【请勿相信视频中出现的网址和企鹅号及二维码等联系信息，以防上当受骗】\nup的编程技术交流小组在主页，资料也在小组中，大家一起交流哦。","copyright":"","title":"【薪资突破20K】JavaEE在职加薪课之持续集成与容器管理","review":0,"author":"真全栈程序员","mid":362268332,"is_union_video":0,"created":1572426921,"length":"124:56","video_review":0,"is_pay":0,"favorites":32,"aid":73933923,"is_steins_gate":0,"hide_click":false},{"comment":1,"typeid":39,"play":146,"pic":"//i1.hdslb.com/bfs/archive/78de44299db20280ead9b8e427b11d8878013e7a.jpg","subtitle":"","description":"编程技术交流群：167399488（勿吹水闲聊）\n视频教程源于网络仅供学习，若有侵权，私信删除。\n【请勿相信视频中出现的网址和企鹅号及二维码等联系信息，以防上当受骗】\nup的编程技术交流小组在主页，资料也在小组中，大家一起交流哦。","copyright":"","title":"【薪资突破20K】JavaEE在职加薪课之SpringBoot微服务快速开发","review":0,"author":"真全栈程序员","mid":362268332,"is_union_video":0,"created":1572426443,"length":"175:13","video_review":0,"is_pay":0,"favorites":20,"aid":73932253,"is_steins_gate":0,"hide_click":false},{"comment":1,"typeid":39,"play":260,"pic":"//i0.hdslb.com/bfs/archive/fafd74f0f1a774cdf8af05401f039c195e908600.jpg","subtitle":"","description":"编程技术交流群：167399488（勿吹水闲聊）\n视频教程源于网络仅供学习，若有侵权，私信删除。\n【请勿相信视频中出现的网址和企鹅号及二维码等联系信息，以防上当受骗】\nup的编程技术交流小组在主页，资料也在小组中，大家一起交流哦。","copyright":"","title":"【薪资突破20K】JavaEE在职加薪课之Maven项目管理工具","review":0,"author":"真全栈程序员","mid":362268332,"is_union_video":0,"created":1572425430,"length":"326:17","video_review":0,"is_pay":0,"favorites":41,"aid":73930019,"is_steins_gate":0,"hide_click":false},{"comment":1,"typeid":39,"play":174,"pic":"//i2.hdslb.com/bfs/archive/4e2dde49d45eba99939b5fb6d9d7b37ba435266e.jpg","subtitle":"","description":"编程技术交流群：167399488（勿吹水闲聊）\n视频教程源于网络仅供学习，若有侵权，私信删除。\n【请勿相信视频中出现的网址和企鹅号及二维码等联系信息，以防上当受骗】\nup的编程技术交流小组在主页，资料也在小组中，大家一起交流哦。","copyright":"","title":"UI培训就业课程之flash+axure（6天）","review":0,"author":"真全栈程序员","mid":362268332,"is_union_video":0,"created":1572333430,"length":"911:57","video_review":0,"is_pay":0,"favorites":23,"aid":73822404,"is_steins_gate":0,"hide_click":false},{"comment":1,"typeid":39,"play":275,"pic":"//i1.hdslb.com/bfs/archive/52d899109351d0f8394e3e92563c335d4297b910.jpg","subtitle":"","description":"编程技术交流群：167399488（勿吹水闲聊）\n视频教程源于网络仅供学习，若有侵权，私信删除。\n【请勿相信视频中出现的网址和企鹅号及二维码等联系信息，以防上当受骗】\nup的编程技术交流小组在主页，资料也在小组中，大家一起交流哦。","copyright":"","title":"UI培训就业课程之JavaScript+jQuery+响应式（17天）","review":0,"author":"真全栈程序员","mid":362268332,"is_union_video":0,"created":1572323978,"length":"3037:00","video_review":0,"is_pay":0,"favorites":77,"aid":73808680,"is_steins_gate":0,"hide_click":false},{"comment":1,"typeid":39,"play":196,"pic":"//i0.hdslb.com/bfs/archive/ac22e038124d9d9b47b2658cb24e15c550b7328f.jpg","subtitle":"","description":"编程技术交流群：167399488（勿吹水闲聊）\n视频教程源于网络仅供学习，若有侵权，私信删除。\n【请勿相信视频中出现的网址和企鹅号及二维码等联系信息，以防上当受骗】\nup的编程技术交流小组在主页，资料也在小组中，大家一起交流哦。","copyright":"","title":"UI培训就业课程之HTML+CSS+项目实战（15天）","review":0,"author":"真全栈程序员","mid":362268332,"is_union_video":0,"created":1572314718,"length":"2276:08","video_review":0,"is_pay":0,"favorites":50,"aid":73785611,"is_steins_gate":0,"hide_click":false},{"comment":1,"typeid":39,"play":171,"pic":"//i2.hdslb.com/bfs/archive/716b4abcc91c7bddf4ddadb174fc500a8c1d60d3.jpg","subtitle":"","description":"编程技术交流群：167399488（勿吹水闲聊）\n视频教程源于网络仅供学习，若有侵权，私信删除。\n【请勿相信视频中出现的网址和企鹅号及二维码等联系信息，以防上当受骗】\nup的编程技术交流小组在主页，资料也在小组中，大家一起交流哦。","copyright":"","title":"UI培训就业课程之UI设计（10天）","review":0,"author":"真全栈程序员","mid":362268332,"is_union_video":0,"created":1572314410,"length":"1734:51","video_review":0,"is_pay":0,"favorites":49,"aid":73784104,"is_steins_gate":0,"hide_click":false},{"comment":1,"typeid":39,"play":145,"pic":"//i2.hdslb.com/bfs/archive/6bb77feab5e122458dc17195d891fde071ab4416.jpg","subtitle":"","description":"编程技术交流群：167399488（勿吹水闲聊）\n视频教程源于网络仅供学习，若有侵权，私信删除。\n【请勿相信视频中出现的网址和企鹅号及二维码等联系信息，以防上当受骗】\nup的编程技术交流小组在主页，资料也在小组中，大家一起交流哦。","copyright":"","title":"UI培训就业课程之电商设计+网页设计（11天）","review":0,"author":"真全栈程序员","mid":362268332,"is_union_video":0,"created":1572273979,"length":"2195:41","video_review":0,"is_pay":0,"favorites":46,"aid":73768485,"is_steins_gate":0,"hide_click":false},{"comment":2,"typeid":39,"play":267,"pic":"//i1.hdslb.com/bfs/archive/01889924be3a7195bbc814e599379a0346cd2cd3.jpg","subtitle":"","description":"编程技术交流群：167399488（勿吹水闲聊）\n视频教程源于网络仅供学习，若有侵权，私信删除。\n【请勿相信视频中出现的网址和企鹅号及二维码等联系信息，以防上当受骗】\nup的编程技术交流小组在主页，资料也在小组中，大家一起交流哦。","copyright":"","title":"UI培训就业课程之PS+Adobe illustrator+实战+实用美术课程（17天）","review":0,"author":"真全栈程序员","mid":362268332,"is_union_video":0,"created":1572193452,"length":"3600:49","video_review":0,"is_pay":0,"favorites":56,"aid":73667530,"is_steins_gate":0,"hide_click":false},{"comment":4,"typeid":39,"play":1693,"pic":"//i0.hdslb.com/bfs/archive/0a823d63d1d5836bdb5dbd12618ff0b9209539d1.jpg","subtitle":"","description":"编程技术交流群：167399488（勿吹水闲聊）\n视频教程源于网络仅供学习，若有侵权，私信删除。\n【请勿相信视频中出现的网址和企鹅号及二维码等联系信息，以防上当受骗】\nup的编程技术交流小组在主页，资料也在小组中，大家一起交流哦。","copyright":"","title":"嵌入式之WiFi智能家居项目实战","review":0,"author":"真全栈程序员","mid":362268332,"is_union_video":0,"created":1572098714,"length":"491:55","video_review":1,"is_pay":0,"favorites":250,"aid":73413553,"is_steins_gate":0,"hide_click":false},{"comment":3,"typeid":39,"play":635,"pic":"//i0.hdslb.com/bfs/archive/cb4ffa7e0cd858c849ca4e828765dc70917ee745.jpg","subtitle":"","description":"编程技术交流群：167399488（勿吹水闲聊）\n视频教程源于网络仅供学习，若有侵权，私信删除。\n【请勿相信视频中出现的网址和企鹅号及二维码等联系信息，以防上当受骗】\nup的编程技术交流小组在主页，资料也在小组中，大家一起交流哦。","copyright":"","title":"嵌入式之NB-IOT技术实践开发物联网智慧消防项目","review":0,"author":"真全栈程序员","mid":362268332,"is_union_video":0,"created":1572098411,"length":"502:38","video_review":5,"is_pay":0,"favorites":115,"aid":73412515,"is_steins_gate":0,"hide_click":false},{"comment":5,"typeid":39,"play":751,"pic":"//i0.hdslb.com/bfs/archive/4e46d3de78a010d32a566f49c2802ab9ab9b63f1.jpg","subtitle":"","description":"编程技术交流群：167399488（勿吹水闲聊）\n视频教程源于网络仅供学习，若有侵权，私信删除。\n【请勿相信视频中出现的网址和企鹅号及二维码等联系信息，以防上当受骗】\nup的编程技术交流小组在主页，资料也在小组中，大家一起交流哦。","copyright":"","title":"嵌入式之LoRa开发与应用","review":0,"author":"真全栈程序员","mid":362268332,"is_union_video":0,"created":1572077124,"length":"592:12","video_review":1,"is_pay":0,"favorites":114,"aid":73410784,"is_steins_gate":0,"hide_click":false},{"comment":2,"typeid":39,"play":522,"pic":"//i2.hdslb.com/bfs/archive/95054d93d8e2e03205802196e23e7fa4adbdedb8.jpg","subtitle":"","description":"编程技术交流群：167399488（勿吹水闲聊）\n视频教程源于网络仅供学习，若有侵权，私信删除。\n【请勿相信视频中出现的网址和企鹅号及二维码等联系信息，以防上当受骗】\nup的编程技术交流小组在主页，资料也在小组中，大家一起交流哦。","copyright":"","title":"嵌入式之RFID开发与应用","review":0,"author":"真全栈程序员","mid":362268332,"is_union_video":0,"created":1572076821,"length":"303:49","video_review":0,"is_pay":0,"favorites":87,"aid":73409046,"is_steins_gate":0,"hide_click":false},{"comment":1,"typeid":39,"play":553,"pic":"//i1.hdslb.com/bfs/archive/6d3d409327935d1e9400c4894f58b2ea70719c22.jpg","subtitle":"","description":"编程技术交流群：167399488（勿吹水闲聊）\n视频教程源于网络仅供学习，若有侵权，私信删除。\n【请勿相信视频中出现的网址和企鹅号及二维码等联系信息，以防上当受骗】\nup的编程技术交流小组在主页，资料也在小组中，大家一起交流哦。","copyright":"","title":"嵌入式之蓝牙4.0 BLE和智能手环实战","review":0,"author":"真全栈程序员","mid":362268332,"is_union_video":0,"created":1572055542,"length":"395:38","video_review":0,"is_pay":0,"favorites":103,"aid":73408053,"is_steins_gate":0,"hide_click":false},{"comment":1,"typeid":39,"play":496,"pic":"//i0.hdslb.com/bfs/archive/8107adf12df09163554bf654bef9ce9128aeaef8.jpg","subtitle":"","description":"编程技术交流群：167399488（勿吹水闲聊）\n视频教程源于网络仅供学习，若有侵权，私信删除。\n【请勿相信视频中出现的网址和企鹅号及二维码等联系信息，以防上当受骗】\nup的编程技术交流小组在主页，资料也在小组中，大家一起交流哦。","copyright":"","title":"嵌入式之ZigBee系统开发实战","review":0,"author":"真全栈程序员","mid":362268332,"is_union_video":0,"created":1572055226,"length":"468:42","video_review":1,"is_pay":0,"favorites":107,"aid":73404657,"is_steins_gate":0,"hide_click":false},{"comment":5,"typeid":39,"play":3283,"pic":"//i0.hdslb.com/bfs/archive/3e1681dd47c3ec750108cb7564867c296acb632b.jpg","subtitle":"","description":"编程技术交流群：167399488（勿吹水闲聊）\n视频教程源于网络仅供学习，若有侵权，私信删除。\n【请勿相信视频中出现的网址和企鹅号及二维码等联系信息，以防上当受骗】\nup的编程技术交流小组在主页，资料也在小组中，大家一起交流哦。","copyright":"","title":"嵌入式之精通STM32开发","review":0,"author":"真全栈程序员","mid":362268332,"is_union_video":0,"created":1572010624,"length":"882:07","video_review":2,"is_pay":0,"favorites":520,"aid":73387038,"is_steins_gate":0,"hide_click":false},{"comment":1,"typeid":39,"play":838,"pic":"//i1.hdslb.com/bfs/archive/bc924986e0a39d3e3fd437eafc9a6d6e75042e8e.jpg","subtitle":"","description":"编程技术交流群：167399488（勿吹水闲聊）\n视频教程源于网络仅供学习，若有侵权，私信删除。\n【请勿相信视频中出现的网址和企鹅号及二维码等联系信息，以防上当受骗】\nup的编程技术交流小组在主页，资料也在小组中，大家一起交流哦。","copyright":"","title":"嵌入式之物联网仓储项目实战","review":0,"author":"真全栈程序员","mid":362268332,"is_union_video":0,"created":1572008439,"length":"629:23","video_review":0,"is_pay":0,"favorites":132,"aid":73383097,"is_steins_gate":0,"hide_click":false},{"comment":2,"typeid":39,"play":689,"pic":"//i1.hdslb.com/bfs/archive/a390f3b73c3ebf35b259421db9957e8de86ca3a6.jpg","subtitle":"","description":"编程技术交流群：167399488（勿吹水闲聊）\n视频教程源于网络仅供学习，若有侵权，私信删除。\n【请勿相信视频中出现的网址和企鹅号及二维码等联系信息，以防上当受骗】\nup的编程技术交流小组在主页，资料也在小组中，大家一起交流哦。","copyright":"","title":"嵌入式之内核及驱动开发（高级课程）","review":0,"author":"真全栈程序员","mid":362268332,"is_union_video":0,"created":1571987126,"length":"841:07","video_review":0,"is_pay":0,"favorites":175,"aid":73307331,"is_steins_gate":0,"hide_click":false},{"comment":3,"typeid":39,"play":1149,"pic":"//i0.hdslb.com/bfs/archive/b43871ce302672e90febdbe2dd3e086e9c738ea9.jpg","subtitle":"","description":"编程技术交流群：167399488（勿吹水闲聊）\n视频教程源于网络仅供学习，若有侵权，私信删除。\n【请勿相信视频中出现的网址和企鹅号及二维码等联系信息，以防上当受骗】\nup的编程技术交流小组在主页，资料也在小组中，大家一起交流哦。","copyright":"","title":"嵌入式之内核及驱动开发（初级课程）","review":0,"author":"真全栈程序员","mid":362268332,"is_union_video":0,"created":1571986824,"length":"989:49","video_review":0,"is_pay":0,"favorites":236,"aid":73306160,"is_steins_gate":0,"hide_click":false},{"comment":4,"typeid":39,"play":597,"pic":"//i0.hdslb.com/bfs/archive/7515d14761e3d9d202aec1c7fcd8486ffd5164b6.jpg","subtitle":"","description":"编程技术交流群：167399488（勿吹水闲聊）\n视频教程源于网络仅供学习，若有侵权，私信删除。\n【请勿相信视频中出现的网址和企鹅号及二维码等联系信息，以防上当受骗】\nup的编程技术交流小组在主页，资料也在小组中，大家一起交流哦。","copyright":"","title":"嵌入式之系统移植","review":0,"author":"真全栈程序员","mid":362268332,"is_union_video":0,"created":1571968817,"length":"586:34","video_review":0,"is_pay":0,"favorites":123,"aid":73304169,"is_steins_gate":0,"hide_click":false},{"comment":3,"typeid":39,"play":913,"pic":"//i0.hdslb.com/bfs/archive/cf5f5cc6913a3f9040435933abb1d4bf2753191a.jpg","subtitle":"","description":"编程技术交流群：167399488（勿吹水闲聊）\n视频教程源于网络仅供学习，若有侵权，私信删除。\n【请勿相信视频中出现的网址和企鹅号及二维码等联系信息，以防上当受骗】\nup的编程技术交流小组在主页，资料也在小组中，大家一起交流哦。","copyright":"","title":"嵌入式之精通ARM体系结构及接口技术","review":0,"author":"真全栈程序员","mid":362268332,"is_union_video":0,"created":1571925632,"length":"663:01","video_review":1,"is_pay":0,"favorites":176,"aid":73258517,"is_steins_gate":0,"hide_click":false},{"comment":1,"typeid":39,"play":339,"pic":"//i1.hdslb.com/bfs/archive/c80bb3f0aa4c0c4ea0911e345d997b9fcedd8688.jpg","subtitle":"","description":"编程技术交流群：167399488（勿吹水闲聊）\n视频教程源于网络仅供学习，若有侵权，私信删除。\n【请勿相信视频中出现的网址和企鹅号及二维码等联系信息，以防上当受骗】\nup的编程技术交流小组在主页，资料也在小组中，大家一起交流哦。","copyright":"","title":"嵌入式之应用层综合项目在线词典","review":0,"author":"真全栈程序员","mid":362268332,"is_union_video":0,"created":1571899705,"length":"242:06","video_review":0,"is_pay":0,"favorites":55,"aid":73239520,"is_steins_gate":0,"hide_click":false},{"comment":1,"typeid":39,"play":397,"pic":"//i0.hdslb.com/bfs/archive/da0b96b75e06a36620d8b4a90671b591ab12be56.jpg","subtitle":"","description":"编程技术交流群：167399488（勿吹水闲聊）\n视频教程源于网络仅供学习，若有侵权，私信删除。\n【请勿相信视频中出现的网址和企鹅号及二维码等联系信息，以防上当受骗】\nup的编程技术交流小组在主页，资料也在小组中，大家一起交流哦。","copyright":"","title":"嵌入式之数据库Sqlite3学习","review":0,"author":"真全栈程序员","mid":362268332,"is_union_video":0,"created":1571898546,"length":"71:21","video_review":0,"is_pay":0,"favorites":72,"aid":73238112,"is_steins_gate":0,"hide_click":false},{"comment":3,"typeid":39,"play":789,"pic":"//i0.hdslb.com/bfs/archive/a67cb6eb6b078608b9159cf37fedaa2330ada420.jpg","subtitle":"","description":"编程技术交流群：167399488（勿吹水闲聊）\n视频教程源于网络仅供学习，若有侵权，私信删除。\n【请勿相信视频中出现的网址和企鹅号及二维码等联系信息，以防上当受骗】\nup的编程技术交流小组在主页，资料也在小组中，大家一起交流哦。","copyright":"","title":"嵌入式之Linux网络编程","review":0,"author":"真全栈程序员","mid":362268332,"is_union_video":0,"created":1571879420,"length":"683:27","video_review":0,"is_pay":0,"favorites":175,"aid":73203918,"is_steins_gate":0,"hide_click":false},{"comment":3,"typeid":39,"play":390,"pic":"//i2.hdslb.com/bfs/archive/ead145f7a93c559f0fe726071107bbd7ac4886d4.jpg","subtitle":"","description":"编程技术交流群：167399488（勿吹水闲聊）\n视频教程源于网络仅供学习，若有侵权，私信删除。\n【请勿相信视频中出现的网址和企鹅号及二维码等联系信息，以防上当受骗】\nup的编程技术交流小组在主页，资料也在小组中，大家一起交流哦。","copyright":"","title":"嵌入式之Linux并发程序设计","review":0,"author":"真全栈程序员","mid":362268332,"is_union_video":0,"created":1571879119,"length":"442:17","video_review":0,"is_pay":0,"favorites":97,"aid":73202565,"is_steins_gate":0,"hide_click":false},{"comment":1,"typeid":39,"play":265,"pic":"//i0.hdslb.com/bfs/archive/c73f8dfa4196b21b9f5f3c09a6c68b0dc83ef22f.jpg","subtitle":"","description":"编程技术交流群：167399488（勿吹水闲聊）\n视频教程源于网络仅供学习，若有侵权，私信删除。\n【请勿相信视频中出现的网址和企鹅号及二维码等联系信息，以防上当受骗】\nup的编程技术交流小组在主页，资料也在小组中，大家一起交流哦。","copyright":"","title":"嵌入式之Linux下文件I/O精讲","review":0,"author":"真全栈程序员","mid":362268332,"is_union_video":0,"created":1571878811,"length":"255:01","video_review":0,"is_pay":0,"favorites":66,"aid":73200692,"is_steins_gate":0,"hide_click":false},{"comment":2,"typeid":39,"play":1124,"pic":"//i1.hdslb.com/bfs/archive/1a90cefd3a413c3f616e813fd952532ace8f300d.jpg","subtitle":"","description":"编程技术交流群：167399488（勿吹水闲聊）\n视频教程源于网络仅供学习，若有侵权，私信删除。\n【请勿相信视频中出现的网址和企鹅号及二维码等联系信息，以防上当受骗】\nup的编程技术交流小组在主页，资料也在小组中，大家一起交流哦。","copyright":"","title":"嵌入式之算法与数据结构","review":0,"author":"真全栈程序员","mid":362268332,"is_union_video":0,"created":1571819988,"length":"1067:03","video_review":3,"is_pay":0,"favorites":254,"aid":73145988,"is_steins_gate":0,"hide_click":false},{"comment":1,"typeid":39,"play":957,"pic":"//i2.hdslb.com/bfs/archive/cc6e3c7688b004acadfe9402a8e418d0f6bd8728.jpg","subtitle":"","description":"编程技术交流群：167399488（勿吹水闲聊）\n视频教程源于网络仅供学习，若有侵权，私信删除。\n【请勿相信视频中出现的网址和企鹅号及二维码等联系信息，以防上当受骗】\nup的编程技术交流小组在主页，资料也在小组中，大家一起交流哦。","copyright":"","title":"嵌入式之Linux C语言高级","review":0,"author":"真全栈程序员","mid":362268332,"is_union_video":0,"created":1571816853,"length":"610:15","video_review":0,"is_pay":0,"favorites":162,"aid":73140871,"is_steins_gate":0,"hide_click":false},{"comment":1,"typeid":39,"play":1030,"pic":"//i0.hdslb.com/bfs/archive/a68e4d08f1042281f9c584c894477dd30438cf9a.jpg","subtitle":"","description":"编程技术交流群：167399488（勿吹水闲聊）\n视频教程源于网络仅供学习，若有侵权，私信删除。\n【请勿相信视频中出现的网址和企鹅号及二维码等联系信息，以防上当受骗】\nup的编程技术交流小组在主页，资料也在小组中，大家一起交流哦。","copyright":"","title":"嵌入式之Linux C语言基础","review":0,"author":"真全栈程序员","mid":362268332,"is_union_video":0,"created":1571815210,"length":"1547:16","video_review":9,"is_pay":0,"favorites":156,"aid":73137095,"is_steins_gate":0,"hide_click":false},{"comment":2,"typeid":39,"play":1560,"pic":"//i0.hdslb.com/bfs/archive/8ac2a3aa058b01969ac8010e08174f58f5647887.jpg","subtitle":"","description":"编程技术交流群：167399488（勿吹水闲聊）\n视频教程源于网络仅供学习，若有侵权，私信删除。\n【请勿相信视频中出现的网址和企鹅号及二维码等联系信息，以防上当受骗】\nup的编程技术交流小组在主页，资料也在小组中，大家一起交流哦。","copyright":"","title":"Java架构师高级课程","review":0,"author":"真全栈程序员","mid":362268332,"is_union_video":0,"created":1571569935,"length":"6740:54","video_review":1,"is_pay":0,"favorites":269,"aid":71889808,"is_steins_gate":0,"hide_click":false},{"comment":2,"typeid":39,"play":1914,"pic":"//i2.hdslb.com/bfs/archive/2db8e82a5f22cefbe3f9e3a50f6ad2ad17821c48.jpg","subtitle":"","description":"编程技术交流群：167399488（勿吹水闲聊）\n视频教程源于网络仅供学习，若有侵权，私信删除。\n【请勿相信视频中出现的网址和企鹅号及二维码等联系信息，以防上当受骗】\nup的编程技术交流小组在主页，资料也在小组中，大家一起交流哦。","copyright":"","title":"算法进阶课程","review":0,"author":"真全栈程序员","mid":362268332,"is_union_video":0,"created":1571447154,"length":"1638:44","video_review":1,"is_pay":0,"favorites":386,"aid":71679959,"is_steins_gate":0,"hide_click":false},{"comment":4,"typeid":39,"play":2204,"pic":"//i1.hdslb.com/bfs/archive/35762fb26132bfab4d48cd05c6a2d7c557c5fa56.jpg","subtitle":"","description":"编程技术交流群：167399488（勿吹水闲聊）\n视频教程源于网络仅供学习，若有侵权，私信删除。\n【请勿相信视频中出现的网址和企鹅号及二维码等联系信息，以防上当受骗】\nup的编程技术交流小组在主页，资料也在小组中，大家一起交流哦。","copyright":"","title":"算法初级课程","review":0,"author":"真全栈程序员","mid":362268332,"is_union_video":0,"created":1571446843,"length":"1335:40","video_review":16,"is_pay":0,"favorites":367,"aid":71674726,"is_steins_gate":0,"hide_click":false},{"comment":3,"typeid":39,"play":1405,"pic":"//i0.hdslb.com/bfs/archive/ebb0012afcba42c911f1400ad46e591188f18f40.jpg","subtitle":"","description":"编程技术交流群：167399488（勿吹水闲聊）\n视频教程源于网络仅供学习，若有侵权，私信删除。\n【请勿相信视频中出现的网址和企鹅号及二维码等联系信息，以防上当受骗】\nup的编程技术交流小组在主页，资料也在小组中，大家一起交流哦。","copyright":"","title":"中华石杉老师-21天互联网Java进阶面试训练营（分布式篇）","review":0,"author":"真全栈程序员","mid":362268332,"is_union_video":0,"created":1571321159,"length":"682:17","video_review":3,"is_pay":0,"favorites":272,"aid":71506934,"is_steins_gate":0,"hide_click":false},{"comment":4,"typeid":39,"play":1570,"pic":"//i1.hdslb.com/bfs/archive/78a0f48e8d5e109b08b7c277aa8d201db12a5508.jpg","subtitle":"","description":"编程技术交流群：167399488（勿吹水闲聊）\n视频教程源于网络仅供学习，若有侵权，私信删除。\n【请勿相信视频中出现的网址和企鹅号及二维码等联系信息，以防上当受骗】\nup的编程技术交流小组在主页，资料也在小组中，大家一起交流哦。","copyright":"","title":"中华石杉老师-互联网Java工程师面试突击训练第1季（可能是史上最好的Java面试突击课程）","review":0,"author":"真全栈程序员","mid":362268332,"is_union_video":0,"created":1571320856,"length":"1994:40","video_review":1,"is_pay":0,"favorites":245,"aid":71505947,"is_steins_gate":0,"hide_click":false},{"comment":2,"typeid":39,"play":1094,"pic":"//i0.hdslb.com/bfs/archive/02df56e5b86124d03f47cb47873775982fa6bc57.jpg","subtitle":"","description":"编程技术交流群：167399488（勿吹水闲聊）\n视频教程源于网络仅供学习，若有侵权，私信删除。\n【请勿相信视频中出现的网址和企鹅号及二维码等联系信息，以防上当受骗】\nup的编程技术交流小组在主页，资料也在小组中，大家一起交流哦。","copyright":"","title":"亿级流量电商详情页系统实战（第二版）：缓存架构+高可用服务架构+微服务架构（中华石杉）","review":0,"author":"真全栈程序员","mid":362268332,"is_union_video":0,"created":1571306432,"length":"3790:58","video_review":2,"is_pay":0,"favorites":254,"aid":71494884,"is_steins_gate":0,"hide_click":false}],"count":305,"pages":7}
     */

    @JsonProperty("status")
    private boolean status;
    @JsonProperty("data")
    private DataBean data;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class DataBean {
        /**
         * tlist : {"36":{"tid":36,"count":305,"name":"科技"}}
         * vlist : [{"comment":1,"typeid":39,"play":576,"pic":"//i0.hdslb.com/bfs/archive/c4415d5c5014d635e0e096f29f3c9e32ade3d7d9.jpg","subtitle":"","description":"编程技术交流群：167399488（勿吹水闲聊）\n视频教程源于网络仅供学习，若有侵权，私信删除。\n【请勿相信视频中出现的网址和企鹅号及二维码等联系信息，以防上当受骗】\nup的编程技术交流小组在主页，资料也在小组中，大家一起交流哦。","copyright":"","title":"【薪资突破20K】JavaEE在职加薪课之大数据转型必备课程-Hadoop3","review":0,"author":"真全栈程序员","mid":362268332,"is_union_video":0,"created":1572616842,"length":"1296:22","video_review":0,"is_pay":0,"favorites":75,"aid":74044043,"is_steins_gate":0,"hide_click":false},{"comment":2,"typeid":39,"play":360,"pic":"//i1.hdslb.com/bfs/archive/b2fd1403f6b701298a85c5e34ee1b4dc146665cf.jpg","subtitle":"","description":"编程技术交流群：167399488（勿吹水闲聊）\n视频教程源于网络仅供学习，若有侵权，私信删除。\n【请勿相信视频中出现的网址和企鹅号及二维码等联系信息，以防上当受骗】\nup的编程技术交流小组在主页，资料也在小组中，大家一起交流哦。","copyright":"","title":"【薪资突破20K】JavaEE在职加薪课之互联网全终端微服务项目-好客租房","review":0,"author":"真全栈程序员","mid":362268332,"is_union_video":0,"created":1572591646,"length":"3614:44","video_review":0,"is_pay":0,"favorites":86,"aid":74030429,"is_steins_gate":0,"hide_click":false},{"comment":1,"typeid":39,"play":253,"pic":"//i0.hdslb.com/bfs/archive/672f72d400a6dda7f18266b558bdb547bca569af.jpg","subtitle":"","description":"编程技术交流群：167399488（勿吹水闲聊）\n视频教程源于网络仅供学习，若有侵权，私信删除。\n【请勿相信视频中出现的网址和企鹅号及二维码等联系信息，以防上当受骗】\nup的编程技术交流小组在主页，资料也在小组中，大家一起交流哦。","copyright":"","title":"【薪资突破20K】JavaEE在职加薪课之传统行业解决方案SaaS-HRM项目","review":0,"author":"真全栈程序员","mid":362268332,"is_union_video":0,"created":1572573623,"length":"3141:10","video_review":0,"is_pay":0,"favorites":52,"aid":74019610,"is_steins_gate":0,"hide_click":false},{"comment":3,"typeid":39,"play":299,"pic":"//i1.hdslb.com/bfs/archive/0f21c61a639bc01de39f981cd51cc1d27e48c17a.jpg","subtitle":"","description":"编程技术交流群：167399488（勿吹水闲聊）\n视频教程源于网络仅供学习，若有侵权，私信删除。\n【请勿相信视频中出现的网址和企鹅号及二维码等联系信息，以防上当受骗】\nup的编程技术交流小组在主页，资料也在小组中，大家一起交流哦。","copyright":"","title":"【薪资突破20K】JavaEE在职加薪课之Netty网络编程","review":0,"author":"真全栈程序员","mid":362268332,"is_union_video":0,"created":1572530725,"length":"322:10","video_review":0,"is_pay":0,"favorites":49,"aid":74016796,"is_steins_gate":0,"hide_click":false},{"comment":1,"typeid":39,"play":172,"pic":"//i2.hdslb.com/bfs/archive/ab2071fa40e39bb7a14ba9dccc3c8ca4482538c6.jpg","subtitle":"","description":"编程技术交流群：167399488（勿吹水闲聊）\n视频教程源于网络仅供学习，若有侵权，私信删除。\n【请勿相信视频中出现的网址和企鹅号及二维码等联系信息，以防上当受骗】\nup的编程技术交流小组在主页，资料也在小组中，大家一起交流哦。","copyright":"","title":"【薪资突破20K】JavaEE在职加薪课之ORM思想及相关框架实现原理","review":0,"author":"真全栈程序员","mid":362268332,"is_union_video":0,"created":1572530421,"length":"473:09","video_review":0,"is_pay":0,"favorites":26,"aid":74015037,"is_steins_gate":0,"hide_click":false},{"comment":1,"typeid":39,"play":219,"pic":"//i1.hdslb.com/bfs/archive/190cf326eb3b52b323f77ecde53f035847a61ce2.jpg","subtitle":"","description":"编程技术交流群：167399488（勿吹水闲聊）\n视频教程源于网络仅供学习，若有侵权，私信删除。\n【请勿相信视频中出现的网址和企鹅号及二维码等联系信息，以防上当受骗】\nup的编程技术交流小组在主页，资料也在小组中，大家一起交流哦。","copyright":"","title":"【薪资突破20K】JavaEE在职加薪课之NIO与Netty编程","review":0,"author":"真全栈程序员","mid":362268332,"is_union_video":0,"created":1572527414,"length":"559:13","video_review":0,"is_pay":0,"favorites":38,"aid":74017593,"is_steins_gate":0,"hide_click":false},{"comment":1,"typeid":39,"play":200,"pic":"//i2.hdslb.com/bfs/archive/f8ade4729b53c08e3c179aa0460bf1eb3479018d.jpg","subtitle":"","description":"编程技术交流群：167399488（勿吹水闲聊）\n视频教程源于网络仅供学习，若有侵权，私信删除。\n【请勿相信视频中出现的网址和企鹅号及二维码等联系信息，以防上当受骗】\nup的编程技术交流小组在主页，资料也在小组中，大家一起交流哦。","copyright":"","title":"【薪资突破20K】JavaEE在职加薪课之MVC模式详解","review":0,"author":"真全栈程序员","mid":362268332,"is_union_video":0,"created":1572517819,"length":"343:53","video_review":0,"is_pay":0,"favorites":27,"aid":74013574,"is_steins_gate":0,"hide_click":false},{"comment":1,"typeid":39,"play":249,"pic":"//i0.hdslb.com/bfs/archive/9d8bc932a5e8f202664dd2b483b7975c2e0a0979.jpg","subtitle":"","description":"编程技术交流群：167399488（勿吹水闲聊）\n视频教程源于网络仅供学习，若有侵权，私信删除。\n【请勿相信视频中出现的网址和企鹅号及二维码等联系信息，以防上当受骗】\nup的编程技术交流小组在主页，资料也在小组中，大家一起交流哦。","copyright":"","title":"【薪资突破20K】JavaEE在职加薪课之MySQL数据库优化","review":0,"author":"真全栈程序员","mid":362268332,"is_union_video":0,"created":1572514854,"length":"609:08","video_review":0,"is_pay":0,"favorites":65,"aid":74011321,"is_steins_gate":0,"hide_click":false},{"comment":1,"typeid":39,"play":234,"pic":"//i0.hdslb.com/bfs/archive/20818e3e7f1b0f3470da83fe10afcae45dab945d.jpg","subtitle":"","description":"编程技术交流群：167399488（勿吹水闲聊）\n视频教程源于网络仅供学习，若有侵权，私信删除。\n【请勿相信视频中出现的网址和企鹅号及二维码等联系信息，以防上当受骗】\nup的编程技术交流小组在主页，资料也在小组中，大家一起交流哦。","copyright":"","title":"【薪资突破20K】JavaEE在职加薪课之JVM优化","review":0,"author":"真全栈程序员","mid":362268332,"is_union_video":0,"created":1572512744,"length":"461:37","video_review":1,"is_pay":0,"favorites":52,"aid":74007143,"is_steins_gate":0,"hide_click":false},{"comment":1,"typeid":39,"play":200,"pic":"//i1.hdslb.com/bfs/archive/4cb39bfd513a265a451e11e6335641b429d929cf.jpg","subtitle":"","description":"编程技术交流群：167399488（勿吹水闲聊）\n视频教程源于网络仅供学习，若有侵权，私信删除。\n【请勿相信视频中出现的网址和企鹅号及二维码等联系信息，以防上当受骗】\nup的编程技术交流小组在主页，资料也在小组中，大家一起交流哦。","copyright":"","title":"【薪资突破20K】JavaEE在职加薪课之华为云PaaS微服务治理课程（CSE Mesher开发）","review":0,"author":"真全栈程序员","mid":362268332,"is_union_video":0,"created":1572487816,"length":"912:09","video_review":0,"is_pay":0,"favorites":25,"aid":73988821,"is_steins_gate":0,"hide_click":false},{"comment":1,"typeid":39,"play":59,"pic":"//i2.hdslb.com/bfs/archive/d746866d23044d38e230a90024ef27bbbb491478.jpg","subtitle":"","description":"编程技术交流群：167399488（勿吹水闲聊）\n视频教程源于网络仅供学习，若有侵权，私信删除。\n【请勿相信视频中出现的网址和企鹅号及二维码等联系信息，以防上当受骗】\nup的编程技术交流小组在主页，资料也在小组中，大家一起交流哦。","copyright":"","title":"【薪资突破20K】JavaEE在职加薪课之容器化进阶K8S","review":0,"author":"真全栈程序员","mid":362268332,"is_union_video":0,"created":1572487514,"length":"153:41","video_review":0,"is_pay":0,"favorites":18,"aid":73987567,"is_steins_gate":0,"hide_click":false},{"comment":1,"typeid":39,"play":105,"pic":"//i1.hdslb.com/bfs/archive/361014ebb0ab5e6f8d517dfd04aabb8bdb2ed553.jpg","subtitle":"","description":"编程技术交流群：167399488（勿吹水闲聊）\n视频教程源于网络仅供学习，若有侵权，私信删除。\n【请勿相信视频中出现的网址和企鹅号及二维码等联系信息，以防上当受骗】\nup的编程技术交流小组在主页，资料也在小组中，大家一起交流哦。","copyright":"","title":"【薪资突破20K】JavaEE在职加薪课之Apache ServiceComb课程","review":0,"author":"真全栈程序员","mid":362268332,"is_union_video":0,"created":1572487207,"length":"371:00","video_review":0,"is_pay":0,"favorites":18,"aid":73984460,"is_steins_gate":0,"hide_click":false},{"comment":3,"typeid":39,"play":400,"pic":"//i1.hdslb.com/bfs/archive/544d0f9051f315fc9a99c1b5bfe8feb4fbb34312.jpg","subtitle":"","description":"编程技术交流群：167399488（勿吹水闲聊）\n视频教程源于网络仅供学习，若有侵权，私信删除。\n【请勿相信视频中出现的网址和企鹅号及二维码等联系信息，以防上当受骗】\nup的编程技术交流小组在主页，资料也在小组中，大家一起交流哦。","copyright":"","title":"【薪资突破20K】JavaEE在职加薪课之微服务实战项目学成在线","review":0,"author":"真全栈程序员","mid":362268332,"is_union_video":0,"created":1572450033,"length":"3575:46","video_review":0,"is_pay":0,"favorites":92,"aid":73943722,"is_steins_gate":0,"hide_click":false},{"comment":1,"typeid":39,"play":192,"pic":"//i1.hdslb.com/bfs/archive/18dcb07d92a23422c51153e044d97d16190885e5.jpg","subtitle":"","description":"编程技术交流群：167399488（勿吹水闲聊）\n视频教程源于网络仅供学习，若有侵权，私信删除。\n【请勿相信视频中出现的网址和企鹅号及二维码等联系信息，以防上当受骗】\nup的编程技术交流小组在主页，资料也在小组中，大家一起交流哦。","copyright":"","title":"【薪资突破20K】JavaEE在职加薪课之Git版本控制","review":0,"author":"真全栈程序员","mid":362268332,"is_union_video":0,"created":1572449432,"length":"160:03","video_review":0,"is_pay":0,"favorites":32,"aid":73934404,"is_steins_gate":0,"hide_click":false},{"comment":1,"typeid":39,"play":351,"pic":"//i1.hdslb.com/bfs/archive/06af42e8fd4c75faf87a48e51be59abda8c41ce0.jpg","subtitle":"","description":"编程技术交流群：167399488（勿吹水闲聊）\n视频教程源于网络仅供学习，若有侵权，私信删除。\n【请勿相信视频中出现的网址和企鹅号及二维码等联系信息，以防上当受骗】\nup的编程技术交流小组在主页，资料也在小组中，大家一起交流哦。","copyright":"","title":"【薪资突破20K】JavaEE在职加薪课之Docker容器化","review":0,"author":"真全栈程序员","mid":362268332,"is_union_video":0,"created":1572427440,"length":"142:02","video_review":0,"is_pay":0,"favorites":55,"aid":73933339,"is_steins_gate":0,"hide_click":false},{"comment":1,"typeid":39,"play":109,"pic":"//i1.hdslb.com/bfs/archive/f25025150848e257b433cbfd2ce02ce9316eea18.jpg","subtitle":"","description":"编程技术交流群：167399488（勿吹水闲聊）\n视频教程源于网络仅供学习，若有侵权，私信删除。\n【请勿相信视频中出现的网址和企鹅号及二维码等联系信息，以防上当受骗】\nup的编程技术交流小组在主页，资料也在小组中，大家一起交流哦。","copyright":"","title":"【薪资突破20K】JavaEE在职加薪课之持续集成与容器管理","review":0,"author":"真全栈程序员","mid":362268332,"is_union_video":0,"created":1572426921,"length":"124:56","video_review":0,"is_pay":0,"favorites":32,"aid":73933923,"is_steins_gate":0,"hide_click":false},{"comment":1,"typeid":39,"play":146,"pic":"//i1.hdslb.com/bfs/archive/78de44299db20280ead9b8e427b11d8878013e7a.jpg","subtitle":"","description":"编程技术交流群：167399488（勿吹水闲聊）\n视频教程源于网络仅供学习，若有侵权，私信删除。\n【请勿相信视频中出现的网址和企鹅号及二维码等联系信息，以防上当受骗】\nup的编程技术交流小组在主页，资料也在小组中，大家一起交流哦。","copyright":"","title":"【薪资突破20K】JavaEE在职加薪课之SpringBoot微服务快速开发","review":0,"author":"真全栈程序员","mid":362268332,"is_union_video":0,"created":1572426443,"length":"175:13","video_review":0,"is_pay":0,"favorites":20,"aid":73932253,"is_steins_gate":0,"hide_click":false},{"comment":1,"typeid":39,"play":260,"pic":"//i0.hdslb.com/bfs/archive/fafd74f0f1a774cdf8af05401f039c195e908600.jpg","subtitle":"","description":"编程技术交流群：167399488（勿吹水闲聊）\n视频教程源于网络仅供学习，若有侵权，私信删除。\n【请勿相信视频中出现的网址和企鹅号及二维码等联系信息，以防上当受骗】\nup的编程技术交流小组在主页，资料也在小组中，大家一起交流哦。","copyright":"","title":"【薪资突破20K】JavaEE在职加薪课之Maven项目管理工具","review":0,"author":"真全栈程序员","mid":362268332,"is_union_video":0,"created":1572425430,"length":"326:17","video_review":0,"is_pay":0,"favorites":41,"aid":73930019,"is_steins_gate":0,"hide_click":false},{"comment":1,"typeid":39,"play":174,"pic":"//i2.hdslb.com/bfs/archive/4e2dde49d45eba99939b5fb6d9d7b37ba435266e.jpg","subtitle":"","description":"编程技术交流群：167399488（勿吹水闲聊）\n视频教程源于网络仅供学习，若有侵权，私信删除。\n【请勿相信视频中出现的网址和企鹅号及二维码等联系信息，以防上当受骗】\nup的编程技术交流小组在主页，资料也在小组中，大家一起交流哦。","copyright":"","title":"UI培训就业课程之flash+axure（6天）","review":0,"author":"真全栈程序员","mid":362268332,"is_union_video":0,"created":1572333430,"length":"911:57","video_review":0,"is_pay":0,"favorites":23,"aid":73822404,"is_steins_gate":0,"hide_click":false},{"comment":1,"typeid":39,"play":275,"pic":"//i1.hdslb.com/bfs/archive/52d899109351d0f8394e3e92563c335d4297b910.jpg","subtitle":"","description":"编程技术交流群：167399488（勿吹水闲聊）\n视频教程源于网络仅供学习，若有侵权，私信删除。\n【请勿相信视频中出现的网址和企鹅号及二维码等联系信息，以防上当受骗】\nup的编程技术交流小组在主页，资料也在小组中，大家一起交流哦。","copyright":"","title":"UI培训就业课程之JavaScript+jQuery+响应式（17天）","review":0,"author":"真全栈程序员","mid":362268332,"is_union_video":0,"created":1572323978,"length":"3037:00","video_review":0,"is_pay":0,"favorites":77,"aid":73808680,"is_steins_gate":0,"hide_click":false},{"comment":1,"typeid":39,"play":196,"pic":"//i0.hdslb.com/bfs/archive/ac22e038124d9d9b47b2658cb24e15c550b7328f.jpg","subtitle":"","description":"编程技术交流群：167399488（勿吹水闲聊）\n视频教程源于网络仅供学习，若有侵权，私信删除。\n【请勿相信视频中出现的网址和企鹅号及二维码等联系信息，以防上当受骗】\nup的编程技术交流小组在主页，资料也在小组中，大家一起交流哦。","copyright":"","title":"UI培训就业课程之HTML+CSS+项目实战（15天）","review":0,"author":"真全栈程序员","mid":362268332,"is_union_video":0,"created":1572314718,"length":"2276:08","video_review":0,"is_pay":0,"favorites":50,"aid":73785611,"is_steins_gate":0,"hide_click":false},{"comment":1,"typeid":39,"play":171,"pic":"//i2.hdslb.com/bfs/archive/716b4abcc91c7bddf4ddadb174fc500a8c1d60d3.jpg","subtitle":"","description":"编程技术交流群：167399488（勿吹水闲聊）\n视频教程源于网络仅供学习，若有侵权，私信删除。\n【请勿相信视频中出现的网址和企鹅号及二维码等联系信息，以防上当受骗】\nup的编程技术交流小组在主页，资料也在小组中，大家一起交流哦。","copyright":"","title":"UI培训就业课程之UI设计（10天）","review":0,"author":"真全栈程序员","mid":362268332,"is_union_video":0,"created":1572314410,"length":"1734:51","video_review":0,"is_pay":0,"favorites":49,"aid":73784104,"is_steins_gate":0,"hide_click":false},{"comment":1,"typeid":39,"play":145,"pic":"//i2.hdslb.com/bfs/archive/6bb77feab5e122458dc17195d891fde071ab4416.jpg","subtitle":"","description":"编程技术交流群：167399488（勿吹水闲聊）\n视频教程源于网络仅供学习，若有侵权，私信删除。\n【请勿相信视频中出现的网址和企鹅号及二维码等联系信息，以防上当受骗】\nup的编程技术交流小组在主页，资料也在小组中，大家一起交流哦。","copyright":"","title":"UI培训就业课程之电商设计+网页设计（11天）","review":0,"author":"真全栈程序员","mid":362268332,"is_union_video":0,"created":1572273979,"length":"2195:41","video_review":0,"is_pay":0,"favorites":46,"aid":73768485,"is_steins_gate":0,"hide_click":false},{"comment":2,"typeid":39,"play":267,"pic":"//i1.hdslb.com/bfs/archive/01889924be3a7195bbc814e599379a0346cd2cd3.jpg","subtitle":"","description":"编程技术交流群：167399488（勿吹水闲聊）\n视频教程源于网络仅供学习，若有侵权，私信删除。\n【请勿相信视频中出现的网址和企鹅号及二维码等联系信息，以防上当受骗】\nup的编程技术交流小组在主页，资料也在小组中，大家一起交流哦。","copyright":"","title":"UI培训就业课程之PS+Adobe illustrator+实战+实用美术课程（17天）","review":0,"author":"真全栈程序员","mid":362268332,"is_union_video":0,"created":1572193452,"length":"3600:49","video_review":0,"is_pay":0,"favorites":56,"aid":73667530,"is_steins_gate":0,"hide_click":false},{"comment":4,"typeid":39,"play":1693,"pic":"//i0.hdslb.com/bfs/archive/0a823d63d1d5836bdb5dbd12618ff0b9209539d1.jpg","subtitle":"","description":"编程技术交流群：167399488（勿吹水闲聊）\n视频教程源于网络仅供学习，若有侵权，私信删除。\n【请勿相信视频中出现的网址和企鹅号及二维码等联系信息，以防上当受骗】\nup的编程技术交流小组在主页，资料也在小组中，大家一起交流哦。","copyright":"","title":"嵌入式之WiFi智能家居项目实战","review":0,"author":"真全栈程序员","mid":362268332,"is_union_video":0,"created":1572098714,"length":"491:55","video_review":1,"is_pay":0,"favorites":250,"aid":73413553,"is_steins_gate":0,"hide_click":false},{"comment":3,"typeid":39,"play":635,"pic":"//i0.hdslb.com/bfs/archive/cb4ffa7e0cd858c849ca4e828765dc70917ee745.jpg","subtitle":"","description":"编程技术交流群：167399488（勿吹水闲聊）\n视频教程源于网络仅供学习，若有侵权，私信删除。\n【请勿相信视频中出现的网址和企鹅号及二维码等联系信息，以防上当受骗】\nup的编程技术交流小组在主页，资料也在小组中，大家一起交流哦。","copyright":"","title":"嵌入式之NB-IOT技术实践开发物联网智慧消防项目","review":0,"author":"真全栈程序员","mid":362268332,"is_union_video":0,"created":1572098411,"length":"502:38","video_review":5,"is_pay":0,"favorites":115,"aid":73412515,"is_steins_gate":0,"hide_click":false},{"comment":5,"typeid":39,"play":751,"pic":"//i0.hdslb.com/bfs/archive/4e46d3de78a010d32a566f49c2802ab9ab9b63f1.jpg","subtitle":"","description":"编程技术交流群：167399488（勿吹水闲聊）\n视频教程源于网络仅供学习，若有侵权，私信删除。\n【请勿相信视频中出现的网址和企鹅号及二维码等联系信息，以防上当受骗】\nup的编程技术交流小组在主页，资料也在小组中，大家一起交流哦。","copyright":"","title":"嵌入式之LoRa开发与应用","review":0,"author":"真全栈程序员","mid":362268332,"is_union_video":0,"created":1572077124,"length":"592:12","video_review":1,"is_pay":0,"favorites":114,"aid":73410784,"is_steins_gate":0,"hide_click":false},{"comment":2,"typeid":39,"play":522,"pic":"//i2.hdslb.com/bfs/archive/95054d93d8e2e03205802196e23e7fa4adbdedb8.jpg","subtitle":"","description":"编程技术交流群：167399488（勿吹水闲聊）\n视频教程源于网络仅供学习，若有侵权，私信删除。\n【请勿相信视频中出现的网址和企鹅号及二维码等联系信息，以防上当受骗】\nup的编程技术交流小组在主页，资料也在小组中，大家一起交流哦。","copyright":"","title":"嵌入式之RFID开发与应用","review":0,"author":"真全栈程序员","mid":362268332,"is_union_video":0,"created":1572076821,"length":"303:49","video_review":0,"is_pay":0,"favorites":87,"aid":73409046,"is_steins_gate":0,"hide_click":false},{"comment":1,"typeid":39,"play":553,"pic":"//i1.hdslb.com/bfs/archive/6d3d409327935d1e9400c4894f58b2ea70719c22.jpg","subtitle":"","description":"编程技术交流群：167399488（勿吹水闲聊）\n视频教程源于网络仅供学习，若有侵权，私信删除。\n【请勿相信视频中出现的网址和企鹅号及二维码等联系信息，以防上当受骗】\nup的编程技术交流小组在主页，资料也在小组中，大家一起交流哦。","copyright":"","title":"嵌入式之蓝牙4.0 BLE和智能手环实战","review":0,"author":"真全栈程序员","mid":362268332,"is_union_video":0,"created":1572055542,"length":"395:38","video_review":0,"is_pay":0,"favorites":103,"aid":73408053,"is_steins_gate":0,"hide_click":false},{"comment":1,"typeid":39,"play":496,"pic":"//i0.hdslb.com/bfs/archive/8107adf12df09163554bf654bef9ce9128aeaef8.jpg","subtitle":"","description":"编程技术交流群：167399488（勿吹水闲聊）\n视频教程源于网络仅供学习，若有侵权，私信删除。\n【请勿相信视频中出现的网址和企鹅号及二维码等联系信息，以防上当受骗】\nup的编程技术交流小组在主页，资料也在小组中，大家一起交流哦。","copyright":"","title":"嵌入式之ZigBee系统开发实战","review":0,"author":"真全栈程序员","mid":362268332,"is_union_video":0,"created":1572055226,"length":"468:42","video_review":1,"is_pay":0,"favorites":107,"aid":73404657,"is_steins_gate":0,"hide_click":false},{"comment":5,"typeid":39,"play":3283,"pic":"//i0.hdslb.com/bfs/archive/3e1681dd47c3ec750108cb7564867c296acb632b.jpg","subtitle":"","description":"编程技术交流群：167399488（勿吹水闲聊）\n视频教程源于网络仅供学习，若有侵权，私信删除。\n【请勿相信视频中出现的网址和企鹅号及二维码等联系信息，以防上当受骗】\nup的编程技术交流小组在主页，资料也在小组中，大家一起交流哦。","copyright":"","title":"嵌入式之精通STM32开发","review":0,"author":"真全栈程序员","mid":362268332,"is_union_video":0,"created":1572010624,"length":"882:07","video_review":2,"is_pay":0,"favorites":520,"aid":73387038,"is_steins_gate":0,"hide_click":false},{"comment":1,"typeid":39,"play":838,"pic":"//i1.hdslb.com/bfs/archive/bc924986e0a39d3e3fd437eafc9a6d6e75042e8e.jpg","subtitle":"","description":"编程技术交流群：167399488（勿吹水闲聊）\n视频教程源于网络仅供学习，若有侵权，私信删除。\n【请勿相信视频中出现的网址和企鹅号及二维码等联系信息，以防上当受骗】\nup的编程技术交流小组在主页，资料也在小组中，大家一起交流哦。","copyright":"","title":"嵌入式之物联网仓储项目实战","review":0,"author":"真全栈程序员","mid":362268332,"is_union_video":0,"created":1572008439,"length":"629:23","video_review":0,"is_pay":0,"favorites":132,"aid":73383097,"is_steins_gate":0,"hide_click":false},{"comment":2,"typeid":39,"play":689,"pic":"//i1.hdslb.com/bfs/archive/a390f3b73c3ebf35b259421db9957e8de86ca3a6.jpg","subtitle":"","description":"编程技术交流群：167399488（勿吹水闲聊）\n视频教程源于网络仅供学习，若有侵权，私信删除。\n【请勿相信视频中出现的网址和企鹅号及二维码等联系信息，以防上当受骗】\nup的编程技术交流小组在主页，资料也在小组中，大家一起交流哦。","copyright":"","title":"嵌入式之内核及驱动开发（高级课程）","review":0,"author":"真全栈程序员","mid":362268332,"is_union_video":0,"created":1571987126,"length":"841:07","video_review":0,"is_pay":0,"favorites":175,"aid":73307331,"is_steins_gate":0,"hide_click":false},{"comment":3,"typeid":39,"play":1149,"pic":"//i0.hdslb.com/bfs/archive/b43871ce302672e90febdbe2dd3e086e9c738ea9.jpg","subtitle":"","description":"编程技术交流群：167399488（勿吹水闲聊）\n视频教程源于网络仅供学习，若有侵权，私信删除。\n【请勿相信视频中出现的网址和企鹅号及二维码等联系信息，以防上当受骗】\nup的编程技术交流小组在主页，资料也在小组中，大家一起交流哦。","copyright":"","title":"嵌入式之内核及驱动开发（初级课程）","review":0,"author":"真全栈程序员","mid":362268332,"is_union_video":0,"created":1571986824,"length":"989:49","video_review":0,"is_pay":0,"favorites":236,"aid":73306160,"is_steins_gate":0,"hide_click":false},{"comment":4,"typeid":39,"play":597,"pic":"//i0.hdslb.com/bfs/archive/7515d14761e3d9d202aec1c7fcd8486ffd5164b6.jpg","subtitle":"","description":"编程技术交流群：167399488（勿吹水闲聊）\n视频教程源于网络仅供学习，若有侵权，私信删除。\n【请勿相信视频中出现的网址和企鹅号及二维码等联系信息，以防上当受骗】\nup的编程技术交流小组在主页，资料也在小组中，大家一起交流哦。","copyright":"","title":"嵌入式之系统移植","review":0,"author":"真全栈程序员","mid":362268332,"is_union_video":0,"created":1571968817,"length":"586:34","video_review":0,"is_pay":0,"favorites":123,"aid":73304169,"is_steins_gate":0,"hide_click":false},{"comment":3,"typeid":39,"play":913,"pic":"//i0.hdslb.com/bfs/archive/cf5f5cc6913a3f9040435933abb1d4bf2753191a.jpg","subtitle":"","description":"编程技术交流群：167399488（勿吹水闲聊）\n视频教程源于网络仅供学习，若有侵权，私信删除。\n【请勿相信视频中出现的网址和企鹅号及二维码等联系信息，以防上当受骗】\nup的编程技术交流小组在主页，资料也在小组中，大家一起交流哦。","copyright":"","title":"嵌入式之精通ARM体系结构及接口技术","review":0,"author":"真全栈程序员","mid":362268332,"is_union_video":0,"created":1571925632,"length":"663:01","video_review":1,"is_pay":0,"favorites":176,"aid":73258517,"is_steins_gate":0,"hide_click":false},{"comment":1,"typeid":39,"play":339,"pic":"//i1.hdslb.com/bfs/archive/c80bb3f0aa4c0c4ea0911e345d997b9fcedd8688.jpg","subtitle":"","description":"编程技术交流群：167399488（勿吹水闲聊）\n视频教程源于网络仅供学习，若有侵权，私信删除。\n【请勿相信视频中出现的网址和企鹅号及二维码等联系信息，以防上当受骗】\nup的编程技术交流小组在主页，资料也在小组中，大家一起交流哦。","copyright":"","title":"嵌入式之应用层综合项目在线词典","review":0,"author":"真全栈程序员","mid":362268332,"is_union_video":0,"created":1571899705,"length":"242:06","video_review":0,"is_pay":0,"favorites":55,"aid":73239520,"is_steins_gate":0,"hide_click":false},{"comment":1,"typeid":39,"play":397,"pic":"//i0.hdslb.com/bfs/archive/da0b96b75e06a36620d8b4a90671b591ab12be56.jpg","subtitle":"","description":"编程技术交流群：167399488（勿吹水闲聊）\n视频教程源于网络仅供学习，若有侵权，私信删除。\n【请勿相信视频中出现的网址和企鹅号及二维码等联系信息，以防上当受骗】\nup的编程技术交流小组在主页，资料也在小组中，大家一起交流哦。","copyright":"","title":"嵌入式之数据库Sqlite3学习","review":0,"author":"真全栈程序员","mid":362268332,"is_union_video":0,"created":1571898546,"length":"71:21","video_review":0,"is_pay":0,"favorites":72,"aid":73238112,"is_steins_gate":0,"hide_click":false},{"comment":3,"typeid":39,"play":789,"pic":"//i0.hdslb.com/bfs/archive/a67cb6eb6b078608b9159cf37fedaa2330ada420.jpg","subtitle":"","description":"编程技术交流群：167399488（勿吹水闲聊）\n视频教程源于网络仅供学习，若有侵权，私信删除。\n【请勿相信视频中出现的网址和企鹅号及二维码等联系信息，以防上当受骗】\nup的编程技术交流小组在主页，资料也在小组中，大家一起交流哦。","copyright":"","title":"嵌入式之Linux网络编程","review":0,"author":"真全栈程序员","mid":362268332,"is_union_video":0,"created":1571879420,"length":"683:27","video_review":0,"is_pay":0,"favorites":175,"aid":73203918,"is_steins_gate":0,"hide_click":false},{"comment":3,"typeid":39,"play":390,"pic":"//i2.hdslb.com/bfs/archive/ead145f7a93c559f0fe726071107bbd7ac4886d4.jpg","subtitle":"","description":"编程技术交流群：167399488（勿吹水闲聊）\n视频教程源于网络仅供学习，若有侵权，私信删除。\n【请勿相信视频中出现的网址和企鹅号及二维码等联系信息，以防上当受骗】\nup的编程技术交流小组在主页，资料也在小组中，大家一起交流哦。","copyright":"","title":"嵌入式之Linux并发程序设计","review":0,"author":"真全栈程序员","mid":362268332,"is_union_video":0,"created":1571879119,"length":"442:17","video_review":0,"is_pay":0,"favorites":97,"aid":73202565,"is_steins_gate":0,"hide_click":false},{"comment":1,"typeid":39,"play":265,"pic":"//i0.hdslb.com/bfs/archive/c73f8dfa4196b21b9f5f3c09a6c68b0dc83ef22f.jpg","subtitle":"","description":"编程技术交流群：167399488（勿吹水闲聊）\n视频教程源于网络仅供学习，若有侵权，私信删除。\n【请勿相信视频中出现的网址和企鹅号及二维码等联系信息，以防上当受骗】\nup的编程技术交流小组在主页，资料也在小组中，大家一起交流哦。","copyright":"","title":"嵌入式之Linux下文件I/O精讲","review":0,"author":"真全栈程序员","mid":362268332,"is_union_video":0,"created":1571878811,"length":"255:01","video_review":0,"is_pay":0,"favorites":66,"aid":73200692,"is_steins_gate":0,"hide_click":false},{"comment":2,"typeid":39,"play":1124,"pic":"//i1.hdslb.com/bfs/archive/1a90cefd3a413c3f616e813fd952532ace8f300d.jpg","subtitle":"","description":"编程技术交流群：167399488（勿吹水闲聊）\n视频教程源于网络仅供学习，若有侵权，私信删除。\n【请勿相信视频中出现的网址和企鹅号及二维码等联系信息，以防上当受骗】\nup的编程技术交流小组在主页，资料也在小组中，大家一起交流哦。","copyright":"","title":"嵌入式之算法与数据结构","review":0,"author":"真全栈程序员","mid":362268332,"is_union_video":0,"created":1571819988,"length":"1067:03","video_review":3,"is_pay":0,"favorites":254,"aid":73145988,"is_steins_gate":0,"hide_click":false},{"comment":1,"typeid":39,"play":957,"pic":"//i2.hdslb.com/bfs/archive/cc6e3c7688b004acadfe9402a8e418d0f6bd8728.jpg","subtitle":"","description":"编程技术交流群：167399488（勿吹水闲聊）\n视频教程源于网络仅供学习，若有侵权，私信删除。\n【请勿相信视频中出现的网址和企鹅号及二维码等联系信息，以防上当受骗】\nup的编程技术交流小组在主页，资料也在小组中，大家一起交流哦。","copyright":"","title":"嵌入式之Linux C语言高级","review":0,"author":"真全栈程序员","mid":362268332,"is_union_video":0,"created":1571816853,"length":"610:15","video_review":0,"is_pay":0,"favorites":162,"aid":73140871,"is_steins_gate":0,"hide_click":false},{"comment":1,"typeid":39,"play":1030,"pic":"//i0.hdslb.com/bfs/archive/a68e4d08f1042281f9c584c894477dd30438cf9a.jpg","subtitle":"","description":"编程技术交流群：167399488（勿吹水闲聊）\n视频教程源于网络仅供学习，若有侵权，私信删除。\n【请勿相信视频中出现的网址和企鹅号及二维码等联系信息，以防上当受骗】\nup的编程技术交流小组在主页，资料也在小组中，大家一起交流哦。","copyright":"","title":"嵌入式之Linux C语言基础","review":0,"author":"真全栈程序员","mid":362268332,"is_union_video":0,"created":1571815210,"length":"1547:16","video_review":9,"is_pay":0,"favorites":156,"aid":73137095,"is_steins_gate":0,"hide_click":false},{"comment":2,"typeid":39,"play":1560,"pic":"//i0.hdslb.com/bfs/archive/8ac2a3aa058b01969ac8010e08174f58f5647887.jpg","subtitle":"","description":"编程技术交流群：167399488（勿吹水闲聊）\n视频教程源于网络仅供学习，若有侵权，私信删除。\n【请勿相信视频中出现的网址和企鹅号及二维码等联系信息，以防上当受骗】\nup的编程技术交流小组在主页，资料也在小组中，大家一起交流哦。","copyright":"","title":"Java架构师高级课程","review":0,"author":"真全栈程序员","mid":362268332,"is_union_video":0,"created":1571569935,"length":"6740:54","video_review":1,"is_pay":0,"favorites":269,"aid":71889808,"is_steins_gate":0,"hide_click":false},{"comment":2,"typeid":39,"play":1914,"pic":"//i2.hdslb.com/bfs/archive/2db8e82a5f22cefbe3f9e3a50f6ad2ad17821c48.jpg","subtitle":"","description":"编程技术交流群：167399488（勿吹水闲聊）\n视频教程源于网络仅供学习，若有侵权，私信删除。\n【请勿相信视频中出现的网址和企鹅号及二维码等联系信息，以防上当受骗】\nup的编程技术交流小组在主页，资料也在小组中，大家一起交流哦。","copyright":"","title":"算法进阶课程","review":0,"author":"真全栈程序员","mid":362268332,"is_union_video":0,"created":1571447154,"length":"1638:44","video_review":1,"is_pay":0,"favorites":386,"aid":71679959,"is_steins_gate":0,"hide_click":false},{"comment":4,"typeid":39,"play":2204,"pic":"//i1.hdslb.com/bfs/archive/35762fb26132bfab4d48cd05c6a2d7c557c5fa56.jpg","subtitle":"","description":"编程技术交流群：167399488（勿吹水闲聊）\n视频教程源于网络仅供学习，若有侵权，私信删除。\n【请勿相信视频中出现的网址和企鹅号及二维码等联系信息，以防上当受骗】\nup的编程技术交流小组在主页，资料也在小组中，大家一起交流哦。","copyright":"","title":"算法初级课程","review":0,"author":"真全栈程序员","mid":362268332,"is_union_video":0,"created":1571446843,"length":"1335:40","video_review":16,"is_pay":0,"favorites":367,"aid":71674726,"is_steins_gate":0,"hide_click":false},{"comment":3,"typeid":39,"play":1405,"pic":"//i0.hdslb.com/bfs/archive/ebb0012afcba42c911f1400ad46e591188f18f40.jpg","subtitle":"","description":"编程技术交流群：167399488（勿吹水闲聊）\n视频教程源于网络仅供学习，若有侵权，私信删除。\n【请勿相信视频中出现的网址和企鹅号及二维码等联系信息，以防上当受骗】\nup的编程技术交流小组在主页，资料也在小组中，大家一起交流哦。","copyright":"","title":"中华石杉老师-21天互联网Java进阶面试训练营（分布式篇）","review":0,"author":"真全栈程序员","mid":362268332,"is_union_video":0,"created":1571321159,"length":"682:17","video_review":3,"is_pay":0,"favorites":272,"aid":71506934,"is_steins_gate":0,"hide_click":false},{"comment":4,"typeid":39,"play":1570,"pic":"//i1.hdslb.com/bfs/archive/78a0f48e8d5e109b08b7c277aa8d201db12a5508.jpg","subtitle":"","description":"编程技术交流群：167399488（勿吹水闲聊）\n视频教程源于网络仅供学习，若有侵权，私信删除。\n【请勿相信视频中出现的网址和企鹅号及二维码等联系信息，以防上当受骗】\nup的编程技术交流小组在主页，资料也在小组中，大家一起交流哦。","copyright":"","title":"中华石杉老师-互联网Java工程师面试突击训练第1季（可能是史上最好的Java面试突击课程）","review":0,"author":"真全栈程序员","mid":362268332,"is_union_video":0,"created":1571320856,"length":"1994:40","video_review":1,"is_pay":0,"favorites":245,"aid":71505947,"is_steins_gate":0,"hide_click":false},{"comment":2,"typeid":39,"play":1094,"pic":"//i0.hdslb.com/bfs/archive/02df56e5b86124d03f47cb47873775982fa6bc57.jpg","subtitle":"","description":"编程技术交流群：167399488（勿吹水闲聊）\n视频教程源于网络仅供学习，若有侵权，私信删除。\n【请勿相信视频中出现的网址和企鹅号及二维码等联系信息，以防上当受骗】\nup的编程技术交流小组在主页，资料也在小组中，大家一起交流哦。","copyright":"","title":"亿级流量电商详情页系统实战（第二版）：缓存架构+高可用服务架构+微服务架构（中华石杉）","review":0,"author":"真全栈程序员","mid":362268332,"is_union_video":0,"created":1571306432,"length":"3790:58","video_review":2,"is_pay":0,"favorites":254,"aid":71494884,"is_steins_gate":0,"hide_click":false}]
         * count : 305
         * pages : 7
         */

        @JsonProperty("tlist")
        private TlistBean tlist;
        @JsonProperty("count")
        private int count;
        @JsonProperty("pages")
        private int pages;
        @JsonProperty("vlist")
        private List<VlistBean> vlist;

        public TlistBean getTlist() {
            return tlist;
        }

        public void setTlist(TlistBean tlist) {
            this.tlist = tlist;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public int getPages() {
            return pages;
        }

        public void setPages(int pages) {
            this.pages = pages;
        }

        public List<VlistBean> getVlist() {
            return vlist;
        }

        public void setVlist(List<VlistBean> vlist) {
            this.vlist = vlist;
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class TlistBean {
            /**
             * 36 : {"tid":36,"count":305,"name":"科技"}
             */

            @JsonProperty("36")
            private _$36Bean $36;

            public _$36Bean get$36() {
                return $36;
            }

            public void set$36(_$36Bean $36) {
                this.$36 = $36;
            }

            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class _$36Bean {
                /**
                 * tid : 36
                 * count : 305
                 * name : 科技
                 */

                @JsonProperty("tid")
                private int tid;
                @JsonProperty("count")
                private int count;
                @JsonProperty("name")
                private String name;

                public int getTid() {
                    return tid;
                }

                public void setTid(int tid) {
                    this.tid = tid;
                }

                public int getCount() {
                    return count;
                }

                public void setCount(int count) {
                    this.count = count;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }
            }
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class VlistBean {
            /**
             * comment : 1
             * typeid : 39
             * play : 576
             * pic : //i0.hdslb.com/bfs/archive/c4415d5c5014d635e0e096f29f3c9e32ade3d7d9.jpg
             * subtitle :
             * description : 编程技术交流群：167399488（勿吹水闲聊）
             视频教程源于网络仅供学习，若有侵权，私信删除。
             【请勿相信视频中出现的网址和企鹅号及二维码等联系信息，以防上当受骗】
             up的编程技术交流小组在主页，资料也在小组中，大家一起交流哦。
             * copyright :
             * title : 【薪资突破20K】JavaEE在职加薪课之大数据转型必备课程-Hadoop3
             * review : 0
             * author : 真全栈程序员
             * mid : 362268332
             * is_union_video : 0
             * created : 1572616842
             * length : 1296:22
             * video_review : 0
             * is_pay : 0
             * favorites : 75
             * aid : 74044043
             * is_steins_gate : 0
             * hide_click : false
             */

            @JsonProperty("comment")
            private int comment;
            @JsonProperty("typeid")
            private int typeid;
            @JsonProperty("play")
            private int play;
            @JsonProperty("pic")
            private String pic;
            @JsonProperty("subtitle")
            private String subtitle;
            @JsonProperty("description")
            private String description;
            @JsonProperty("copyright")
            private String copyright;
            @JsonProperty("title")
            private String title;
            @JsonProperty("review")
            private int review;
            @JsonProperty("author")
            private String author;
            @JsonProperty("mid")
            private int mid;
            @JsonProperty("is_union_video")
            private int isUnionVideo;
            @JsonProperty("created")
            private int created;
            @JsonProperty("length")
            private String length;
            @JsonProperty("video_review")
            private int videoReview;
            @JsonProperty("is_pay")
            private int isPay;
            @JsonProperty("favorites")
            private int favorites;
            @JsonProperty("aid")
            private int aid;
            @JsonProperty("is_steins_gate")
            private int isSteinsGate;
            @JsonProperty("hide_click")
            private boolean hideClick;

            public int getComment() {
                return comment;
            }

            public void setComment(int comment) {
                this.comment = comment;
            }

            public int getTypeid() {
                return typeid;
            }

            public void setTypeid(int typeid) {
                this.typeid = typeid;
            }

            public int getPlay() {
                return play;
            }

            public void setPlay(int play) {
                this.play = play;
            }

            public String getPic() {
                return pic;
            }

            public void setPic(String pic) {
                this.pic = pic;
            }

            public String getSubtitle() {
                return subtitle;
            }

            public void setSubtitle(String subtitle) {
                this.subtitle = subtitle;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getCopyright() {
                return copyright;
            }

            public void setCopyright(String copyright) {
                this.copyright = copyright;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public int getReview() {
                return review;
            }

            public void setReview(int review) {
                this.review = review;
            }

            public String getAuthor() {
                return author;
            }

            public void setAuthor(String author) {
                this.author = author;
            }

            public int getMid() {
                return mid;
            }

            public void setMid(int mid) {
                this.mid = mid;
            }

            public int getIsUnionVideo() {
                return isUnionVideo;
            }

            public void setIsUnionVideo(int isUnionVideo) {
                this.isUnionVideo = isUnionVideo;
            }

            public int getCreated() {
                return created;
            }

            public void setCreated(int created) {
                this.created = created;
            }

            public String getLength() {
                return length;
            }

            public void setLength(String length) {
                this.length = length;
            }

            public int getVideoReview() {
                return videoReview;
            }

            public void setVideoReview(int videoReview) {
                this.videoReview = videoReview;
            }

            public int getIsPay() {
                return isPay;
            }

            public void setIsPay(int isPay) {
                this.isPay = isPay;
            }

            public int getFavorites() {
                return favorites;
            }

            public void setFavorites(int favorites) {
                this.favorites = favorites;
            }

            public int getAid() {
                return aid;
            }

            public void setAid(int aid) {
                this.aid = aid;
            }

            public int getIsSteinsGate() {
                return isSteinsGate;
            }

            public void setIsSteinsGate(int isSteinsGate) {
                this.isSteinsGate = isSteinsGate;
            }

            public boolean isHideClick() {
                return hideClick;
            }

            public void setHideClick(boolean hideClick) {
                this.hideClick = hideClick;
            }
        }
    }
}
