package StepDefinations;

import BaseClass.TestBase;
import Pages.AmazonHomePage;
import Pages.BeddingPage;
import Pages.CartPage;
import Pages.ProductPage;
import Utillities.TestBaseUtill;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Ignore;


public class AmazonStepDefinations extends TestBase {

	TestBaseUtill utility = new TestBaseUtill();
	AmazonHomePage Hp = new AmazonHomePage();
	BeddingPage Bp = new BeddingPage();
	ProductPage Pp = new ProductPage();
	CartPage Cp = new CartPage();
	
	public static String productName;

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
		productName = Bp.userCheckRatings();
	}
	
	@When("^user is on product page and title on a page change according to Product$")
	public void user_is_on_product_page_and_title_on_a_page_change_according_to_Product(){
	   String actualProductPageTitle = Pp.validateProductPageTitle();
	   
	   Assert.assertTrue(actualProductPageTitle.contains(productName));
	}
	
	@Then("^header Image and colour of the product to validate$")
	public void header_Image_and_colour_of_the_product_to_validate() {
	   
	}
	
	@When("^product name and Image should change accordingly and product colour should change according to new product selection$")
	public void product_name_and_Image_should_change_accordingly_and_product_colour_should_change_according_to_new_product_selection() throws InterruptedException {
	   Pp.changingOfColourAndImage();
	}
	
	@Then("^user select brown product$")
	public void user_select_brown_product(){
	    Pp.userSelectBrownProduct();	    
	}
	
	@Then("^product header Image and colour should change to brown$")
	public void product_header_Image_and_colour_should_change_to_brown(){
	   
	}


	@Then("^product titile should change to brown$")
	public void product_titile_should_change_to_brown() throws InterruptedException{
	    String actualBrownProductTitle = ProductPage.ValidateBrownProductTitle();
	    String expectedBrownPeoductTitle = TestBaseUtill.BROWN_PRODUCT_TITLE;
	    
	    System.out.println("I am at stepDe: "+actualBrownProductTitle);
	    
	    Assert.assertEquals(expectedBrownPeoductTitle, actualBrownProductTitle);
	}

	@Then("^user click on Add To Cart$")
	public void user_click_on_Add_To_Cart() {
	    ProductPage.addToCart();
	}

	@Then("^new frame should show up for cart$")
	public void new_frame_should_show_up_for_cart() throws InterruptedException {
	   String actulProcustTitileInCart = ProductPage.ValidateProductInCartFrame();
	   String expectedProductTitileInCart = TestBaseUtill.BROWN_PRODUCT_TITLE;
	   
	   System.out.println("I am in StepDe: "+actulProcustTitileInCart);
	   Assert.assertEquals(actulProcustTitileInCart, expectedProductTitileInCart);
	}

	@Then("^user click on cart\\.$")
	public void user_click_on_cart() throws InterruptedException {
	    ProductPage.cart();
	}

	@Given("^user is on Shopping cart page$")
	public void user_is_on_Shopping_cart_page(){
	    String expectedCartPageTitle = TestBaseUtill.AMZON_SHOPPING_CART_PAGE_TITLE;
	    String actualCartPageTitle = CartPage.ValidatePageTitle();
	    
	    Assert.assertEquals(expectedCartPageTitle, actualCartPageTitle);
	}

	@When("^check if iteam is alredy in cart$")
	public void check_if_iteam_is_alredy_in_cart() throws InterruptedException  {
		String actulProcustTitileInCart = ProductPage.ValidateProductInCartFrame();
		   String expectedProductTitileInCart = TestBaseUtill.BROWN_PRODUCT_TITLE;
		   
		   System.out.println("I am in StepDe: "+actulProcustTitileInCart);
		   Assert.assertEquals(actulProcustTitileInCart, expectedProductTitileInCart);
	}
	
	@When("^Check the price of product match with actual price$")
	public void check_the_price_of_product_match_with_actual_price() throws InterruptedException{
	    String actualProductPriceProductPage = ProductPage.productPrice();
	    String expectedProductPriceCartPage = CartPage.ValidateProductPrice();
	    
	    Assert.assertEquals(expectedProductPriceCartPage, actualProductPriceProductPage);
	}

	@When("^user select two iteams from qty$")
	public void user_select_two_iteams_from_qty() {
	   
	}

	@Then("^Sutotal will change accordingly$")
	public void sutotal_will_change_accordingly() {
	   
	}


	@Then("^click on process to checkout$")
	public void click_on_process_to_checkout(){
	   
	}

	@Given("^user is on Sign-in page\\.$")
	public void user_is_on_Sign_in_page()  {
	   
	}

	@Then("^user click on create your amazon account$")
	public void user_click_on_create_your_amazon_account() {
	    
	}

	@Given("^User is on create account page\\.$")
	public void user_is_on_create_account_page() {
	    
	}

	@Then("^user Enter all the details and click on create account$")
	public void user_Enter_all_the_details_and_click_on_create_account() {
	    
	}
	
}
