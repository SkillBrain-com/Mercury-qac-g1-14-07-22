import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class seleniumTests  {

    ChromeDriver driver;

    @BeforeMethod
    public  void beforeMethod(){
         driver = WebDriverManager.getChromeDriverByManager();
       //  throw new RuntimeException("Eroare din before method ");
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        if (driver != null) {
            driver.quit();
        }
    }

//    @Test(dataProvider = "myFirstDataProvider" , dataProviderClass = MainSelenium.class)
//    public void dataProviderTest(String path , int paramInt){
//      driver.get("https://demoqa.com" + path);
//      WebElement image = driver.findElement(By.cssSelector("img[src='/images/Toolsqa.jpg']"));
//      assertTrue(image.isDisplayed(),"Image is not displayed!");
//
//    }
//
    @Test
    public void assertTest(){
        driver.get("https://demoqa.com");
        List<WebElement> cards = driver.findElements(By.className("card"));
        assertEquals(cards.size(), 6,"Wrong catd size");
    }
//
//    @Test
//    public void primulTest(){
//        driver.get("https://demoqa.com");
//        throw new RuntimeException("Custom exception ");
//    }
//
//
//    @Test //asssert
//    public  void doubleClick(){
//        driver.get("https://demoqa.com/buttons");
//        WebElement doubleClick = driver.findElement(By.id("doubleClickBtn"));
//        Actions actions = new Actions(driver);
//        actions.doubleClick(doubleClick).build().perform();
//
//
//        WebElement message = driver.findElement(By.id("doubleClickMessage"));
//        assertEquals(message.getText(), "You have done a double click" ,"Double click was unsuccessful");
//
//
//    }
//
//
//    @Test
//    public  void rightClick(){
//        SoftAssert softAssert = new SoftAssert();
//
//
//        driver.get("https://demoqa.com/buttons");
//        WebElement simpleClick = driver.findElement(By.id("rightClickBtn"));
//        softAssert.assertTrue(simpleClick.isDisplayed() , "Right click button is not displayed!");
//
//
//        Actions actions = new Actions(driver);
//        actions.contextClick().build().perform();
//
//
//        WebElement message = driver.findElement(By.id("rightClickMessage"));
//        softAssert.assertEquals(message.getText(), "You have done a right click");
//
//
//
//        softAssert.assertAll();
//
//
//    }
//
//
//    @Test
//    public  void simpleClick() {
//        driver.get("https://demoqa.com/buttons");
//        driver.findElements(By.cssSelector(".btn.btn-primary")).get(2).click();
//
//    }

}
