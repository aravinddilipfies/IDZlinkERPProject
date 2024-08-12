package com.idzlink.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.idzlink.utilities.AbstractComponents;

public class CustomsPage extends AbstractComponents {

	WebDriver ldriver;
	//ldriver - local driver  rdriver - remote driver
	
	public CustomsPage(WebDriver rdriver)
	{
		super(rdriver);
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//ul[@class='CategoryMain level1']//span[@class='maincatName'][normalize-space()='Customs']")
	@CacheLookup
	WebElement customsbtn;
	
	@FindBy(xpath="//input[@id='txtcatcode']")
	@CacheLookup
	WebElement customecodetxt;
	
	@FindBy(xpath="//input[@id='txtdutypercent']")
	@CacheLookup
	WebElement dutypercenttxt;
	
	@FindBy(xpath="//i[@class='fa fa-check']")
	@CacheLookup
	WebElement custombtnSubmit;
	
	@FindBy(xpath="//span[@id='span1']")
	@CacheLookup
	WebElement customclose;
	
	//span[@id='span1']
	
	public void CustomesMaster()
	{
		customsbtn.click();
	}
	
	public void CustomeCode(String ccode)
	{
		customecodetxt.sendKeys(ccode);
	}
	
	public void DutyPercent(String cduty)
	{
		dutypercenttxt.sendKeys(cduty);
	}
	
	public void CustomesSubmit()
	{
		clickElement(custombtnSubmit);
		custombtnSubmit.click();
	}
	
	public void CustomesClose()
	{
		customclose.click();
	}
	
	
	
	
	
}
