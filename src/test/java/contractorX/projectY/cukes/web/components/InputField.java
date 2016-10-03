package contractorX.projectY.cukes.web.components;

import org.openqa.selenium.WebDriver;

public interface InputField<T> 
{
	public void setText(WebDriver driver, int waitTimeInSeconds, T value);
}
