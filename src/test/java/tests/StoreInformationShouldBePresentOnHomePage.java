package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.MainPage;

public class StoreInformationShouldBePresentOnHomePage extends BasicTest {

	public String address = "Selenium Framework, Research Triangle Park, North Carolina, USA";
	public String phoneNumber = "(347) 466-7432";
	public String email = "support@seleniumframework.com";

	@BeforeMethod
	public void initializePages() {
		mainPage = new MainPage();

	}

	@Test(description = "Verify is store info present on main page")
	public void test() {
		assertTrue(mainPage.isStoreInfoPresentOnPageWithData(address, phoneNumber, email));

	}

}
