package com.github.odinggg.tools.util;

import java.util.Random;
import java.util.UUID;

/**
 * 描述:
 *
 * @author Hansen
 * @create 2019-03-13 11:38
 */
public class RandomUtil {
    /**
     * 取UUID字符串
     *
     * @return UUID字符串
     */
    public static String getUUIDString() {
        String uuid = UUID.randomUUID().toString().replace("-", "").toUpperCase();
        return uuid;
    }


    /**
     * 获取num位的重复随机码 纯数字
     *
     * @param num
     * @return
     */
    public static String getRandomNum(int num) {
        Random random = new Random();
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < num; i++) {
            buf.append(random.nextInt(9));
        }
        return buf.toString();
    }

    private static String[] bytes = "Random$SaltValue#WithSpecialCharacters12@$@4&#%^$*".split("");

    private static Random random = new Random(47);

    /**
     * 随机获取盐
     *
     * @param length
     * @return
     */
    public static String getSalt(int length) {
        length = bytes.length <= length ? bytes.length : length;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(random.nextInt(length));
        }
        return sb.toString();
    }

    /**
     * 产生一个数字、字母的随机数
     *
     * @param length
     * 产生位数
     * @return 随机数
     */
    private static Random random2 = new Random();

    public static String generateStringRandom(int length) {
        StringBuilder val = new StringBuilder();
        // 参数length，表示生成几位随机数
        for (int i = 0; i < length; i++) {
            // 判断生成的数字或者字母作为一个标识
            String charOrNum = random2.nextInt(2) % 2 == 0 ? "char" : "num";
            // 输出字母还是数字
            if ("char".equalsIgnoreCase(charOrNum)) {
                // 输出是大写字母还是小写字母
                int temp = random2.nextInt(2) % 2 == 0 ? 65 : 97;
                val.append((char) (random.nextInt(26) + temp));
            } else if ("num".equalsIgnoreCase(charOrNum)) {
                val.append(random.nextInt(10));
            }
        }
        return val.toString();
    }
}
