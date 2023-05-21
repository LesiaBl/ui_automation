package project1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Front_endTechGlobal {

    static WebDriver driver;
    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://www.google.com/");
        driver.get("https://techglobal-training.com/frontend/project-1");

    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    /*
    Test Case 01 - Validate the Contact Us information
Navigate to https://techglobal-training.com/frontend/project-1
Validate the heading is “Contact Us”
Validate the address is “2860 S River Rd Suite 350, Des Plaines IL 60018”
Validate the email is “info@techglobalschool.com"
Validate the phone number is “(773) 257-3010”
     */
    @Test
    public void validateTheContactUsInformation(){
        WebElement headerElement = driver.findElement(By.tagName("h1"));
        Assert.assertEquals("Contact Us", headerElement.getText());

        WebElement address = driver.findElement(By.id("address"));
        Assert.assertEquals("2860 S River Rd Suite 350, Des Plaines IL 60018",address.getText());

        WebElement email = driver.findElement(By.id("email"));
        Assert.assertEquals("info@techglobalschool.com", email.getText());

        WebElement phone_number = driver.findElement(By.id("phone-number"));
        Assert.assertEquals("(773) 257-3010",phone_number.getText());

    }
/*
Navigate to https://techglobal-training.com/frontend/project-1
Validate that the Full name input box is displayed
Validate that the Full name input box is required
Validate that the label of the Full name input box is “Full name”
Validate that the placeholder of the Full name input box is “Enter your name”
 */
    @Test
    public void  validateTheGenderSelectorIsClikable(){
        WebElement searchInputBox = driver.findElement(By.xpath("(//label[@class='label'])[1]"));
        Assert.assertTrue(searchInputBox.isDisplayed());
        Assert.assertTrue(searchInputBox.isEnabled());
        Assert.assertEquals("Full name *",searchInputBox.getText());
        WebElement clickable = driver.findElement(By.xpath("(//input[@class='input'])[1]"));
        Assert.assertTrue(clickable.isDisplayed(), "Enter your name");
        clickable.sendKeys("lesia");

    }
    //Navigate to https://techglobal-training.com/frontend/project-1
    //Validate the label is “Gender”
    //Validate that the Gender is required
    //Validate the options are “Female”, “Male” and “Prefer not to disclose”
    //Validate the options are clickable and not selected
    //Click on the “Male” option and validate it is selected while the others are not selected
    //Click on the “Female” option and validate it is selected while the others are not selected

    @Test
    public void validateGenderRadioButton(){

        WebElement searchGender = driver.findElement(By.xpath("(//label[@class='label'])[2]"));
        Assert.assertTrue(searchGender.isDisplayed());

    }
}
