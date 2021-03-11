package com.inetbanking.testcases;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import com.inetbanking.pageobjects.LoginPage;
import com.inetbanking.pageobjects.LogoutPage;
import com.inetbanking.pageobjects.NewCustomerPage;

public class TC_NewCustTest_003 extends BaseTest{
	
	@Test
	public void login() {
		lp = new LoginPage(driver);
		lp.login(username, password);
		logger.info("Login successful for  username -" +username+ " & password -" +password);
		
	}
	
	@Test(dependsOnMethods="login")
	public void addCust() {
		nc = new NewCustomerPage(driver);
		nc.addNewCustBtn("raja");
		logger.info("Entered Cust Name");
		nc.genderTxt("male");
		logger.info("Selected gender");
		nc.dobTxt(15, 06, 2000);
		logger.info("Entered Cust DOB");
		nc.custAddressTxt("Near Yu", "Banglore", "KA", rndPin);
		logger.info("Entered Cust Address");
		nc.phoneTxt(rndPhone);
		logger.info("Entered Cust Phone number");
		String rndEmail = RandomStringUtils.randomAlphabetic(9).toLowerCase().concat("@gmail.com");
		nc.emailTxt(rndEmail);
		logger.info("Entered Cust Email Id");
		nc.pwdTxt(rndPwd);
		logger.info("Created Cust Password");
		
		if(nc.succTxt()==true) {
			logger.info("Customer added");
			logger.info(nc.cidTxt());
			
		} else {
			logger.info("Customer not added");
		}
		
		if(nc.homeTxt()==true) {
			logger.info("Home Link Button Displayed in New Cust Page");
		} else {
			logger.info("Home Link Button not Displayed in New Cust Page");
		}
		
	}
	
	@Test(dependsOnMethods= {"login", "addCust"})
	public void logout() {
		lo = new LogoutPage(driver);
		lo.logoutBtn();
		logger.info("Logout Successfull");
	}
}
