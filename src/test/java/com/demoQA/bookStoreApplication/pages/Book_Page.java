package com.demoQA.bookStoreApplication.pages;

import com.demoQA.bookStoreApplication.utilities.BrowserUtils;
import com.demoQA.bookStoreApplication.utilities.Driver;
import org.bouncycastle.util.Store;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.awt.print.Book;

public class Book_Page extends Base_Page{
//-----------------------------------------------LOCATORS-----------------------------------------------------
    @FindBy(xpath = "//button[.=\"Add To Your Collection\"]")
    private WebElement addToYourCollectionButton;
    @FindBy(xpath = "//label[.=\"http://chimera.labs.oreilly.com/books/1230000000561/index.html\"]")
    private WebElement linkInBookPage;
    @FindBy(xpath = "//button[.=\"Back To Book Store\"]")
    private WebElement backToBookStoreButton;
    @FindBy(xpath = "//a[.=\"Learning JavaScript Design Patterns\"]")
    private WebElement secondBook;

//-----------------------------------------------METHODS--------------------------------------------------------
    public void verifyLinkInBookPage(){
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        BrowserUtils.sleep(3);
        js.executeScript("arguments[0].scrollIntoView(true)",linkInBookPage);
        linkInBookPage.click();
        Assert.assertTrue(linkInBookPage.isEnabled());
        //LINKIN ACILIP ACILMADIGINI VERFY ETMEK ICIN WINDOW HANDLE  KULLANILABILIR MI WINDOW

    }
    public void clickAddToYourCollectionButton(){
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        BrowserUtils.sleep(3);
        js.executeScript("arguments[0].scrollIntoView(true)",addToYourCollectionButton);
        addToYourCollectionButton.click();
        BrowserUtils.sleep(3);
        Alert alert=Driver.getDriver().switchTo().alert();
        alert.accept();
    }
    public void verifyAddToYourCollectionButton(){
        Assert.assertTrue(addToYourCollectionButton.isEnabled());
    }
    public void clickBackToBookStoreButton(){
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        BrowserUtils.sleep(3);
        js.executeScript("arguments[0].scrollIntoView(true)",backToBookStoreButton);
        backToBookStoreButton.click();
    }
    public void verifyIsEnabledBackToBookStoreButton(){
        String expectedURL=Driver.getDriver().getCurrentUrl();
        String actualURL="https://demoqa.com/books";
        Assert.assertEquals(expectedURL,actualURL);
    }
    public void addSecondBook(){
        secondBook.click();
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        BrowserUtils.sleep(3);
        js.executeScript("arguments[0].scrollIntoView(true)",addToYourCollectionButton);
        addToYourCollectionButton.click();
        BrowserUtils.sleep(3);
        Alert alert=Driver.getDriver().switchTo().alert();
        alert.accept();
    }


}
