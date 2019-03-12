package com.PageObjcts;

import java.util.List;

import org.apache.velocity.runtime.directive.Foreach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Selenium extends BaseTest {
	@FindBy(xpath = "//*[@id='content']/ul/li[2]/a[contains(text(),'Basic Auth')]")
	private WebElement BasicAuth;

	@FindBy(xpath = "//*[@id='content']/ul/li[3]/a[contains(text(),'Broken Images')]")
	private WebElement images;

	@FindBy(xpath = "//*[@id='content']/ul/li[4]/a[contains(text(),'Challenging DOM')]")
	private WebElement challengedom;

	@FindBy(xpath = "//*[@id='content']/ul/li[5]/a[contains(text(),'Checkboxes')]")
	private WebElement checkboxes;

	@FindBy(xpath = "//*[@id='content']/ul/li[6]/a[contains(text(),'Context Menu')]")
	private WebElement context_menu;

	@FindBy(xpath = "//*[@id='content']/ul/li[7]/a[contains(text(),'Disappearing Elements')]")
	private WebElement disappearing_elements;

	public Selenium(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void basicauth() throws InterruptedException {
		if (BasicAuth != null) {
			// click(BasicAuth);
			// Thread.sleep(3000);
			driver.get("http://kumar:marrireddy@the-internet.herokuapp.com");

		} else
			org.testng.Assert.fail();

	}

	/*
	 * public void challengeDom() { click(images);
	 * 
	 * for(WebElement img:driver.findElements(By.cssSelector("img"))) {
	 * isBroken(img); };
	 * 
	 * }
	 * 
	 * private void isBroken(WebElement img) {
	 * if(img.getAttribute("naturalWidth").equals("0")) {
	 * System.out.println(img.getAttribute("outerHTML")+ "Brokenimage.");
	 * 
	 * }
	 * 
	 * }
	 */

	public void imagesBroken() {
		click(images);
		for (WebElement img : driver.findElements(By.cssSelector("img"))) {
			isImageBroken(img);
		}
	}

	private void isImageBroken(WebElement img) {
		if (img.getAttribute("naturalWidth").equals("0"))
			;
		{
			System.out.println(img.getAttribute("outerHTML") + "Brokenimage"
					+ driver.getCurrentUrl());
		}

	}

	public void challengedom() {
		click(challengedom);
		List<WebElement> elements = driver.findElements(By.tagName("tr")
				.tagName("td"));

		for (WebElement ele : elements) {
			System.out.println(ele.getText());
		}
		System.out.println(elements);

	}

	public void checkboxes() {
		click(checkboxes);
		int CheckBoxes = driver.findElements(
				By.xpath("//*[@id='content']//input")).size();
		System.out.println(CheckBoxes);
		for (int i = 1; i <= CheckBoxes; i++) {
			WebElement checkbox = driver.findElement(By
					.xpath("//*[@id='checkboxes']/input[" + i + "]"));

			if (checkbox.isSelected()) {
				break;
			} else
				checkbox.click();
		}
	}

	public void Context_Menu() {
		click(context_menu);
		moveToElemet(driver.findElement(By
				.xpath("//div[@id='//div[@id='hot-spot']")));

	}

	public void disappearingelements() {
		click(disappearing_elements);

		List<WebElement> listElement = driver.findElements(By
				.xpath("//div[@id='content']//div//ul/li"));
		System.out.println(listElement);

		for (int i = 0; i <= listElement.size(); i++) {
			String text = listElement.get(i).getText();
			if (text.equalsIgnoreCase("gallery")) {
				System.out.println("gallery option present");
				listElement.get(i).click();
			}
			System.out.println(text);

		}

	}
}
