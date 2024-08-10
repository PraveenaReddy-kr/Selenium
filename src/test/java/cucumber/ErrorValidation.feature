@tag

	Feature: Error Handling
	
	Background: 
	Given I landed on Login Page 
	
	@ErrorHandling
	Scenario Outline: Handling Errors in Login Page
	Given I login with <email> and <password>
	Then I should get "Incorrect email or password." message
	
	Examples:
	| email 											 | password |
	| NITISHREDDYSEERAPU@GMAIL.COM | Npr@0672 |
  | register1@gmail.com				   | Ammu@0691|