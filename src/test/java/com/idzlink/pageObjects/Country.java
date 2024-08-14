package com.idzlink.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.idzlink.utilities.AbstractComponents;

public class Country extends AbstractComponents {

	WebDriver ldriver;
	
	public Country(WebDriver rdriver)
	{
		super(rdriver);
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//ul[@class='CategoryMain level1']//span[@class='maincatName'][normalize-space()='Country']")
	@CacheLookup
	WebElement Contrymenu;
	
	
	
	@FindBy(id="txtCountryCode")
	@CacheLookup
	WebElement contrycodeelement;
	
	
	@FindBy(id="txtCountryName")
	@CacheLookup
	WebElement contryname;
	
	@FindBy(xpath="//input[@id='txtCountryTelephoneCode']")
	@CacheLookup 
	WebElement contrytele;
	
	@FindBy(xpath="//i[@class='fa fa-check']")
	@CacheLookup 
	WebElement submitbtn;
	
	
	
	
	public void countrymasteropen()
	{
		Contrymenu.click();
	}
	
	
	public void countrycode(String code)
	{
		contrycodeelement.sendKeys(code);
	}
	
	public void countryname(String name)
	{
		contryname.sendKeys(name);
	}
	
	public void countrytelephonecode(String phonecode)
	{
		contrytele.sendKeys(phonecode);	
	}
	
	public void submit()
	{
		submitbtn.click();
	}
	
	
	
	
	
	
	
	
}
