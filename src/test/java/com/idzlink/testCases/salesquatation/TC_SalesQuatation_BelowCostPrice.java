package com.idzlink.testCases.salesquatation;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.testng.annotations.Test;

import com.idzlink.pageObjects.Homepage;
import com.idzlink.pageObjects.SalesQuatation;
import com.idzlink.testCases.BaseClass;

public class TC_SalesQuatation_BelowCostPrice  extends BaseClass {
@Test
public void SalesQuatation_BelowCostPrice() throws InterruptedException, IOException 
{
	intilization(); //login
	
	Homepage hp = new Homepage(driver);
	hp.Startbutton();  // click on start button
	Thread.sleep(1000);
	hp.Retailclick(); // click on retail tab
	Thread.sleep(1000);
	hp.locationclick(); //location
	hp.shoplocationselect();  //location shop select
	hp.submitlocation(); //location submit button
	
	Thread.sleep(1000);
	hp.salesandreturnexpand();
	Thread.sleep(2000);
	
	SalesQuatation sq=new SalesQuatation(driver);
	sq.opensalesquatation();
	
	driver.switchTo().frame("frame1");
	
	Thread.sleep(3000);
	sq.customerselection();
	sq.customernameenter("Customer");
	Thread.sleep(3000);
	sq.ratesearch();
	
	
	Alert alert = driver.switchTo().alert();
	 String alertText = alert.getText();
     
     // Expected alert message
     String expectedMessage = "Maximum rate editing limit reached";

     // Check if the alert text matches the expected message
     if (alertText.equals(expectedMessage)) {
         System.out.println("Alert message confirmed: " + alertText);
     } else {
    	 captureScreen(driver,"SalesQuatation_BelowCostPrice");
			Assert.assertTrue(false);
			logger.warn("sales quatation failed");
     }
	
	
}

}
