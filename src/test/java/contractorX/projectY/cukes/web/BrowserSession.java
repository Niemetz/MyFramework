package contractorX.projectY.cukes.web;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
//import org.openqa.jetty.log.LogFactory;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserSession 
{
	protected Log log = LogFactory.getLog(getClass());
	private WebDriver driver;
	private String user;
	private Page lastPage;
	private String lastWindowHandle = null;
	
	
	private List<BrowserWindow> browserWindows = new ArrayList<BrowserWindow>();
	
	// Bring up the desired browser dictated by the user
	public BrowserSession(String newUser, String browserType) throws Throwable 
	{
		user = newUser;
		
		switch(browserType.toLowerCase())
		{
		                
		case "firefox" :   
			              // Set up the firefox profile
				           FirefoxProfile profile = new FirefoxProfile();
			               profile.setPreference("network.automatic-ntlm-auth.trusted-uris", "dev,local,gov,net");
			               //final File file = new File("/Applications/geckodriver");
			       		   //System.setProperty("webdriver.gecko.driver", file.getAbsolutePath());
			       		   driver = new FirefoxDriver(); 
			       		   // Resize the browser window
			               Dimension windowSize = new Dimension(1050,1015);
			               driver.manage().window().setSize(windowSize);
			               // Get the current window ID from the selenium window array.
			               // The last entry in the selenium window array is the current window ID.		               
			               lastWindowHandle = driver.getWindowHandle();
			               
			               //SHORTCUT
			               //System.out.println("WindowHandle ID = " + driver.getWindowHandle());
			               
			               browserWindows.add(new BrowserWindow(this, lastWindowHandle));
			               //gotoURL ("https://www.amazon.com");
			
		                 break;
		case "ie"     :
			             // Get the Internet Explorer browser
			             driver = new InternetExplorerDriver();
			             break;
			            
		case "Chrome" :
			            // Get the Chrome Browser
			            driver = new ChromeDriver();
			            break;
	    default:
	    	            throw new IllegalArgumentException("=> Invalid Browser Type!  Only three type of Bowsers are supported: Firefox, EI or Chrome.");
		}	
	}
	public String getLastWindowHandle() {
		return lastWindowHandle;
	}

	public void setLastWindowHandle(String lastWindowHandle) {
		this.lastWindowHandle = lastWindowHandle;
	}


public BrowserWindow lastBrowserWindow() 
{
	for (BrowserWindow browserWindow : browserWindows)
	{
		if (browserWindow.getWindowHandle().equals(lastWindowHandle)) 
		{
			return browserWindow;
		}
	}
	return null;
}

public void terminateScenario()
{
	log.debug("Clean up before terminating the scenarios...");
	driver.manage().deleteAllCookies();
	
}
public boolean hasBrowserOpen()
{
	boolean hasValidBrowserWindow = false;
	for (BrowserWindow browserWindow : browserWindows)
	   {
		hasValidBrowserWindow = browserWindow.isValidBrowserWindow();
		if (hasValidBrowserWindow)
		  {
			break;
		  }
	   }
	   return hasValidBrowserWindow;
}
public boolean goneToURL(String url)
{
	if (driver.getCurrentUrl().contains(url))
	  {
	   return true;
	  }
	  return false;
}

public void gotoURL (String url)
{
	driver.get(url);
}

public String getUser()
{
	return user;
}

public Page getLastPage()
{
  return lastPage;
}

public void waitForPageLanding (Page page, int timeOutInSeconds)
{
	lastPage = null;
	boolean landingConfirmed = page.getDomeState().confirmlanding(driver,timeOutInSeconds);
	assertTrue(String.format("%s landing NOT confirmed.....", page.getClass().getSimpleName()), landingConfirmed);
	lastPage = page;
}

public WebDriver getDriver()
{
	return driver;
}

@Override
 public String toString()
 {
	return String.format("BrowserSession [driver=%s, user=%s, lastPage=%s]",  driver, user, lastPage); 
 }


} //End