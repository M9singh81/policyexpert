package com.policyexpert.qademo.page.aboutYou;

import com.github.javafaker.Faker;
import com.policyexpert.qademo.utility.WebDriverHelper;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AboutYou {
    private static By TITLE_SELECT = By.cssSelector(".question-row-title .questionset-input select");
    private static By FIRST_NAME = By.cssSelector(".question-row-first-name .questionset-input input");
    private static By LAST_NAME = By.cssSelector(".question-row-last-name .questionset-input input");
    private static By DAY_SELECT = By.xpath(".//div[@data-testid=\"date-dropdowns\"]/div[1]/select");
    private static By MONTH_SELECT = By.xpath(".//div[@data-testid=\"date-dropdowns\"]/div[2]/select");
    private static By YEAR_SELECT = By.xpath(".//div[@data-testid=\"date-dropdowns\"]/div[3]/select");
    private static By MARITAL_STATUS_SELECT = By.cssSelector(".question-row-what-is-your-marital select");
    private static By OCCUPATION_INPUT = By.cssSelector(".question-row-what-is-your-occupat input");
    private static By OCCUPATION_SUGGESTION = By.cssSelector("ul.list-group > li:nth-child(1)");
    private static By SMOKE_YES_BUTTON = By.xpath(".//p[contains(.,\"smoke\")]/../following-sibling::div/div/div/button[.=\"Yes\"]");
    private static By SMOKE_NO_BUTTON = By.xpath(".//p[contains(.,\"smoke\")]/../following-sibling::div/div/div/button[.=\"No\"]");
    private static By PHONE_INPUT = By.cssSelector(".question-row-main-telephone-numbe input");
    private static By EMAIL_INPUT = By.cssSelector(".question-row-what-is-your-e-mail input");


    @Autowired
    AboutYou aboutYou;

    @Autowired
    Faker faker;

    @Autowired
    WebDriverHelper wdHelper;

    public void selectTitle(String title) {
        title = title.replace(".", "");
        wdHelper.selectOptionByVisibleText(TITLE_SELECT, title);
    }

    public void enterFirstName(String firstName) {
        wdHelper.sendKeys(FIRST_NAME, firstName);
    }

    public void enterLastName(String lastName) {
        wdHelper.sendKeys(LAST_NAME, lastName);
    }

    public void enterDOB(String dob) {
        String[] dobArray = dob.split("-");
        wdHelper.selectOptionByVisibleText(DAY_SELECT, dobArray[0]);
        wdHelper.selectOptionByValue(MONTH_SELECT, dobArray[1]);
        wdHelper.selectOptionByVisibleText(YEAR_SELECT, dobArray[2]);
    }

    public void enterMaritalStatus(String maritalStatus) {
        wdHelper.selectOptionByVisibleText(MARITAL_STATUS_SELECT, maritalStatus);
    }

    public void enterOccupation(String occupation) {
        wdHelper.sendKeys(OCCUPATION_INPUT, occupation);
        wdHelper.click(OCCUPATION_SUGGESTION);
    }

    public void selectSmoker(String isSmoker) {
        By SMOKER = (isSmoker).equals("Yes") ? SMOKE_YES_BUTTON : SMOKE_NO_BUTTON;
        wdHelper.click(SMOKER);
    }

    public void enterTelephone(String phoneNumber) {
        wdHelper.sendKeys(PHONE_INPUT, phoneNumber);
    }

    public void enterEmail(String email) {
        wdHelper.sendKeys(EMAIL_INPUT, email);
    }
}
