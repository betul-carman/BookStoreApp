Feature: As a user, I should be able to login so that I can access the main app features.
  Background:
    Given the user is on Login page

  Scenario Outline: User should be able to login with valid credentials and launch to the homepage.
    When the user enters valid "<username>" and "<password>"
    And the user clicks the login button
    Then the user is on the homepage
    Examples:
      |username   | password |
      |DavidBowie |Abc1234.# |
  @wip
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

  Scenario Outline: User should see “This field is required.” error message when they attempt to login without <"username"> and/or <"password">.
    When the user enters "<username>" and "<password>"
    And the user clicks the login button
    Then the user can not login
    And the user see the red border line for empty required fields
   Examples:
     |username |password|
     |  |  |

  #Scenerio Outline: When user drog and drop on the red line User should see “This field is required.” error message after attempting to login without <"username"> and/or <"password">