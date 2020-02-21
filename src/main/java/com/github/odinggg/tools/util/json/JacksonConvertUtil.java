package com.github.odinggg.tools.util.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * 描述:
 *
 * @outhor Hansen
 * @create 2018-08-29 15:46
 */
public final class JacksonConvertUtil {
    private static final Logger logger = LoggerFactory.getLogger(JacksonConvertUtil.class);
    public static final PropertyNamingStrategy.PropertyNamingStrategyBase UPPERCASE_NAMESTRATEGY = new UpperCaseNameStrategy();

    private JacksonConvertUtil() {
        throw new IllegalStateException();
    }

    public static String objectToJson(Object objectModel) throws JsonConvertException {
        return objectToJson(objectModel, null, null);
    }

    public static String objectToJson(Object objectModel, JsonInclude.Include include) throws JsonConvertException {
        return objectToJson(objectModel, include, null);
    }

    public static String objectToJson(Object objectModel, PropertyNamingStrategy.PropertyNamingStrategyBase nameStrategy) throws JsonConvertException {
        return objectToJson(objectModel, null, nameStrategy);
    }

    public static String objectToJson(Object objectModel, JsonInclude.Include include, PropertyNamingStrategy.PropertyNamingStrategyBase nameStrategy) throws JsonConvertException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setPropertyNamingStrategy(nameStrategy);
        mapper.setSerializationInclusion(include);
        try {
            return mapper.writeValueAsString(objectModel);
        } catch (JsonProcessingException var5) {
            logger.error("对象转字符串异常：" + var5.getMessage());
            throw new JsonConvertException(var5);
        }
    }

    public static <T> T jsonToObject(String jsonStringData, Class<T> targetClass) throws JsonConvertException {
        return jsonToObject(jsonStringData, targetClass, null);
    }

    public static <T> T jsonToObject(String jsonStringData, Class<T> targetClass, PropertyNamingStrategy.PropertyNamingStrategyBase nameStrategy) throws JsonConvertException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setPropertyNamingStrategy(nameStrategy);
        mapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);

        try {
            return mapper.readValue(jsonStringData, targetClass);
        } catch (IOException var6) {
            logger.error(var6.getMessage());
            StringBuilder builder = new StringBuilder();
            builder.append("字符串：" + jsonStringData);
            builder.append("转换为：" + targetClass.getName() + "类异常");
            logger.error(builder.toString());
            throw new JsonConvertException(var6);
        }
    }

    public static JavaType getCollectionType(Class<?> parametrized, Class... elementClasses) {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.getTypeFactory().constructParametricType(parametrized, elementClasses);
    }

    public static <T> T jsonToObject(String jsonStringData, JavaType collectionType) throws JsonConvertException {
        ObjectMapper mapper = new ObjectMapper();

        try {
            return mapper.readValue(jsonStringData, collectionType);
        } catch (IOException var5) {
            logger.error(var5.getMessage());
            StringBuilder builder = new StringBuilder();
            builder.append("字符串：" + jsonStringData);
            builder.append("转换为" + collectionType.getTypeName() + "类异常");
            logger.error(builder.toString());
            throw new JsonConvertException(var5);
        }
    }

    public static <T> T jsonToObject(String jsonStringData, TypeReference<T> collectionType) throws JsonConvertException {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(jsonStringData, collectionType);
        } catch (IOException var5) {
            logger.error(var5.getMessage());
            StringBuilder builder = new StringBuilder();
            builder.append("字符串：" + jsonStringData);
            builder.append("转换为" + collectionType.getType().getTypeName() + "类异常");
            logger.error(builder.toString());
            throw new JsonConvertException(var5);
        }
    }
}
