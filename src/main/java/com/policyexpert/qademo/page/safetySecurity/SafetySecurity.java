package com.policyexpert.qademo.page.safetySecurity;

import com.policyexpert.qademo.utility.WebDriverHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class SafetySecurity {
    private final By SECURITY_SAFETY_YES = By.xpath(".//div[.=\"About safety and security\"]/following-sibling::div/div/div/div/div/div/div/button[.=\"Yes\"]");
    private final By SECURITY_SAFETY_NO = By.xpath(".//div[.=\"About safety and security\"]/following-sibling::div/div/div/div/div/div/div/button[.=\"No\"]");

    @Autowired
    WebDriverHelper wdHelper;

    public void selectOptions(String securityOptions) {
        By SECURITY_SAFETY = (securityOptions.equals("Yes")) ? SECURITY_SAFETY_YES : SECURITY_SAFETY_NO;
        List<WebElement> elements = wdHelper.getElements(SECURITY_SAFETY);
        elements.
                stream().
                forEach( e -> wdHelper.click(e));
    }
}
