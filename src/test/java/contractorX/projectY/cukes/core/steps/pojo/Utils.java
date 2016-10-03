package contractorX.projectY.cukes.core.steps.pojo;

import java.util.HashMap;
import java.util.Map;

public class Utils 
{
  public static Map<String, String> toMap (String gherkinName, String gherkinValue)
  {
	 Map<String, String> map = new HashMap<String, String>();
	 map.put(gherkinName, gherkinValue);
	 return map;
  }
}
