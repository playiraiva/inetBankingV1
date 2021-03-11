package com.inetbanking.testcases;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import com.inetbanking.pageobjects.EditCustPage;
import com.inetbanking.pageobjects.LoginPage;
import com.inetbanking.pageobjects.LogoutPage;
import com.inetbanking.pageobjects.NewCustomerPage;

public class TC_EditCustTest_005 extends BaseTest{

	String cid;
	
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
			cid = nc.cidTxt();
			logger.info(nc.cidTxt());	
		} else {
			logger.info("Customer not added");
		}
		
		if(nc.homeTxt()==true) {
			logger.info("Home Link Button Displayed in New Cust Page");
			nc.getHomeBtn().click();
			logger.info("Home Page Displayed");
		} else {
			logger.info("Home Link Button not Displayed in New Cust Page");
		}
		
	}
	
	@Test(dependsOnMethods={"login","addCust"})
	public void editCust() {
		ec = new EditCustPage(driver);
		ec.editCustLink();
		logger.info("Clicked on Edit Link");
		ec.cidTxt(cid);
		logger.info("Entered Cust id");
		ec.subBtn();
		logger.info("Clicked on submit button");
		ec.homeBtn();
	}
	
	@Test(dependsOnMethods= {"login","addCust","editCust"})
	public void logout() {
		lo = new LogoutPage(driver);
		lo.logoutBtn();
		logger.info("Logout Successfull");
	}
}
