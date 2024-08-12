package com.idzlink.testCases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

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

public class TC_CustomerEdit_T004 extends BaseClass {

	
	@Test(retryAnalyzer=Retry.class)
	public void editcustomer() throws InterruptedException, IOException
	{

		intilization();
		
		
		Homepage hp=new Homepage(driver);
		hp.Startbutton();
		
		hp.Setupclick();
		
		
		CustomerPage cp=new CustomerPage(driver);
		cp.Customermaster();
		
		driver.switchTo().frame("frame1");
		
		cp.Customercategory("General"); // general
		
		String customername=randomeString();
		cp.setCustomerName(customername); // customer name
		
		Thread.sleep(2000);
		cp.CustomerCountry(5); // country
		
		cp.CustomerCity(1);
		
		cp.CustomerCurrency(1);
		
		cp.CustomerGroup(1);
		
		cp.CustomerDebtoracc(1);
		
		
		String email=customername+"@gmaiil.com";
		
		cp.setCustomerEmail(email);
		
		cp.Customersave();
		
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.alertIsPresent());
		
			driver.switchTo().alert().accept(); //close alert
			driver.switchTo().defaultContent();
			
			driver.switchTo().frame("frame1");
			
			
			cp.Customerserachicon();
			
			cp.Customersearch(customername);
			Thread.sleep(1000);
			cp.Customerserachbtn();
		
			cp.CustomerEditicon();
			
			
			Thread.sleep(2000);
			String editcustomer=cp.getCustomerName();
			logger.info("Customer master opened in edit mode");
			System.out.println(editcustomer);
			
			if(customername.equals(editcustomer))
			{
				Assert.assertTrue(true);
				logger.info("Entered customer matched");
				
			}
			
			else
			{
				captureScreen(driver,"editcustomer");
				Assert.assertTrue(false);
				logger.info("Entered customer missmatched");
				System.out.println("failed innnnn");
			}
			
			
	
		
			
	}
	
}
