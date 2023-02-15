package com.demoQA.bookStoreApplication.step_Definitions;

import com.demoQA.bookStoreApplication.pages.BookStore_Page;
import com.demoQA.bookStoreApplication.pages.Book_Page;
import com.demoQA.bookStoreApplication.pages.Login_Page;
import com.demoQA.bookStoreApplication.utilities.ConfigurationReader;
import com.demoQA.bookStoreApplication.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class BookStore_StepDefinitions {
    Login_Page loginPage=new Login_Page();
    BookStore_Page bookStorePage=new BookStore_Page();
    Book_Page bookPage=new Book_Page();
    @Given("the user is on the Book Store Page")
    public void theUserIsOnTheBookStorePage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("bookStoreUrl"));
        loginPage.clickLoginButtonInHomepage();
        loginPage.enterInputUsername(ConfigurationReader.getProperty("username"));
        loginPage.enterInputPassword(ConfigurationReader.getProperty("password"));
        loginPage.clickLoginButton();
    }
//-------------------------------------------SCENARIO-1--------------------------------------------------------------
    @When("the user types a book name in the search box")
    public void theUserTypesABookNameInTheSearchBox() {
        bookStorePage.enterBookNameInSearchBox();
    }
    @And("the user clicks the search button")
    public void theUserClicksTheSearchButton() {
        bookStorePage.clickSearchBoxButton();
    }
    @Then("the user finds the searched book")
    public void theUserFindsTheSearchedBook() {
       bookStorePage.verifySearchingBook();
    }
//--------------------------------------------SCENARIO-2-------------------------------------------------------------
    @When("the user types an author name in the search box")
    public void theUserTypesAnAuthorNameInTheSearchBox() {
        bookStorePage.enterAuthorNameInSearchBox();
    }
    @Then("the user finds the searched author")
    public void theUserFindsTheSearchedAuthor() {
        bookStorePage.verifySearchingAuthorIsVisibleInThePage();
    }
//--------------------------------------------SCENARIO-3--------------------------------------------------------------
    @When("the user types some letters of a book {string} in the search box")
    public void theUserTypesSomeLettersOfABookInTheSearchBox(String letters) {
        bookStorePage.enterSomeLettersOfBook(letters);
    }
    @Then("the user sees the suggestions which contain written letters {string}")
    public void theUserSeesTheSuggestionsWhichContainWrittenLetters(String letters) {
        bookStorePage.verifyAutoSuggestion(letters);
    }
//-------------------------------------------SCENARIO-4--------------------------------------------------------------
   @When("the user types a book name which is not included in the repository")
   public void theUserTypesABookNameWhichIsNotIncludedInTheRepository() {
        bookStorePage.typeBookNameNotInRepository();
    }
    @Then("the user sees {string} message")
    public void theUserSeesMessage(String arg0) {
        bookStorePage.verifyNoRowsFoundMessage(arg0);
    }
//-------------------------------------------SCENARIO-5--------------------------------------------------------------
   @And("the user clicks on the searched book")
   public void theUserClicksOnTheSearchedBook() {
     bookStorePage.clickOnSearchingBook();
    }

    @Then("the user adds the searched book to its own collection by clicking on Add collection button")
    public void theUserAddsTheSearchedBookToItsOwnCollectionByClickingOnAddCollectionButton() {
        bookPage.clickAddToYourCollectionButton();
       bookPage.verifyAddToYourCollectionButton();
    }
//-------------------------------------------SCENARIO-6--------------------------------------------------------------
    @Given("the user is on the book page")
    public void theUserIsOnTheBookPage() {
        bookStorePage.enterBookNameInSearchBox();
        bookStorePage.clickOnSearchingBook();
    }
    @Then("the user clicks on the book link in the book page")
    public void theUserClicksOnTheBookLinkInTheBookPage() {
     bookPage.verifyLinkInBookPage();
    }
//-------------------------------------------SCENARIO-7------------------------------------------------------
    @Then("the user goes back the book store by clicking Back to book store button")
    public void theUserGoesBackTheBookStoreByClickingBackToBookStoreButton() {
        bookPage.clickBackToBookStoreButton();
        bookPage.verifyIsEnabledBackToBookStoreButton();
    }
}
