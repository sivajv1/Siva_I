package testrunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features", glue = "stepDefinitions", tags = "@Test")
public class capstoneRunner extends AbstractTestNGCucumberTests {
}
