import org.testng.annotations.*;

public class TestNgAnnotations {

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("Before Suite");
    }

    @BeforeTest
    public static void beforeTest(){
        System.out.println("Before Test");
    }

    @BeforeGroups(groups = {"Group 1"})
    public void beforeGroups(){
        System.out.println("Before Groups");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("Before Class");
    }


    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Before Method");
    }


    @Test(groups = {"Group 1"})
    public void test1(){

        System.out.println("Test1");
    }

    @Test(groups = {"Group 1"})
    public void test2(){

        System.out.println("Test2");
    }


    @Test
    public void test3(){
        System.out.println("test3");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("After Method");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("After Class");
    }

    @AfterGroups(groups = {"Group 1"})
    public void afterGroups(){
        System.out.println("After Groups");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("After Test");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("After Suite");
    }

}
