import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.builder.ToStringExclude;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import javax.lang.model.element.Element;
import javax.swing.*;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static javax.swing.text.html.CSS.getAttribute;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class MainSelenium {

    @DataProvider(name = "myFirstDataProvider")
    public static Object[][] myFirstDataProvider(){
        return new Object[][]{
                {"/elements", 1},
 //               {"/forms", 2},
 //               {"/alertsWindows", 3},
//                {"/widgets", 4},
//                {"/interaction", 5},
//                {"/books", 6}
        };
    }


//    private static void buttonThree(){
//        ChromeDriver driver;
//       // driver = WebDriverManager.getChromeDriverByManager();
//        driver.get("https://demoqa.com/buttons");
//
//        //buttons
//     //   driver.findElements(By.cssSelector(".btn.btn-primary")).get(2).click();
//
//      //  WebElement rightClickButton =  driver.findElement(By.id("rightClickBtn"));
//        WebElement doubleClick = driver.findElement(By.id("doubleClickBtn"));
//
//
//        Actions actions = new Actions(driver);
//        actions.doubleClick(doubleClick).build().perform();
//     //   actions.contextClick(rightClickButton).build().perform();
//
//        driver.quit();
//
//    }

    private static void ActionsScreen() throws IOException {

            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
            // ChromeDriver driver = null;


        WebDriverManager.chromedriver().setup();
        ChromeDriver driver= new ChromeDriver();

            try {
                WebDriverManager.chromedriver().setup();



                driver.get("https://demoqa.com");
                List<WebElement> cards = driver.findElements(By.cssSelector(".card"));
                WebElement sixthCard = cards.get(5);

                // scroll pe pagina
                Actions actions = new Actions(driver);
                actions.moveToElement(sixthCard).build().perform();

                sixthCard.click();
                throw new NoSuchElementException("Exceptie custom ");

                // screenshot
            } catch (Exception e) {
                System.out.println("Am intrat in ramura de catch ");

                if (driver != null) ;

                File file = driver.getScreenshotAs(OutputType.FILE);
                File destFile = new File("C:\\Users\\ungur\\IdeaProjects\\poza.png");
                FileUtils.copyFile(file, destFile);
            } finally {
                if (driver != null) {
                    driver.quit();
                }

            }
            System.out.println("Finish");
        }

    private static void TryCatchFinally() {

        WebDriverManager.chromedriver().setup();
        ChromeDriver driver= new ChromeDriver();

        driver.get("https://demoqa.com");



        //Thread.sleep(2000);

        try {
            WebElement card = driver.findElement(By.className("card"));
            driver.navigate().refresh();
            // se face refresh la pagina
            card = driver.findElement(By.className("card"));
            card.click();

        } catch (NoSuchElementException | ElementClickInterceptedException e) {
            System.out.println("Am  prins o exceptie ");

        } finally {
            System.out.println("Inchid draiverul ");
            driver.quit();
        }


        WebElement element1 = driver.findElement(By.xpath("//div[@class= 'home-banner']/a"));

        WebElement element2 = driver.findElement(By.cssSelector("div.home-banner a"));
        element2.click();

        //By.tagName
        WebElement header = driver.findElement(By.tagName("header"));
        header.click();


        //By.id
        driver.get("https://demoqa.com/webtables");

        WebElement button = driver.findElement(By.id("addNewRecordButton"));
        button.click();


        //By.linkText
        driver.get("https://demoqa.com/links");

        WebElement link = driver.findElement(By.linkText("Home"));
        link.click();


        //By.name()
        driver.get("https://demoqa.com/");

        WebElement meta = driver.findElement(By.name("viewport"));
        System.out.println(getAttribute("content"));

        //By.linktext
        driver.get("https://demoqa.com/links");
        link = driver.findElement(By.linkText("Home"));
        link.click();
        WebElement link2 = driver.findElement(By.partialLinkText("Content"));
        link2.click();


        //By.className

        WebElement homebanner = driver.findElement(By.className("home-banner"));
        homebanner.click();


        driver.close();
        driver.quit();

        System.out.println("Finish");


    }


    }

    