package com.idzlink.testCases.POS;

import java.io.IOException;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.idzlink.pageObjects.CustomerPage;
import com.idzlink.pageObjects.Homepage;
import com.idzlink.pageObjects.PointofSale;
import com.idzlink.testCases.BaseClass;

public class TC_Cash_Customer_Selection_Details_Verification_POS extends BaseClass {
	
	@Test
	public void Cash_Customer_Selection_Details_Verification() throws InterruptedException, IOException
	{
		
intilization();
		
		Homepage hp=new Homepage(driver);
		hp.Startbutton();
		
		hp.Setupclick();
	
		CustomerPage cp=new CustomerPage(driver);
		cp.Customermaster();
		logger.info("Customer Master Opened");
		
		driver.switchTo().frame("frame1");
		Thread.sleep(2000);
		cp.Customercategory("General"); // general
		logger.info("Customer General Entered");
		
		String customername=randomeString();
		cp.setCustomerName(customername); // customer name
		logger.info("Customer Name Entered");
		
		Thread.sleep(3000);
		
		cp.CustomerCountry(5); // country
		logger.info("Customer Country Selected");
		
		Thread.sleep(2000);
		cp.CustomerCity(1);
		logger.info("Customer City Selected");
		
		cp.CustomerCurrency(1);
		logger.info("Customer Currency Selected");
		
		cp.CustomerGroup(1);
		logger.info("Customer Group Selected");
		
		Thread.sleep(2000);
		cp.CustomerDebtoracc(1);
		
		
		String email=customername+"@gmaiil.com";
		
		Thread.sleep(2000);
		cp.setCustomerEmail(email);
		
		String tin=randomeTin();
		cp.setCustomerTin(tin);
		
		cp.clickCustomerShopDetailtab();
		cp.shopselectioncheckbox();
		
		
		cp.Customersave();
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
		driver.switchTo().defaultContent();
		
		//customer saved
		
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
		driver.switchTo().frame("frame2");
		ps.counterselection();
	
		
		String customerlist=customername;
		ps.customerselection(customername);
		Map<String, String> customerdetails=ps.customerfetch();
		
		String actualCustomerName=customerdetails.get("name");
		String actualemail=customerdetails.get("email");
		String actualtin=customerdetails.get("tin");
		
		System.out.println("cus name : "+actualCustomerName);
		System.out.println("email : "+actualemail);
		System.out.println("tin : "+actualtin);
		
		ps.firstthreeitems();
		

		ps.checkout();
		Thread.sleep(1000);


		if(customername.equals(actualCustomerName) && email.equals(actualemail) && tin.equals(actualtin) )
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
			captureScreen(driver,"Cash_Customer_Selection_Details_Verification");
		}
		
		Thread.sleep(1000);
		ps.closebtn();
		
		Thread.sleep(2000);
		ps.conterlogout();
		
	
		
	}

}
