package com.idzlink.testCases;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.idzlink.pageObjects.LoginPage;
import com.idzlink.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass 
{ 
	@Test(dataProvider="LoginData")
	public void loginDDT(String user,String pwd) throws InterruptedException
	{
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(user);
		logger.info("username provided");
		lp.setPassword(pwd);
		logger.info("password provided");
		lp.clickSubmit();
		
		Thread.sleep(3000);
		
		if(lp.tutorialclose())
		{
			Assert.assertTrue(true);
			logger.info("Login test passed");
			Thread.sleep(3000);
			lp.closebtn(); // close tutorial windows
			lp.Usricon();
			lp.Logout();
			Thread.sleep(3000);
			driver.switchTo().alert().accept(); // close the logout alert
			driver.switchTo().defaultContent();
			
		}
		
		else
		{
			Assert.assertTrue(false);
			logger.warn("Login Failed");
		}
		
		
		
	}
	
	
	
	
	
	
	@DataProvider(name="LoginData")
	String[][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/test/java/com/idzlink/testData/LoginData.xlsx";
		
		int rownum =XLUtils.getRowCount(path,"Sheet1");
		int cocount=XLUtils.getCellCount(path,"Sheet1",1);
		
		String logindata[][]=new String[rownum][cocount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<cocount;j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(path,"Sheet1",i,j);
			}
		}
		return logindata;
	}

}
