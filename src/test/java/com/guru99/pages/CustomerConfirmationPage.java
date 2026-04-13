package com.guru99.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CustomerConfirmationPage {

    WebDriver driver;

    By successMessage = By.xpath("//td[contains(.,'Customer Registered Successfully')]");

    public CustomerConfirmationPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getRegistrationSuccessMessage() {
        return driver.findElement(successMessage).getText();
    }
}