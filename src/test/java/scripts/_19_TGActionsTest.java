package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.Waiter;

import java.util.List;

public class _19_TGActionsTest extends Base{
    @BeforeMethod
    public void setPage(){
        driver.get("https://techglobal-training.com/frontend");
        driver.findElement(By.id("card-15")).click();
        actions = new Actions(driver);
    }
    /**
     * TEST CASE 1
     * Go to https://techglobal-training.com/frontend/
     * Click on the "Actions" card
     * Verify that the user is redirected to the Actions page
     * Verify that the first three web elements are present and labeled as "Click on me", "Right-Click on me", and "Double-Click on me"
     * Perform a click action on the first web element labeled "Click on me"
     * Verify that a message appears next to the element stating, "You clicked on a button!"
     * Perform a right-click action on the second web element labeled "Right-Click on me"
     * Verify that the message appears next to the element stating, "You right-clicked on a button!"
     * Perform a double-click action on the third web element labeled "Double-Click on me"
     * Verify that the message appears next to the element stating, "You double-clicked on a button!"
     */

    @Test
    public void mouseActions(){
        Assert.assertEquals(driver.findElement(By.id("main_heading")).getText(), "Actions");
        List<WebElement> clickButtons = driver.findElements(By.cssSelector("button[id*='click']"));
        String [] text = {"Click on me", "Right-Click on me", "Double-Click on me"};
        for(int i = 0; i < text.length; i++){
            Assert.assertEquals(clickButtons.get(i).getText(), text[i]);
        }
        actions.moveToElement(driver.findElement(By.id("click"))).click().perform();
        Assert.assertTrue(driver.findElement(By.id("click_result")).isDisplayed());
        Assert.assertEquals(driver.findElement(By.id("click_result")).getText(),"You clicked on a button!");

        actions.moveToElement(driver.findElement(By.id("right-click"))).contextClick().perform();
        Assert.assertTrue(driver.findElement(By.id("right_click_result")).isDisplayed());
        Assert.assertEquals(driver.findElement(By.id("right_click_result")).getText(),"You right-clicked on a button!");


        actions.moveToElement(driver.findElement(By.id("double-click"))).doubleClick().perform();
        Assert.assertTrue(driver.findElement(By.id("double_click_result")).isDisplayed());
        Assert.assertEquals(driver.findElement(By.id("double_click_result")).getText(),"You double-clicked on a button!");


    }

    /**
     * TEST CASE 2
     * Go to https://techglobal-training.com/frontend/
     * Click on the "Actions" card
     * Verify that the last two web elements are present and labeled as "Drag Me", and "Drop Here",
     * Perform a Drag and Drop action on the "Drag Me" web element, and drop it to "Drop Here"
     * Verify that the first web element "Drag me" is successfully dropped into the second web element "Drop Here"
     * Verify that a message appears next to the web element stating, "An element dropped here!"
     */

    /**
     * TEST CASE 3
     * Go to https://techglobal-training.com/frontend/
     * Click on the "Actions" card
     * Go to the input box, and remove if there is an existing text inside
     * First, enter “h” to the input box in upper case using keyboard actions
     * Then complete the word by sending “ello” as a key
     * Validate value attribute of the input box is “Hello”
     *
     */
    @Test
    public void validateRightClickOnMe(){
        actions.moveToElement(driver.findElement(By.id("input_box"))).click().sendKeys(Keys.SHIFT, "H").sendKeys( "ello");
        Assert.assertEquals(driver.findElement(By.id("input_box")).getAttribute("value"),"Hello");
        Waiter.pause(5);
    }
}
