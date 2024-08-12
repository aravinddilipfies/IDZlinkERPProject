package com.idzlink.testCases;

import java.io.IOException;
import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.idzlink.pageObjects.CustomsPage;
import com.idzlink.pageObjects.Homepage;
import com.idzlink.pageObjects.LoginPage;
import com.idzlink.utilities.XLUtils;

public class TC_CustomsDDT_T007 extends BaseClass {

	@BeforeClass
	public void cutsm_login() throws InterruptedException
	{
		
		intilization();
		
		//start button click
		Homepage hp=new Homepage(driver);
		hp.Startbutton();
		
		hp.Setupclick();
		
		
		//custom page
		CustomsPage c=new CustomsPage(driver);
		Thread.sleep(2000);
		c.CustomesMaster();
		Thread.sleep(2000);
	}
	
	@Test(dataProvider="CustomsData")
	public void customsDDT(String code,String duty) throws InterruptedException, IOException
	{
		
		CustomsPage c=new CustomsPage(driver);
	
		driver.switchTo().frame("frame1");
		
		c.CustomeCode(code);
		logger.info("custom code provided");
		c.DutyPercent(duty);
		logger.info("duty percent provided");
		//Thread.sleep(2000);
		c.CustomesSubmit();
		
		
	
		
		//Thread.sleep(3000);
		
		if(isAlertPresent()==true)
		{
			logger.info("customs duty created");
			driver.switchTo().alert().accept(); //close alert
			driver.switchTo().defaultContent();
			Assert.assertTrue(true);
			
			
		}
		
		else
		{
			captureScreen(driver,"cutsm_login");
			Assert.assertTrue(false);
			
		}
		
		
		
	}
	
		
	@DataProvider(name="CustomsData")
	String[][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/test/java/com/idzlink/testData/Customs.xlsx";
		
		int rownum =XLUtils.getRowCount(path,"Sheet1");
		int cocount=XLUtils.getCellCount(path,"Sheet1",1);
		
		String customdata[][]=new String[rownum][cocount];
		
		System.out.println(rownum);
		System.out.println(cocount);
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<cocount;j++)
			{
				customdata[i-1][j]=XLUtils.getCellData(path,"Sheet1",i,j);
			}
		}
		return customdata;
	}
	
	
	public boolean isAlertPresent() //user defined method created to check alert present or not
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		try
		{
			wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert();
		return true;
		}
		catch(NoAlertPresentException e)
		{
			return false;
		}
	}
	
}
