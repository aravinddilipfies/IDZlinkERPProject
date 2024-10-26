package com.idzlink.testCases.POS;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.idzlink.pageObjects.Homepage;
import com.idzlink.pageObjects.PointofSale;
import com.idzlink.testCases.BaseClass;

public class TC_sellingpriceabovemrpalert_pos  extends BaseClass{
@Test
public void sellingpriceabovemrpalert_pos() throws InterruptedException, IOException
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
	Thread.sleep(1000);
	ps.counterselection();
	Thread.sleep(1000);
	ps.mrppriceitemsearch();
	Thread.sleep(1000);
	ps.mrppricealert();
	 String mrpmessagepricealert=ps.mrppricealert();
	 Thread.sleep(1000);
	    System.out.println("message is "+ mrpmessagepricealert);
	    
	    if (mrpmessagepricealert.toLowerCase().contains("Price should be less than MRP.".toLowerCase())) {
			// Assertion to pass the test
			
			Assert.assertTrue(true);
		} else {
			// Assertion to fail the test with a message
			captureScreen(driver,"sellingpriceabovemrpalert_pos");
			Assert.assertTrue(false);
		}

		Thread.sleep(1000);
		
		ps.conterlogout();
		
	
}
}
