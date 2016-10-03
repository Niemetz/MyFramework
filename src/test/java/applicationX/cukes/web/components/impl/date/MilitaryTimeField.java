package applicationX.cukes.web.components.impl.date;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.WebDriver;

import contractorX.projectY.cukes.web.components.InputField;

public class MilitaryTimeField extends AbstractTimeField implements InputField<String>, TimeField
{
   public MilitaryTimeField(String xpathExpression)
   {
	   super(xpathExpression);
   }
   public MilitaryTimeField (String xpathExpression, boolean verifyForLandingConfirmation)
   {
 	  super(xpathExpression, verifyForLandingConfirmation);
   }


@Override
public void getCurrentTime(WebDriver driver, int waitTimeInSeconds) 
{
	String currentTime = null;
	DateFormat dateFormat = new SimpleDateFormat("hh:mm a");
	Calendar cal = Calendar.getInstance();
	currentTime = dateFormat.format(cal.getTime());
	
	this.setText(driver, waitTimeInSeconds, currentTime);
}

}//end
