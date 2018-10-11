package cucumberOptions;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java/features", 
		glue = "stepDefinition")// "stepDefinition" is only the package name where our stepDefenitions are
								// we need to make sure that our stepDefinition	
								// package and TestRunner package have the same parent package
								
								// There should be one mapping implementation for each Gherkin line
								// Tidy Gherkin plugin to generate stepDefenition file
								//

public class TestRunner extends AbstractTestNGCucumberTests {

	
}
