package pages;

import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.*;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import io.qameta.allure.Step;

public class ContactUsPage {

	private SelenideElement subjectHeadingSelect = $(By.id("id_contact"));
	private SelenideElement emailInput = $(By.id("email"));
	private SelenideElement orederReferenceInput = $(By.id("id_order"));
	private SelenideElement meassgeTxtArea = $(By.id("message"));
	private SelenideElement sendButton = $(By.id("submitMessage"));
	private SelenideElement alertMessage = $(By.xpath("//*[contains(@class,'alert')]"));

	@Step("Select subject heading: {subject}")
	public void selectSubjectHeading(String subject) {
		executeJavaScript("$('#id_contact').attr('style','display:block;')");
		subjectHeadingSelect.selectOption(subject);
	}

	@Step("Enter email: {email}")
	public void enterEmail(String email) {
		emailInput.setValue(email);
	}

	@Step("Enter Order Reference: {orderReference}")
	public void enterOrderReference(String orderReference) {
		orederReferenceInput.setValue(orderReference);
	}

	@Step("Enter message: {message}")
	public void enterMessage(String message) {
		meassgeTxtArea.setValue(message);
	}

	@Step("Click Send button")
	public void clickSendButton() {
		sendButton.click();
	}

	@Step("Verify is 'Message Cannot Be Blank Message' is Shown")
	public boolean isMessageCannotBeBlankAlertIsShown() {
		return alertMessage.text().contains("The message cannot be blank.");
	}

	@Step("Verify is 'Message has been successfully sent' is Shown")
	public boolean isMessageHasBeenSentSuccessfullyAlertIsShown() {
		return alertMessage.text().contains("Message has been successfully sent");
	}

}
