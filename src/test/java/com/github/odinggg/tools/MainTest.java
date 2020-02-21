package com.github.odinggg.tools;

import com.github.odinggg.tools.util.JacksonConvertUtil;

import java.util.ArrayList;

/**
 * 描述:
 *
 * @outhor Hansen
 * @create 2018-12-21 16:48
 */
public class MainTest {
    public static void main(String[] args) throws Exception {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("1");
        strings.add("2");
        strings.add("3");
        strings.add("4");
        strings.add("5");
        strings.add("6");
        ArrayList<String> list = new ArrayList<>();
        list.add("4");
        list.add("5");
        list.add("6");
        list.add("7");
        System.out.println(JacksonConvertUtil.objectToJson(strings));
        strings.removeAll(list);
        System.out.println(JacksonConvertUtil.objectToJson(strings));
    }
}
