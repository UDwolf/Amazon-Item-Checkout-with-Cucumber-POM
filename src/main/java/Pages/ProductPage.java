package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import BaseClass.TestBase;

public class ProductPage extends TestBase {

	public static WebElement Brown;

	public String validateProductPageTitle() {
		return driver.getTitle();
	}

	public void changingOfColourAndImage() throws InterruptedException {
		String prodTitle = null;
		String prodImg = null;
		Actions Builder = new Actions(driver);

		Thread.sleep(1500);

		List<WebElement> products = driver.findElements(By.xpath(
				"//ul[@class='a-unordered-list a-nostyle a-button-list a-declarative a-button-toggle-group a-horizontal a-spacing-top-micro swatches swatchesSquare imageSwatches']//li"));
		WebElement Black = driver.findElement(By.id("color_name_0"));
		WebElement White = driver.findElement(By.id("color_name_1"));
		Brown = driver.findElement(By.id("color_name_2"));

		Thread.sleep(1500);

		System.out.println("I am in changing Image method....before for loop");

		if (products.size() != 0) {
			for (int i = 0; i < products.size(); i++) {
				System.out.println("I am in changing Image method....After for loop");
				if (products.get(i).getAttribute("class").equals("swatchSelect")) {
					System.out.println("I am in changing Image method....After for loop.....After first If condition");
					if (products.get(i).getAttribute("title").equals("Click to select Black")) {
						System.out.println(
								"I am in changing Image method....After for loop.....After second If condition");
						prodTitle = driver.findElement(By.xpath("//span[@class='selection'][contains(text(),'Black')]"))
								.getText();
						if (prodTitle.equals("Black")) {
							System.out.println("Pass / Title ... When Black was Selected");

							prodImg = driver.findElement(By.id("landingImage")).getAttribute("src");
							if (prodImg.contains("https://m.media-amazon.com/images/I/81GgWnGkPTL._AC_SX466_.jpg")) {
								System.out.println("Pass / Image ... When Black was Selected");
							} else {
								System.out.println("Failed / Image ... When Black was Selected");
							}
						} else {
							System.out.println("Failed / Title ... When Black was Selected");

							prodImg = driver.findElement(By.id("landingImage")).getAttribute("src");
							if (prodImg.contains("https://m.media-amazon.com/images/I/81GgWnGkPTL._AC_SX466_.jpg")) {
								System.out.println("Pass / Image ... When Black was Selected");
							} else {
								System.out.println("Failed / Image ... When Black was Selected");
							}
						}

						Builder.moveToElement(White).build().perform();

						Thread.sleep(1500);
						prodTitle = driver
								.findElement(By.xpath("//span[@class='selection hover'][contains(text(),'White')]"))
								.getText();
						if (prodTitle.equals("White")) {
							System.out.println("Pass / Title ... When Black was Selected and Hover over White");

							prodImg = driver.findElement(By.xpath(
									"//img[starts-with(@data-old-hires,'https://m.media-amazon.com/images/I/') and @class='a-dynamic-image'][1]"))
									.getAttribute("src");
							if (prodImg.contains("https://m.media-amazon.com/images/I/61XIF4NGbwL._AC_SX466_.jpg")) {
								System.out.println("Pass / Image ... When Black was Selected and Hover over White");
							} else {
								System.out.println("Pass / Image ... When Black was Selected and Hover over White");
							}
						} else {
							System.out.println("Failed / Title ... When Black was Selected and Hover over White");

							prodImg = driver.findElement(By.xpath(
									"//img[starts-with(@data-old-hires,'https://m.media-amazon.com/images/I/') and @class='a-dynamic-image'][1]"))
									.getAttribute("src");
							if (prodImg.contains("https://m.media-amazon.com/images/I/61XIF4NGbwL._AC_SX466_.jpg")) {
								System.out.println("Pass / Image ... When Black was Selected and Hover over White");
							} else {
								System.out.println("Pass / Image ... When Black was Selected and Hover over White");
							}
						}

						Builder.moveToElement(Brown).build().perform();
						Thread.sleep(1500);
						prodTitle = driver
								.findElement(By.xpath("//span[@class='selection hover'][contains(text(),'Brown')]"))
								.getText();
						if (prodTitle.equals("Brown")) {
							System.out.println("Pass / Title ... When Black was Selected and Hover over Brown");

							prodImg = driver.findElement(By.xpath(
									"//img[starts-with(@data-old-hires,'https://m.media-amazon.com/images/I/') and @class='a-dynamic-image'][1]"))
									.getAttribute("src");
							if (prodImg.contains("https://m.media-amazon.com/images/I/81Cb8-H+GlL._AC_SX466_.jpg")) {
								System.out.println("Pass / Image ... When Black was Selected and Hover over Brown");
							} else {
								System.out.println("Pass / Image ... When Black was Selected and Hover over Brown");
							}
						} else {
							System.out.println("Failed / Title ... When Black was Selected and Hover over Brown");

							prodImg = driver.findElement(By.xpath(
									"//img[starts-with(@data-old-hires,'https://m.media-amazon.com/images/I/') and @class='a-dynamic-image'][1]"))
									.getAttribute("src");
							if (prodImg.contains("https://m.media-amazon.com/images/I/81Cb8-H+GlL._AC_SX466_.jpg")) {
								System.out.println("Pass / Image ... When Black was Selected and Hover over Brown");
							} else {
								System.out.println("Pass / Image ... When Black was Selected and Hover over Brown");
							}
						}
					} else {
						System.out.println("Opppppssss.....not black");
					}
				} else {
					System.out.println("Opppssss....swatch is not selected");
				}
			}
		} else {
			System.out.println("Opppsss....produstList empty");
		}

	}

	public void userSelectBrownProduct() {
		Brown.click();
	}

	public static String ValidateBrownProductTitle() throws InterruptedException {
		Thread.sleep(1500);
		String expectedBrownHeader = driver.findElement(By.xpath("//span[@id='productTitle']")).getText().toString();
		return expectedBrownHeader;
	}

	public static void addToCart() {
		driver.findElement(By.id("add-to-cart-button")).click();
	}

	public static String ValidateProductInCartFrame() throws InterruptedException {
		Thread.sleep(1500);
		String productImg = driver.findElement(By.xpath("//img[@class='sc-product-image celwidget']"))
				.getAttribute("alt").toString();
		return productImg;
	}

	public static void cart() throws InterruptedException {
		Thread.sleep(1500);
		driver.findElement(By.xpath("//span[@id='attach-sidesheet-view-cart-button']//span[@class='a-button-inner']"))
				.click();
	}
}
