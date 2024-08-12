package com.idzlink.testCases;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.idzlink.pageObjects.Homepage;
import com.idzlink.pageObjects.PackingType;

public class TC_PackingTypeNew extends BaseClass {

	@Test
	public void addnewpackkingtye() throws InterruptedException, IOException
	{
		intilization();
		Homepage hp=new Homepage(driver);
		hp.Startbutton();
		hp.Setupclick();
		hp.RetailSetupclick();
		hp.itemSetupclick();
		
		PackingType pt=new PackingType(driver);
		pt.packingtypemaster();
		driver.switchTo().frame("frame1");
		String pcode= randomeNum();
		String pdes =randomeString();
		pt.packingtypesave(pcode, pdes,1,pcode);
		
		if(isAlertPresentWithSuccessMessage()==true)
		{
			driver.switchTo().alert().accept(); //close alert
			driver.switchTo().defaultContent();
			Assert.assertTrue(true);
			
		}
		
		else
		{
			captureScreen(driver,"addnewpackkingtye");
			Assert.assertTrue(false);
			logger.warn("Packing Type master  Failed");
		}
		
		
		
		
		
	}
	
}
