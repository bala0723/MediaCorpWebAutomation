Feature: Login Functionality with Invalid credentials

	#As a user, with invalid credentials I cannot able to login to the application
	@TEST_AWD-3
	Scenario: Login Functionality with Invalid credentials
		Given user launches the applpication lands on login page
		When user enters invalid <username> and <password>
		And clicks on login button
		Then application should throw the error
