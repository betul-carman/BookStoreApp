package com.demoQA.bookStoreApplication.pages;

import com.demoQA.bookStoreApplication.utilities.BrowserUtils;
import com.demoQA.bookStoreApplication.utilities.ConfigurationReader;
import com.demoQA.bookStoreApplication.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login_Page extends Base_Page {
    //----------------------------------------LOCATORS---------------------------------------------
    @FindBy(xpath = "//button[@id='login']")
    private WebElement loginButtonInHomepage;
    @FindBy(xpath = "//input[@id=\"userName\"]")
    private WebElement inputUsername;
    @FindBy(xpath = "//input[@id=\"password\"]")
    private WebElement inputPassword;
    @FindBy(xpath = "//button[.=\"Login\"]")
    private WebElement loginButton;
    @FindBy(xpath = "//p[.=\"Invalid username or password!\"]")
    private WebElement errorMessage;

    //--------------------------------------------METHODS------------------------------------------
    public void clickLoginButtonInHomepage(){
        loginButtonInHomepage.click();}
    public void enterInputUsername(String username){
        inputUsername.sendKeys(username);
    }
    public void enterInputPassword(String password) {
        inputPassword.sendKeys(password);
    }
    public void clickLoginButton(){
        loginButton.click();
    }
    public void hitEnterButtonOfKeyboard(){
        inputPassword.sendKeys(Keys.ENTER);
    }
    public void verifyLoginFunctionality(){
        BrowserUtils.sleep(3);
        String actualResult= Driver.getDriver().getCurrentUrl();
        String expectedResult= ConfigurationReader.getProperty("bookStoreUrl");
        Assert.assertEquals(expectedResult,actualResult);
    }
    public void verifyTitle(){
        String actualResult=Driver.getDriver().getTitle();
        String expectedResult="DEMOQA";
        Assert.assertEquals(expectedResult,actualResult);
    }
    public void verifyErrorMessage(String string){
        String actualResult= errorMessage.getText();
        String expectedResult=string;
        Assert.assertEquals(expectedResult,actualResult);
    }


}
