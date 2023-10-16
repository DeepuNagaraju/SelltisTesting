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

public class createactivity extends TestEngine {

	public createactivity() throws IOException {
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
	public void clickactivity()
	{
		try
		{
			Thread.sleep(3000);
			WebElement activities = driver.findElement(By.id("Activities"));
			activities.click();
			
			Thread.sleep(3000);
			WebElement myactivities = driver.findElement(By.xpath("//a[@id='DSK_2004052710225915073C_S00016XX']"));
			myactivities.click();
			
			Thread.sleep(5000);
			WebElement addactivity = driver.findElement(By.xpath("//button[@title='Add new']"));
			addactivity.click();
			
			//Contact
		 	  Thread.sleep(8000);
			  WebElement contactclick = driver.findElement(By.xpath("//i[@id='ilbl_LNK_RELATED_CN']"));
			  contactclick.click();
			    
			    Thread.sleep(3000);
				 WebElement contactsearch = driver.findElement(By.id("txtSelectFilter"));
				 contactsearch.sendKeys("Melton"); 
				 Thread.sleep(2000); 
				 driver.findElement(By.xpath("//button[@id='btn_Select']")).click();
				 Thread.sleep(2000);
				  WebElement contact = driver.findElement(By.id("RelatedDialogGridLNK_RELATED_CN"));
				   Thread.sleep(2000);
					List<WebElement> contact1 = contact.findElements(By.className("k-master-row"));
					Thread.sleep(1000);
					for(WebElement contact3 : contact1)
					{
						String stract = contact3.getText();
						System.out.println(contact3.getText());
						if(stract.contains("Melton"))
						{
							Thread.sleep(1000);
							contact3.findElement(By.className("chkbx")).click();
							driver.findElement(By.xpath("//div[@class='modal-body']//button[@id='btnSave']")).click();
							break;
						}
					}
					
					//Date
			    	Thread.sleep(3000);
			    	System.out.println("date");
				    WebElement date = driver.findElement(By.xpath("//input[@id='DTE_STARTTIME']"));
				    date.clear();
				    date.sendKeys("2023-07-28");	
				    
				    //To
			    	Thread.sleep(3000);
			    	System.out.println("date");
				    WebElement to = driver.findElement(By.xpath("//input[@id='DTE_ENDTIME']"));
				    to.clear();
				    to.sendKeys("2023-08-28");
				    
				    //End Time
			    	Thread.sleep(3000);
			    	System.out.println("date");
				    WebElement endtime = driver.findElement(By.xpath("//input[@id='TME_ENDTIME']"));
				    endtime.clear();
				    endtime.sendKeys("01:14");
				    
				    //Type
				    Thread.sleep(3000);
				    WebElement type = driver.findElement(By.xpath("//input[@name='MLS_TYPE_input']"));
				    type.click();
				    Thread.sleep(3000);
				    List<WebElement> typelist = driver.findElements(By.xpath("//div[@id='MLS_TYPE-list']//ul[@id='MLS_TYPE_listbox']//li"));
				    Thread.sleep(3000);
				    System.out.println("kl");
				    for(WebElement typlist1 : typelist)
				    {
				    	String str = typlist1.getText();
				    	System.out.println(str);
				    	if(str.equals("Training"))
				    	{
				    		typlist1.click();				    		
				    	}
				    }
				    
				    Thread.sleep(3000);
				    WebElement btnsave = driver.findElement(By.xpath("//button[@id='btnSaveandClose']"));
				    btnsave.click();
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
