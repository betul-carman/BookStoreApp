Feature: As a user, I should be able to login so that I can access the main app features.

  Background:
    Given the user should be on Login page
  @wip
  Scenario Outline: User should be able to login with valid credentials and launch to the homepage.
    When the user enters valid "<username>" and "<password>"
    And the user clicks the login button
    Then the user is on the homepage
    Examples:
      |username   | password |
      |DavidBowie |Abc1234.# |
  Scenario Outline: User should be able to login with valid credentials by hitting the 'Enter' key of the keyboard
    When the user enters valid "<username>" and "<password>"
    And the user hits the enter key of the keyboard
    Then the user is on the homepage
    Examples:
      |username  | password |
      |DavidBowie|Abc1234.#|
  Scenario Outline: User should see "Invalid username or password!" error pop up message if any users try to login with invalid credentials.
    When the user enters invalid "<username>" or and "<password>"
    And the user clicks the login button
    Then the user sees "Invalid username or password!" error message
    Examples:
    |username  | password|
    |DavidBowie | Abc |
    |David | Abc1234.#|
    |David | Abc      |
  #Scenario Outline: Users should see “This field is required.” error pop up message when they attempt to login without <"username"> and/or <"password">.
   # Examples:
    #|username |password|
   # |  |  |
   # |DavidBowie| |
   # |  |Abc1234.#|