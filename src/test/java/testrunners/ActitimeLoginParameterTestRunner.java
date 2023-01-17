package testrunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "./src/test/resources/featurefiles/ActitimeLoginWithParameters.feature", 
				glue = "stepdefinitions")
public class ActitimeLoginParameterTestRunner {

}
