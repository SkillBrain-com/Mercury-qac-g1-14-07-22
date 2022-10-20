package driver;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class RemoteWebDriverManager {

//    public static RemoteWebDriver getRemoteDriver() throws MalformedURLException {
//        return new RemoteWebDriver(new URL("http://localhost:4444/"), new ChromeOptions());
//
//    }

    public static RemoteWebDriver getRemoteDriver() throws MalformedURLException {
        return new RemoteWebDriver(new URL("http://localhost:4444/"), new ChromeOptions());
    }
}
