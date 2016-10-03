package contractorX.projectY.cukes.web.components.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;

import contractorX.projectY.cukes.web.components.Clickable;

import java.lang.InterruptedException;

public class Button extends XPathComponent implements Clickable
{
  private Log log = LogFactory.getLog(getClass());
  // first constructor
  public Button (String xpathExpression)
  {
	  super(xpathExpression);
  }
  
  // Second constructor
  public Button (String xpathExpression, boolean verifyForLandingConfirmation)
  {
	  super(xpathExpression,verifyForLandingConfirmation);
  }
  
  // final constructor
  public Button (String xpathExpression, boolean verifyForLandingConfirmation, int specifiedWaitTime, int specifiedSleepTime)
  {
	  super(xpathExpression,verifyForLandingConfirmation,specifiedWaitTime,specifiedSleepTime);
  }
  
  /* Override the isVerified method in the XPathComponent class:
     1 - Add a debug message to the log. 
     2- Not retrun the text on the button
   */
  @Override
	public boolean isVerified(WebDriver driver, int waitTimeInSecond) {
		boolean verified = false;
		try
		{
			findElement(driver, waitTimeInSecond);
			log.debug(xpathExpression + " isDisplayed() ? " + element.isDisplayed());
			verified = element.isDisplayed();
		}
		catch (Exception e)
		{
			verified = false;
		}
		return verified;
	}
  
  // Implement the click method from the "Clickable" interface
  @Override
  public void click(WebDriver driver, int waitTimeInSeconds) 
  {
	super.findElement(driver, waitTimeInSeconds);
	try
	{
		super.getElement().click();
	} catch (Exception ex)
	{
		try
		{
			log.info("Did not click successfull first timme... refresh and try again...");
			Thread.sleep(300);
			super.findElement(driver, waitTimeInSeconds);
			super.getElement().click();
		} catch (InterruptedException ie){}
	}
  }

} //end
