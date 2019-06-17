package tests;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.OrderPage;
import pages.SearchResultPage;

public class UserCanAddAndDeleteItemsFromCart extends BasicTest{
	
	public String productName = "Faded Short Sleeve T-shirts";
	
	@BeforeMethod
	public void initializePages() {
		mainPage = new MainPage();
		searchResultPage =  new SearchResultPage();
		orderPage = new OrderPage();
	}
	
	@Test (description = "Verify that user can add and delete items from cart")
	public void test() {
		mainPage.searchForProduct(productName);
        searchResultPage.addProductToCart(productName);
        searchResultPage.clickContinueShoppingButton();
        
        searchResultPage.clickViewShoppingCartButton();
        assertTrue(orderPage.isCartContainsProduct(productName) , "Product should be in cart");
      
        orderPage.deleteProductFromCart(productName);
        assertFalse(orderPage.isCartContainsProduct(productName) , "Product should not be in cart");
	
	}
}
