package com.idzlink.testCases.salesquatation;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.idzlink.pageObjects.Homepage;
import com.idzlink.pageObjects.PointofSale;
import com.idzlink.pageObjects.SalesQuatation;
import com.idzlink.testCases.BaseClass;

public class TC_covertionofsalesquatationtopos extends BaseClass {

	@Test
	public void covertionofsalesquatationtopos() throws InterruptedException, IOException
	{
      intilization(); //login
		
		Homepage hp = new Homepage(driver);
		hp.Startbutton();  // click on start button
		Thread.sleep(1000);
		hp.Retailclick(); // click on retail tab
		Thread.sleep(1000);
		hp.locationclick(); //location
		hp.shoplocationselect();  //location shop select
		hp.submitlocation(); //location submit button
		
		Thread.sleep(1000);
		hp.salesandreturnexpand();
		Thread.sleep(2000);
		
		SalesQuatation sq=new SalesQuatation(driver);
		sq.opensalesquatation();
		
		driver.switchTo().frame("frame1");
		
		Thread.sleep(3000);
		sq.customerselection();
		sq.customernameenter("Customer");
		
		Thread.sleep(3000);
		
		sq.additem();
		Thread.sleep(2000);
		
		sq.itemdropdown();
		Thread.sleep(2000);
		sq.quantity();
		sq.checkbox();
		sq.remarksenter();
		Thread.sleep(2000);
		sq.submit();
		
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		driver.switchTo().alert().dismiss();
		
		sq.searchicon();
		Thread.sleep(2000);
		sq.searchbuttonfield();
		Thread.sleep(2000);
		
		
		String quatationno =sq.quotationnumberfield();
		
		System.out.println(quatationno);
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		
		
		Homepage hp2 = new Homepage(driver);
		Thread.sleep(2000);
		hp2.Startbutton();
		Thread.sleep(3000);
		hp2.Retailclick();
		Thread.sleep(3000);
		hp2.salesandreturnexpand();
		Thread.sleep(2000);
		
		
		PointofSale ps = new PointofSale(driver);
		ps.Posopen();
		driver.switchTo().frame("frame2");
		ps.counterselection();
		
		ps.quptationbutton();
		Thread.sleep(2000);
		ps.selectionquotation();
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
			captureScreen(driver,"covertionofsalesquatationtopos");
			Assert.assertTrue(false);
		}

		Thread.sleep(1000);
		ps.closebtn();

		Thread.sleep(3000);
	//	ps.conterlogout();
		
		
	}
}
