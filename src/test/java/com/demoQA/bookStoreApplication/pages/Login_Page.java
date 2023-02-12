package com.demoQA.bookStoreApplication.pages;

import com.demoQA.bookStoreApplication.utilities.BrowserUtils;
import com.demoQA.bookStoreApplication.utilities.ConfigurationReader;
import com.demoQA.bookStoreApplication.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login_Page extends Base_Page {
    //--------------------------------------------------LOCATORS--------------------------------------------------------
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

    //---------------------------------------------------METHODS--------------------------------------------------------
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
    public void verifyErrorMessage(String expectedResult){
        String actualResult= errorMessage.getText();
        Assert.assertEquals(expectedResult,actualResult);
    }
    public void verifyUnableToLoginWithoutAnyCredentials(){
        String actualResult= Driver.getDriver().getCurrentUrl();
        String expectedResult= "https://demoqa.com/login";
        Assert.assertEquals(expectedResult,actualResult);
    }
    /*public void verifyRedBorderLineForError(){
        String expectRGB []={"220,53,69"};
        String actualRGB []=inputPassword.getCssValue("border-bottom-color").replaceAll("(rgba)|(rgb)|(\\()|(\\s)|(\\))","").split(",");
        Assert.assertArrayEquals(expectRGB,actualRGB);
        //String actual=toBrowserHexValue(3);
        //String expected="#DC3545";

    }
    public String toBrowserHexValue(int number) {
        String rgb[]=inputUsername.getCssValue("border-bottom-color").replaceAll("(rgba)|(rgb)|(\\()|(\\s)|(\\))","").split(",");
        String hex = String.format("#%s%s%s", toBrowserHexValue(Integer.parseInt(rgb[0])), toBrowserHexValue(Integer.parseInt(rgb[1])), toBrowserHexValue(Integer.parseInt(rgb[2])));
        StringBuilder builder = new StringBuilder(Integer.toHexString(number & 0xff));
        while (builder.length() < 2) {
            builder.append("0");
        }
        return builder.toString().toUpperCase();
    }*/



}
