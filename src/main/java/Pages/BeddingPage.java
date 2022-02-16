package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import BaseClass.TestBase;

public class BeddingPage extends TestBase {

	public String validateBeddingPage() {
		List<WebElement> beddingList = driver.findElements(
				By.xpath("//select[@id='searchDropdownBox' and @aria-describedby='searchDropdownDescription']/option"));

		String isSelected = null;

		// System.out.println(beddingList.size());
		/*
		 * for (int i = 0; i < beddingList.size(); i++) { //
		 * System.out.println(beddingList.get(i).getText()); if
		 * (beddingList.get(i).isSelected()) { //
		 * System.out.println(beddingList.get(i).getText() + "......Is selected");
		 * isSelected = beddingList.get(i).getText(); } }
		 */

		for (WebElement e : beddingList) {
			if (e.isSelected()) {
				isSelected = e.getText();
			}
		}
		return isSelected;
	}

	public void ShortBrands() throws InterruptedException {
		driver.findElement(By.xpath("//span[@class='a-size-base a-color-base'][contains(text(),'SafeRest')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[contains(text(),'Utopia Bedding')][@class='a-size-base a-color-base']"))
				.click();
	}

	public String validateBeddingPageTitle() {
		return driver.getTitle();
	}
	
	public void userCheckRatings() throws InterruptedException {
		WebElement product = driver.findElement(By.xpath("//img[@alt='Utopia Bedding Adjustable Bed Furniture Risers - Elevation in Heights 3, 5 or 8 Inch Heavy Duty Risers for Sofa and Table...']"));
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView(true);",product);
		//jse.executeScript("arguments[0].scroll", args)
		if(product != null) {
			//WebElement Starts = driver.findElement(By.xpath("(//a[@class='a-popover-trigger a-declarative'])[13]"));
			WebElement Stars = driver.findElement(By.xpath("//div[@class='s-widget-container s-spacing-small s-widget-container-height-small celwidget slot=MAIN template=SEARCH_RESULTS widgetId=search-results_11']//div[@class='s-card-container s-overflow-hidden aok-relative s-expand-height s-include-content-margin s-latency-cf-section s-card-border']//div[@class='a-section a-spacing-base']//div[@class='a-section a-spacing-small s-padding-left-small s-padding-right-small']//div[@class='a-section a-spacing-none a-spacing-top-micro']//div[@class='a-row a-size-small']//span[@aria-label='4.5 out of 5 stars']//span[@class='a-declarative']//a[@class='a-popover-trigger a-declarative']//i[@class='a-icon a-icon-star-small a-star-small-4-5 aok-align-bottom']"));
			Thread.sleep(1000);
			Actions Builder = new Actions(driver);
			Builder.moveToElement(Stars).build().perform();
			Stars.click();
			Thread.sleep(1500);
			product.click();
		}
		else {
			System.out.println("oopps...");
		}
	}

}
