package com.idzlink.testCases;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.idzlink.pageObjects.Homepage;
import com.idzlink.pageObjects.ItemMaster;

public class TC_ItemmasternSave extends BaseClass {

	@Test
	public void addnewitem() throws InterruptedException, IOException
	{
		intilization();
		Homepage hp=new Homepage(driver);
		hp.Startbutton();
		Thread.sleep(1000);
		hp.Setupclick();
		hp.RetailSetupclick();
		hp.itemSetupclick();
		
		ItemMaster im=new ItemMaster(driver);
		im.itemmasteropen();
		driver.switchTo().frame("frame1");
		String itemcp= randomeNum();
		String itemname =randomeString();
		String itemsp= "1"+itemcp;
		
		im.Itemsave(itemname, 1, 2, 1, itemcp, itemsp,1);
		
		
		
		if(isAlertPresentWithSuccessMessage()==true)
		{
			driver.switchTo().alert().accept(); //close alert
			driver.switchTo().defaultContent();
			Assert.assertTrue(true);
			
		}
		
		else
		{
			captureScreen(driver,"addnewitem");
			Assert.assertTrue(false);
			logger.warn("Packing Type master  Failed");
		}
		
		
	}
}
