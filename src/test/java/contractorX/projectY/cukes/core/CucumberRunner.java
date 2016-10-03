package contractorX.projectY.cukes.core;

import java.io.IOException;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.model.InitializationError;
import cucumber.api.junit.Cucumber;


public class CucumberRunner extends Cucumber
{
	public CucumberRunner(Class<?> testClass) throws InitializationError, IOException
	{
		super(testClass);
	}
	@Override
	public void run (RunNotifier notifier)
	{
		CucumberTest cucumberTest;
		try
		{
			cucumberTest = (CucumberTest) getTestClass().getJavaClass().newInstance();
		}
		catch(Throwable e)
		{
			throw new RuntimeException("Error in cucumber runner ", e);
		}
		cucumberTest.beforeAll();
		super.run(notifier);
		cucumberTest.beforeAll();
		
	}
	
}
