package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
//import cucumber.api.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(features = "/CucumberFramework/Feature/IoT.feature", plugin = { "pretty",
        "html:target/site/cucumber-pretty",
        "rerun:target/rerun.txt",
        "json:target/cucumber1.json" })
public class RunCukeTest {
	
}