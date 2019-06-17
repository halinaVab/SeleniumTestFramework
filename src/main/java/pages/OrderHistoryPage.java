package pages;

import static com.codeborne.selenide.Selenide.$;

import org.openqa.selenium.By;

import com.codeborne.selenide.SelenideElement;

import io.qameta.allure.Step;

public class OrderHistoryPage {

	private SelenideElement lastOrderDetailsButton = $(
			By.xpath("//tr[1]//td[contains(@class,'history_detail')]//a[1]"));
	private SelenideElement orderedProduct = $(
			By.xpath("//div[@id='order-detail-content']//tr[@class='item']//td[@class='bold']"));

	@Step("Click on Last Order Details button")
	public void clickLastOrderDetailsButton() {
		lastOrderDetailsButton.click();
	}

	@Step("Get Ordered Product")
	public String getOrderedProduct() {
		return orderedProduct.text();
	}

	@Step("")
	public boolean isOrderContainProduct(String productName) {
		return orderedProduct.text().contains(productName);
	}
}
