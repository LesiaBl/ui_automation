package scrips;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.Waiter;

public class TGUploud extends Base {
    @BeforeMethod
    public void setPage() {
        driver.get("https://techglobal-training.com/frontend");
        driver.findElement(By.id("card-13")).click();
    }

    @Test
    public void validateFileUpload1() {
        WebElement input = driver.findElement(By.id("file_upload"));

        input.sendKeys("script.js");
        WebElement button = driver.findElement(By.id("file_submit"));
        button.click();
        Waiter.pause(3);

    }

    /*
    TEST CASE
    Go to https://techglobal-training.com/frontend/
    Click on the "File Upload" card
    Send the path of the file as keys to the "Choose File" input box
    Click on the "UPLOAD" button
    Validate the result message equals "You Uploaded 'hello.txt'"
     */
    @Test
    public void validateFileUpload() {
        WebElement input = driver.findElement(By.id("file_upload"));


        String filePath = "/Users/lesiabiletska/IdeaProjects/ui_automation/hello.txt";
        input.sendKeys(filePath);
        WebElement button = driver.findElement(By.id("file_submit"));
        button.click();
        Waiter.pause(3);

        WebElement result = driver.findElement(By.id("result"));

        Assert.assertEquals(result.getText(),"You Uploaded '"+filePath.substring(filePath.lastIndexOf("/") + 1)+"'");
        Waiter.pause(5);
    }
}
