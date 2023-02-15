package com.demoQA.bookStoreApplication.pages;

import com.demoQA.bookStoreApplication.utilities.BrowserUtils;
import com.demoQA.bookStoreApplication.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Registration_Page extends Base_Page{

//-----------------------------------------------LOCATORS-------------------------------------------------------
@FindBy(xpath = "//*[@id=\"firstname\"]")
    private WebElement firstNameInputBox;
@FindBy(xpath = "//*[@id=\"lastname\"]")
    private WebElement lastNameInputBox;
@FindBy(xpath = "//*[@id=\"userName\"]")
    private WebElement usernameInputBox;
@FindBy(xpath = "//*[@id=\"password\"]")
    private WebElement passwordInputBox;
@FindBy(id= "rc-anchor-container")
    private WebElement IamNotARobotButton;
@FindBy(xpath = "//p[@id=\"name\"]")
   private WebElement messageForIamNotARobotButton;
@FindBy(xpath = "//*[@id=\"gotologin\"]")
    private WebElement backToLoginButton;
@FindBy(xpath = "//button[@id=\"register\"]")
    private WebElement registerButton;
@FindBy(xpath = "//p[.=\"User exists!\"]")
    private WebElement messageUserExists;
@FindBy(xpath= "//iframe[@title='reCAPTCHA']")
    private WebElement iframe;
@FindBy(xpath = "//p[@id=\"name\"]")
private WebElement errorMessageForPassword;
//-----------------------------------------------METHODS-------------------------------------------------------
public void hitEnterButtonOfKeyboard(){
    passwordInputBox.sendKeys(Keys.ENTER);
}
    public void clickBackTologinButton(){
    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
    BrowserUtils.sleep(3);
    js.executeScript("arguments[0].scrollIntoView(true)", backToLoginButton);
    backToLoginButton.click();
    }
    public void verifyBackTologinButton(){
    String expectedURL="https://demoqa.com/login";
    String actualURL=Driver.getDriver().getCurrentUrl();
    Assert.assertEquals(expectedURL,actualURL);
    }
    public void enterFirstName(String firstName){
    firstNameInputBox.sendKeys(firstName);
}
    public void enterLastName(String lastName){
        lastNameInputBox.sendKeys(lastName);
    }
    public void enterUsername(String username){
        usernameInputBox.sendKeys(username);
    }
    public void enterPassword(String password){
        passwordInputBox.sendKeys(password);
    }
    public void clickIamNotRobotButton(){
    Driver.getDriver().switchTo().frame(iframe);
    IamNotARobotButton.click();
    Driver.getDriver().switchTo().parentFrame();
    }
    public void clickRegisterButton(){
    BrowserUtils.sleep(3);
    registerButton.click();
    }
    public void verifyMessageUserExist(String expectedMessage){
    String actualMessage=messageUserExists.getText();
    Assert.assertEquals(expectedMessage,actualMessage);
    }
    public void verifyRegistrationIsNotCompleted(){
    String expectedURL="https://demoqa.com/register";
    String actualURL=Driver.getDriver().getCurrentUrl();
    Assert.assertEquals(expectedURL,actualURL);
    }
    public void verifyErrorMessageForPassword(String expectedMessage){
    String actualMessage=errorMessageForPassword.getText();
    Assert.assertEquals(expectedMessage,actualMessage);
    }
    public void verifyMessageForIamNotARobotButton(String expectedMessage){
    String actualMessage=messageForIamNotARobotButton.getText();
    Assert.assertEquals(expectedMessage,actualMessage);
    }
}
