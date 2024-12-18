package com.idzlink.testCases;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.idzlink.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass  {

	@Test
	public void loginTest() throws IOException, InterruptedException
	{
		
		
		
		logger.info("URL is opened");
		
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		logger.info("Entered Username");
		
		lp.setPassword(password);
		logger.info("Entered Password");
		
		lp.clickSubmit();
		
		Thread.sleep(5000);
		
		if(driver.getTitle().equals("Cloud ERP| IDZlink Home"))
		{
			Assert.assertTrue(true);
			logger.info("Login test passed");
		}
		else
		{
			captureScreen(driver,"logintest");
			Assert.assertTrue(false);
			logger.info("Login test failed");
		}
		
		
		
	}
	
}
