package com.idzlink.testCases;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.Test;

import com.idzlink.pageObjects.Homepage;
import com.idzlink.pageObjects.LoginPage;
import com.idzlink.pageObjects.Maincategorypage;
import com.idzlink.pageObjects.SupplierPage;
import com.idzlink.utilities.JavaScriptsUtil;

public class TC_MainCategoryNew_T008 extends BaseClass {

	private static final String JavaScriptUtil = null;
	@Test
	public void addnewmaincategory() throws InterruptedException, IOException
	{
		intilization();
		
		Homepage hp=new Homepage(driver);
		hp.Startbutton();
		//Thread.sleep(1000);
		hp.Setupclick();
		
		//Thread.sleep(3000);
		
		hp.RetailSetupclick();
		//Thread.sleep(2000);
		hp.itemSetupclick();
		//Thread.sleep(2000);
		
		Maincategorypage mc=new Maincategorypage(driver);
		mc.MainCategoryMaster();
	//	Thread.sleep(2000);
		
	
		
		driver.switchTo().frame("frame1");
		
		String code= randomeNum();
		String des =randomeString();
		
		mc.MainCategoryCode(code);
		//Thread.sleep(2000);

		mc.MainCategoryDescription(des);
		//Thread.sleep(2000);
		
		mc.MainCategorySubmit();
		
			
		//mc.MainCategorySaveMsg().contains("Successfully Saved");
		//Thread.sleep(2000);
		if(mc.MainCategorySaveMsg())
		{
			 String actualMessage=mc.MainCategorySaveMsgGet();
			 Assert.assertTrue(actualMessage.contains("Successfully Saved"));
		}
		else
		{
			Assert.assertTrue(false);
			captureScreen(driver,"maincategory");
		}
	
	}
}
