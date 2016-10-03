package contractorX.projectY.cukes.web.components.impl;

public class Label extends XPathComponent
{

	// First constructor
	public Label(String xpathExpression) 
	{
		super(xpathExpression);
	}
	
	// Second constructor
	public Label(String xpathExpression, boolean verifyForLandingConfirmation) 
	{
		super(xpathExpression,verifyForLandingConfirmation);
	}
	
	// final constructor
	public Label(String xpathExpression, boolean verifyForLandingConfirmation, int sepcifiedWaitTime, int specifiedSleepTime) 
	{
		super(xpathExpression,verifyForLandingConfirmation,sepcifiedWaitTime, specifiedSleepTime);
	}
	
	public String getText()
	{
		return super.getElement().getText();
	}

}
