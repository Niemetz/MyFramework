package applicationX.cukes.web.dom.home;

import contractorX.projectY.cukes.web.components.impl.Button;
import contractorX.projectY.cukes.web.components.impl.Label;
import applicationX.cukes.web.dom.ApplicationXDOMState;



public class HomeDOM extends ApplicationXDOMState
{
	 public HomeDOM()
	 {
	   /* - The first parameter must be the axact name of the comopnent on the page
	    * - The second parameter is the xpath location of the component on the page.  The "Label()", "Button()", "CheckBox()", etc... 
	    *   are defined under the package => "contractorX.projectY.cukes.web.components.impl"
	    * - The third paramter is set by the tester to tell the code whether he wants it to check if the component is on the page or not.
	    *   There are cases where the application can create a dynamic object which can be visible/disabled at some point on the page
	    */
	
	   putComponent("The exact name of the component on the page", new Label("The xpath location of the component onf the page", true));
	 }

}
