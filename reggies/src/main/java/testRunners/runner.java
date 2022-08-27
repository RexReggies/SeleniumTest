package testRunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
				features = "feature/GoogleVerification.feature",
				plugin = { "pretty", "html:target/cucumber-reports/cucumber-html","json:target/json/json-google.json"},
				glue= {"stepdefination"}
				)
		
public class runner {

}
