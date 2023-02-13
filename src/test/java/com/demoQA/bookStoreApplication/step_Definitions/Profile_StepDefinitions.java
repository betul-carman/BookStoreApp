package com.demoQA.bookStoreApplication.step_Definitions;

import com.demoQA.bookStoreApplication.pages.BookStore_Page;
import com.demoQA.bookStoreApplication.pages.Book_Page;
import com.demoQA.bookStoreApplication.pages.Login_Page;
import com.demoQA.bookStoreApplication.pages.Profile_Page;
import com.demoQA.bookStoreApplication.utilities.ConfigurationReader;
import com.demoQA.bookStoreApplication.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
public class Profile_StepDefinitions {
    Profile_Page profilePage=new Profile_Page();
    Login_Page loginPage=new Login_Page();
    BookStore_Page bookStorePage=new BookStore_Page();
    Book_Page bookPage=new Book_Page();
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
    @Then("the user navigates to the book store page")
    public void theUserGoToTheBookStorePageByClickingGoToBookStoreButton() {
        profilePage.clickGoToBookStoreButton();
        profilePage.verifyNavigatingToBookStore();
    }
//------------------------------------------------SCENARIO-2-----------------------------------------------------
    @Then("the user logs out by clicking logout button")
    public void theUserLogsOutByClickingLogoutButton() {
        profilePage.clickLogOutButton();
        profilePage.verifyLogOut();
    }
//------------------------------------------------SCENARIO-3-----------------------------------------------------
    @Given("the user adds a book")
    public void theUserAddABook() {
        profilePage.clickGoToBookStoreButton();
        bookPage.addSecondBook();
        profilePage.clickProfileButton();
    }
    @Then("the user sees an pop-up message {string}")
    public void theUserSeesAnPopUpMessage(String arg0) {
        profilePage.clickDeleteAllBooksButton();
        profilePage.verifyMessageDoYouWantToDeleteAllBooks(arg0);
        profilePage.clickOkButton();
    }
    @And("the user deletes all books")
    public void theUserDeleteAllBooks() {
        profilePage.verifyDeleteAllBooksButton();
    }
}
