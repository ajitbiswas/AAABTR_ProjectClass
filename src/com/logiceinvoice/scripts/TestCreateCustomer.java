package com.logiceinvoice.scripts;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.logicinvoice.generics.BaseTest;
import com.logicinvoice.generics.Utility;
import com.logicinvoice.pompages.CustomersPage;
import com.logicinvoice.pompages.DashboardPage;

public class TestCreateCustomer extends BaseTest{
	
	static Logger log = LogManager.getLogger(TestCreateCustomer.class.getName());
	@Test
	public void testCreateCustomer(){
		//CTRl + 1 +ENTER
		log.debug("Creating an object of DashboardPage pom class");
		DashboardPage d = new DashboardPage(driver);
		log.info(" DashboardPage class Object created successfully");
		//Mouse on $ menu
		log.debug("Mouse hover on Dollar menu");
		d.mouseHoverOnDollarMenu(driver);
		log.info("successfully mouse hover");
		//Cick on Customer menu
		log.debug("click on Customer menu");
		d.clickOnCustomersMenu();
		log.info("clicked on Customers succesfully");
		//click on Add button present on Customers Page
		CustomersPage c = new CustomersPage(driver);
		int rowCount = Utility.getRowCount("CustomerDetails");
		for (int i = 1; i <=rowCount; i++) {
			c.clickCustAdd();
			String fn = Utility.getCellValue("CustomerDetails", i, 0);
			String ln = Utility.getCellValue("CustomerDetails", i, 1);
			String cn = Utility.getCellValue("CustomerDetails", i, 2);
			String website = Utility.getCellValue("CustomerDetails", i, 3);
			String email = Utility.getCellValue("CustomerDetails", i, 4);
			String pwd = Utility.getCellValue("CustomerDetails", i, 5);
			String confpwd = Utility.getCellValue("CustomerDetails", i, 6);
			String status = Utility.getCellValue("CustomerDetails", i, 7);
			c.setFirstName(fn);
			c.setLastName(ln);
			c.setCompanyName(cn);
			c.setWebsite(website);
			c.setEmail(email);
			c.setPassword(pwd);
			c.setConfirmPassword(confpwd);
			c.setCustomerStatus(status);
			c.clickCustSave();
			Assert.fail();
		}
	}
}
