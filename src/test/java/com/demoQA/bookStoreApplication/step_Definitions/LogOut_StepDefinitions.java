package com.demoQA.bookStoreApplication.step_Definitions;

import com.demoQA.bookStoreApplication.pages.BookStore_Page;
import com.demoQA.bookStoreApplication.pages.Login_Page;
import com.demoQA.bookStoreApplication.utilities.ConfigurationReader;
import com.demoQA.bookStoreApplication.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LogOut_StepDefinitions {
    Login_Page loginPage=new Login_Page();
    BookStore_Page bookStorePage=new BookStore_Page();
    @Given("the user already logs in")
    public void theUserAlreadyLogsIn() {
        Driver.getDriver().get(ConfigurationReader.getProperty("bookStoreUrl"));
        loginPage.clickLoginButtonInHomepage();
        loginPage.enterInputUsername(ConfigurationReader.getProperty("username"));
        loginPage.enterInputPassword(ConfigurationReader.getProperty("password"));
        loginPage.clickLoginButton();
    }
//-----------------------------------------------SCENARIO-1-------------------------------------------------
    @Then("the user logs out by clicking log out button")
    public void theUserLogsOutByClickingLogOutButton() {
        bookStorePage.clickLogOutButton();
        bookStorePage.verifyLoggedOut();
    }
//-----------------------------------------------SCENARIO-2-------------------------------------------------
    @When("the user closes the tab without clicking log out button")
    public void theUserClosesTheTabWithoutClickingLogOutButton() {
        Driver.closeDriver();
    }
    @Then("the user logs out")
    public void theUserLogsOut() {
        Driver.getDriver().get(ConfigurationReader.getProperty("bookStoreUrl"));
        bookStorePage.verifyLoggedOut();
    }
//-----------------------------------------------SCENARIO-3------------------------------------------------
    @When("the user clicks the step back button")
    public void theUserClicksTheStepBackButton() {
        Driver.getDriver().navigate().back();
        bookStorePage.verifyLoggedOut();
    }
}
