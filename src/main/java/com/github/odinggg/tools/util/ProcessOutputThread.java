package com.github.odinggg.tools.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 *
 */
class ProcessOutputThread extends Thread {
    private InputStream inputStream;
    private StringBuffer stringBuffer;
    private String charset;

    public ProcessOutputThread(InputStream inputStream, String charset) {
        if (null == inputStream) return;
        this.inputStream = inputStream;
        this.stringBuffer = new StringBuffer();
        this.charset = charset;
    }

    public StringBuffer getStringBuffer() {
        return stringBuffer;
    }

    @Override
    public void run() {
        if (this.inputStream == null) return;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;
        try {
            inputStreamReader = new InputStreamReader(this.inputStream, this.charset);
            bufferedReader = new BufferedReader(inputStreamReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                this.stringBuffer.append(line);
            }
        } catch (IOException e) {
        } finally {
            FileUtil.close(bufferedReader);
            FileUtil.close(inputStreamReader);
            FileUtil.close(this.inputStream);

        }
    }
}
