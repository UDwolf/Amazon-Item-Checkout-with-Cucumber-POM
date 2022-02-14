package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
	
	public AmazonHomePage() {
		super();
		//PageFactory.initElements(driver, this);
	}
	
	public String validateHomePageTitle() {
		return driver.getTitle();
	}
	
	public void clickOnManuBarAll() {
		//WebElement HomePageAll = driver.findElement(By.id("nav-hamburger-menu"));
		HomePageAll.click();
	}
	
	public void clickOnSeeAll() throws InterruptedException {
		//System.out.println(seeAllShopByDepartment.getLocation());
		//Thread.sleep(1000);
		//WebElement seeAllShopByDepartment = driver.findElement(By.xpath("//div[@id='hmenu-content']/ul/li[11]/a[1]"));
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
