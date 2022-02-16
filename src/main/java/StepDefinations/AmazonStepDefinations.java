package StepDefinations;

import BaseClass.TestBase;
import Pages.AmazonHomePage;
import Pages.BeddingPage;
import Utillities.TestBaseUtill;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class AmazonStepDefinations extends TestBase {

	TestBaseUtill utility = new TestBaseUtill();
	AmazonHomePage Hp = new AmazonHomePage();
	BeddingPage Bp = new BeddingPage();

	@Given("^user opens Browser$")
	public void user_opens_Browser() {
		Hp.openBrowser();
		// System.out.println("I am in Open browser");
	}

	@Then("^user on Home page$")
	public void user_on_Home_page() {
		String ActualHomePageTitle = Hp.validateHomePageTitle();
		String expectedHomePageTitle = TestBaseUtill.AMAZON_HOMEPAGE_TITLE;

		Assert.assertEquals(expectedHomePageTitle, ActualHomePageTitle);
	}

	@Then("^user click on Manubar-All$")
	public void user_click_on_Manubar_All() throws InterruptedException {
		Thread.sleep(1000);
		Hp.clickOnManuBarAll();
	}

	@Then("^user click on Shop of Department see All$")
	public void user_click_on_Shop_of_Department_see_All() throws InterruptedException {
		// System.out.println("I am in Shop Department");
		Thread.sleep(2000);
		Hp.clickOnSeeAll();
	}

	@Then("^user click on Home and kitchen$")
	public void user_click_on_Home_and_kitchen() throws InterruptedException {
		Thread.sleep(1000);
		Hp.ClickOnHomeAndKitchen();
	}

	@Then("^user click on Bedding$")
	public void user_click_on_Bedding() throws InterruptedException {
		Thread.sleep(1000);
		Hp.clickOnBedding();
	}

	@Then("^user on bedding Page$")
	public void user_on_bedding_Page() throws InterruptedException {
		Thread.sleep(1000);
		String actualSelectedOption = Bp.validateBeddingPage();
		String expectedSelectedOption = TestBaseUtill.BEDDING_PAGE_SELECTED_OPTION;

		Assert.assertEquals(expectedSelectedOption, actualSelectedOption);
	}

	@Then("^user click on Feacture brands SafeRest and Ultopia Bedding$")
	public void user_click_on_Feacture_brands_SafeRest_and_Ultopia_Bedding() throws InterruptedException {
		Thread.sleep(1000);
		Bp.ShortBrands();
	}

	@When("^title of page change according to brands$")
	public void title_of_page_change_according_to_brands() throws InterruptedException {
		Thread.sleep(1000);
		String actualBeddingPageTitle = Bp.validateBeddingPageTitle();
		String expectedBeddingPageTitle = TestBaseUtill.BEDDING_PAGE_TITLE;
		
		Assert.assertEquals(expectedBeddingPageTitle, actualBeddingPageTitle);
	}

	@Then("^user check the rating of the product and click on it$")
	public void user_check_the_rating_of_the_product_and_click_on_it() throws InterruptedException  {
	    Bp.userCheckRatings();
	}

	@Then("^user on a Product page$")
	public void user_on_a_Product_page() {
	}

	@When("^title on a page chnage according to Product$")
	public void title_on_a_page_chnage_according_to_Product() {
	}

	@Then("^user check the Ratings$")
	public void user_check_the_Ratings() {
	}

	@Then("^user click on Add To Cart$")
	public void user_click_on_Add_To_Cart() {
	}

	@When("^check if iteam is alredy in cart$")
	public void check_if_iteam_is_alredy_in_cart() {
	}

	@Then("^click on process to checkout$")
	public void click_on_process_to_checkout() {
	}

	@Then("^user is on Sign IN page$")
	public void user_is_on_Sign_IN_page() {
	}

	@When("^title of the page change to Sign In$")
	public void title_of_the_page_change_to_Sign_In() {
	}

	@Then("^user click on create your amazon account$")
	public void user_click_on_create_your_amazon_account() {
	}

	@Then("^user Enter all the details and click on create account$")
	public void user_Enter_all_the_details_and_click_on_create_account() {

	}

}
