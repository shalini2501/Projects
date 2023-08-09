Feature: Test the saucedemo page
  
  Scenario: To test the saucedemo login page
    Given I am in the login page of saucedemo
    When I enter the username and password
    And click the login button
    Then I validate the outcomes
    
	Scenario: To test the saucedemo  add to cart page
    Given I am in the home page of saucedemo
    When I click items to addtocart
    And click on Icon of AddToCart 
    And click on check out
    Then I validate outcomes
    
   Scenario: To test the saucedemo for continue shopping
   	Given I am in the your cart of saucedemo
    When I click on continue shopping
    And click items to addtocart
    And click on Icon of AddCart 
    And click on checkout
    Then  validate the outcomes
    
	Scenario: To test the saucedemo  Checkout: Your Information page
		Given I am in the Checkout: Your Information page of saucedemo
		When I enter firstname lastname and postalcode
		And click on continue
		Then I validate the outcomes
		And click on the back home
		 
	Scenario: To test the saucedemo for the logout
		Given I am in the Home page of saucedemo1
		When I click on menu icon
		And click on Logout
		Then Validate the outcomes
		