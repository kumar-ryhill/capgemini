package com.PageObjcts;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WebDriver_Manager 
{
	private WebDriver driver;
	
	@BeforeClass
	protected static void setUp()
	{
		WebDriverManager.chromedriver().setup();
	}
	
	
	@Before
	protected void driverlaunch()
	{
		driver =  new ChromeDriver();
	}
	
	@Test
	protected void launchUrl()
	{
		driver.get("http://www.google.com");
	}
	
	@AfterTest
	protected void close()
	{
		if(driver!=null)
		{
			driver.close();
		}
	}
	

}
