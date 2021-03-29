package com.policyexpert.qademo.page.cover;

import com.policyexpert.qademo.utility.ScenarioSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class CoverProxy implements Cover {
    @Autowired
    ScenarioSession scenarioSession;

    @Autowired
    CoverReal aboutCoverReal;


    @Override
    public void fillBuildingQuestionnaire(Map<String, String> data) {
        String coverType = (String) scenarioSession.getData("COVER_TYPE");
        if(coverType.contains("Buildings")) {
            aboutCoverReal.fillBuildingQuestionnaire(data);
        }
   }

    @Override
    public void fillContentQuestionnaire(Map<String, String> data) {
        String coverType = (String) scenarioSession.getData("COVER_TYPE");
        if(coverType.contains("Components")) {
            aboutCoverReal.fillContentQuestionnaire(data);
        }
    }
}
