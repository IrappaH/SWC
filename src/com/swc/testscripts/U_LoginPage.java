package com.swc.testscripts;


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
		String pw=Excel.getValue(XL_PATH, "ValidLogin",1,1);
		System.out.println("Reading from Excel password :"+ pw);
		String eTitle=Excel.getValue(XL_PATH,"ValidLogin",1,2);
		System.out.println("Reading from Excel title:"+ eTitle);
		LoginPage l=new LoginPage(driver);
		//Enter Valid UN
		l.setUserName("uswm");
		//Enter Valid pw
	
		l.setPassword("6");
		//Click login
		l.clickLogin();
		//verify home page....
		EnterPage e=new EnterPage(driver);
		String eTitle1 = "WaterConsumption | Liter";
		e.verifyHomePageIsDisplayed(driver, eTitle );
	}



}