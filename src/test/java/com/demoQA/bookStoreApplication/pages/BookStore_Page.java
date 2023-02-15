package com.demoQA.bookStoreApplication.pages;

import com.demoQA.bookStoreApplication.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class BookStore_Page extends Base_Page {

//-----------------------------------------------LOCATORS---------------------------------------------------------------
    @FindBy(xpath = "//input[@id=\"searchBox\"]")
    private WebElement inputSearchBox;
    @FindBy(xpath = "//span[@id=\"basic-addon2\"]")
    private  WebElement searchBoxButton;
    @FindBy(xpath = "//a[.=\"Git Pocket Guide\"]")
    private WebElement searchingBook;
    @FindBy(xpath = "(//div[@role=\"gridcell\"])[3]")
    private WebElement searchingAuthor;
    @FindBy(xpath="//div[@class=\"rt-tbody\"]//div//div//div//div")
    private List<WebElement> allBooksInTheBookPage;
    @FindBy(xpath = "//div[.=\"No rows found\"]")
    private WebElement noRowsFound;
    @FindBy(xpath = "//button[.=\"Log out\"]")
    private WebElement logOutButton;

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
        inputSearchBox.sendKeys("Richard E. Silverman");
    }
    public void verifySearchingAuthorIsVisibleInThePage(){
        String expectedAuthor="Richard E. Silverman";
        String actualAuthor=searchingAuthor.getText();
        Assert.assertEquals(expectedAuthor,actualAuthor);
    }
    public void enterSomeLettersOfBook(String letters){
        inputSearchBox.sendKeys(letters);
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
    public void verifyAutoSuggestion(String letters){
        System.out.println( allBooksInTheBookPage.get(0).getText());
        Assert.assertTrue(allBooksInTheBookPage.get(0).getText().contains(letters));
    }
    public void clickLogOutButton(){
        logOutButton.click();
    }
    public void verifyLoggedOut(){
        String expectedUrl="https://demoqa.com/login";
        String actualURL=Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualURL);
    }




}
