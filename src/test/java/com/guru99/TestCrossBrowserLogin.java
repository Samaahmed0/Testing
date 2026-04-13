package com.guru99;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;


public class TestCrossBrowserLogin {

    WebDriver driver;

    @Parameters("browser")
    @BeforeMethod
    public void beforeMethod(String browser) {
      if (browser.equalsIgnoreCase("Chrome")) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
      } else if (browser.equalsIgnoreCase("firefox")) {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
      }
            driver.get("https://demo.guru99.com/test/login.html");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod

    public void afterMethod() {
        driver.close();
    }
    @DataProvider(name="LoginData")
    public Object[][] getLoginData() {
        return new Object[][] {{"test@mail.com","123","Invalid email or password.","Invalid"},
                {"test@mail.com","152","https://demo.guru99.com/test/success.html","Valid"}
        };
    }

    @Test(dataProvider = "LoginData")
    public void f(String UN, String pass,String excpected,String CaseType) throws InterruptedException {
        WebElement username=driver.findElement(By.id("email"));
        WebElement password=driver.findElement(By.name("passwd"));
        WebElement loginBtn=driver.findElement(By.id("SubmitLogin"));
        username.sendKeys(UN);
        password.sendKeys(pass);
        loginBtn.submit();
        if(CaseType.equalsIgnoreCase("Valid")) {
            Thread.sleep(7000);
            String ActualURL=driver.getCurrentUrl();
            Assert.assertEquals(ActualURL, excpected, "Valid URL navigation");
        }
    }
}





