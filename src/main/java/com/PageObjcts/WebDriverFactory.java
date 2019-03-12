package com.PageObjcts;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

public class WebDriverFactory 
{
	ChromeOptions options;
	DesiredCapabilities cap;
	WebDriver driver;
	String mobileEmulation = "true";
	
	
	public WebDriver setup(@Optional ("chrome")String browser)
	{
		if(browser.equalsIgnoreCase("chrome"))
		{
			String chromepath="src"+File.separator+"resource"+File.separator+"chromedriver.exe";
			
			//String chromepath="C:\\Users\\kmarrire\\Documents\\workspace1\\Driver\\src\\resource\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", chromepath);
			 options=new ChromeOptions();
			 options.setExperimentalOption("useAutomationExtension", false);
			 options.addArguments("start-maximized");
			 cap = DesiredCapabilities.chrome();
			 cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS,true);	
		}else
		{
			Map<String, String> mobileEmu = new HashMap<String, String>();
			mobileEmu.put("deviceName", "Nexus 5");
			Map<String, Object> chromeOptions = new HashMap<String, Object>();
			chromeOptions.put("mobileEmulation", mobileEmu);
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			
			capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
			
		//	System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY,
			//		System.getProperty("user.dir") + "/target/chromedriver.log");

			
		
		}
		driver= new ChromeDriver(cap);
		 driver.manage().window().maximize();
		 driver.get("https://the-internet.herokuapp.com");
		
		
		
		 return driver;
	}
	 
	
}

		
		
		
	


