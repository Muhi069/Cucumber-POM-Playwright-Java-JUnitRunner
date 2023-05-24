package com.pwc.glue;

import com.microsoft.playwright.Page;
import com.pages.LoginPage;
import com.qa.managers.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.SoftAssertions;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LoginSteps {
    Page page = DriverFactory.getPage();
    //getting base url from config file

    LoginPage loginPage= new LoginPage(page);



    @Given("User is on the login page")
    public void user_is_on_the_login_page() {
        loginPage.userOnLoginPage();

    }



    @When("user enters username {string}")
    public void user_enters_username(String username) {
        loginPage.enterEmail(username);

    }

    @When("user enters password {string}")
    public void user_enters_password(String password) {
        loginPage.enterPassword(password);
    }

    @When("user clicks on Login button")
    public void user_clicks_on_login_button() {
        loginPage.clickBtn();
    }

    @Then("user should see error message {string}")
    public void user_should_see_error_message(String expatErrMessage) {
        String err1= loginPage.getErrorNoUser();
        SoftAssertions softAssertions= new SoftAssertions();
        softAssertions.assertThat(expatErrMessage).contains(err1);

    }

    @Then("user should see error message as {string}")
    public void user_should_see_error_message_as(String expatErrMessage) {
        String err2= loginPage.invalidCred();
        SoftAssertions softAssertions= new SoftAssertions();
        softAssertions.assertThat(expatErrMessage).contains(err2);
    }

    @Then("page title should be {string}")
    public void page_title_should_be(String string) {
        String Title= page.title();
        SoftAssertions softAssertions= new SoftAssertions();
        softAssertions.assertThat(string).contains(Title);
    }

    @Then("user should see input error message as {string}")
    public void user_should_see_input_error_message_as(String string) {
        String err3= loginPage.noInputError();
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(string).contains(err3);
    }

}