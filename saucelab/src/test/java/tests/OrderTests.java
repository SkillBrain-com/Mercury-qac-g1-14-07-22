package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class OrderTests extends BaseTest{

    @Test(description = "Verify add product to cart", groups = "with_login")
    public void testAddToCartFunctionality(){

        //asta adaug doar dupa ce fac primele doua assert uri de mai jos
        WebElement shoppingCart = driver.findElement(By.cssSelector("a.shopping_cart_link"));
        //facem o metoda mai jos

        //facem o lista cu toate produsele
        List<WebElement> products = driver.findElements(By.cssSelector(".inventory_item"));

        //iau primul produs
        WebElement firstItem = products.get(0);

        //iau numele primului produs
        String firstItemTitle = firstItem.findElement(By.cssSelector(".inventory_item_name")).getText();

        //iau price tag-ul primului produs
        String firstItemPrice = firstItem.findElement(By.cssSelector(".inventory_item_price")).getText();

        //identific butonul de add to cart de pe primul item
        WebElement firstItemButton = firstItem.findElement(By.cssSelector(".btn_inventory"));

        //assert before click
        assertEquals(firstItemButton.getText(), "ADD TO CART",
                "Add to cart button text is incorrect before adding an item to cart");

        //assertu de shopping cart inainte de click
        assertFalse(isElementPresent(By.cssSelector("span.shopping_cart_badge")), "Sopping cart badge is present" +
                "before adding elements to cart");

        //click on add to card
        firstItemButton.click();

        //assert before click
        //ca sa evitam stale element exception, inlocuim firstItemButton. mai jos, cu
        //firstItem.findElement(By.cssSelector(".btn_inventory"))
//        assertEquals(firstItemButton.getText(), "REMOVE",
//                "Add to cart button text didn't change into REMOVE after clicking Add to cart");

        assertEquals(firstItem.findElement(By.cssSelector(".btn_inventory")).getText(), "REMOVE",
                "Add to cart button text didn't change into REMOVE after clicking Add to cart");

        //observam ca daca nu avem produse in cos, elementul din stanga sus, de cart, nu are
        //fieldul .shopping-cart_badge, iar dupa ce adaugam un produs in cos, il avem

        //assertu de shopping cart dupa click
        assertTrue(isElementPresent(By.cssSelector("span.shopping_cart_badge")), "Sopping cart badge is not displayed" +
                "after adding elements to cart");
        //verificam si textul de pe el
        assertEquals(driver.findElement(By.cssSelector("span.shopping_cart_badge")).getText(), "1", "" +
                "Number of elements in the shopping cart is incorrect");


        //sa facem click pe cart
        shoppingCart.click();
        //verificam ca am ajuns pe pagina de shopping cart
        assertTrue(driver.getCurrentUrl().contains("cart.html"), "User is not on the cart page" +
                "after navigating to it");
        // verificam cate elemente avem in acest cart
        List<WebElement> cartItems = driver.findElements(By.className("cart_item"));
        assertEquals(cartItems.size(), 1, "Number of items in the cart is incorrect");
        //sa verificam ce avem in cart
        String cartItemName = cartItems.get(0).findElement(By.cssSelector(".inventory_item_name")).getText();
        assertEquals(cartItemName, firstItemTitle, "Wrong item added to cart");
        //sa verificam pretul
        String cartItemPrice = cartItems.get(0).findElement(By.className("inventory_item_price")).getText();
        assertEquals(cartItemPrice, firstItemPrice, "Wrong price for the item in the cart");



    }

}
