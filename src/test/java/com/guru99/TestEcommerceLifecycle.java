package com.guru99;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestEcommerceLifecycle {

    WebDriver driver;

    // Runs ONCE before any @Test in this <test> block — open browser
    @BeforeTest
    public void openWebSite() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://demo.guru99.com/V4/");
        System.out.println("Browser opened and navigated to site");
    }

    // priority=1 runs first
    @Test(priority = 1)
    public void signUp() {
        System.out.println("Step 1: Signing up a new user");
        // In a real test you would fill the registration form here
    }

    // priority=2 runs second
    @Test(priority = 2)
    public void logIn() {
        System.out.println("Step 2: Logging in with registered credentials");
        // In a real test you would enter username + password and click login
    }

    // priority=3 runs third
    @Test(priority = 3)
    public void addToCart() {
        System.out.println("Step 3: Adding a product to the cart");
        // In a real test you would click a product and add to cart
    }

    // Runs ONCE after all @Test methods finish — close browser
    @AfterTest
    public void logOut() {
        System.out.println("Step 4: Logging out and closing browser");
        if (driver != null) {
            driver.quit();
        }
    }
}