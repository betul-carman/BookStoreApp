package com.demoQA.bookStoreApplication.step_Definitions;

import com.demoQA.bookStoreApplication.pages.Login_Page;
import com.demoQA.bookStoreApplication.utilities.BrowserUtils;
import com.demoQA.bookStoreApplication.utilities.ConfigurationReader;
import com.demoQA.bookStoreApplication.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

public class Login_StepDefinitions {
    Actions action=new Actions(Driver.getDriver());
    Login_Page loginPage=new Login_Page();
    @Given("the user should be on Login page")
    public void theUserShouldBeOnLoginPage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("bookStoreUrl"));
        loginPage.clickLoginButtonInHomepage();
    }
    @When("the user enters valid {string} and {string}")
    public void theUserEntersValidAnd(String arg0, String arg1) {
        loginPage.enterInputUsername(arg0);
        loginPage.enterInputPassword(arg1);
    }
    @And("the user clicks the login button")
    public void theUserClicksTheLoginButton() {
        loginPage.clickLoginButton();
    }
    @Then("the user is on the homepage")
    public void theUserIsOnTheHomepage() {
        loginPage.verifyLoginFunctionality();
        loginPage.verifyTitle();
    }
    @And("the user hits the enter key of the keyboard")
    public void theUserHitsTheEnterKeyOfTheKeyboard() {
        loginPage.hitEnterButtonOfKeyboard();
    }
    @When("the user enters invalid {string} or and {string}")
    public void theUserEntersInvalidOrAnd(String arg0, String arg1) {
        loginPage.enterInputUsername(arg0);
        loginPage.enterInputPassword(arg1);
    }
    @Then("the user sees {string} error message")
    public void theUserSeesErrorMessage(String arg0) {
        loginPage.verifyErrorMessage(arg0);
    }



}
