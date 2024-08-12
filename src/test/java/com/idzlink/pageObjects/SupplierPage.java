package com.idzlink.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.idzlink.utilities.AbstractComponents;

public class SupplierPage extends AbstractComponents  {

	WebDriver ldriver;
	//ldriver - local driver  rdriver - remote driver
	
	public SupplierPage(WebDriver rdriver)
	{
		super(rdriver);
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//ul[@class='CategoryMain level1']//span[@class='maincatName'][normalize-space()='Supplier']")
	@CacheLookup
	WebElement supplierbtn;
	
	@FindBy(xpath="//select[@id='ddlVendorGroup']")
	@CacheLookup
	WebElement suppgrp;

	@FindBy(xpath="//select[@id='ddlCountry']")
	@CacheLookup
	WebElement suppcountry;
	
	@FindBy(xpath="//input[@id='txtVendorName']")
	@CacheLookup
	WebElement suppname;
	
	@FindBy(xpath="//select[@id='ddlCurrency']")
	@CacheLookup
	WebElement suppcurr;
	
	@FindBy(xpath="//select[@id='ddlCity']")
	@CacheLookup
	WebElement suppcity;
	
	@FindBy(xpath="//select[@id='ddlCreditAC']")
	@CacheLookup
	WebElement suppacc;
	
	@FindBy(css=".shopchckbox")
	@CacheLookup
	WebElement suppchk;
	
	@FindBy(xpath="//i[@class='fa fa-check']")
	@CacheLookup
	WebElement suppsub;
	

	@FindBy(xpath="//i[@class='fa fa-search']")
	@CacheLookup
	WebElement vendsearchicon;
	
	@FindBy(xpath="//input[@id='btnSearch']")
	@CacheLookup
	WebElement vensearchbtn;
	
	@FindBy(xpath="//input[@id='txtSearchName']")
	@CacheLookup
	WebElement ventxtsearch;
			
	@FindBy(xpath="//span[@class='editBtn btn btn-default']")
	@CacheLookup
	WebElement veneditbtn;
	
			
			
	
	
	
	public void Suppliermaster()
	{
		clickElement(supplierbtn);
		supplierbtn.click();
	}
	
	public void SupplierGroup(int grpindex)
	{
		/*Select sgrp=new Select(suppgrp);
		sgrp.selectByIndex(grpindex);*/
		try {
            clickElement(suppgrp); // Assuming clickElement method waits for element to be clickable
            Select countrys = new Select(suppgrp);
            countrys.selectByIndex(grpindex);
            System.out.println("Selected Group at index " + grpindex);
        } catch (Exception e) {
            System.out.println("Exception occurred while selecting Group: " + e.getMessage());
            e.printStackTrace();
        }
	}
	
	public void SupplierCountry(int conindex)
	{
		/*Select scountry=new Select(suppcountry);
		scountry.selectByIndex(conindex);*/
		try {
            clickElement(suppcountry); // Assuming clickElement method waits for element to be clickable
            Select countrys = new Select(suppcountry);
            countrys.selectByIndex(conindex);
            System.out.println("Selected country at index " + conindex);
        } catch (Exception e) {
            System.out.println("Exception occurred while selecting country: " + e.getMessage());
            e.printStackTrace();
        }
	}
	
	public void SupplierCity(int scityindex)
	{
		/*Select scity=new Select(suppcity);
		scity.selectByIndex(scityindex);*/
		try {
            clickElement(suppcity); // Assuming clickElement method waits for element to be clickable
            Select countrys = new Select(suppcity);
            countrys.selectByIndex(scityindex);
            System.out.println("Selected City at index " + scityindex);
        } catch (Exception e) {
            System.out.println("Exception occurred while selecting City: " + e.getMessage());
            e.printStackTrace();
        }
	}
	
	
	
	public void setsupplierName(String sname)
	{
		suppname.sendKeys(sname);
	}
	
	public void SupplierCurrency(int currindex)
	{
	/*	Select scurrency=new Select(suppcurr);
		scurrency.selectByIndex(currindex); */
		
		try {
            clickElement(suppcurr); // Assuming clickElement method waits for element to be clickable
            Select countrys = new Select(suppcurr);
            countrys.selectByIndex(currindex);
            System.out.println("Selected Currency at index " + currindex);
        } catch (Exception e) {
            System.out.println("Exception occurred while selecting Currency: " + e.getMessage());
            e.printStackTrace();
        }
		
	}
	
	public void SuppliercreditAC(int scredit)
	{
		/* Select screditac=new Select(suppacc);
		screditac.selectByIndex(scredit); */
		
		try {
            clickElement(suppacc); // Assuming clickElement method waits for element to be clickable
            Select countrys = new Select(suppacc);
            countrys.selectByIndex(scredit);
            System.out.println("Selected SuppliercreditAC at index " + scredit);
        } catch (Exception e) {
            System.out.println("Exception occurred while selecting SuppliercreditAC: " + e.getMessage());
            e.printStackTrace();
        }
		
	}
	
	public void SupplierShop()
	{
		suppchk.click();
	}
	
	public void SupplierSubmit()
	{
		suppsub.click();
	}
	
	public void vendorserachicon()
	{
		vendsearchicon.click();
	}
	
	public void vendorserachbtn()
	{
		vensearchbtn.click();
	}
	
	
	
	public void vendorEditicon()
	{
		veneditbtn.click();
	}
	
	public String getvendorName()
	{
		 return suppname.getAttribute("value");
	}
	
	public void vendorsearch(String vsearchname)
	{
		ventxtsearch.sendKeys(vsearchname);
	}
}
