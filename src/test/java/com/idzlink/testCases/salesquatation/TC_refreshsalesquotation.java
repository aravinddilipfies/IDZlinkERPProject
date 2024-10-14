package com.idzlink.testCases.salesquatation;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.idzlink.pageObjects.Homepage;
import com.idzlink.pageObjects.SalesQuatation;
import com.idzlink.testCases.BaseClass;

public class TC_refreshsalesquotation extends BaseClass {
@Test
public void refreshsalesquotation() throws InterruptedException, IOException
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
	sq.buttonrefresh();
	
	Alert alert = driver.switchTo().alert();

    // Get the text of the alert
    String alertMessage = alert.getText();
    
    // Use assert in if condition to check if the message is as expected
    if (alertMessage.contains("This Action will reset your current Entry")) {
        // Assertion will pass if the condition is true
        Assert.assertTrue(true, "Alert message is correct");
        System.out.println("Alert message is correct: " + alertMessage);
    } else {
    	captureScreen(driver,"salesQuatationEditTotalamoutValidation");
		Assert.assertTrue(false);
		logger.info("Entered customer missmatched");
		System.out.println("failed innnnn");
        // Assertion will fail if the message is not as expected
       
    }
}
}
