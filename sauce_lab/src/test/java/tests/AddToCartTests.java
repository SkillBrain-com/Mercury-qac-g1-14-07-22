package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class AddToCartTests extends BaseTest{

    @Test(description = "Verify that add to cart works fine", groups = "with_login")
    public void testAddToCartFunctionality(){

        //identificam sectiunea de cart (dreapta sus)
        WebElement shoppingCart = driver.findElement(By.cssSelector("a.shopping_cart_link"));

        //fac o lista cu cele 6 itemuri
        List<WebElement> products = driver.findElements(By.cssSelector(".inventory_item"));

        //iau primul produs din lista
        WebElement firstItem = products.get(0);

        //identificam numele primului produs
        String firstItemTitle = firstItem.findElement(By.cssSelector(".inventory_item_name")).getText();

        //identificam pretul primului produs
        String firstItemPrice = firstItem.findElement(By.cssSelector(".inventory_item_price")).getText();

        //cautam butonul de add to cart si luam textul de pe el
        WebElement firstItemButton = firstItem.findElement(By.cssSelector(".btn_inventory"));

        //verificam ca textul de pe buttonul de add cart este ADD TO CART
        assertEquals(firstItemButton.getText(), "ADD TO CART", "Textul de e butonul de add" +
                "to cart e incorect inainte sa dam click pe buton");

        //verificam shopping cartul inainte de click pe add to cart
        assertFalse(isElementPresent(By.cssSelector(".shopping_cart_badge")), "Shopping cart badge is " +
                "present on the page before clicking on add to cart");

        //click pe butonul de add to cart
        firstItemButton.click();

        //verificam textul de pe butonul primului item, ca e REMOVE
        assertEquals(firstItem.findElement(By.cssSelector(".btn_inventory")).getText(), "REMOVE",
                "Itemul nu a fost adaugat in cos");

        //verificam shopping cartul dupa click pe add to cart
        assertTrue(isElementPresent(By.cssSelector(".shopping_cart_badge")), "Shopping cart badge is " +
                "present on the page before clicking on add to cart");

    }

}
