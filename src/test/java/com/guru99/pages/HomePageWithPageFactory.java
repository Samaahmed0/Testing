package com.guru99.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageWithPageFactory {

    @FindBy(xpath = "//table//tr[@class='heading3']")
    WebElement homePageUserName;

    public HomePageWithPageFactory(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public String getHomePageDashboardUserName() {
        return homePageUserName.getText();
    }
}