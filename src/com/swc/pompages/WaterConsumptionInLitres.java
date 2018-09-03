package com.swc.pompages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class WaterConsumptionInLitres {
	
	@FindBy(id="orgid")
	private WebElement OrganizationdropDownList;
	

	
	public void ClickOnOrganization() {
		OrganizationdropDownList.click();
		Select s = new Select(OrganizationdropDownList);
		s.selectByIndex(1);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	public boolean isAlertPresent() {
		try {
            final Alert alert = this.driver.switchTo().alert();
            alert.getText();
		} catch (final NoAlertPresentException nape) {
			return false;
		}
		return true;
	}

	public String getAlertText() {
        final Alert alert = this.driver.switchTo().alert();
        return alert.getText();
	}

	public void acceptAlert() {
        final Alert alert = this.driver.switchTo().alert();
        alert.accept();
	}

	public void dismissAlert() {
        final Alert alert = this.driver.switchTo().alert();
        alert.dismiss();
	}*/
	
	
	
	
	
}
