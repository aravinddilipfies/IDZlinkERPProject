package com.idzlink.testCases.salesquatation;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.idzlink.pageObjects.Homepage;
import com.idzlink.pageObjects.SalesQuatation;
import com.idzlink.testCases.BaseClass;

public class TC_serachentersalesquotation  extends BaseClass {
@Test
public void serachentersalesquotation() throws InterruptedException, IOException
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
	sq.searchtext();
	Thread.sleep(3000);
	sq.itemsearched();
	Thread.sleep(2000);
	sq.itemdropdown();
	Thread.sleep(2000);
	sq.remarksenter();
	Thread.sleep(2000);
	sq.checkbox();
	Thread.sleep(2000);
	sq.submit();
	if(isAlertPresentWithSuccessMessage()==true)
	{
		driver.switchTo().alert().accept(); //alert accept
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		driver.switchTo().defaultContent();
		Assert.assertTrue(true);
		
	}
	
	
	else
	{
		captureScreen(driver,"serachentersalesquotation");
		Assert.assertTrue(false);
		logger.warn("sales quatation failed");
	}
	
	
	
	
}
}
