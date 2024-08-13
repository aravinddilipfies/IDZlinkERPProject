package com.idzlink.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.idzlink.utilities.AbstractComponents;

public class Homepage extends AbstractComponents {

	WebDriver ldriver;
	//ldriver - local driver  rdriver - remote driver
	
	public Homepage(WebDriver rdriver)
	{
		super(rdriver);
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="(//span[@class='home-txt'])[1]")
	@CacheLookup
	WebElement startbtn;
	
	@FindBy(xpath="//ul[@id='ul2371']//li[@id='lnkMaster']")
	@CacheLookup
	WebElement setup;
	
	@FindBy(xpath="//tbody/tr[1]/td[2]/div[2]/div[1]/div[1]/nav[1]/ul[1]/li[6]/div[1]")
	@CacheLookup
	WebElement retailsetup;
	
	@FindBy(xpath="//tbody/tr[1]/td[2]/div[2]/div[1]/div[1]/nav[1]/ul[1]/li[6]/ul[1]/li[2]")
	@CacheLookup
	WebElement itemdrpdwn;
	
	@FindBy(xpath="//div[@id='target01Automation']//li[4]")
	@CacheLookup
	WebElement retail;
	
	@FindBy(xpath="//div[@class='selectLocation']//span[contains(text(),'Select Location')]")
	@CacheLookup
	WebElement location;
	
	@FindBy(id="chkSelectS1")
	@CacheLookup
	WebElement shoplocation;
	
	@FindBy(id="cmdSelectLocation")
	@CacheLookup
	WebElement locationok;
	
	@FindBy(xpath="//body[1]/form[1]/div[5]/table[1]/tbody[1]/tr[1]/td[2]/div[2]/div[1]/div[1]/nav[1]/ul[1]/li[1]/div[1]")
	@CacheLookup
	WebElement salesandreturn;
	
	
	
	
	
	
	
	
	public void Startbutton()
	{
		startbtn.click();
	}
	
	public void Setupclick()
	{
		clickElement(setup);
		setup.click();
	}
	
	public void RetailSetupclick()
	{
		retailsetup.click();
	}
	
	public void itemSetupclick()
	{
		itemdrpdwn.click();
	}
	
	public void Retailclick()
	{
		retail.click();
		
	}
	
	public void locationclick()
	{
		clickElement(location);
		location.click();
		
	}
	
	public void shoplocationselect()
	{
		shoplocation.click();
		
	}
	
	public void submitlocation()
	{
		locationok.click();
		
	}
	
	public void salesandreturnexpand()
	{
		salesandreturn.click();
		
	}
	
	
	
	
	
}
