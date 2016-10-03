package contractorX.projectY.cukes.web;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchWindowException;

public class BrowserWindow 
{
	private Log log = LogFactory.getLog(getClass());
	private BrowserSession browserSession;
	private String windowHandle;
	
	public BrowserWindow (BrowserSession browserSession, String windowHandle)
	{
		this.browserSession = browserSession;
		this.windowHandle = windowHandle;
	}
	
	public void terminateScenario()
	{
		this.closedBrowserWindow();
		this.browserSession = null;
		this.windowHandle = null;
	}
	
	public String getGreetingMsg()
	{
		return browserSession.getDriver().findElement(By.id("greeting")).getText();
	}
	
	public boolean isValidBrowserWindow()
	{
		boolean validBrowserWindow;
		try
		{
			browserSession.getDriver().switchTo().window(windowHandle);
			validBrowserWindow = true;
		}
		catch (NoSuchWindowException nswe)
		{
			log.error( "Browser window with handle '" + windowHandle + "' doesn't exist!");
			validBrowserWindow = false;
		}
		return validBrowserWindow ;
	}
   
	public void closedBrowserWindow()
	{
		browserSession.getDriver().switchTo().window(windowHandle);
		browserSession.getDriver().close();
	}
	
	public BrowserSession getBrowserSession()
	{
		return browserSession;
	}
	
	public void setBrowsserSession (BrowserSession browserSession)
	{
		this.browserSession = browserSession;
	}
	
	public String getWindowHandle()
	{
		return windowHandle;
		
	}
	
	public void setWindowHandle(String windowHandle)
	{
		this.windowHandle = windowHandle;
	}
} // End
