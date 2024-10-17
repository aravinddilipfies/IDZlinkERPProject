package com.idzlink.testCases.POS;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import com.idzlink.pageObjects.Homepage;
import com.idzlink.pageObjects.PointofSale;
import com.idzlink.testCases.BaseClass;
import com.idzlink.utilities.Retry;

public class TC_PointofSalesEdit extends BaseClass {
	
	@Test(retryAnalyzer=Retry.class)
	public void poseditmode() throws InterruptedException, IOException
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

			ps.firstthreeitems();
			logger.info("items added to pos on new mode");
			
			double amount = ps.FinalAmount();
			System.out.println(amount);
			
			ps.checkout();
			Thread.sleep(1000);
			
			ps.closebtn();
			//serach the latest bill
			ps.search();
			
			//edit the bill
			Thread.sleep(1000);
			ps.editbutton();
			
			
			ps.additemsoneditmode();
			logger.info("items added to pos on edit mode");
			ps.checkout();
			logger.info("pos checkout on edit mode");
			
			Thread.sleep(1000);
			String updatepopup=ps.updatesuccessfulmessage();
			System.out.println(updatepopup);
			
			if (updatepopup.toLowerCase().contains("Updated Successfully.".toLowerCase())) {
				// Assertion to pass the test
				assertTrue(true);
			} else {
				captureScreen(driver,"poseditmode");
				// Assertion to fail the test with a message
				assertTrue(false, "The success message should contain 'Updated Successfully.'");
			}
			
			Thread.sleep(1000);
			ps.closebtn();

			Thread.sleep(2000);
			ps.conterlogout();
			
			
			
			
			
	}

}
