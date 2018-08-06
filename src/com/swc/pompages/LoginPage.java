package com.swc.pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage {

	@FindBy(id="uname")
	private WebElement unTB;
	
	@FindBy(name="pass")
	private WebElement pwTB;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement loginBTN;
	
	@FindBy(xpath="//span[contains(.,'Please enter')]|//span[contains(.,'Invalid User')]")
	private WebElement errMsg;
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void setUserName(String un) {
		unTB.sendKeys(un);
	}
	
	public void setPassword(String pw) {
		pwTB.sendKeys(pw);
	}
	
	public void clickLogin() {
		loginBTN.click();
	}
	
	public void verifyErrMsg(String expectedMSG) {
		String actualMSG=errMsg.getText();
		Assert.assertEquals(actualMSG,expectedMSG);
	}

}
