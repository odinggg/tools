package com.github.odinggg.tools.util;


import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Base64;
import java.util.List;

/**
 * Created by Zhutaoshen on 2018-4-22.
 */
public class ByteUtil {

    /**
     * @Description: byte 与 int 的相互转换
     * @param: [v]
     * @return: byte
     * @author: Zhutaoshen
     * @Date: 2018-4-22
     */
    public static byte int2byte(int v) {
        return (byte) v;
    }

    /**
     * @Description: Java 总是把 byte 当做有符处理；我们可以通过将其和 0xFF 进行二进制与得到它的无符值
     * @param: [v]
     * @return: int
     * @author: Zhutaoshen
     * @Date: 2018-4-22
     */
    public static int byte2int(byte v) {
        return v & 0xFF;
    }

    /**
     * @Description: byte 数组与 int 的相互转换
     * @param: [v]
     * @return: int
     * @author: Zhutaoshen
     * @Date: 2018-4-22
     */
    public static int bytes2int(byte[] v) {
        return v[3] & 0xFF | (v[2] & 0xFF) << 8 | (v[1] & 0xFF) << 16 | (v[0] & 0xFF) << 24;
    }

    public static int bytes2int(byte[] v, int offset) {
        return v[offset + 3] & 0xFF | (v[offset + 2] & 0xFF) << 8 | (v[offset + 1] & 0xFF) << 16 | (v[offset + 0] & 0xFF) << 24;
    }

    public static short byte2short(byte[] v, int offset) {
        return (short) (v[offset + 1] & 0xFF | (v[offset + 0] & 0xFF) << 8);
    }

    /**
     * @Description: byte 数组与 int 的相互转换
     * @param: [v]
     * @return: byte[]
     * @author: Zhutaoshen
     * @Date: 2018-4-22
     */
    public static byte[] int2bytes(int v) {
        return new byte[]{(byte) ((v >> 24) & 0xFF), (byte) ((v >> 16) & 0xFF), (byte) ((v >> 8) & 0xFF), (byte) (v & 0xFF)};
    }

    public static byte[] short2bytes(short v) {
        return new byte[]{(byte) ((v >> 8) & 0xFF), (byte) (v & 0xFF)};
    }

    public static int short2int(short v) {
        return (v & 0xFFFF);
    }

    public static short int2short(int v) {
        return (short) v;
    }

    /**
     * @Description: byte 数组与 long 的相互转换
     * @param: [v]
     * @return: long
     * @author: Zhutaoshen
     * @Date: 2018-4-22
     */
    public static long byte2long(byte[] v, int offset) {
        ByteBuffer buffer = ByteBuffer.allocate(8);
        buffer.put(v, offset, 8);
        buffer.flip();
        return buffer.getLong();
    }

    /**
     * @Description: byte 数组与 long 的相互转换
     * @param: [v]
     * @return: byte[]
     * @author: Zhutaoshen
     * @Date: 2018-4-22
     */
    public static byte[] long2byte(long v) {
        ByteBuffer buffer = ByteBuffer.allocate(8);
        buffer.putLong(v);
        buffer.flip();
        return buffer.array();
    }

    public static String byte2String(byte[] v) {
        return byte2String(v, 0, v.length);
    }

    public static String byte2String(byte[] v, int offset, int limit) {
        byte[] val = new byte[Math.min(v.length - offset, limit)];
        System.arraycopy(v, offset, val, 0, val.length);
        try {
            return new String(val, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return new String(val);
        }
    }

    public static byte[] string2Byte(String data) {
        if (data == null) {
            return new byte[]{};
        }
        try {
            return data.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            return data.getBytes();
        }
    }

    public static ByteBuffer string2ByteBuffer(String v) {
        byte b[] = string2Byte(v);
        ByteBuffer buffer = ByteBuffer.allocate(b.length);
        buffer.put(b, 0, b.length);
        buffer.flip();
        return buffer;
    }

    public static ByteBuffer byte2Buffer(byte[] v) {
        ByteBuffer buffer = ByteBuffer.allocate(v.length);
        buffer.put(v, 0, v.length);
        buffer.flip();
        return buffer;
    }

    public static byte[] buffer2Bytes(ByteBuffer buffer, int offset, int length) {
        byte[] bytes = new byte[Math.min(buffer.limit() - offset, length)];
        for (int i = 0; i < bytes.length; i++) {
            byte b = buffer.get(i + offset);
            bytes[i] = b;
        }
        return bytes;
    }

    public static String buffer2String(ByteBuffer buffer, int offset, int length) {
        return byte2String(buffer2Bytes(buffer, offset, length));
    }

    public static boolean bitContain(byte a, byte b) {
        String sa = Integer.toBinaryString(byte2int(a) + 0x100).substring(1);
        String sb = Integer.toBinaryString(byte2int(b) + 0x100).substring(1);
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '1') {
                if (sa.charAt(i) != '1') {
                    return false;
                }
            }
        }
        return true;
    }

    public static byte bitCopy(byte v, int pos, int len) {
        String a = Integer.toBinaryString(byte2int(v) + 0x100).substring(1);
        return int2byte(Integer.valueOf(a.substring(a.length() - pos - 1, a.length() - pos - 1 + len), 2));
    }

    public static byte[] list2byte(List<Byte> byteList) {
        if (byteList == null || byteList.size() <= 0) {
            return new byte[0];
        }
        byte[] result = new byte[byteList.size()];
        for (int i = 0; i < byteList.size(); i++) {
            result[i] = byteList.get(i);
        }
        return result;
    }

    public static String convertByteToBase64(byte[] data) {

        try {
            return new String(Base64.getEncoder().encode(data));
        } catch (Exception e) {
            return null;
        }
    }

    public static byte[] convertBase64ToByte(String base64String) {
        try {
            return Base64.getDecoder().decode(base64String);
        } catch (Exception e) {
            return null;
        }
    }

    public static byte shiftLeft(byte v, byte num) {
        return int2bytes(v << num)[3];
    }

    public static byte shiftRight(byte v, byte num) {
        return int2bytes(v >>> num)[3];
    }

    public static byte shiftLeft(short v, byte num) {
        return int2bytes(v << num)[3];
    }

    public static byte shiftRight(short v, byte num) {
        return int2bytes(v >>> num)[3];
    }

    public static String byte2Binstring(byte v) {
        return Integer.toBinaryString(byte2int(v) + 0x100).substring(1);
    }

    public static byte[] binString2byte(String binString, boolean fillOnAfter) {
        StringBuilder stringBuilder = new StringBuilder(binString);
        int remainder = stringBuilder.length() % 8;
        if (remainder > 0) {
            for (int i = 0; i < 8 - remainder; i++) {
                if (fillOnAfter) {
                    stringBuilder.append("0");
                } else {
                    stringBuilder.insert(0, "0");
                }
            }
        }
        byte[] bytes = new byte[stringBuilder.length() / 8];
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) Integer.parseInt(stringBuilder.substring(i * 8, i * 8 + 8), 2);
        }
        return bytes;
    }

    public static byte[] copy(byte[] src, int offset, int length) {
        if (src.length <= offset || offset < 0) {
            return new byte[]{};
        }
        if (length <= 0) {
            length = src.length - offset;
        }
        byte[] dest = new byte[length];
        System.arraycopy(src, offset, dest, 0, length);
        return dest;
    }
}
