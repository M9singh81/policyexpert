package com.policyexpert.qademo.page.cover;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class CoverComponent {
    @Autowired
    CoverQuestionnaire coverQuestionnaire;

    @Autowired
    CoverProxy coverProxy;

    public void fillAboutCoverForm(String coverType, Map<String, String> data) {
        coverQuestionnaire.selectStartDate(data.get("Start Date"));
        coverQuestionnaire.selectCoverType(coverType);
        coverProxy.fillBuildingQuestionnaire(data);
        coverProxy.fillContentQuestionnaire(data);
        coverQuestionnaire.selectStandardExcess(data.get("Standard Excess"));
    }

}
