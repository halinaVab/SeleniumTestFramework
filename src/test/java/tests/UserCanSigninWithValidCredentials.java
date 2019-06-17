package tests;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.MyAccountPage;
import pages.SigninPage;

public class UserCanSigninWithValidCredentials extends BasicTest {

	public String validEmail = "galinavab280222@gmail.com";
	public String validPassword = "123456";

	@BeforeMethod
	public void initializePages() {
		mainPage = new MainPage();
		signinPage = new SigninPage();
		myAccountPage = new MyAccountPage();

	}

	@Test(description = "Verify that user can add sigin with valid credentials")
	public void testLogin() {
		mainPage.clickSignInLink();
		signinPage.signin(validEmail, validPassword);

		assertTrue(myAccountPage.isOpen(), "My Account page should be open");

	}

}
