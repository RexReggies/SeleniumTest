package stepdefination;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.FileNotFoundException;

import Libraries.genericLib;;
public class test {
	@Given("I Launch Google ChromeBrowser")
	public void i_launch_google_chrome_browser() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
		genericLib.initialize();
		genericLib.navigateTo("https://www.google.co.in");
	}
	@When("I Open Google HomePage")
	public void i_open_google_home_page() throws Exception {
		
	    System.out.println("Google Home Page");
	}
	@Then("GoogleHomePage Displayed")
	public void google_home_page_displayed() throws Exception {
		genericLib.hardAssert("css=img[alt='Google']",true);
	    // Write code here that turns the phrase above into concrete actions
	}
	@Then("close Browser")
	public void close_browser() {
	    // Write code here that turns the phrase above into concrete actions
		genericLib.quit();
	}

}

