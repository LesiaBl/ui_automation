package project.projects;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import project.web_elements.LoginPageElement;
import scrips.Base;

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
        Assert.assertTrue(LoginPageElement.usernameInputBox(driver).isDisplayed());
        Assert.assertNull( LoginPageElement.usernameInputBox(driver).getAttribute("required"));

        Assert.assertEquals(LoginPageElement.userNameLabel(driver).getText(), "Please enter your username");


        Assert.assertTrue(LoginPageElement.passwordInputBox(driver).isDisplayed());
        Assert.assertNull(LoginPageElement.passwordInputBox(driver).getAttribute("required"));

        Assert.assertEquals(LoginPageElement.passwordLabel(driver).getText(), "Please enter your password");

        Assert.assertTrue(LoginPageElement.login(driver).isDisplayed());
        Assert.assertTrue(LoginPageElement.login(driver).isEnabled());
        Assert.assertEquals(LoginPageElement.login(driver).getText(),"LOGIN");

        Assert.assertTrue(LoginPageElement.forgotPassword(driver).isDisplayed());
        Assert.assertTrue(LoginPageElement.forgotPassword(driver).isEnabled());
        Assert.assertEquals(LoginPageElement.forgotPassword(driver).getText(),"Forgot Password?");
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
        LoginPageElement.usernameInputBox(driver).sendKeys("TechGlobal");
        LoginPageElement.passwordInputBox(driver).sendKeys("Test1234");

        LoginPageElement.login(driver).click();


        Assert.assertTrue(LoginPageElement.loggedIn(driver).isDisplayed());
        Assert.assertTrue(LoginPageElement.logout(driver).isDisplayed());
        Assert.assertEquals(LoginPageElement.loggedIn(driver).getText(),"You are logged in");
        Assert.assertEquals(LoginPageElement.logout(driver).getText(),"LOGOUT");
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
        LoginPageElement.usernameInputBox(driver).sendKeys("TechGlobal");

        LoginPageElement.passwordInputBox(driver).sendKeys("Test1234");

        LoginPageElement.login(driver).click();
        LoginPageElement.logout(driver).click();

        Assert.assertTrue(LoginPageElement.loginForm(driver).isDisplayed());
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
        LoginPageElement.forgotPassword(driver).click();

        Assert.assertTrue(LoginPageElement.reset(driver).isDisplayed());
        Assert.assertTrue(LoginPageElement.close(driver).isDisplayed());

        Assert.assertTrue(LoginPageElement.email(driver).isDisplayed());

        Assert.assertEquals(LoginPageElement.emailLabel(driver).getText(),"Enter your email address and we'll send you a link to reset your password.");

         Assert.assertTrue(LoginPageElement.submit(driver).isDisplayed());
         Assert.assertTrue(LoginPageElement.submit(driver).isEnabled());
         Assert.assertEquals(LoginPageElement.submit(driver).getText(),"SUBMIT");
        }
        //Test Case 05 - Validate the Reset Password modal close button
        //Navigate to https://techglobal-training.com/frontend/project-2
        //Click on the “Forgot Password?” link
        //Validate that the “Reset Password” modal is displayed
        //Click on the close button
        //Validate that the “Reset Password” modal is closed

    @Test(priority = 5)
    public void validateCloseButton(){
        LoginPageElement.forgotPassword(driver).click();


        Assert.assertTrue(LoginPageElement.resetModal(driver).isDisplayed());

        LoginPageElement.close(driver).click();

        Assert.assertTrue(LoginPageElement.loginForm(driver).isDisplayed());

    }
    //Test Case 06 - Validate the Reset Password form submission
    //Navigate to https://techglobal-training.com/frontend/project-2
    //Click on the “Forgot Password?” link
    //Enter an email
    //Click on the “SUBMIT” button
    //Validate the form message “A link to reset your password has been sent to your email address.” is displayed under the “SUBMIT” button

    @Test(priority = 6)
    public void validateResetPasswordFormSubmission(){
        LoginPageElement.forgotPassword(driver).click();

        LoginPageElement.email(driver).sendKeys("a@a.a");
        LoginPageElement.submit(driver).click();

        Assert.assertEquals(LoginPageElement.confirmationMessage(driver).getText(), "A link to reset your password has been sent to your email address.");
    }
    //Test Case 07 - Validate the invalid login with the empty credentials
    //Navigate to https://techglobal-training.com/frontend/project-2
    //Leave username empty
    //Leave password empty
    //Click on the “LOGIN” button
    //Validate the failure message is displayed as “Invalid Username entered!” above the form

    @Test(priority = 7)
    public  void validateInvalidLogin(){
        LoginPageElement.login(driver).click();
        Assert.assertEquals(LoginPageElement.error(driver).getText(),"Invalid Username entered!");
    }

    //Test Case 08 - Validate the invalid login with the wrong username
    //Navigate to https://techglobal-training.com/frontend/project-2
    //Enter the username as “John”
    //Enter the password as “Test1234”
    //Click on the “LOGIN” button
    //Validate the failure message is displayed as “Invalid Username entered!” above the form

    @Test(priority = 8)
    public void validateLoginWithWrongUsername(){
        LoginPageElement.usernameInputBox(driver).sendKeys("John");
        LoginPageElement.passwordInputBox(driver).sendKeys("Test1234");
        LoginPageElement.login(driver).click();
        Assert.assertEquals(LoginPageElement.error(driver).getText(),"Invalid Username entered!");
    }

    //Test Case 09 - Validate the invalid login with the wrong password
    //Navigate to https://techglobal-training.com/frontend/project-2
    //Enter the username as “TechGlobal”
    //Enter the password as “1234”
    //Click on the “LOGIN” button
    //Validate the failure message is displayed as “Invalid Password entered!” above the form

    @Test(priority = 9)
    public void validateInvalidPassword(){
        LoginPageElement.usernameInputBox(driver).sendKeys("TechGlobal");
        LoginPageElement.passwordInputBox(driver).sendKeys("1234");

         LoginPageElement.login(driver).click();

        Assert.assertEquals(LoginPageElement.error(driver).getText(),"Invalid Username entered!");

    }

    //Test Case 10 - Validate the invalid login with the wrong username and password
    //Navigate to https://techglobal-training.com/frontend/project-2
    //Enter the username as “John”
    //Enter the password as “1234”
    //Click on the “LOGIN” button
    //Validate the failure message is displayed as “Invalid Username entered!” above the form

    @Test(priority = 10)
    public void validateInvalidInput(){
        LoginPageElement.usernameInputBox(driver).sendKeys("John");

        LoginPageElement.usernameInputBox(driver).sendKeys("TechGlobal");

        LoginPageElement.login(driver).click();
        Assert.assertEquals(LoginPageElement.error(driver).getText(),"Invalid Username entered!");


    }
}
