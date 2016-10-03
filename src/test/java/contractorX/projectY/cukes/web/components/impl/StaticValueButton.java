package contractorX.projectY.cukes.web.components.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Map;

import javax.lang.model.element.Element;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

// Old method declaration
//public class StaticValueButton extends BaseUIComponent implements Clickable
public class StaticValueButton extends BaseUIComponent
{
	private Map<String, String> nameAndPathKeypairs;
	private String selectedKey;
	private Log log = LogFactory.getLog(getClass());
	
	// first try
	public StaticValueButton (Map<String, String> value)
	{
		super();
		this.nameAndPathKeypairs = value;
	}
	
	// second try
	public StaticValueButton (Map<String, String> value, boolean verifyForLandingConfirmation)
	{
		super(verifyForLandingConfirmation);
		this.nameAndPathKeypairs = value;
	}
	// Final constructor
	public StaticValueButton (Map<String, String> value, boolean verifyForLandingConfirmation, int specifiedWaitTime, int specifiedSleepTime)
	{
		super(verifyForLandingConfirmation,specifiedWaitTime,specifiedSleepTime);
		this.nameAndPathKeypairs = value;
	}

    public WebElement findIndividualElement(WebDriver driver, int waitTimeInSeconds, String valueText)
    {
    	WebElement element = null;
    	By by = By.xpath(nameAndPathKeypairs.get(valueText));
    	WebDriverWait wait = new WebDriverWait(driver, waitTimeInSeconds);
    	wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    	wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(by)));
    	element = driver.findElement(by);
    	if (element.isDisplayed())
    	{
    		log.debug(String.format("Element %s is displayed", valueText));
    	}
    	else
    	{
    		log.debug(String.format("Element %s is NOT displayed", valueText));
    	}
    	return element;
    }
    
    public boolean isVerified(WebDriver driver, int waitTimeInSeconds)
    {
    	boolean verified = false;
    	for (String key:nameAndPathKeypairs.keySet())
    	{
    		try
    		{
    			WebElement individualRadioButton = findIndividualElement(driver, waitTimeInSeconds, key);
    			verified = individualRadioButton.isDisplayed();
    			if (!verified)
    				break;
    		}
    		catch (Exception e)
    		{
    			verified = false;
    		}
    	}
    	return verified;
    }
    
    @Override
    public void findElement(WebDriver driver, int waitTimeInSecond)
    {
    	
    }
    @Override
    public WebElement getElement()
    {
    	return null;
    }
    @Override
    public boolean isVerifyForLandingConfirmation()
    {
    	return true;
    }
    @Override 
    public String getText()
    {
    	return this.selectedKey;
    }
    
    public void click(WebDriver driver, int waitTimeInSeconds, String valueText)
    {
    	try
    	{
    		WebElement element = findIndividualElement(driver, waitTimeInSeconds, valueText);
    		element.click();
    		selectedKey = valueText;
    	}
    	catch (Exception ex)
    	{
    		log.error("Cannot select element " + valueText);
    	}
    }

}
