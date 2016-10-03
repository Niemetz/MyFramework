package applicationX.cukes.web.components.impl.date;

import contractorX.projectY.cukes.web.components.InputField;
import contractorX.projectY.cukes.web.components.impl.TextField;

public abstract class AbstractTimeField extends TextField implements InputField<String>, TimeField
{
	public AbstractTimeField(String xpathExpression)
	{
		super(xpathExpression);
	}
	
	public AbstractTimeField(String xpathExpression, boolean verifyForLandingConfirmation)
	{
		super(xpathExpression, verifyForLandingConfirmation);
	}
}
