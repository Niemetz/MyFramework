package contractorX.projectY.cukes.web.components;

import org.openqa.selenium.WebDriver;

public interface Selectable 
{
  public void selectText(WebDriver driver, int waitTimeInSeconds, String textToSelect);
}
