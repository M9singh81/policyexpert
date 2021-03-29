package com.policyexpert.qademo.utility;

import org.springframework.stereotype.Component;
import java.util.HashMap;
import java.util.Map;

@Component
public class ScenarioSession {
    private Map<String, Object> scenarioData = new HashMap<>();

    public Object getData(String key) {
        return scenarioData.get(key);
    }

    public void putData(String key, Object value) {
        this.scenarioData.put(key, value);
    }
}
