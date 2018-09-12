package com.swc.generic;

import java.io.File;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class ExtentManager {
	 public static ExtentReports extent;
	 public ExtentTest logger;
	    public synchronized static ExtentReports getReporter(){
	        if(extent == null){
	            //Set HTML reporting file location
	           // String workingDir = System.getProperty("user.dir");
	            extent = new ExtentReports("./Reports/ExtentReportResults.html", true);
	           // extent = new ExtentReports ("./Reports/test-output/STMExtentReport.html", true);
	            
	            extent
                .addSystemInfo("Host Name", "SoftwareTestingMaterial")
                .addSystemInfo("Environment", "Automation Testing")
                .addSystemInfo("User Name", "Irappa H");
                //loading the external xml file (i.e., extent-config.xml) which was placed under the base directory
                //You could find the xml file below. Create xml file in your project and copy past the code mentioned below
                extent.loadConfig(new File("./extent-config.xml"));
	        }
	        return extent;
	    }

}
