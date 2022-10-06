import driver.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Test
public class Tests {

//    public static void main(String[] args) {
//
//    }

//    @Test
    public void test1(){

        ChromeDriver driver = WebDriverManager.getChromeDriveByManager();
        driver.get("https://testpages.herokuapp.com/styled/index.html");
        driver.quit();

    }

    //Assert
//    @Test
    public void assertTest(){

        //naviogam pe demoqa si verificam ca avem 6 carduri pe pagina
        ChromeDriver driver = WebDriverManager.getChromeDriveByManager();
        driver.get("https://demoqa.com");

        List<WebElement> cards = driver.findElements(By.className("card"));
        assertEquals(cards.size(), 6, "Wrong card number on the page!");

        driver.quit();

    }


    public static void interactWithFirstFourLinks(){

        WebDriver driver = WebDriverManager.getChromeDriveByManager();
        driver.get("https://testpages.herokuapp.com/styled/index.html");

        //identify links
        WebElement firstLink = driver.findElement(By.cssSelector("#basicpagetest"));
        WebElement secondLink = driver.findElement(By.xpath("//*[@id=\"elementattributestest\"]"));
        WebElement thirdLink = driver.findElement(By.id("findbytest"));
        WebElement fourthLink = driver.findElement(By.id("tablestest"));

        //get some elements attributes
        System.out.println(firstLink.getText());
        System.out.println(firstLink.getLocation());

        System.out.println(secondLink.getText());
        System.out.println(secondLink.getLocation());

        System.out.println(thirdLink.getText());
        System.out.println(thirdLink.getLocation());

        System.out.println(fourthLink.getText());
        System.out.println(fourthLink.getLocation());


    }

    public static void basicElementsPage(){

        WebDriver driver = WebDriverManager.getChromeDriveByManager();
        driver.get("https://testpages.herokuapp.com/styled/index.html");

        //navigate to the first page
        WebElement firstLink = driver.findElement(By.cssSelector("#basicpagetest"));
        firstLink.click();

        //first paragraph
        WebElement para1 = driver.findElement(By.id("para1"));
        System.out.println("Paragraph 1 text: " + para1.getText());

        //second paragraph
        WebElement para2 = driver.findElement(By.id("para2"));
        System.out.println("Paragraph 2 text: " + para2.getText());

    }

    public static void elementAttributesPage(){

        WebDriver driver = WebDriverManager.getChromeDriveByManager();
        driver.get("https://testpages.herokuapp.com/styled/index.html");

        //click the second link
        WebElement secondLink = driver.findElement(By.xpath("//*[@id=\"elementattributestest\"]"));
        secondLink.click();

        //identify the field with static attributes:
        WebElement attributesElement = driver.findElement(By.id("domattributes"));

        //get some of its attributes and display them to the user
        System.out.println("Attr1: " + attributesElement.getAttribute("class"));
        System.out.println("Attr2: " + attributesElement.getAttribute("custom-attrib"));
        System.out.println("Attr3: " + attributesElement.getAttribute("title"));

        //identify the field with dynamic attributes
        WebElement dynamicAttributesElement = driver.findElement(By.id("jsattributes"));
        WebElement addAttributeButton = driver.findElement(By.cssSelector(".styled-click-button"));

        //display attributes before clicking the button:
        System.out.println("Before adding attribute: " + dynamicAttributesElement.getAttribute("nextId"));
        System.out.println("After adding attribute: " + dynamicAttributesElement.getAttribute("custom-1"));

        //click the button
        addAttributeButton.click();

        //display attributes after adding a new attribute
        System.out.println("After adding attribute: " + dynamicAttributesElement.getAttribute("nextId"));
        System.out.println("After adding attribute: " + dynamicAttributesElement.getAttribute("custom-1"));



    }

    public static void paragraphs(){

        WebDriver driver = WebDriverManager.getChromeDriveByManager();
        driver.get("https://testpages.herokuapp.com/styled/index.html");

        //navigate to the page by clicking the corresponding link
        WebElement paragraphsLink = driver.findElement(By.cssSelector("#findbytest"));
        paragraphsLink.click();

        //paraghraph1
        WebElement paragraph1 = driver.findElement(By.id("p1"));
        System.out.println(paragraph1.getText());

        //paraghraph2
        WebElement paragraph2 = driver.findElement(By.xpath("//*[@id=\"p2\"]"));
        System.out.println(paragraph2.getText());

    }

    public static void table(){

        WebDriver driver = WebDriverManager.getChromeDriveByManager();
        driver.get("https://testpages.herokuapp.com/styled/index.html");

        //navigate to the required url
        WebElement tableLink = driver.findElement(By.cssSelector("#tablestest"));
        tableLink.click();

        //create a list with all rows as web elements
        List<WebElement> tableRows = driver.findElements(By.cssSelector("table#dynamictable tr"));


        //extract data from line 1
        WebElement firstRow = tableRows.get(0);

        List<WebElement> firstRowColumns = driver.findElements(By.cssSelector("table#dynamictable th"));
        System.out.println("Header linia 1 coloana 1: " + firstRowColumns.get(0).getText());
        System.out.println("Header linia 1 coloana 2: " + firstRowColumns.get(1).getText());


        //extract data from line 2
        WebElement secondRow = tableRows.get(1);
        List<WebElement> secondRowColumns = secondRow.findElements(By.cssSelector("td"));
        System.out.println("Header linia 2 coloana 1: " + secondRowColumns.get(0).getText());
        System.out.println("Header linia 2 coloana 2: " + secondRowColumns.get(1).getText());

        //extract data from line 3
        WebElement thirdRow = tableRows.get(2);
        List<WebElement> thirdRowColumns = thirdRow.findElements(By.cssSelector("td"));
        System.out.println("Header linia 3 coloana 1: " + thirdRowColumns.get(0).getText());
        System.out.println("Header linia 3 coloana 2: " + thirdRowColumns.get(1).getText());

        driver.quit();

    }


    public void simpleClick(){
        ChromeDriver driver = WebDriverManager.getChromeDriveByManager();
        driver.get("https://demoqa.com/buttons");

        //click on the button
        driver.findElements(By.cssSelector(".btn.btn-primary")).get(2).click();
        driver.quit();

    }

    //exemplify softAssert
//    @Test
    public void rightClick() throws InterruptedException {
        ChromeDriver driver = WebDriverManager.getChromeDriveByManager();
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

        softAssert.assertEquals(textDisplayed.getText(), "You have done a right clicek", "Wrong click was unsuccessful");

//        softAssert.assertAll();
        driver.quit();
        softAssert.assertAll();

    }

//    @Test
    public void doubleClick(){
        ChromeDriver driver = WebDriverManager.getChromeDriveByManager();
        driver.get("https://demoqa.com/buttons");

        WebElement doubleClickButton = driver.findElement(By.id("doubleClickBtn"));

        Actions actions = new Actions(driver);
        actions.doubleClick(doubleClickButton).build().perform();

        WebElement textDisplayed = driver.findElement(By.id("doubleClickMessage"));
        assertEquals(textDisplayed.getText(), "You have done a double click", "Double click was unsuccessful");

        driver.quit();

    }

}
