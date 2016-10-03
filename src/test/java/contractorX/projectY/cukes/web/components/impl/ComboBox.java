package contractorX.projectY.cukes.web.components.impl;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import contractorX.projectY.cukes.web.components.Selectable;

public class ComboBox extends XPathComponent implements Selectable
{
	// First constructor
	public ComboBox(String xpathExpression) 
	{
		super(xpathExpression);
	}
	
	// Second constructor
	public ComboBox(String xpathExpression, boolean verifyForLandingConfirmation) 
	{
		super(xpathExpression,verifyForLandingConfirmation);
	}
	
	// final constructor
	public ComboBox(String xpathExpression, boolean verifyForLandingConfirmation, int sepcifiedWaitTime, int specifiedSleepTime) 
	{
		super(xpathExpression,verifyForLandingConfirmation,sepcifiedWaitTime, specifiedSleepTime);
	}

	// Implement the interface selectText() method from the Selectable
	@Override
	public void selectText(WebDriver driver, int waitTimeInSeconds, String textToSelect) 
	{
	  findElement(driver, waitTimeInSeconds);
	  List<WebElement> comboItems = driver.findElements(By.xpath(xpathExpression));
	  for (int i = 0; i <= comboItems.size(); i++)
	  {
		  WebElement item = comboItems.get(i);
		  if (item.getText().equals(textToSelect))
		  {
			  item.click();
			  break;
		  }
	  }
	}

}
