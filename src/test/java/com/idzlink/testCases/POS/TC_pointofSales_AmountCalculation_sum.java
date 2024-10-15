package com.idzlink.testCases.POS;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.idzlink.pageObjects.Homepage;
import com.idzlink.pageObjects.PointofSale;
import com.idzlink.testCases.BaseClass;

public class TC_pointofSales_AmountCalculation_sum extends BaseClass {

	@Test
	public void itemsumverification() throws InterruptedException, IOException
	{
		
		intilization();
		Homepage hp = new Homepage(driver);
		hp.Startbutton();
		Thread.sleep(1000);
		hp.Retailclick();
		Thread.sleep(1000);
		hp.locationclick();
		hp.shoplocationselect();
		hp.submitlocation();
		Thread.sleep(1000);
		hp.salesandreturnexpand();
		Thread.sleep(2000);
		
		PointofSale ps = new PointofSale(driver);
		ps.Posopen();
		driver.switchTo().frame("frame1");
		ps.counterselection();
		
		Thread.sleep(2000);
		ps.itemadd();
		
		
		
		double itemstotal = ps.gettheitempricesum();
		
		double grandtotal = ps.FinalAmount();
		
		if(itemstotal==grandtotal)
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
			captureScreen(driver,"itemsumverification");
		}
		
		Thread.sleep(2000);
		ps.conterlogout();
	}
	
}
