package com.idzlink.testCases.POS;

import java.io.IOException;

import org.testng.annotations.Test;

import com.idzlink.pageObjects.Homepage;
import com.idzlink.pageObjects.PointofSale;
import com.idzlink.testCases.BaseClass;

public class TC_PointofSalesEdit extends BaseClass {
	
	@Test
	public void poseditmode() throws InterruptedException
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
			Thread.sleep(3000);
			PointofSale ps = new PointofSale(driver);
			ps.Posopen();
			driver.switchTo().frame("frame1");
			ps.counterselection();

			ps.itemselection();
			
			double amount = ps.FinalAmount();
			System.out.println(amount);
			
			ps.checkout();
			Thread.sleep(1000);
			
			ps.closebtn();
			
			ps.search();
			
			Thread.sleep(1000);
			ps.editbutton();
			
			
			
			Thread.sleep(5000);
			
			
			
	}

}
