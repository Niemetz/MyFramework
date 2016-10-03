package contractorX.projectY.cukes.web;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class SessionManager 
{
 protected Log log = LogFactory.getLog(getClass());
 private Map<String, BrowserSession> browserSessions = new HashMap<String, BrowserSession>();
 private BrowserSession lastSession = null;
 
 public BrowserSession findOrCreateSession(String user, String browserType) throws Throwable
 {
	 lastSession = browserSessions.get(user);
	 if (lastSession == null)
	 {
		 lastSession = new BrowserSession(user, browserType);
		 browserSessions.put(user,  lastSession);
	 }
	 return lastSession;
 }
 
 public BrowserSession lastSession()
 {
	 
	 return lastSession;
 }
 
 public String lastUser()
 {
	 if (lastSession == null)
		 return null;
	 return lastSession.getUser();
 }
 
 public void terminateScenario()
 {
	 log.debug("Clean up before terminating screnario...");
	 for (Map.Entry<String, BrowserSession> entry : browserSessions.entrySet())
	 {
		 BrowserSession bs = browserSessions.get(entry.getKey());
		 log.debug(entry.getKey());
		 log.debug(bs);
		 bs.terminateScenario();
	 }
	 browserSessions.clear();
	 browserSessions = null;
	 lastSession = null;
 }
}//end
