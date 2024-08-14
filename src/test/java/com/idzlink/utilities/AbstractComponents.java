package com.idzlink.utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponents {

	protected WebDriver driver;
	WebDriverWait wait;
	static JavascriptExecutor js;
	
	public AbstractComponents(WebDriver driver)
	{
		this.driver=driver;
		//this.wait = new WebDriverWait(driver,Duration.ofSeconds(15));
			
	}
	
	public void waitForWebElementToAppear(WebElement findBy) {

		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(findBy));

	}
	
	public void clickElement(WebElement close) {
        // Wait for the element to be clickable
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(close));
	}
	
	public void waitForElementToBeVisible(WebElement element) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
	public void selectDropdownByIndex(WebElement dropdown, int index) {
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	        wait.until(ExpectedConditions.elementToBeClickable(dropdown));
	        Select select = new Select(dropdown);
	        select.selectByIndex(index);
	    }
	
	public static void scrollPageDown (WebDriver driver)
	{ 
		 js = ((JavascriptExecutor) driver);
	
		js.executeScript ("window.scrollTo(0, document.body.scrollHeight)");
	}
	
	public static void scrolltomiddle (WebDriver driver)
	{
		js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0, document.body.scrollHeight / 4);");
	}
	
	
	public static void scrolltotop(WebDriver driver)
	{
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, 0);");
	}
	
	// Method to scroll to a specific element
    public void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
