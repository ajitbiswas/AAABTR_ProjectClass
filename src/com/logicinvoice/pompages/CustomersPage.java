package com.logicinvoice.pompages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.logicinvoice.generics.Utility;
public class CustomersPage extends Utility {
	
	@FindBy(xpath="//a[@data-original-title='Add']")
	WebElement addBtn;
	@FindBy(id="input-firstname")
	WebElement firstNameTB;
	@FindBy(id="input-lastname")
	WebElement lastNameTB;
	@FindBy(id="input-company")
	WebElement companyNameTB;
	@FindBy(id="input-website")
	WebElement websiteTB;
	@FindBy(id="input-email")
	WebElement emailTB;
	@FindBy(id="input-password")
	WebElement passwordTB;
	@FindBy(id="input-confirm")
	WebElement confirmpasswordTB;
	@FindBy(id="input-status")
	WebElement statusLB;
	@FindBy(xpath="//*[@data-original-title='Save']")
	WebElement saveBtn;
	public CustomersPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	public void clickCustAdd(){
		addBtn.click();
	}
	public void setFirstName(String fn){
		firstNameTB.sendKeys(fn);
	}
	public void setLastName(String ln){
		lastNameTB.sendKeys(ln);
	}
	public void setCompanyName(String cn){
		companyNameTB.sendKeys(cn);
	}
	public void setWebsite(String website){
		websiteTB.sendKeys(website);
	}
	public void setEmail(String email){
		emailTB.sendKeys(email);
	}
	public void setPassword(String pwd){
		passwordTB.sendKeys(pwd);
	}
	public void setConfirmPassword(String confpwd){
		confirmpasswordTB.sendKeys(confpwd);
	}
	public void setCustomerStatus(String status){
		selectByVisibleText(statusLB, status);
	}
	public void clickCustSave(){
		saveBtn.click();
	}
}
