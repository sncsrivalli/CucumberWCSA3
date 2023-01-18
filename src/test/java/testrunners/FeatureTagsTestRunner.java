package testrunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"./src/test/resources/featurefiles/Feature1.feature",
		"./src/test/resources/featurefiles/Feature2.feature",
		"./src/test/resources/featurefiles/Feature3.feature"},
		tags = "@Functional and not @System")
public class FeatureTagsTestRunner {

}
