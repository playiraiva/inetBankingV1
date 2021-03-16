package com.inetbanking.utilities;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot implements IConstants{

	public static String getImage(WebDriver driver, String testCaseName) {
		String filePath = IConstants.sshotPath+testCaseName+".png";
		System.out.println(filePath +"====Screenshot");
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		
		File tempFile = ts.getScreenshotAs(OutputType.FILE);		
		File destFile = new File(filePath);
		try {
			FileUtils.copyFile(tempFile, destFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return filePath;
	}

}
