package com.github.odinggg.tools.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * 描述:
 * 获取视频详情响应
 *
 * @author Hansen
 * @version 2019-11-05 15:41
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class VideoDetailResponse {

    /**
     * code : 0
     * message : 0
     * ttl : 1
     * data : {"bvid":"","aid":74044043,"videos":136,"tid":39,"tname":"演讲\u2022 公开课","copyright":2,"pic":"http://i2.hdslb.com/bfs/archive/c4415d5c5014d635e0e096f29f3c9e32ade3d7d9.jpg","title":"【薪资突破20K】JavaEE在职加薪课之大数据转型必备课程-Hadoop3","pubdate":1572616842,"ctime":1572523906,"desc":"编程技术交流群：167399488（勿吹水闲聊）\n视频教程源于网络仅供学习，若有侵权，私信删除。\n【请勿相信视频中出现的网址和企鹅号及二维码等联系信息，以防上当受骗】\nup的编程技术交流小组在主页，资料也在小组中，大家一起交流哦。","state":0,"attribute":16384,"duration":77782,"rights":{"bp":0,"elec":0,"download":1,"movie":0,"pay":0,"hd5":0,"no_reprint":0,"autoplay":1,"ugc_pay":0,"is_cooperation":0,"ugc_pay_preview":0},"owner":{"mid":362268332,"name":"真全栈程序员","face":"http://i0.hdslb.com/bfs/face/d9d971f7ba4889d01851b1be1f63e45e182e4668.jpg"},"stat":{"aid":74044043,"view":576,"danmaku":0,"reply":1,"favorite":75,"coin":4,"share":0,"now_rank":0,"his_rank":0,"like":40,"dislike":0,"evaluation":""},"dynamic":"上传了几天终于搞定了，此系列课程完结，这是最后一个了。撒花✿✿ヽ(°▽°)ノ✿\n\nJavaEE在职加薪课为一套完整课程，是为初级JavaEE工程师准备的进阶课程。\n本套课程包含3个大型微服务实战项目，从实战出发了解当下热门的微服务技术。\n据说完整学完，月薪可以突破20K，不管你信不信，反正我是信了，（手动滑稽）。\n\n本视频为最后一部分，讲解大数据转型必备课程-Hadoop3。#大数据##Hadoop##HDFS#","cid":126664942,"dimension":{"width":1360,"height":768,"rotate":0},"no_cache":false,"pages":[{"cid":126664942,"page":1,"from":"vupload","part":"1-今日内容和Hadoop的介绍","duration":826,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126664962,"page":2,"from":"vupload","part":"2-环境搭建-准备三台虚拟机","duration":537,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126664977,"page":3,"from":"vupload","part":"3-环境搭建-网络模式和内存设置","duration":471,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126664991,"page":4,"from":"vupload","part":"4-环境搭建-网络配置","duration":864,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126665010,"page":5,"from":"vupload","part":"5-Linux命令增强","duration":1002,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126665042,"page":6,"from":"vupload","part":"6-Linux命令增强2","duration":646,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126665055,"page":7,"from":"vupload","part":"7-Linux的shell脚本1","duration":771,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126665068,"page":8,"from":"vupload","part":"8-Linux的shell脚本2","duration":727,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126665094,"page":9,"from":"vupload","part":"9-集群环境搭建-配置1","duration":854,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126665118,"page":10,"from":"vupload","part":"10-集群环境搭建-配置2","duration":396,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126665127,"page":11,"from":"vupload","part":"11-集群环境搭建-jdk安装","duration":669,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126665146,"page":12,"from":"vupload","part":"12-Zookeeper的概述","duration":598,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126665160,"page":13,"from":"vupload","part":"13-Zookeeper的安装","duration":884,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126665191,"page":14,"from":"vupload","part":"14-Zookeeper的节点操作","duration":834,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126665220,"page":15,"from":"vupload","part":"15-Zookeeper的watch机制","duration":391,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126665237,"page":16,"from":"vupload","part":"16-hadoop的架构","duration":1140,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126665285,"page":17,"from":"vupload","part":"17-hadoop的安装-准备工作","duration":351,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126665302,"page":18,"from":"vupload","part":"18-hadoop的安装-配置文件修改","duration":878,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126665334,"page":19,"from":"vupload","part":"19-hadoop的安装-启动集群","duration":675,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126665351,"page":20,"from":"vupload","part":"1-HDFS的概述","duration":288,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126665363,"page":21,"from":"vupload","part":"2-HDFS的namenode和datanode","duration":520,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126665380,"page":22,"from":"vupload","part":"3-HDFS的文件副本机制","duration":758,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126665400,"page":23,"from":"vupload","part":"4-HDFS的块缓存和访问权限","duration":327,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126665412,"page":24,"from":"vupload","part":"5-HDFS的Secondarynamenode工作机制","duration":889,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126665448,"page":25,"from":"vupload","part":"6-HDFS数据的写入过程","duration":1081,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126665473,"page":26,"from":"vupload","part":"7-HDFS数据的读取过程","duration":851,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126665496,"page":27,"from":"vupload","part":"8-HDFS的shell操作命令","duration":1002,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126665525,"page":28,"from":"vupload","part":"9-HDFS的页面操作","duration":300,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126665533,"page":29,"from":"vupload","part":"10-HDFS的API操作-配置Window系统下的Hadoop","duration":196,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126665539,"page":30,"from":"vupload","part":"11-HDFS的API操作-获取FileSystem方式1","duration":788,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126665559,"page":31,"from":"vupload","part":"12-HDFS的API操作-获取FileSystem其他方式","duration":367,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126665576,"page":32,"from":"vupload","part":"13-HDFS的API操作-获取文件列表信息","duration":659,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126665600,"page":33,"from":"vupload","part":"14-HDFS的API操作-创建文件和文件夹","duration":219,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126665612,"page":34,"from":"vupload","part":"15-HDFS的API操作-文件的上传和下载","duration":691,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126665635,"page":35,"from":"vupload","part":"16-HDFS的API操作-访问权限问题","duration":708,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126665653,"page":36,"from":"vupload","part":"17-HDFS的API操作-小文件的合并","duration":716,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126665677,"page":37,"from":"vupload","part":"1-MapReduce介绍","duration":752,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126665701,"page":38,"from":"vupload","part":"2-MapReduce的构思和框架结构","duration":438,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126665711,"page":39,"from":"vupload","part":"3-MapReduce的编程规范","duration":293,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126665731,"page":40,"from":"vupload","part":"4-MapReduce案例-wordcount-步骤分析","duration":1280,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126665759,"page":41,"from":"vupload","part":"5-MapReduce案例-wordcount-准备工作","duration":310,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126665771,"page":42,"from":"vupload","part":"6-MapReduce案例-wordcount-Map阶段代码","duration":853,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126665793,"page":43,"from":"vupload","part":"7-MapReduce案例-wordcount-Reduce阶段代码","duration":564,"vid":"","weblink":"","dimension":{"width":1356,"height":768,"rotate":0}},{"cid":126665806,"page":44,"from":"vupload","part":"8-MapReduce案例-wordcount-JobMain代码","duration":1198,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126665851,"page":45,"from":"vupload","part":"9-MapReduce案例-wordcount-集群运行","duration":426,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126665869,"page":46,"from":"vupload","part":"10-MapReduce分区-原理","duration":633,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126665886,"page":47,"from":"vupload","part":"11-MapReduce分区-代码实现","duration":692,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126666041,"page":48,"from":"vupload","part":"12-MapReduce排序-概述","duration":274,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126666054,"page":49,"from":"vupload","part":"13-MapReduce排序-流程分析","duration":973,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126666072,"page":50,"from":"vupload","part":"14-MapReduce排序-实现比较器和序列化代码","duration":618,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126666099,"page":51,"from":"vupload","part":"15-MapReduce排序-其他代码编写","duration":781,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126666123,"page":52,"from":"vupload","part":"16-MapReduce排序-集群运行","duration":278,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126666140,"page":53,"from":"vupload","part":"1-MapReduce-计数器","duration":736,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126666163,"page":54,"from":"vupload","part":"2-MapReduce-Combiner规约-原理分析","duration":607,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126666186,"page":55,"from":"vupload","part":"3-MapReduce-Combiner规约-代码实现","duration":813,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126666222,"page":56,"from":"vupload","part":"4-MapReduce-流量统计求和-步骤分析","duration":761,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126666243,"page":57,"from":"vupload","part":"5-MapReduce-流量统计求和-FlowBean和Mapper代码编写","duration":643,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126666266,"page":58,"from":"vupload","part":"6-MapReduce-流量统计求和-Reducer和JobMain代码编写","duration":558,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126666292,"page":59,"from":"vupload","part":"7-MapReduce-流量统计求和-测试运行","duration":204,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126666300,"page":60,"from":"vupload","part":"8-MapReduce-流量统计求和-排序-FlowBean编写","duration":320,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126666320,"page":61,"from":"vupload","part":"9-MapReduce-流量统计求和-排序-Mapper和Reducer编写","duration":413,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126666349,"page":62,"from":"vupload","part":"10-MapReduce-流量统计求和-排序-JobMain代码和测试运行","duration":340,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126666366,"page":63,"from":"vupload","part":"11-MapReduce-流量统计求和-分区代码实现","duration":586,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126666381,"page":64,"from":"vupload","part":"12-MapReduce运行机制-Map阶段","duration":1213,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126666410,"page":65,"from":"vupload","part":"13-MapReduce运行机制-Map阶段-细节补充","duration":186,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126666421,"page":66,"from":"vupload","part":"14-MapReduce运行机制-Reduce阶段","duration":597,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126666434,"page":67,"from":"vupload","part":"15-MapReduce-Reduce端join操作-步骤分析","duration":796,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126666454,"page":68,"from":"vupload","part":"16-MapReduce-Reduce端join操作-Map阶段代码","duration":429,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126666460,"page":69,"from":"vupload","part":"17-MapReduce-Reduce端join操作-Reducer阶段代码","duration":290,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126666475,"page":70,"from":"vupload","part":"18-MapReduce-Reduce端join操作-集群测试","duration":356,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126666486,"page":71,"from":"vupload","part":"1-数据仓库的基本特征","duration":394,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126666499,"page":72,"from":"vupload","part":"2-数据仓库和数据库的区别","duration":278,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126666511,"page":73,"from":"vupload","part":"3-数据仓库分层和元数据管理","duration":492,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126666534,"page":74,"from":"vupload","part":"4-Hive的基本介绍","duration":591,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126666564,"page":75,"from":"vupload","part":"5-Hive的架构","duration":261,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126666575,"page":76,"from":"vupload","part":"6-Hive和Hadoop及RDBMS关系","duration":244,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126666581,"page":77,"from":"vupload","part":"7-Hive的安装-Mysql安装","duration":300,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126666593,"page":78,"from":"vupload","part":"8-Hive的安装-Hive配置","duration":265,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126666606,"page":79,"from":"vupload","part":"9-Hive的安装-Hive的交互方式","duration":431,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126666614,"page":80,"from":"vupload","part":"10-Hive的基本操作-数据库的创建和删除","duration":374,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126666625,"page":81,"from":"vupload","part":"11-Hive的基本操作-创建表的格式","duration":496,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126666645,"page":82,"from":"vupload","part":"12-Hive的基本操作-创建内部表","duration":455,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126666663,"page":83,"from":"vupload","part":"13-Hive的基本操作-创建外部表","duration":765,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126666690,"page":84,"from":"vupload","part":"14-Hive的基本操作-创建分区表","duration":556,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126666703,"page":85,"from":"vupload","part":"15-Hive的基本操作-创建分桶表","duration":516,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126666729,"page":86,"from":"vupload","part":"16-Hive的基本操作-表结构修改和数据加载","duration":259,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126666767,"page":87,"from":"vupload","part":"17-Hive的基本操作-基本查询语法","duration":669,"vid":"","weblink":"","dimension":{"width":1352,"height":768,"rotate":0}},{"cid":126666785,"page":88,"from":"vupload","part":"18-Hive的基本操作-分组和多表连接","duration":1027,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126666813,"page":89,"from":"vupload","part":"19-Hive的基本操作-排序","duration":970,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126666837,"page":90,"from":"vupload","part":"20-Hive的基本操作-内置函数","duration":529,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126666852,"page":91,"from":"vupload","part":"21-Hive的基本操作-自定义函数","duration":769,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126684815,"page":92,"from":"vupload","part":"1-flume的概述和运行机制","duration":590,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126684837,"page":93,"from":"vupload","part":"2-flume案例-网络数据采集-Flume安装","duration":305,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126684845,"page":94,"from":"vupload","part":"3-flume案例-网络数据采集-Flume的配置","duration":634,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126684867,"page":95,"from":"vupload","part":"4-flume案例-网络数据采集-启动flume","duration":442,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126684881,"page":96,"from":"vupload","part":"5-flume案例-目录数据采集-实现流程","duration":339,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126684893,"page":97,"from":"vupload","part":"6-flume案例-目录数据采集-配置文件编写","duration":1289,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126684929,"page":98,"from":"vupload","part":"7-flume案例-目录数据采集-运行测试","duration":349,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126684960,"page":99,"from":"vupload","part":"8-flume案例-文件数据采集-步骤分析","duration":620,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126684994,"page":100,"from":"vupload","part":"9-flume案例-文件数据采集-运行测试","duration":381,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126685024,"page":101,"from":"vupload","part":"10-flume案例-flume级联-组件分析","duration":514,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126685050,"page":102,"from":"vupload","part":"11-flume案例-flume级联-配置文件编写","duration":492,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126685071,"page":103,"from":"vupload","part":"12-flume案例-flume级联-测试运行","duration":269,"vid":"","weblink":"","dimension":{"width":1356,"height":768,"rotate":0}},{"cid":126685083,"page":104,"from":"vupload","part":"13-flume高可用-failover-模型分析","duration":370,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126685093,"page":105,"from":"vupload","part":"14-flume高可用-failover-配置文件编写","duration":566,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126685118,"page":106,"from":"vupload","part":"15-flume高可用-failover-测试运行","duration":310,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126685136,"page":107,"from":"vupload","part":"16-flume高可用-balance-配置文件编写","duration":524,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126685150,"page":108,"from":"vupload","part":"17-flume高可用-balance-测试运行","duration":179,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126685155,"page":109,"from":"vupload","part":"18-flume拦截器-模型分析","duration":555,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126685171,"page":110,"from":"vupload","part":"19-flume拦截器-配置文件编写","duration":668,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126685201,"page":111,"from":"vupload","part":"20-flume拦截器-测试运行","duration":338,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126684844,"page":112,"from":"vupload","part":"1-Azkaban介绍","duration":381,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126685227,"page":113,"from":"vupload","part":"2-Azkaban编译和安装模式","duration":708,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126685247,"page":114,"from":"vupload","part":"3-Azkaban-solo模式-安装","duration":357,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126685263,"page":115,"from":"vupload","part":"4-Azkaban-solo模式-使用","duration":347,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126685273,"page":116,"from":"vupload","part":"5-Azkaban-two_server模式-安装1","duration":599,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126685305,"page":117,"from":"vupload","part":"6-Azkaban-two_server模式-安装2","duration":504,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126685326,"page":118,"from":"vupload","part":"7-Azkaban-two_server模式-安装3和启动运行","duration":367,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126685343,"page":119,"from":"vupload","part":"8-Azkaban-two_server模式-job任务运行1","duration":594,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126685361,"page":120,"from":"vupload","part":"9-Azkaban-two_server模式-job任务运行2","duration":995,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126685389,"page":121,"from":"vupload","part":"10-sqoop入门介绍","duration":270,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126685400,"page":122,"from":"vupload","part":"11-sqoop安装","duration":343,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126685421,"page":123,"from":"vupload","part":"12-sqoop导入-hdfs","duration":769,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126685450,"page":124,"from":"vupload","part":"13-sqoop导入-hive","duration":405,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126685470,"page":125,"from":"vupload","part":"14-sqoop增量导入hdfs和导出","duration":602,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126685487,"page":126,"from":"vupload","part":"15-网站流量日志分析-分析模型","duration":711,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126685506,"page":127,"from":"vupload","part":"16-网站流量日志分析-分析指标","duration":332,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126685523,"page":128,"from":"vupload","part":"17-网站流量日志分析-数据处理流程","duration":296,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126685529,"page":129,"from":"vupload","part":"18-网站流量日志分析-数据采集","duration":427,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126685549,"page":130,"from":"vupload","part":"19-网站流量日志分析-数据预处理","duration":725,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126685585,"page":131,"from":"vupload","part":"20-网站流量日志分析-获取PageView表模型","duration":882,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126685625,"page":132,"from":"vupload","part":"21-网站流量日志分析-获取Visit表模型","duration":406,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126685646,"page":133,"from":"vupload","part":"22-网站流量日志分析-hive表数据导入","duration":705,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126685667,"page":134,"from":"vupload","part":"23-网站流量日志分析-hive表数据分析和导出","duration":414,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126685679,"page":135,"from":"vupload","part":"24-网站流量日志分析-数据的可视化-Echarts入门","duration":342,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126685695,"page":136,"from":"vupload","part":"25-网站流量日志分析-数据的可视化-案例分析结果可视化","duration":841,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}}],"subtitle":{"allow_submit":false,"list":[]}}
     */

    @JsonProperty("code")
    private int code;
    @JsonProperty("message")
    private String message;
    @JsonProperty("ttl")
    private int ttl;
    @JsonProperty("data")
    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getTtl() {
        return ttl;
    }

    public void setTtl(int ttl) {
        this.ttl = ttl;
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
         * bvid :
         * aid : 74044043
         * videos : 136
         * tid : 39
         * tname : 演讲• 公开课
         * copyright : 2
         * pic : http://i2.hdslb.com/bfs/archive/c4415d5c5014d635e0e096f29f3c9e32ade3d7d9.jpg
         * title : 【薪资突破20K】JavaEE在职加薪课之大数据转型必备课程-Hadoop3
         * pubdate : 1572616842
         * ctime : 1572523906
         * desc : 编程技术交流群：167399488（勿吹水闲聊）
         * 视频教程源于网络仅供学习，若有侵权，私信删除。
         * 【请勿相信视频中出现的网址和企鹅号及二维码等联系信息，以防上当受骗】
         * up的编程技术交流小组在主页，资料也在小组中，大家一起交流哦。
         * state : 0
         * attribute : 16384
         * duration : 77782
         * rights : {"bp":0,"elec":0,"download":1,"movie":0,"pay":0,"hd5":0,"no_reprint":0,"autoplay":1,"ugc_pay":0,"is_cooperation":0,"ugc_pay_preview":0}
         * owner : {"mid":362268332,"name":"真全栈程序员","face":"http://i0.hdslb.com/bfs/face/d9d971f7ba4889d01851b1be1f63e45e182e4668.jpg"}
         * stat : {"aid":74044043,"view":576,"danmaku":0,"reply":1,"favorite":75,"coin":4,"share":0,"now_rank":0,"his_rank":0,"like":40,"dislike":0,"evaluation":""}
         * dynamic : 上传了几天终于搞定了，此系列课程完结，这是最后一个了。撒花✿✿ヽ(°▽°)ノ✿
         * <p>
         * JavaEE在职加薪课为一套完整课程，是为初级JavaEE工程师准备的进阶课程。
         * 本套课程包含3个大型微服务实战项目，从实战出发了解当下热门的微服务技术。
         * 据说完整学完，月薪可以突破20K，不管你信不信，反正我是信了，（手动滑稽）。
         * <p>
         * 本视频为最后一部分，讲解大数据转型必备课程-Hadoop3。#大数据##Hadoop##HDFS#
         * cid : 126664942
         * dimension : {"width":1360,"height":768,"rotate":0}
         * no_cache : false
         * pages : [{"cid":126664942,"page":1,"from":"vupload","part":"1-今日内容和Hadoop的介绍","duration":826,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126664962,"page":2,"from":"vupload","part":"2-环境搭建-准备三台虚拟机","duration":537,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126664977,"page":3,"from":"vupload","part":"3-环境搭建-网络模式和内存设置","duration":471,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126664991,"page":4,"from":"vupload","part":"4-环境搭建-网络配置","duration":864,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126665010,"page":5,"from":"vupload","part":"5-Linux命令增强","duration":1002,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126665042,"page":6,"from":"vupload","part":"6-Linux命令增强2","duration":646,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126665055,"page":7,"from":"vupload","part":"7-Linux的shell脚本1","duration":771,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126665068,"page":8,"from":"vupload","part":"8-Linux的shell脚本2","duration":727,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126665094,"page":9,"from":"vupload","part":"9-集群环境搭建-配置1","duration":854,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126665118,"page":10,"from":"vupload","part":"10-集群环境搭建-配置2","duration":396,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126665127,"page":11,"from":"vupload","part":"11-集群环境搭建-jdk安装","duration":669,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126665146,"page":12,"from":"vupload","part":"12-Zookeeper的概述","duration":598,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126665160,"page":13,"from":"vupload","part":"13-Zookeeper的安装","duration":884,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126665191,"page":14,"from":"vupload","part":"14-Zookeeper的节点操作","duration":834,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126665220,"page":15,"from":"vupload","part":"15-Zookeeper的watch机制","duration":391,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126665237,"page":16,"from":"vupload","part":"16-hadoop的架构","duration":1140,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126665285,"page":17,"from":"vupload","part":"17-hadoop的安装-准备工作","duration":351,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126665302,"page":18,"from":"vupload","part":"18-hadoop的安装-配置文件修改","duration":878,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126665334,"page":19,"from":"vupload","part":"19-hadoop的安装-启动集群","duration":675,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126665351,"page":20,"from":"vupload","part":"1-HDFS的概述","duration":288,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126665363,"page":21,"from":"vupload","part":"2-HDFS的namenode和datanode","duration":520,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126665380,"page":22,"from":"vupload","part":"3-HDFS的文件副本机制","duration":758,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126665400,"page":23,"from":"vupload","part":"4-HDFS的块缓存和访问权限","duration":327,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126665412,"page":24,"from":"vupload","part":"5-HDFS的Secondarynamenode工作机制","duration":889,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126665448,"page":25,"from":"vupload","part":"6-HDFS数据的写入过程","duration":1081,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126665473,"page":26,"from":"vupload","part":"7-HDFS数据的读取过程","duration":851,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126665496,"page":27,"from":"vupload","part":"8-HDFS的shell操作命令","duration":1002,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126665525,"page":28,"from":"vupload","part":"9-HDFS的页面操作","duration":300,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126665533,"page":29,"from":"vupload","part":"10-HDFS的API操作-配置Window系统下的Hadoop","duration":196,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126665539,"page":30,"from":"vupload","part":"11-HDFS的API操作-获取FileSystem方式1","duration":788,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126665559,"page":31,"from":"vupload","part":"12-HDFS的API操作-获取FileSystem其他方式","duration":367,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126665576,"page":32,"from":"vupload","part":"13-HDFS的API操作-获取文件列表信息","duration":659,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126665600,"page":33,"from":"vupload","part":"14-HDFS的API操作-创建文件和文件夹","duration":219,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126665612,"page":34,"from":"vupload","part":"15-HDFS的API操作-文件的上传和下载","duration":691,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126665635,"page":35,"from":"vupload","part":"16-HDFS的API操作-访问权限问题","duration":708,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126665653,"page":36,"from":"vupload","part":"17-HDFS的API操作-小文件的合并","duration":716,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126665677,"page":37,"from":"vupload","part":"1-MapReduce介绍","duration":752,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126665701,"page":38,"from":"vupload","part":"2-MapReduce的构思和框架结构","duration":438,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126665711,"page":39,"from":"vupload","part":"3-MapReduce的编程规范","duration":293,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126665731,"page":40,"from":"vupload","part":"4-MapReduce案例-wordcount-步骤分析","duration":1280,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126665759,"page":41,"from":"vupload","part":"5-MapReduce案例-wordcount-准备工作","duration":310,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126665771,"page":42,"from":"vupload","part":"6-MapReduce案例-wordcount-Map阶段代码","duration":853,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126665793,"page":43,"from":"vupload","part":"7-MapReduce案例-wordcount-Reduce阶段代码","duration":564,"vid":"","weblink":"","dimension":{"width":1356,"height":768,"rotate":0}},{"cid":126665806,"page":44,"from":"vupload","part":"8-MapReduce案例-wordcount-JobMain代码","duration":1198,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126665851,"page":45,"from":"vupload","part":"9-MapReduce案例-wordcount-集群运行","duration":426,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126665869,"page":46,"from":"vupload","part":"10-MapReduce分区-原理","duration":633,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126665886,"page":47,"from":"vupload","part":"11-MapReduce分区-代码实现","duration":692,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126666041,"page":48,"from":"vupload","part":"12-MapReduce排序-概述","duration":274,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126666054,"page":49,"from":"vupload","part":"13-MapReduce排序-流程分析","duration":973,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126666072,"page":50,"from":"vupload","part":"14-MapReduce排序-实现比较器和序列化代码","duration":618,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126666099,"page":51,"from":"vupload","part":"15-MapReduce排序-其他代码编写","duration":781,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126666123,"page":52,"from":"vupload","part":"16-MapReduce排序-集群运行","duration":278,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126666140,"page":53,"from":"vupload","part":"1-MapReduce-计数器","duration":736,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126666163,"page":54,"from":"vupload","part":"2-MapReduce-Combiner规约-原理分析","duration":607,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126666186,"page":55,"from":"vupload","part":"3-MapReduce-Combiner规约-代码实现","duration":813,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126666222,"page":56,"from":"vupload","part":"4-MapReduce-流量统计求和-步骤分析","duration":761,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126666243,"page":57,"from":"vupload","part":"5-MapReduce-流量统计求和-FlowBean和Mapper代码编写","duration":643,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126666266,"page":58,"from":"vupload","part":"6-MapReduce-流量统计求和-Reducer和JobMain代码编写","duration":558,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126666292,"page":59,"from":"vupload","part":"7-MapReduce-流量统计求和-测试运行","duration":204,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126666300,"page":60,"from":"vupload","part":"8-MapReduce-流量统计求和-排序-FlowBean编写","duration":320,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126666320,"page":61,"from":"vupload","part":"9-MapReduce-流量统计求和-排序-Mapper和Reducer编写","duration":413,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126666349,"page":62,"from":"vupload","part":"10-MapReduce-流量统计求和-排序-JobMain代码和测试运行","duration":340,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126666366,"page":63,"from":"vupload","part":"11-MapReduce-流量统计求和-分区代码实现","duration":586,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126666381,"page":64,"from":"vupload","part":"12-MapReduce运行机制-Map阶段","duration":1213,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126666410,"page":65,"from":"vupload","part":"13-MapReduce运行机制-Map阶段-细节补充","duration":186,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126666421,"page":66,"from":"vupload","part":"14-MapReduce运行机制-Reduce阶段","duration":597,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126666434,"page":67,"from":"vupload","part":"15-MapReduce-Reduce端join操作-步骤分析","duration":796,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126666454,"page":68,"from":"vupload","part":"16-MapReduce-Reduce端join操作-Map阶段代码","duration":429,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126666460,"page":69,"from":"vupload","part":"17-MapReduce-Reduce端join操作-Reducer阶段代码","duration":290,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126666475,"page":70,"from":"vupload","part":"18-MapReduce-Reduce端join操作-集群测试","duration":356,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126666486,"page":71,"from":"vupload","part":"1-数据仓库的基本特征","duration":394,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126666499,"page":72,"from":"vupload","part":"2-数据仓库和数据库的区别","duration":278,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126666511,"page":73,"from":"vupload","part":"3-数据仓库分层和元数据管理","duration":492,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126666534,"page":74,"from":"vupload","part":"4-Hive的基本介绍","duration":591,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126666564,"page":75,"from":"vupload","part":"5-Hive的架构","duration":261,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126666575,"page":76,"from":"vupload","part":"6-Hive和Hadoop及RDBMS关系","duration":244,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126666581,"page":77,"from":"vupload","part":"7-Hive的安装-Mysql安装","duration":300,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126666593,"page":78,"from":"vupload","part":"8-Hive的安装-Hive配置","duration":265,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126666606,"page":79,"from":"vupload","part":"9-Hive的安装-Hive的交互方式","duration":431,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126666614,"page":80,"from":"vupload","part":"10-Hive的基本操作-数据库的创建和删除","duration":374,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126666625,"page":81,"from":"vupload","part":"11-Hive的基本操作-创建表的格式","duration":496,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126666645,"page":82,"from":"vupload","part":"12-Hive的基本操作-创建内部表","duration":455,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126666663,"page":83,"from":"vupload","part":"13-Hive的基本操作-创建外部表","duration":765,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126666690,"page":84,"from":"vupload","part":"14-Hive的基本操作-创建分区表","duration":556,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126666703,"page":85,"from":"vupload","part":"15-Hive的基本操作-创建分桶表","duration":516,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126666729,"page":86,"from":"vupload","part":"16-Hive的基本操作-表结构修改和数据加载","duration":259,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126666767,"page":87,"from":"vupload","part":"17-Hive的基本操作-基本查询语法","duration":669,"vid":"","weblink":"","dimension":{"width":1352,"height":768,"rotate":0}},{"cid":126666785,"page":88,"from":"vupload","part":"18-Hive的基本操作-分组和多表连接","duration":1027,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126666813,"page":89,"from":"vupload","part":"19-Hive的基本操作-排序","duration":970,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126666837,"page":90,"from":"vupload","part":"20-Hive的基本操作-内置函数","duration":529,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126666852,"page":91,"from":"vupload","part":"21-Hive的基本操作-自定义函数","duration":769,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126684815,"page":92,"from":"vupload","part":"1-flume的概述和运行机制","duration":590,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126684837,"page":93,"from":"vupload","part":"2-flume案例-网络数据采集-Flume安装","duration":305,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126684845,"page":94,"from":"vupload","part":"3-flume案例-网络数据采集-Flume的配置","duration":634,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126684867,"page":95,"from":"vupload","part":"4-flume案例-网络数据采集-启动flume","duration":442,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126684881,"page":96,"from":"vupload","part":"5-flume案例-目录数据采集-实现流程","duration":339,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126684893,"page":97,"from":"vupload","part":"6-flume案例-目录数据采集-配置文件编写","duration":1289,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126684929,"page":98,"from":"vupload","part":"7-flume案例-目录数据采集-运行测试","duration":349,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126684960,"page":99,"from":"vupload","part":"8-flume案例-文件数据采集-步骤分析","duration":620,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126684994,"page":100,"from":"vupload","part":"9-flume案例-文件数据采集-运行测试","duration":381,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126685024,"page":101,"from":"vupload","part":"10-flume案例-flume级联-组件分析","duration":514,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126685050,"page":102,"from":"vupload","part":"11-flume案例-flume级联-配置文件编写","duration":492,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126685071,"page":103,"from":"vupload","part":"12-flume案例-flume级联-测试运行","duration":269,"vid":"","weblink":"","dimension":{"width":1356,"height":768,"rotate":0}},{"cid":126685083,"page":104,"from":"vupload","part":"13-flume高可用-failover-模型分析","duration":370,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126685093,"page":105,"from":"vupload","part":"14-flume高可用-failover-配置文件编写","duration":566,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126685118,"page":106,"from":"vupload","part":"15-flume高可用-failover-测试运行","duration":310,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126685136,"page":107,"from":"vupload","part":"16-flume高可用-balance-配置文件编写","duration":524,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126685150,"page":108,"from":"vupload","part":"17-flume高可用-balance-测试运行","duration":179,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126685155,"page":109,"from":"vupload","part":"18-flume拦截器-模型分析","duration":555,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126685171,"page":110,"from":"vupload","part":"19-flume拦截器-配置文件编写","duration":668,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126685201,"page":111,"from":"vupload","part":"20-flume拦截器-测试运行","duration":338,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126684844,"page":112,"from":"vupload","part":"1-Azkaban介绍","duration":381,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126685227,"page":113,"from":"vupload","part":"2-Azkaban编译和安装模式","duration":708,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126685247,"page":114,"from":"vupload","part":"3-Azkaban-solo模式-安装","duration":357,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126685263,"page":115,"from":"vupload","part":"4-Azkaban-solo模式-使用","duration":347,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126685273,"page":116,"from":"vupload","part":"5-Azkaban-two_server模式-安装1","duration":599,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126685305,"page":117,"from":"vupload","part":"6-Azkaban-two_server模式-安装2","duration":504,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126685326,"page":118,"from":"vupload","part":"7-Azkaban-two_server模式-安装3和启动运行","duration":367,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126685343,"page":119,"from":"vupload","part":"8-Azkaban-two_server模式-job任务运行1","duration":594,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126685361,"page":120,"from":"vupload","part":"9-Azkaban-two_server模式-job任务运行2","duration":995,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126685389,"page":121,"from":"vupload","part":"10-sqoop入门介绍","duration":270,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126685400,"page":122,"from":"vupload","part":"11-sqoop安装","duration":343,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126685421,"page":123,"from":"vupload","part":"12-sqoop导入-hdfs","duration":769,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126685450,"page":124,"from":"vupload","part":"13-sqoop导入-hive","duration":405,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126685470,"page":125,"from":"vupload","part":"14-sqoop增量导入hdfs和导出","duration":602,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126685487,"page":126,"from":"vupload","part":"15-网站流量日志分析-分析模型","duration":711,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126685506,"page":127,"from":"vupload","part":"16-网站流量日志分析-分析指标","duration":332,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126685523,"page":128,"from":"vupload","part":"17-网站流量日志分析-数据处理流程","duration":296,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126685529,"page":129,"from":"vupload","part":"18-网站流量日志分析-数据采集","duration":427,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126685549,"page":130,"from":"vupload","part":"19-网站流量日志分析-数据预处理","duration":725,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126685585,"page":131,"from":"vupload","part":"20-网站流量日志分析-获取PageView表模型","duration":882,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126685625,"page":132,"from":"vupload","part":"21-网站流量日志分析-获取Visit表模型","duration":406,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126685646,"page":133,"from":"vupload","part":"22-网站流量日志分析-hive表数据导入","duration":705,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126685667,"page":134,"from":"vupload","part":"23-网站流量日志分析-hive表数据分析和导出","duration":414,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126685679,"page":135,"from":"vupload","part":"24-网站流量日志分析-数据的可视化-Echarts入门","duration":342,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}},{"cid":126685695,"page":136,"from":"vupload","part":"25-网站流量日志分析-数据的可视化-案例分析结果可视化","duration":841,"vid":"","weblink":"","dimension":{"width":1360,"height":768,"rotate":0}}]
         * subtitle : {"allow_submit":false,"list":[]}
         */

        @JsonProperty("bvid")
        private String bvid;
        @JsonProperty("aid")
        private int aid;
        @JsonProperty("videos")
        private int videos;
        @JsonProperty("tid")
        private int tid;
        @JsonProperty("tname")
        private String tname;
        @JsonProperty("copyright")
        private int copyright;
        @JsonProperty("pic")
        private String pic;
        @JsonProperty("title")
        private String title;
        @JsonProperty("pubdate")
        private int pubdate;
        @JsonProperty("ctime")
        private int ctime;
        @JsonProperty("desc")
        private String desc;
        @JsonProperty("state")
        private int state;
        @JsonProperty("attribute")
        private int attribute;
        @JsonProperty("duration")
        private int duration;
        @JsonProperty("rights")
        private RightsBean rights;
        @JsonProperty("owner")
        private OwnerBean owner;
        @JsonProperty("stat")
        private StatBean stat;
        @JsonProperty("dynamic")
        private String dynamic;
        @JsonProperty("cid")
        private int cid;
        @JsonProperty("dimension")
        private DimensionBean dimension;
        @JsonProperty("no_cache")
        private boolean noCache;
        @JsonProperty("subtitle")
        private SubtitleBean subtitle;
        @JsonProperty("pages")
        private List<PagesBean> pages;

        public String getBvid() {
            return bvid;
        }

        public void setBvid(String bvid) {
            this.bvid = bvid;
        }

        public int getAid() {
            return aid;
        }

        public void setAid(int aid) {
            this.aid = aid;
        }

        public int getVideos() {
            return videos;
        }

        public void setVideos(int videos) {
            this.videos = videos;
        }

        public int getTid() {
            return tid;
        }

        public void setTid(int tid) {
            this.tid = tid;
        }

        public String getTname() {
            return tname;
        }

        public void setTname(String tname) {
            this.tname = tname;
        }

        public int getCopyright() {
            return copyright;
        }

        public void setCopyright(int copyright) {
            this.copyright = copyright;
        }

        public String getPic() {
            return pic;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getPubdate() {
            return pubdate;
        }

        public void setPubdate(int pubdate) {
            this.pubdate = pubdate;
        }

        public int getCtime() {
            return ctime;
        }

        public void setCtime(int ctime) {
            this.ctime = ctime;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public int getState() {
            return state;
        }

        public void setState(int state) {
            this.state = state;
        }

        public int getAttribute() {
            return attribute;
        }

        public void setAttribute(int attribute) {
            this.attribute = attribute;
        }

        public int getDuration() {
            return duration;
        }

        public void setDuration(int duration) {
            this.duration = duration;
        }

        public RightsBean getRights() {
            return rights;
        }

        public void setRights(RightsBean rights) {
            this.rights = rights;
        }

        public OwnerBean getOwner() {
            return owner;
        }

        public void setOwner(OwnerBean owner) {
            this.owner = owner;
        }

        public StatBean getStat() {
            return stat;
        }

        public void setStat(StatBean stat) {
            this.stat = stat;
        }

        public String getDynamic() {
            return dynamic;
        }

        public void setDynamic(String dynamic) {
            this.dynamic = dynamic;
        }

        public int getCid() {
            return cid;
        }

        public void setCid(int cid) {
            this.cid = cid;
        }

        public DimensionBean getDimension() {
            return dimension;
        }

        public void setDimension(DimensionBean dimension) {
            this.dimension = dimension;
        }

        public boolean isNoCache() {
            return noCache;
        }

        public void setNoCache(boolean noCache) {
            this.noCache = noCache;
        }

        public SubtitleBean getSubtitle() {
            return subtitle;
        }

        public void setSubtitle(SubtitleBean subtitle) {
            this.subtitle = subtitle;
        }

        public List<PagesBean> getPages() {
            return pages;
        }

        public void setPages(List<PagesBean> pages) {
            this.pages = pages;
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class RightsBean {
            /**
             * bp : 0
             * elec : 0
             * download : 1
             * movie : 0
             * pay : 0
             * hd5 : 0
             * no_reprint : 0
             * autoplay : 1
             * ugc_pay : 0
             * is_cooperation : 0
             * ugc_pay_preview : 0
             */

            @JsonProperty("bp")
            private int bp;
            @JsonProperty("elec")
            private int elec;
            @JsonProperty("download")
            private int download;
            @JsonProperty("movie")
            private int movie;
            @JsonProperty("pay")
            private int pay;
            @JsonProperty("hd5")
            private int hd5;
            @JsonProperty("no_reprint")
            private int noReprint;
            @JsonProperty("autoplay")
            private int autoplay;
            @JsonProperty("ugc_pay")
            private int ugcPay;
            @JsonProperty("is_cooperation")
            private int isCooperation;
            @JsonProperty("ugc_pay_preview")
            private int ugcPayPreview;

            public int getBp() {
                return bp;
            }

            public void setBp(int bp) {
                this.bp = bp;
            }

            public int getElec() {
                return elec;
            }

            public void setElec(int elec) {
                this.elec = elec;
            }

            public int getDownload() {
                return download;
            }

            public void setDownload(int download) {
                this.download = download;
            }

            public int getMovie() {
                return movie;
            }

            public void setMovie(int movie) {
                this.movie = movie;
            }

            public int getPay() {
                return pay;
            }

            public void setPay(int pay) {
                this.pay = pay;
            }

            public int getHd5() {
                return hd5;
            }

            public void setHd5(int hd5) {
                this.hd5 = hd5;
            }

            public int getNoReprint() {
                return noReprint;
            }

            public void setNoReprint(int noReprint) {
                this.noReprint = noReprint;
            }

            public int getAutoplay() {
                return autoplay;
            }

            public void setAutoplay(int autoplay) {
                this.autoplay = autoplay;
            }

            public int getUgcPay() {
                return ugcPay;
            }

            public void setUgcPay(int ugcPay) {
                this.ugcPay = ugcPay;
            }

            public int getIsCooperation() {
                return isCooperation;
            }

            public void setIsCooperation(int isCooperation) {
                this.isCooperation = isCooperation;
            }

            public int getUgcPayPreview() {
                return ugcPayPreview;
            }

            public void setUgcPayPreview(int ugcPayPreview) {
                this.ugcPayPreview = ugcPayPreview;
            }
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class OwnerBean {
            /**
             * mid : 362268332
             * name : 真全栈程序员
             * face : http://i0.hdslb.com/bfs/face/d9d971f7ba4889d01851b1be1f63e45e182e4668.jpg
             */

            @JsonProperty("mid")
            private int mid;
            @JsonProperty("name")
            private String name;
            @JsonProperty("face")
            private String face;

            public int getMid() {
                return mid;
            }

            public void setMid(int mid) {
                this.mid = mid;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getFace() {
                return face;
            }

            public void setFace(String face) {
                this.face = face;
            }
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class StatBean {
            /**
             * aid : 74044043
             * view : 576
             * danmaku : 0
             * reply : 1
             * favorite : 75
             * coin : 4
             * share : 0
             * now_rank : 0
             * his_rank : 0
             * like : 40
             * dislike : 0
             * evaluation :
             */

            @JsonProperty("aid")
            private int aid;
            @JsonProperty("view")
            private int view;
            @JsonProperty("danmaku")
            private int danmaku;
            @JsonProperty("reply")
            private int reply;
            @JsonProperty("favorite")
            private int favorite;
            @JsonProperty("coin")
            private int coin;
            @JsonProperty("share")
            private int share;
            @JsonProperty("now_rank")
            private int nowRank;
            @JsonProperty("his_rank")
            private int hisRank;
            @JsonProperty("like")
            private int like;
            @JsonProperty("dislike")
            private int dislike;
            @JsonProperty("evaluation")
            private String evaluation;

            public int getAid() {
                return aid;
            }

            public void setAid(int aid) {
                this.aid = aid;
            }

            public int getView() {
                return view;
            }

            public void setView(int view) {
                this.view = view;
            }

            public int getDanmaku() {
                return danmaku;
            }

            public void setDanmaku(int danmaku) {
                this.danmaku = danmaku;
            }

            public int getReply() {
                return reply;
            }

            public void setReply(int reply) {
                this.reply = reply;
            }

            public int getFavorite() {
                return favorite;
            }

            public void setFavorite(int favorite) {
                this.favorite = favorite;
            }

            public int getCoin() {
                return coin;
            }

            public void setCoin(int coin) {
                this.coin = coin;
            }

            public int getShare() {
                return share;
            }

            public void setShare(int share) {
                this.share = share;
            }

            public int getNowRank() {
                return nowRank;
            }

            public void setNowRank(int nowRank) {
                this.nowRank = nowRank;
            }

            public int getHisRank() {
                return hisRank;
            }

            public void setHisRank(int hisRank) {
                this.hisRank = hisRank;
            }

            public int getLike() {
                return like;
            }

            public void setLike(int like) {
                this.like = like;
            }

            public int getDislike() {
                return dislike;
            }

            public void setDislike(int dislike) {
                this.dislike = dislike;
            }

            public String getEvaluation() {
                return evaluation;
            }

            public void setEvaluation(String evaluation) {
                this.evaluation = evaluation;
            }
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class DimensionBean {
            /**
             * width : 1360
             * height : 768
             * rotate : 0
             */

            @JsonProperty("width")
            private int width;
            @JsonProperty("height")
            private int height;
            @JsonProperty("rotate")
            private int rotate;

            public int getWidth() {
                return width;
            }

            public void setWidth(int width) {
                this.width = width;
            }

            public int getHeight() {
                return height;
            }

            public void setHeight(int height) {
                this.height = height;
            }

            public int getRotate() {
                return rotate;
            }

            public void setRotate(int rotate) {
                this.rotate = rotate;
            }
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class SubtitleBean {
            /**
             * allow_submit : false
             * list : []
             */

            @JsonProperty("allow_submit")
            private boolean allowSubmit;
            @JsonProperty("list")
            private List<?> list;

            public boolean isAllowSubmit() {
                return allowSubmit;
            }

            public void setAllowSubmit(boolean allowSubmit) {
                this.allowSubmit = allowSubmit;
            }

            public List<?> getList() {
                return list;
            }

            public void setList(List<?> list) {
                this.list = list;
            }
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class PagesBean {
            /**
             * cid : 126664942
             * page : 1
             * from : vupload
             * part : 1-今日内容和Hadoop的介绍
             * duration : 826
             * vid :
             * weblink :
             * dimension : {"width":1360,"height":768,"rotate":0}
             */

            @JsonProperty("cid")
            private int cid;
            @JsonProperty("page")
            private int page;
            @JsonProperty("from")
            private String from;
            @JsonProperty("part")
            private String part;
            @JsonProperty("duration")
            private int duration;
            @JsonProperty("vid")
            private String vid;
            @JsonProperty("weblink")
            private String weblink;
            @JsonProperty("dimension")
            private DimensionBeanX dimension;

            public int getCid() {
                return cid;
            }

            public void setCid(int cid) {
                this.cid = cid;
            }

            public int getPage() {
                return page;
            }

            public void setPage(int page) {
                this.page = page;
            }

            public String getFrom() {
                return from;
            }

            public void setFrom(String from) {
                this.from = from;
            }

            public String getPart() {
                return part;
            }

            public void setPart(String part) {
                this.part = part;
            }

            public int getDuration() {
                return duration;
            }

            public void setDuration(int duration) {
                this.duration = duration;
            }

            public String getVid() {
                return vid;
            }

            public void setVid(String vid) {
                this.vid = vid;
            }

            public String getWeblink() {
                return weblink;
            }

            public void setWeblink(String weblink) {
                this.weblink = weblink;
            }

            public DimensionBeanX getDimension() {
                return dimension;
            }

            public void setDimension(DimensionBeanX dimension) {
                this.dimension = dimension;
            }

            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class DimensionBeanX {
                /**
                 * width : 1360
                 * height : 768
                 * rotate : 0
                 */

                @JsonProperty("width")
                private int width;
                @JsonProperty("height")
                private int height;
                @JsonProperty("rotate")
                private int rotate;

                public int getWidth() {
                    return width;
                }

                public void setWidth(int width) {
                    this.width = width;
                }

                public int getHeight() {
                    return height;
                }

                public void setHeight(int height) {
                    this.height = height;
                }

                public int getRotate() {
                    return rotate;
                }

                public void setRotate(int rotate) {
                    this.rotate = rotate;
                }
            }
        }
    }
}
