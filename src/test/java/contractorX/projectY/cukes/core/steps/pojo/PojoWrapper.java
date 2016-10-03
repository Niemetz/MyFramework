package contractorX.projectY.cukes.core.steps.pojo;
import contractorX.projectY.cukes.core.converter.GherkinToValueConverter;

public class PojoWrapper {
	private String name;
	private String className;
	private GherkinToValueConverter converter;
	public PojoWrapper()
	{
		super();
	}
	
	public PojoWrapper (String name, String className, GherkinToValueConverter converter)
	{
		super();
		this.name = name;
		this.className = className;
		this.converter = converter;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public GherkinToValueConverter getConverter() {
		return converter;
	}

	public void setConverter(GherkinToValueConverter converter) {
		this.converter = converter;
	}
	


}
