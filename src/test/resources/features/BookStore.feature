Feature:The user should be able to use the functions on Book Store.
Background:
  Given the user is on the Book Store Page
#------------------------------------------------SCENARIO-1-----------------------------------------------------
Scenario: Verify that the user should be able to search a book in the search box
  When the user types a book name in the search box
  And the user clicks the search button
  Then the user finds the searched book
  #------------------------------------------------SCENARIO-2-----------------------------------------------------

  Scenario: Verify that the user should be able to search an author name in the search box
    When the user types an author name in the search box
    And the user clicks the search button
    Then the user finds the searched author
#------------------------------------------------SCENARIO-3-----------------------------------------------------
  @book
  Scenario: Verify that the auto-suggestion works in the search box
    When the user types some letters of a book in the search box
    Then the user sees the suggestions which contain written letters
#------------------------------------------------SCENARIO-4-----------------------------------------------------
  Scenario: Verify that user should be able to see "No rows found" message when typing a book name which is not included in the repository
    When the user types a book name which is not included in the repository
    Then the user sees "No rows found" message
#------------------------------------------------SCENARIO-5-----------------------------------------------------
  Scenario: Verify that the user should be able to add a book to its own collection
    When the user types a book name in the search box
    And the user clicks on the searched book
    Then the user adds the searched book to its own collection by clicking on Add collection button
#------------------------------------------------SCENARIO-6-----------------------------------------------------

  Scenario: Verify that the user should be able to see "Book added to your collection." as a message
    When the user types a book name in the search box
    And the user clicks on the searched book
    Then the user sees "Book added to your collection." as a message by clicking on Add collection button
#------------------------------------------------SCENARIO-7-----------------------------------------------------
  Scenario: Verify that the user should be able to open the book link in the book page
    Given the user is on the book page
    Then the user clicks on the book link in the book page
#------------------------------------------------SCENARIO-8-----------------------------------------------------
  Scenario: Verify that the user should be able to go back to the book store when the user is on the book page
    Given the user is on the book page
    Then the user goes back the book store by clicking Back to book store button








