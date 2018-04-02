package com.logicinvoice.pompages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.logicinvoice.generics.Utility;
public class CustomersPage extends Utility {
	@FindBy(id="input-status")
	WebElement statusLB;
	public CustomersPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	public void setCustomerStatus(String status){
		selectByVisibleText(statusLB, status);
	}

}
