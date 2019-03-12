package com.capgi.Driver;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.PageObjcts.Homepage;
import com.PageObjcts.Selenium;
import com.PageObjcts.WebDriverFactory;

public class Tests extends WebDriverFactory
{ 	
	WebDriver driver;
	@Parameters({"browser"})
	
	@Test
	public void execute(String browser) throws InterruptedException
	{
		 driver= setup(browser);
		 
		/* Homepage page = new Homepage(driver,this);
		 page.ItemName();
		 page.searchItem();
		 page.selectItems();
		 page.moveToPDPPage();
		 page.clickOnAddToCart();*/
		 
		 Selenium sel = new Selenium(driver);
		 //sel.basicauth();
		 //sel.challengedom();
		 //sel.checkboxes();
		 //sel.disappearingelements();
		 
		sel.Context_Menu();
			
	}

}
