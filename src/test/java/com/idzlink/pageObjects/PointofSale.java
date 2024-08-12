package com.idzlink.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.idzlink.utilities.AbstractComponents;

public class PointofSale extends AbstractComponents {

	WebDriver ldriver;
	public PointofSale(WebDriver rdriver)
	{
		super(rdriver);
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//ul[@class='CategoryMain level1']//span[@class='maincatName'][normalize-space()='Point of Sales']")
	@CacheLookup
	WebElement posEle;
	
	@FindBy(xpath="//div[@class='counterCover']")
	@CacheLookup
	WebElement contEle;
	
	@FindBy(xpath="//input[@value='OK']")
	@CacheLookup
	WebElement counterok;
	
	@FindBy(id="Counter")
	@CacheLookup
	WebElement counterlogoutele;

	@FindBy(xpath="//span[@class='btn btn-primary logoutCounter']//i[@class='fa fa-sign-out']")
	@CacheLookup
	WebElement logoutcounter;
	
	@FindBy(xpath = "//li[@class='col-md-4 col-sm-6 col-xs-6 ']//div[@class='counterCover']")
	List<WebElement> counters;
	
	@FindBy(css = ".tilecommon")
	List<WebElement> items;
	
	@FindBy(id="btnEnter")
	@CacheLookup
	WebElement okbtn;
	
	@FindBy(css = ".cart-item-price")
	List<WebElement> priceElements;
	
	@FindBy(css=".cart-finalAmt")
	@CacheLookup
	WebElement finalamt;
	
	
	@FindBy(css=".checkout-dtls-right")
	@CacheLookup
	WebElement checkoutbtn;
	
	@FindBy(css=".checkoutbtns.btnCheckOutCash")
	@CacheLookup
	WebElement cashbtn;
	
	@FindBy(xpath="//div[@class='alertcontent']//span[2]")
	@CacheLookup
	WebElement successfulpopup;
	
	
	@FindBy(xpath="//span[@class='messagePopUpClose']")
	@CacheLookup
	WebElement cloasepopupbtn;
	
	@FindBy(xpath="//i[@class='fa fa-search']")
	@CacheLookup
	WebElement searchicon;
	
	@FindBy(xpath="//input[@id='btnSearch']")
	@CacheLookup
	WebElement searchbtn;
	
	@FindBy(xpath="//span[@class='btn btn-default search-edit'][1]")
	@CacheLookup
	WebElement editbtn;
	
	
	@FindBy(xpath="//span[@class='search-close search-toggle']")
	@CacheLookup
	WebElement closebtn;
	
	
	
	
	
	public void Posopen()
	{
		posEle.click();
	}
	
	public void counterselection()
	{
	/*	contEle.click();
		counterok.click();*/
		for(WebElement counter :counters)
		{
			if(counter.isEnabled())
			{
				counter.click();
				break;
			}
		}
		
		counterok.click();
		
	}
	
	public void itemselection()
	{
		for(WebElement item: items)
		{
			item.click();
			okbtn.click();
			okbtn.click();
		}
		
	}
	
	
	public double  calculationcheck()
	{
		double totalPrice = 0;
        for (WebElement element : priceElements) {
            String priceText = element.getText();
            double price = Double.parseDouble(priceText); // Adjust the replacement as per your price format
            totalPrice += price;
        }	
        return totalPrice;
	}
	
	public double FinalAmount()
	{
		String Total=finalamt.getText();
		double amt=Double.parseDouble(Total);
		return amt;
		
	}
	
	public void checkout() throws InterruptedException
	{
		checkoutbtn.click();
		clickElement(cashbtn);
		Thread.sleep(2000);
		cashbtn.click();
	}
	
	public String SuccessfullMessage()
	
	{
		return successfulpopup.getText();
	}
	
	
	public void conterlogout()
	{
		counterlogoutele.click();
		clickElement(logoutcounter);
		logoutcounter.click();
	}
	
	
	public void closebtn()
	{
		cloasepopupbtn.click();
	}
	
	
	public void search() throws InterruptedException
	{
		clickElement(searchicon);
		searchicon.click();
		Thread.sleep(1000);
		waitForWebElementToAppear(searchbtn);
		searchbtn.click();
		
	}
	
	public void editbutton()
	{
		clickElement(editbtn);
		editbtn.click();
		
		closebtn.click();
	}
	
	
	//ul[@class='CategoryMain level1']//span[@class='maincatName'][normalize-space()='Point of Sales']
	
	
	
	
	
	//ul[@class='CategoryMain level1']//span[@class='maincatName'][normalize-space()='Point of Sales']
	
}
