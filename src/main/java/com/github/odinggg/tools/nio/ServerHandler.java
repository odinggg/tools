package com.github.odinggg.tools.nio;


import com.github.odinggg.tools.util.ByteUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * 描述:
 *
 * @outhor Hansen
 * @create 2018-10-25 10:58
 */
public class ServerHandler implements Runnable {

    protected final Logger logger = LoggerFactory.getLogger(ServerHandler.class);
    public static final ConcurrentLinkedDeque<String> DATA_PACKETS = new ConcurrentLinkedDeque<>();
    private Socket socket;
    private byte[] bytes;

    public byte[] getBytes() {
        return bytes;
    }

    private String jsonData;

    public String getJsonData() {
        return jsonData;
    }

    public void setJsonData(String jsonData) {
        this.jsonData = jsonData;
    }

    public ServerHandler(Socket socket) {
        this.socket = socket;
    }


    private int getSize(InputStream in) throws IOException {
        byte[] length = new byte[4];
        in.read(length);
        return ByteUtil.bytes2int(length);
    }

    private boolean send = false;

    public boolean isSend() {
        return send;
    }

    public void setSend(boolean send) {
        this.send = send;
    }

    private boolean receiveData = false;

    public boolean isReceiveData() {
        return receiveData;
    }

    public void setReceiveData(boolean receiveData) {
        this.receiveData = receiveData;
    }

    private final DataOutputStream dos = null;

    public void run() {

        InputStream in = null;
        OutputStream out = null;
        BufferedOutputStream bo = null;
        try {
            in = socket.getInputStream();
            out = socket.getOutputStream();
            while (true) {
                String first = DATA_PACKETS.pollFirst();
                if (!StringUtils.isEmpty(first)) {
                    byte[] text = ByteUtil.string2Byte(first);
                    ArrayList<Byte> bytes = new ArrayList<>();
                    bytes.add((byte) 0x00);
                    byte[] length = ByteUtil.int2bytes(text.length);
                    for (byte b : length) {
                        bytes.add(b);
                    }
                    bytes.add((byte) 0x02);
                    for (byte b : text) {
                        bytes.add(b);
                    }
                    bytes.add((byte) 0x0A);
                    Byte[] bytes1 = bytes.toArray(new Byte[0]);
                    byte[] data = new byte[bytes.size()];
                    for (int i = 0; i < bytes1.length; i++) {
                        data[i] = bytes1[i];
                    }
                    out.write(data);
                    out.flush();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //一些必要的清理工作
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                socket = null;
            }
        }
    }
}
