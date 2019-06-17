package pages;

import static com.codeborne.selenide.Selenide.title;

import io.qameta.allure.Step;

public class ForgotPasswordPage {

	private String pageTitle = "Forgot your password - My Store";

	@Step("Verify if Forgot your password Page is opened")
	public boolean isOpen() {
		return title().contains(pageTitle);
	}
}
