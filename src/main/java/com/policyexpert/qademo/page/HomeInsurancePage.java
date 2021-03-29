package com.policyexpert.qademo.page;

import com.github.javafaker.Faker;
import com.policyexpert.qademo.page.aboutYou.AboutYou;
import com.policyexpert.qademo.page.cover.CoverComponent;
import com.policyexpert.qademo.page.insuranceHistory.InsuranceHistory;
import com.policyexpert.qademo.page.policyHolders.PolicyHolder;
import com.policyexpert.qademo.page.safetySecurity.SafetySecurity;
import com.policyexpert.qademo.utility.WebDriverHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class HomeInsurancePage {
    @Autowired
    private WebDriverHelper wdHelper;

    @Autowired
    CoverComponent coverComponent;

    @Autowired
    InsuranceHistory insuranceHistory;

    @Autowired
    PolicyHolder policyHolder;

    @Autowired
    AboutYou aboutYou;

    @Autowired
    SafetySecurity safetySecurity;

    @Value("${url}")
    private String url;

    @Autowired
    Faker faker;

    public void goTo(){
        wdHelper.navigateToUrl(url);
    }


    public void fillAboutYouSection(Map<String, String> data){
        aboutYou.selectTitle(faker.name().prefix());
        aboutYou.enterFirstName(faker.name().firstName());
        aboutYou.enterLastName(faker.name().lastName());
        aboutYou.enterDOB(data.get("DOB"));
        aboutYou.enterMaritalStatus(data.get("Marital Status"));
        aboutYou.enterOccupation(data.get("Occupation"));
        aboutYou.selectSmoker(data.get("Smoker"));
        aboutYou.enterTelephone(faker.phoneNumber().phoneNumber());
        aboutYou.enterEmail(faker.name().username()+"@email.com");
    }

    public void fillAboutYouStatementSection(){
    }

    public void fillPropertySection(){
    }

    public void fillPropertyStatementSection(){
    }


    public void fillSafetyAndSecuritySection(String securityOptions){
        safetySecurity.selectOptions(securityOptions);
    }

    public void fillPolicyHolderSection(String jointPolicy){
        policyHolder.selectJointPolicy(jointPolicy);
    }

    public void fillInsuranceHistorySection(Map<String, String> data){
        insuranceHistory.selectYearsInsuranceHeld(data.get("Years Insurance Held"));
        insuranceHistory.insuranceClaimsMade(data.get("Claims Made"));
    }

    public void fillCoverTypeSection(String coverType, Map<String, String> data) {
        coverComponent.fillAboutCoverForm(coverType, data);
    }

}
