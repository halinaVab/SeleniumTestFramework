package tests;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.SearchResultPage;

public class UserCanSearchItems extends BasicTest {

	@BeforeMethod
	public void initializePages() {
		mainPage = new MainPage();
		searchResultPage = new SearchResultPage();
	}

	@Test(description = "Verify that user can search for items")
	public void test() {
		mainPage.searchForProduct("Blouse");
		assertTrue(searchResultPage.isSearchResultsContainsProduct("Blouse"), "Blouse should appear");

	}

}
