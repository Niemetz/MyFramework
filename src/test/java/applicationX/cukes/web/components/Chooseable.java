package applicationX.cukes.web.components;

import org.openqa.selenium.WebDriver;

// select an item that has "T value" from a pull-down combo box.   
public interface Chooseable<T> 
{
	  public void setText(WebDriver driver, T value);

}
