package com.inetbanking.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.RandomStringUtils;

public interface IConstants {
	
	String log4j = "./resources/Log4j.properties";
	String XL_Path = "./resources/inetBankingV1.xlsx";
	String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm").format(new Date());
	String sshotPath = "./screenshots/"+timeStamp;
	String rndPwd = RandomStringUtils.randomNumeric(5);
	String rndPin = RandomStringUtils.randomNumeric(6);
	String rndPhone = RandomStringUtils.randomNumeric(10);

}
