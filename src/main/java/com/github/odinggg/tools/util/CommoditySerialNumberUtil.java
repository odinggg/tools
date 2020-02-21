package com.github.odinggg.tools.util;

import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 描述:
 * 序列号生成工具类
 *
 * @author Hansen
 * @create 2019-03-01 17:28
 */
@Component
public class CommoditySerialNumberUtil {

    public static String getSerialNumber(String number, int fill) {
        if (number != null) {
            Map map = JacksonConvertUtil.jsonToObject(number, Map.class);
            if (map != null && map.containsKey("data")) {
                Map dataMap = (Map) map.get("data");
                if (dataMap != null && dataMap.containsKey("sn")) {
                    String sn = (String) dataMap.get("sn");
                    if (sn != null && sn.length() > fill) {
                        return sn;
                    }
                }
            }
        }
        return null;
    }
}
