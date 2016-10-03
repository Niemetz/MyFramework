package contractorX.projectY.cukes.web.components.impl;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;

import contractorX.projectY.cukes.web.components.InputField;


public class TextField extends XPathComponent implements InputField<String>
{
	private Log log = LogFactory.getLog(getClass());
	
	// first try
	public TextField (String xpathExpression)
	{
		super(xpathExpression);
	}
	
	// second try
	public TextField (String xpathExpression, boolean verifyForLandingConfirmation)
	{
		super(xpathExpression, verifyForLandingConfirmation);

	}
	// Final constructor
	public TextField (String xpathExpression, boolean verifyForLandingConfirmation, int specifiedWaitTime, int specifiedSleepTime)
	{
		super(xpathExpression,verifyForLandingConfirmation,specifiedWaitTime,specifiedSleepTime);
	
	}

	@Override
	public void setText(WebDriver driver, int waitTimeInSeconds, String value) 
	{
		if (super.getElement() == null)
		{
			super.findElement(driver, waitTimeInSeconds);
		}
		if (!super.getElement().isEnabled())
		{
			log.debug(String.format("Elelment %s is NOT displayed or NOT Editable", xpathExpression));
		}
		else
			super.getElement().sendKeys(value);
	}

}
