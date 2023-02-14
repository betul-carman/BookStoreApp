package com.demoQA.bookStoreApplication.pages;

import com.demoQA.bookStoreApplication.utilities.BrowserUtils;
import com.demoQA.bookStoreApplication.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class Profile_Page extends Base_Page{
//-----------------------------------------------LOCATORS--------------------------------------------------------------
    @FindBy(xpath = "//button[.=\"Log out\"]")
    private WebElement logOutButton;
    @FindBy(xpath = "//span[.='Profile']")
    private WebElement profileButton;
    @FindBy(xpath = "//button[.=\"Go To Book Store\"]")
    private WebElement goToBookStoreButton;
    @FindBy(xpath = "//*[@id=\"delete-record-undefined\"]/svg")
    private WebElement deleteABookButton;
    @FindBy(xpath = "//button[@id=\"closeSmallModal-ok\"]")
    private WebElement okButton;
    @FindBy(xpath = "(//button[.=\"Delete All Books\"])[1]")
    private WebElement deleteAllBooksButton;
    @FindBy(xpath = "//div[.=\"Do you want to delete all books?\"]")
    private WebElement messageDoYouWantToDeleteAllBooks;
    @FindBy(xpath = "//a[.=\"Git Pocket Guide\"]")
    private WebElement deletedBook;
    @FindBy(xpath = "//a[.=\"Learning JavaScript Design Patterns\"]")
    private WebElement deletedSecondBook;
    @FindBy(xpath = "//button[.=\"Delete Account\"]")
    private WebElement deleteAccountButton;
//-----------------------------------------------METHODS--------------------------------------------------------------
    public void clickLogOutButton(){
        logOutButton.click();
    }
    public void verifyLogOut(){
        String expectedURL="https://demoqa.com/login";
        String actualResult=Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(expectedURL,actualResult);
    }
    public void clickDeleteButton(){
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        BrowserUtils.sleep(3);
        js.executeScript("arguments[0].scrollIntoView(true)",deleteAccountButton);
        deleteAccountButton.click();
    }
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
    public void clickOkButton(){
        okButton.click();
    }
    public void clickDeleteBook(){
        BrowserUtils.sleep(3);
        deleteABookButton.click();
    }
    public void clickDeleteAllBooksButton(){
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        BrowserUtils.sleep(3);
        js.executeScript("arguments[0].scrollIntoView(true)",deleteAllBooksButton);
        deleteAllBooksButton.click();
    }
    public void verifyMessageDoYouWantToDeleteAllBooks(String expectedMessage){
        String actualMessage=messageDoYouWantToDeleteAllBooks.getText();
        Assert.assertEquals(expectedMessage,actualMessage);
    }
    public void verifyDeleteAllBooksButton(){
        BrowserUtils.assertWebElementNotPresent(deletedSecondBook);

    }
}
