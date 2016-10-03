package applicationX.cukes.web;

import static org.junit.Assert.assertNotNull;
import contractorX.projectY.cukes.web.Page;
import contractorX.projectY.cukes.web.PageResolver;
import applicationX.cukes.steps.ApplicationXPages;
import applicationX.cukes.web.dom.home.HomeDOM;

import org.apache.commons.logging.Log;
//import org.openqa.jetty.log.LogFactory;

import java.util.HashMap;
import java.util.Map;

// This is the place where all pages and their components are mapped and saved in the common page table (HashMap table, that is)
public class ApplicationXPageResolver  implements PageResolver
{
	
	
	private Map<String,Page> componentTable = new HashMap<String, Page>();
	
	/* This constructor is used to create a mapping of ALL pages in the ApplicationX/
	 * - The first paramter is the actual name of the component on the page
	 * - The second parameter is xpathLocator/cssSelector of the component on the page
	 *   Note that the ApplicationXPages method get the component of a page based the method xDOM which returns the location of the
	 *   component on the page.  The page as the methos suggests has it name,  For exmaple, all of the components on the Home page is defined 
	 *   in the "HomeDOM" page.
	 */
	
	// each component on the pages is mapped to this table
	public ApplicationXPageResolver()
	{
		 // The Home page... all components on the Home page is defined in the "HomeDOM" file.
		 // do the same thing for other pages.
		componentTable.put("User Profile link", new ApplicationXPages(new HomeDOM()));
		//  The X page
		
		// the Y Page
		
		// the Z page etc....
		
	}
	

	@Override
	public Page resolvePage(String gherkinPageName) {
		Page page = componentTable.get(gherkinPageName);
		assertNotNull("=> Unknown page named '" + gherkinPageName + "' .  Can't find tis page in the table pagesMapping", page);
        // Need to write an error message to the debug log
		return page;
	}
	

}
