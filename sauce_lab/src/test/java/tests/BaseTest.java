package tests;

import driver.WebDriverManagerConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected ChromeDriver driver = null;

    @BeforeMethod(onlyForGroups = "with_login")
    public void beforeMethodWithLogin(){

        //instantiem driver
        driver = WebDriverManagerConfig.getChromeDriverByManager();
        driver.get("https://www.saucedemo.com/");

        //login
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

    }

    @BeforeMethod(onlyForGroups = "without_login")
    public void beforeMethodWithoutLogin(){

        //intantiere de driver
        driver = WebDriverManagerConfig.getChromeDriverByManager();
        driver.get("https://www.saucedemo.com/");
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod(){

        if (driver != null){
            driver.quit();
        }
    }

    protected boolean isElementPresent(By locator){

        try{
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException e){
            return false;
        }
    }

}
