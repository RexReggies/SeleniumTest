package stepdefination;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


import Libraries.genericLib;;

public class Login1 {
	@Given("I Navigate to Google")
	public void i_navigate_to_google() throws Exception {
		genericLib.initialize();
		genericLib.navigateTo("https://www.google.co.in");
	}
	@When("I search the  {string}")
	public void i_search_the(String string) throws Exception{
		genericLib.set("css=input[title='Search']",string);
	}
	@Then("I verify the {string} in step")
	public void i_verify_the_in_step(String string) throws Exception {
		genericLib.hardAssert("xpath=//img[@alt='"+string+"']",true);
	}


}
