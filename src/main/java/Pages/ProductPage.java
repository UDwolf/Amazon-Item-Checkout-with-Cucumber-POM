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

	public static void ValidateProductDetails(String proTitle, String proColour, String proImage, String proListIteam) throws InterruptedException {
		Thread.sleep(1000);
		String selectedProTitle = driver.findElement(By.id("productTitle")).getText();
		String selectedProColour = driver.findElement(By.id("inline-twister-expanded-dimension-text-color_name")).getText();
		String selectedProImage = driver.findElement(By.id("landingImage")).getAttribute("src").toString();
		String selectedProListIteam = driver.findElement(By.xpath("//span[@id='color_name_0']")).getAttribute("aria-checked").toString();

		if (proTitle.equals(selectedProTitle) && proImage.equals(selectedProImage) && proColour.equals(selectedProColour) && proListIteam.equals(selectedProListIteam)) {
			System.out.println("Valide....");
		} else {
			System.out.println("In valide....");
		}
	}

	public static void changingOfColourAndImage() throws InterruptedException {
		Thread.sleep(1000);
		List<WebElement> products = driver.findElements(By.xpath("//div[@id='inline-twister-expander-content-color_name']//div[@class='a-section']//div[@id='tp-inline-twister-dim-values-container']//ul//li[position()>1]"));
		System.out.println(products.size());
		
		for (int i = 0; i < products.size(); i++) {
			Thread.sleep(500);
			String selectedProColour = driver.findElement(By.id("inline-twister-expanded-dimension-text-color_name")).getText();
			String selectedProImage = driver.findElement(By.id("landingImage")).getAttribute("src").toString();

			productImgColourChange(products.get(i), selectedProColour, selectedProImage);
		}
	}

	public static void productImgColourChange(WebElement product, String colour, String Image) {
		Actions Builder = new Actions(driver);
		Builder.moveToElement(product).build().perform();
		Thread.sleep(1500);
		if()
		
	}

	/*public static void changingOfColourAndImage() throws InterruptedException {
		String prodTitle = null;
		String prodImg = null;
		Actions Builder = new Actions(driver);

		Thread.sleep(2000);

		WebElement product = driver.findElement(By.id("inline-twister-expander-content-color_name"));

		List<WebElement> products = driver.findElements(By.xpath(
				"//div[@id='inline-twister-expander-content-color_name']//div[@class='a-section']//div[@id='tp-inline-twister-dim-values-container']//ul//li[position()>1]"));

		System.out.println(product.getAttribute("data-totalvariationcount").toString());

		// Thread.sleep(1000);

		WebElement Black = driver.findElement(By.id("color_name_0"));
		WebElement White = driver.findElement(By.id("color_name_1"));
		Brown = driver.findElement(By.id("color_name_2"));

		// Thread.sleep(1500);

		System.out.println("I am in changing Image method....before for loop");

		if (products.size() > 0) {
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

	}*/

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
		String productImg = driver.findElement(By.xpath(
				"//img[@class='sc-product-image celwidget' and @alt='Utopia Bedding Adjustable Bed Furniture Risers - Elevation in Heights 3, 5 or 8 Inch Heavy Duty Risers for Sofa and Table - Supports up to 1,300 lbs - (8 Piece Set, Brown)']"))
				.getAttribute("alt").toString();
		return productImg;
	}

	public static void cart() throws InterruptedException {
		Thread.sleep(1500);
		driver.findElement(By.xpath("//span[@id='attach-sidesheet-view-cart-button']//span[@class='a-button-inner']"))
				.click();
	}

	public static String productPrice() throws InterruptedException {
		Thread.sleep(1000);
		WebElement price = driver.findElement(By.xpath(
				"//td[contains(text(),'Price:')]/parent::tr/child::td[@class=\"a-span12\"]/span[@data-a-color=\"price\"]/span[2]"));

		String priceStr = price.getText().toString();

		return priceStr;

	}
}
