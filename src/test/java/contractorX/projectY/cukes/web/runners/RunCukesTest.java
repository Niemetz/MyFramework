package contractorX.projectY.cukes.web.runners;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		monochrome = true,
		plugin = {"pretty", "json:target/json/output.json", "html:target/html/"},
		glue = {"contractorX.projectY.cukes.web.steps"},
		features = {"src/test/resource/contractorX/projectY/cukes/web/features"}
		)

public class RunCukesTest {

}
