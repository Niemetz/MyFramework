package contractorX.projectY.cukes.web.components.impl;

import static org.junit.Assert.fail;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import contractorX.projectY.cukes.web.components.UIComponent;

//import org.openqa.selenium.support.ui.ExpectedCondition;

//import org.openqa.selenium.support.ui.WebDriverWait;

public class XPathComponent extends BaseUIComponent implements UIComponent
{
	protected String xpathExpression;
	protected WebElement element;
	private Log log = LogFactory.getLog(getClass());
	private String text = null;
	
	// first try
	public XPathComponent (String xpathExpression)
	{
		this.xpathExpression = xpathExpression;
	}
	
	// second try
	public XPathComponent (String xpathExpression, boolean verifyForLandingConfirmation)
	{
		super(verifyForLandingConfirmation);
		this.xpathExpression = xpathExpression;
	}
	// Final constructor
	public XPathComponent (String xpathExpression, boolean verifyForLandingConfirmation, int specifiedWaitTime, int specifiedSleepTime)
	{
		super(verifyForLandingConfirmation,specifiedWaitTime,specifiedSleepTime);
		this.xpathExpression = xpathExpression;
	}
	
	@Override
	public void findElement(WebDriver driver, int waitTimeInSeconds) 
	{
		By by = By.xpath(xpathExpression);
		int waitTime;
		
		if (this.specifiedWaitTime != -1)
			waitTime = specifiedWaitTime;
		else
			waitTime = waitTimeInSeconds;
		
		for (int second = 0 ; ; second++)
		{
			if (second >= 1000)
			{
				log.debug(String.format("Elelment %s is NOT displayed....", xpathExpression));
                fail("I'm timing out...after 1,000 tries....");
                try
                {
                	element = driver.findElement(by);
                    if (element.isDisplayed() && element.isEnabled())
                    {
                    	Thread.sleep(waitTime);
                    	log.debug(String.format("Element %s is displayed and is ready for use", xpathExpression));
                    	break;
                    }
                    else
                    	Thread.sleep(this.getSpecifiedSleepTime());
                }
                catch (Exception e)
                {
                	log.debug( String.format("Element %s is NOT displayed yet...keep looking....", xpathExpression));
                }
			}
		}
	}

	@Override
	public boolean isVerified(WebDriver driver, int waitTimeInSecond) {
		boolean verified = false;
		try
		{
			findElement(driver, waitTimeInSecond);
			verified = element.isDisplayed();
			// get the text on the element
			text = element.getText();	
		}
		catch (Exception e)
		{
			verified = false;
		}
		return verified;
	}

	@Override
	public WebElement getElement() {
		
		return element;
	}

	@Override
	public String getText() 
	{
		return text;
	}

	@Override
	public boolean isVerifyForLandingConfirmation() 
	{
		return verifyForLandingConfirmation;
	}
	
	@Override
	public String toString()
	{
		return "XpathExpression = "+ xpathExpression + ", element = " + element + "]";
	}
	
	
  
}
