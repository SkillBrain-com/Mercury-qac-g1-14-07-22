import driver.RemoteWebDriverManager;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class SeleniumGridTests {

    @Test
    public void gridTest() throws MalformedURLException {

        RemoteWebDriver driver = RemoteWebDriverManager.getRemoteDriver();
        driver.get("https://demoqa.com");



        driver.quit();

    }

}
