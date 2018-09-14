package com.swc.testscripts;

import org.testng.annotations.Test;

import com.swc.generic.BaseTest;
import com.swc.pompages.HousingBook;
import com.swc.pompages.LoginPage;
public class Home_page extends BaseTest{
	
	
	@Test(priority=3, invocationCount=2)
	public void WaterConsumptionInLitres() throws InterruptedException {
		LoginPage l=new LoginPage(driver);
		//Enter Valid UN
		l.setUserName("uswm");
		//Enter Valid pw		
		l.setPassword("6");
		//Click login
		l.clickLogin();
		
		HousingBook HT = new HousingBook(driver);
		HT.HouseApp(0);
		HT.AppDropDown(1);
		HT.BlockDropDown(1);
		HT.WaterDropDown(1);
		HT.FromDate("07/23/2018 6:20 PM");
		HT.ToDate("09/23/2018 6:20 PM");
		HT.Submit();

		}
	

}
