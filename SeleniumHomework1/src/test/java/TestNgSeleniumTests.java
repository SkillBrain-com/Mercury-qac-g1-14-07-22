import driver.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class TestNgSeleniumTests {

    ChromeDriver driver;

    @BeforeMethod
    public void beforeMethod(){

        driver = WebDriverManager.getChromeDriveByManager();
//        driver.get("https://demoqa.com");

    }

    @AfterMethod
    //@AfterMethod(alwaysRun = true)
    public void afterMethod(){
        if (driver != null){
            driver.quit();
        }

    }

    @DataProvider(name = "myFirstDataProvider")
    public Object[][] myFirstDataProvider(){
        return new Object[][]{
                {"/elements"},
                {"/forms"},
                {"/alertsWindows"},
                {"/widgets"},
                {"/interaction"},
                {"/books"}
        };
    }

    @Test(dataProvider = "myFirstDataProvider")
    public void dataProviderTest(String path){
        driver.get("https://demoqa.com" + path);
        WebElement image = driver.findElement(By.cssSelector("img[src=\"/images/Toolsqa.jpg\"]"));

        assertTrue(image.isDisplayed(),"Expected image is not displayed");

    }

    @Test
    public void test1(){

        driver.get("https://testpages.herokuapp.com/styled/index.html");

    }

    //Assert example - numarul de carduri de pe demoqa.com este egal cu 6
    @Test
    public void assertTest(){

        //navigam pe demoqa si verificam ca avem 6 carduri pe pagina
//        driver.get("https://demoqa.com");

        List<WebElement> cards = driver.findElements(By.className("card"));

        assertEquals(cards.size(), 5, "Wrong card number on the page!");

    }

    //Assert that text displayed dupa right click este prezent;
    //also assert ca textul este ce corect (as expected)
    @Test
    public void rightClick() throws InterruptedException {
        driver.get("https://demoqa.com/buttons");
        SoftAssert softAssert = new SoftAssert();

        WebElement rightClickButton = driver.findElement(By.id("rightClickBtn"));

        //scroll to button in the page
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", rightClickButton);
        Thread.sleep(500);

//        assertTrue(rightClickButton.isDisplayed(), "Button is not displayed!");
        softAssert.assertFalse(rightClickButton.isDisplayed(), "Button is not displayed!");

        Actions actions = new Actions(driver);
        actions.contextClick(rightClickButton).build().perform();

        WebElement textDisplayed = driver.findElement(By.id("rightClickMessage"));

        softAssert.assertEquals(textDisplayed.getText(), "You have done a right click", "Right click was unsuccessful");

        softAssert.assertAll();

    }

    //assert that textul dupa double click este cel asteptat
    @Test
    public void doubleClick(){

        driver.get("https://demoqa.com/buttons");

        WebElement doubleClickButton = driver.findElement(By.id("doubleClickBtn"));

        Actions actions = new Actions(driver);
        actions.doubleClick(doubleClickButton).build().perform();

        WebElement textDisplayed = driver.findElement(By.id("doubleClickMessage"));

        assertEquals(textDisplayed.getText(), "You have done a double click", "Double click was unsuccessful");

    }

}
