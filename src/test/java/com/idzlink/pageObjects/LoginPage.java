package com.idzlink.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.idzlink.utilities.AbstractComponents;

public class LoginPage extends AbstractComponents {

	WebDriver ldriver;
	//ldriver - local driver  rdriver - remote driver
	
	public LoginPage(WebDriver rdriver)
	{
		super(rdriver);
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(name="txtEmailId")
	@CacheLookup
	WebElement txtUserName;
	
	@FindBy(name="txtPassword")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(name="butLogin")
	@CacheLookup
	WebElement btnLogin;
	
	@FindBy(xpath="//a[normalize-space()='×']")
	@CacheLookup
	WebElement close;
	
	@FindBy(xpath="//img[@id='imgUser']")
	@CacheLookup
	WebElement Usericon;
	
	@FindBy(xpath="//a[@id='SignOut']")
	@CacheLookup
	WebElement Signout;
	
	public void setUserName(String uname)
	{
		txtUserName.sendKeys(uname);
	}
	
	public void setPassword(String pwd)
	{
		txtPassword.sendKeys(pwd);
	}
	
	public void clickSubmit()
	{
		btnLogin.click();
	}
	
	public void closebtn()
	{
		clickElement(close);
		close.click();
	}
	
	public void Usricon()
	{
		Usericon.click();
	}
	
	public void Logout()
	{
		Signout.click();
	}
	
	public boolean tutorialclose()
	{
		return close.isDisplayed();
	}
	
	
	
}
