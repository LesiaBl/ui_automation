package scrips;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.Waiter;

public class TGDownload extends Base {
    @BeforeMethod
    public void setPage() {
        driver.get("https://techglobal-training.com/frontend");
        driver.findElement(By.id("card-14")).click();
    }

    @Test
    public void validateFileDownload(){
        driver.findElement(By.id("file_download")).click();
        Waiter.pause(4);
    }
}