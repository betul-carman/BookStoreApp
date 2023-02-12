package com.demoQA.bookStoreApplication.pages;

import com.demoQA.bookStoreApplication.utilities.BrowserUtils;
import com.demoQA.bookStoreApplication.utilities.Driver;
import com.google.common.base.Verify;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Profile_Page extends Base_Page{

//-----------------------------------------------LOCATORS--------------------------------------------------------------
    @FindBy(xpath = "//span[.='Profile']")
    private WebElement profileButton;
    @FindBy(xpath = "//button[.=\"Go To Book Store\"]")
    private WebElement goToBookStoreButton;
//-----------------------------------------------METHODS--------------------------------------------------------------
    public void clickProfileButton(){
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        BrowserUtils.sleep(3);
        js.executeScript("arguments[0].scrollIntoView(true)", profileButton);
        profileButton.click();
    }
    public void clickGoToBookStoreButton(){
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        BrowserUtils.sleep(3);
        js.executeScript("arguments[0].scrollIntoView(true)", goToBookStoreButton);
        goToBookStoreButton.click();
    }
    public void verifyNavigatingToBookStore(){
        BrowserUtils.sleep(3);
        String actualURL= Driver.getDriver().getCurrentUrl();
        String expectedURL="https://demoqa.com/books";
        Assert.assertEquals(expectedURL,actualURL);
    }
}
