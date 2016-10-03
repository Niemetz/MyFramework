package contractorX.projectY.cukes.web.components.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import contractorX.projectY.cukes.web.components.Clickable;
import contractorX.projectY.cukes.web.components.UIComponent;

public class SplitButton extends Button implements Clickable
{
  private Log log = LogFactory.getLog(getClass());
  private int x;
  private int y;
	// first try
	public SplitButton (String xpathExpression, int x, int y)
	{
		super(xpathExpression);
		this.x = x;
		this.y = y;
	}
	
	// second try
	public SplitButton (String xpathExpression, int x, int y, boolean verifyForLandingConfirmation)
	{
		super(xpathExpression, verifyForLandingConfirmation);
		this.x = x;
		this.y = y;
	}
	// Final constructor
	public SplitButton (String xpathExpression, int x, int y, boolean verifyForLandingConfirmation, int specifiedWaitTime, int specifiedSleepTime)
	{
		super(xpathExpression, verifyForLandingConfirmation, specifiedWaitTime, specifiedSleepTime);
		this.x = x;
		this.y = y;
	}

  @Override
   public void click(WebDriver driver, int waitTimeInSeconds) 
   {
	  super.findElement(driver, waitTimeInSeconds);
	  log.debug(String.format("Click a preferred pint (%d, %d, args)", x, y));
	  Actions actions = new Actions(driver);
	  actions.moveToElement(super.getElement(), x, y).click().perform();
	  
   }
}
