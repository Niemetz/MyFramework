package contractorX.projectY.cukes.core.steps;

import contractorX.projectY.cukes.core.StepBase;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class ScenarioHooks extends StepBase
{
  @Before
  public void beforeScenarios()
  {
	  globalTestInstance.beforeScenario();
	  
  }
  
  @After
  public void afterSenario()
  {
	  globalTestInstance.afterScenario();
  }
}
