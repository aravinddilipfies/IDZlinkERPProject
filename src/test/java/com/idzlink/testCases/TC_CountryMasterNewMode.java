package com.idzlink.testCases;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.idzlink.pageObjects.Country;
import com.idzlink.pageObjects.Homepage;

public class TC_CountryMasterNewMode extends BaseClass {
	
	@Test
	public void countrymasternewmode() throws InterruptedException, IOException
	{
		intilization();
		
		Homepage hp=new Homepage(driver);
		hp.Startbutton();
		
		hp.Setupclick();
		
		Country cm=new Country(driver);
		
		cm.countrymasteropen();
		
		driver.switchTo().frame("frame1");
		
		String contrycode=randomeNum();
		cm.countrycode(contrycode);
		
		String countryname=randomeString();
		cm.countryname(countryname);
		
		String telephonecode=randomeNum();
		cm.countrytelephonecode(telephonecode);
		
		cm.submit();
		
		if(isAlertPresentWithSuccessMessage()==true)
		{
			driver.switchTo().alert().accept(); //close alert
			driver.switchTo().defaultContent();
			Assert.assertTrue(true);
			
		}
		
		else
		{
			captureScreen(driver,"countrymasternewmode");
			Assert.assertTrue(false);
			logger.warn("Country creation Failed");
		}
		
		
		
		
		
	}
	
	

}
