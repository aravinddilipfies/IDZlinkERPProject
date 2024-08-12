package com.idzlink.testCases;

import java.io.IOException;
import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.idzlink.pageObjects.Homepage;
import com.idzlink.pageObjects.LoginPage;
import com.idzlink.pageObjects.SupplierPage;
import com.idzlink.utilities.JavaScriptsUtil;

public class TC_SupplierNew_T005 extends BaseClass {

	private static final String JavaScriptUtil = null;
	@Test
	public void addnewsupplier() throws InterruptedException, IOException
	{
		intilization();
		
		System.out.println("opened ");
		
		Homepage hp=new Homepage(driver);
		hp.Startbutton();
	//	Thread.sleep(3000);
		hp.Setupclick();
		
	//	Thread.sleep(3000);
		SupplierPage sp=new SupplierPage(driver);
		sp.Suppliermaster();
		
		driver.switchTo().frame("frame1");
		
		Thread.sleep(2000);
		sp.SupplierGroup(1); // general
		
	//	Thread.sleep(2000);
		String supplierrname=randomeString();
		sp.setsupplierName(supplierrname); // customer name
		
		
		//Thread.sleep(3000);
		sp.SupplierCountry(5); // country
	//	Thread.sleep(2000);
		sp.SupplierCurrency(1); // currency
	//	Thread.sleep(2000);
		sp.SupplierCity(1);		//city
	//	Thread.sleep(2000);
		
		sp.SuppliercreditAC(1);
		JavascriptExecutor js=(JavascriptExecutor) driver;
		JavaScriptsUtil.scrollPageDown(driver);
		
	//	Thread.sleep(2000);
		
		
		sp.SupplierShop();
		
	//	Thread.sleep(2000);
		
		System.out.println("shop selected");
		
		sp.SupplierSubmit();
		
		
		
	//	Thread.sleep(2000);
		
		if(isAlertPresentWithSuccessMessage()==true)
		{
			driver.switchTo().alert().accept(); //close alert
			driver.switchTo().defaultContent();
			Assert.assertTrue(true);
			
		}
		
		else
		{
			captureScreen(driver,"addnewsupplier");
			Assert.assertTrue(false);
			logger.warn("Customer creation  Failed");
		}
		
			
	}
	public boolean isAlertPresent() //user defined method created to check alert present or not
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		try
		{
			wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert();
		return true;
		}
		catch(NoAlertPresentException e)
		{
			return false;
		}
	}
}
