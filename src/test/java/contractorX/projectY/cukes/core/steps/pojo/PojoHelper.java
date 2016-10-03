package contractorX.projectY.cukes.core.steps.pojo;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PojoHelper 
{
  protected Log log = LogFactory.getLog(getClass());
  private Map<String, PojoWrapper> registry = new HashMap<String, PojoWrapper>();
  private BeanUtilsBean beanUtilsBean = BeanUtilsBean.getInstance();
  
  public void registerPojoWrapper(String gherkinPropName, PojoWrapper pojowrapper)
  {
	  log.debug(String.format("register properties converter for %s ", gherkinPropName ));
	  registry.put(gherkinPropName, pojowrapper);
  }
  
  public Object instantiate (String gherkinName)
  {
	  log.debug(String.format("look up class type for %s ", gherkinName));
	  PojoWrapper pojoWrapper = registry.get(gherkinName);
	  if (pojoWrapper == null)
	  {
		  log.debug(String.format("look up class type for %s failed ", gherkinName));
	  }
	  try
	  {
		  String className = pojoWrapper.getClassName();
		  log.debug(String.format("Loading class %s ",  className));
		  Class<?> clazz = Thread.currentThread().getContextClassLoader().loadClass(className);
		  return clazz.newInstance();
	  }
	  catch (InstantiationException e)
	  {
		  log.error(String.format("Cannot instantiate object for %s ", gherkinName)); 
	  }
	  catch (IllegalAccessException e )
	  {
		  log.error(String.format("Cannot instantiate object for %s ", gherkinName));
	  }
	  catch (ClassNotFoundException e)
	  {
		  log.error(String.format("Cannot instantiate object for %s ", gherkinName));
	  }
	  return null;
  }
 
  @SuppressWarnings("rawtypes")
  public void setProperties(Object o, Map<String, String> properties)
  {
	  for (Entry<String, String> entry : properties.entrySet())
	  {
		  String gherkinName = entry.getKey();
		  String gherkinValue = entry.getValue();
		  log.debug(String.format("converting gherkinName '%s' with gherkinValue '%s' to and object", gherkinName, gherkinValue));
		  try
		  {
			  PojoWrapper pojoWrapper = registry.get(gherkinName);
			  String propName  = pojoWrapper.getName();
			  Class propClass = ClassLoader.getSystemClassLoader().loadClass(pojoWrapper.getClassName());
			  Object propValue = pojoWrapper.getConverter().convertToValue(gherkinValue, propClass);
			  log.debug(String.format("Setting propName '$s' with propValue '%s' ", propName, propValue));
			  if (o.getClass().equals(propValue.getClass()))
			  {
				  beanUtilsBean.copyProperties(o,  propValue);
			  }
			  else
			  {
				  beanUtilsBean.setProperty(o, propName, propValue);
			  }
		  }
		  catch (Exception e)
		  {
			  log.error(String.format("Cannot convert gherkinName '%s' with gherkinValue '%s' to an object", gherkinName, gherkinValue), e);
		  }
		  
	  }
  }
}
