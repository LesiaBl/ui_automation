package project.projects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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

        WebElement usernameLabel = driver.findElement(By.cssSelector("label[for='username']"));
        Assert.assertEquals(usernameLabel.getText(), "Please enter your username");


        WebElement passwordInputBox = driver.findElement(By.cssSelector("div:nth-child(2) input[type='password']"));
        Assert.assertTrue(passwordInputBox.isDisplayed());
        Assert.assertNull(passwordInputBox.getAttribute("required"));

        WebElement passwordLabel = driver.findElement(By.cssSelector("label[for='password']"));
        Assert.assertEquals(passwordLabel.getText(), "Please enter your password");

        WebElement login = driver.findElement(By.id("login_btn"));
        Assert.assertTrue(login.isDisplayed());
        Assert.assertTrue(login.isEnabled());
        Assert.assertEquals(login.getText(),"LOGIN");

        WebElement forgotPassword = driver.findElement(By.xpath("//button[@id='login_btn']/../a"));
        Assert.assertTrue(forgotPassword.isDisplayed());
        Assert.assertTrue(forgotPassword.isEnabled());
        Assert.assertEquals(forgotPassword.getText(),"Forgot Password?");
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
        WebElement usernameInputBox = driver.findElement(By.cssSelector("div:nth-child(1) input[type='text']"));
        usernameInputBox.sendKeys("TechGlobal");

        WebElement passwordInputBox = driver.findElement(By.cssSelector("div:nth-child(2) input[type='password']"));
        passwordInputBox.sendKeys("Test1234");

        WebElement login = driver.findElement(By.id("login_btn"));
        login.click();

        WebElement loggedIn = driver.findElement(By.id("success_lgn"));
        WebElement logout = driver.findElement(By.id("logout"));

        Assert.assertTrue(loggedIn.isDisplayed());
        Assert.assertTrue(logout.isDisplayed());
        Assert.assertEquals(loggedIn.getText(),"You are logged in");
        Assert.assertEquals(logout.getText(),"LOGOUT");
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
        WebElement usernameInputBox = driver.findElement(By.cssSelector("div:nth-child(1) input[type='text']"));
        usernameInputBox.sendKeys("TechGlobal");

        WebElement passwordInputBox = driver.findElement(By.cssSelector("div:nth-child(2) input[type='password']"));
        passwordInputBox.sendKeys("Test1234");

        WebElement login = driver.findElement(By.id("login_btn"));
        login.click();
        WebElement logout = driver.findElement(By.id("logout"));
        logout.click();

        WebElement loginForm = driver.findElement(By.cssSelector(".LoginForm_form__b4o6J"));
        Assert.assertTrue(loginForm.isDisplayed());
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
        WebElement forgotPassword = driver.findElement(By.xpath("//button[@id='login_btn']/../a"));
        forgotPassword.click();

        WebElement reset = driver.findElement(By.id("modal_title"));
        Assert.assertTrue(reset.isDisplayed());

        WebElement close = driver.findElement(By.cssSelector(".delete"));
        Assert.assertTrue(close.isDisplayed());

        WebElement email =driver.findElement(By.id("email"));
        Assert.assertTrue(email.isDisplayed());

        WebElement label = driver.findElement(By.cssSelector("label[for='email']"));
        Assert.assertEquals(label.getText(),"Enter your email address and we'll send you a link to reset your password.");

         WebElement submit = driver.findElement(By.id("submit"));
         Assert.assertTrue(submit.isDisplayed());
         Assert.assertTrue(submit.isEnabled());
         Assert.assertEquals(submit.getText(),"SUBMIT");
        }
        //Test Case 05 - Validate the Reset Password modal close button
        //Navigate to https://techglobal-training.com/frontend/project-2
        //Click on the “Forgot Password?” link
        //Validate that the “Reset Password” modal is displayed
        //Click on the close button
        //Validate that the “Reset Password” modal is closed

    @Test(priority = 5)
    public void validateCloseButton(){
        WebElement forgotPassword = driver.findElement(By.xpath("//button[@id='login_btn']/../a"));
        forgotPassword.click();

        WebElement resetModal = driver.findElement(By.cssSelector(".modal"));
        Assert.assertTrue(resetModal.isDisplayed());

        WebElement close = driver.findElement(By.cssSelector(".delete"));
        close.click();
        boolean modal =resetModal.isDisplayed();

        Assert.assertTrue(modal);
    }
    //Test Case 06 - Validate the Reset Password form submission
    //Navigate to https://techglobal-training.com/frontend/project-2
    //Click on the “Forgot Password?” link
    //Enter an email
    //Click on the “SUBMIT” button
    //Validate the form message “A link to reset your password has been sent to your email address.” is displayed under the “SUBMIT” button

    @Test(priority = 6)
    public void validateResetPasswordFormSubmission(){
        WebElement forgotPassword = driver.findElement(By.xpath("//button[@id='login_btn']/../a"));
        forgotPassword.click();

        WebElement email =driver.findElement(By.id("email"));
        email.sendKeys("a@a.a");

        WebElement submit = driver.findElement(By.id("submit"));
        submit.click();

        WebElement confirmationMessage = driver.findElement(By.id("confirmation_message"));
        Assert.assertEquals(confirmationMessage.getText(), "A link to reset your password has been sent to your email address.");
    }
    //Test Case 07 - Validate the invalid login with the empty credentials
    //Navigate to https://techglobal-training.com/frontend/project-2
    //Leave username empty
    //Leave password empty
    //Click on the “LOGIN” button
    //Validate the failure message is displayed as “Invalid Username entered!” above the form

    @Test(priority = 7)
    public  void validateInvalidLogin(){
        WebElement login = driver.findElement(By.id("login_btn"));
        login.click();

        WebElement error = driver.findElement(By.id("error_message"));
        Assert.assertEquals(error.getText(),"Invalid Username entered!");
    }

    //Test Case 08 - Validate the invalid login with the wrong username
    //Navigate to https://techglobal-training.com/frontend/project-2
    //Enter the username as “John”
    //Enter the password as “Test1234”
    //Click on the “LOGIN” button
    //Validate the failure message is displayed as “Invalid Username entered!” above the form

    @Test(priority = 8)
    public void validateLoginWithWrongUsername(){
        WebElement usernameInputBox = driver.findElement(By.cssSelector("div:nth-child(1) input[type='text']"));
        usernameInputBox.sendKeys("John");

        WebElement passwordInputBox = driver.findElement(By.cssSelector("div:nth-child(2) input[type='password']"));
        passwordInputBox.sendKeys("Test1234");

        WebElement login = driver.findElement(By.id("login_btn"));
        login.click();

        WebElement error = driver.findElement(By.id("error_message"));
        Assert.assertEquals(error.getText(),"Invalid Username entered!");
    }

    //Test Case 09 - Validate the invalid login with the wrong password
    //Navigate to https://techglobal-training.com/frontend/project-2
    //Enter the username as “TechGlobal”
    //Enter the password as “1234”
    //Click on the “LOGIN” button
    //Validate the failure message is displayed as “Invalid Password entered!” above the form

    @Test(priority = 9)
    public void validateInvalidPassword(){
        WebElement usernameInputBox = driver.findElement(By.cssSelector("div:nth-child(1) input[type='text']"));
        usernameInputBox.sendKeys("TechGlobal");

        WebElement passwordInputBox = driver.findElement(By.cssSelector("div:nth-child(2) input[type='password']"));
        passwordInputBox.sendKeys("1234");

        WebElement login = driver.findElement(By.id("login_btn"));
        login.click();

        WebElement error = driver.findElement(By.id("error_message"));
        Assert.assertEquals(error.getText(),"Invalid Username entered!");
    }

    //Test Case 10 - Validate the invalid login with the wrong username and password
    //Navigate to https://techglobal-training.com/frontend/project-2
    //Enter the username as “John”
    //Enter the password as “1234”
    //Click on the “LOGIN” button
    //Validate the failure message is displayed as “Invalid Username entered!” above the form

    @Test(priority = 10)
    public void validateInvalidInput(){
        WebElement usernameInputBox = driver.findElement(By.cssSelector("div:nth-child(1) input[type='text']"));
        usernameInputBox.sendKeys("John");

        WebElement passwordInputBox = driver.findElement(By.cssSelector("div:nth-child(2) input[type='password']"));
        passwordInputBox.sendKeys("1234");

        WebElement login = driver.findElement(By.id("login_btn"));
        login.click();

        WebElement error = driver.findElement(By.id("error_message"));
        Assert.assertEquals(error.getText(),"Invalid Username entered!");

    }
}
