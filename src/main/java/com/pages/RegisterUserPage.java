package com.pages;

import com.microsoft.playwright.Page;


public class RegisterUserPage {

    private Page page;




    //constructor to initialize page
    public RegisterUserPage(Page page) {
        this.page = page;
    }

    public String REG_URL= "https://localhost:44369/register?returnUrl=%2F";


    //////////////*** Locators ***////////////
//    public By FIRST_NAME= By.xpath("//input[@id='FirstName']");
//    public By LAST_NAME= By.xpath("//input[@id='LastName']");
//    public By EMAIL= By.xpath("//input[@id='Email']");
//    public By PASSWORD= By.xpath("//input[@id='Password']");
//    public By CONFIRM_PASSWORD= By.xpath("//input[@id='ConfirmPassword']");
//    public By REG_BTN= By.xpath("//button[@id='register-button']");
//    public By firstNameError= By.xpath("//span[@id='FirstName-error']");
//    public By lastNameError= By.xpath("//span[@id='LastName-error']");
//    public By emailError1= By.xpath("//span[@id='Email-error']"); //email required
//    public By emailError2= By.xpath("//span[@id='Email-error']"); //invalid mail format
//    public By emailError3= By.xpath("//*[text()=\"The specified email already exists\"]"); //existing mail
//    public By passError1= By.xpath("//span[@class='field-validation-error']"); //pass length error
//    public By passError2= By.xpath("//span[@id='Password-error']"); //password required
//    public By passError3= By.xpath("//span[@id='ConfirmPassword-error']"); // password doesn't match
//    public By confirmPassError= By.xpath("//span[@id='ConfirmPassword-error']");
//    public By Confirmation_msg= By.xpath("//div[@class='result']");




    ///////////////***Methods***//////////////

    public void enterFirstName(String firstName) {
        page.fill("//input[@id='FirstName']", firstName);

    }

    public void enterLastName(String lastName) {
        page.fill("//input[@id='LastName']", lastName);

    }

    public void enterEmail(String email) {
        page.fill("//input[@id='Email']", email);
    }


    public void enterPassword(String passWord) {
        page.fill("//input[@id='Password']", passWord);
    }


    public void enterConfirmPass(String ConfirmPass) {
        page.fill("//input[@id='ConfirmPassword']", ConfirmPass);
    }



    public void clickRegBtn() {
        page.click("//button[@id='register-button']");
    }

    // empty frstname //
    public String FirstNameError() {
        return page.textContent("//span[@id='FirstName-error']");
    }

    // empty lastname //
    public String LastNameError() {
        return page.textContent("//span[@id='LastName-error']");
    }

    // empty mail //
    public String EmailError1() {
        return page.textContent("//span[@class='field-validation-error']");
    }


    // invalid mail format //
    public String EmailError2() {
        return page.textContent("//span[@id='Email-error']");
    }

    // existing email //
    public String EmailError3() {
        return page.textContent("//*[text()=\"The specified email already exists\"]");
    }

    //invalid password length //
    public String PassError1() {
        return page.textContent("//span[@class='field-validation-error']");
    }

    // error for empty pass field //
    public String PassError2() {
        return page.textContent("//span[@id='Password-error']");
    }

    // error for empty pass field //
    public String PassError3() {
        return page.textContent("//span[@id='ConfirmPassword-error']");
    }

    // pass: admin1234, conf_pass: admin12345 //
    public String PassError4() {
        return page.textContent("//span[@id='ConfirmPassword-error']");
    }

    // confirm pass empty //
    public String PassError5() {
        return page.textContent("//span[@id='ConfirmPassword-error']");
    }

    // confirm register //
    public String ConfirmReg() {
        return page.textContent("//div[@class='result']");
    }

    public void userOnRegPage() {
        page.navigate("https://localhost:44369/register?returnUrl=%2F");
    }

    public String emptyConfPass() {
        return page.textContent("//span[@class='field-validation-error']");
    }

}
