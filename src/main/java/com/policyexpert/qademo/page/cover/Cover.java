package com.policyexpert.qademo.page.cover;

import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public interface Cover {
    void fillBuildingQuestionnaire(Map<String, String> data);
    void fillContentQuestionnaire(Map<String, String> data);
}
