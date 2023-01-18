package testrunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "./src/test/resources/featurefiles/Feature1.feature",
					tags = "@smoke or @sanity or @regression")
public class Feature1TestRunner {

}
