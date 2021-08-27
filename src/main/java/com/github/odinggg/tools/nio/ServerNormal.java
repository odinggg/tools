package com.github.odinggg.tools.nio;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 描述:
 * BIO
 *
 * @outhor Hansen
 * @create 2018-10-25 10:57
 */
public final class ServerNormal implements Runnable {
    private static final Logger logger = LoggerFactory.getLogger(ServerNormal.class);

    //单例的ServerSocket
    private static ServerSocket server;

    private List<ServerHandler> serverHandlers;

    private ExecutorService threadPool;

    public ExecutorService getThreadPool() {
        return threadPool;
    }

    public void setThreadPool(ExecutorService threadPool) {
        this.threadPool = threadPool;
    }

    public static final AtomicInteger count = new AtomicInteger(1);
    private int port = 0;

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    //根据传入参数设置监听端口，如果没有参数调用以下方法并使用默认值
    public void start() throws IOException {
        //使用默认值
        //默认的端口号
        int DEFAULT_PORT = 12345;
        start(DEFAULT_PORT);
    }


    //这个方法不会被大量并发访问，不太需要考虑效率，直接进行方法同步就行了
    public synchronized void start(int port) throws IOException {
        if (server != null) return;
        serverHandlers = new ArrayList<>();
        try {
            //通过构造函数创建ServerSocket
            //如果端口合法且空闲，服务端就监听成功
            server = new ServerSocket(port);
            logger.info("服务器已启动，端口号：" + port);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //通过无线循环监听客户端连接
            //如果没有客户端接入，将阻塞在accept操作上。
            while (true) {
                Socket socket = server.accept();
                //当有新的客户端接入时，会执行下面的代码
                //然后创建一个新的线程处理这条Socket链路
                logger.info("第" + count.getAndAdd(1) + "个tcp连接成功：" + socket.getInetAddress()
                        .getHostAddress() + "，主机名：" + socket.getInetAddress().getHostName());
                ServerHandler serverHandler = new ServerHandler(socket);
                serverHandlers.add(serverHandler);
                threadPool.execute(serverHandler);
            }
        } finally {
            //一些必要的清理工作
            if (server != null) {
                System.out.println("服务器已关闭。");
                server.close();
                server = null;
            }
        }
    }

    public void run() {
        try {
            if (port == 0) {
                start();
            } else {
                start(port);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
