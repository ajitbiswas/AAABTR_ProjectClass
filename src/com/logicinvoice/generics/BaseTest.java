package com.logicinvoice.generics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.logicinvoice.pompages.DashboardPage;
import com.logicinvoice.pompages.LoginPage;
public class BaseTest implements IAutoConstant{
	
	public WebDriver driver ;
	static{
		System.setProperty(GEKCO_KEY, GEKCO_PATH);
		System.setProperty(CHROME_KEY, CHROME_PATH);
	}
	@BeforeMethod
	public void openApplication(){
		driver = new FirefoxDriver();
		String url = Utility.getPropertyValue("URL");
		driver.get(url);
		String ITO = Utility.getPropertyValue("ITO");
		driver.manage().timeouts().implicitlyWait(Long.parseLong(ITO), TimeUnit.SECONDS);
		LoginPage lp = new LoginPage(driver);
		String username = Utility.getPropertyValue("USERNAME");
		lp.setUsername(username);
		//enter password
		String password = Utility.getPropertyValue("PASSWORD");
		lp.setPassword(password);
		//click on login button
		lp.clickLogin();
	}
	@AfterMethod
	public void closeApplication(ITestResult result){
		DashboardPage d = new DashboardPage(driver);
		
		if (ITestResult.FAILURE==result.getStatus()) {
			Utility.takeScreenshot(driver, result.getName());
		}
		
		d.clickOnLoggedInUser();
		d.clickOnLogout();
		driver.close();
	}
}
