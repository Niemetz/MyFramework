package applicationX.cukes.steps;

import applicationX.projectY.cukes.web.components.impl.MultiSelectComboBox;
import contractorX.projectY.cukes.core.Global;
import contractorX.projectY.cukes.core.StepBase;
import contractorX.projectY.cukes.web.Page;
import contractorX.projectY.cukes.web.PageResolver;
import contractorX.projectY.cukes.web.SessionManager;
//import contractorX.projectY.cukes.web.URLResolver;
import contractorX.projectY.cukes.web.URLResolver;
import contractorX.projectY.cukes.web.components.Clickable;
import contractorX.projectY.cukes.web.steps.StepsDefinitions;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

public class GenericWebSteps extends StepBase
{
  @Global
  protected URLResolver urlResolver;
  @Global
  protected SessionManager sessionManager;
  @Global
  protected PageResolver pageResolver;
  
  private final int DEFAULT_WAIT_TIME_IN_SECONDS = 5;
  private StepsDefinitions websteps = new StepsDefinitions();
  
  @Then("^he selects \'(.*)\' from the multi combo box \'(.*)\' $")
  public void lastUserSelectMultiComboBox( String textToSelect, String gherkinInutName) throws Throwable
  {
	  log.debug(String.format("=> last user '%s' selects '%s' from combox box '%s' ", 
			                  sessionManager.lastSession().getUser(), textToSelect, gherkinInutName));
	  MultiSelectComboBox comboBox = (MultiSelectComboBox)sessionManager.lastSession().getLastPage().getDomeState().getComponent(gherkinInutName);  
	  comboBox.selectText(sessionManager.lastSession().getDriver(), DEFAULT_WAIT_TIME_IN_SECONDS, textToSelect);
  }
  
  
}
