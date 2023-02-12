package com.demoQA.bookStoreApplication.step_Definitions;

import com.demoQA.bookStoreApplication.pages.BookStore_Page;
import com.demoQA.bookStoreApplication.pages.Login_Page;
import com.demoQA.bookStoreApplication.pages.Profile_Page;
import com.demoQA.bookStoreApplication.utilities.ConfigurationReader;
import com.demoQA.bookStoreApplication.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Profile_StepDefinitions {
    Profile_Page profilePage=new Profile_Page();
    Login_Page loginPage=new Login_Page();
    BookStore_Page bookStorePage=new BookStore_Page();
    @Given("the user is on the profile page")
    public void theUserIsOnTheProfilePage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("bookStoreUrl"));
        loginPage.clickLoginButtonInHomepage();
        loginPage.enterInputUsername(ConfigurationReader.getProperty("username"));
        loginPage.enterInputPassword(ConfigurationReader.getProperty("password"));
        loginPage.clickLoginButton();
        profilePage.clickProfileButton();
    }
//------------------------------------------------SCENARIO-1-----------------------------------------------------
    @Then("the user navigate to the book store page")
    public void theUserGoToTheBookStorePageByClickingGoToBookStoreButton() {
        profilePage.clickGoToBookStoreButton();
        profilePage.verifyNavigatingToBookStore();
    }
//------------------------------------------------SCENARIO-2-----------------------------------------------------
    @Given("the user adds a book")
    public void theUserAddsABook() {
        profilePage.clickGoToBookStoreButton();
        bookStorePage.enterBookNameInSearchBox();
        bookStorePage.clickOnSearchingBook();
        bookStorePage.clickAddToYourCollectionButton();
    }
//------------------------------------------------SCENARIO-3-----------------------------------------------------
}
