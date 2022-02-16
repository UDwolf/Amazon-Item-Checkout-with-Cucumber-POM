package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import BaseClass.TestBase;

public class AmazonHomePage extends TestBase {

	@FindBy(id = "nav-hamburger-menu")
	WebElement HomePageAll;

	@FindBy(xpath = "//div[@id='hmenu-content']/ul/li[11]/a[1]")
	WebElement seeAllShopByDepartment;

	@FindBy(xpath = "//div[contains(text(),'Home and Kitchen')]")
	WebElement HomeAndKitchnen;

	@FindBy(xpath = "//a[contains(text(),'Bedding')]")
	WebElement Bedding;

	public String validateHomePageTitle() {
		return driver.getTitle();
	}

	public void clickOnManuBarAll() {
		// WebElement HomePageAll = driver.findElement(By.id("nav-hamburger-menu"));
		HomePageAll.click();
	}

	public void clickOnSeeAll() throws InterruptedException {
		// System.out.println(seeAllShopByDepartment.getLocation());
		// Thread.sleep(1000);
		// WebElement seeAllShopByDepartment =
		// driver.findElement(By.xpath("//div[@id='hmenu-content']/ul/li[11]/a[1]"));
		seeAllShopByDepartment.click();
	}

	public void ClickOnHomeAndKitchen() {
		HomeAndKitchnen.click();
	}

	public BeddingPage clickOnBedding() {
		Bedding.click();
		return new BeddingPage();
	}

}
