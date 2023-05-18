package testNG_Kknowledge;

import org.testng.annotations.*;

public class _01_TestHG_Annotations {
    @BeforeMethod
    public void setUp(){
        System.out.println("All the pre condions");
    }

    @AfterMethod
    public void tearDown(){
        System.out.println("All the post conditions");
    }

    @Test
    public void test1(){
        System.out.println("This is test 1");
    }

    @Test
    public void test12(){
        System.out.println("This is test 1");
    }
}
