package com.swc.pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.PageFactoryFinder;
import org.openqa.selenium.support.ui.Select;

public class HousingBook {
	
	@FindBy(name="typeId")
	private WebElement Housing_Type;
	
	@FindBy(name="orgid")
	private WebElement orgdropmenu;
	
	@FindBy(name="appid")
	private WebElement Appdropmenu;
	
	@FindBy(name="devid")
	private WebElement devdropmenu;
	
	@FindBy(xpath="//input[@id='fromDate']") 
	private WebElement Fromdate;
	
	
	@FindBy(xpath="//input[@id='toDate']")
	private WebElement Todate;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement submit;
	public HousingBook(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public  void HouseApp(int index) {
	    //  WebEelement ele = driver.findElement("your by selector")
	      Select drop1 = new Select(Housing_Type);
	      drop1.selectByIndex(index);  
	}
	
	public  void AppDropDown(int index) {
	    //  WebEelement ele = driver.findElement("your by selector")
	      Select drop2 = new Select(orgdropmenu);
	      drop2.selectByIndex(index);  
	}
	
	public  void BlockDropDown(int index) {
	    //  WebEelement ele = driver.findElement("your by selector")
	      Select drop3 = new Select(Appdropmenu);
	      drop3.selectByIndex(index);  
	}
	
	public  void WaterDropDown(int index) {
	    //  WebEelement ele = driver.findElement("your by selector")
	      Select drop4 = new Select(devdropmenu);
	      drop4.selectByIndex(index);  
	}
	
	public void FromDate(String date) {
		
		Fromdate.sendKeys(date);
	}
	
public void ToDate(String date) {
		
		Todate.sendKeys(date);
	}
public void Submit()
{
	submit.click();
}

}
