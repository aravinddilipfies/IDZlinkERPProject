package com.idzlink.testCases.POS;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.idzlink.pageObjects.Homepage;
import com.idzlink.pageObjects.PointofSale;
import com.idzlink.testCases.BaseClass;

public class TC_costpricevalidationhandling_pos  extends BaseClass 
{
@Test
public void costpricevalidationhandling_pos() throws InterruptedException, IOException
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
	ps.costpriceitemsearch();
	Thread.sleep(1000);
    ps.costpricealert();
    String costpricemessage=ps.costpricealert();
    Thread.sleep(1000);
    System.out.println("message is "+ costpricemessage);
    
    if (costpricemessage.toLowerCase().contains("Maximum rate editing / discount limit reached.".toLowerCase())) {
		// Assertion to pass the test
		
		Assert.assertTrue(true);
	} else {
		// Assertion to fail the test with a message
		captureScreen(driver,"costpricevalidationhandling_pos");
		Assert.assertTrue(false);
	}

	Thread.sleep(1000);
	
	ps.conterlogout();
	

}
}
