package stepDefinitions;

//import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumberTest.LoginTest;

public class LoginSD {
	
	LoginTest lt = new LoginTest();

	@Given("Open chrome and start application")

	public void givenStatment() throws Exception {
		
		lt.setUp();

		System.out.println("Application started successfully");

	}

	@When("User Navigate to LogIn Page and enters a valid credentials")

	public void whenStatement() throws Exception{
		
		lt.loginForm();

		System.out.println("Login successful");

	}
	
	@And("Verify the dashboard title")

	public void andStatement() throws Exception{
		
		lt.dashboard();

		System.out.println("Dashboard displayed successfully");

	}

	@Then("Close the application")

	public void thenStatment() throws Exception{
		
		lt.tearDown();

		System.out.println("Application closed");

	}

}
