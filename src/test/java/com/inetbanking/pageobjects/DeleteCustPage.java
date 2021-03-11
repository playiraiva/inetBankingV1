package com.inetbanking.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class DeleteCustPage extends BasePage {
	
	public DeleteCustPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(how=How.LINK_TEXT, using="Delete Customer") private WebElement deleteCustLink;
	@FindBy(how=How.XPATH, using="//p[text()='Delete Customer Form']") private WebElement deleteCustTxt;
	@FindBy(how=How.NAME, using="cusid") private WebElement cidTxt;
	@FindBy(how=How.NAME, using="AccSubmit") private WebElement deleteSubBtn;
	
	public WebElement getDeleteCustLink() {
		return deleteCustLink;
	}
	public WebElement getDeleteCustTxt() {
		return deleteCustTxt;
	}
	public WebElement getCidTxt() {
		return cidTxt;
	}
	public WebElement getDeleteSubBtn() {
		return deleteSubBtn;
	}
	
	public boolean deleteCustLink() {
		getDeleteCustLink().click();
		return getDeleteCustTxt().isDisplayed();
	}
	
	public void cidTxt(String cid) {
		getCidTxt().sendKeys(cid);
		getDeleteSubBtn().click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.switchTo().alert().accept();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.switchTo().alert().accept();
	}

}
