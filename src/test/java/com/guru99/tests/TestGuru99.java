package com.guru99.tests;

import com.guru99.pages.HomePage;
import com.guru99.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestGuru99 {

    WebDriver driver = new FirefoxDriver();
    LoginPage objLogin = new LoginPage(driver);
    HomePage objHome  = new HomePage(driver);

    @BeforeMethod
    public void setUp() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test(priority = 0)
    public void test_Home_Page_Appear_Correct() throws Exception {
        driver.get("http://demo.guru99.com/V4/");
        Assert.assertTrue(objLogin.getBankTitle().toLowerCase().contains("guru99 bank"));

        objLogin.setUserName("mngr658731");
        objLogin.setPassword("bYsezer");
        objLogin.clickLogin();

        Assert.assertTrue(objHome.getHomePageDashboardUserName().toLowerCase().contains("mngr658731"));
    }
}