package com.idzlink.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.idzlink.utilities.AbstractComponents;

public class CustomerPage extends AbstractComponents  {

	WebDriver ldriver;
	//ldriver - local driver  rdriver - remote driver
	
	public CustomerPage(WebDriver rdriver)
	{
		super(rdriver);
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//ul[@class='CategoryMain level1']//span[@class='maincatName'][normalize-space()='Customer']")
	@CacheLookup
	WebElement customerbtn;
	
	@FindBy(id="txtCustomerName")
	@CacheLookup
	WebElement customername;
	
	@FindBy(xpath="//input[@id='ddlCustomercategoryId']")
	@CacheLookup
	WebElement cuscategory;
	
	@FindBy(xpath="//select[@id='ddlCountryId']")
	@CacheLookup
	WebElement drpcountry;
	
	@FindBy(xpath="//select[@id='ddlCityId']")
	@CacheLookup
	WebElement drpcity;
	
	@FindBy(xpath="//select[@id='ddlCurrencyId']")
	@CacheLookup
	WebElement drpcurrency;
	
	@FindBy(xpath="//select[@id='ddlCustomerGroupcategoryId']")
	@CacheLookup
	WebElement drpGroup;
	
	@FindBy(xpath="//select[@id='ddlDebtorAcId']")
	@CacheLookup
	WebElement drpDebtorAcc;
	
	@FindBy(xpath="//input[@id='txtEmailID']")
	@CacheLookup
	WebElement txtemail;
	
	@FindBy(xpath="//i[@class='fa fa-check']")
	@CacheLookup
	WebElement savebtn;
	
	@FindBy(xpath="//i[@class='fa fa-search']")
	@CacheLookup
	WebElement searchicon;
	
	@FindBy(xpath="//input[@id='btnSearch']")
	@CacheLookup
	WebElement searchbtn;
	
	@FindBy(xpath="//input[@id='txtsearchName']")
	@CacheLookup
	WebElement txtsearch;
			
	@FindBy(xpath="//span[@id='btnEdit']")
	@CacheLookup
	WebElement editbtn;
	
	
			
			
	
	
	
	public void Customermaster()
	{
		clickElement(customerbtn);
		customerbtn.click();
	}
	
	
	public void setCustomerName(String cname)
	{
		waitForElementToBeVisible(customername);
		customername.sendKeys(cname);
	}
	
	public void Customercategory(String cuscat)
	{
		cuscategory.sendKeys(cuscat);
	}
	
	public void CustomerCountry(int country_index)
	{
		
		/*clickElement(drpcountry);
		Select country=new Select(drpcountry);
		country.selectByIndex(country_index);*/
		  try {
	            clickElement(drpcountry); // Assuming clickElement method waits for element to be clickable
	            Select countrys = new Select(drpcountry);
	            countrys.selectByIndex(country_index);
	            System.out.println("Selected country at index " + country_index);
	        } catch (Exception e) {
	            System.out.println("Exception occurred while selecting country: " + e.getMessage());
	            e.printStackTrace();
	        }
		
	}
	
	public void CustomerCity(int city_index)
	{
	/*	clickElement(drpcity);
		Select city=new Select(drpcity);
		city.selectByIndex(city_index); */
		
		try {
            clickElement(drpcity); // Assuming clickElement method waits for element to be clickable
            Select citys = new Select(drpcity);
            citys.selectByIndex(city_index);
            System.out.println("Selected City at index " + city_index);
        } catch (Exception e) {
            System.out.println("Exception occurred while selecting country: " + e.getMessage());
            e.printStackTrace();
        }
	}
	
	public void CustomerCurrency(int currency_index)
	{
		
		try {
            clickElement(drpcurrency); // Assuming clickElement method waits for element to be clickable
            Select currencys = new Select(drpcurrency);
            currencys.selectByIndex(currency_index);
            System.out.println("Selected City at index " + currency_index);
        } catch (Exception e) {
            System.out.println("Exception occurred while selecting country: " + e.getMessage());
            e.printStackTrace();
        }
		
		/*clickElement(drpcurrency);
		Select currencys=new Select(drpcurrency);
		currencys.selectByIndex(currency_index); */
	}
	
	public void CustomerGroup(int Group_index)
	{
	/*	clickElement(drpGroup);
		Select customerGroups=new Select(drpGroup);
		customerGroups.selectByIndex(Group_index);
		*/
		try {
            clickElement(drpGroup); // Assuming clickElement method waits for element to be clickable
            Select customerGroups = new Select(drpGroup);
            customerGroups.selectByIndex(Group_index);
            System.out.println("Selected City at index " + Group_index);
        } catch (Exception e) {
            System.out.println("Exception occurred while selecting country: " + e.getMessage());
            e.printStackTrace();
        }
	}
	
	public void CustomerDebtoracc(int Debtor_index)
	{
	/*	clickElement(drpGroup);
		Select customerDebtoraccs=new Select(drpDebtorAcc);
		country.selectByIndex(Debtor_index);  */
		
		
		try {
            clickElement(drpDebtorAcc); // Assuming clickElement method waits for element to be clickable
            Select customerGroups = new Select(drpDebtorAcc);
            customerGroups.selectByIndex(Debtor_index);
            System.out.println("Selected City at index " + Debtor_index);
        } catch (Exception e) {
            System.out.println("Exception occurred while selecting country: " + e.getMessage());
            e.printStackTrace();
        }
	}
	
	public void setCustomerEmail(String cemail)
	{
		txtemail.sendKeys(cemail);
	}
	
	public void Customersave()
	{
		clickElement(savebtn);
		savebtn.click();
	}
	
	public void Customerserachicon()
	{
		clickElement(searchicon);
		searchicon.click();
	}
	
	public void Customerserachbtn()
	{
		clickElement(searchbtn);
		searchbtn.click();
	}
	
	
	
	public void CustomerEditicon()
	{
		clickElement(editbtn);
		editbtn.click();
	}
	
	public String getCustomerName()
	{
		waitForWebElementToAppear(customername);
		 return customername.getAttribute("value");
	}
	
	public void Customersearch(String csearchname)
	{
		
		waitForElementToBeVisible(txtsearch);
		txtsearch.sendKeys(csearchname);
	}
	
	
	
	
	
	
	
}
