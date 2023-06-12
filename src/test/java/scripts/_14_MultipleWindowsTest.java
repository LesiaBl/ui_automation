package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.Waiter;
import utils.WindowHandler;

import java.util.List;


public class _14_MultipleWindowsTest extends Base {
    @BeforeMethod
    public void setPage(){
        driver.get("https://techglobal-training.com/frontend");
        driver.findElement(By.id("card-10")).click();
    }


    @Test(priority = 1)
    public void validateMultipleWindows() {

        WebElement apple = driver.findElement(By.id("apple"));
        apple.click();

        WindowHandler.switchToChildWindow();

        WebElement logo = driver.findElement(By.cssSelector("a[aria-label='Apple']"));

        Assert.assertTrue(logo.isDisplayed());

      //  driver.switchTo().window(mainWindow);
      //  Waiter.pause(5);
    }
    @Test(priority = 2, description = "TC322 Validate the Microsoft navigation")
    public void validateMicrosoft() {

        WebElement microsoft = driver.findElement(By.id("microsoft"));
        microsoft.click();

        WindowHandler.switchToChildWindow();
        Assert.assertTrue(driver.getCurrentUrl().contains("microsoft"));


    }

    @Test(priority = 3, description = "TC322 Validate the Tesla navigation")
    public void validateTesla() {
        WebElement tesla = driver.findElement(By.id("tesla"));
        tesla.click();
        WindowHandler.switchToChildWindow();

        Assert.assertEquals(driver.getTitle(),"Electric Cars, Solar & Clean Energy | Tesla");

        WindowHandler.switchToMainWindow();

        Assert.assertTrue(driver.getCurrentUrl().contains("techglobal"));

        WebElement heading = driver.findElement(By.id("main_heading"));

        Assert.assertTrue(heading.isDisplayed());
        Assert.assertEquals(heading.getText(),"Multiple Windows");

    }
 /*
    TEST CASE
    Go to https://techglobal-training.com/frontend
    Click on "Multiple Windows" card
    Validate the links "Apple", "Microsoft" and "Tesla" navigates user to
    "https://www.apple.com/", "https://www.microsoft.com/en-us/", "https://www.tesla.com/"
     */

    @Test(priority = 4, description = "Validate link URLs")
    public void validateTheLinkURLs(){
        List<WebElement> links = driver.findElements(By.cssSelector(".MultipleWindows_link__JB372"));
        String[] expectedURLs = {"https://www.apple.com/", "https://www.microsoft.com/en-us/", "https://www.tesla.com/"};

        for (int i = 0; i < 3; i++) {
            links.get(i).click();
            WindowHandler.switchToChildWindow();
            Assert.assertEquals(driver.getCurrentUrl(), expectedURLs[i]);
            driver.close();
            WindowHandler.switchToMainWindow();
            Waiter.pause(2);
        }
    }

    @Test
    public void validateLinks(){

        List<WebElement> links = driver.findElements(By.cssSelector("ul a"));
        String[] linksURL = {"https://www.apple.com/", "https://www.microsoft.com/", "https://www.tesla.com/"};

        for (int i = 0; i < linksURL.length; i++) {
            Assert.assertEquals(links.get(i).getAttribute("href"), linksURL[i]);
        }
    }
}
