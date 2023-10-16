package com.qa.test.TestEngine.test;

import java.util.Properties;
import java.time.Duration;
import java.util.Properties;
import java.io.*;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class TestEngine {
	
	public static WebDriver driver;
	public Properties pro;
	

	public TestEngine() throws IOException
	{	
		try
		{
		System.out.println("config properties file loading....");
		pro = new Properties();
		FileInputStream ip = new FileInputStream(System.getProperty ("user.dir")+"\\src\\main\\java\\com\\qa\\config\\test\\config.prop"); 
		pro.load(ip);
		System.out.println("config file loaded");
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();}
	}	
	
	@BeforeTest
	@Parameters({"browser","url"})
	public void intilization(String browser,String url)
		{
		System.out.println("enters into initilization method");
		System.out.println(browser);
		System.out.println(url);
		
		//String browsername = pro.getProperty("browser");
		if (browser.equalsIgnoreCase("chrome"))
		{
			System.out.println("browser loading............");
			if (browser.equals("chrome")) {
				System.setProperty("webdriver.chrome.driver",pro.getProperty("chromepath"));
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--remote-allow-origins=*");
				driver = new ChromeDriver(options);
			System.out.println("chrome driver..");
		}		
		}
		driver.manage().window().maximize();		
		driver.get(url);
		}
	
	public boolean click(By locator)
	{
		boolean flag = false;
		driver.findElement(locator).click();
		flag = true;
		if(locator == null)
		{
			Assert.assertTrue(flag,"Unbale to click"+locator);
		}		
		return flag;
	}
	
	public boolean iselementpresent(By locator)
	{
		boolean flag = false;
		//driver.findElement(locator).isEnabled();
		driver.findElement(locator).isEnabled();
		flag = true;
		if(locator == null)
		{
			Assert.assertTrue(flag,"Unbale to click"+locator);
		}		
		return flag;
	}
	
	public boolean dragandrop(By source, By target)
	{
		boolean flag = false;
		WebElement tar = driver.findElement(target);
		WebElement sour = driver.findElement(source);		
		Actions clicker = new Actions(driver);
		clicker.dragAndDrop(sour, tar).build().perform();
		flag = true;			  
		return flag;
	}
	
	public boolean rightclick(By locator)
	{
		boolean flag = false;
		WebElement tr = driver.findElement(locator);
		Actions clicker = new Actions(driver);
		clicker.contextClick(tr).build().perform();
		flag = true;
		return flag;			
		
	}

}
