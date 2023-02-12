Feature: As a user, I should be able to organize my profile.
  Background:
    Given the user is on the profile page
#------------------------------------------------SCENARIO-1-----------------------------------------------------
  @profile
  Scenario: The user should be able to navigate to the book store page
    Then the user navigate to the book store page
#------------------------------------------------SCENARIO-2-----------------------------------------------------
  Scenario: The user should be able to delete a book from its own collection
    Given the user adds a book
    Then the user delete the added book
#------------------------------------------------SCENARIO-3-----------------------------------------------------
#------------------------------------------------SCENARIO-4-----------------------------------------------------