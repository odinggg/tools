package com.github.odinggg.tools.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.github.odinggg.tools.util.json.JsonConvertException;
import com.github.odinggg.tools.util.json.UpperCaseNameStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public static String objectToXml(Object objectModel) throws JsonConvertException {
        return objectToXml(objectModel, null, null);
    }

    public static String objectToXml(Object objectModel, JsonInclude.Include include, PropertyNamingStrategy.PropertyNamingStrategyBase nameStrategy) throws JsonConvertException {
        XmlMapper mapper = getXmlMapper(nameStrategy);
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

    public static <T> T xmlToObject(String xmlStringData, Class<T> targetClass) throws JsonConvertException {
        return xmlToObject(xmlStringData, targetClass, null);
    }

    public static Map jsonToObject(String jsonStringData) throws JsonConvertException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        jsonStringData = jsonStringData.replaceAll("\\s*|\t|\r|\n", "");
        if (jsonStringData.startsWith("{[")) {
            jsonStringData = jsonStringData.substring(1, jsonStringData.length() - 1);
        }
        JsonNode jsonNode = objectMapper.readTree(jsonStringData);
        Map map = new HashMap<>();
        if (jsonNode.isArray()) {
            List list = JacksonConvertUtil.jsonToObject(jsonStringData, List.class);
            if (list != null && !list.isEmpty())
                map = (Map) list.get(0);
        } else if (jsonNode.isObject()) {
            map = JacksonConvertUtil.jsonToObject(jsonStringData, Map.class);
        }
        return map;
    }

    public static <T> T jsonToObject(String jsonStringData, Class<T> targetClass, PropertyNamingStrategy.PropertyNamingStrategyBase nameStrategy) throws JsonConvertException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setPropertyNamingStrategy(nameStrategy);
        mapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        mapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
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

    public static XmlMapper getXmlMapper(PropertyNamingStrategy.PropertyNamingStrategyBase nameStrategy) {
        XmlMapper mapper = new XmlMapper();
        if (nameStrategy != null) {
            mapper.setPropertyNamingStrategy(nameStrategy);
        }
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        mapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        return mapper;
    }

    public static <T> T xmlToObject(String xmlStringData, Class<T> targetClass, PropertyNamingStrategy.PropertyNamingStrategyBase nameStrategy) throws JsonConvertException {
        XmlMapper mapper = getXmlMapper(nameStrategy);
        try {
            return mapper.readValue(xmlStringData, targetClass);
        } catch (IOException var6) {
            logger.error(var6.getMessage());
            StringBuilder builder = new StringBuilder();
            builder.append("字符串：" + xmlStringData);
            builder.append("转换为：" + targetClass.getName() + "类异常");
            logger.error(builder.toString());
            throw new JsonConvertException(var6);
        }
    }

    public static <T> T xmlToObject(String jsonStringData, TypeReference<T> collectionType) throws JsonConvertException {
        XmlMapper mapper = getXmlMapper(null);
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

    public static <T> T jsonToObject(String jsonStringData, TypeReference<T> collectionType) throws JsonConvertException {
        ObjectMapper mapper = getObjectMapper();
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

    /**
     * ObjectMapper是JSON操作的核心，Jackson的所有JSON操作都是在ObjectMapper中实现。
     * ObjectMapper有多个JSON序列化的方法，可以把JSON字符串保存File、OutputStream等不同的介质中。
     * writeValue(File arg0, Object arg1)把arg1转成json序列，并保存到arg0文件中。
     * writeValue(OutputStream arg0, Object arg1)把arg1转成json序列，并保存到arg0输出流中。
     * writeValueAsBytes(Object arg0)把arg0转成json序列，并把结果输出成字节数组。
     * writeValueAsString(Object arg0)把arg0转成json序列，并把结果输出成字符串。
     */

    public static ObjectMapper objectMapper = null;

    public static ObjectMapper getObjectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        // 解决实体未包含字段反序列化时抛出异常
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        // 对于空的对象转json的时候不抛出错误
        mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        // 允许属性名称没有引号
        mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        // 允许单引号
        mapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        //配置为true表示mapper接受只有一个元素的数组的反序列化
//        mapper.getDeserializationConfig().with(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
//        mapper.getDeserializationConfig().without(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        // 日期格式设置
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        return mapper;
    }

    public static ObjectMapper getSingleObjectMapper() {
        if (objectMapper == null) {
            objectMapper = new ObjectMapper();
            objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        }
        return objectMapper;
    }

    /**
     * 将一个object转换为json, 可以使一个java对象，也可以是集合
     *
     * @Description: objectToJson
     * @param: [mapper, obj]
     * @return: java.lang.String
     * @author: zhutaoshen
     * @Date: 2019/4/18
     */
    public static String toJsonString(Object obj, boolean ignoreNull, String... properties) {
        try {
            ObjectMapper objectMapper = getObjectMapper();
            if (ignoreNull) {
                objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            }
            if (properties != null) {
                objectMapper.setFilterProvider(new SimpleFilterProvider().addFilter("except", SimpleBeanPropertyFilter.serializeAllExcept(properties)));
            }
            return objectMapper.writeValueAsString(obj);
        } catch (Exception e) {
            logger.error("", e);
            return "{}";
        }
    }

    /**
     * @Description: 将json结果集转化为对象
     * @param: [json, beanType]
     * @return: T
     * @author: zhutaoshen
     * @Date: 2019/4/18
     */
    public static <T> T jsonToClass(String json, Class<T> beanType) {
        try {
            return getObjectMapper().readValue(json, beanType);
        } catch (Exception e) {
            logger.error("", e);
            return null;
        }
    }

    /**
     * @Description: 将json数据转换成Map
     * @param: [json]
     * @return: Map<String, Object>
     * @author: zhutaoshen
     * @Date: 2019/4/18
     */
    public static Map<String, Object> jsonToMap(String json) {
        Map<String, Object> map = null;
        try {
            return getObjectMapper().readValue(json, new TypeReference<Map<String, Object>>() {
            });
        } catch (Exception e) {
            logger.error("", e);
            return null;
        }
    }

    /**
     * @Description: 将json数据转换成list
     * @param: [json, beanType]
     * @return: java.util.List<T>
     * @author: zhutaoshen
     * @Date: 2019/4/18
     */
    public static <T> List<T> jsonToList(String json, Class<T> beanType) {
        try {
            ObjectMapper mapper = getObjectMapper();
/*            JavaType javaType = mapper.getTypeFactory().constructParametricType(List.class, beanType);
            return mapper.readValue(json, javaType);
            JavaType javaType = getCollectionType(ArrayList.class, clazz);
        List<T> lst = (List<T>) objectMapper.readValue(jsonArrayStr, javaType);*/
            return mapper.readValue(json, mapper.getTypeFactory().constructCollectionType(List.class, beanType));
        } catch (Exception e) {
            logger.error("", e);
            return null;
        }
    }

    /**
     * @Description: 获取json对象数据的属性
     * @param: [resData, resPro]
     * @return: java.lang.String
     * @author: zhutaoshen
     * @Date: 2019/4/18
     */
    public static String findValue(String resData, String resPro) {
        try {
            JsonNode node = getObjectMapper().readTree(resData);
            JsonNode resProNode = node.get(resPro);
            return resProNode.textValue();
        } catch (Exception e) {
            logger.error("", e);
            return null;
        }
    }

    /**
     * @Description:
     * @param: [json, type]
     * @return: T
     * @author: zhutaoshen
     * @Date: 2019/4/18
     */
    public static <T> T nativeRead(String json, TypeReference<T> type) {
        try {
            return getObjectMapper().readValue(json, type);
        } catch (IOException e) {
            logger.error("json解析出错：" + json, e);
            return null;
        }
    }

    /**
     * @Description: 把json解析成list，如果list内部的元素存在jsonString，继续解析
     * @param: [json, mapper]
     * @return: java.util.List<java.lang.Object>
     * @author: zhutaoshen
     * @Date: 2019/4/18
     */
    private static List<Object> json2ListRecursion(String json, ObjectMapper mapper) {
        if (json == null) {
            return null;
        }
        List<Object> list = null;
        try {
            list = mapper.readValue(json, List.class);
        } catch (IOException e) {
            return null;
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != null && list.get(i) instanceof String) {
                String str = (String) list.get(i);
                Object obj = null;
                if (str.startsWith("[")) {
                    obj = json2ListRecursion(str, mapper);
                } else if (obj.toString().startsWith("{")) {
                    obj = json2MapRecursion(str, mapper);
                }
                if (obj != null) {
                    list.set(i, obj);
                }
            }
        }
        return list;
    }

    /**
     * @Description: 把json解析成map，如果map内部的value存在jsonString，继续解析
     * @param: [json, mapper]
     * @return: java.util.Map<java.lang.String, java.lang.Object>
     * @author: zhutaoshen
     * @Date: 2019/4/18
     */
    private static Map<String, Object> json2MapRecursion(String json, ObjectMapper mapper) {
        if (json == null) {
            return null;
        }
        Map<String, Object> map = null;
        try {
            map = mapper.readValue(json, Map.class);
        } catch (IOException e) {
            return null;
        }
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            Object obj = entry.getValue();
            if (obj != null && obj instanceof String) {
                String str = ((String) obj);
                if (str.startsWith("[")) {
                    List<?> list = json2ListRecursion(str, mapper);
                    map.put(entry.getKey(), list);
                } else if (str.startsWith("{")) {
                    Map<String, Object> mapRecursion = json2MapRecursion(str, mapper);
                    map.put(entry.getKey(), mapRecursion);
                }
            }
        }
        return map;
    }

    /**
     * @Description: 深度转换json成map
     * @param: [json]
     * @return: java.util.Map<java.lang.String, java.lang.Object>
     * @author: zhutaoshen
     * @Date: 2019/4/18
     */
    public static Map<String, Object> json2mapDeeply(String json) {
        return json2MapRecursion(json, getObjectMapper());
    }

    public static String toJsonString(Object object, String... properties) {
        return toJsonString(object, true, properties);
    }

    public static byte[] toJsonByte(Object object, String... properties) {
        String data = toJsonString(object, properties);
        if (data == null) {
            return new byte[]{};
        }
        return data.getBytes(StandardCharsets.UTF_8);
    }

    public static JsonNode getJSON(String string) {
        if (string != null && string.length() > 2) {
            try {
                return getObjectMapper().readTree(string);
            } catch (Exception e) {
                logger.error("", e);
                return null;
            }
        } else {
            return null;
        }
    }

    public static String getJSONValue(JsonNode obj, String path, String defaultValue) {
        if (obj == null) return defaultValue;
        JsonNode node = obj.findPath(path);
        if (node != null) {
            return node.asText();
        } else {
            return defaultValue;
        }
    }

    public static int getJSONValue(JsonNode obj, String path, int defaultValue) {
        if (obj == null) return defaultValue;
        JsonNode node = obj.findPath(path);
        if (node != null) {
            return node.asInt();
        } else {
            return defaultValue;
        }
    }

    public static long getJSONValue(JsonNode obj, String path, long defaultValue) {
        if (obj == null) return defaultValue;
        JsonNode node = obj.findPath(path);
        if (node != null) {
            return node.asLong();
        } else {
            return defaultValue;
        }
    }

    public static double getJSONValue(JsonNode obj, String path, double defaultValue) {
        if (obj == null) return defaultValue;
        JsonNode node = obj.findPath(path);
        if (node != null) {
            return node.asDouble();
        } else {
            return defaultValue;
        }
    }

    public static String getJSONString(JsonNode obj, String path) {
        return getJSONValue(obj, path, null);
    }

    public static int getJSONInt(JsonNode obj, String path) {
        return getJSONValue(obj, path, 0);
    }

    public static long getJSONLong(JsonNode obj, String path) {
        return getJSONValue(obj, path, 0L);
    }

    public static double getJSONDouble(JsonNode obj, String path) {
        return getJSONValue(obj, path, 0.0D);
    }

    public static Object getJSONObject(JsonNode obj, String path) {
        if (obj == null) return null;
        try {
            return obj.findPath(path);
        } catch (Exception e) {
            logger.error("", e);
            return null;
        }
    }

    public static JsonNode toJsonNode(Object object) {
        if (object == null) return null;
        try {
            return getSingleObjectMapper().valueToTree(object);
        } catch (Exception e) {
            logger.error("", e);
            return null;
        }
    }
}
