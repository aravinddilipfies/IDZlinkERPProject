package com.idzlink.pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
	
	@FindBy(xpath="//i[@class='fa fa-angle-down']")
	@CacheLookup
	WebElement itemdropdown1;
	
	@FindBy(xpath="//input[@value='1']")
	@CacheLookup
	WebElement quantity;
	
	@FindBy(id="Totalmrf")
	@CacheLookup
	WebElement totalamount;
	
	@FindBy(xpath="//input[@id='checkconfirmation']")
	@CacheLookup
	WebElement confirmfinished;
	
	@FindBy(xpath="//i[@class='fa fa-search']")
	@CacheLookup
	WebElement clicksearch;
	
	@FindBy(id="btnSearch")
	@CacheLookup
	WebElement searchbutton;
	
	@FindBy(id="btnEdit")
	@CacheLookup
	WebElement editbutton;
	
	@FindBy(xpath="//div[@id='wrapper']//div[@class='toggled']//div[2]//div[2]//span[2]//i[1]")
	@CacheLookup
	WebElement deletebutton;
	
	@FindBy(xpath="//body[1]/form[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[3]/div[1]/div[1]/input[1]")
	@CacheLookup
	WebElement deletebuttontext1;
	
	@FindBy(id="okbtn")
	@CacheLookup
	WebElement deleteokbutton;
	
	@FindBy(id="Sperid")
	@CacheLookup
	WebElement quptationnumber;
	
	@FindBy(id="itemUnitPrice")
	@CacheLookup
	WebElement actualpricesalesquotation;
	
	@FindBy(id="UnitItemTax")
	@CacheLookup
	WebElement taxamountsalesquotation;
	
	@FindBy(xpath="//i[@class='fa fa-refresh']")
	@CacheLookup
	WebElement refreshbutton;
	
	@FindBy(id="txtItemSearch")
	@CacheLookup
	WebElement txtsearch;
	
	@FindBy(xpath="//body/form[@id='form1']/div/div[@id='wrapper']/div[@id='page-content-wrapper']/div[@class='row']/div[@class='col-md-12 col-sm-12 col-xs-12']/div[@id='QuotationItemsView']/div[@class='col-md-12']/div[@class='tab-content']/div[@id='OrderTab']/div[@class='panel panel-default']/div[@id='AddItemBody']/div[@id='posItemcartdetails']/div[@class='col-md-7 col-sm-12 col-xs-12 col-lg-7 nopadding']/div[@id='posItemdetails']/div[1]/div[1]")
	@CacheLookup
	WebElement searcheditem;
	
	@FindBy(xpath="//*[@id=\"posItemcartdetails\"]/div[1]/div/div/div[2]/div[2]/div/input")
	@CacheLookup
	WebElement rate;
	
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
	public void itemdropdown()
	{
		itemdropdown1.click();
	}
	public void quantity()
	{
		quantity.sendKeys("2");
	}
	
	public void checkbox()
	{
		super.scrollToElement(confirmfinished);
		confirmfinished.click();
	}
	
	
	public String gettotalamount()
	{
		super.scrollToElement(totalamount);
		return totalamount.getAttribute("value");
		
	}
	public void searchicon()
	{
		clicksearch.click();
	}
	public void searchbuttonfield()
	{
		searchbutton.click();
	}
	public void editbuttonfunction()
	{
		editbutton.click();
	}
	
public void shortcutforsave()
{
	Actions action=new Actions(driver);
	action.keyDown(Keys.ALT).sendKeys("S").keyUp(Keys.ALT).perform();
}
	
	public void deletebuttonfield()  // delete icon
	{
		deletebutton.click();
	}
	public void textdeletwarningmessage()   //delete remarks
	{
		deletebuttontext1.sendKeys("remarks");
	}
	
	public void dletewarningokbutton()  //delete ok button
	{
		deleteokbutton.click();
	}
	
	public String quotationnumberfield()
{
	return	quptationnumber.getText();
}
	
	public String salesquotationactualamount()
	{
		super.scrollToElement(actualpricesalesquotation);
		return actualpricesalesquotation.getText();
		
	}
	
	public String salesquotationtaxamount()
	{
		super.scrollToElement(taxamountsalesquotation);
		return taxamountsalesquotation.getText();
		
	}
		
	public void buttonrefresh()
	{
		refreshbutton.click();
	}
	
	public void searchtext()
	{
		txtsearch.sendKeys("Samsung");
		txtsearch.sendKeys(Keys.ENTER);
		
	}
	
	public void itemsearched()
	{
		searcheditem.click();
	}
	
	public void ratesearch() throws InterruptedException
	{
		txtsearch.sendKeys("28");
		txtsearch.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		searcheditem.click();
		Thread.sleep(1000);
		itemdropdown1.click();
		Thread.sleep(1000);
		//rate.click();
		scrollToElement(rate);
		//rate.click();
		
		  Actions actions = new Actions(driver);

	        // Perform double-click action
	        actions.doubleClick(rate).perform();
		
		
		
	//	Thread.sleep(2000);
	//	rate.clear();
		Thread.sleep(1000);
		rate.sendKeys("9");
		Thread.sleep(1000);
		quantity.click();
	}
	
	public void mrpsearch() throws InterruptedException
	{
		txtsearch.sendKeys("26");
		txtsearch.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		searcheditem.click();
		Thread.sleep(1000);
		itemdropdown1.click();
		Thread.sleep(1000);
		scrollToElement(rate);
		 Actions actions = new Actions(driver);

	        // Perform double-click action
	        actions.doubleClick(rate).perform();
	        Thread.sleep(2000);
			rate.sendKeys("501");
	}
}
