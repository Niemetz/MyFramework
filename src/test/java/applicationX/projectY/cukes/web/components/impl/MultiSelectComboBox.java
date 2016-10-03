package applicationX.projectY.cukes.web.components.impl;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import contractorX.projectY.cukes.web.components.Selectable;
import contractorX.projectY.cukes.web.components.impl.XPathComponent;

public class MultiSelectComboBox extends XPathComponent implements Selectable
{
  private String selectGroup;
  public MultiSelectComboBox( String xpathExpression, String selectGroup)
  {
	  super(xpathExpression);
	  this.selectGroup = selectGroup;
  }
  
public MultiSelectComboBox( String xpathExpression, String selectGroup, boolean verifyForLandingConfirmation)
  {
	  super(xpathExpression,verifyForLandingConfirmation);
	  this.selectGroup = selectGroup;
  }
  public MultiSelectComboBox( String cssSelector, boolean verifyForLandingConfirmation, int sepcifiedWaitTime, int sepcifiedSleepTime)
  {
	  super(cssSelector,verifyForLandingConfirmation, sepcifiedWaitTime, sepcifiedSleepTime);
  }

  
@Override
public void selectText(WebDriver driver, int waitTimeInSeconds, String textToSelect) 
{
	if(super.getElement() == null)
	{
		findElement(driver, waitTimeInSeconds);
		
	}
	if(!super.getElement().isEnabled())
	{
		throw new RuntimeException("Can't select item with desired text because it is NOT enabled!");
	}
	super.getElement().sendKeys(textToSelect);
	driver.findElement(By.xpath(selectGroup)).click();
}
public String getSelectGroup() 
{
	return selectGroup;
}

public void setSelectGroup(String selectGroup) 
{
	this.selectGroup = selectGroup;
}



}//end
