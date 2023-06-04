package project.web_elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Driver;

public class LoginPageElement {

    public static WebElement element = null;

    public static WebElement usernameInputBox(){
        return Driver.getDriver().findElement(By.cssSelector("div:nth-child(1) input[type='text']"));
    }

    public static WebElement loginForm(){
        return Driver.getDriver().findElement(By.cssSelector(".LoginForm_form__b4o6J"));
    }

    public static WebElement passwordInputBox(){
        return Driver.getDriver().findElement(By.cssSelector("div:nth-child(2) input[type='password']"));
    }
    public static WebElement passwordLabel( ){
        return Driver.getDriver().findElement(By.cssSelector("label[for='password']"));
    }
    public static WebElement userNameLabel( ){
        return Driver.getDriver().findElement(By.cssSelector("label[for='username']"));
    }
    public static WebElement forgotPassword(){
        return Driver.getDriver().findElement(By.xpath("//button[@id='login_btn']/../a"));

    }
    public static WebElement login(){
        return Driver.getDriver().findElement(By.id("login_btn"));
    }

    public static WebElement loggedIn(){
        return Driver.getDriver().findElement(By.id("success_lgn"));
    }

    public static WebElement logout(){
        return Driver.getDriver().findElement(By.id("logout"));
    }

    public static WebElement reset(){
        return Driver.getDriver().findElement(By.id("modal_title"));
    }
    public static WebElement close(){
        return Driver.getDriver().findElement(By.cssSelector(".delete"));
    }
    public static WebElement email(){
        return Driver.getDriver().findElement(By.id("email"));
    }

    public static WebElement emailLabel(){
       return Driver.getDriver().findElement(By.cssSelector("label[for='email']"));
    }

    public static WebElement submit(){
        return Driver.getDriver().findElement(By.id("submit"));
    }

    public static WebElement resetModal(){
        return Driver.getDriver().findElement(By.cssSelector(".modal"));
    }

    public static WebElement confirmationMessage() {
       return Driver.getDriver().findElement(By.id("confirmation_message"));
    }

    public static WebElement error() {
        return  Driver.getDriver().findElement(By.id("error_message"));
    }
}
