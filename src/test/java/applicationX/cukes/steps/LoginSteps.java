package applicationX.cukes.steps;

import contractorX.projectY.cukes.core.Global;
import contractorX.projectY.cukes.core.StepBase;
import contractorX.projectY.cukes.web.PageResolver;
import contractorX.projectY.cukes.web.SessionManager;
import contractorX.projectY.cukes.web.URLResolver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

public class LoginSteps  extends StepBase
{
  @Global
  protected URLResolver urlResolver;
  @Global
  protected SessionManager sessionManager;
  @Global
  protected PageResolver pageResolver;
  
  @Then("^the user \'(.*)\' is displayed in the user profile \'(.*)\' $")
  public void loginSuccessful(String userName, String gherkinName)
  {
	  log.debug(String.format("=> Last User '%s' name is displayed in ther user profile '%s' ", sessionManager.lastSession().getUser(),gherkinName));
	  sessionManager.lastSession().waitForPageLanding(sessionManager.lastSession().getLastPage(), 5);
  }
  
  
}
