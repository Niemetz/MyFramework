package contractorX.projectY.cukes.core.steps.pojo;

import java.util.Map;

import contractorX.projectY.cukes.core.Global;
import contractorX.projectY.cukes.core.StepBase;
import cucumber.api.java.en.Given;

public class ConstructPojo extends StepBase
{
  @Global
  private PojoHelper pojoHelper;
  @Global
  private Map<String, Object> nameMap;
  @Given("^a \"(.*?)\" with username \"(.*?)\" constructs a new \"(.*?)\" object named \"(.*?)\" with$")
  public void constructObject(String userNamed, String userNameValue, String objClass, String name, Map<String,String> properties)
  {
	  log.debug(String.format("Construct POJO for objClass=%s with name=%s and properties=%s", objClass, name, properties));
	  Object ciapUser =  pojoHelper.instantiate(userNamed);
	  
	  pojoHelper.setProperties(ciapUser, Utils.toMap(userNamed, userNameValue));
	  nameMap.put(userNamed, ciapUser);
	  Object o = pojoHelper.instantiate(objClass);
	  log.debug(String.format("%s was instantiated successfully ",  o.getClass()));
	  pojoHelper.setProperties(o, properties);
	  log.debug(String.format("%s was instantiated successfully", o));
	  nameMap.put(name, o);    
  }

}
