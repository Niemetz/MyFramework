package contractorX.projectY.cukes.core;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class StepBase {
	
	protected Log log = LogFactory.getLog(getClass());
	private static Map<Class<? extends StepBase>, Map<Field, Object>> globals = 
			       new HashMap<Class<? extends StepBase>, Map<Field, Object>>();
	
	protected static CucumberTest globalTestInstance = null;
	protected StepBase()
	{
		Map<Field, Object> globalMap = globals.get(getClass());
		if (globalMap != null)
		{
			for (Entry<Field, Object> entry : globalMap.entrySet())
			{
				Object value = entry.getValue();
				if (value == null)
					throw new RuntimeException("Global is null");
				try
				{
					entry.getKey().set(this, value);
				}
				catch (Throwable t)
				{
					throw new RuntimeException("Error initializing globals", t);
				}
			}
		}
	}
	
	static public final void scanGlobals (Class<? extends StepBase> scanClass,  CucumberTest testInstance )
	{
		globalTestInstance = testInstance;
		Class<?> objectClass = scanClass;
		while (!Object.class.equals(objectClass))
		{
			for (Field field : objectClass.getDeclaredFields())
			{
				if (field.isAnnotationPresent(Global.class))
				{
					Object value;
					try
					{
						field.setAccessible(true);
						value = getGlobalValue(field, testInstance);
						Map<Field, Object> mapping = globals.get(scanClass);
						if (mapping == null)
						{
							mapping = new HashMap<Field, Object>();
							globals.put(scanClass, mapping);
						}
					}
					catch (Throwable t)
					{
						throw new RuntimeException("Error getting value for global field '" + field.getName()+ "'");
					}
				}
			}
			objectClass = objectClass.getSuperclass();
			
		}
		
	}

	private static final Object getGlobalValue(Field f, CucumberTest testInstance)
	{
		for (Class<?> c = testInstance.getClass(); (!CucumberTest.class.equals(c)); c = c.getSuperclass())
		{
			Field[] testFields = c.getDeclaredFields();
			for (Field t : testFields)
			{
				if (!f.getName().equals(t.getName()))
					continue;
				if (!f.getName().equals(t.getType()))
					continue;
				if (!t.isAnnotationPresent(Global.class))
					continue;
				try
				{
					t.setAccessible(true);
					return t.get(testInstance);
				}
				catch (Throwable e)
				{
					throw new RuntimeException("Unable to get value of global field");
				}
			}
		}
		
		return null;
	}
}//end
