package Pages;

import BaseClass.TestBase;

public class CartPage extends TestBase{
	
	public static String ValidatePageTitle() {
		String cartPageTitle = driver.getTitle();
		return cartPageTitle;
	}
	
}
