package com.PageObjcts;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTest 
{
	WebDriver driver;
	Actions action;
	BaseTest(WebDriver driver) {
		this.driver=driver;
		action = new Actions(driver);
	}

	public void click(WebElement element)
	{
		elementHighlight(element);
		element.click();
	}
	
	public void elementHighlight(WebElement element) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='2px solid red'", element);
		js.executeScript("arguments[0].style.border=''", element);
	}
	
	@SuppressWarnings("unchecked")
	public void WaitAndForceClickElement(WebElement element)
	{
		try{
		@SuppressWarnings("rawtypes")
		Wait wait = new WebDriverWait(driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		action.moveToElement(element);
		action.click();
		action.build().perform();
		}catch(Exception e){
			System.out.println(e.getMessage());
			Assert.fail("Fail to click the Element");
			
		}
		
	}
	
	public void moveToElemet(WebElement element)
	{
		
		Actions action = new Actions(driver);
		action.moveToElement(element).contextClick();
		
	}
	

	
	
	
	
}
