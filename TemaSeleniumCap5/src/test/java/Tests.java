import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Tests {

    public static void main(String[] args) {


        // instantiem driverul si navigam pe url-ul paginii

        ChromeDriver driver = WebDriverManager.getChromeDriverByManager();
        driver.get("https://testpages.herokuapp.com/styled/index.html");

        try {
//           InterectWhihtFirtFourLinks (driver);
//           basicElementsPage ( driver);
//           attributesPage (driver);
//           findByPlaygroundLocator (driver);
             tablestest (driver);

        } finally {
            driver.quit();
        }

    }
    public static void InterectWhihtFirtFourLinks (WebDriver driver){


        // identify the 4 links
        WebElement firstLink = driver.findElement(By.cssSelector("#basicpagetest"));
        firstLink.click();

        WebElement indexPage = driver.findElement(By.cssSelector(".page-navigation a"));
        indexPage.click();

        WebElement secondLink = driver.findElement(By.id("elementattributestest"));
        secondLink.click();

        indexPage = driver.findElement(By.cssSelector(".page-navigation a"));
        indexPage.click();

        WebElement thirdLink = driver.findElement(By.xpath("//*[@id=\"findbytest\"]"));
        thirdLink.click();

        indexPage = driver.findElement(By.cssSelector(".page-navigation a"));
        indexPage.click();

        WebElement fourthLink = driver.findElement(By.cssSelector("#tablestest"));
        fourthLink.click();

        indexPage = driver.findElement(By.cssSelector(".page-navigation a"));
        indexPage.click();

    }
    public static void basicElementsPage (WebDriver driver){

        WebElement firstLink = driver.findElement(By.cssSelector("#basicpagetest"));
        firstLink.click();

        // first paragraph
        WebElement para1 = driver.findElement(By.cssSelector("#para1"));
        System.out.println(para1.getText());

        // second paragraph
        WebElement para2 = driver.findElement(By.id("para2"));
        System.out.println(para2.getText());
    }
    public static void attributesPage (WebDriver driver){


        WebElement secondLink = driver.findElement(By.id("elementattributestest"));
        secondLink.click();

        //static attributes
    //    WebElement attributesParagraph = driver.findElement(By.id("domattributes"));
    //    System.out.println("Attribute 1: " + attributesParagraph.getAttribute("class"));
    //    System.out.println("Attribute 2: " + attributesParagraph.getAttribute("custom-attrib"));
    //    System.out.println("Attribute 3: " + attributesParagraph.getAttribute("title"));
    //    System.out.println("Attribute 4: " + attributesParagraph.getAttribute("original-title"));

        // dynamic attributes
        WebElement dynamicAttributes = driver.findElement(By.id("jsattributes"));
        System.out.println("Dynamic text :" + dynamicAttributes.getText());
        System.out.println("nextid befor cliking button :" + dynamicAttributes.getAttribute("nextid"));
        System.out.println("custom-1 befor cliking button :" + dynamicAttributes.getAttribute("custom-1"));

        // button add another attributes
        WebElement addAttributeButton = driver.findElement(By.className("styled-click-button"));
        addAttributeButton.click();
        System.out.println("nextid after cliking button :" + dynamicAttributes.getAttribute("nextid"));
        System.out.println("custom-1 after cliking button :" + dynamicAttributes.getAttribute("custom-1"));

    }
    public static void findByPlaygroundLocator (WebDriver driver){
        WebElement thirdLink = driver.findElement(By.xpath("//*[@id=\"findbytest\"]"));
        thirdLink.click();

        WebElement textParagraph = driver.findElement(By.xpath("//*[@id=\"p1\"]"));
        System.out.println("para 1:" + textParagraph.getText());

        WebElement para12 = driver.findElement(By.id("a38"));
        System.out.println("para 12 :" + para12.getText());
    }
    public static void tablestest (WebDriver driver){
        WebElement fourthLink = driver.findElement(By.cssSelector("#tablestest"));
        fourthLink.click();

        // title
        WebElement tabelCaption = driver.findElement(By.cssSelector("table#mytable caption"));
        System.out.println(tabelCaption.getText());

        // create a list all rows as web elements
        List<WebElement> tableRows = driver.findElements(By.cssSelector("table#mytable tr"));

        // extract data from line 1
        WebElement firstRow = tableRows.get(0);
        List<WebElement> firstRowColumns = driver.findElements(By.cssSelector("table#mytable th"));
        System.out.println("Header linia 1, coloana 1 :" + firstRowColumns.get(0).getText());
        System.out.println("Header linia 1, coloana 2 :" + firstRowColumns.get(1).getText());


        // extract data from line 2
        WebElement secondRow = tableRows.get(1);
        List<WebElement> secondRowColumns = secondRow.findElements(By.cssSelector("table#mytable td"));
        System.out.println("Header linia 2, coloana 1 :" + secondRowColumns.get(0).getText());
        System.out.println("Header linia 2, coloana 2 :" + secondRowColumns.get(1).getText());

       // extract data from line 3
        WebElement thirdRow = tableRows.get(2);
        List<WebElement> thirdRowColumns = thirdRow.findElements(By.cssSelector("table#mytable td"));
        System.out.println("Header linia 3, coloana 1 :" + thirdRowColumns.get(0).getText());
        System.out.println("Header linia 3, coloana 2 :" + thirdRowColumns.get(1).getText());

        // extract data from line 4
        WebElement fourthRow = tableRows.get(3);
        List<WebElement> fourthRowColumns = fourthRow.findElements(By.cssSelector("table#mytable td"));
        System.out.println("Header linia 4, coloana 1 :" + fourthRowColumns.get(0).getText());
        System.out.println("Header linia 4, coloana 2 :" + fourthRowColumns.get(1).getText());

        // extract data from line 5
        WebElement fifthRow = tableRows.get(4);
        List<WebElement> fifthRowColumns = fifthRow.findElements(By.cssSelector("table#mytable td"));
        System.out.println("Header linia 5, coloana 1 :" + fifthRowColumns.get(0).getText());
        System.out.println("Header linia 5, coloana 2 :" + fifthRowColumns.get(1).getText());

    }



}

