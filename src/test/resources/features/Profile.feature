@profile
Feature: As a user, I should be able to manage my profile.
  Background:
    Given the user is on the profile page
#------------------------------------------------SCENARIO-1-----------------------------------------------------
  Scenario: The user should be able to navigate to the book store page
    Then the user navigates to the book store page
#------------------------------------------------SCENARIO-2-----------------------------------------------------
  Scenario: The user should be able to log out
    Then the user logs out by clicking logout button
#------------------------------------------------SCENARIO-3-----------------------------------------------------
  Scenario: The user should be able to delete all books from its own collection
   Given the user adds a book
   Then the user sees an pop-up message "Do you want to delete all books?"
   And the user deletes all books
#------------------------------------------------SCENARIO-4-----------------------------------------------------