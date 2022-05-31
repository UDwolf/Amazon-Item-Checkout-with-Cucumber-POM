Feature: Amazon bedding Iteam selection and check out testing

Scenario: Validate Amazon Home page

Given user opens Browser
Then user on Home page
Then user click on Manubar-All
Then user click on Shop of Department see All
Then user click on Home and kitchen
Then user click on Bedding 

Scenario: Validate Bedding Page

Then user on bedding Page
Then user click on Feacture brands SafeRest and Ultopia Bedding
When title of page change according to brands
Then user check the rating of the product and click on it

Scenario: Validate Product Page

Then user is on product page and title on a page change according to Product
When product name and Image should change accordingly and product title should change according to new product selection
Then user select brown product
And product titile should change to brown
Then user click on Add To Cart
And new frame should show up for cart
Then user click on cart.

Scenario: Validate cart page

Given user is on Shopping cart page
When check if iteam is alredy in cart

Then click on process to checkout

Scenario: validate Sign-In page.

Given user is on Sign-in page.
Then user click on create your amazon account

Scenario: validate Create account page.

Given User is on create account page.
Then user Enter all the details and click on create account
