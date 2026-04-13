package com.guru99.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    By userName    = By.name("uid");
    By password    = By.name("password");
    By loginButton = By.name("btnLogin");
    By bankTitle   = By.className("barone");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setUserName(String s) {
        driver.findElement(userName).sendKeys(s);
    }

    public void setPassword(String s) {
        driver.findElement(password).sendKeys(s);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public String getBankTitle() {
        return driver.findElement(bankTitle).getText();
    }
}