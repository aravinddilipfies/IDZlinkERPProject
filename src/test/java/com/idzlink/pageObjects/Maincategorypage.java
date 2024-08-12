package com.idzlink.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.idzlink.utilities.AbstractComponents;

public class Maincategorypage extends AbstractComponents{

	WebDriver ldriver;
	//ldriver - local driver  rdriver - remote driver
	
	public Maincategorypage(WebDriver rdriver)
	{
		super(rdriver);
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//tbody/tr[1]/td[2]/div[2]/div[1]/div[1]/nav[1]/ul[1]/li[6]/ul[1]/li[2]/ul[1]/li[1]")
	@CacheLookup
	WebElement maincategorybtn;
	
	@FindBy(xpath="//input[@id='txtParentItemCode']")
	@CacheLookup
	WebElement maintcatcode;
	
	@FindBy(xpath="//input[@id='txtParentItemName']")
	@CacheLookup
	WebElement maintcatdes;
	
	
	@FindBy(xpath="//i[@class='fa fa-check']")
	@CacheLookup
	WebElement maincatsub;
	
	@FindBy(xpath="//label[@class='lblAlertMsg']")
	@CacheLookup
	WebElement svmsg;
	
	//label[@class='lblAlertMsg']
	
	
	
	
	
	public void MainCategoryMaster()
	{
		maincategorybtn.click();
	}
	
	public void MainCategoryCode(String code)
	{
		maintcatcode.sendKeys(code);
	}
	
	public void MainCategoryDescription(String des)
	{
		maintcatdes.sendKeys(des);
	}
	
	public void MainCategorySubmit()
	{
		maincatsub.click();
	}
	
	public boolean MainCategorySaveMsg()
	{
		waitForWebElementToAppear(svmsg);
		return svmsg.isDisplayed();
	}
	
	public String MainCategorySaveMsgGet()
	{
		return svmsg.getText();
	}
	
	
	
	
}
