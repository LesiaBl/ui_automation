package practice;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import scripts.Base;

public class UltimateQa extends Base {
    @BeforeMethod
    public void setPage(){
        driver.get("https://ultimateqa.com/complicated-page#A_toggle");

    }

    @Test
    public void validateA_toggle(){
        
    }
}
