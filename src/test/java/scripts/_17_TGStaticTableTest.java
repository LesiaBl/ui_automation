package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.TableHandler;

import java.util.List;

public class _17_TGStaticTableTest extends Base{
    @BeforeMethod
    public void setPage(){
        driver.get("https://techglobal-training.com/frontend/static-tables");
    }
    //TEST CASE 1
    //Verify the headers of the table
    //Go to https://techglobal-training.com/frontend/
    //Click on the "Static Tables" card
    //Check that the headers of the table are "Rank", "Company", "Employees", and "Country"
    //Verify the rows of the table

    @Test
    public void validateHeaders(){

        List<WebElement> headers = driver.findElements(By.cssSelector("th[class*='header']"));
        String[] expectedText = {"Rank", "Company", "Employees", "Country"};
        for(int i = 0; i < headers.size(); i++){
            Assert.assertTrue(headers.get(i).isDisplayed());
            Assert.assertEquals(headers.get(i).getText(), expectedText[i]);

        }
    }
//TEST CASE 2
//Go to https://techglobal-training.com/frontend/
//Click on the "Static Tables" card
//Check that the first row of the table has the values "1", "Amazon", "1,523,000", and "USA"
//Verify the columns of the table
    @Test
    public void validateFirstRow() {
        List<WebElement>  firstRow = driver.findElements(By.cssSelector("tr:nth-child(1) td"));
        String[] expectedText = {"1", "Amazon", "1,523,000", "USA"};

        for(int i = 0; i < firstRow.size(); i++){
            Assert.assertTrue(firstRow.get(i).isDisplayed());
            Assert.assertEquals(firstRow.get(i).getText(), expectedText[i]);

        }
    }
    //TEST CASE 3
    //Go to https://techglobal-training.com/frontend/
    //Click on the "Static Tables" card
    //Check that the "Country" column of the table has the values "USA", "China", "USA", "USA", "S. Korea"
    //Verify the entire table
    @Test
    public void validateLastColon() {
        List<WebElement>  country = driver.findElements(By.cssSelector("d:nth-child(4)"));
        String[] expectedText = {"USA", "China", "USA", "USA", "S. Korea"};

        for(int i = 0; i < country.size(); i++){
            Assert.assertTrue(country.get(i).isDisplayed());
            Assert.assertEquals(country.get(i).getText(), expectedText[i]);
        }
    }


    @Test
    public void listOfLists(){
        WebElement mainTable = driver.findElement(By.id("company_table"));
        List<List<WebElement>> tableDate = TableHandler.getTableData(mainTable);

        for(List<WebElement> row: tableDate){
            for(WebElement cell: row){
                System.out.println(cell.getText());
            }
        }
    }
}
