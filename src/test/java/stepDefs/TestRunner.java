package stepDefs;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin={"html:target/cucumber.html","json:target/cucumber.json"},
		features="src/test/java/features",	
				glue= {"stepDefinition"}
				)

public class TestRunner {

}
