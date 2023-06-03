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

}
