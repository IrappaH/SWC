package com.swc.generic;

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

public abstract class BaseTest implements IAutoConst{
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
		Logger logger = Logger.getLogger(BaseTest.class);
		logger.debug("this Is Irappa modified---------");
		
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
		logger.info("This is info : " + browser);
	}
	
	//---------------------------------------------------------------------
	@AfterMethod(alwaysRun=true)
	public void closeApplication(ITestResult test) {
		String name=test.getName();
		System.out.println("the name we reading from closing app: "+name);
		int status=test.getStatus();
		if(status==1) {
			Reporter.log(name+" is PASSED",true);
		}
		else {
			Reporter.log(name+" is FAILED",true);
			AutoUtil.getPhoto(driver,IMG_PATH,name);
		}
		driver.quit();
	}
}

