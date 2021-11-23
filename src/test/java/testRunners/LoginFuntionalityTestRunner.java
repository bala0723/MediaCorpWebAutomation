package testRunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(glue = "stepDefinitions",monochrome = true,features = "C:\\Users\\admin\\Documents\\MediaCorpWebAutomation\\Features\\",
plugin = {"json:target/cucumber-json-report.json"})
public class LoginFuntionalityTestRunner {

	
	
}
