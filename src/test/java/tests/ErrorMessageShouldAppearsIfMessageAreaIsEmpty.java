package tests;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ContactUsPage;
import pages.MainPage;

public class ErrorMessageShouldAppearsIfMessageAreaIsEmpty extends BasicTest {

	public String subjectHeading = "Customer service";
	public String email = "foo@gmail.com";
	public String orderReference = "hello";
	
	@BeforeMethod
	public void initializePages() {
		mainPage = new MainPage();
		contactUsPage = new ContactUsPage();
	}

	@Test(description = "Verify that error Message appears if Message Area is empty")
	public void testErrorMessage() {
		mainPage.clickContactUsLink();
		contactUsPage.selectSubjectHeading(subjectHeading);
		contactUsPage.enterEmail(email);
		contactUsPage.enterOrderReference(orderReference);
		contactUsPage.clickSendButton();

		assertTrue(contactUsPage.isMessageCannotBeBlankAlertIsShown(),
				"'The message cannot be blank.' message should be visible");
		
	}

}
