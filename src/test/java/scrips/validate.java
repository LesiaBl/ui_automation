package scrips;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.IntStream;

public class validate extends Base {
    /*
    05/23/2023 - Handling dynamic elemens & Waits
<p id="05_123"></p>
XPATH WAY
//p[@id='element']
//p[contains(@id, 'element')]
//p[starts-with(@id, 'element')]
//p[ends-with(@id, 'element')]
CSS WAY
p[id^='element'] // starts with
p[id*='element'] // contains
p[id$='element'] // ends with





6:18
TEST CASE 1
Go to https://techglobal-training.com/frontend/
Click on the "Dynamic Elements" card
Validate both boxes are displayed with the below texts
Box 1
     */
    @BeforeMethod

    public void setPage(){
        driver.get("https://techglobal-training.com/frontend/");
        driver.findElement(By.id("card-3")).click();
    }




    @Test
    public void validateBoxes(){

        WebElement box1 = driver.findElement(By.cssSelector("p[id^='box_1_']"));

        WebElement box2 = driver.findElement(By.cssSelector("p[id^='box_2_']"));

        Assert.assertTrue(box1.isDisplayed());
        Assert.assertTrue(box2.isDisplayed());

        Assert.assertEquals(box1.getText(), "Box 1");
        Assert.assertEquals(box2.getText(), "Box 2");
    }


    @Test
    public void validateBoxesList(){

        List <WebElement> boxes = driver.findElements(By.cssSelector("p[id*='box_']"));
        String[] expectedText = {"Box 1", "Box 2"};

        for (int i = 0; i < expectedText.length; i++) {
            Assert.assertTrue(boxes.get(i).isDisplayed());
            Assert.assertEquals(boxes.get(i).getText(), expectedText[i]);

        }
    }
}
