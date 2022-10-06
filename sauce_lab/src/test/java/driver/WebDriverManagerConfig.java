package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverManagerConfig {

    public static ChromeDriver getChromeDriverByManager(){

        ChromeDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }


}
