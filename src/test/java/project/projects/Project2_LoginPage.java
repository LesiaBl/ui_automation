package project.projects;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import project.web_elements.LoginPageElement;
import scrips.Base;
import utils.Driver;

import java.util.NoSuchElementException;

public class Project2_LoginPage extends Base {
    @BeforeMethod
    public void setPage(){
        driver.get("https://techglobal-training.com/frontend/project-2");
    }

    //Test Case 01 - Validate the login form
    //Navigate to https://techglobal-training.com/frontend/project-2
    //Validate that the username input box is displayed
    //Validate that the username input box is not required
    //Validate that the label of the username input box is “Please enter your username”
    //Validate that the password input box is displayed
    //Validate that the password input box is not required
    //Validate that the label of the password input box is “Please enter your password”
    //Validate the “LOGIN” button is displayed
    //Validate the “LOGIN” button is clickable
    //Validate that the button text is “LOGIN”
    //Validate the “Forgot Password?” link is displayed
    //Validate that the “Forgot Password?” link is clickable
    //Validate that the link text is “Forgot Password?”
    @Test(priority = 1)
    public void validateTheLoginForm(){
        Assert.assertTrue(LoginPageElement.usernameInputBox().isDisplayed());
        Assert.assertNull( LoginPageElement.usernameInputBox().getAttribute("required"));

        Assert.assertEquals(LoginPageElement.userNameLabel().getText(), "Please enter your username");


        Assert.assertTrue(LoginPageElement.passwordInputBox().isDisplayed());
        Assert.assertNull(LoginPageElement.passwordInputBox().getAttribute("required"));

        Assert.assertEquals(LoginPageElement.passwordLabel().getText(), "Please enter your password");

        Assert.assertTrue(LoginPageElement.login().isDisplayed());
        Assert.assertTrue(LoginPageElement.login().isEnabled());
        Assert.assertEquals(LoginPageElement.login().getText(),"LOGIN");

        Assert.assertTrue(LoginPageElement.forgotPassword().isDisplayed());
        Assert.assertTrue(LoginPageElement.forgotPassword().isEnabled());
        Assert.assertEquals(LoginPageElement.forgotPassword().getText(),"Forgot Password?");
    }

    //Test Case 02 - Validate the valid login
    //Navigate to https://techglobal-training.com/frontend/project-2
    //Enter the username as “TechGlobal”
    //Enter the password as “Test1234”
    //Click on the “LOGIN” button
    //Validate the success message is displayed as “You are logged in”
    //Validate the logout button displayed with the text “LOGOUT”

    @Test(priority = 2)
    public void validateTheValidLogin(){

//page object model
        LoginPageElement.usernameInputBox().sendKeys("TechGlobal");
        LoginPageElement.passwordInputBox().sendKeys("Test1234");

        LoginPageElement.login().click();


        Assert.assertTrue(LoginPageElement.loggedIn().isDisplayed());
        Assert.assertTrue(LoginPageElement.logout().isDisplayed());
        Assert.assertEquals(LoginPageElement.loggedIn().getText(),"You are logged in");
        Assert.assertEquals(LoginPageElement.logout().getText(),"LOGOUT");
    }

    //Test Case 03 - Validate the logout
    //Navigate to https://techglobal-training.com/frontend/project-2
    //Enter the username as “TechGlobal”
    //Enter the password as “Test1234”
    //Click on the “LOGIN” button
    //Click on the “LOGOUT” button
    //Validate that the login form is displayed
    @Test(priority = 3)
    public void validateLogout(){
        LoginPageElement.usernameInputBox().sendKeys("TechGlobal");

        LoginPageElement.passwordInputBox().sendKeys("Test1234");

        LoginPageElement.login().click();
        LoginPageElement.logout().click();

        Assert.assertTrue(LoginPageElement.loginForm().isDisplayed());
    }
    //Test Case 04 - Validate the Forgot Password? Link and Reset Password modal
    //Navigate to https://techglobal-training.com/frontend/project-2
    //Click on the “Forgot Password?” link
    //Validate that the modal heading “Reset Password” is displayed
    //Validate that the close button is displayed
    //Validate that the email input box is displayed
    //Validate that the label of the email input box is “Enter your email address and we'll send you a link to reset your password.”
    //Validate the “SUBMIT” button is displayed
    //Validate the “SUBMIT” button is clickable
    //Validate that the button text is “SUBMIT”

