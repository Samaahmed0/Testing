package com.guru99.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class FundTransferPage {

    @FindBy(name = "payersaccount")
    WebElement payerAccount;

    @FindBy(name = "payeeaccount")
    WebElement payeeAccount;

    @FindBy(name = "ammount")
    WebElement amount;

    @FindBy(name = "desc")
    WebElement description;

    @FindBy(name = "AccSubmit")
    WebElement submitBtn;

    public FundTransferPage(WebDriver driver) {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 15), this);
    }

    public void setPayerAccount(String a) { payerAccount.sendKeys(a); }
    public void setPayeeAccount(String a) { payeeAccount.sendKeys(a); }
    public void setAmount(String a)       { amount.sendKeys(a); }
    public void setDescription(String d)  { description.sendKeys(d); }
    public void clickSubmit()             { submitBtn.click(); }
}