package com.inetbanking.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LogoutPage extends BasePage{
	
	public LogoutPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(how=How.LINK_TEXT, using="Log out") private WebElement logoutLink;

	public WebElement getLogoutLink() {
		return logoutLink;
	}
	
	public void logoutBtn() {
		getLogoutLink().click();
		driver.switchTo().alert().accept();
	}

}
