package applicationX.cukes.web;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertNotNull;
import org.apache.commons.logging.*;
//import org.openqa.jetty.log.LogFactory;

import contractorX.projectY.cukes.web.URLResolver;

// This table hold all application URLs
//  Need to add your URL for the applicaiton you need to test to this table
public class ApplicationXURLResolver implements URLResolver
{

	/* ORIGIN
	private Log log = LogFactory.getLog(getClass());
	private Map<String, String> simpleURLMap = new HashMap<String, String>();
	private static final String PROTOCOL = "http";
	private static final String HOST = "12.13.14.15";
	private static final int PORT = 9090;
	private static final String URL_TMPL = "%s://%s:%d%s";
	*/
	private Log log = LogFactory.getLog(getClass());
	private Map<String, String> simpleURLMap = new HashMap<String, String>();
	private static final String PROTOCOL = "https";
	private static final String HOST = "www.amazon.com";
	//private static final int PORT = 9090;
	private static final String URL_TMPL = "%s://%s";
	
	public ApplicationXURLResolver()
	{
		simpleURLMap.put("ApplicationX", toUrl("/x/y/z"));
	}
	
	public static String toUrl(String uri)
	{
		//return String.format(URL_TMPL, PROTOCOL, HOST, PORT, uri);
		return String.format(URL_TMPL, PROTOCOL, HOST);
	}
	
	@Override
	public String resolveURL(String gherkinName) 
	{
		String url = simpleURLMap.get(gherkinName);
		assertNotNull("Unkonw URL '" + gherkinName + "'", url);
		log.debug(String.format("gherkinName = %s; url = %s", gherkinName, url));
		return url;
	}

}
