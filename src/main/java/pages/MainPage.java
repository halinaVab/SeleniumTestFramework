package pages;

import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.*;
import com.codeborne.selenide.SelenideElement;

import io.qameta.allure.Step;

public class MainPage {

	private SelenideElement contactUsLink = $(By.xpath("//div[@id='contact-link']//a"));
	private SelenideElement signinLink = $(".login");
	private SelenideElement searchInput = $(By.id("search_query_top"));
	private SelenideElement searchButton = $(By.xpath("//button[@name='submit_search']"));
	private SelenideElement tShirtsTab = $(By.xpath("(//a[@title='T-shirts'])[2]"));
	private SelenideElement address = $(By.xpath("//section[@id='block_contact_infos']//li[1]"));
	private SelenideElement phoneNumber = $(By.xpath("//section[@id='block_contact_infos']//li[2]"));
	private SelenideElement email = $(By.xpath("//section[@id='block_contact_infos']//li[3]//a"));

	@Step("Click Contact Us Link")
	public void clickContactUsLink() {
		contactUsLink.click();
	}

	@Step("Click Sign in link")
	public void clickSignInLink() {
		signinLink.click();
	}

	@Step("Search for Product: {productName}")
	public void searchForProduct(String productName) {
		searchInput.setValue(productName);
		searchButton.click();
	}

	@Step("Click on T-Shirts tab")
	public void clickOnTshirtsTab() {
		tShirtsTab.click();
	}

	@Step("Verify if store information present on Main Page")
	public boolean isStoreInfoPresentOnPageWithData(String expectedAddress, String expectedPhoneNumber,
			String expectedEmail) {
		String actualAddress = address.text().replaceAll("\\r\\n", " ");
		String actualPhoneNumber = phoneNumber.text().replace("Call us now: ", "");
		String actualEmail = email.text();
		return (actualAddress.equals(expectedAddress) && actualPhoneNumber.equals(expectedPhoneNumber)
				&& actualEmail.equals(actualEmail));
	}
}
