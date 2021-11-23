#@REQ_AWD-1
Feature: Login Functionality with valid credentials

	#As a user, I can login to the application with no interruption
	@TEST_AWD-2
	Scenario Outline: Login Functionality with valid credentials
		Given user launches the applpication lands on login page
		When user enters valid <username> and <password>
		And clicks on login button
		Then user lands on homepage
		
		Examples:
		|username|password|
		|traditional@grr.la|123123|
