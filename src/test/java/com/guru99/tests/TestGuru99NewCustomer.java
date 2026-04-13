package com.guru99.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.guru99.pages.CustomerConfirmationPage;
import com.guru99.pages.LoginPage;
import com.guru99.pages.NewCustomerPage;

import java.util.concurrent.TimeUnit;

public class TestGuru99NewCustomer {

    WebDriver driver = new FirefoxDriver();

    @BeforeMethod
    public void setUp() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test(priority = 0)
    public void test_Register_New_Customer() throws Exception {
        LoginPage login = new LoginPage(driver);
        driver.get("http://demo.guru99.com/V4/");
        login.setUserName("mngr658731");
        login.setPassword("bYsezer");
        login.clickLogin();

        driver.findElement(By.linkText("New Customer")).click();

        NewCustomerPage newCustomer = new NewCustomerPage(driver);
        long ts = System.currentTimeMillis();
        newCustomer.fillCustomerForm(
                "Testuser",
                "1995-01-01",
                "123 Main Street",
                "Los Angeles",
                "123456",
                String.valueOf(ts).substring(0, 10),
                "user" + ts + "@gmail.com",
                "pass123"
        );

        newCustomer.clickSubmit();

        CustomerConfirmationPage confirm = new CustomerConfirmationPage(driver);
        Assert.assertTrue(
                confirm.getRegistrationSuccessMessage().toLowerCase().contains("customer registered successfully")
        );
    }
}