Feature: Login page feature
  Background:
    Given User is on the login page

  Scenario: Login with valid set of data

    When user enters username and password from given test data
    And User clicks the log in button
    Then User should see the Home Page title from given test data


  Scenario: Login with invalid set of data
    When user enters username and password from given test data
    And user clicks on Login button
    Then And User should see invalid credentials message from given test data


  Scenario: Login with no user exists data set
    When user enters username and password from given test data
    And user clicks on Login button
    Then  And User should see no user message from given test data