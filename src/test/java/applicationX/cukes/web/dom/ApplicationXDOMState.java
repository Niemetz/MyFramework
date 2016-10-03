package applicationX.cukes.web.dom;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;

import contractorX.projectY.cukes.web.DOMState;

public abstract class ApplicationXDOMState extends DOMState
{
	private Log log = LogFactory.getLog(getClass());
	
	public boolean confirmLanding(WebDriver driver, int waitTimeInSeconds)
	{
		boolean landingConfirmed;
		String skipConfirmLanding = System.getProperty("SKIP_CONFIRM_LANDING");
		if (skipConfirmLanding != null)
		{
			log.info("=> Skipping landing confirmation...");
			landingConfirmed = true;
			
		}
		else
		{
			 landingConfirmed = super.confirmlanding(driver, waitTimeInSeconds);
		}
		return landingConfirmed;			
	}
}
