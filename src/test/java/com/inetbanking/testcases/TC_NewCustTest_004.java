package com.inetbanking.testcases;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pageobjects.LoginPage;
import com.inetbanking.pageobjects.LogoutPage;
import com.inetbanking.pageobjects.NewCustomerPage;
import com.inetbanking.utilities.ExcelLibrary;

public class TC_NewCustTest_004 extends BaseTest {
	
	@Test
	public void login() {
		lp = new LoginPage(driver);
		lp.login(username, password);
		logger.info("Login successful for  username -" +username+ " & password -" +password);
		
	}

	@Test(dataProvider="NewCustData", dependsOnMethods="login")
	public void addCust(String custName, String gender, String add, String city, String state) {
		nc = new NewCustomerPage(driver);
		nc.addNewCustBtn(custName);
		logger.info("Entered Cust Name");
		nc.genderTxt(gender);
		logger.info("Selected gender");
		nc.dobTxt(15, 06, 2000);
		logger.info("Entered Cust DOB");
		nc.custAddressTxt(add, city, state, rndPin);
		logger.info("Entered Cust Address");
		nc.phoneTxt(rndPhone);
		logger.info("Entered Cust Phone number");
		String rndEmail = RandomStringUtils.randomAlphabetic(9).toLowerCase().concat("@gmail.com");
		nc.emailTxt(rndEmail);
		logger.info("Entered Cust Email Id");
		nc.pwdTxt(rndPwd);
		logger.info("Created Cust Password");
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		if(nc.succTxt()==true) {
			logger.info("Customer added");
			
			if(nc.homeTxt()==true) {
				logger.info("Home Link Button Displayed in New Cust Page");
				nc.getHomeBtn().click();
			} else {
				logger.info("Home Link Button not Displayed in New Cust Page");
			}
		} else {
			logger.info("Customer not added");
		}
		
	}
	
	@DataProvider(name="NewCustData")
	public String[][] getData(){
			return ExcelLibrary.getMultipleDataInString(XL_Path, "NewCustData");
		}
	
	@Test(dependsOnMethods= {"login", "addCust"})
	public void logout() {
		lo = new LogoutPage(driver);
		lo.logoutBtn();
		logger.info("Logout Successfull");
	}

}
