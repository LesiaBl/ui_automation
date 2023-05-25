package scrips;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.annotation.Tainted;
import java.util.List;

public class CheckBox  extends Base{
    /**
     * Go to https://techglobal-training.com/frontend/
     * Click on the "Checkboxes" card
     * Validate "Apple" and "Microsoft" checkboxes are displayed, enabled, and not selected
     * Select both and validate they are both selected
     * Deselect both and validate they are deselected

     */


    @BeforeMethod
    public void setPage(){
        driver.get("https://techglobal-training.com/frontend/");
        driver.findElement(By.id("card-7")).click();
    }

    @Test
    public void validateCheckbox(){
        List<WebElement>  checkboxes = driver.findElements(By.cssSelector("#checkbox-button-group_1 label"));
        String[] elementsText = {"Apple","Microsoft"};

        List<WebElement> checkBoxesSelected = driver.findElements(By.cssSelector("#checkbox-button-group_1 label>input"));

        for (int i = 0; i < 2; i++) {
                //to check if checkboxes  is displayed we use  LABEL
            Assert.assertTrue(checkboxes.get(i).isDisplayed());//checking if boxes are displayed
            Assert.assertEquals(checkboxes.get(i).getText(),elementsText[i]);//if the expected text match actual

            Assert.assertTrue(checkboxes.get(i).isEnabled());//if its enabled/clickable
            //TO CHECK IF checkBoxesSelected  INPUT
            Assert.assertFalse(checkBoxesSelected.get(i).isSelected());//check if its NOT selected

            checkboxes.get(i).click();//click
            Assert.assertTrue(checkBoxesSelected.get(i).isSelected());//asserts that is selected now
            checkboxes.get(i).click();//click one more time to unselects
            Assert.assertFalse(checkBoxesSelected.get(i).isSelected());//make sure its unselected
        }

    }


    @Test
    private void validatePracticeMore(){
        //use css to find label and use it for display, text and enabled
        List<WebElement> boxesExist = driver.findElements(By.cssSelector("#checkbox-button-group_2 label"));
        //here we use input to for selections
        List<WebElement> boxesSelected = driver.findElements(By.cssSelector("#checkbox-button-group_2 label>input"));

        String[] expectedText = {"Tesla","SpaceX"};


        for (int i = 0; i < expectedText.length; i++) {
            //Assert that our boxes are displayed with the  expected content and are enabled ---> use label
            Assert.assertTrue(boxesExist.get(i).isDisplayed());
            Assert.assertEquals(boxesExist.get(i).getText(), expectedText[i]);
            Assert.assertTrue(boxesExist.get(i).isEnabled());

            //Assert that they are unselected --->use input
            Assert.assertFalse(boxesSelected.get(i).isSelected());
        }
        for (int i = 0; i < expectedText.length; i++) {

            //Click on boxes ---> use label
            boxesExist.get(i).click();

            // now check if they are selected
            Assert.assertTrue(boxesSelected.get(i).isSelected());
        }

        for (int i = 0; i < expectedText.length; i++) {

            //and now unselect them again and make sure they are unselected

            boxesExist.get(i).click();
            Assert.assertFalse(boxesSelected.get(i).isSelected());

        }

    }
}
