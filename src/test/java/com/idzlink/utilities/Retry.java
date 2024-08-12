package com.idzlink.utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {
	
	int count=0;
	int maxtry=1;
	
	public boolean retry(ITestResult result)
	{
		if(count<maxtry)
		{
			count++;
			return true;
		}
		return false;
	
	}

}
