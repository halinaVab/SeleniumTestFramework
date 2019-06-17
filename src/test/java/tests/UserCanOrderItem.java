package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.OrderHistoryPage;
import pages.OrderPage;
import pages.SearchResultPage;
import pages.SigninPage;

public class UserCanOrderItem extends BasicTest {

	public String productName = "Faded Short Sleeve T-shirts";
	public String email = "galinavab280222@gmail.com";
	public String password = "123456";

	@BeforeMethod
	public void initializePages() {
		mainPage = new MainPage();
		searchResultPage = new SearchResultPage();
		orderPage = new OrderPage();
		signinPage = new SigninPage();
		orderHistoryPage = new OrderHistoryPage();
	}

	@Test(description = "Verify that user can order item")
	public void test() {
		mainPage.searchForProduct(productName);
		searchResultPage.addProductToCart(productName);
		searchResultPage.clickProceedToCheckoutButton();
		orderPage.clickProceedToCheckoutButton();
		signinPage.signin(email , password);
		orderPage.clickProceedToCheckoutButton();
		orderPage.clickAgreeTermsCheckBox();
		orderPage.clickProceedToCheckoutButton();
		orderPage.clickPayByBankWareButton();
		orderPage.clickConfirmOrderButton();
		orderPage.clickBackToOrdersLink();
		orderHistoryPage.clickLastOrderDetailsButton();

		assertTrue(orderHistoryPage.isOrderContainProduct(productName),
				"Order should contains Product");
		
	}

}
