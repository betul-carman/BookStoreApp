package com.demoQA.bookStoreApplication.pages;

import com.demoQA.bookStoreApplication.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class Base_Page {
    public Base_Page() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

}
