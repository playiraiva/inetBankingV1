package com.inetbanking.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver){
		super(driver);
	}
	
	@CacheLookup
	@FindBy(name="uid") private WebElement userTxtField;
	@FindBy(name="password") private WebElement passTxtField;
	@FindBy(name="btnLogin") private WebElement loginBtn;
	@FindBy(linkText="Log out") private WebElement logoutBtn;

	
	public WebElement getUserTxtField() {
		return userTxtField;
	}
	public WebElement getPassTxtField() {
		return passTxtField;
	}
	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	public WebElement getLogoutBtn() {
		return logoutBtn;
	}
	
	public void login(String uname, String pwd) {
		getUserTxtField().sendKeys(uname);
		getPassTxtField().sendKeys(pwd);
		getLoginBtn().click();
	}
	
}
