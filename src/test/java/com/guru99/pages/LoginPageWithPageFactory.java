package com.guru99.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class LoginPageWithPageFactory {

    WebDriver driver;

    @FindBy(name = "uid")
    WebElement userNameElement;

    @FindBy(name = "password")
    WebElement passwordElement;

    @FindBy(name = "btnLogin")
    WebElement loginButtonElement;

    @FindBy(className = "barone")
    WebElement bankTitleElement;

//    public LoginPageWithPageFactory(WebDriver driver) {
//        this.driver = driver;
//        PageFactory.initElements(driver, this);
//    }



public LoginPageWithPageFactory(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
}

    public void   setUserName(String s) { userNameElement.sendKeys(s); }
    public void   setPassword(String s) { passwordElement.sendKeys(s); }
    public void   clickLogin()          { loginButtonElement.click(); }
    public String getBankTitle()        { return bankTitleElement.getText(); }
}