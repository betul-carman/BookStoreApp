Feature: As a user, I should be able to register
  Background:
    Given the user is on register page
#-----------------------------------------------SCENARIO-1------------------------------------------------------
  @register
  Scenario Outline: If the user tries to register an existing credentials then an error message should get displayed
    When the user try to register with the existing credentials "<First Name>", "<Last Name>", "<Username>", "<Password>"
    Then an error message "User exists!" gets displayed
    Examples:
      | First Name | Last Name | Username  | Password |
      | David      | Bowie     | DavidBowie| Abc1234.#|
#-----------------------------------------------SCENARIO-2------------------------------------------------------

  Scenario Outline: The user should not be able to register with any incomplete mandatory field
    When the user incompletely fills in the mandatory fields "<First Name>", "<Last Name>", "<Username>", "<Password>"
    Then the user can not register
    Examples:
      | First Name | Last Name | Username | Password |
      |  Bon       |  Jovi     | BonJovi  |          |
      |  Bon       |  Jovi     |          |          |
      |  Bon       |           |          |          |
#-----------------------------------------------SCENARIO-3------------------------------------------------------

  Scenario Outline: The user should not be able to register with invalid password
    When the user enters invalid password "<Password>" and valid other credentials "<First Name>", "<Last Name>", "<Username>"
    Then the user sees an error message "Passwords must have at least one non alphanumeric character, one digit ('0'-'9'), one uppercase ('A'-'Z'), one lowercase ('a'-'z'), one special character and Password must be eight characters or longer."
    Examples:
      | First Name | Last Name | Username | Password |
      |  Bon       |  Jovi     | BonJovi  |  Abc123. |
      |  Bon       |  Jovi     | BonJovi  |  abc123.#|
      |  Bon       |  Jovi     | BonJovi  |  123456.#|

#-----------------------------------------------SCENARIO-4-----------------------------------------------------

  Scenario: The user should always be able to go back to login page before registration
    When user clicks Back to login button
    Then user navigates to the login page

#-----------------------------------------------SCENARIO-5-----------------------------------------------------

  Scenario Outline: The user can not create an account before clicking "I am not robot" button
    When the user enters the valid credentials "<First Name>", "<Last Name>", "<Username>", "<Password>" in required fields
    Then the user can not register before clicking button(I am not robot) and sees an error message "Please verify reCaptcha to register!"
    Examples:
      | First Name | Last Name | Username | Password |
      |   Bon      | Jovi      | Bonjovi  | 1234Abc.#|
#-----------------------------------------------SCENARIO-6------------------------------------------------------
  Scenario Outline: The user should be able to create an account
    When the user enters the valid credentials "<First Name>", "<Last Name>", "<Username>", "<Password>" in required fields
    Then the user creates an account
    Examples:
      | First Name | Last Name | Username | Password |
      |   Bon      | Jovi      | Bonjovi  | 1234Abc.#|
