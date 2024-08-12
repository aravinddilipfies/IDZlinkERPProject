package com.idzlink.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.idzlink.utilities.AbstractComponents;

public class Unit extends AbstractComponents {

	
	WebDriver ldriver;
	public Unit(WebDriver rdriver)
	{	super(rdriver);
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//span[@class='maincatName'][normalize-space()='Unit']")
	@CacheLookup
	WebElement Unitbtn;
	
	@FindBy(id="txtcode")
	@CacheLookup
	WebElement Unitcodeele;
	
	@FindBy(id="txtname")
	@CacheLookup
	WebElement unittxtnameele;
	
	@FindBy(xpath="//i[@class='fa fa-check']")
	@CacheLookup
	WebElement unitsubbtn;
	
	public void UnitmasterOpen()
	{
		Unitbtn.click();
	}
	
	public void Unitsave(String ucode,String uname)
	{
		waitForWebElementToAppear(Unitcodeele);
		Unitcodeele.sendKeys(ucode);
		waitForWebElementToAppear(unittxtnameele);
		unittxtnameele.sendKeys(uname);
		unitsubbtn.click();
			
		
	}
	
	
	
	
	
	
	
}
