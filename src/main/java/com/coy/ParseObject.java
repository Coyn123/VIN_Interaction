package com.coy;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.Map;

public class ParseObject {
    public void parseResponse(String resp) throws JsonProcessingException {
        System.err.println(resp);
        ObjectMapper mapper = new ObjectMapper();
        Map map = mapper.readValue(resp, Map.class);
        List<Map<String, Object>> results = (List<Map<String, Object>>) map.get("Results");
        results.forEach(entry -> entry.forEach((k, v) -> {
            if (v != null && !v.toString().isEmpty() && !v.toString().equals("Not Applicable"))
                System.out.println(k + ": " + v);
        }));
    }
}
