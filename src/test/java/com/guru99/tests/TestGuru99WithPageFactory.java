package com.guru99.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.guru99.pages.LoginPageWithPageFactory;
import com.guru99.pages.HomePageWithPageFactory;

public class TestGuru99WithPageFactory {

    WebDriver driver = new FirefoxDriver();
    LoginPageWithPageFactory objLogin = new LoginPageWithPageFactory(driver);
    HomePageWithPageFactory  objHome  = new HomePageWithPageFactory(driver);

    @Test(priority = 0)
    public void test_Home_Page() throws Exception {
        driver.get("http://demo.guru99.com/V4/");
        Assert.assertTrue(objLogin.getBankTitle().toLowerCase().contains("guru99 bank"));

        objLogin.setUserName("mngr658731");
        objLogin.setPassword("bYsezer");
        objLogin.clickLogin();

        Assert.assertTrue(objHome.getHomePageDashboardUserName().toLowerCase().contains("mngr658731"));
    }
}