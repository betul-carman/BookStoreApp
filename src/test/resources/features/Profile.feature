@profile
Feature: As a user, I should be able to manage my profile.
#------------------------------------------------SCENARIO-1-----------------------------------------------------
  Scenario: The user should be able to navigate to the book store page
    Given the user is on the profile page
    Then the user navigates to the book store page
#------------------------------------------------SCENARIO-2-----------------------------------------------------
  Scenario: The user should be able to log out
    Given the user is on the profile page
    Then the user logs out by clicking logout button
#------------------------------------------------SCENARIO-3-----------------------------------------------------
  Scenario: The user should be able to delete all books from its own collection
   Given the user is on the profile page
   And the user adds a book
   Then the user sees an pop-up message "Do you want to delete all books?"
   And the user deletes all books
#------------------------------------------------SCENARIO-4-----------------------------------------------------
  Scenario: The user should be able delete the account
    Given the user is on the profile page as an other user and with those credentials "BonJovi" and "1234ABn.@"
    When the user clicks the delete account button
    Then the user sees a message "Do you want to delete your account?"
    And the user deletes the account by clicking ok
    And the user can not login again with those credentials "BonJovi" and "1234ABn.@"
    And the user sees "Invalid username or password!"as an error message
