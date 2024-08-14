package com.idzlink.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.idzlink.utilities.AbstractComponents;

public class PackingType extends AbstractComponents {
	
	WebDriver ldriver;
	public PackingType(WebDriver rdriver)
	{	super(rdriver);
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}


	@FindBy(xpath="//span[@class='maincatName'][normalize-space()='Packing Type']")
	@CacheLookup
	WebElement pktbtn;
	
	
	@FindBy(id="txtcode")
	@CacheLookup
	WebElement pktcode;
	
	@FindBy(id="txtdesc")
	@CacheLookup
	WebElement pktdes;
	
	@FindBy(id="btnadd")
	@CacheLookup
	WebElement pktadd;
	
	@FindBy(id="ddlunit")
	@CacheLookup
	WebElement pktunit;
	
	@FindBy(id="txtunitqty")
	@CacheLookup
	WebElement pktunitqty;
	
	@FindBy(css=".glyphicon-ok")
	@CacheLookup
	WebElement pktunitsubmit;
	
	@FindBy(xpath="//i[@class='fa fa-check']")
	@CacheLookup
	WebElement pksubmit;
	
	public void packingtypemaster() throws InterruptedException
	{
		scrollToElement(pktbtn);
		Thread.sleep(1000);
		pktbtn.click();
	}
	
	public void packingtypesave(String pcode,String pdesc,int unitindex,String pqty) throws InterruptedException
	{
		waitForWebElementToAppear(pktcode);
		pktcode.sendKeys(pcode);
		waitForWebElementToAppear(pktdes);
		pktdes.sendKeys(pdesc);
		waitForWebElementToAppear(pktadd);
		pktadd.click();
		
		Thread.sleep(1000);
		waitForWebElementToAppear(pktunit);
		try {
            clickElement(pktunit); // Assuming clickElement method waits for element to be clickable
            Select countrys = new Select(pktunit);
            countrys.selectByIndex(unitindex);
            System.out.println("Selected unitindex at index " + unitindex);
        } catch (Exception e) {
            System.out.println("Exception occurred while selecting unitindex: " + e.getMessage());
            e.printStackTrace();
        }
		
		waitForWebElementToAppear(pktunitqty);
		pktunitqty.sendKeys(pqty);
		
		pktunitsubmit.click();
		pksubmit.click();
		
		
		
	}
	
	
	
	
	
	

	
}
