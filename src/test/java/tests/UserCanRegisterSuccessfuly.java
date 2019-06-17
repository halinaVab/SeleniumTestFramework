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
	public String fisrtName = "Masha";
	public String lastName = "Petrov";
	public String password = "1234567QWE";
	public String address = "Minsk Lenina 23 IBA";
	public String city = "Austin";
	public String state = "Texas";
	public String postCode = "00000";
	public String country = "United States";
	public String phoneNumber = "1234569";

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
		signinPage.enterEmailToCreateAccount("dgsfbg@gmail.com" + generateRandomPart());
		signinPage.clickCreateAccountButton();
		accountCreationPage.fillInUserInfo(gender, fisrtName, lastName, password);
		accountCreationPage.fillInAdressInfo(lastName, fisrtName, address, city, state, postCode, country, postCode,
				address);
		accountCreationPage.clickRegisterButton();

		assertTrue(myAccountPage.isOpen(), "My Account page should be open");

	}
}
