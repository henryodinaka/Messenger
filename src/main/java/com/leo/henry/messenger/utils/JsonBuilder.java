package com.leo.henry.messenger.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonBuilder {

    public static String generateJson(Object object)
    {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.valueToTree(object);
        return jsonNode.toString();
    }
}
