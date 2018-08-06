package com.swc.pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.swc.common.AutoUtil;
import com.swc.common.IAutoConst;


public class EnterPage {

	@FindBy(xpath="(//div[@class='col-xs-6 col-md-6 text-center'])[1]")
	private WebElement users;
	
	@FindBy(linkText="About your actiTIME")
	private WebElement aboutAT;
	
	@FindBy(xpath="(//div[@class='col-xs-6 col-md-6 text-center'])[12]")
	private WebElement sensors;
	
	public EnterPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public void getValueFromUSers() {
		users.getAttribute("value");
	}
	
	public void getValuefromSensors() {
		aboutAT.click();
	}
	
	public void verifyProductVersion(String eVersion) {
	//	String aVersion=Version.getText();
	//	Assert.assertEquals(aVersion,eVersion);
	}
	
	public void verifyHomePageIsDisplayed(WebDriver driver,String eTitle) {
		String strETO = AutoUtil.getProperty(IAutoConst.CONFIG_PATH,"ETO");
		long ETO = Long.parseLong(strETO);
		WebDriverWait wait=new WebDriverWait(driver,ETO);
		try {
			wait.until(ExpectedConditions.titleIs(eTitle));
			Reporter.log("HomePage is Displayed",true);
		}
		catch (Exception e) {
			Reporter.log("HomePage is Not Displayed",true);
			Assert.fail();
		}
		
	}
}
