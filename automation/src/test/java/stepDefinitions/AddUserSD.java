package stepDefinitions;

//import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumberTest.AddUser;


public class AddUserSD {
	
	AddUser addUser = new AddUser();

	@Given("Start Chrome")

	public void givenStatment() throws Exception {
		
		addUser.setUp();

		System.out.println("Application started successfully");

	}

	@When("Enter valid credentials")

	public void whenStatement() throws Exception{
		
		addUser.loginForm();

		System.out.println("Login successful");

	}
	
	@And("Create a new user")

	public void andStatement() throws Exception{
		
		addUser.addUser();

		System.out.println("User created successfully");

	}

	@Then("Exit application")

	public void thenStatment() throws Exception{
		
		addUser.tearDown();

		System.out.println("Application closed");

	}

}
