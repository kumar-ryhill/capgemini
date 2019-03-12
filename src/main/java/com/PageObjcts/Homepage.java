package com.PageObjcts;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.capgi.Driver.Tests;

public class Homepage extends BaseTest {

	@FindBy(id = "twotabsearchtextbox")
	private WebElement enterItem;

	@FindBy(xpath = "//*[@id='nav-search']/form/div[2]/div/input")
	private WebElement search;

	@FindBy(xpath = "//li[@id='result_0']//img[contains(@class,'s-access-image cfMarker')]")
	private WebElement selectItem;
	
	@FindBy(id="add-to-cart-button") 
	private WebElement addtocart;

	public Homepage(WebDriver driver, Tests tests) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void ItemName() {
		enterItem.sendKeys("phone");
	}

	public void searchItem() {
		click(search);
		
	}

	public void selectItems() {
		WaitAndForceClickElement(selectItem);
	}

	public void moveToPDPPage() {
		
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> itr = windows.iterator();
		String parent = itr.next();
		String child = itr.next();
		driver.switchTo().window(child);
	}
	
	public void clickOnAddToCart() throws InterruptedException
	{
		Thread.sleep(3000);
		click(addtocart);
			}

}
