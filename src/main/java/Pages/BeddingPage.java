package Pages;

import java.time.Duration;
import java.util.List;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import BaseClass.TestBase;
import Utillities.TestBaseUtill;

public class BeddingPage extends TestBase {
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

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
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[@class='a-size-base a-color-base'][contains(text(),'SafeRest')]"))));
		driver.findElement(By.xpath("//span[@class='a-size-base a-color-base'][contains(text(),'SafeRest')]")).click();
		//Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[contains(text(),'Utopia Bedding')][@class='a-size-base a-color-base']"))));
		driver.findElement(By.xpath("//span[contains(text(),'Utopia Bedding')][@class='a-size-base a-color-base']"))
				.click();
	}

	public String validateBeddingPageTitle() {
		return driver.getTitle();
	}
	
	public String userCheckRatings() throws InterruptedException {
		WebElement product = driver.findElement(By.xpath("//img[@alt='Utopia Bedding Adjustable Bed Furniture Risers - Elevation in Heights 3, 5 or 8 Inch Heavy Duty Risers for Sofa and Table...']"));
		String productName = driver.findElement(By.xpath("//span[contains(text(),'Utopia Bedding Adjustable Bed Furniture Risers - E')]")).getText();
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView(true);",product);
		//jse.executeScript("arguments[0].scroll", args)
		if(product != null) {
			//WebElement Starts = driver.findElement(By.xpath("(//a[@class='a-popover-trigger a-declarative'])[13]"));
			WebElement Stars = driver.findElement(By.xpath("//span[contains(text(),'Utopia Bedding Adjustable Bed Furniture Risers - E')]/parent::a/parent::h2/parent::div/following-sibling::div//span[@aria-label=\"4.5 out of 5 stars\"]"));
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
		
		return productName;
	}

}
