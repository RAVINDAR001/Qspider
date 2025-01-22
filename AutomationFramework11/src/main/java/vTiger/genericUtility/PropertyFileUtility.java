package vTiger.genericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * THis class consist of method related to read the data from property file
 */
public class PropertyFileUtility {
	
	/**
	 * This methos is used to read the data from property file
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String toReadTheDataFromPropertyfile(String key) throws IOException {
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\commonData.properties");
		Properties prop=new Properties();
		prop.load(fis);
		
		 String value = prop.getProperty(key);
		 return value;
	}

}
