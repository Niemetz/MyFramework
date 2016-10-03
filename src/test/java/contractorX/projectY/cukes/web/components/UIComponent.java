package contractorX.projectY.cukes.web.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public interface UIComponent 
{
	public void findElement(WebDriver driver, int waitTimeInSecond);
	public boolean isVerified(WebDriver driver, int waitTimeInSecond);
	public WebElement getElement();
	public String getText();
	public boolean isVerifyForLandingConfirmation();
}
