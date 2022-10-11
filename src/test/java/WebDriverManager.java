import org.openqa.selenium.chrome.ChromeDriver;

    public class WebDriverManager { public static ChromeDriver getChromeDriverByManager() {
        io.github.bonigarcia.wdm.WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
}

    public static  ChromeDriver getChromeDriverByExecutable(){
        System.setProperty("webdriver.chrome.driver" , "chromedriver.exe");
        return new ChromeDriver();
    }
}
