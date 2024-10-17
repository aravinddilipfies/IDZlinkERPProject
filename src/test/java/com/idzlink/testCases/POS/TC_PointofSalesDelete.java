package com.idzlink.testCases.POS;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.idzlink.pageObjects.Homepage;
import com.idzlink.pageObjects.PointofSale;
import com.idzlink.testCases.BaseClass;
import com.idzlink.utilities.Retry;

public class TC_PointofSalesDelete extends BaseClass {
	
	@Test(retryAnalyzer=Retry.class)
	public void posdeletemode() throws InterruptedException, IOException
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
			logger.info("pos interface is opened");
			driver.switchTo().frame("frame1");
			ps.counterselection();
			logger.info("counter selected");

			ps.firstthreeitems();
			logger.info("items added to pos on new mode");
			
			double amount = ps.FinalAmount();
			System.out.println(amount);
			
			ps.checkout();
			logger.info("pos checkedout");
			
			Thread.sleep(1000);
			
			ps.closebtn();
			//serach the latest bill
			ps.search();
			
			//deleting pos transaction
			ps.deletepostransaction();
			logger.info("pos transaction deleted");
			
			String cancelvalue=ps.cancelledvalidation();
			
			System.out.println(cancelvalue);
			
			if (cancelvalue.contains("Yes")) {
	           
				Assert.assertTrue(true);
				System.out.println("Test Passed: The cancel value contains 'yes'.");
	        } else {
	        	Assert.assertTrue(false);
	            System.out.println("Test Failed: The cancel value does not contain 'yes'.");
	            captureScreen(driver,"posdeletemode");
	        }
			
			
			
			
			

			Thread.sleep(2000);
			ps.conterlogout();
			
			
			
			
			
			
			
			
			
			
	}

}
