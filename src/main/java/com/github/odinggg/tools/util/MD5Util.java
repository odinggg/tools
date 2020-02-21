package com.github.odinggg.tools.util;

import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;

/**
 * 描述:
 *
 * @author Hansen
 * @create 2019-03-13 11:29
 */
public class MD5Util {
    public static boolean verify(String text, String salt, String md5) {
        String md5Text = md5(text, salt);
        return md5Text.equalsIgnoreCase(md5);
    }

    public static String md5(String text, String salt) {
        String s = DigestUtils.md5DigestAsHex((text + salt).getBytes(StandardCharsets.UTF_8));
        return s;
    }

    public static String md5(String text) {
        String s = DigestUtils.md5DigestAsHex(text.getBytes(StandardCharsets.UTF_8));
        return s;
    }

    public static void main(String[] args) {
        String s = md5("123456", "9999");
        System.out.println(s);
        boolean verify = verify("123456", "9999", s);

        System.out.println(verify);
    }
}
