package com.idzlink.testCases.POS;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.idzlink.pageObjects.Homepage;
import com.idzlink.pageObjects.PointofSale;
import com.idzlink.testCases.BaseClass;

public class TC_pointofsalesbarcodesearch extends BaseClass {
@Test
public void pointofsalesbarcodesearch() throws InterruptedException, IOException {
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
	ps.barcodesearch();
	Thread.sleep(2000);
	ps.checkout();
	Thread.sleep(1000);
	String succ = ps.SuccessfullMessage();
	System.out.println(succ);

	// Thread.sleep(5000);

	if (succ.toLowerCase().contains("saved successfully".toLowerCase())) {
		// Assertion to pass the test
		
		Assert.assertTrue(true);
	} else {
		// Assertion to fail the test with a message
		captureScreen(driver,"pointofsalesbarcodesearch");
		Assert.assertTrue(false);
	}

	Thread.sleep(1000);
	ps.closebtn();

	Thread.sleep(2000);
	ps.conterlogout();

}
}