      @Test(priority = 4)
    public void validateForgotPassword(){
        LoginPageElement.forgotPassword().click();

        Assert.assertTrue(LoginPageElement.reset().isDisplayed());
        Assert.assertTrue(LoginPageElement.close().isDisplayed());

        Assert.assertTrue(LoginPageElement.email().isDisplayed());

        Assert.assertEquals(LoginPageElement.emailLabel().getText(),"Enter your email address and we'll send you a link to reset your password.");

         Assert.assertTrue(LoginPageElement.submit().isDisplayed());
         Assert.assertTrue(LoginPageElement.submit().isEnabled());
         Assert.assertEquals(LoginPageElement.submit().getText(),"SUBMIT");
        }

        //Test Case 05 - Validate the Reset Password modal close button
        //Navigate to https://techglobal-training.com/frontend/project-2
        //Click on the “Forgot Password?” link
        //Validate that the “Reset Password” modal is displayed
        //Click on the close button
        //Validate that the “Reset Password” modal is closed

    @Test(priority = 5)
    public void validateCloseButton(){

            LoginPageElement.forgotPassword().click();
            Assert.assertTrue(LoginPageElement.resetModal().isDisplayed());
            LoginPageElement.close().click();

        Assert.assertFalse(isModalDisplayed());

    }
    public boolean isModalDisplayed() {
        try {
            return Driver.getDriver().findElement(By.cssSelector(".modal")).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }


    //Test Case 06 - Validate the Reset Password form submission
    //Navigate to https://techglobal-training.com/frontend/project-2
    //Click on the “Forgot Password?” link
    //Enter an email
    //Click on the “SUBMIT” button
    //Validate the form message “A link to reset your password has been sent to your email address.” is displayed under the “SUBMIT” button

    @Test(priority = 6)
    public void validateResetPasswordFormSubmission(){
        LoginPageElement.forgotPassword().click();

        LoginPageElement.email().sendKeys("a@a.a");
        LoginPageElement.submit().click();

        Assert.assertEquals(LoginPageElement.confirmationMessage().getText(), "A link to reset your password has been sent to your email address.");
    }
    //Test Case 07 - Validate the invalid login with the empty credentials
    //Navigate to https://techglobal-training.com/frontend/project-2
    //Leave username empty
    //Leave password empty
    //Click on the “LOGIN” button
    //Validate the failure message is displayed as “Invalid Username entered!” above the form

    @Test(priority = 7)
    public  void validateInvalidLogin(){
        LoginPageElement.login().click();
        Assert.assertEquals(LoginPageElement.error().getText(),"Invalid Username entered!");
    }

    //Test Case 08 - Validate the invalid login with the wrong username
    //Navigate to https://techglobal-training.com/frontend/project-2
    //Enter the username as “John”
    //Enter the password as “Test1234”
    //Click on the “LOGIN” button
    //Validate the failure message is displayed as “Invalid Username entered!” above the form

    @Test(priority = 8)
    public void validateLoginWithWrongUsername(){
        LoginPageElement.usernameInputBox().sendKeys("John");
        LoginPageElement.passwordInputBox().sendKeys("Test1234");
        LoginPageElement.login().click();
        Assert.assertEquals(LoginPageElement.error().getText(),"Invalid Username entered!");
    }

    //Test Case 09 - Validate the invalid login with the wrong password
    //Navigate to https://techglobal-training.com/frontend/project-2
    //Enter the username as “TechGlobal”
    //Enter the password as “1234”
    //Click on the “LOGIN” button
    //Validate the failure message is displayed as “Invalid Password entered!” above the form

    @Test(priority = 9)
    public void validateInvalidPassword(){
        LoginPageElement.usernameInputBox().sendKeys("TechGlobal");
        LoginPageElement.passwordInputBox().sendKeys("1234");

         LoginPageElement.login().click();

        Assert.assertEquals(LoginPageElement.error().getText(),"Invalid Password entered!");

    }

    //Test Case 10 - Validate the invalid login with the wrong username and password
    //Navigate to https://techglobal-training.com/frontend/project-2
    //Enter the username as “John”
    //Enter the password as “1234”
    //Click on the “LOGIN” button
    //Validate the failure message is displayed as “Invalid Username entered!” above the form

    @Test(priority = 10)
    public void validateInvalidInput(){
        LoginPageElement.usernameInputBox().sendKeys("John");

        LoginPageElement.usernameInputBox().sendKeys("TechGlobal");

        LoginPageElement.login().click();
        Assert.assertEquals(LoginPageElement.error().getText(),"Invalid Username entered!");


    }
}
