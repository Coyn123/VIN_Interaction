package com.coy;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.Map;

public class ParseObject {
    public void parseResponse(String resp) throws JsonProcessingException {
        System.err.println(resp);
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> map = mapper.readValue(resp, Map.class);
        map.forEach((k, v) -> System.out.println(k + ": " + v));
        List<Map<String, Object>> results = (List<Map<String, Object>>) map.get("Results");
        results.forEach(entry -> entry.forEach((k, v) -> System.out.println(k + ": " + v)));
    }
}
