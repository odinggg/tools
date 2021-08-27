package com.github.odinggg.tools;

import com.github.odinggg.tools.nio.ServerNormal;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootApplication
public class ToolsApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(ToolsApplication.class, args);
        ConfigurableEnvironment environment = run.getEnvironment();
        String address = environment.getProperty("tcp.server.address", "12345");
        ExecutorService threadPool = Executors.newFixedThreadPool(20);
        ServerNormal serverNormal = new ServerNormal();
        serverNormal.setThreadPool(threadPool);
        try {
            serverNormal.setPort(Integer.parseInt(address));
            threadPool.execute(serverNormal);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

