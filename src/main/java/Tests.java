import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Tests {
    public static void main(String[] args) {
        ChromeDriver driver = WebDriverManager.getChromeDriverByManager();
        driver.get(" https://testpages.herokuapp.com/styled/index.html");
       // driver.get("https://demoqa.com/elements ");


        try {
            // interactionWithTheFourthLinks(driver);
            //   basicElementPage(driver);
            //  attributesPage(driver);
            //   findByLocator(driver);
            //  getTableDetails(driver);



        } finally {

            driver.quit();

        }
    }

    public static void interactionWithTheFourthLinks(WebDriver driver) {


        WebElement firstLink = driver.findElement(By.cssSelector("#basicpagetest"));
        firstLink.click();


        WebElement indexPage = driver.findElement(By.cssSelector(".page-navigation a"));
        indexPage.click();


        WebElement secondLink = driver.findElement(By.id("elementattributestest"));
        secondLink.click();

        WebElement index2Page = driver.findElement(By.cssSelector(".page-navigation a"));
        index2Page.click();


        WebElement thirdLink = driver.findElement(By.xpath("//*[@id=\"findbytest\"] "));
        thirdLink.click();

        WebElement index3Page = driver.findElement(By.cssSelector(".page-navigation a"));
        index3Page.click();


        WebElement fourthLink = driver.findElement(By.cssSelector("#tablestest"));
        fourthLink.click();

        WebElement index4Page = driver.findElement(By.cssSelector(".page-navigation a"));
        index4Page.click();


    }

    public static void basicElementPage(WebDriver driver) {

        WebElement firstLink = driver.findElement(By.cssSelector("#basicpagetest"));
        firstLink.click();

        //primul paragraf
        WebElement para1 = driver.findElement(By.cssSelector("#para1"));
        System.out.println(para1.getText());

        //al doilea paragraf
        WebElement para2 = driver.findElement(By.id("para2"));
        System.out.println(para2.getText());


    }

    public static void attributesPage(WebDriver driver) {
        WebElement secondLink = driver.findElement(By.id("elementattributestest"));
        secondLink.click();

        WebElement attributesParagraph = driver.findElement(By.id("domattributes"));
        System.out.println("Attribute 1 :" + attributesParagraph.getAttribute("class"));
        System.out.println("Attribute 2 :" + attributesParagraph.getAttribute("custom-attrib"));
        System.out.println("Attribute 3 :" + attributesParagraph.getAttribute("title"));
        System.out.println("Attribute 4 :" + attributesParagraph.getAttribute("original-title"));


        WebElement dynanimAttributes = driver.findElement(By.cssSelector("#jsattributes"));
        System.out.println("Dynamic text : " + dynanimAttributes.getText());

        System.out.println("nextInt before clicking button :" + dynanimAttributes.getAttribute("nextId"));
        System.out.println("custom -1 before click :" + dynanimAttributes.getAttribute("custom -1"));

        WebElement addAttributeButton = driver.findElement(By.className("styled-click-button"));

        addAttributeButton.click();
        System.out.println("nextInt after clicking button :" + dynanimAttributes.getAttribute("nextId"));
        System.out.println("custom -1 after click :" + dynanimAttributes.getAttribute("custom -1"));


    }

    public static void findByLocator(WebDriver driver) {
        WebElement thirdLink = driver.findElement(By.xpath("//*[@id=\"findbytest\"] "));
        thirdLink.click();

        WebElement locatorPage1 = driver.findElement(By.id("p1"));
        WebElement locatorPage2 = driver.findElement(By.id("p2"));
        WebElement locatorPage3 = driver.findElement(By.id("p3"));

        System.out.println("para 1: " + locatorPage1.getText());
        System.out.println("para 2: " + locatorPage2.getText());
        System.out.println("para 3: " + locatorPage3.getText());
        System.out.println(" ");

        WebElement locatorPageA = driver.findElement(By.cssSelector("#p26"));
        WebElement locatorPageB = driver.findElement(By.cssSelector("#p27"));
        WebElement locatorPageC = driver.findElement(By.cssSelector("#p28"));

        System.out.println("para A: " + locatorPageA.getText());
        System.out.println("para C: " + locatorPageC.getText());
        System.out.println("para C: " + locatorPageC.getText());
        System.out.println(" ");

        WebElement locatorXpath = driver.findElement(By.xpath("//*[@id=\"p17\"]"));
        System.out.println("line text: " + locatorXpath.getText());
        System.out.println("");

        WebElement locatorXpath1 = driver.findElement(By.xpath("//*[@id=\"p39\"]"));
        System.out.println("line text: " + locatorXpath1.getText());
        System.out.println("");


    }

    public static void getTableDetails(WebDriver driver) {
        WebElement fourthLink = driver.findElement(By.cssSelector("#tablestest"));
        fourthLink.click();

        WebElement tabelTag = driver.findElement(By.xpath("//*[@id=\"mytable\"]/tbody/tr[1]"));
        System.out.println(tabelTag.getText());
        System.out.println("");


        WebElement firstRow = driver.findElement(By.xpath("//*[@id=\"mytable\"]/tbody/tr[2] "));
        System.out.println(firstRow.getText());
        System.out.println("");

        WebElement secondRow = driver.findElement(By.xpath("//*[@id=\"mytable\"]/tbody/tr[3]"));
        System.out.println(secondRow.getText());
        System.out.println("");

        WebElement thirdRow = driver.findElement(By.xpath("//*[@id=\"mytable\"]/tbody/tr[4]"));
        System.out.println(thirdRow.getText());
        System.out.println("");

        WebElement fourthRow = driver.findElement(By.xpath("//*[@id=\"mytable\"]/tbody/tr[5]"));
        System.out.println(fourthRow.getText());
        System.out.println("");


    }




}





