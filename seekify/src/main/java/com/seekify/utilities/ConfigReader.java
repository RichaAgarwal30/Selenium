package com.seekify.utilities;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

public class ConfigReader {

	static Logger logger = Logger.getLogger(ConfigReader.class);
	
	private static String readConfig(String fileName, String config) {
		Properties property = new Properties();
		try {
			property.load(new FileInputStream(fileName));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return property.getProperty(config);
	}
	
	public static synchronized String getConfig(String config) {
		
		if (readConfig("app.properties", "ENV").equalsIgnoreCase("qa")) {
			String configValue = readConfig("qa.properties", config);
			System.out.println("Config of "+config+" - "+configValue);
			return configValue;
		}
		if (readConfig("app.properties", "ENV").equalsIgnoreCase("prod")) {
			String configValue = readConfig("prod.properties", config);
			System.out.println("Config of "+config+" - "+configValue);
			return configValue;
		}
		else return null;		
	}
	
	public static synchronized String getENVConfigValue() {		
		return readConfig("app.properties", "ENV");		
	}
	
	public static synchronized String allowToSendEmail() {		
		return readConfig("app.properties", "allowToSendEmail");		
	}
	
	public static synchronized String getBrowserName() {		
		return readConfig("app.properties", "browser");		
	}			
}
