package contractorX.projectY.cukes.web;



import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;

import contractorX.projectY.cukes.web.components.UIComponent;

public abstract class DOMState 
{
  private Log log = LogFactory.getLog(getClass());
  private Map<String, UIComponent> components;
  
  public DOMState()
  {
	  this.components = new HashMap<String, UIComponent>();
  }
  
  public UIComponent getComponent(String name)
  {
	  UIComponent component = components.get(name);
	  log.debug(name);
	  log.debug(component);
	  return component;
  }
  
  // The "componentName" is the exact name of the component as displayed on the page.
  // The component is the xpath of the component on the page
  public void putComponent(String componentName, UIComponent component)
  {
	  components.put(componentName, component);
  }
  
  public boolean confirmlanding(WebDriver driver, int waitTimeInSeconds)
  {
	  log.debug(String.format("currentURL = %s", driver.getCurrentUrl()));
	  log.debug(String.format("domState = %s", this));
	  boolean landingConfirmed = false;
	  if (!components.isEmpty())
	  {
		  landingConfirmed = true;
		  for (String key : components.keySet())
		  {
			  UIComponent component = components.get(key);
			  if(component.isVerifyForLandingConfirmation())
			  {
				  boolean isVerified = component.isVerified(driver, waitTimeInSeconds);
				  log.debug(String.format("key %s isverified ? %b", key, isVerified));
				  landingConfirmed = landingConfirmed && isVerified;
			  }
			  else
			  {
				  log.debug(String.format("key %s will not be verified at landing time", key));
			  }
		  }
	  }
	  log.debug(String.format("landingConfirmed = '%s'", landingConfirmed));
	  return landingConfirmed;
  }	  
	  protected  Map<String, UIComponent> getComponents()
	  {
		  return components;
	  }
	  
	  @Override
	  public String toString()
	  {
		  return String.format("DOMState [components = '%s']", components);
	  }
	  
     
}//ene
