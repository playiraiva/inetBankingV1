package com.inetbanking.testcases;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetbanking.pageobjects.DeleteCustPage;
import com.inetbanking.pageobjects.EditCustPage;
import com.inetbanking.pageobjects.LoginPage;
import com.inetbanking.pageobjects.LogoutPage;
import com.inetbanking.pageobjects.NewCustomerPage;
import com.inetbanking.utilities.IConstants;
import com.inetbanking.utilities.ReadConfig;
import com.inetbanking.utilities.Screenshot;

public class BaseTest implements IConstants {

	public WebDriver driver;
	public Logger logger;
	ReadConfig readconfig = new ReadConfig();
	LoginPage lp;
	NewCustomerPage nc;
	EditCustPage ec;
	DeleteCustPage dc;
	LogoutPage lo;
	protected String baseURL = readconfig.appURL();
	protected String username = readconfig.username();
	protected String password = readconfig.password();

	@Parameters("browser")
	@BeforeClass
	public void setup(String br) {

		logger = LogManager.getLogger(TC_LoginTest_001.class);
		PropertyConfigurator.configure(log4j);

		switch (br) {
		case "edge":
			System.setProperty("webdriver.edge.driver", readconfig.edgepath());
			driver = new EdgeDriver();
			logger.info("Url opened on edge Browser");
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver", readconfig.geckopath());
			driver = new FirefoxDriver();
			logger.info("Url opened on firefox Browser");
			break;
		case "ie":
			System.setProperty("webdriver.ie.driver", readconfig.iepath());
			driver = new InternetExplorerDriver();
			logger.info("Url opened on internetexplorer Browser");
			break;
		case "opera":
			System.setProperty("webdriver.opera.driver", readconfig.operapath());
			driver = new OperaDriver();
			logger.info("Url opened on opera Browser");
			break;
		default:
			System.setProperty("webdriver.chrome.driver", readconfig.chromepath());
			driver = new ChromeDriver();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			logger.info("Url opened on Chrome Browser");
			break;
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(baseURL);
	}

	@AfterMethod(alwaysRun = true)
	public void endResult(ITestResult result) {
		String testCaseName = result.getName();
		int status = result.getStatus();
		if (status == ITestResult.FAILURE) {
			String screenshotPath = Screenshot.getImage(driver, testCaseName);
			logger.info(screenshotPath);
		}
	}

	
	  @AfterClass public void teardown() { 
	  try {
		Thread.sleep(3000);
	  } catch (InterruptedException e) {
		e.printStackTrace();
	  }
	  driver.manage().deleteAllCookies(); 
	  driver.close(); 
	  driver.quit();
	  logger.info("window closed"); }
	 
}