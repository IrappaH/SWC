package com.swc.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesConfig {
	
	Properties prop;
	String PropertiesFilePath = "C:\\Users\\user\\OneDrive - Unizen Technologies\\SmartWaterController\\UZ_SWC_SeleniumTool\\data\\Configuration.properties";
	
	public PropertiesConfig() throws IOException {
		File file = new File(PropertiesFilePath);
		FileInputStream fis = new FileInputStream(file);
		prop = new Properties();
		prop.load(fis);
	}
	
//	public void readFromConfig() throws IOException {
//		
//		Properties prop = new Properties();
//		FileInputStream fis = new FileInputStream(System.getProperty(PropertiesFilePath));
//		prop.load(fis);
//		fis.close();
//		
//	}
	
	public String takeURL() {
		String url = prop.getProperty("url");
		if(url!= null) {
		return url;
		}else {
			throw new RuntimeException("url is not definied in the Configuration file");
		}
		
	}
	
	public String takeDriver() {
		String chromeDriver = prop.getProperty("chromeDriver");
		if(chromeDriver!= null) {
		return chromeDriver;
		}else {
			throw new RuntimeException("url is not definied in the Configuration file");
		}
		
	}

}
