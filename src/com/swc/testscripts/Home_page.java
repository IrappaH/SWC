package com.swc.testscripts;

import java.util.List;

import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import com.swc.generic.BaseTest;
import com.swc.pompages.EnterPage;
import com.swc.testscripts.*;

public class Home_page extends BaseTest{
	//	public void UserDevice() {EnterPage e = new EnterPage(driver);	}
	
	 
	public void WaterConsumptionInLitres() throws InterruptedException {
	//org	-->i	
		
		Thread.sleep(2000);
		WebElement orgdropmenu = driver.findElement(By.name("orgid"));
		Select select = new Select(orgdropmenu);	
		List<WebElement> allOption = select.getOptions();
		int count = allOption.size();
		System.out.println("total number of org list items :"+count);
		
			for(int i=3; i<count; i++) {
						WebElement option = allOption.get(i);
						String text = option.getText();
						System.out.println("The selected list item is : "+text);			
						select.selectByIndex(i);		
						driver.findElement(By.xpath("//input[@type='submit']")).click();
						Alert alert = driver.switchTo().alert();
						String alerttxt = alert.getText();
						System.out.println(alerttxt);
						alert.accept();
				
					//appid->j
						Thread.sleep(2000);
									WebElement Appdropmenu = driver.findElement(By.name("appid"));
									Select select1 = new Select(Appdropmenu);
									 List<WebElement> allOption1 = select1.getOptions();
									int count1 = allOption1.size();
									System.out.println("total number of app list items :"+count1);
									for(int j=1; j<count;j++) {
											WebElement option1 = allOption1.get(j);
											String text1 = option1.getText();
											System.out.println("The selected list item is : "+text1);					
											select1.selectByIndex(j);					
											driver.findElement(By.xpath("//input[@type='submit']")).click();
											Alert alert1 = driver.switchTo().alert();
											String alerttxt1 = alert1.getText();
											System.out.println(alerttxt1);
											alert.accept();	
											
					//devid ->k
														Thread.sleep(2000);
														WebElement devdropmenu = driver.findElement(By.name("devid"));
														Select select2 = new Select(devdropmenu);
														 List<WebElement> allOption2 = select.getOptions();
														int count2 = allOption2.size();
														System.out.println("total number of devue list items :"+count2);
														for(int k=1; k<count; k++) {
																 WebElement option2 = allOption.get(k);
																String text2 = option2.getText();
																System.out.println("The selected list item is : "+text2);															
																select2.selectByIndex(k);
																driver.findElement(By.xpath("//input[@type='submit']")).click();
																		alert = driver.switchTo().alert();
																		String alerttxt2 = alert.getText();
																		System.out.println(alerttxt2);
																		alert.accept();		
								//fromDate	
																		WebElement datefield = driver.findElement(By.xpath("//input[@id='fromDate']"));
																		datefield.sendKeys("07/23/2018 6:20 PM");
																		driver.findElement(By.xpath("//input[@type='submit']")).click();
																		alert = driver.switchTo().alert();
																		String alerttxt3 = alert.getText();
																		System.out.println(alerttxt3);
																		alert.accept();	
								//toDate
																		WebElement todatefield = driver.findElement(By.xpath("//input[@id='toDate']"));
																		todatefield.sendKeys("09/23/2018 6:20 PM");
																		driver.findElement(By.xpath("//input[@type='submit']")).click();
																		datefield.clear();
																		todatefield.clear();
																		System.out.println("Final submit success");
																	//	driver.navigate().refresh();
																		//select.deselectByIndex(k);
																	 
															}	
											System.out.println("Control is here after dueUE");
											
			}
								System.out.println("Control is here after app");													
						
			}
	}
	

}
