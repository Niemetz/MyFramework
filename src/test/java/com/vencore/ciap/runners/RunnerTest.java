package com.vencore.ciap.runners;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {"pretty", "json:target/json/output.json", "html:target/html/"},
		glue = {"com/vencore/ciap/steps"},
		features ="src/test/resource/features"
		)

public class RunnerTest {

}
