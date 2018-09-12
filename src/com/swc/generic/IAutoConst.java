package com.swc.generic;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public interface IAutoConst {
	String CHROME_KEY="webdriver.chrome.driver";
	String CHROME_VALUE="./data/chromedriver.exe";
	String GECKO_KEY="webdriver.gecko.driver";
	String GECKO_VALUE="./drivers/geckodriver.exe";
	String EDGE_KEY="webdriver.edge.driver";
	String EDGE_VALUE="./drivers/MicrosoftWebDriver.exe";
	String IE_KEY="webdriver.ie.driver";
	String IE_VALUE="./drivers/IEDriverServer.exe";
	String XL_PATH="./data/input.xlsx";
	String CONFIG_PATH="./data/config.properties";
	String IMG_PATH="./screenshots/";
	String LOG4J_Path = " ./Reports/SWC_log_html";
	String EXTENT_REPORT = "./Reports/test-output/STMExtentReport.html";
	//ExtentReports extent =  new ExtentReports ("./Reports/test-output/STMExtentReport.html", true);
	//ExtentTest Logger = null;
	
}
