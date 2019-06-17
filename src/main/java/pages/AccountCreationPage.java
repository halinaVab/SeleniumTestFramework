package pages;

import static com.codeborne.selenide.Selenide.$;

import org.openqa.selenium.By;

import com.codeborne.selenide.SelenideElement;

import io.qameta.allure.Step;

public class AccountCreationPage {

	private SelenideElement maleGender = $(By.id("id_gender1"));
	private SelenideElement femaleGender = $(By.id("id_gender2"));
	private SelenideElement firstNameInput = $(By.id("customer_firstname"));
	private SelenideElement lastNameInput = $(By.id("customer_lastname"));
	private SelenideElement passwordInput = $(By.id("passwd"));

	private SelenideElement adressFirstNameInput = $(By.id("firstname"));
	private SelenideElement adressLastNameInput = $(By.id("lastname"));
	private SelenideElement adressInput = $(By.id("address1"));
	private SelenideElement cityInput = $(By.id("city"));
	private SelenideElement stateSelect = $(By.id("id_state"));
	private SelenideElement postCodeInput = $(By.id("postcode"));
	private SelenideElement countrySelect = $(By.id("id_country"));
	private SelenideElement phoneMobileInput = $(By.id("phone_mobile"));
	private SelenideElement adressAliasInput = $(By.id("alias"));
	private SelenideElement registerButton = $(By.id("submitAccount"));

	@Step("Select Female gender")
	public void selectFemaleGender() {
		femaleGender.click();
	}

	@Step("Select Male gender")
	public void selectMaleGender() {
		maleGender.click();
	}

	@Step("Enter first name {firstName}")
	public void enterFirstName(String firstName) {
		firstNameInput.val(firstName);
	}

	@Step("Enter last name {lastName}")
	public void enterLastName(String lastName) {
		lastNameInput.val(lastName);
	}

	@Step("Enter password {password}")
	public void enterPassword(String password) {
		passwordInput.val(password);
	}

	@Step("Enter first name for adress {adressFirstName}")
	public void enterFirstNameForAdress(String adressFirstName) {
		adressFirstNameInput.val(adressFirstName);
	}

	@Step("Enter last name for adress {adressLastName}")
	public void enterLastNameForAdress(String adressLastName) {
		adressLastNameInput.val(adressLastName);
	}

	@Step("Enter  adress {adress}")
	public void enterAdress(String adress) {
		adressInput.val(adress);
	}

	@Step("Enter city {city}")
	public void enterCity(String city) {
		cityInput.val(city);
	}

	@Step("Select state {state}")
	public void selectState(String state) {
		stateSelect.selectOption(state);
	}

	@Step("Enter postCode {postCode}")
	public void enterPostCode(String postCode) {
		postCodeInput.val(postCode);
	}

	@Step("Select country {country}")
	public void selectsCountry(String country) {
		countrySelect.selectOption(country);
	}

	@Step("Enter phone {phone}")
	public void enterPhone(String phone) {
		phoneMobileInput.val(phone);
	}

	@Step("Enter alias adress {aliasAdress}")
	public void enterAliasAdress(String aliasAdress) {
		adressAliasInput.val(aliasAdress);
	}

	@Step("Click Register Button")
	public void clickRegisterButton() {
		registerButton.click();
	}

	@Step("Fill in User info")
	public void fillInUserInfo(String gender, String firstName, String lastName, String password) {
		if (gender.equals("Male"))
			selectMaleGender();
		else if (gender.equals("Female")) {
			selectFemaleGender();
		}
		enterFirstName(firstName);
		enterLastName(lastName);
		enterPassword(password);
	}

	@Step("Fill in Adress info")
	public void fillInAdressInfo(String adressFirstName, String adressLastName, String adress, String city,
			String state, String postCode, String country, String phone, String aliasAdress) {
		enterFirstNameForAdress(adressFirstName);
		enterLastNameForAdress(adressLastName);
		enterAdress(adress);
		enterCity(city);
		selectState(state);
		enterPostCode(postCode);
		selectsCountry(country);
		enterPhone(phone);
		enterAliasAdress(aliasAdress);
	}

}
