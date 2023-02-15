@logout
Feature: As a user, I should be able to logout
  Background:
   Given the user already logs in
#------------------------------------------------SCENARIO-1-----------------------------------------------------
  Scenario: The user should be able to log out
    Then the user logs out by clicking log out button
#------------------------------------------------SCENARIO-2-----------------------------------------------------
  Scenario: The user should be able to log out by closing the tab
    When the user closes the tab without clicking log out button
    Then the user logs out
#------------------------------------------------SCENARIO-3----------------------------------------------------
  Scenario: The user should be able to log out by clicking the step back button
    When the user clicks the step back button
    Then the user logs out
