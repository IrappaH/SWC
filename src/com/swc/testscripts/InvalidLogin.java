package com.swc.testscripts;

import org.testng.annotations.Test;

import com.swc.generic.BaseTest;
import com.swc.generic.Excel;
import com.swc.pompages.LoginPage;

public class InvalidLogin extends BaseTest {
	@Test(priority=1,groups= {"login"})
	public void testbInvalidLogin() throws InterruptedException {
		int rc=Excel.getRowCount(XL_PATH, "InvalidLogin");
		System.out.println("Total number of rows getting from Excel invalid sheet: "+rc);
		for(int i=1;i<=rc;i++) {
		String un=Excel.getValue(XL_PATH,"InvalidLogin",i,0);
		String pw=Excel.getValue(XL_PATH,"InvalidLogin",i,1);
		String expectedMSG=Excel.getValue(XL_PATH,"InvalidLogin",i,2);
		LoginPage l=new LoginPage(driver);
		//Enter invalid user name
		l.setUserName(un);
		//Enter invalid password
		l.setPassword(pw);
		//Click login
		l.clickLogin();
		Thread.sleep(1000);
		//Verify err msg
		l.verifyErrMsg(expectedMSG);
		Thread.sleep(2000);
		
		
		}
	}

}
