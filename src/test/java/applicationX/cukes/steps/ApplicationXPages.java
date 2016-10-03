package applicationX.cukes.steps;

import org.apache.commons.logging.*;
//import org.openqa.jetty.log.LogFactory;

import contractorX.projectY.cukes.web.DOMState;
import contractorX.projectY.cukes.web.Page;


public class ApplicationXPages implements Page
{

	protected Log log = LogFactory.getLog(getClass());
	private DOMState domState;
	
	public ApplicationXPages(DOMState domState)
	{
		this.domState = domState;
	}
	
	@Override
	public DOMState getDomeState() {
		return domState;
	}

}
