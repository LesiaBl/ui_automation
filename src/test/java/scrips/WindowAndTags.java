package scrips;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.WindowHandler;


public class WindowAndTags extends Base {
    @BeforeMethod
    public void setPage(){
        driver.get("https://techglobal-training.com/frontend");
        driver.findElement(By.id("card-10")).click();
    }


    @Test(priority = 1)
    public void validateMultipleWindows() {

        WebElement apple = driver.findElement(By.id("apple"));
        apple.click();

        WindowHandler.switchToSecondWindow();

        WebElement logo = driver.findElement(By.cssSelector("a[aria-label='Apple']"));

        Assert.assertTrue(logo.isDisplayed());

      //  driver.switchTo().window(mainWindow);
      //  Waiter.pause(5);
    }
    @Test(priority = 2, description = "TC322 Validate the Microsoft navigation")
    public void validateMicrosoft() {

        WebElement apple = driver.findElement(By.id("microsoft"));
        apple.click();

        WindowHandler.switchToSecondWindow();
        Assert.assertTrue(driver.getCurrentUrl().contains("microsoft"));


    }

    @Test(priority = 3, description = "TC322 Validate the Tesla navigation")
    public void validateTesla() {
        WebElement tesla = driver.findElement(By.id("tesla"));
        tesla.click();
        WindowHandler.switchToSecondWindow();

        Assert.assertEquals(driver.getTitle(),"Electric Cars, Solar & Clean Energy | Tesla");

        WindowHandler.switchToMainWindow();

        Assert.assertTrue(driver.getCurrentUrl().contains("techglobal"));

        WebElement heading = driver.findElement(By.id("main_heading"));

        Assert.assertTrue(heading.isDisplayed());
        Assert.assertEquals(heading.getText(),"Multiple Windows");

    }
}