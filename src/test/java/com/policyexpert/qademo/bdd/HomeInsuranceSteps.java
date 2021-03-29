package com.policyexpert.qademo.bdd;

import com.policyexpert.qademo.page.HomeInsurancePage;
import com.policyexpert.qademo.utility.ScenarioSession;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

@SpringBootTest
public class HomeInsuranceSteps {
    @Autowired
    HomeInsurancePage homeInsurancePage;

    @Autowired
    ScenarioSession scenarioSession;

    @Given("I am on home-insurance page")
    public void iAmOnHomeInsurancePage() {
        homeInsurancePage.goTo();
    }

    @When("I enter the following details about me")
    public void aboutMe(DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);
        homeInsurancePage.fillAboutYouSection(data);
    }

//    @And("I agree with statements about me")
//    public void iAgreeWithStatementsAboutMe() {
//    }
//
//    @And("I enter the following property details")
//    public void iEnterTheFollowingPropertyDetails(DataTable dataTable) {
//    }
//
//    @And("I agree with statements about property")
//    public void iAgreeWithStatementsAboutProperty() {
//    }

    @And("I select {string} for safety and security options")
    public void safetySecuritySection(String securityOptions) {
        homeInsurancePage.fillSafetyAndSecuritySection(securityOptions);
    }

    @And("I {string} to add a joint policy holder")
    public void policyHolder(String jointPolicy) {
        homeInsurancePage.fillPolicyHolderSection(jointPolicy);
    }

    @And("I select following options for insurance history")
    public void insuranceHistory(DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);
        homeInsurancePage.fillInsuranceHistorySection(data);
    }

    @And("I select {string} cover (.*)")
    public void coverType(String coverType, DataTable dataTable) {
        scenarioSession.putData("COVER_TYPE", coverType);
        Map<String, String> data = dataTable.asMap(String.class, String.class);
        homeInsurancePage.fillCoverTypeSection(coverType, data);
    }
}
