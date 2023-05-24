Feature: Login page feature


  Scenario: Login with valid Username and invalid password
    Given User is on the login page
    When user enters username "muti@gmail.com"
    And user enters password "1234567"
    And user clicks on Login button
    Then user should see error message "Login was unsuccessful. Please correct the errors and try again.The credentials provided are incorrect"

  Scenario: Login with incorrect credentials
    Given User is on the login page
    When user enters username "noname@gmail.com"
    And user enters password "123456123"
    And user clicks on Login button
    Then user should see error message "Login was unsuccessful. Please correct the errors and try again.No customer account found"


  Scenario: Login without giving any credentials
    Given User is on the login page
    When user enters username ""
    And user enters password ""
    And user clicks on Login button
    Then user should see input error message as "Please enter your email"

  Scenario: Login with wrong email in Email field
    Given User is on the login page
    When user enters username "hello@gmail.com"
    And user enters password "1234567"
    And user clicks on Login button
    Then user should see error message "Login was unsuccessful. Please correct the errors and try again.No customer account found"


  Scenario: Login with correct credentials
    Given User is on the login page
    When user enters username "muti@gmail.com"
    And user enters password "123456"
    And user clicks on Login button
    Then page title should be "Your store. Home page title"
