package com.github.odinggg.tools.tasks;

import com.github.odinggg.tools.model.WeChatModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 描述:
 *
 * @author Hansen
 * @version 2020-02-25 16:37
 */
@Component("weChatMessageListenTask")
@Scope("prototype")
public class WeChatMessageListenTask implements Runnable {
    private final Logger logger = LoggerFactory.getLogger(WeChatMessageListenTask.class);

    private WeChatModel weChatModel;

    public WeChatModel getWeChatModel() {
        return weChatModel;
    }

    public WeChatMessageListenTask setWeChatModel(WeChatModel weChatModel) {
        this.weChatModel = weChatModel;
        return this;
    }

    @Override
    public void run() {
        try {
            while (true){

            }
        } catch (Throwable e) {
            logger.error("同步消息异常：", e);
        }
    }
}
