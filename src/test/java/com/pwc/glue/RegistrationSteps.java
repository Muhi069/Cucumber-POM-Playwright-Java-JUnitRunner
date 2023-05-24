package com.pwc.glue;

import com.microsoft.playwright.Page;
import com.pages.LoginPage;
import com.pages.RegisterUserPage;
import com.qa.managers.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.SoftAssertions;

public class RegistrationSteps {

    Page page = DriverFactory.getPage();
    //getting base url from config file

    SoftAssertions softAssertions= new SoftAssertions();

    RegisterUserPage registerUserPage= new RegisterUserPage(page);


    @Given("User is on registration page")
    public void user_is_on_registration_page() {
        registerUserPage.userOnRegPage();
    }

    @Given("User fills Last name field {string}")
    public void user_fills_last_name_field(String string) {
        registerUserPage.enterLastName(string);
    }

    @Given("User fills Email field {string}")
    public void user_fills_email_field(String string) {
        registerUserPage.enterEmail(string);
    }

    @Given("User fills Password field {string}")
    public void user_fills_password_field(String string) {
        registerUserPage.enterPassword(string);
    }

    @Given("User fills Confirm Password filed {string}")
    public void user_fills_confirm_password_filed(String string) {
        registerUserPage.enterConfirmPass(string);
    }

    /// confusion with the empty field methods ///
    @When("User keeps the First name field empty {string}")
    public void user_keeps_the_first_name_field_empty(String string) {
        registerUserPage.enterFirstName(string);
    }

    @When("User clicks Registration button")
    public void user_clicks_registration_button() {
        registerUserPage.clickRegBtn();
    }

    @Then("User should see First Name required message {string}")
    public void user_should_see_first_name_required_message(String string) {
        String fnameReq= registerUserPage.FirstNameError();
        softAssertions.assertThat(string).contains(fnameReq);
    }

    @Given("User fills First name field {string}")
    public void user_fills_first_name_field(String string) {
        registerUserPage.enterFirstName(string);
    }

    @When("User keeps the Last name field empty {string}")
    public void user_keeps_the_last_name_field_empty(String string) {
       registerUserPage.enterLastName(string);
    }

    @Then("User should see Last Name required message {string}")
    public void user_should_see_last_name_required_message(String string) {
        String lNameReq= registerUserPage.LastNameError();
        softAssertions.assertThat(string).contains(lNameReq);
    }

    @When("User keeps the Email field empty {string}")
    public void user_keeps_the_email_field_empty(String string) {
        registerUserPage.enterEmail(string);
    }

    @Then("User should see Email required message {string}")
    public void user_should_see_email_required_message(String string) {
        String mailReq= registerUserPage.EmailError1();
        softAssertions.assertThat(string).contains(mailReq);
    }

    @When("User keeps the Password field empty {string}")
    public void user_keeps_the_password_field_empty(String string) {
        registerUserPage.enterPassword(string);
    }

    @Then("User should see 1st warning message {string}")
    public void user_should_see_1st_warning_message(String string) {
        String firstWarn= registerUserPage.PassError2();
        softAssertions.assertThat(string).contains(firstWarn);
    }

    @Then("User should see 2nd warning message {string}")
    public void user_should_see_2nd_warning_message(String string) {
        String secondWarn= registerUserPage.PassError3();
        softAssertions.assertThat(string).contains(secondWarn);
    }

    @Given("User fills Password filed {string}")
    public void user_fills_password_filed(String string) {
        registerUserPage.enterPassword(string);
    }

    @When("User keeps the Confirm Password field empty {string}")
    public void user_keeps_the_confirm_password_field_empty(String string) {
        registerUserPage.enterConfirmPass(string);
    }

    @Then("User should see Password required message {string}")
    public void user_should_see_password_required_message(String string) {
        String passReq= registerUserPage.emptyConfPass();
        softAssertions.assertThat(string).contains(passReq);
    }

    @Then("User should see mismatched password message {string}")
    public void user_should_see_mismatched_password_message(String string) {
        String misMatchedPass= registerUserPage.PassError4();
        softAssertions.assertThat(string).contains(misMatchedPass);
    }

    @Then("User should see invalid email message {string}")
    public void user_should_see_invalid_email_message(String string) {
        String invalidMailFormat= registerUserPage.EmailError2();
        softAssertions.assertThat(string).contains(invalidMailFormat);
    }

    @Then("User should see invalid password length message {string}")
    public void user_should_see_invalid_password_length_message(String string) {
        String invalidPassLen= registerUserPage.PassError1();
        softAssertions.assertThat(string).contains(invalidPassLen);
    }

    @Then("User should see email already exists message {string}")
    public void user_should_see_email_already_exists_message(String string) {
//        String errorText = registerUserPage.EmailError3();
        String mailExists= registerUserPage.EmailError3();
        softAssertions.assertThat(string).contains(mailExists);

    }

    @Then("User should see confirmation message {string}")
    public void user_should_see_confirmation_message(String string) {
//        String errOr= registerUserPage.ConfirmReg();
        String confirmReg= registerUserPage.ConfirmReg();
        softAssertions.assertThat(string).contains(confirmReg);

    }

}
