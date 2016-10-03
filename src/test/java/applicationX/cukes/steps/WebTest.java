package applicationX.cukes.steps;

import org.apache.commons.logging.*;
//import org.openqa.jetty.log.LogFactory;

import applicationX.cukes.web.ApplicationXPageResolver;
import applicationX.cukes.web.ApplicationXURLResolver;
import contractorX.projectY.cukes.core.CucumberTest;
import contractorX.projectY.cukes.core.Global;
import contractorX.projectY.cukes.web.PageResolver;
import contractorX.projectY.cukes.web.SessionManager;
import contractorX.projectY.cukes.web.URLResolver;

public abstract class WebTest extends CucumberTest
{
  protected Log log = LogFactory.getLog(getClass());
  
  @Global
  protected URLResolver urlResolver;
  @Global
  protected SessionManager sessionManager;
  @Global
  PageResolver pageResolver;
  
  public static int PAGE_LOAD_ATTEMPTS;
  public static final int DEFAULT_MAX_PAGE_LOAD_ATTEMPTS = 1;
  
  protected void initializeTest()
  {
	  log.debug("=> Initialize utilites");
	  sessionManager = new SessionManager();
	  urlResolver = new ApplicationXURLResolver();
	  pageResolver = new ApplicationXPageResolver();
	  String pageLoadAttemps = System.getProperty("DEFAULT_MAX_PAGE_LOAD_ATTEMPTS");
	  if (pageLoadAttemps != null)
	  {
		  try
		  {
		  PAGE_LOAD_ATTEMPTS = Integer.parseInt(pageLoadAttemps);
		  }
		  catch (Exception ex)
		  {
			  PAGE_LOAD_ATTEMPTS = DEFAULT_MAX_PAGE_LOAD_ATTEMPTS;
		  }
	  }
	  else
	  {
		  PAGE_LOAD_ATTEMPTS = DEFAULT_MAX_PAGE_LOAD_ATTEMPTS;
	  }
	  log.info("=> Set max page log attempts to " + PAGE_LOAD_ATTEMPTS );
     } 
  
	  @Override
	  protected void terminateScenario()
	  {
		  sessionManager.lastSession().terminateScenario();
	  }
	  
}//end

