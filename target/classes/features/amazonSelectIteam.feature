Feature: Amazon bedding Iteam selection and check out testing

Scenario: Validate Amazon Home page

Given user opens Browser
Then user on Home page
Then user click on Manubar-All
Then user click on Shop of Department see All
Then user click on Home and kitchen
Then user click on Bedding
Then user on bedding Page
Then user click on Feacture brands SafeRest and Ultopia Bedding
When title of page change according to brands
Then user check the rating of the product and click on it
Then user on a Product page
When title on a page chnage according to Product
Then user check the Ratings
Then user click on Add To Cart
When check if iteam is alredy in cart
Then click on process to checkout
Then user is on Sign IN page
When title of the page change to Sign In
Then user click on create your amazon account
Then user Enter all the details and click on create account
