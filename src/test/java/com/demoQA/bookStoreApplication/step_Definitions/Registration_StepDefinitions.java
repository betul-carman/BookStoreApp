package com.demoQA.bookStoreApplication.step_Definitions;

import com.demoQA.bookStoreApplication.pages.Login_Page;
import com.demoQA.bookStoreApplication.pages.Profile_Page;
import com.demoQA.bookStoreApplication.pages.Registration_Page;
import com.demoQA.bookStoreApplication.utilities.ConfigurationReader;
import com.demoQA.bookStoreApplication.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class Registration_StepDefinitions {
    Login_Page loginPage=new Login_Page();
    Registration_Page registrationPage=new Registration_Page();
    Profile_Page profilePage=new Profile_Page();
    @Given("the user is on register page")
    public void theUserIsOnRegisterPage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("bookStoreUrl"));
        loginPage.clickLoginButton();
        loginPage.clickNewUserButton();
    }
   //-----------------------------------------------SCENARIO-1-------------------------------------------------
   @When("the user try to register with the existing credentials {string}, {string}, {string}, {string}")
   public void theUserTryToRegisterWithTheExistingCredentials(String firstName, String lastName, String username, String password) {
   registrationPage.enterFirstName(firstName);
   registrationPage.enterLastName(lastName);
   registrationPage.enterUsername(username);
   registrationPage.enterPassword(password);
   registrationPage.clickIamNotRobotButton();
   registrationPage.clickRegisterButton();
    }
    @Then("an error message {string} gets displayed")
    public void anErrorMessageGetsDisplayed(String arg0) {
        registrationPage.verifyMessageUserExist(arg0);
    }
    //-----------------------------------------------SCENARIO-2------------------------------------------------
    @When("the user incompletely fills in the mandatory fields {string}, {string}, {string}, {string}")
    public void theUserIncompletelyFillsInTheMandatoryFields(String firstName, String lastName, String username, String password) {
        registrationPage.enterFirstName(firstName);
        registrationPage.enterLastName(lastName);
        registrationPage.enterUsername(username);
        registrationPage.enterPassword(password);
        registrationPage.hitEnterButtonOfKeyboard();
    }
    @Then("the user can not register")
    public void theUserCanNotRegister() {
        registrationPage.verifyRegistrationIsNotCompleted();
    }
    //-----------------------------------------------SCENARIO-3------------------------------------------------
    @When("the user enters invalid password {string} and valid other credentials {string}, {string}, {string}")
    public void theUserEnterInvalidPasswordAndValidOtherCredentials(String firstName, String lastName, String username, String password) {
        registrationPage.enterFirstName(firstName);
        registrationPage.enterLastName(lastName);
        registrationPage.enterUsername(username);
        registrationPage.enterPassword(password);
        registrationPage.clickIamNotRobotButton();
        registrationPage.clickRegisterButton();
    }
    @Then("the user sees an error message {string}")
    public void theUserSeesAnErrorMessage(String arg0) {
        registrationPage.verifyErrorMessageForPassword(arg0);
    }
    //-----------------------------------------------SCENARIO-4-----------------------------------------------
    @When("user clicks Back to login button")
    public void userClicksBackToLoginButton() {
        registrationPage.clickBackTologinButton();
    }
    @Then("user navigates to the login page")
    public void userNavigatesToTheLoginPage() {
        registrationPage.verifyBackTologinButton();
    }
    //-----------------------------------------------SCENARIO-5-----------------------------------------------
    @When("the user enters the valid credentials {string}, {string}, {string}, {string} in required fields")
    public void theUserEntersTheValidCredentialsInRequiredFields(String firstName, String lastName, String username, String password) {
        registrationPage.enterFirstName(firstName);
        registrationPage.enterLastName(lastName);
        registrationPage.enterUsername(username);
        registrationPage.enterPassword(password);
        registrationPage.hitEnterButtonOfKeyboard();
    }
    @Then("the user can not register before clicking button\\(I am not robot) and sees an error message {string}")
    public void theUserCanNotRegisterBeforeClickingButtonIAmNotRobotAndSeesAnErrorMessage(String arg0) {
        registrationPage.verifyMessageForIamNotARobotButton(arg0);
    }
    //-----------------------------------------------SCENARIO-6-----------------------------------------------

}
