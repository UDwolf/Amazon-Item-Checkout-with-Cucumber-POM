package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseClass.TestBase;

public class AmazonHomePage extends TestBase {
	@FindBy(xpath = "//a[contains(text(),'Sign in')]")
	WebElement btnSignIn;
	
	@FindBy(xpath = "//a[@id='nav-hamburger-menu']")
	WebElement HomePageAll;
	
	/*@FindBy(xpath = "//div[@id='hmenu-content']/ul/li[11]/a/div[contains(text(),'see all')]")
	WebElement seeAllShopByDepartment;*/
	
	@FindBy(xpath = "//div[@id='hmenu-content']/ul/li[11]/a[1]")
	WebElement seeAllShopByDepartment;
	
	public AmazonHomePage() {
		super();
		PageFactory.initElements(driver, this);
	}
	
	public String validateHomePageTitle() {
		return driver.getTitle();
	}
	
	public void clickOnManuBarAll() {
		HomePageAll.click();
	}
	
	public void clickOnSeeAll() {
		//System.out.println(seeAllShopByDepartment.getLocation());
		seeAllShopByDepartment.click();
	}

}
