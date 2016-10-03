package contractorX.projectY.cukes.web.components.impl;

import org.openqa.selenium.WebDriver;

import contractorX.projectY.cukes.web.components.Clickable;

public class CheckBox extends XPathComponent implements Clickable
{
    
	// First constructor
	public CheckBox(String xpathExpression) 
	{
		super(xpathExpression);
	}
	
	// Second constructor
	public CheckBox(String xpathExpression, boolean verifyForLandingConfirmation) 
	{
		super(xpathExpression,verifyForLandingConfirmation);
	}
	
	// final constructor
	public CheckBox(String xpathExpression, boolean verifyForLandingConfirmation, int sepcifiedWaitTime, int specifiedSleepTime) 
	{
		super(xpathExpression,verifyForLandingConfirmation,sepcifiedWaitTime, specifiedSleepTime);
	}

	/* 
	  Override the click method from the interface Clickable
	 */
	@Override
	public void click(WebDriver driver, int waitTimeInSeconds) 
	{
		super.findElement(driver, waitTimeInSeconds);
		super.getElement().click();
	}

}
