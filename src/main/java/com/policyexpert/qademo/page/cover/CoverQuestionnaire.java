package com.policyexpert.qademo.page.cover;

import com.policyexpert.qademo.utility.WebDriverHelper;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CoverQuestionnaire {
    private final By STANDARD_ACCESS = By.xpath(".//p[.=\"Standard Excess (other excesses may apply)\"]/../following-sibling::div/select");
    private final By COVER_TYPE_SELECT = By.xpath(".//p[.=\"Please select what type of home insurance you require\"]/../following-sibling::div/select");
    private final By START_DATE_TODAY = By.xpath(".//button[@data-testid=\"today\"]");
    private final By START_DATE_TOMORROW = By.xpath(".//button[@data-testid=\"tomorrow\"]");

    @Autowired
    WebDriverHelper wdHelper;


    public void selectStartDate(String startDate){;
        By START_DATE =  (startDate.equals("Today")) ? START_DATE_TODAY: START_DATE_TOMORROW;
        wdHelper.click(START_DATE);
    }

    public void selectCoverType(String coverType) {
        wdHelper.selectOptionByVisibleText(COVER_TYPE_SELECT, coverType);
    }

    public void selectStandardExcess(String excess){
        wdHelper.selectOptionByValue(STANDARD_ACCESS, excess);
    }
}
