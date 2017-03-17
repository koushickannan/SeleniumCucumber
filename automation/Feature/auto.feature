Feature: IoT UI Automation
	I want to use this template for my feature file
	
cucumber --tags ~@ignore
Scenario1: Successful Login with Valid Credentials
	Given Open chrome and start application
	When User Navigate to LogIn Page and enters a valid credentials
	And  Verify the dashboard title
	Then Close the application

cucumber --tags ~@ignore	
Scenario2: Successful User Creation
	Given Start Chrome
	When Enter valid credentials
	And  Create a new user
	Then Exit application
	
Scenario: Successful Asset Creation
	Given Open Chrome
	When Enter credentials
	And  Create a new device
	Then Exit