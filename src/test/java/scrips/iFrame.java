package scrips;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class iFrame extends Base {

    @BeforeMethod
    public void setPage(){
        driver.get("https://techglobal-training.com/frontend/iframes");
    }

    /*TEST CASE
    Go to https://techglobal-training.com/frontend/iframes
    Validate the "Please fill out your information below" paragraph
     */

    @Test(priority = 1, description = "TC123: Validate the IFrame Page content paragraph")
    public void validateTheParagraph(){
        //WebElement iframe = driver.findElement(By.id("form_frame"));
        //driver.switchTo().frame(iframe);

        //driver.switchTo().frame(0);

        driver.switchTo().frame("form_frame");

        WebElement paragraph = driver.findElement(By.cssSelector("#name_form>p"));
        Assert.assertTrue(paragraph.isDisplayed());
        Assert.assertEquals(paragraph.getText(), "Please fill out your information below");

    }

    @Test(priority = 2, description = "")
    public void validateResult(){
        driver.switchTo().frame("form_frame");
        WebElement firstName = driver.findElement(By.id("first_name"));
        firstName.sendKeys("John");

        WebElement lastName = driver.findElement(By.id("last_name"));
        lastName.sendKeys("Doe");

        WebElement submit = driver.findElement(By.id("submit"));

        submit.submit();

        driver.switchTo().parentFrame();

        WebElement result = driver.findElement(By.id("result"));

        Assert.assertTrue(result.isDisplayed());
        Assert.assertEquals(result.getText(), "You entered: John Doe");

    }

}
