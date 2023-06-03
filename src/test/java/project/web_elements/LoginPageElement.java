package project.web_elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageElement {

    public static WebElement element = null;

    public static WebElement usernameInputBox(WebDriver driver){
        element = driver.findElement(By.cssSelector("div:nth-child(1) input[type='text']"));
        return element;
    }

    public static WebElement loginForm(WebDriver driver){
       element = driver.findElement(By.cssSelector(".LoginForm_form__b4o6J"));
       return element;
    }

    public static WebElement passwordInputBox(WebDriver driver){
        element = driver.findElement(By.cssSelector("div:nth-child(2) input[type='password']"));
       return element;
    }
    public static WebElement passwordLabel(WebDriver driver){
        element = driver.findElement(By.cssSelector("label[for='password']"));
        return element;
    }
    public static WebElement userNameLabel(WebDriver driver){
        element = driver.findElement(By.cssSelector("label[for='username']"));
        return element;
    }
    public static WebElement forgotPassword(WebDriver driver){
        element = driver.findElement(By.xpath("//button[@id='login_btn']/../a"));
        return element;
    }
    public static WebElement login(WebDriver driver){
        element = driver.findElement(By.id("login_btn"));
        return element;
    }

    public static WebElement loggedIn(WebDriver driver){
        element = driver.findElement(By.id("success_lgn"));
        return element;
    }

    public static WebElement logout(WebDriver driver){
        element = driver.findElement(By.id("logout"));
        return element;
    }
    public static WebElement reset(WebDriver driver){
        element = driver.findElement(By.id("modal_title"));
        return element;
    }
    public static WebElement close(WebDriver driver){
        element = driver.findElement(By.id(".delete"));
        return element;
    }
    public static WebElement email(WebDriver driver){
        element = driver.findElement(By.id("email"));
        return element;
    }
    public static WebElement emailLabel(WebDriver driver){
        element = driver.findElement(By.id("label[for='email']"));
        return element;
    }
    public static WebElement submit(WebDriver driver){
        element = driver.findElement(By.id("submit"));
        return element;
    }
    public static WebElement resetModal(WebDriver driver){
        element = driver.findElement(By.id(".modal"));
        return element;
    }
    public static WebElement confirmationMessage(WebDriver driver) {
        element = driver.findElement(By.id("confirmation_message"));
        return element;
    }
    public static WebElement error(WebDriver driver) {
        element = driver.findElement(By.id("error_message"));
        return element;
    }
}
