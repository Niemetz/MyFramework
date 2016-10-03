package contractorX.projectY.cukes.web.components.impl;

import contractorX.projectY.cukes.web.components.UIComponent;

public abstract class BaseUIComponent implements UIComponent
{
	private static final int DEFAULT_SEELP_TIME = 300; //mili secs
	private static final boolean DEFAULT_VERIFY_FOR_LANDING_CONFIRMATION = true;
	protected boolean verifyForLandingConfirmation;
	
	protected int specifiedWaitTime = -1;
	private int specifiedSleepTime = 1;
	
	//  the first constructor
	public BaseUIComponent()
	{
		super();
		this.verifyForLandingConfirmation = DEFAULT_VERIFY_FOR_LANDING_CONFIRMATION;
	}
	
	// the second possible constructor
	public BaseUIComponent(int specifiedWaitTime, int specifiedSleepTinme)
	{
		super();
		this.specifiedWaitTime = specifiedWaitTime;
		this.specifiedSleepTime = specifiedSleepTinme;
	}
	// the third possible constructor
	public BaseUIComponent(boolean verifyForLandingConfirmation)
	{
		super();
		this.verifyForLandingConfirmation = verifyForLandingConfirmation;
	}
	
	/* the final constructor
	 It allows the user to specify these following:
	 1 - Is the page/component fully loaded? => verifyForLandingConfirmation = True/Flase
	 2 - Go to  sleep between the checking until the page/component fully loaded. => specifiedSleepTinme = mil secs
	 3 - After the page/component is fully loaded, wait for an additional few mil secs => specifiedWaitTime = mil secs
	     This is to make sure that the full page/component is stable.
	*/
	public BaseUIComponent(boolean verifyForLandingConfirmation, int specifiedWaitTime, int specifiedSleepTinme)
	{
		super();
		this.verifyForLandingConfirmation = verifyForLandingConfirmation;
		this.specifiedWaitTime = specifiedWaitTime;
		this.specifiedSleepTime = specifiedSleepTinme;
	}
	
	public boolean verifyForLandingConfirmation()
	{
		return verifyForLandingConfirmation;
	}
	
	// Set and Get the additional specified wait time AFTER the page was fully loaded 
	public void setSpecifiedWaitTime(int specifiedWaitTime)
	{
		this.specifiedWaitTime = specifiedWaitTime;
	}

	public int getSpecifiedWaitTime()
	{   
		return specifiedWaitTime;
	}
   
	// Set and Get the specified sleep time from the user or else use the DEFAULT_SEELP_TIME
	public void setSpecifiedSleepTime(int specifiedSleepTime)
	{
		this.specifiedSleepTime = specifiedSleepTime;
	}
	
	public int getSpecifiedSleepTime()
	{
		if (this.specifiedSleepTime != -1)
			return this.specifiedSleepTime;
		else
			return DEFAULT_SEELP_TIME;
	}
   	
}//end
