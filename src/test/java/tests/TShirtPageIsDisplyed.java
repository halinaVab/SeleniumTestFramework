package tests;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.TShirtPage;

public class TShirtPageIsDisplyed extends BasicTest{
	
	@BeforeMethod
	public void initializePages() {
		mainPage = new MainPage();
		tshirtPage = new TShirtPage();
	}
	
	@Test (description = "Verify that T-shirts page is opened after clicking t-shirts tab")
	private void test() {
		mainPage.clickOnTshirtsTab();
		assertTrue(tshirtPage.isOpen());
		
	}
	
}
