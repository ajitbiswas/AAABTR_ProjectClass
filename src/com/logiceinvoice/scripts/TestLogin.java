package com.logiceinvoice.scripts;
import org.testng.annotations.Test;

import com.logicinvoice.generics.BaseTest;
import com.logicinvoice.pompages.LoginPage;
public class TestLogin extends BaseTest {
	@Test
	public void testLogin(){
		//enter username
		LoginPage lp = new LoginPage(driver);
		lp.setUsername("admin");
		//enter password
		lp.setPassword("123456");
		//click on login button
		lp.clickLogin();
	}
}
