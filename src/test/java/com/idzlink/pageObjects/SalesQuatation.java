package com.idzlink.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.idzlink.utilities.AbstractComponents;

public class SalesQuatation extends AbstractComponents{

	WebDriver ldriver;
	public SalesQuatation(WebDriver rdriver)
	{
		super(rdriver);
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//span[@class='maincatName'][normalize-space()='Sales Quotation']")
	@CacheLookup
	WebElement salesquatation;
	
	
	@FindBy(xpath="//button[@data-id='customer']")
	@CacheLookup
	WebElement customerselection;
	
	
	@FindBy(xpath="//div[@class='btn-group bootstrap-select form-control mandatory SelCust open']//input[@type='text']")
	@CacheLookup
	WebElement customertextbox;
	
	
	@FindBy(xpath="//span[@class='text'][normalize-space()='Customer---->RUFIYA']")
	@CacheLookup
	WebElement customerdropdown;
	
	
	
	@FindBy(xpath="//body[1]/form[1]/div[3]/div[1]/div[1]/div[4]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[2]/div[3]/div[1]/div[1]/div[2]/div[6]")
	@CacheLookup
	WebElement item1;
	
	@FindBy(xpath="//textarea[@id='remarks']")
	@CacheLookup
	WebElement remakrs;
	
	
	@FindBy(xpath="//i[@class='fa fa-check']")
	@CacheLookup
	WebElement submitbtn;
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void opensalesquatation()
	{
		salesquatation.click();
	}
	
	
	public void  customerselection()
	{
		customerselection.click();
	}
	
	public void customernameenter(String customername)
	{
		customertextbox.sendKeys(customername);
		
		customerdropdown.click();
		
	}
	
	
	public void additem()
	{
		super.scrollToElement(item1);
		item1.click();
	}
	
	public void remarksenter()
	{
		remakrs.sendKeys("remarks");
	}
	
	public void submit()
	{
		submitbtn.click();
	}
	
	
}
