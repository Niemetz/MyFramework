package contractorX.projectY.cukes.core;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;

class PackageScanner 
{
  static public Set<Class<?>> scanPakages(ClassLoader classLoader, String[] basePackages)
  {
	  HashSet<Class<?>> classes = new HashSet<Class<?>>();
	  for (String pkgName : basePackages)
	  {
		  String resName = pkgName.replace('.',  '/');
		  Enumeration<URL> urls;
		  
		  try
		  {
			  urls = classLoader.getResources(resName);
		  }
		  catch (Throwable t)
		  {
			  continue;
		  }
		  while (urls.hasMoreElements())
		  {
			  URL url = urls.nextElement();
			  scanURL(pkgName, resName, classes, url);
		  }
	  }
	  return classes;
  }
  static private void scanURL(String pkgName, String resName, HashSet<Class<?>> classes, URL url)
  {
	  try
	  {
		  URI uri = new URI(url.toString());
		  File file = new File(uri);
		  if (file.isDirectory() && uri.getPath().endsWith(resName))
		  {
			  scanFiles(pkgName, resName, classes, file.listFiles());
		  }
	  }
	  catch (URISyntaxException e)
	  {
		  
	  }
  }
  static private void scanFiles (String pkgName, String resName, HashSet<Class<?>> classes, File[] fileList)
  {
	  for ( File file : fileList)
	  {
		  String baseName = file.getName();
		  if (file.isDirectory())
		  {
			  scanFiles(pkgName + "." + baseName, resName, classes, file.listFiles());
		  }
		  else if (baseName.endsWith(".class"))
		  {
			  String className = pkgName + "." + baseName.substring(0, baseName.length() - 6);
			  try
			  {
				  classes.add(Class.forName(className));
			  }
			  catch (ClassNotFoundException e)
			  {
				  throw new RuntimeException("Class for " + className + " not fopund", e);
			  }
		  }
	  }
  }
  
}//end
