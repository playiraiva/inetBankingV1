 package com.inetbanking.testcases;

import org.testng.annotations.Test;

import com.inetbanking.pageobjects.LoginPage;
import com.inetbanking.pageobjects.LogoutPage;

public class TC_LoginTest_001 extends BaseTest{
	@Test
	public void login() {
	lp = new LoginPage(driver);
	lp.login(username, password);
	
	logger.info("Login Successfull for username - " +username+" & password - "+password);
	}
	
	@Test(dependsOnMethods="login")
	public void logout() {
		lo = new LogoutPage(driver);
		lo.logoutBtn();
		logger.info("Logout Successfull");
	}
	
}
