package com.PageObjcts;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;



public class Mobile {
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		//String chromepath = "src" + File.separator + "resource"+ File.separator + "chromedriver.exe";

		 
		String chromeExe = "C:\\Users\\kmarrire\\Documents\\workspace1\\Driver\\src\\resource\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromeExe);

		Map<String,Object> mobileEmulation = new HashMap<String,Object>();

		mobileEmulation.put("deviceName", "Nexus 5");

		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
		chromeOptions.addArguments("--disable-extensions--");

		WebDriver driver = new ChromeDriver(chromeOptions);
		driver.get("https://www.amazon.in/");
		
/*		Map<String, Object> deviceMetrics = new HashMap<>();

		deviceMetrics.put("width", 360);

		deviceMetrics.put("height", 640);

		deviceMetrics.put("pixelRatio", 3.0);

		Map<String, Object> mobileEmulation = new HashMap<>();

		mobileEmulation.put("deviceMetrics", deviceMetrics);

		mobileEmulation.put("userAgent", "Mozilla/5.0 (Linux; Android 4.2.1; en-us; Nexus 5 Build/JOP40D) AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.166 Mobile Safari/535.19");
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
		WebDriver driver = new ChromeDriver(chromeOptions);
		driver.get("https://vmware--uat.cs25.my.salesforce.com/");*/
		
		
		
		
		
		

		

	}

}
