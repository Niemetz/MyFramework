package applicationX.cukes.web.components.impl.date;

import org.openqa.selenium.WebDriver;

public interface DateField 
{
  public void setTextToTodaysDate(WebDriver driver, int waitTimeInSeconds);
  public void SetTextXNumberOfDaysAfterTodaysDate(WebDriver driver, int waitTimeInSeconds, int numberOfDays);
  public void SetTextXNumberOfDaysBeforeTodaysDate(WebDriver driver, int waitTimeInSeconds, int numberOfDays);
}
