package com.idzlink.testCases.POS;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.idzlink.pageObjects.Homepage;
import com.idzlink.pageObjects.PointofSale;
import com.idzlink.testCases.BaseClass;

public class TC_pointofsalediscount extends BaseClass {
@Test
public void pointofsalediscount() throws InterruptedException, IOException
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
	Thread.sleep(2000);
	ps.counterselection();
	Thread.sleep(2000);
	ps.firstthreeitems();
	
	String granttotalinstring=ps.getgranttotal();
	float totalamount=Float.parseFloat(granttotalinstring);
	
	float discount = totalamount * 0.10f;
	float finalAmount = totalamount - discount;
	
	finalAmount = Math.round(finalAmount * 100.0f) / 100.0f;
	
	ps.discountapplying();
	
	Thread.sleep(2000);
	String toalamountafterdiscountinstring=ps.getgranttotal();
	float totalamountafterdiscount=Float.parseFloat(toalamountafterdiscountinstring);
	
	System.out.println("total amount"+finalAmount);
	System.out.println("total amount after discony by iszlink"+totalamountafterdiscount);
	
	Thread.sleep(2000);
	ps.checkout();
	Thread.sleep(1000);
	
	

	// Thread.sleep(5000);

	if (finalAmount==totalamountafterdiscount) {
		// Assertion to pass the test
		
		Assert.assertTrue(true);
		
		Thread.sleep(1000);
		ps.closebtn();

		Thread.sleep(2000);
		ps.conterlogout();
		
	} else {
		// Assertion to fail the test with a message
		captureScreen(driver,"pointofsalediscount");
		Assert.assertTrue(false);
	}
}
}
