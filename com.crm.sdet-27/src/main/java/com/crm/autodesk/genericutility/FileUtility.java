package com.crm.autodesk.genericutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
/**
 * 
 * @author Shivakumar S
 *
 */

public class FileUtility {
	/**
	 * 
	 * @param key
	 * @return value
	 * @throws Throwable
	 */
	
	public String getPropertyKeyValue(String key) throws Throwable
	{
	FileInputStream fis = new FileInputStream("./data/commonData.properties");
	 Properties pobj = new Properties();
	 pobj.load(fis);
	 String value = pobj.getProperty(key);
	return value;

}
}
