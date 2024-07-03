package com.echo.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JSONParser {
    private static ObjectMapper mapper = new ObjectMapper();

    public static JsonNode parse(String json) throws IOException {
        return mapper.readTree(json);
    }
}
