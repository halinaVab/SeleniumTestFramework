package tests;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ForgotPasswordPage;
import pages.MainPage;
import pages.SigninPage;

public class ForgotYourPasswordPageShouldBeOpen extends BasicTest {

	@BeforeMethod
	public void initializePages() {
		mainPage = new MainPage();
		signinPage = new SigninPage();
		forgotPasswordPage = new ForgotPasswordPage();
	}

	@Test(description = "Verify that user is navigated to Forgot Your Password Page after clciking on 'Forgot Your Password' link")
	public void testLogin() {
		mainPage.clickSignInLink();
		signinPage.clickForgotPasswordLink();

		assertTrue(forgotPasswordPage.isOpen(), "Forgot Your Password Page should be open");
		
	}

}
