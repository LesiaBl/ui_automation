package scripts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AppleMainPage {
    static WebDriver driver;

    @BeforeMethod
    public void setUp(){
    WebDriverManager.chromedriver().setup();

    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    driver.get("https://www.google.com/");


    }

    @AfterMethod
    public void tearDown() throws InterruptedException {

        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void validateAppleTitleAndURL() throws InterruptedException{
        Thread.sleep(2000);

        driver.get("https://www.apple.com/");
        Assert.assertEquals(driver.getTitle(),"Apple");
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.apple.com/");

    }





}
