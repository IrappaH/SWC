package com.swc.testscripts;


import java.util.List;

import org.apache.log4j.Logger;
import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.swc.generic.BaseTest;
import com.swc.generic.Excel;
import com.swc.pompages.EnterPage;
import com.swc.pompages.HousingBook;
import com.swc.pompages.LoginPage;
import com.swc.pompages.WaterConsumptionInLitres;


public class U_LoginPage extends BaseTest{

//	final static Logger logger = Logger.getLogger(U_LoginPage.class);
	@Test(priority=2,groups= {"login","smoke"})
	public void testValidLogin() throws InterruptedException {
		//logger = extent.startTest("Test Case Passed is User login validTest methon paased");
		int rc = Excel.getRowCount(XL_PATH, "ValidLogin");
		System.out.println("Total number of valid users count:"+rc);
	//	logger = extent.startTest("Test Case Passed total number rows: "+ rc);
	//	logger.log(LogStatus.PASS, "Test Case Passed is Row count: "+rc);
		for(int i=1;i<=rc;i++) {
		String un = Excel.getValue(XL_PATH, "ValidLogin", i, 0);
		System.out.println("Reading from Excel username  :"+ un);
	//	String pw=Excel.getValue(XL_PATH, "ValidLogin", i, 1);	
		String pwd= Excel.getCellValue(XL_PATH, "ValidLogin", i, 1);
		System.out.println("Reading from Excel password :"+ pwd);
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
		//Hi Added Here see
		//verify home page....
		
		EnterPage e=new EnterPage(driver);
		String eTitle1 = "WaterConsumption | Liter";
		String current_userName = l.verify_current_userName();
		
		Reporter.log("Login success for :"+current_userName+ " and verifying below message");
		e.verifyHomePageIsDisplayed(driver, eTitle );
		
		Reporter.log( "Login success for: " + current_userName);
		System.out.println("The username :"+ current_userName);
		
		/*Home_page hm= new Home_page();
		hm.WaterConsumptionInLitres();*/
		/*Excel.writeIntoExcel(XL_PATH, "sheet1", 0, 0, current_userName);
		System.out.println("This is the current user name :"+ current_userName);*/
		//Home_page Hm = new Home_page();
		//Hm.WaterConsumptionInLitres();z
		
		}
	}
}

	
		/*		
		
		//House Type
		WebElement Housing_Type = driver.findElement(By.name("typeId"));
		Select sele = new Select(Housing_Type);
		List<WebElement> HToptions = sele.getOptions();
		int size = HToptions.size();
		System.out.println("The House type itesm:"+ size );
		for(int h=0; h<size; h++){
			WebElement HToptiont = HToptions.get(h);
			String House_type = HToptiont.getText();
			System.out.println("The selected list item is : "+ House_type);
			sele.selectByIndex(h);
			 driver.findElement(By.xpath("//input[@type='submit']")).click();
			 Alert aler = driver.switchTo().alert();
		      String alerttx = aler.getText();
		  //    Reporter.log(alerttxt);
		      System.out.println(alerttx);
		      aler.accept();
		
		
		//org	-->i
		
		WebElement orgdropmenu = driver.findElement(By.name("orgid"));
		  Select select = new Select(orgdropmenu); 
		  List<WebElement> allOption = select.getOptions();
		  int count = allOption.size();
		  System.out.println("total number of org list items :"+count);
		  
		   for(i=1; i<count; i++) {
		      WebElement option = allOption.get(i);
		      String text = option.getText();
		      System.out.println("The selected list item is : "+text);   
		      select.selectByIndex(i);  
		      driver.findElement(By.xpath("//input[@type='submit']")).click();
		      Alert alert = driver.switchTo().alert();
		      String alerttxt = alert.getText();
		      Reporter.log(alerttxt);
		      System.out.println(alerttxt);
		      alert.accept();
		    
		     //appid->j
		        Thread.sleep(2000);
		         WebElement Appdropmenu = driver.findElement(By.name("appid"));
		   Select  select1= new Select(Appdropmenu);
		     List<WebElement> allOption1 = select1.getOptions();
		         int count1 = allOption1.size();
		         System.out.println("total number of app list items :"+count1);
		        for(int j=1; j<count1;j++) {
		       
		         WebElement  option1 = allOption1.get(j);
		         String  text1 = option1.getText();
		           System.out.println("The selected list item is : "+text1);     
		           select1.selectByIndex(j);     
		           driver.findElement(By.xpath("//input[@type='submit']")).click();
		           alert = driver.switchTo().alert();
		           String alerttxt1 = alert.getText();
		           Reporter.log(alerttxt1);
		           System.out.println(alerttxt1);
		           alert.accept(); 
		           
		     //devid ->k
		              Thread.sleep(2000);
		              WebElement devdropmenu = driver.findElement(By.name("devid"));
		           Select  select2 = new Select(devdropmenu);
		           List<WebElement> allOption2 = select2.getOptions();
		            int  count2 = allOption2.size();
		              System.out.println("total number of devue list items :"+count2);
		              for(int k=1; k<count2; k++) {
		             WebElement   option2 = allOption2.get(k);
		               String text2 = option2.getText();
		                System.out.println("The selected list item is : "+text2);               
		                select2.selectByIndex(k);
		                driver.findElement(By.xpath("//input[@type='submit']")).click();
		                  alert = driver.switchTo().alert();
		                  String alerttxt2 = alert.getText();
		                 Reporter.log(alerttxt2);
		                  System.out.println(alerttxt2);
		                  alert.accept();  */
				
				/*
				
		        //fromDate 
		                  Thread.sleep(1000);
		                  WebElement datefield = driver.findElement(By.xpath("//input[@id='fromDate']"));
		                  datefield.sendKeys("07/23/2018 6:20 PM");	
		                  	String xpath1 = "//span[@class='glyphicon glyphicon-calendar']";
		              		WebElement datefield = driver.findElement(By.xpath(xpath1));
		              		datefield.click();
		              		Thread.sleep(1000);
		              	//	driver.findElement(By.xpath(xpath)).click();
		              		driver.findElement(By.xpath("//input[@type='submit']")).click();
		                 Alert alert = driver.switchTo().alert();
		                  String alerttxt3 = alert.getText();
		               Reporter.log(alerttxt3);
		                  System.out.println(alerttxt3);
		                  alert.accept(); 
		        //toDate
		                  Thread.sleep(1000);
		                  WebElement todatefield = driver.findElement(By.xpath("//input[@id='toDate']"));
		                  todatefield.sendKeys("09/23/2018 6:20 PM");
		                  String x1 = "(//span[@class='glyphicon glyphicon-calendar'])[2]";
		      			WebElement todatefield = driver.findElement(By.xpath(x1));
		      			todatefield.click();
		      			Thread.sleep(1000);
		      			driver.findElement(By.xpath(x1)).click();
		                
		                  Thread.sleep(2000);
		                  driver.findElement(By.xpath("//input[@type='submit']")).click();
		                  System.out.println("Final submit success");
		                  datefield.clear();
		                  System.out.println("Fromdate cleared..........");
		                  todatefield.clear();
		                  System.out.println("Todate cleared..........");
		                  //devdropmenu.clear();
		                  
		                  
		                 // driver.navigate().refresh();
		                  //select.deselectByIndex(k);
		                  //driver.navigate().refresh();
		                  Thread.sleep(1000);
		                  
		               } 
		           System.out.println("Control is here after dueUE");*/
		           //select.selectByIndex(j++);
		  /* }
		        System.out.println("Control is here after app");      												
						
			} System.out.println("Control is here after House type");  
		
		} System.out.println("Control Come out of the loop "); */
		
	/*	
	}

	}



}*/