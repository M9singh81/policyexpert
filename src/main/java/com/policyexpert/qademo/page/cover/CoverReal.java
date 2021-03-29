package com.policyexpert.qademo.page.cover;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class CoverReal implements Cover {
    @Autowired
    BuildingQuestionnaire buildingQuestionnaire;

    @Override
    public void fillBuildingQuestionnaire(Map<String, String> data) {
        buildingQuestionnaire.enterPropertyValue(data.get("Property Value"));
        buildingQuestionnaire.enterRebuildCost(data.get("Rebuild Cost"));
        buildingQuestionnaire.selectAccidentalCover(data.get("Accidental Cover"));
    }

    @Override
    public void fillContentQuestionnaire(Map<String, String> data) {

    }
}

