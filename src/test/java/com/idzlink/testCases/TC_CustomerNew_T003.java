package com.idzlink.testCases;

import java.io.IOException;
import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.idzlink.pageObjects.CustomerPage;
import com.idzlink.pageObjects.Homepage;
import com.idzlink.pageObjects.LoginPage;
import com.idzlink.utilities.Retry;

public class TC_CustomerNew_T003 extends BaseClass {

	
	@Test(retryAnalyzer=Retry.class)
	public void addnewcustomer() throws InterruptedException, IOException
	{
		intilization();
		
		Homepage hp=new Homepage(driver);
		hp.Startbutton();
		
		hp.Setupclick();
	
		CustomerPage cp=new CustomerPage(driver);
		cp.Customermaster();
		logger.info("Customer Master Opened");
		
		driver.switchTo().frame("frame1");
		
		cp.Customercategory("General"); // general
		logger.info("Customer General Entered");
		
		String customername=randomeString();
		cp.setCustomerName(customername); // customer name
		logger.info("Customer Name Entered");
		
		Thread.sleep(2000);
		
		cp.CustomerCountry(5); // country
		logger.info("Customer Country Selected");
		
		cp.CustomerCity(1);
		logger.info("Customer City Selected");
		
		cp.CustomerCurrency(1);
		logger.info("Customer Currency Selected");
		
		cp.CustomerGroup(1);
		logger.info("Customer Group Selected");
		
		cp.CustomerDebtoracc(1);
		
		
		String email=randomeString()+"@gmaiil.com";
		
		cp.setCustomerEmail(email);
		
		cp.Customersave();
			
		if(isAlertPresentWithSuccessMessage()==true)
		{
			driver.switchTo().alert().accept(); //close alert
			driver.switchTo().defaultContent();
			Assert.assertTrue(true);
			
		}
		
		else
		{
			captureScreen(driver,"addnewcustomer");
			Assert.assertTrue(false);
			logger.warn("Customer creation  Failed");
		}
		
			
	}

}
