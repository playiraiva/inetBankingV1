package com.inetbanking.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class EditCustPage extends BasePage{
	
	public EditCustPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(how=How.XPATH, using="//a[text()='Edit Customer']") private WebElement editCustLink;
	@FindBy(how=How.NAME, using="cusid") private WebElement cidTxt;
	@FindBy(how=How.NAME, using="AccSubmit") private WebElement editSubBtn;
	@FindBy(how=How.NAME, using="sub") private WebElement subBtn;
	@FindBy(how=How.XPATH, using="//a[text()='Home']") private WebElement homeBtn;
	
	public WebElement getEditCustLink() {
		return editCustLink;
	}
	public WebElement getCidTxt() {
		return cidTxt;
	}
	public WebElement getEditSubBtn() {
		return editSubBtn;
	}
	public WebElement getSubBtn() {
		return subBtn;
	}
	public WebElement getHomeBtn() {
		return homeBtn;
	}
	public void editCustLink() {
		getEditCustLink().click();
	}
	
	public void cidTxt(String cid) {
		getCidTxt().sendKeys(cid);
		getEditSubBtn().click();
	}
	
	public void subBtn() {
		getSubBtn().click();
		driver.switchTo().alert().accept();
	}
	
	public void homeBtn() {
		getHomeBtn().click();
	}
	
}
