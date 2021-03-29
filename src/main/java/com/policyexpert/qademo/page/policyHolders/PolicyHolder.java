package com.policyexpert.qademo.page.policyHolders;

import com.policyexpert.qademo.utility.WebDriverHelper;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PolicyHolder {
    private final By JOINT_POLICY_YES = By.xpath(".//p[contains(.,\"policyholder\")]/../following-sibling::div/div/div/button[.=\"Yes\"]");
    private final By JOINT_POLICY_NO = By.xpath(".//p[contains(.,\"policyholder\")]/../following-sibling::div/div/div/button[.=\"No\"]");

    @Autowired
    WebDriverHelper wdHelper;

    public void selectJointPolicy(String jointPolicy) {
        By JOINT_POLICY = (jointPolicy.equals("choose")) ? JOINT_POLICY_YES : JOINT_POLICY_NO;
        wdHelper.click(JOINT_POLICY);
    }
}
