package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.SigninPage;

public class UserCannotSiginWithInvalidCredentials extends BasicTest {

	public String invalidEmail = "galinavab280222@gmail.com";
	public String invalidPassword = "12345644";

	@BeforeMethod
	public void initializePages() {
		mainPage = new MainPage();
		signinPage = new SigninPage();

	}

	@Test(description = "Verify that user can add sigin with valid credentials")
	public void testLogin() {
		mainPage.clickSignInLink();
		signinPage.signin(invalidEmail, invalidPassword);

		assertTrue(signinPage.isAuthenticationFailedMessageIsShown(), "Authentication Failed Message should be shown");
	
	}

}
