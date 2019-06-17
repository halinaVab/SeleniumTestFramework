package pages;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

import org.openqa.selenium.By;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import io.qameta.allure.Step;

public class SearchResultPage {

	private ElementsCollection resultProducts = $$(
			By.xpath("//div[@class='product-container']//a[@class='product-name']"));
	private SelenideElement continueShoppingButton = $(By.xpath("//span[@title='Continue shopping']"));
	private SelenideElement proceedToCheckOutButton = $(By.xpath("//a[@title='Proceed to checkout']"));
	private SelenideElement viewCartButton = $(By.xpath("//a[@title='View my shopping cart']"));
	private SelenideElement addToCartWindow = $("#layer_cart");

	@Step("Verify if search results contains product: {productName}")
	public boolean isSearchResultsContainsProduct(String productName) {
		for (SelenideElement product : resultProducts) {
			if (product.text().equals(productName)) {
				return true;
			}
		}
		return false;
	}

	@Step("Add product: {productName} to cart")
	public void addProductToCart(String productName) {
		for (SelenideElement product : resultProducts) {
			if (product.text().equals(productName)) {
				product.hover();
				product.find(By.xpath("//a[@title='Add to cart']")).click();
				addToCartWindow.shouldBe(Condition.visible);
				break;
			}
		}
	}

	@Step("Click Continue shopping button")
	public void clickContinueShoppingButton() {
		continueShoppingButton.shouldBe(Condition.visible).click();
		addToCartWindow.shouldNot(Condition.visible);
	}

	@Step("Click view shopping cart button")
	public void clickViewShoppingCartButton() {
		viewCartButton.click();
	}

	@Step("Click Proceed to checkout button")
	public void clickProceedToCheckoutButton() {
		proceedToCheckOutButton.click();
		addToCartWindow.shouldNot(Condition.visible);
	}
}
