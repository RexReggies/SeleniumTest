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
		genericLib.Click("(//input[@value='Google Search'])[2]");
	}
	@Then("I verify the {string} in step")
	public void i_verify_the_in_step(String string) throws Exception {
		genericLib.hardAssert("xpath=//img[contains(@alt,'"+string+"')]",true);
		genericLib.Click("css=img[alt='Google']");
	}
	@Given("I close the Browser")
	public void i_close_the_browser() {
	    genericLib.quit();
	    
	}


}
