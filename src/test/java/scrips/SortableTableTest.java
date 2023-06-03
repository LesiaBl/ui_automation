package scrips;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SortableTableTest extends Base{
    @BeforeMethod
    public void setPage(){
        driver.get("https://techglobal-training.com/frontend/sortable-tables");
    }

    @Test
    public void sortTable(){
        WebElement table = driver.findElement(By.id("company_table"));

    }
}
