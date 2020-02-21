package com.github.odinggg.tools.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class BaseController {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    protected String readRequest(HttpServletRequest request) {
        String str;
        String readerStr = "";

        try {
            InputStreamReader in = new InputStreamReader(request.getInputStream(), StandardCharsets.UTF_8);

            BufferedReader reader;
            for (reader = new BufferedReader(in); (str = reader.readLine()) != null; readerStr = readerStr + str) {
            }

            reader.close();
            in.close();
            this.logger.info("read request:{}", readerStr);
        } catch (Exception var6) {
            this.logger.error("", var6);
        }

        return readerStr;
    }
}
