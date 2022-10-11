package Tests;

import Driver.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Exercitiu {
    public static void main(String[] args) {

    }
    ChromeDriver driver = null;
     @Test
    public void PrimulTest(){
        driver = WebDriverManager.getChromDriverByManager();
        driver.get("https://demoqa.com/browser-windows");
        driver.quit();



    }
}
