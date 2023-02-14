package com.qa.amazon.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.qa.amazon.util.AmazonTestUtil;
import com.qa.amazon.util.WebEventListener;

public class AmazonTestBase {
	public static WebDriver driver;
	public static Properties prop;
	 public  static EventFiringWebDriver e_driver;
		public static WebEventListener eventListener;
	public AmazonTestBase()
	
	{
		try {
		prop =new Properties();
		
		FileInputStream ip=new FileInputStream("C:\\QA\\Selenium_workspace\\MyAmazonStoreProject\\src\\main\\java\\com\\qa\\amazon\\config\\amazonconfig.properties");
	prop.load(ip);
	}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
		public static void initialization()
		{

			String browserName = prop.getProperty("browser");
		
			if(browserName.equals("chrome")) {
				System.setProperty("webdriver.chrome.driver", "C:\\QA\\Selenium_workspace\\MyAmazonStoreProject\\chromedriver.exe");
				driver = new ChromeDriver(); 
				
			}
			else if(browserName.equals("firefox")) {
				System.setProperty("webdriver.gecko.driver", "C:\\QA\\Seleniumjars\\geckodriver.exe");
				 driver = new FirefoxDriver();
			 
			}
			e_driver = new EventFiringWebDriver(driver);
			// Now create object of EventListerHandler to register it with EventFiringWebDriver
			eventListener = new WebEventListener();
			e_driver.register(eventListener);
			driver = e_driver;
		driver.manage().window().maximize();
		 driver.manage().deleteAllCookies();
		 driver.manage().timeouts().pageLoadTimeout(AmazonTestUtil.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
		 driver.manage().timeouts().implicitlyWait(AmazonTestUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);
		 
		 driver.get(prop.getProperty("url"));
		
	}
	

}
