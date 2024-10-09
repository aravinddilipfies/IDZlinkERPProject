package com.idzlink.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.idzlink.utilities.AbstractComponents;

public class Salesquotation extends AbstractComponents {
	
	WebDriver ldriver;
	
	public Salesquotation(WebDriver rdriver)
	{
		super(rdriver);
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}

	
	@FindBy(xpath="//span[@class='maincatName'][normalize-space()='Sales Quotation']")
	@CacheLookup
	WebElement Salesquotation;
	
	
	@FindBy(id="customer")
	@CacheLookup
	WebElement cus;
	
}
