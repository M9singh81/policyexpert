package com.policyexpert.qademo.page.insuranceHistory;

import com.policyexpert.qademo.utility.WebDriverHelper;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InsuranceHistory {
    private final By YEARS_INSURANCE_HELD_SELECT = By.xpath(".//p[.=\"How many consecutive years have you held home insurance?\"]/../following-sibling::div/select");
    private final By INSURANCE_CLAIMS_YES = By.xpath(".//p[contains(.,\"claims\")]/../following-sibling::div/div/div/button[.=\"Yes\"]");
    private final By INSURANCE_CLAIMS_NO = By.xpath(".//p[contains(.,\"claims\")]/../following-sibling::div/div/div/button[.=\"No\"]");

    @Autowired
    WebDriverHelper wdHelper;

    public void selectYearsInsuranceHeld(String yearsInsuranceHeld){
        wdHelper.selectOptionByVisibleText(YEARS_INSURANCE_HELD_SELECT, yearsInsuranceHeld);
    }

    public void insuranceClaimsMade(String claimsMade){
        By INSURANCE_CLAIMS = (claimsMade.equals("YES")) ? INSURANCE_CLAIMS_YES : INSURANCE_CLAIMS_NO;
        wdHelper.click(INSURANCE_CLAIMS);
    }
}
