package applicationX.cukes.web.components.impl.date;

import contractorX.projectY.cukes.web.components.InputField;
import contractorX.projectY.cukes.web.components.impl.TextField;

public abstract class AbstractDateField  extends TextField implements InputField<String>
{
	public AbstractDateField(String xpathExpression)
	{
		super(xpathExpression);
	}
	public AbstractDateField(String xpathExpression, boolean verifyForLandingConfirmation)
	{
		super(xpathExpression, verifyForLandingConfirmation);
	}
	
}
