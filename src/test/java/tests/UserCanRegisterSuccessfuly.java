package tests;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AccountCreationPage;
import pages.MainPage;
import pages.MyAccountPage;
import pages.SigninPage;

public class UserCanRegisterSuccessfuly extends BasicTest {

	public String gender = "Female";
	public String fisrtName = "";
	public String lastName = "";
	public String password = "";
	public String address = "";
	public String city = "";
	public String state = "";
	public String postCode = "";
	public String country = "";
	public String phoneNumber = "";

	@BeforeMethod
	public void initializePages() {
		mainPage = new MainPage();
		signinPage = new SigninPage();
		myAccountPage = new MyAccountPage();
		accountCreationPage = new AccountCreationPage();

	}

	@Test(description = "Verify that user can register successfuly")
	public void testLogin() {
		mainPage.clickSignInLink();
		signinPage.enterEmailToCreateAccount("dgsfbg@gmail.com");
		signinPage.clickCreateAccountButton();
		accountCreationPage.fillInUserInfo(gender, fisrtName, lastName, password);
		accountCreationPage.fillInAdressInfo(lastName, fisrtName, address, city, state, postCode, country, postCode,
				address);
		accountCreationPage.clickRegisterButton();

		assertTrue(myAccountPage.isOpen(), "My Account page should be open");

	}
}
