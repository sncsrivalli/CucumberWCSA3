package testrunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "./src/test/resources/featurefiles/Organization.feature", 
				glue = "stepdefinitions",
				plugin = {"pretty", "html:target/HTMLReports/report.html",
						"json:target/JSONReports/report.json",
						"junit:JUNITReports/report.xml"})

public class OrganizationTestRunner {

}
