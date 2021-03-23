package com.inetbanking.utilities;

import java.io.FileReader;
import java.util.Properties;

//Listener class used to generate Extent reports

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport extends TestListenerAdapter implements IConstants
{
	public static WebDriver driver;
	private ExtentSparkReporter sparkReporter; // used to add report loc
	private ExtentReports extent; // used to add info in reports
	private ExtentTest logger; // used to add pass, fail & skip info in reports
		
	public void onStart(ITestContext testContext)
	{
		String repName="Test-Report.html";
		
		sparkReporter=new ExtentSparkReporter("./test-output/Execution-report/"+repName); //specify location of the report
		
		extent=new ExtentReports();
        
		extent.attachReporter(sparkReporter);
		extent.setReportUsesManualConfiguration(true);
		extent.setSystemInfo("Host name","localhost");
		extent.setSystemInfo("Environemnt","QA");
		extent.setSystemInfo("user","vinayak");
		
		sparkReporter.config().setDocumentTitle("InetBankingV1 Test Project"); // Title of report
		sparkReporter.config().setReportName("Test Automation Report"); // name of the report
		sparkReporter.config().setTheme(Theme.DARK);
	}
	
	public void onTestSuccess(ITestResult tr)
	{
		logger=extent.createTest(tr.getName()); // create new entry in the report
		logger.log(Status.PASS,MarkupHelper.createLabel(tr.getName(),ExtentColor.GREEN)); // send the passed information to the report with GREEN color highlighted
		
	}
	
	public String readProperties(String name) {
		String fName = null;
      try {
    	  FileReader reader=new FileReader("./resources/test.properties");
          Properties pro=new Properties();
          pro.load(reader);
          fName = pro.getProperty(name);
          return    pro.getProperty(name);
	} catch (Exception e) {
		e.printStackTrace();
	}
      return fName;
	}
	
	public void onTestFailure(ITestResult result)
	{
		logger=extent.createTest(result.getName()); // create new entry in the report
		logger.log(Status.FAIL,MarkupHelper.createLabel(result.getName(),ExtentColor.RED)); // send the passed information to the report with GREEN color highlighted
		
		String testCaseName = result.getName();
		String filePath = null;
		if (readProperties("env").equalsIgnoreCase("local")) {
			filePath = readProperties("localReportPath")+IConstants.timeStamp+testCaseName+".png";
		} 
		else if (readProperties("env").equalsIgnoreCase("remoteWar")) {
			filePath = readProperties("remoteWarReportPath")+IConstants.timeStamp+testCaseName+".png";
		} 
		else
		{
			filePath = readProperties("remoteExeReportPath")+IConstants.timeStamp+testCaseName+".png";
		}
	
		try {
			logger.fail("Please find Screenshot:" + logger.addScreenCaptureFromPath(filePath));
			} 
		catch (Exception e) 
				{
				e.printStackTrace();
				}
	}
		
	
	public void onTestSkipped(ITestResult tr)
	{
		logger=extent.createTest(tr.getName()); // create new entry in the report
		logger.log(Status.SKIP,MarkupHelper.createLabel(tr.getName(),ExtentColor.ORANGE));// send the skipped information to the report with ORANGE color highlighted
	}
	
	public void onFinish(ITestContext testContext)
	{
		extent.flush();
	}
	
}
