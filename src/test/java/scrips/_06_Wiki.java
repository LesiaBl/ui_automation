package scrips;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class _06_Wiki extends Base {

    @BeforeMethod
    public void setPage(){
        driver.get("https://www.wikipedia.org/");
    }


    @Test

    public void validateWikiSearch(){

        WebElement search = driver.findElement(By.id("searchInput"));

        Assert.assertTrue(search.isDisplayed());
        Assert.assertTrue(search.isEnabled());
        search.sendKeys("Tesla");

        WebElement searchButton = driver.findElement(By.cssSelector(".pure-button"));

        Assert.assertTrue(searchButton.isDisplayed());
        Assert.assertTrue(searchButton.isEnabled());

        searchButton.click();

        WebElement header = driver.findElement(By.cssSelector(".mw-page-title-main"));
        Assert.assertTrue(header.isDisplayed());
        Assert.assertEquals(header.getText(), "Tesla");



    }
}
