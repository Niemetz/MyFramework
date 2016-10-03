package contractorX.projectY.cukes.core.converter;

public interface GherkinToValueConverter 
{
	@SuppressWarnings("rawtypes")
	public Object convertToValue(String gherkinValue, Class clazz);
}
