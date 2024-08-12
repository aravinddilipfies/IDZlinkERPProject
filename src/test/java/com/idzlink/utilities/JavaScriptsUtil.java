package com.idzlink.utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class JavaScriptsUtil {

	public static void scrollPageDown (WebDriver driver)
	{ 
		JavascriptExecutor js = ((JavascriptExecutor) driver);
	
		js.executeScript ("window.scrollTo(0, document.body.scrollHeight)");
	}
	
}
