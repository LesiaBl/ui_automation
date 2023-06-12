package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.DropdownHandler;
import utils.Waiter;

import java.util.List;

public class _11_TGDropdownsTest extends Base{

    @BeforeMethod
    public void setPage(){
        driver.get("https://techglobal-training.com/frontend/dropdowns");
    }

    @Test
    public void validateSelectProductDropdown(){
        WebElement product = driver.findElement(By.id("product_dropdown"));
        DropdownHandler.selectByVisibleText(product,"iPhone 14 Pro Max");

        DropdownHandler.selectByValue(product,"Apple Watch Series 8");

    }
    @Test
    public void validateSelectColorDropdown(){
        Select color = new Select(driver.findElement(By.id("color_dropdown")));
        color.selectByValue("Green");
        Waiter.pause(2);

    }
    @Test
    public void validateSelectShipmentTypeDropdown(){
        WebElement selector = driver.findElement(By.id("shipment_dropdown"));
        List<WebElement> options = driver.findElements(By.cssSelector("span[role='option']"));
        DropdownHandler.clickDropdownOption(selector, options, "Pick up");
        Waiter.pause(2);
    }


    //Test Case: Validate Dropdowns Functionality on TechGlobal Training Page
    //Go to https://techglobal-training.com/frontend/
    //Click on the "Alerts" card
    //Select the "MacBook Pro 13" option from the "Product" dropdown.
    //Select the "Green" option from the "Color" dropdown.
    //Open the "Shipping" dropdown and click on the "c" option.
    //Click on the "Submit" button.
    //Validate result message displays "c"

    @Test
    public void validateDropdownsFunctionality(){
        WebElement product = driver.findElement(By.id("product_dropdown"));
        DropdownHandler.selectByVisibleText(product,"MacBook Pro 13");

        Select color = new Select(driver.findElement(By.id("color_dropdown")));
        color.selectByValue("Green");


        WebElement selector = driver.findElement(By.id("shipment_dropdown"));
        selector.click();
        List<WebElement> options = driver.findElements(By.cssSelector("span[role='option']"));
        options.get(0).click();

        driver.findElement(By.id("submit")).click();
        WebElement result = driver.findElement(By.cssSelector("#result"));

        Assert.assertTrue(result.isDisplayed());
        Assert.assertEquals(result.getText(),"Your Green MacBook Pro 13 will be delivered to you.");

        Waiter.pause(2);
    }
}
