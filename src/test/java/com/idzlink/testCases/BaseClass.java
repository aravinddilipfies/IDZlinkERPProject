package com.idzlink.testCases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.idzlink.pageObjects.LoginPage;
import com.idzlink.utilities.ReadConfig;

public class BaseClass {

	ReadConfig readconfig=new ReadConfig();
	
	public String baseURL=readconfig.getApplicationURL();
	public String username=readconfig.getUsername();
	public String password=readconfig.getPassword();
	public static WebDriver driver;
	
	public static Logger logger;
	public Properties prop;

	/*
	@SuppressWarnings("deprecation")
	@Parameters("browser")
	@BeforeClass(alwaysRun=true)
	public void setup(@Optional("chrome") String br)
	{
						
		logger=Logger.getLogger("IDZlink logs");
		PropertyConfigurator.configure("Log4j.properties");
		
		if(br.equals("chrome"))
		{
		System.setProperty("webdriver.chrome.driver",readconfig.getChromepath());
		driver=new ChromeDriver();
		}
		else if(br.equals("edge"))
		{
			System.setProperty("webdriver.edge.driver",readconfig.getEdgepath());
			driver=new EdgeDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		//driver.manage().window().maximize();
		driver.manage().window().setSize(new Dimension(1440,900));
		driver.get(baseURL);
		
	}
	    prop = new Properties();
	*/
	
	/*@BeforeClass
	public void setup() {
	    // Logger configuration
	    logger = Logger.getLogger("ebanking");
	    PropertyConfigurator.configure("Log4j.properties");
	    prop = new Properties();
	    
	    // Get the browser name from the command line or default to "chrome"
	    String br = System.getProperty("browser")!=null ? System.getProperty("browser") :prop.getProperty("browser");

	    // Initialize WebDriver based on the specified browser
	    if (br.equalsIgnoreCase("chrome")) {
	        System.setProperty("webdriver.chrome.driver", readconfig.getChromepath());
	        driver = new ChromeDriver();
	    } else if (br.equalsIgnoreCase("edge")) {
	        System.setProperty("webdriver.edge.driver", readconfig.getEdgepath());
	        driver = new EdgeDriver();
	    } else {
	        throw new IllegalArgumentException("Unsupported browser: " + br);
	    }

	    // WebDriver configuration
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.manage().window().setSize(new Dimension(1440, 900));
	    driver.get(baseURL);
	}*/
	
	@BeforeClass
    public void setup() {
        // Logger configuration
        logger = Logger.getLogger("ERP");
        PropertyConfigurator.configure("Log4j.properties");

        // Load the properties file
        prop = new Properties();
        try {
            FileInputStream configFile = new FileInputStream("./Configuration/config.properties");
            prop.load(configFile);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Could not load properties file.");
        }

        // Get the browser name from the command line or from properties file
        String br = System.getProperty("browser");
        if (br == null || br.isEmpty()) {
            br = prop.getProperty("browser", "chrome"); // Default to "chrome" if not specified
        }

        // Check if `br` is still null
        if (br == null) {
            throw new RuntimeException("Browser name not specified in system property or properties file.");
        }

        // Initialize WebDriver based on the specified browser
        if (br.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", readconfig.getChromepath());
            driver = new ChromeDriver();
        } else if (br.equalsIgnoreCase("edge")) {
            System.setProperty("webdriver.edge.driver", readconfig.getEdgepath());
            driver = new EdgeDriver();
        } else {
            throw new IllegalArgumentException("Unsupported browser: " + br);
        }

        // WebDriver configuration
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().setSize(new Dimension(1440, 900));
        driver.get(baseURL);
    }
	
	@AfterClass(alwaysRun=true)
	public void tearDown() {
	    if (driver != null) {
	        driver.quit();
	    } else {
	        System.out.println("WebDriver was not initialized, skipping driver.quit().");
	    }
	}
	
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	
	public  String randomeString()
	{
		String generatedstring=RandomStringUtils.randomAlphabetic(5);
		return generatedstring;
	}
	
	public String randomeNum()
	{
		String generatedstring2=RandomStringUtils.randomNumeric(4);
		return generatedstring2;
	}
	
	public void intilization() throws InterruptedException
	{
		logger.info("URL is opened");
		
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		logger.info("Entered Username");
		
		lp.setPassword(password);
		logger.info("Entered Password");
		
		lp.clickSubmit();
		
		Thread.sleep(5000);
		lp.closebtn();
		
		System.out.println("opened ");
	}
	
	
	
	public boolean isAlertPresent() //user defined method created to check alert present or not
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		try
		{
			wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert();
		return true;
		}
		catch(NoAlertPresentException e)
		{
			return false;
		}
	}
	
	
	public boolean isAlertPresentWithSuccessMessage() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	    try {
	        wait.until(ExpectedConditions.alertIsPresent());
	        Alert alert = driver.switchTo().alert();
	        String alertText = alert.getText();
	       // alert.accept();  // Optional: Close the alert after checking the message
	        return StringUtils.containsIgnoreCase(alertText, "successfully");
	    } catch (NoAlertPresentException e) {
	        return false;
	    }
	}
	
	
	
}
