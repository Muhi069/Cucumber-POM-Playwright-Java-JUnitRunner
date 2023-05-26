Feature: Registration feature
  Background:
    Given User is on registration page


  Scenario: Unable to register with First name field empty
    Given User fills Last name field "Hasan"
    * User fills Email field "customer12@yourstore.com"
    * User fills Password field "admin1234"
    * User fills Confirm Password filed "admin1234"
    When User keeps the First name field empty ""
    And User clicks Registration button
    Then User should see First Name required message "First name is required."


  Scenario: Unable to register with Last name field empty
    Given User fills First name field "Mutasim"
    * User fills Email field "customer12@yourstore.com"
    * User fills Password field "admin1234"
    * User fills Confirm Password filed "admin1234"
    When User keeps the Last name field empty ""
    And User clicks Registration button
    Then User should see Last Name required message "Last name is required."



  Scenario: Unable to register with Email field empty
    Given User fills First name field "Mutasim"
    * User fills Last name field "Hasan"
    * User fills Password field "admin1234"
    * User fills Confirm Password filed "admin1234"
    When User keeps the Email field empty ""
    And User clicks Registration button
    Then User should see Email required message "Email is required."



  Scenario: Unable to register with Password field empty
    Given User fills First name field "Mutasim"
    * User fills Last name field "Hasan"
    * User fills Email field "customer12@yourstore.com"
    * User fills Confirm Password filed "admin1234"
    When User keeps the Password field empty ""
    And User clicks Registration button
    Then User should see 1st warning message "Password is required."
    And User should see 2nd warning message "The password and confirmation password do not match."



  Scenario: Unable to register with Confirm Password field empty
    Given User fills First name field "Mutasim"
    * User fills Last name field "Hasan"
    * User fills Email field "customer12@yourstore.com"
    * User fills Password filed "admin1234"
    When User keeps the Confirm Password field empty ""
    And User clicks Registration button
    Then User should see Password required message "Password is required."



  Scenario: Unable to register with mismatched password
    Given User fills First name field "Mutasim"
    * User fills Last name field "Hasan"
    * User fills Email field "customer12@yourstore.com"
    * User fills Password filed "admin1234"
    * User fills Confirm Password filed "admin2345"
    When User clicks Registration button
    Then User should see mismatched password message "The password and confirmation password do not match."



  Scenario: Unable to register with invalid Email
    Given User fills First name field "Mutasim"
    * User fills Last name field "Hasan"
    * User fills Email field "customer1.yourStore.com"
    * User fills Password filed "admin1234"
    * User fills Confirm Password filed "admin234"
    When User clicks Registration button
    Then User should see invalid email message "Wrong email"



  Scenario: Unable to register with invalid length of password
    Given User fills First name field "Mutasim"
    * User fills Last name field "Hasan"
    * User fills Email field "customer12@yourstore.com"
    * User fills Password filed "admin"
    * User fills Confirm Password filed "admin"
    When User clicks Registration button
    Then User should see invalid password length message "must meet the following rules:must have at least 6 characters"



  Scenario: Unable to register with existing email address
    Given User fills First name field "Mutasim"
    * User fills Last name field "Hasan"
    * User fills Email field "admin@yourStore.com"
    * User fills Password filed "admin1234"
    * User fills Confirm Password filed "admin1234"
    When User clicks Registration button
    Then User should see email already exists message "The specified email already exists"




#  Scenario: Register with Valid data
#    Given User fills First name field "Mutasim"
#    * User fills Last name field "Hasan"
#    * User fills Email field "customer11213@yourStore.com"
#    * User fills Password filed "admin1234"
#    * User fills Confirm Password filed "admin1234"
#    When User clicks Registration button
#    Then User should see confirmation message "Your registration completed"