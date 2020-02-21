package com.github.odinggg.tools.util;

import org.springframework.cglib.beans.BeanCopier;

import java.util.HashMap;
import java.util.Map;

/**
 * 描述:
 * bean拷贝工具类
 *
 * @outhor Hansen
 * @create 2018-07-19 14:53
 */
public final class BeanCopierUtil {
    private static final Map<String, BeanCopier> BEAN_COPIERS = new HashMap();

    private BeanCopierUtil() {
        throw new IllegalStateException();
    }

    public static void copy(Object srcObj, Object targetObj) {
        String key = genKey(srcObj.getClass(), targetObj.getClass());
        BeanCopier copier = null;
        if (!BEAN_COPIERS.containsKey(key)) {
            copier = BeanCopier.create(srcObj.getClass(), targetObj.getClass(), false);
            BEAN_COPIERS.put(key, copier);
        } else {
            copier = BEAN_COPIERS.get(key);
        }

        copier.copy(srcObj, targetObj, null);
    }

    private static String genKey(Class<?> srcClazz, Class<?> targetObj) {
        return srcClazz.getName() + targetObj.getName();
    }
}
