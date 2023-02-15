package com.demoQA.bookStoreApplication.utilities;

import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class BrowserUtils {
    public static void sleep(int second) {
        second *= 1000;
        try {
            Thread.sleep(second);
        } catch (InterruptedException e) {

        }
    }
    public static boolean assertWebElementNotPresent(WebElement webElement){
        try {
            Driver.getDriver().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            webElement.getText();
            return false;
        } catch (Exception ignored) {
            return true;
        }
    }

}
