package applicationX.cukes.web.components.impl.date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.openqa.selenium.WebDriver;

import contractorX.projectY.cukes.web.components.InputField;

public class DateFieldMMDDYY extends AbstractDateField implements InputField<String>, DateField
{
  public DateFieldMMDDYY (String xpathExpression)
  {
	  super(xpathExpression);
  }
  
  public DateFieldMMDDYY (String xpathExpression, boolean verifyForLandingConfirmation)
  {
	  super(xpathExpression, verifyForLandingConfirmation);
  }

  
@Override
public void setTextToTodaysDate(WebDriver driver, int waitTimeInSeconds) 
{
     String todaysDate;
     DateFormat dateFormat = new SimpleDateFormat("MM/dd/yy");
     Calendar cal = Calendar.getInstance();
     todaysDate = dateFormat.format(cal.getTime());
     this.setText(driver, waitTimeInSeconds,  todaysDate);
}

@Override
public void SetTextXNumberOfDaysAfterTodaysDate(WebDriver driver,int waitTimeInSeconds, int numberOfDays)
{
	String futureDate;
	DateFormat format = new SimpleDateFormat("MM/dd/yy");
	Calendar date1 = new GregorianCalendar();
	Calendar date2 = (Calendar) date1.clone();
	date2.add(Calendar.DATE, numberOfDays);
	futureDate = format.format(date2.getTime());
	this.setText(driver, waitTimeInSeconds,  futureDate);	
}

@Override
public void SetTextXNumberOfDaysBeforeTodaysDate(WebDriver driver, int waitTimeInSeconds, int numberOfDays) 
{
	String pastDate;
	DateFormat format = new SimpleDateFormat("MM/dd/yy");
	Calendar date1 = new GregorianCalendar();
	Calendar date2 = (Calendar) date1.clone();
	date2.add(Calendar.DATE, - numberOfDays);
	pastDate = format.format(date2.getTime());
	this.setText(driver, waitTimeInSeconds,  pastDate);	
}
  
} // end
