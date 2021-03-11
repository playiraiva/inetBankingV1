package com.inetbanking.testcases;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pageobjects.LoginPage;
import com.inetbanking.pageobjects.LogoutPage;
import com.inetbanking.utilities.ExcelLibrary;

public class TC_LoginTest_002 extends BaseTest{

	public Alert alert;
	
	public boolean isAlertPresent() {
		try {
			alert = driver.switchTo().alert();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	String XL_Path = "./resources/inetBankingV1.xlsx";
	
	@DataProvider(name="LoginData")
	public String[][] getData(){
			return ExcelLibrary.getMultipleDataInString(XL_Path, "LoginData");
		}
	
	@Test(dataProvider = "LoginData")
	public void login(String username, String password) {
		lp = new LoginPage(driver);
		lp.login(username, password);
		
		if(isAlertPresent()==true) {
			logger.info("Login failed");
			alert.accept();
			driver.switchTo().defaultContent();
			Assert.fail("Wrong username or password");
		} else {
			logger.info("Login Successfull");
			lo = new LogoutPage(driver);
			lo.logoutBtn();
			logger.info("Logout Successfull");
		}
	}
	
}
