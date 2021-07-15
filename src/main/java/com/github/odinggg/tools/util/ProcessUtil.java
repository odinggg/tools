package com.github.odinggg.tools.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 */
public class ProcessUtil {

    private static final Logger logger = LoggerFactory.getLogger(ProcessUtil.class);

    public static int Run(List<String> cmd, StringBuffer buffer, Integer timeout, String charset) {
        ProcessBuilder processBuilder = new ProcessBuilder(cmd);
        Process process;
        try {
            long startTime = System.currentTimeMillis();
            process = processBuilder.start();
            int k = -1;
            ProcessOutputThread outputThread = new ProcessOutputThread(process.getInputStream(), charset);
            ProcessOutputThread errorThread = new ProcessOutputThread(process.getErrorStream(), charset);
            outputThread.start();
            errorThread.start();
            while (timeout > 0 && System.currentTimeMillis() - startTime <= timeout) {
                try {
                    k = process.exitValue();
                    break;
                } catch (IllegalThreadStateException ignored) {
                }
            }
            try {
                if (k == -1) {
                    outputThread.interrupt();
                    errorThread.interrupt();
                    Thread.sleep(500);
                } else {
                    outputThread.join();
                    errorThread.join();
                }
                if (outputThread.getStringBuffer() != null) {
                    buffer.append(outputThread.getStringBuffer());
                }
                if (errorThread.getStringBuffer() != null) {
                    buffer.append(errorThread.getStringBuffer());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return k;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static int Run(String cmd, StringBuffer buffer) {
        List<String> collect = Arrays.stream(cmd.split(" ")).collect(Collectors.toList());
        return Run(collect, buffer, 1200000, StandardCharsets.UTF_8.displayName());
    }
}
