package pages;

import static com.codeborne.selenide.Selenide.title;

import io.qameta.allure.Step;

public class MyAccountPage {

	private String pageTitle = "My account";

	@Step("Verify if My Account Page is opened")
	public boolean isOpen() {
		return title().contains(pageTitle);
	}

}
