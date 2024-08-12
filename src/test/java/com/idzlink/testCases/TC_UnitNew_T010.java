package com.idzlink.testCases;

import java.io.IOException;
import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.idzlink.pageObjects.Homepage;
import com.idzlink.pageObjects.Unit;

public class TC_UnitNew_T010 extends BaseClass {

	@Test
	public void addnewunit() throws InterruptedException, IOException
	{
		intilization();
		Homepage hp=new Homepage(driver);
		hp.Startbutton();
		hp.Setupclick();
		hp.RetailSetupclick();
		hp.itemSetupclick();
		
		Unit ut=new Unit(driver);
		ut.UnitmasterOpen();
		driver.switchTo().frame("frame1");
		String Ucode= randomeNum();
		String Udes =randomeString();
		ut.Unitsave(Ucode, Udes);
		
		if(isAlertPresentWithSuccessMessage()==true)
		{
			driver.switchTo().alert().accept(); //close alert
			driver.switchTo().defaultContent();
			Assert.assertTrue(true);
			
		}
		
		else
		{
			captureScreen(driver,"addnewitemvategory");
			Assert.assertTrue(false);
			logger.warn("Unit master  Failed");
		}
		
	}
	
		
	}
	

