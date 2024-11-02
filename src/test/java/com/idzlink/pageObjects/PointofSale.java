package com.idzlink.pageObjects;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

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
	
	@FindBy(xpath="//span[normalize-space()='Updated Successfully.']")
	@CacheLookup
	WebElement updatesuccessfullpopup;
	
	@FindBy(id="btnDelete")
	@CacheLookup
	WebElement deletebtn;
	
	
	@FindBy(id="txtCancelledRemarks")
	@CacheLookup
	WebElement deleteremarks;
	
	@FindBy(id="btnDeleteOk")
	@CacheLookup
	WebElement deleteokbtn;
	
	@FindBy(xpath="//span[@id='Cancelled']")
	@CacheLookup
	WebElement cancelled;
	
	@FindBy(xpath="//input[@id='txtItemSearch']")
	@CacheLookup
	WebElement itemsearchtxt;
	
	
	@FindBy(xpath="//span[@id='cartArrow']")
	@CacheLookup
	List<WebElement> itemcartarrows;
	
	@FindBy(xpath="//li[@id='1']//i[@id='arrow']")
	@CacheLookup
	WebElement firstcartarrow;
	
	
	
	@FindBy(xpath="//input[@id='UnitPrice']")
	@CacheLookup
	List<WebElement> UnitPrices;
	
	@FindBy(xpath="//span[@id='UnitItemTax']")
	@CacheLookup
	List<WebElement> UnitItemTaxes;
	
	@FindBy(xpath="//div[@class='Totalrow']//div//span[@id='totalTax']")
	@CacheLookup
	WebElement totaltax;
	
	@FindBy(xpath="//div[@class='addcustomer-row']")
	@CacheLookup
	WebElement customerselectionbtn;
	
	@FindBy(xpath="//select[@id='ddlCustomer']")
	@CacheLookup
	WebElement customerdropdown;
	
	@FindBy(xpath="//input[@id='txtname']")
	@CacheLookup
	WebElement name;
	
	@FindBy(xpath="//input[@id='txtEmail']")
	@CacheLookup
	WebElement email;
	
	@FindBy(xpath="//input[@id='txtTIN']")
	@CacheLookup
	WebElement tin;
	
	@FindBy(xpath="//span[@class='btn btn-primary btn-continue-cust']")
	@CacheLookup
	WebElement continuebtn;
	
	
	@FindBy(xpath="//i[@class='fa fa-download']")
	@CacheLookup
	WebElement downloadquotationbutton;
	
	@FindBy(xpath="//div[@class='modal-body text-center quotation-details quotationData']//div[1]//div[3]")
	@CacheLookup
	WebElement quatationselection;
	
	@FindBy(id="txtItemSearch")
	@CacheLookup
	WebElement itemsearchpos;
	
	@FindBy(xpath="//div[@class='tiledesc ItemDescription']")
	@CacheLookup
	List<WebElement> itemsearchlists;
	
	@FindBy(xpath="//div[@class='tiledesc ItemDescription']")
	@CacheLookup
	List<WebElement> itemlists;
	
	@FindBy(xpath="//label[normalize-space()='Discount']")
	@CacheLookup
	WebElement discount;
	
	@FindBy(id="btnDiscPerc")
	@CacheLookup
	WebElement discountpercentage;
	
	@FindBy(id="numpad-search")
	@CacheLookup
	WebElement discountpercentagetextbox;
	
	@FindBy(id="grandTotal")
	@CacheLookup
	WebElement grandtotals;
	
	@FindBy(id="cbxCredInvo")
	@CacheLookup
	WebElement creditbuttoncheckbox;
	
	@FindBy(id="ddlCustomer")
	@CacheLookup
	WebElement creditcustomerselection;
	
	@FindBy(xpath="//span[normalize-space()='Credit']")
	@CacheLookup
	WebElement creditbtn;
	
	@FindBy(id="btnPrice")
	@CacheLookup
	WebElement pricebtn;
	
	@FindBy(id="numpad-search")
	@CacheLookup
	WebElement numpadpricesearch;
	
	
	@FindBy(xpath="//div[@class='alertcontent']//span[2]")
	@CacheLookup
	WebElement costpricealertbtn;
	
	@FindBy(xpath="//div[@class='alertcontent']//span[2]")
	@CacheLookup
	WebElement mrpalertbtn;
	
	@FindBy(xpath="//span[@class='glyphicon glyphicon-search']")
	@CacheLookup
	WebElement itemsearchicon;
	//span[@class='glyphicon glyphicon-search']
	
	
	public void Posopen()
	{
		posEle.click();
	}
	
	public void counterselection() throws InterruptedException
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
		
		Thread.sleep(3000);		
		itemsearchicon.click();
	}
	
	public void itemadd() throws InterruptedException
	{
		for(WebElement item: items)
		{
			scrollToElement(item);
			item.click();
			Thread.sleep(2000);
			okbtn.click();
			Thread.sleep(1000);
			okbtn.click();
			Thread.sleep(1000);
		}
		
	}
	
	
	public double  gettheitempricesum()
	{
		double totalPrice = 0;
        for (WebElement element : priceElements) {
            String priceText = element.getText();
            double price = Double.parseDouble(priceText); // Adjust the replacement as per your price format
            totalPrice += price;
        }	
        return totalPrice;
	}
	
	public float FinalAmount()
	{
		String Total=finalamt.getText();
		float amt=Float.parseFloat(Total);
		return amt;
		
	}
	
	public void checkout() throws InterruptedException
	{
		Thread.sleep(2000);
		scrollToElement(checkoutbtn);
		checkoutbtn.click();
		Thread.sleep(2000);
		clickElement(cashbtn);
		Thread.sleep(2000);
		cashbtn.click();
	}
	
	public String SuccessfullMessage() throws InterruptedException
	
	{
		
		return successfulpopup.getText();
	}
	
	
	public void conterlogout() throws InterruptedException
	{
		Thread.sleep(5000);
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
	
	
	public String updatesuccessfulmessage()
	
	{
		return updatesuccessfullpopup.getText();
	}
	
	public void additemsoneditmode()
	{
		for(WebElement item: items)
		{
			item.click();
			okbtn.click();
			
		}
	}
	
	
	public void deletepostransaction() throws InterruptedException
	{
		Thread.sleep(1000);
		waitForElementToBeVisible(deletebtn);
		deletebtn.click();
		deleteremarks.sendKeys("deleting pos transaction");
		clickElement(deleteokbtn);
		deleteokbtn.click();
		
	}
	
	public String cancelledvalidation() throws InterruptedException
	{
		Thread.sleep(1000);
		return cancelled.getText();
	}
	
	public void checkoutshortcutforcash() throws InterruptedException
	{
		Actions action=new Actions(driver);
		action.keyDown(Keys.ALT).sendKeys("S").keyUp(Keys.ALT).perform();
		Thread.sleep(2000);
		action.keyDown(Keys.ALT).sendKeys("H").keyUp(Keys.ALT).perform();
		
	}
	
	
	public void scrolltoTopofCart()
	{
		scrollToElement(firstcartarrow);
	}
	
	public Map<String, Float> calculateTotalPriceAndTax() throws InterruptedException {
	    float totalUnitPrice = 0.0f;
	    float totalUnitTax = 0.0f;

	    // External iterator for corresponding lists
	    Iterator<WebElement> priceIterator = UnitPrices.iterator();
	    Iterator<WebElement> taxIterator = UnitItemTaxes.iterator();

	    // Loop through each cart arrow using a for-each loop
	    for (WebElement cartArrow : itemcartarrows) {
	        // Click the cart arrow
	        cartArrow.click();
	        
	        Thread.sleep(1000);
	        // Get the unit price and tax using the iterators
	        if (priceIterator.hasNext() && taxIterator.hasNext()) {
	            String unitPriceText = priceIterator.next().getAttribute("value"); // Assuming value attribute holds the price
	            String unitTaxText = taxIterator.next().getText();

	            // Convert the text to float
	            try {
	                float unitPrice = Float.parseFloat(unitPriceText);
	                float unitTax = Float.parseFloat(unitTaxText);

	                // Add the values to the total
	                totalUnitPrice += unitPrice;
	                totalUnitTax += unitTax;
	            } catch (NumberFormatException e) {
	                System.out.println("Failed to parse unit price or tax. Skipping item.");
	            }
	        }
	    }

	    // Calculate the sum of totalUnitPrice and totalUnitTax
	    float sum = totalUnitPrice + totalUnitTax;

	    // Create a map to store and return the results
	    Map<String, Float> result = new HashMap<>();
	    result.put("sum", sum);
	    result.put("totalUnitTax", totalUnitTax);

	    return result;
	}
	
	public String getTotalTax()
	{
		return totaltax.getText();
	}
	
	
	public void customerselection(String customername)
	{
		customerselectionbtn.click();
		
		Select customers = new Select(customerdropdown);

		// Get all options from the dropdown
		List<WebElement> allOptions = customers.getOptions();

		// Loop through each option and select the one that contains the desired substring
		for (WebElement option : allOptions)
		{
		    if (option.getText().contains(customername))
		    {
		        customers.selectByVisibleText(option.getText());
		        break;
		    }
		    
	}
	}
	
	public Map<String, String> customerfetch() throws InterruptedException
	{
		Thread.sleep(1000);
	String customername=	name.getAttribute("value");
	String customeremail=	email.getAttribute("value");
	String customertin=	tin.getAttribute("value");
	
	Map<String, String> customerInfo = new HashMap<>();
    customerInfo.put("name", customername);
    customerInfo.put("email", customeremail);
    customerInfo.put("tin", customertin);
    
    continuebtn.click();
    
    return customerInfo;
	
    
	}
	
	public void quptationbutton()
	{
		downloadquotationbutton.click();
	}
	
	public void selectionquotation()
	{
		quatationselection.click();
	}
	
	
	public void barcodesearch() throws InterruptedException
	
	{
		
		itemsearchpos.sendKeys("1800000021");
		itemsearchpos.sendKeys(Keys.ENTER);
		waitForWebElementToAppear(okbtn);
		okbtn.click();
		Thread.sleep(1000);
		okbtn.click();
		Thread.sleep(1000);
	}
	
public void itemcodesearch() throws InterruptedException
	
	{
		
		itemsearchpos.sendKeys("18");
		itemsearchpos.sendKeys(Keys.ENTER);
		waitForWebElementToAppear(okbtn);
		okbtn.click();
		Thread.sleep(1000);
		okbtn.click();
		Thread.sleep(1000);
	}
	
public void itemnamesearch() throws InterruptedException

{
	
	itemsearchpos.sendKeys("samsung s23");
	itemsearchpos.sendKeys(Keys.ENTER);
	System.out.println("item entered");
	
	Thread.sleep(2000);
	for (WebElement itemsearchlist : itemsearchlists) {
	    if (itemsearchlist.getText().contains("Samsung S23")) {
	        // Perform actions on the filtered item
	        System.out.println("Found Samsung S23: " + itemsearchlist.getText());
	        itemsearchlist.click(); // Example action
	    }
	}

	waitForWebElementToAppear(okbtn);
	okbtn.click();
	Thread.sleep(1000);
	okbtn.click();
	Thread.sleep(1000);
}

public void firstthreeitems() throws InterruptedException
{
	for (int i = 0; i < 3; i++) {
	    WebElement item = itemlists.get(i);
	    item.click();  // Click the item
	    System.out.println("Clicked item: " + item.getText());
	}
	waitForWebElementToAppear(okbtn);
	okbtn.click();
	Thread.sleep(1000);
	okbtn.click();
	Thread.sleep(1000);
	
	
}

public void discountapplying() throws InterruptedException
{
	discount.click();
	Thread.sleep(1000);
	discountpercentage.click();
	Thread.sleep(1000);
	discountpercentagetextbox.sendKeys("10");
	Thread.sleep(1000);
	okbtn.click();	
}

public String getgranttotal() throws InterruptedException
{
	Thread.sleep(1000);
	return grandtotals.getText();
}

public void Creditcustomersectionandcreditbox() throws InterruptedException
{
	customerselectionbtn.click();
	Thread.sleep(2000);
	creditbuttoncheckbox.click();
}

public void creditcustomerdropdownselection() throws InterruptedException
{
	//creditcustomerselection
	Thread.sleep(2000);
	Select customer=new Select(creditcustomerselection);
	customer.selectByVisibleText("credit customer--->RUFIYA");
	Thread.sleep(3000);
	continuebtn.click();
	
}

public void creditcheckout() throws InterruptedException {
	checkoutbtn.click();
	Thread.sleep(1000);
	creditbtn.click();
}

public void checkoutshortcutforcredit() throws InterruptedException
{
	Actions action=new Actions(driver);
	action.keyDown(Keys.ALT).sendKeys("S").keyUp(Keys.ALT).perform();
	Thread.sleep(2000);
	action.keyDown(Keys.ALT).sendKeys("T").keyUp(Keys.ALT).perform();
	
}


public void mrpitemadd() throws InterruptedException

{
	
	itemsearchpos.sendKeys("MRP");
	itemsearchpos.sendKeys(Keys.ENTER);
	System.out.println("item entered");
	
	Thread.sleep(3000);
	for (WebElement itemsearchlist : itemsearchlists) {
	    if (itemsearchlist.getText().contains("MRP")) {
	        // Perform actions on the filtered item
	        System.out.println("Found MRP item " + itemsearchlist.getText());
	        itemsearchlist.click(); // Example action
	    }
	}

	waitForWebElementToAppear(okbtn);
	okbtn.click();
	Thread.sleep(1000);
	okbtn.click();
	Thread.sleep(1000);
}


public void customeradding(String cname,String cemail, String ctin) throws InterruptedException
{
	
	customerselectionbtn.click();
	Thread.sleep(2000);
	name.sendKeys(cname);
	Thread.sleep(2000);
	email.sendKeys(cemail);
	Thread.sleep(2000);
	tin.sendKeys(ctin);
	Thread.sleep(2000);
	continuebtn.click();
	Thread.sleep(2000);
	
	driver.switchTo().alert().accept();
	Thread.sleep(2000);
	continuebtn.click();

}
public void costpriceitemsearch() throws InterruptedException // item rate editing cost price wise

{
	
	itemsearchpos.sendKeys("28");
	itemsearchpos.sendKeys(Keys.ENTER);
	System.out.println("item entered");
	pricebtn.click();
	numpadpricesearch.sendKeys("9");
	numpadpricesearch.sendKeys(Keys.ENTER);
	okbtn.click();	
	
}

public String costpricealert() 
{
	return costpricealertbtn.getText();

}

public void mrppriceitemsearch() throws InterruptedException // item rate editing mrp wise

{
	
	itemsearchpos.sendKeys("26");
	itemsearchpos.sendKeys(Keys.ENTER);
	System.out.println("item entered");
	pricebtn.click();
	numpadpricesearch.sendKeys("501");
	numpadpricesearch.sendKeys(Keys.ENTER);
	okbtn.click();	
	
}

public String mrppricealert() 
{
	return mrpalertbtn.getText();

}


}


