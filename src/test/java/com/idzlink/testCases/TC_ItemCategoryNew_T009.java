package com.idzlink.testCases;

import java.io.IOException;
import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.idzlink.pageObjects.Homepage;
import com.idzlink.pageObjects.ItemCategorypage;
import com.idzlink.pageObjects.LoginPage;
import com.idzlink.pageObjects.Maincategorypage;
import com.idzlink.pageObjects.SupplierPage;
import com.idzlink.utilities.JavaScriptsUtil;

public class TC_ItemCategoryNew_T009 extends BaseClass {

	private static final String JavaScriptUtil = null;
	@Test
	public void addnewitemvategory() throws InterruptedException, IOException
	{
	
		
		intilization();
		
		Homepage hp=new Homepage(driver);
		hp.Startbutton();
	//	Thread.sleep(3000);
		hp.Setupclick();
		
	//	Thread.sleep(3000);
		
		hp.RetailSetupclick();
	//	Thread.sleep(2000);
		hp.itemSetupclick();
		//Thread.sleep(2000);
		
		ItemCategorypage ic=new ItemCategorypage(driver);
		ic.ItemCategoryMaster();
		//Thread.sleep(2000);
		
	
		
		driver.switchTo().frame("frame1");
		
		String code= randomeNum();
		String des =randomeString();
		
		ic.ItemCategorycode(code);
		Thread.sleep(2000);
		
		ic.Maincatselection(1);
	//	Thread.sleep(2000);

		ic.ItemCategoryDescription(des);
	//	Thread.sleep(2000);
		
		ic.itemcattaxselection(1);
	//	Thread.sleep(2000);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		
		ic.ItemCategoryShopSelection();
		
		ic.ItemCategorysubmite();
	//	Thread.sleep(2000);
			
		//mc.MainCategorySaveMsg().contains("Successfully Saved");
		
		if(isAlertPresentWithSuccessMessage()==true)
		{
			driver.switchTo().alert().accept(); //close alert
			driver.switchTo().defaultContent();
			Assert.assertTrue(true);
			
		}
		
		else
		{
			captureScreen(driver,"addnewitemvategory");
			Assert.assertTrue(false);
			logger.warn("Item category master  Failed");
		}
		
			
	}

}


