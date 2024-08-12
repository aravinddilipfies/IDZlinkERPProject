package com.idzlink.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.idzlink.utilities.AbstractComponents;

public class ItemMaster extends AbstractComponents {
	
	WebDriver ldriver;
	public ItemMaster(WebDriver rdriver)
	{
		super(rdriver);
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	//item master
	@FindBy(xpath="//li[@class='loadinterface']//span[@class='maincatName'][normalize-space()='Item']")
	@CacheLookup
	WebElement itembtn;
	
	//item describtion
	@FindBy(id="txtDescription")
	@CacheLookup
	WebElement itemdesc;
	
	//item category dropdown 
	@FindBy(id="ddlCategory")
	@CacheLookup
	WebElement itemcat;
	
	//item unit dropdown 
	@FindBy(id="ddlUnit")
	@CacheLookup
	WebElement itemunit;
	
	//item tax dropdown
	@FindBy(id="ddlTaxCategory")
	@CacheLookup
	WebElement itemtax;
	
	//item cp
	@FindBy(id="txtCostPrice")
	@CacheLookup
	WebElement itemcp;
	
	//advance button
	@FindBy(css=".separator")
	@CacheLookup
	WebElement advnce;
	
	//item sp textbox
	@FindBy(id="txtSellingPrice")
	@CacheLookup
	WebElement itemsp;
	
	//item packing type dropdown
	@FindBy(id="ddlPackingType")
	@CacheLookup
	WebElement itempkt;
	
	//item pkt checkbox
	@FindBy(id="cbBasePackingType")
	@CacheLookup
	WebElement itembasepkt;
	
	//item shop check box
	@FindBy(css=".shopchckbox.clsshop1")
	@CacheLookup
	WebElement itemshp;
	
	//item submit button
	@FindBy(id="btnSubmit")
	@CacheLookup
	WebElement itemsub;
	
	@FindBy(xpath="//div[@id='Div1']//div[@class='row']//div[1]//div[2]//span[1]//button[1]")
	@CacheLookup
	WebElement pktrefresh;
	
	
	@FindBy(id="btnPackingType")
	@CacheLookup
	WebElement itemadddetails;
	
	
	
	public void itemmasteropen()
	{
		
		itembtn.click();
	}
	
	public void Itemsave(String description, int categoryIndex, int unitIndex, int taxCategoryIndex, String costPrice, String sellingPrice,int packingTypeIndex) throws InterruptedException 
	{
        
		
		Thread.sleep(2000);
        itemdesc.clear();
        itemdesc.sendKeys(description);

        selectDropdownByIndex(itemcat, categoryIndex);
        selectDropdownByIndex(itemunit, unitIndex);
        Thread.sleep(1000);
        selectDropdownByIndex(itemtax, taxCategoryIndex);
        Thread.sleep(1000);

        itemcp.clear();
        itemcp.sendKeys(costPrice);

        advnce.click();

        itemsp.clear();
        itemsp.sendKeys(sellingPrice);
        
        
        scrolltomiddle(driver);
        Thread.sleep(2000);
        
        pktrefresh.click();
        selectDropdownByIndex(itempkt,packingTypeIndex);
        

        clickElement(itembasepkt);
        itembasepkt.click();
        clickElement(itemadddetails);
        itemadddetails.click();
        
        
        clickElement(itemshp);
        itemshp.click();

        scrolltotop(driver);
        Thread.sleep(1000);
        
        clickElement(itemsub);
        itemsub.click();
    }
	
	
	
	

}

    // Helper method to select an option from a dropdown by index
   

   
    

	
	
	
	
	
	
	
	
	
	
	
	
	


