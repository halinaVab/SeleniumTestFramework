package pages;

import static com.codeborne.selenide.Selenide.$;

import org.openqa.selenium.By;

import com.codeborne.selenide.SelenideElement;

import io.qameta.allure.Step;

public class SigninPage {

	private SelenideElement emailInput = $(By.id("email"));
	private SelenideElement passwordInput = $(By.id("passwd"));
	private SelenideElement signinButton = $(By.id("SubmitLogin"));
	private SelenideElement crateEmailInput = $(By.id("email_create"));
	private SelenideElement crateAccountButton = $(By.id("SubmitCreate"));
	private SelenideElement alertMessage = $(By.xpath("//*[contains(@class,'alert')]"));
	private SelenideElement forgotPasswordLink = $(By.xpath("//a[text()='Forgot your password?']"));

	@Step("Enter email to create an account {email}")
	public void enterEmailToCreateAccount(String email) {
		crateEmailInput.setValue(email);
	}

	@Step("Click create an account button")
	public void clickCreateAccountButton() {
		crateAccountButton.click();
	}

	@Step("Enter email {email}")
	public void enterEmail(String email) {
		emailInput.setValue(email);
	}

	@Step("Enter passowrd {password}")
	public void enterPassword(String password) {
		passwordInput.setValue(password);
	}

	@Step("Click Sign in button")
	public void clickSiginButton() {
		signinButton.click();
	}

	@Step("Click Forgot Password link")
	public void clickForgotPasswordLink() {
		forgotPasswordLink.click();
	}

	@Step("Sign in with email: {email} , pasword: {password} and click Sign in button")
	public void signin(String email, String password) {
		enterEmail(email);
		enterPassword(password);
		clickSiginButton();
	}

	@Step("Click Sign in button")
	public boolean isAuthenticationFailedMessageIsShown() {
		return alertMessage.text().contains("Authentication failed.");
	}

}
