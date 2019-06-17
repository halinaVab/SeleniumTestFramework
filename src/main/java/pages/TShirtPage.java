package pages;

import static com.codeborne.selenide.Selenide.title;

import io.qameta.allure.Step;

public class TShirtPage {

	private String pageTitle = "T-shirts";

	@Step("Verify if T-Shirt Page is opened")
	public boolean isOpen() {
		return title().contains(pageTitle);
	}

}
