package com.github.odinggg.tools.service.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLParser;
import com.github.odinggg.tools.model.Text;
import com.github.odinggg.tools.model.TextNode;
import com.github.odinggg.tools.service.ToolService;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 描述:
 *
 * @author Hansen
 * @version 2019-12-27 16:42
 */
@Service
public class ToolServiceImpl implements ToolService {

    private final static List<JsonNodeType> JSON_NODE_TYPES = Stream.of(JsonNodeType.OBJECT, JsonNodeType.ARRAY, JsonNodeType.POJO)
            .collect(Collectors.toList());

    @Override
    public Text yml2properties(String content) throws Exception {
        YAMLFactory build = YAMLFactory.builder().build();
        YAMLParser parser = build.createParser(content);
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode o = objectMapper.readTree(parser);
        Properties properties = new Properties();
        ArrayList<Map<String, String>> temp = new ArrayList<>();
        Map<String, String> collect = Stream.of(o.fields()).flatMap(entryIterator -> {
            while (entryIterator.hasNext()) {
                Map.Entry<String, JsonNode> next = entryIterator.next();
                Map<String, String> stringStringMap = flatMap(next.getValue(), null, next.getKey());
                temp.add(stringStringMap);
            }
            return temp.stream().flatMap(map -> map.entrySet().stream());
        }).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        collect.forEach(properties::setProperty);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        properties.store(outputStream, "properties");
        outputStream.close();
        Text text = new Text();
        text.setContent(outputStream.toString("utf-8"));
        return text;
    }

    public Map<String, String> flatMap(JsonNode jsonNode, Map<String, String> map, String prefix) {
        if (map == null) {
            map = new HashMap<>();
        }
        if (jsonNode != null) {
            Iterator<Map.Entry<String, JsonNode>> fields = jsonNode.fields();
            while (fields.hasNext()) {
                Map.Entry<String, JsonNode> next = fields.next();
                String thisPrefix = prefix + "." + next.getKey();
                JsonNodeType nodeType = next.getValue().getNodeType();
                if (JSON_NODE_TYPES.contains(nodeType)) {
                    map = flatMap(next.getValue(), map, thisPrefix);
                } else {
                    map.put(thisPrefix, next.getValue().asText());
                }
            }
        }
        return map;
    }

    @Override
    public Text properties2yml(String content) throws Exception {
        Properties properties = new Properties();
        properties.load(new FileInputStream(new File("D:\\tmp\\test\\a.properties")));
        HashMap<String, String> map = new HashMap<>();
        properties.forEach((key, value) -> map.put(String.valueOf(key), String.valueOf(value)));
        ObjectMapper objectMapper = new ObjectMapper(YAMLFactory.builder().build());
        String s = objectMapper.writeValueAsString(map);
        System.out.println(s);
        return null;
    }

    private static final Map<String, TextNode> TEXT_NODES = new HashMap<>();

    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();
        properties.load(new FileInputStream(new File("D:\\tmp\\test\\a.properties")));
        HashMap<String, String> map = new HashMap<>();
        properties.forEach((key, value) -> map.put(String.valueOf(key), String.valueOf(value)));
        Set<String> strings = map.keySet();
        ArrayList<TextNode> textNodes = new ArrayList<>();
        Map<String, TextNode> collect = map.entrySet().stream().flatMap(stringStringEntry -> {
            String[] split = stringStringEntry.getKey().split("\\.");
            TextNode textNode = new TextNode();
            textNode.setKey(split[split.length - 1]);
            textNode.setValue(stringStringEntry.getValue());
            for (int i = split.length - 2; i >= 0; i--) {
                Map<String, TextNode> temp = new HashMap<>();
                temp.put(split[i], textNode);
                textNode = new TextNode(split[i], temp);
            }
            HashMap<String, TextNode> hashMap = new HashMap<>();
            hashMap.put(stringStringEntry.getKey(), textNode);
            return hashMap.entrySet().stream();
        }).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (textNode, textNode2) -> textNode));
        collect.forEach((s, textNode) -> {
            String[] split = s.split("\\.");
            if (split.length > 1) {
                TextNode temp = new TextNode();
                TextNode textNode1 = TEXT_NODES.get(split[0]);
                if (textNode == null) {
                    TEXT_NODES.put(textNode.getKey(), textNode);
                } else {
                    TextNode textNode2 = textNode1.getChildrenList().get(split[1]);
                    if (textNode2 == null) {

                    } else {

                    }
                }
            } else {
                TextNode textNode1 = new TextNode(split[0], map.get(s));
                TEXT_NODES.put(split[0], textNode);
            }
        });
        strings.forEach(s -> {

        });
    }
}
