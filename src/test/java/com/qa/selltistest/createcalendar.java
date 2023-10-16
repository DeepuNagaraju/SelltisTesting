package com.qa.selltistest;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

//import com.qa.locators.test.*;

import com.qa.test.TestEngine.test.TestEngine;
import com.qa.selltistest.Login;
import com.qa.mainframe.test.ExcelReader;


public class createcalendar extends TestEngine{

	public createcalendar() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Test(priority = 0)
	public void setUp() {
		System.out.println("setup method...");
		try {
			Login log = new Login();
			log.logintoapp();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test(priority = 1)
	public void clickoncalendar()
	{
		try
		{
		Thread.sleep(3000);
		WebElement calendar = driver.findElement(By.xpath("//a[@id='Calendar']"));
		calendar.click();
		
		Thread.sleep(3000);
		WebElement calendarclick = driver.findElement(By.xpath("//span[normalize-space()='Calendar - My']"));
		calendarclick.click();
		
		Thread.sleep(5000);
		WebElement addcalendar = driver.findElement(By.xpath("//button[@title='Add new']"));
		addcalendar.click();
		
		Thread.sleep(8000);
		WebElement Dis = driver.findElement(By.xpath("//input[@id='TXT_DESCRIPTION']"));
		Dis.sendKeys("Melton cal Testing");
		
		//Date
    	Thread.sleep(3000);
    	System.out.println("date");
	    WebElement date = driver.findElement(By.xpath("//input[@id='DTE_STARTTIME']"));
	    date.clear();
	    date.sendKeys("2023-07-28");	
	    
	    //To
    	Thread.sleep(3000);
    	System.out.println("enddate");
	    WebElement to = driver.findElement(By.xpath("//input[@id='DTE_ENDTIME']"));
	    to.clear();
	    to.sendKeys("2023-08-28");
	    
	    //Time
    	Thread.sleep(3000);
    	System.out.println("time");
	    WebElement Time = driver.findElement(By.xpath("//input[@id='TME_STARTTIME']"));
	    Time.clear();
	    Time.sendKeys("00:41");
	    
	    //Totime
    	Thread.sleep(3000);
    	System.out.println("totime");
	    WebElement totime = driver.findElement(By.xpath("//input[@id='TME_ENDTIME']"));
	    totime.clear();
	    totime.sendKeys("02:00");
	    
	    //Vendor
	 	Thread.sleep(3000);
		WebElement vendor = driver.findElement(By.xpath("//i[@id='ilbl_LNK_RELATED_VE']"));
		vendor.click();
		  
		Thread.sleep(3000);
		WebElement vendorsearch = driver.findElement(By.id("txtSelectFilter"));
		vendorsearch.sendKeys("AMT PUMP CO"); 
		Thread.sleep(2000); 
		driver.findElement(By.xpath("//button[@id='btn_Select']")).click();
		Thread.sleep(2000);
		WebElement vendor1 = driver.findElement(By.id("RelatedDialogGridLNK_RELATED_VE"));
		Thread.sleep(2000);
		List<WebElement> vendor2 = vendor1.findElements(By.className("k-master-row"));
		Thread.sleep(1000);
		for(WebElement vendor3 : vendor2)
		{
			String stract = vendor3.getText();
			System.out.println(vendor3.getText());
			if(stract.contains("AMT PUMP CO"))
				{
					Thread.sleep(1000);
					vendor3.findElement(By.className("chkbx")).click();
					driver.findElement(By.xpath("//div[@class='modal-body']//button[@id='btnSave']")).click();
					break;
				}
		}
				
		//PCAT
	    Thread.sleep(3000);
		WebElement pcatlinkclick = driver.findElement(By.xpath("//i[@id='ilbl_LNK_FOR_PD']"));
		pcatlinkclick.click();
		    
		Thread.sleep(3000);
		WebElement pcatclick = driver.findElement(By.id("txtSelectFilter"));
		pcatclick.sendKeys("Albin Pump"); 
		Thread.sleep(2000); 
		driver.findElement(By.xpath("//button[@id='btn_Select']")).click();
		Thread.sleep(2000);
		WebElement pcatclick1 = driver.findElement(By.id("RelatedDialogGridLNK_FOR_PD"));
		Thread.sleep(2000);
		List<WebElement> pcatclick2 = pcatclick1.findElements(By.className("k-master-row"));
		Thread.sleep(1000);
		for(WebElement pcatclick3 : pcatclick2)
			{
				String stract = pcatclick3.getText();
				System.out.println(pcatclick3.getText());
				if(stract.contains("Albin Pump"))
					{
						Thread.sleep(1000);
						pcatclick3.findElement(By.className("chkbx")).click();
						driver.findElement(By.xpath("//div[@class='modal-body']//button[@id='btnSave']")).click();
						break;
					}
			}  
						
	    Thread.sleep(4000);
		WebElement save = driver.findElement(By.id("btnSaveandClose"));
		save.click();						
	}        
	  	catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
