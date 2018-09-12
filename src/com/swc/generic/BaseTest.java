package com.swc.generic;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public abstract class BaseTest extends ExtentManager implements IAutoConst{
	public WebDriver driver;
	
	static {
		System.setProperty(CHROME_KEY,CHROME_VALUE);
		System.setProperty(GECKO_KEY,GECKO_VALUE);
		System.setProperty(EDGE_KEY, EDGE_VALUE);
		/*System.setProperty(IE_KEY, IE_VALUE);*/
		
	}
	
	@Parameters({"ip","browser"})
	@BeforeMethod(alwaysRun=true)
	public void openApplication(String ip,String browser) throws Exception {
		//logger = extent.startTest("Launch the browser ");	
		String appURL=AutoUtil.getProperty(CONFIG_PATH,"URL");
		String strITO = AutoUtil.getProperty(CONFIG_PATH,"ITO");
		long ITO = Long.parseLong(strITO);
		System.out.println("this is browser name "+ browser);
		URL whichSystem=new URL("http://"+ip+":4444/wd/hub");
		DesiredCapabilities whichBrowser=new DesiredCapabilities();
		whichBrowser.setBrowserName(browser);
		driver=new RemoteWebDriver(whichSystem, whichBrowser);
	//	driver= new EdgeDriver();
	//	driver = new InternetExplorerDriver();
		driver.get(appURL);
		driver.manage().timeouts().implicitlyWait(ITO,TimeUnit.SECONDS);
		
		
	}
	
	//---------------------------------------------------------------------
	@AfterMethod(alwaysRun=true)
	public void closeApplication(ITestResult test) {
		String name=test.getName();
		System.out.println("The method we are closing that is: "+name);
		int status=test.getStatus();
		if(status==1) {
			Reporter.log(name+" is PASSED",true);
			logger.log(LogStatus.PASS, "+name+ is PASSED");
		}
		else {
			Reporter.log(name+" is FAILED",true);
			AutoUtil.getPhoto(driver,IMG_PATH,name);
		}
		driver.quit();
	}
}