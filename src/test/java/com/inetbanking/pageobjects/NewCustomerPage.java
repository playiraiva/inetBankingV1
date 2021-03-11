package com.inetbanking.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class NewCustomerPage extends BasePage{
	
	public NewCustomerPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(how=How.LINK_TEXT, using="New Customer")
	private WebElement newCustomerLink;
	
	@FindBy(how=How.NAME, using="name") private WebElement custNameTxt;
	
	@FindBy(how=How.XPATH, using="//input[@name='rad1' and @value='m']")
	private WebElement genderMaleRadBtn;
	
	@FindBy(how=How.XPATH, using="//input[@name='rad1' and @value='f']")
	private WebElement genderFemaleRadBtn;
	
	@FindBy(how=How.NAME, using="dob") private WebElement dobTxt;
	
	@FindBy(how=How.NAME, using="addr") private WebElement addrTxt;
	
	@FindBy(how=How.NAME, using="city") private WebElement cityTxt;
	
	@FindBy(how=How.NAME, using="state") private WebElement stateTxt;
	
	@FindBy(how=How.NAME, using="pinno") private WebElement pinnoTxt;
	
	@FindBy(how=How.NAME, using="telephoneno") private WebElement mobileNoTxt;
	
	@FindBy(how=How.NAME, using="emailid") private WebElement emailidTxt;
	
	@FindBy(how=How.NAME, using="password") private WebElement pwdTxt;
	
	@FindBy(how=How.NAME, using="sub") private WebElement subBtn;
	
	@FindBy(how=How.XPATH, using="//a[text()='Home']") private WebElement homeBtn;
	
	@FindBy(how=How.XPATH, using="//p[contains(text(),'Successfully!!!')]") private WebElement succTxt;
	
	@FindBy(how=How.XPATH, using="//td[text()='Customer ID']/following-sibling::td") private WebElement Cid;

	public WebElement getNewCustomerLink() {
		return newCustomerLink;
	}

	public WebElement getCustNameTxt() {
		return custNameTxt;
	}

	public WebElement getGenderMaleRadBtn() {
		return genderMaleRadBtn;
	}

	public WebElement getGenderFemaleRadBtn() {
		return genderFemaleRadBtn;
	}
	
	public WebElement getDobTxt() {
		return dobTxt;
	}

	public WebElement getAddrTxt() {
		return addrTxt;
	}

	public WebElement getCityTxt() {
		return cityTxt;
	}

	public WebElement getStateTxt() {
		return stateTxt;
	}

	public WebElement getPinnoTxt() {
		return pinnoTxt;
	}

	public WebElement getMobileNoTxt() {
		return mobileNoTxt;
	}
	
	public WebElement getEmailidTxt() {
		return emailidTxt;
	}
	
	public WebElement getPwdTxt() {
		return pwdTxt;
	}

	public WebElement getSubBtn() {
		return subBtn;
	}

	public WebElement getSuccTxt() {
		return succTxt;
	}
	
	public WebElement getHomeBtn() {
		return homeBtn;
	}
		
	public WebElement getCid() {
		return Cid;
	}

	public void addNewCustBtn(String custName) {
		getNewCustomerLink().click();
		getCustNameTxt().sendKeys(custName);
	}
	
	public void genderTxt(String gender) {
		if(gender=="male") {
			getGenderMaleRadBtn().click();
		} else {
			getGenderFemaleRadBtn().click();
		}
	}
	
	public void dobTxt(int dd, int mm, int yyyy) {
		getDobTxt().sendKeys(String.valueOf(dd));
		getDobTxt().sendKeys(String.valueOf(mm));
		getDobTxt().sendKeys(String.valueOf(yyyy));
	}
	
	public void custAddressTxt(String add, String city, String state, String pin) {
		getAddrTxt().sendKeys(add);
		getCityTxt().sendKeys(city);
		getStateTxt().sendKeys(state);
		getPinnoTxt().sendKeys(String.valueOf(pin));
	}
	
	public void phoneTxt(String phone) {
		getMobileNoTxt().sendKeys(String.valueOf(phone));
	}
	
	public void emailTxt(String email) {
		getEmailidTxt().sendKeys(email);
	}
	
	public void pwdTxt(String pwd) {
		getPwdTxt().sendKeys(pwd);
		getSubBtn().click();
	}
	
	public boolean succTxt() {
		return getSuccTxt().isDisplayed();
	}
	
	public String cidTxt() {
		return getCid().getText();
	}
	
	public boolean homeTxt() {
		return getHomeBtn().isDisplayed();
	}
}
