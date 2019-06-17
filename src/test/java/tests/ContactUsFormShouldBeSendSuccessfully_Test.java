package tests;

import static org.testng.Assert.assertTrue;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ContactUsPage;
import pages.MainPage;

public class ContactUsFormShouldBeSendSuccessfully_Test extends BasicTest {

	private String subjectHeading;
	private String email;
	private String orderReference;
	private String message;
	private static String filePath = System.getProperty("user.dir") + File.separator + "ContactUsData.txt"
			+ File.separator;

	@BeforeMethod
	public void initializePages() throws IOException {
		mainPage = new MainPage();
		contactUsPage = new ContactUsPage();
		File file = new File(filePath);
		BufferedReader br = new BufferedReader(new FileReader(file));
		String st;
		String data = "";
		while ((st = br.readLine()) != null) {
			System.out.println(st);
			data = st;
		}
		String [] arr = data.split(",");
		subjectHeading = arr[0];
		email = arr[1];
		orderReference = arr[2];
		message = arr[3];
	}

	@Test(description = "Verify that Contact Us Form can be send successfully")
	public void testSuccessfullMessage() {
		
		mainPage.clickContactUsLink();
		contactUsPage.selectSubjectHeading(subjectHeading);
		contactUsPage.enterEmail(email);
		contactUsPage.enterOrderReference(orderReference);
		contactUsPage.enterMessage(message);
		contactUsPage.clickSendButton();
		
		assertTrue(contactUsPage.isMessageHasBeenSentSuccessfullyAlertIsShown(), "'Message has been successfully sent' alert message should be visible ");

	}

}
