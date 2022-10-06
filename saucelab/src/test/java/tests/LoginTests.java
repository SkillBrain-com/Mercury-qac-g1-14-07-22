package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class LoginTests extends BaseTest{


    @Test(description = "Verify login scenari with different users", dataProvider = "loginUsers", groups = "without_login")
    public void testLoginScenarios(String username, String password, boolean shouldLogin, boolean shouldWait){

//        System.out.println("blablabla");

        //facem pasii de login
        loginSteps(username, password);

        if (shouldLogin){
            //sa verificam ca s a facut loginul ok
            //in primul rand ca am ajuns pe pagina de inventory:
            assertTrue(driver.getCurrentUrl().contains("/inventory.html"), "User is not loged in correctly");
            //apoi ca lista de inventory nu e goala
            List<WebElement> products = driver.findElements(By.cssSelector(".inventory_item"));
            assertFalse(products.isEmpty(), "No items are on the inventory page after " +
                    "login");
            //also sa verificam ca toate elementele din inventory sunt afisate pe pagina
            for(WebElement item: products){
                assertTrue(item.isDisplayed(), "Items are not displayed on the inventory page after login");
            }
        } else{
            assertFalse(driver.getCurrentUrl().contains("/inventory.html"), "User is taken to the items page after login with" +
                    "locked user");
            if (shouldWait){
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            assertTrue(isElementPresent(By.cssSelector("h3[data-test='error']")),
                    "Error message not displayed for locked user");
        }

    }

    @DataProvider
    public Object[][] loginUsers(){
        return new Object[][]{
            {"standard_user", "secret_sauce", true, false},
            {"locked_out_user", "secret_sauce", false, false},
            {"problem_user", "secret_sauce", true, false},
            {"performance_glitch_user", "secret_sauce", true, true}

        };

    }
}
