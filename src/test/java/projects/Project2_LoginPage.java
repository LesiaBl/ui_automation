package projects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
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
    @Test
    public void validateTheLoginForm(){
        WebElement usernameInputBox = driver.findElement(By.cssSelector("div:nth-child(1) input[type='text']"));
        Assert.assertTrue(usernameInputBox.isDisplayed());
        Assert.assertNull(usernameInputBox.getAttribute("required"));

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


}
