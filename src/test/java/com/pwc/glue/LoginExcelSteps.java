package com.pwc.glue;

import com.microsoft.playwright.Page;
import com.pages.LoginPage;
import com.qa.managers.DriverFactory;
import com.qa.managers.FileReaderManager;
import com.qa.util.Xls_Reader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;

public class LoginExcelSteps {

    Page page = DriverFactory.getPage();
    //getting base url from config file
    final String baseUrl = FileReaderManager.getInstance().getConfigReader().getBaseUrl();
    LoginPage loginPage= new LoginPage(page);
    Xls_Reader reader = new Xls_Reader("src/test/resources/config/testData/loginData.xlsx");
    String sheetName = "Login";
    SoftAssertions softAssertions;


//    @Given("User is on the login page")
//    public void user_is_on_the_login_page() {
//        loginPage.userOnLoginPage();
//    }


    @When("user enters username and password from given test data")
    public void user_enters_username_and_password_from_given_test_data() {
        loginPage.enterEmail(reader.getCellData(sheetName, "email", 4));
        loginPage.enterPassword(reader.getCellData(sheetName, "password", 4));

    }

    @When("User clicks the log in button")
    public void user_clicks_the_log_in_button() {
        loginPage.clickBtn();
    }

    @Then("User should see the Home Page title from given test data")
    public void user_should_see_the_home_page_title_from_given_test_data() {
        String correct= reader.getCellData(sheetName, "message", 0);
        if(correct == "valid") {
            softAssertions.assertThat(correct).contains(loginPage.Title());
            softAssertions.assertAll();

        }
    }


    @Then("And User should see invalid credentials message from given test data")
    public void and_user_should_see_invalid_credentials_message_from_given_test_data() {
        String invalidCred= reader.getCellData(sheetName, "message", 3);
        if(invalidCred == "invalid") {
            softAssertions.assertThat(invalidCred).contains(loginPage.invalidCred());
            softAssertions.assertAll();
        }
    }


    @Then("And User should see no user message from given test data")
    public void and_user_should_see_no_user_message_from_given_test_data() {
        String noUser= reader.getCellData(sheetName, "message", 4);
        if(noUser == "noUser") {
            softAssertions.assertThat(noUser).contains(loginPage.getErrorNoUser());
            softAssertions.assertAll();
        }
    }

}
