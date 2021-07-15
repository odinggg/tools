package com.github.odinggg.tools.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.SimpleDateFormat;
import java.util.List;

public class CsvUtil {
    private static final Logger logger = LogManager.getLogger(CsvUtil.class);

    private static final CsvMapper csvMapper = new CsvMapper();

    private CsvUtil() {

    }

    /**
     * 输出全部属性
     * 如果csv中存在，对象中没有，则自动忽略该属性
     * 失败返回null
     *
     * @param csvContent
     * @param clazz
     * @return
     */
    public static <T> List<T> toNormalObject(String csvContent, Class<T> clazz) {
        try {
            CsvSchema schema = CsvSchema.emptySchema();
            MappingIterator<T> mappingIterator = csvMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
                    .readerFor(clazz)
                    .with(schema)
                    .readValues(csvContent);
            return mappingIterator.readAll();
        } catch (Exception e) {
            logger.info("CsvToObject failed:", e);
        }
        return null;
    }

    /**
     * 输出全部属性
     * 如果csv中存在，对象中没有，则自动忽略该属性
     * 失败返回null
     *
     * @param bytes
     * @param clazz
     * @return
     */
    public synchronized static <T> List<T> toNormalObject(byte[] bytes, Class<T> clazz) {
        try {
            CsvSchema schema = CsvSchema.emptySchema().withHeader();
            MappingIterator<T> mappingIterator = csvMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
                    .readerFor(clazz)
                    .with(schema)
                    .readValues(bytes);
            return mappingIterator.readAll();
        } catch (Exception e) {
            logger.info("CsvToObject failed:", e);
        }
        return null;
    }

    /**
     * 输出全部属性 失败返回""
     *
     * @param object
     * @return
     */
    public static String toNormalCsv(Object object) {
        return objectToCsv(object);
    }

    private static <T> String objectToCsv(T object) {
        try {
            CsvSchema csvSchema = csvMapper.schemaFor(object.getClass());
            csvMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
            return csvMapper.setSerializationInclusion(JsonInclude.Include.ALWAYS)
                    .writer(csvSchema)
                    .writeValueAsString(object);
        } catch (JsonProcessingException e) {
            logger.info("ObjToCsv failed:", e);
        }
        return "";
    }


}
