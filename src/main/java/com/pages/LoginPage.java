package com.pages;

import com.microsoft.playwright.Page;


public class LoginPage {
    private Page page;




    //constructor to initialize page
    public LoginPage(Page page) {
        this.page = page;
    }


    public String URL= "https://localhost:44369/login?returnUrl=%2F";
    public String HomePage_URL= "https://localhost:44369/";


    public
    String email= "id=Email";
    String pass= "id=Password";
    String btn= "type=submit";

    String errorInvalidCred= "class=message-error validation-summary-errors";

    String errorNoUser= "message-error validation-summary-errors";

    String noInput= "id=Email-error";





    /// 2. Methods ///


    public void enterEmail(String Email) {
        page.fill("//input[@id='Email']", Email);

    }

    public void enterPassword(String Pass) {
        page.fill("//input[@id='Password']", Pass);
    }

    public void clickBtn() {
        page.click("//button[normalize-space()='Log in']");
    }

    public String invalidCred() {
        return page.textContent("//div[@class='message-error validation-summary-errors']");
    }

    public String getErrorNoUser() {
        return page.textContent("//div[@class='message-error validation-summary-errors']");
    }

    public void userOnLoginPage() {
        page.navigate("https://localhost:44369/login?returnUrl=%2F");
    }

    public String noInputError() {
        return page.textContent("//span[@class='field-validation-error']");
    }



}
