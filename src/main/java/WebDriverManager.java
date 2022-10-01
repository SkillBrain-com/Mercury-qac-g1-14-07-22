import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverManager {
    public static ChromeDriver getChromeDriverByManager(){

        ChromeDriverManager.chromedriver().setup();
        return new ChromeDriver();

    }
}
