package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class LoginTests extends BaseTest {

    @Test(description = "Verify that standard user can login succuesfully", groups = "without_login")
    public void loginWithStandardUser(){

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        assertTrue(driver.getCurrentUrl().contains("/inventory.html"), "Login failed, user did not " +
                "land on the inventory page");

        List<WebElement> products = driver.findElements(By.cssSelector(".inventory_item"));

        assertFalse(products.isEmpty(), "No items displayed for uyser after login, so login failed!");

    }
}
