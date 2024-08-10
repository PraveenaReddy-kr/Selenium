
@tag
Feature: Purchasing Products
  I want to use this template for my feature file

	Background:
	Given I landed on Login Page 
	
  @Smoke
  Scenario Outline: Login and Place Order
    Given I login with <email> and <password>
    When I Select <product> and add to cart
    And  Checkout <product> and Submit Order
    Then I need to get "Thankyou for the order." 

    Examples: 
      | email  											 | password | product   				 |
      | NITISHREDDYSEERAPU@GMAIL.COM | Npr@0612 | ZARA COAT 3				 |
      | register1@gmail.com				   | Ammu@0611| ADIDAS ORIGINAL    |
