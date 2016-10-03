package contractorX.projectY.cukes.web.steps;


import static org.junit.Assert.assertTrue;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
//import contractorX.projectY.cukes.core.Global;
//import contractorX.projectY.cukes.core.StepBase;
import contractorX.projectY.cukes.web.BrowserSession;
import contractorX.projectY.cukes.web.PageResolver;
import contractorX.projectY.cukes.web.SessionManager;
import contractorX.projectY.cukes.web.URLResolver;
import applicationX.cukes.web.ApplicationXURLResolver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

//public class StepsDefinitions extends StepBase
public class StepsDefinitions 
{
  //@Global
  protected URLResolver urlResolver;
  //@Global
  protected SessionManager sessionManager = new SessionManager();
  //@Global
  protected PageResolver pageResolver;
  
  //@Global
  protected BrowserSession  browserSession;
  
  protected ApplicationXURLResolver applicationXURLResolver = new ApplicationXURLResolver();
  
  protected Log log = LogFactory.getLog(getClass());
  
  // May want to change this "DEFAULT_WAIT_TIME_IN_SECONDS" to "DEFAULT_ADDITIONAL_WAIT_TIME_IN_NANO_SECOND".
  // then implement the org.openqa.selenium.support.ui.WebDriverWait
  // for exmaple:  need to wait two times.
  // WebDriverWiat wait;
  // wait.until(ExpextedConditions.VisibilityOfElementLocated(By.xpaht("<target element> = //div[contains(...)>"), innanoseconds);
  // wait.until(ExpextedConditions.isEnabled(By.xpaht("<target element> = //div[contains(...)>"), innanoseconds);
  // Then set the Thread(sleep("DEFAULT_ADDITIONAL_WAIT_TIME_IN_NANO_SECOND"));  This additional wait will guarantee that the object is 
  // visible and is enabled.
  
  public static final int DEFAULT_WAIT_TIME_IN_SECONDS = 5;

  @Given("^\"([^\"]*)\" user has a \"([^\"]*)\" browser open\\.$")
  public void user_has_a_browser_open(String user, String browserType) throws Throwable 
  {

	  log.debug(String.format("=> '%s' has a '%s' browser open. ", user, browserType));
	  browserSession = sessionManager.findOrCreateSession(user, browserType);
	  log.debug(String.format("=> browserSession = '%s'",  browserSession));
	  boolean hasBrowserOpen = browserSession.hasBrowserOpen();
	  assertTrue(String.format("'%s' has a '%s' browser open", user,browserType), hasBrowserOpen);
	  
	  System.out.println("lastWindowHandle = " + browserSession.getLastWindowHandle());
	  
  }
  
  // the user goes to the application website
  @When("^he navigates to \"([^\"]*)\" website\\.$")
  //public void he_navigates_to_website( String user, String gherkinUrlName)
  public void he_navigates_to_website(String gherkinUrlName)
  {
	  //log.debug(String.format("=> Last user '%s' navigates to '%s' ", sessionManager.lastSession().getUser(), gherkinUrlName));
	  //sessionManager.lastSession().gotoURL(urlResolver.resolveURL(gherkinUrlName));
	 
	  // SHORTCUT
	  sessionManager.lastSession().gotoURL(applicationXURLResolver.resolveURL(gherkinUrlName));
	  
	  //sessionManager.lastSession().gotoURL(gherkinUrlName);
	  //System.out.println("last page = " + sessionManager.lastSession().goneToURL(gherkinUrlName));
	  
	  //System.out.println("lastWindowHandle = " + browserSession.getLastWindowHandle());
	  
	  /* 
	    assertTrue(String.format("'%s' has navigated to '%s' ", 
	  
			                  sessionManager.lastUser(), gherkinUrlName), 
			                  sessionManager.lastSession().goneToURL(urlResolver.resolveURL(gherkinUrlName)));
	   log.debug(String.format("=> Last user '%s' has navigated to '%s' ", 
			                   sessionManager.lastUser(),
			                   sessionManager.lastSession().goneToURL(urlResolver.resolveURL(gherkinUrlName))));
	   */
  }
  
  
  
  /*
  // The user lands on a page
  @Then("^he lands on the \'(.*)\' page$")
  public void lastUserLandsOnPage(String gherkinPageName)
  {
	  log.debug(String.format("=> Last user '%s' lands on the '%s' page", sessionManager.lastSession().getUser(), gherkinPageName));
	  sessionManager.lastSession().waitForPageLanding(pageResolver.resolvePage(gherkinPageName), DEFAULT_WAIT_TIME_IN_SECONDS);
  }
  
  // The user enter some text input value into an input field component
  @When("^he enters \'(.*)\' in the (?:input field|text field.?)$")
  public void lastUserEntersWithComponentTypes(String textValue, String gherkinInputName)
  {
	  log.debug(String.format("=> Last user '%s' enters '%s' in the '%s'", sessionManager.lastSession().getUser(), textValue, gherkinInputName));
	  TextField textField = (TextField)sessionManager.lastSession().getLastPage().getDomeState().getComponent(gherkinInputName);
	  textField.setText(sessionManager.lastSession().getDriver(), DEFAULT_WAIT_TIME_IN_SECONDS, textValue);
  }
  
  // the user clicks on one of UI components => button|checkbox|link|radio button  e.i ClickableName
  @When("^he clicks on the \'(.*)\' (?:button|checkbox|link|radio button|.?)$")
  public void lastUserClicksSpecific(String gherkinClickableName)
  {
	  log.debug(String.format("=> Last user clicks on the '%s'", sessionManager.lastSession().getUser(), gherkinClickableName));
	  Page lastPage = sessionManager.lastSession().getLastPage();
	  Clickable clickable = (Clickable)lastPage.getDomeState().getComponent(gherkinClickableName);
	  clickable.click(sessionManager.lastSession().getDriver(), DEFAULT_WAIT_TIME_IN_SECONDS);
  }
  */
  
}//End
