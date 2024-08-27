package com.idzlink.testCases.POS;

import java.io.IOException;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.idzlink.pageObjects.Homepage;
import com.idzlink.pageObjects.PointofSale;
import com.idzlink.testCases.BaseClass;

public class TC_PointofSales_UnitPriceandTaxCalculation extends BaseClass  {
	
	@Test
	public void posUnitPriceandTaxCalculation() throws InterruptedException, IOException
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
		
		ps.itemadd();
		
		Thread.sleep(2000);
		
		ps.scrolltoTopofCart();
		System.out.println("scrolled to top");
		Thread.sleep(2000);
		
		
		Map<String, Float> results = ps.calculateTotalPriceAndTax();
		
		
		float itemstotalamount = results.get("sum");
		System.out.println("sum is" +itemstotalamount );
		float UnitTax = results.get("totalUnitTax");
		
		float totalUnitTax=Math.round(UnitTax * 100.0f) / 100.0f;
		
		System.out.println("tax is" +totalUnitTax );
		
		
		float grandtotal=ps.FinalAmount();
		 
		 String taxamount=ps.getTotalTax();
		 System.out.println(taxamount);
		// double tax=Double.parseDouble(taxamount); 
		 
		 ps.checkout();
		 
		 //&& tax==totalUnitTax
		 if(itemstotalamount==grandtotal )
			{
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
				captureScreen(driver,"posUnitPriceandTaxCalculation");
			}
		 
		 	Thread.sleep(1000);
			ps.closebtn();
			
			Thread.sleep(2000);
			ps.conterlogout();
		
	}

}
