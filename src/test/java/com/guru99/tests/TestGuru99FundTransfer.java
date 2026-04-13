package com.guru99.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.guru99.pages.LoginPageWithPageFactory;
import com.guru99.pages.FundTransferPage;

import java.util.concurrent.TimeUnit;

public class TestGuru99FundTransfer {

    WebDriver driver = new FirefoxDriver();

    @BeforeMethod
    public void setUp() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test(priority = 0)
    public void test_Fund_Transfer_Valid() throws Exception {
        LoginPageWithPageFactory login = new LoginPageWithPageFactory(driver);

        driver.get("http://demo.guru99.com/V4/");
        login.setUserName("mngr658731");
        login.setPassword("bYsezer");
        login.clickLogin();

        driver.get("http://demo.guru99.com/V4/manager/FundTransInput.php");

        FundTransferPage fund = new FundTransferPage(driver);

        fund.setPayerAccount("181264");
        fund.setPayeeAccount("181263");
        fund.setAmount("500");
        fund.setDescription("test transfer");

        fund.clickSubmit();

        try {
            String alertText = driver.switchTo().alert().getText();
            driver.switchTo().alert().accept();

            Assert.fail("Unexpected alert appeared: " + alertText);

        } catch (Exception e) {

        }

        Assert.assertTrue(driver.getPageSource().contains("Fund Transfer Details"));
        Thread.sleep(2000);

    }

    @Test(priority = 1)
    public void test_Fund_Transfer_Invalid() throws Exception {
        LoginPageWithPageFactory login = new LoginPageWithPageFactory(driver);

        driver.get("http://demo.guru99.com/V4/");
        login.setUserName("mngr658731");
        login.setPassword("bYsezer");
        login.clickLogin();

        driver.get("http://demo.guru99.com/V4/manager/FundTransInput.php");

        FundTransferPage fund = new FundTransferPage(driver);

        fund.setPayerAccount("00000");
        fund.setPayeeAccount("11111");
        fund.setAmount("100");
        fund.setDescription("invalid");

        fund.clickSubmit();

        String alertText = driver.switchTo().alert().getText();

        Assert.assertTrue(
                alertText.contains("does not exist"),
                "Expected error alert for invalid accounts"
        );
        Thread.sleep(3000);

        driver.switchTo().alert().accept();
    }
}