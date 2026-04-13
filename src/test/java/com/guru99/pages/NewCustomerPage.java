package com.guru99.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewCustomerPage {

    WebDriver driver;

    By customerName = By.name("name");
    By genderMale   = By.xpath("//input[@name='rad1'][@value='m']");
    By dob          = By.name("dob");
    By address      = By.name("addr");
    By city         = By.name("city");
    By state        = By.name("state");
    By pin          = By.name("pinno");
    By mobile       = By.name("telephoneno");
    By email        = By.name("emailid");
    By pwd          = By.name("password");
    By submitBtn    = By.name("sub");

    public NewCustomerPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillCustomerForm(String name, String dobVal, String addressVal,
                                 String cityVal, String pinVal,
                                 String mobileVal, String emailVal, String pwdVal) {
        driver.findElement(customerName).sendKeys(name);
        driver.findElement(genderMale).click();
        driver.findElement(dob).sendKeys(dobVal);
        driver.findElement(address).sendKeys(addressVal);
        driver.findElement(city).sendKeys(cityVal);
        driver.findElement(state).sendKeys("California");
        driver.findElement(pin).sendKeys(pinVal);
        driver.findElement(mobile).sendKeys(mobileVal);
        driver.findElement(email).sendKeys(emailVal);
        driver.findElement(pwd).sendKeys(pwdVal);
    }

    public void clickSubmit() {
        driver.findElement(submitBtn).click();
    }
}