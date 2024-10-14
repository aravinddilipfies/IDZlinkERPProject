package com.idzlink.testCases.salesquatation;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.idzlink.pageObjects.Homepage;
import com.idzlink.pageObjects.SalesQuatation;
import com.idzlink.testCases.BaseClass;

public class TC_validationoftotalamountsalesquotation extends BaseClass {
	@Test
	public void validationoftotalamountsalesquotation() throws InterruptedException, IOException
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
		//sq.quantity();
		Thread.sleep(2000);
		sq.remarksenter();
	String amout=	sq.salesquotationactualamount();
	System.out.println("amout is"+ amout);
	String tax=	sq.salesquotationtaxamount();
	System.out.println("tax is"+ tax);	
	
	
		float totalAmount = Float.parseFloat(amout);
		float totaltax = Float.parseFloat(tax);
		
		float granttotal=totalAmount+ totaltax;
		System.out.println("granttotal is"+ granttotal);	
		
		String totalmrf=sq.gettotalamount();
		float mrftotal= Float.parseFloat(totalmrf);
		
		if(granttotal==mrftotal)	
		{
			Assert.assertTrue(true);
		}
		
		else
		{
			captureScreen(driver,"validationoftotalamountsalesquotation");
			Assert.assertTrue(false);
			logger.info("Entered customer missmatched");
			System.out.println("failed innnnn");
		}
		
		
		
	}

	

}
