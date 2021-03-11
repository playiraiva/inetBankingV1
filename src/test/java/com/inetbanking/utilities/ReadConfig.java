package com.inetbanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties pro;
	
		public ReadConfig() {
			try {
				File file = new File("./resources/config.properties");
				FileInputStream fis = new FileInputStream(file);
				pro = new Properties();
				pro.load(fis);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		public String appURL() {
			String appURL = pro.getProperty("baseURL");
			return appURL;
		}
		
		public String username() {
			String username = pro.getProperty("username");
			return username;
		}
		
		public String password() {
			String password = pro.getProperty("password");
			return password;
		}
		
		public String chromepath() {
			String chromepath = pro.getProperty("chromepath");
			return chromepath;
		}
		
		public String geckopath() {
			String geckopath = pro.getProperty("geckopath");
			return geckopath;
		}
		
		public String iepath() {
			String iepath = pro.getProperty("iepath");
			return iepath;
		}
		
		public String edgepath() {
			String edgepath = pro.getProperty("edgepath");
			return edgepath;
		}
		
		public String operapath() {
			String operapath = pro.getProperty("operapath");
			return operapath;
		}
		
}
