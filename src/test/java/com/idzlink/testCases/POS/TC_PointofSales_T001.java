package com.idzlink.testCases.POS;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import com.idzlink.pageObjects.Homepage;
import com.idzlink.pageObjects.PointofSale;
import com.idzlink.testCases.BaseClass;
import com.idzlink.utilities.Retry;

public class TC_PointofSales_T001 extends BaseClass {

	@Test(retryAnalyzer=Retry.class)
	public void posnewmode() throws InterruptedException, IOException {
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
		double totalamount = ps.calculationcheck();

		System.out.println(totalamount);

		double amount = ps.FinalAmount();
		System.out.println(amount);

		ps.checkout();
		Thread.sleep(1000);
		String succ = ps.SuccessfullMessage();

		System.out.println(succ);

		// Thread.sleep(5000);

		if (succ.toLowerCase().contains("saved successfully".toLowerCase())) {
			// Assertion to pass the test
			
			assertTrue(true);
		} else {
			// Assertion to fail the test with a message
			captureScreen(driver,"posnewmode");
			assertTrue(false, "The success message should contain 'Saved Successfully'");
		}

		Thread.sleep(1000);
		ps.closebtn();

		Thread.sleep(2000);
		ps.conterlogout();

	}

}
