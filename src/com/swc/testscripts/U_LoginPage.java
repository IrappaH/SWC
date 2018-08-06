package com.swc.testscripts;


import org.apache.poi.util.SystemOutLogger;
import org.testng.annotations.Test;

import com.swc.common.BaseTest;
import com.swc.common.Excel;
import com.swc.pompages.EnterPage;
import com.swc.pompages.LoginPage;


public class U_LoginPage extends BaseTest{

	@Test(priority=1,groups= {"login","smoke"})
	public void testValidLogin() {
	//	String un=Excel.getValue(XL_PATH,"ValidLogin",1,0);
		String un = Excel.getValue(XL_PATH, "ValidLogin", 1, 0);
		System.out.println("Reading from Excel username  :"+ un);
		String pw=Excel.getValue(XL_PATH, "ValidLogin", 1, 1);	
		System.out.println("Reading from Excel password :"+ pw);
		String eTitle=Excel.getValue(XL_PATH,"ValidLogin",1,2);
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
		e.verifyHomePageIsDisplayed(driver, eTitle );
		String current_userName = l.verify_current_userName();
		Excel.writeIntoExcel(XL_PATH, "sheet1", 0, 0, current_userName);
		System.out.println("This is the current user name :"+ current_userName);
	}

	


}