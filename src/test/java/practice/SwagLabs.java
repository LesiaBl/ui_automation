package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import scrips.Base;

public class SwagLabs extends Base {

    @BeforeMethod
    public void setPage(){
        driver.get("https://www.saucedemo.com/");
    }
    @Test
    public void validateSwagLabsLoginPage(){
        WebElement logo = driver.findElement(By.cssSelector(".login_logo"));
            Assert.assertTrue(logo.isDisplayed());
            Assert.assertEquals(logo.getText(), "Swag Labs");

        WebElement username = driver.findElement(By.cssSelector("input[data-test='username']"));
             Assert.assertTrue(username.isDisplayed());
             Assert.assertTrue(username.isEnabled());
             Assert.assertEquals(username.getAttribute("placeholder"),"Username");
             username.click();
             username.sendKeys("standard_user");

        WebElement password = driver.findElement(By.cssSelector("input[data-test='password'"));
            Assert.assertTrue(password.isDisplayed());
            Assert.assertTrue(password.isEnabled());
            Assert.assertEquals(password.getAttribute("placeholder"),"Password");
            password.click();
            password.sendKeys("secret_sauce");

        WebElement login = driver.findElement(By.cssSelector("input[data-test='login-button']"));
            Assert.assertTrue(login.isDisplayed());
            Assert.assertTrue(login.isEnabled());
            Assert.assertEquals(login.getAttribute("value"), "Login");

            login.submit();

            Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/inventory.html");

            WebElement add = driver.findElement(By.cssSelector("button#add-to-cart-sauce-labs-backpack"));

            Assert.assertTrue(add.isDisplayed());
            Assert.assertEquals(add.getText(),"Add to cart");
            add.click();
            WebElement remove = driver.findElement(By.cssSelector("button#remove-sauce-labs-backpack"));

        Assert.assertEquals(remove.getText(),"Remove");


    }
}
