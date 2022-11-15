package tests;

import driver.WebdriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class WebTableTests {
    public static void main(String[] args) {
//        testWebTable();
        testDynamicWebTable();
    }

    public static void testWebTable() {
        ChromeDriver driver = WebdriverManager.createChromeDriver();
        driver.get("https://testpages.herokuapp.com/styled/tag/dynamic-table.html");

        WebElement tableCaption = driver.findElement(By.cssSelector("table#dynamictable caption"));
        System.out.println(tableCaption.getText());

// Select table rows and columns
        List<WebElement> tableRows = driver.findElements(By.cssSelector("table#dynamictable tr"));
        WebElement firstRow = tableRows.get(0);
        List<WebElement> firstRowColumns = firstRow.findElements(By.cssSelector("th"));
        System.out.println("Header din prima coloana este: " + firstRowColumns.get(0).getText());
        System.out.println("Header din a doua coloana este: " + firstRowColumns.get(1).getText());
        System.out.println("");

        WebElement secondRow = tableRows.get(1);
        List<WebElement> secondRowColumns = secondRow.findElements(By.cssSelector("td"));
        System.out.println("Textul din randul 2, coloana 1 este: " + secondRowColumns.get(0).getText());
        System.out.println("Textul din randul 2, coloana 2 este: " + secondRowColumns.get(1).getText());
        System.out.println("");

        WebElement thirdRow = tableRows.get(2);
        List<WebElement> thirdRowColumns = thirdRow.findElements(By.cssSelector("td"));
        System.out.println("Textul din randul 3, coloana 1 este: " + thirdRowColumns.get(0).getText());
        System.out.println("Textul din randul 3, coloana 2 este: " + thirdRowColumns.get(1).getText());

    }

    public static void testDynamicWebTable() {
        ChromeDriver driver = WebdriverManager.createChromeDriver();
        driver.get("https://testpages.herokuapp.com/styled/tag/dynamic-table.html");

        WebElement summary = driver.findElement(By.cssSelector("details summary"));
        summary.click();

        WebElement caption = driver.findElement(By.id("caption"));
        caption.clear();
        caption.sendKeys("text de introdus pentru lectie");

        WebElement refreshTableButton = driver.findElement(By.id("refreshtable"));
        refreshTableButton.click();

        WebElement tableCaption = driver.findElement(By.cssSelector("table#dynamictable caption"));
        System.out.println(tableCaption.getText());
        System.out.println("");

        driver.quit();
    }

}
