package com.demoQA.bookStoreApplication.step_Definitions;

import com.demoQA.bookStoreApplication.pages.BookStore_Page;
import com.demoQA.bookStoreApplication.pages.Book_Page;
import com.demoQA.bookStoreApplication.pages.Login_Page;
import com.demoQA.bookStoreApplication.pages.Profile_Page;
import com.demoQA.bookStoreApplication.utilities.BrowserUtils;
import com.demoQA.bookStoreApplication.utilities.ConfigurationReader;
import com.demoQA.bookStoreApplication.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Alert;

public class Profile_StepDefinitions {
    Profile_Page profilePage=new Profile_Page();
    Login_Page loginPage=new Login_Page();
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
    @And("the user adds a book")
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
//------------------------------------------------SCENARIO-4----------------------------------------------------
    @Given("the user is on the profile page as an other user and with those credentials {string} and {string}")
    public void theUserIsOnTheProfilePageAsAnOtherUserAndWithThoseCredentialsAnd(String username, String password) {
        Driver.getDriver().get(ConfigurationReader.getProperty("bookStoreUrl"));
        loginPage.clickLoginButtonInHomepage();
        loginPage.enterInputUsername(username);
        loginPage.enterInputPassword(password);
        loginPage.clickLoginButton();
        profilePage.clickProfileButton();
    }
    @When("the user clicks the delete account button")
    public void theUserClicksTheDeleteAccountButton() {
        profilePage.clickAccountDeleteButton();
    }
    @Then("the user sees a message {string}")
    public void theUserSeesAMessage(String message) {
        profilePage.verifyMessageForDeletingAccount(message);
    }
    @And("the user deletes the account by clicking ok")
    public void theUserDeletesTheAccountByClickingOk() {
        profilePage.clickOkButton();
        BrowserUtils.sleep(3);
        Alert alert=Driver.getDriver().switchTo().alert();
        alert.accept();
    }
    @And("the user can not login again with those credentials {string} and {string}")
    public void theUserCanNotLoginAgainWithThoseCredentialsAnd(String username, String password) {
        loginPage.enterInputUsername(username);
        loginPage.enterInputPassword(password);
        loginPage.clickLoginButton();
    }
    @And("the user sees {string}as an error message")
    public void theUserSeesAsAnErrorMessage(String message) {
        loginPage.verifyErrorMessage(message);
    }
}
