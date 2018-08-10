package com.swc.testscripts;


import org.apache.poi.util.SystemOutLogger;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.swc.generic.BaseTest;
import com.swc.generic.Excel;
import com.swc.pompages.EnterPage;
import com.swc.pompages.LoginPage;


public class U_LoginPage extends BaseTest{

	@Test(priority=1,groups= {"login","smoke"})
	public void testValidLogin() {
		int rc = Excel.getRowCount(XL_PATH, "ValidLogin");
		System.out.println("Total number of valid users count:"+rc);
		for(int i=1;i<=rc;i++) {
		String un = Excel.getValue(XL_PATH, "ValidLogin", i, 0);
		System.out.println("Reading from Excel username  :"+ un);
		String pw=Excel.getValue(XL_PATH, "ValidLogin", i, 1);	
		System.out.println("Reading from Excel password :"+ pw);
		String eTitle=Excel.getValue(XL_PATH,"ValidLogin",i,2);
		System.out.println("Reading from Excel title:"+ eTitle);
		//Created Pom class for login page Page
		LoginPage l=new LoginPage(driver);
		//Enter Valid UN
		l.setUserName(un);
		//Enter Valid pw		
		l.setPassword("6");
		//Click login
		l.clickLogin();
		
		//verify home page....
		EnterPage e=new EnterPage(driver);
		String eTitle1 = "WaterConsumption | Liter";
		String current_userName = l.verify_current_userName();
		Reporter.log("Login success for :"+current_userName+ " and verifying below message");
		e.verifyHomePageIsDisplayed(driver, eTitle );
		
		Reporter.log( "Login success for: " + current_userName);
		/*Excel.writeIntoExcel(XL_PATH, "sheet1", 0, 0, current_userName);
		System.out.println("This is the current user name :"+ current_userName);*/
		l.SignOut();
	}

	}


}