package com.policyexpert.qademo.bdd;

import com.policyexpert.qademo.utility.ScreenShotService;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import java.io.IOException;

public class CucumberHooks {
    @Autowired
    private ScreenShotService screenshotService;

    @Autowired
    private ApplicationContext applicationContext;

    @AfterStep
    public void afterStep(Scenario scenario) throws IOException {
        if(scenario.isFailed()){
            scenario.embed(this.screenshotService.getScreenshot(), "image.png", scenario.getName());
        }
    }

    @After
    public void afterScenario(){
        this.applicationContext.getBean(WebDriver.class).quit();
    }
}
