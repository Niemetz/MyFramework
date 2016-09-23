package com.vencore.ciap;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {"pretty", "json:target/json/output.json", "html:target/html/"},
		glue = {"com/vencore/ciap"},
		features ="src/test/resource"
		)

public class RunnerTest {

}
