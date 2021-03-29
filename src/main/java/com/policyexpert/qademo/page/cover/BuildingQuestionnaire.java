package com.policyexpert.qademo.page.cover;

import com.policyexpert.qademo.utility.WebDriverHelper;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BuildingQuestionnaire {
    private static By CURRENT_MARKET_VALUE = By.xpath(".//p[.=\"Please enter the current market value of your property\"]/../following-sibling::div/input");
    private static By REBUILD_COST = By.xpath(".//p[.=\"Please enter the rebuild cost of your property\"]/../following-sibling::div/input");
    private static By ACCIDENTAL_COVER_YES = By.xpath(".//p[.=\"Would you like to include upgraded accidental damage cover for Buildings?\"]/../following-sibling::div/div/div/button[.=\"Yes\"]");
    private static By ACCIDENTAL_COVER_NO = By.xpath(".//p[.=\"Would you like to include upgraded accidental damage cover for Buildings?\"]/../following-sibling::div/div/div/button[.=\"No\"]");

    @Autowired
    WebDriverHelper wdHelper;

    public void enterPropertyValue(String propertyValue){
        wdHelper.sendKeys(CURRENT_MARKET_VALUE, propertyValue);
    }

    public void enterRebuildCost(String rebuildCost){
        wdHelper.sendKeys(REBUILD_COST, rebuildCost);
    }

    public void selectAccidentalCover(String accidentalCover){
        By ACCIDENTAL_COVER = (accidentalCover.equals("Yes")) ? ACCIDENTAL_COVER_YES : ACCIDENTAL_COVER_NO;
        wdHelper.click(ACCIDENTAL_COVER);
    }

}
