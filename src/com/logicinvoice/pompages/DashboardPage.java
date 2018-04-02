package com.logicinvoice.pompages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.logicinvoice.generics.Utility;
public class DashboardPage extends Utility{
	@FindBy(xpath="//a[@aria-expanded='false']")
	WebElement loggedInUser;
	
	@FindBy(xpath="//a[contains(text(),'Logout')]")
	WebElement logoutBtn;
	
	@FindBy(xpath="//i[contains(@class,'usd')]")
	WebElement dollarMenu;
	
	@FindBy(xpath="//span[text()='Customers']")
	WebElement CustomersMenu;
	
	public DashboardPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	public void clickOnLoggedInUser(){
		loggedInUser.click();
	}
	public void clickOnLogout(){
		logoutBtn.click();
	}
	public void mouseHoverOnDollarMenu(WebDriver driver){
		mouseHover(driver, dollarMenu);
	}
	public void clickOnCustomersMenu(){
		CustomersMenu.click();
	}
	
}
