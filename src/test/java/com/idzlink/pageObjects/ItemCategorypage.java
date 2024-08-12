package com.idzlink.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.idzlink.utilities.AbstractComponents;

public class ItemCategorypage extends AbstractComponents {

	WebDriver ldriver;
	//ldriver - local driver  rdriver - remote driver
	
	public ItemCategorypage(WebDriver rdriver)
	{
		super(rdriver);
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	//span[@class='maincatName'][normalize-space()='Item Category']
	
	@FindBy(xpath="//span[@class='maincatName'][normalize-space()='Item Category']")
	@CacheLookup
	WebElement itemcategorybtn;
	
	
	@FindBy(xpath="//input[@id='txtcode']")
	@CacheLookup
	WebElement itemcategorycode;
	
	
	
	@FindBy(xpath="//select[@id='ddlparent']")
	@CacheLookup
	WebElement itemmaincat;
	
	@FindBy(xpath="//textarea[@id='txtdesc']")
	@CacheLookup
	WebElement itemdes;
	

	@FindBy(xpath="//select[@id='ddltaxcategory']")
	@CacheLookup
	WebElement itemcattax;
	
	@FindBy(xpath="//input[@class='shopchckbox clsshop1']")
	@CacheLookup
	WebElement shopsele;
	
	@FindBy(xpath="//i[@class='fa fa-check']")
	@CacheLookup
	WebElement itemcatsavebtn;

	
	public void ItemCategoryMaster()
	{
		itemcategorybtn.click();
		
	}
	
	
	public void ItemCategorycode(String code)
	{
		itemcategorycode.sendKeys(code);
	}
	
	
	public void Maincatselection(int maincat_index)
	{
		/*Select main=new Select(itemmaincat);
		main.selectByIndex(maincat_index); */
		
		 try {
	            clickElement(itemmaincat); // Assuming clickElement method waits for element to be clickable
	            Select countrys = new Select(itemmaincat);
	            countrys.selectByIndex(maincat_index);
	            System.out.println("Selected Maincatselection at index " + maincat_index);
	        } catch (Exception e) {
	            System.out.println("Exception occurred while selecting Maincatselection: " + e.getMessage());
	            e.printStackTrace();
	        }
		
	}
	
	public void ItemCategoryDescription(String des)
	{
		itemdes.sendKeys(des);
	}
	
	public void itemcattaxselection(int itemcattax_index)
	{
		/*Select tax=new Select(itemcattax);
		tax.selectByIndex(itemcattax_index); */
		
		try {
            clickElement(itemcattax); // Assuming clickElement method waits for element to be clickable
            Select countrys = new Select(itemcattax);
            countrys.selectByIndex(itemcattax_index);
            System.out.println("Selected itemcattaxselection at index " + itemcattax_index);
        } catch (Exception e) {
            System.out.println("Exception occurred while selecting itemcattaxselection " + e.getMessage());
            e.printStackTrace();
        }
	}
	
	public void ItemCategoryShopSelection()
	{
		shopsele.click();
	}
	
	public void ItemCategorysubmite()
	{
		itemcatsavebtn.click();
	}
	
	
	
	
}
