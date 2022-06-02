package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import BaseClass.TestBase;

public class CartPage extends TestBase{
	
	public static String ValidatePageTitle() {
		String cartPageTitle = driver.getTitle();
		return cartPageTitle;
	}
	
	public static String ValidateProductPrice() throws InterruptedException {
		Thread.sleep(1000);
		WebElement price = driver.findElement(By.className("a-size-medium a-color-base sc-price sc-white-space-nowrap sc-product-price a-text-bold"));
		String priceStr = price.getText().toString();
		return priceStr;
	}
	
}
