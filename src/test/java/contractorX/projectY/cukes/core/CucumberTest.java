package contractorX.projectY.cukes.core;

import java.util.Scanner;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;

@RunWith(CucumberRunner.class)
public class CucumberTest 
{
  static private Log log = LogFactory.getLog(CucumberTest.class);
  @SuppressWarnings("unchecked")
  public final void beforeAll()
  {
	  log.debug("Before all");
	  CucumberOptions options = getClass().getAnnotation(CucumberOptions.class);
	  if (options == null)
		  throw new RuntimeException("No @CucumberOptions found");
		  
	  initializeTest() ;
		  
		  Set<Class<?>> scanClasses =  PackageScanner.scanPakages(getClass().getClassLoader(), options.glue()); 
		  for (Class<?> scanClass : scanClasses)
		  {
			  if (StepBase.class.isAssignableFrom(scanClass))
			  {
				  StepBase.scanGlobals((Class<? extends StepBase>) scanClass, this);
			  }
		  }		  
   }
   public final void afterAll()
	  {
		  log.debug("After all");
		  terminateTest();
	  }
  public final void beforeScenario() 
  {
	log.debug("Before scenario");
	initializedScenario();
   }
  public final void afterScenario() 
  {
	log.debug("After scenario");
	terminateScenario();
   }
  private void initializeTest() 
    {
	 // TODO Auto-generated method stub
    }
  protected void terminateTest()
  {
	  
  }
  protected void initializedScenario()
  {
	  
  }
  protected void terminateScenario()
  {
	  
  }
  
}
