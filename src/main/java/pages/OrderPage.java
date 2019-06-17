package pages;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.executeJavaScript;

import org.openqa.selenium.By;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import io.qameta.allure.Step;

public class OrderPage {

	private ElementsCollection productsInCart = $$(By.xpath("//td//p[@class='product-name']"));
	private ElementsCollection proceedToCheckOutButton = $$(By.xpath(
			"(//a[@title='Proceed to checkout'])[2]| //p[contains(@class,'cart_navigation')]//button[@type='submit']"));
	private SelenideElement agreeTermsCheckBox = $(By.xpath("//input[@id='cgv']"));
	private SelenideElement confirmOrderBut = $(By.xpath("(//button[@type='submit'])[2]"));
	private SelenideElement payByBankWireButton = $(By.xpath("//a[@title='Pay by bank wire']"));
	private SelenideElement backToOrdersLink = $(By.xpath("//a[@title='Back to orders']"));

	@Step("Verify if cart contains product: {productName}")
	public boolean isCartContainsProduct(String productName) {
		for (SelenideElement product : productsInCart) {
			if (product.text().equals(productName)) {
				return true;
			}
		}
		return false;
	}

	@Step("Delte product: {productName} from cart")
	public void deleteProductFromCart(String productName) {
		for (SelenideElement product : productsInCart) {
			if (product.text().equals(productName)) {
				product.find(By.xpath("//a[@title='Delete']")).click();
				product.find(By.xpath("//a[@title='Delete']")).shouldNotBe(Condition.visible);
				break;
			}
		}
	}

	@Step("Click Proceed to checkout button")
	public void clickProceedToCheckoutButton() {
		for (SelenideElement button : proceedToCheckOutButton) {
			if (button.isDisplayed()) {
				button.click();
				break;
			}
		}
	}

	@Step("Click Agree terms check box")
	public void clickAgreeTermsCheckBox() {
		agreeTermsCheckBox.toWebElement().click();
	}

	@Step("Click Confirm Order button")
	public void clickConfirmOrderButton() {
		confirmOrderBut.click();
	}

	@Step("Click Pay by Bank Ware Button")
	public void clickPayByBankWareButton() {
		payByBankWireButton.click();
	}

	@Step("Click Back to Orders button")
	public void clickBackToOrdersLink() {
		backToOrdersLink.click();
	}
}
