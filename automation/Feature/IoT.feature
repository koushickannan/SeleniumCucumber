Feature: IoT UI Automation
	I want to use this template for my feature file
	
Scenario: Successful User Creation
	Given Open chrome and start application
	When User Navigate to LogIn Page and enters a valid credentials
	And  Create a new user
	Then Close the application