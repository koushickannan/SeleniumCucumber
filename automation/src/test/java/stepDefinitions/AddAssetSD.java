package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumberTest.AddAsset;


public class AddAssetSD {
	
	AddAsset addAsset = new AddAsset();

	@Given("Open Chrome")

	public void givenStatment() throws Exception {
		
		addAsset.setUp();

		System.out.println("Application started successfully");

	}

	@When("Enter credentials")

	public void whenStatement() throws Exception{
		
		addAsset.loginForm();

		System.out.println("Login successful");

	}
	
	@And("Create a new device")

	public void andStatement() throws Exception{
		
		addAsset.addAsset();

		System.out.println("Device created successfully");

	}

	@Then("Exit")

	public void thenStatment() throws Exception{
		
		addAsset.tearDown();

		System.out.println("Application closed");

	}

}
