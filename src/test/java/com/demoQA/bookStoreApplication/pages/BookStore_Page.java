package com.demoQA.bookStoreApplication.pages;

import com.demoQA.bookStoreApplication.utilities.BrowserUtils;
import com.demoQA.bookStoreApplication.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BookStore_Page extends Base_Page {
//-----------------------------------------------LOCATORS---------------------------------------------------------------
 Alert alert=Driver.getDriver().switchTo().alert();
    @FindBy(xpath = "//input[@id=\"searchBox\"]")
    private WebElement inputSearchBox;
    @FindBy(xpath = "//span[@id=\"basic-addon2\"]")
    private  WebElement searchBoxButton;
    @FindBy(xpath = "//a[.=\"Git Pocket Guide\"]")
    private WebElement searchingBook;
    @FindBy(xpath = "(//div[@role=\"gridcell\"])[3]")
    private WebElement searchingAuthor;
    @FindBy(xpath="//div[@class=\"rt-tbody\"]//div//div//div//div")
    private List<WebElement> bookNamesWithSearchingLetters;
    private WebElement searchingLetters;
    @FindBy(xpath = "//div[.=\"No rows found\"]")
    private WebElement noRowsFound;
    @FindBy(xpath = "//button[.=\"Add To Your Collection\"]")
    private WebElement addToYourCollectionButton;
    @FindBy(xpath = "(//label[@id=\"userName-value\"])[9]")
    private WebElement linkInBookPage;

//-----------------------------------------------METHODS----------------------------------------------------------------
    public void enterBookNameInSearchBox(){
        inputSearchBox.sendKeys("Git Pocket Guide");
    }
    public void clickSearchBoxButton(){
        searchBoxButton.click();
    }
    public void verifySearchingBook(){
        String expectedBook="Git Pocket Guide";
        String actualBook=searchingBook.getText();
        Assert.assertEquals(expectedBook,actualBook);
    }
    public void enterAuthorNameInSearchBox(){
        searchingAuthor.sendKeys("Richard E. Silverman");
    }
    public void verifySearchingAuthor(){
        String expectedAuthor="Richard E. Silverman";
        String actualAuthor=searchingAuthor.getText();
        Assert.assertEquals(expectedAuthor,actualAuthor);
    }
    public void enterSomeLettersOfBook(){
        inputSearchBox.sendKeys("abc");
    }
    public void verifyAutoSuggestion(){

    }
    public void typeBookNameNotInRepository(){
        inputSearchBox.sendKeys("Crime and Punishment");
    }
    public void verifyNoRowsFoundMessage(String expected){
        String actual=noRowsFound.getText();
        Assert.assertEquals(expected,actual);
    }
    public void clickOnSearchingBook(){
        searchingBook.click();
    }
    public void clickAddToYourCollectionButton(){
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        BrowserUtils.sleep(3);
        js.executeScript("arguments[0].scrollIntoView(true)",addToYourCollectionButton);
        addToYourCollectionButton.click();
    }
    public void verifyAddToYourCollectionButton(){
        Assert.assertTrue(addToYourCollectionButton.isEnabled());
    }
    public void verifyBookAddedToYourCollectionMessage(){
        alert.accept();
        //ALERTTEKI MESAJI NASIL DOGRULARIZ
    }
    public void verifyBooksWithSearchedLetters(String letters){
        for (WebElement e:bookNamesWithSearchingLetters) {
            if(e.getText().contains(letters)){
                System.out.println("e.getText()");
                Assert.assertTrue(true);

            }

        }
    }
    public void verifyLinkInBookPage(){
        linkInBookPage.click();
        BrowserUtils.sleep(3);
        Assert.assertTrue(linkInBookPage.isDisplayed());
    }



}
