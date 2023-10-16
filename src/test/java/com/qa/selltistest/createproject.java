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

public class createproject extends TestEngine{

	public createproject() throws IOException {
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
	public void clickonproject()
	{
		try
		{
		Thread.sleep(3000);
		WebElement project = driver.findElement(By.xpath("//a[@id='Projects']"));
		project.click();
		
		Thread.sleep(3000);
		WebElement projectsall = driver.findElement(By.xpath("//body[1]/div[1]/aside[1]/div[1]/ul[1]/li[8]/ul[1]/li[2]/a[1]"));
		projectsall.click();
		
		Thread.sleep(8000);
		WebElement addproject = driver.findElement(By.xpath("//i[@class='fa fa-plus']"));
		addproject.click();
		
		//Project name
		Thread.sleep(8000);
		WebElement projectname = driver.findElement(By.xpath("//input[@id='TXT_PROJECTNAME']"));
		projectname.sendKeys("Melton project Testing");
		
		//Date					
		//Thread.sleep(3000);
    	//System.out.println("date");
	    //WebElement date = driver.findElement(By.xpath("//input[@id='DTE_TIME']"));
	    //date.sendKeys("2023-09-28");	
	    
	  //Date 
		WebElement date = driver.findElement(By.xpath("//input[@id='DTE_TIME']")); 
		date.clear();
		date.sendKeys("2023-07-24");
	    	    
		//Eng. Company
		 Thread.sleep(4000);
		  WebElement engcom = driver.findElement(By.id("ilbl_LNK_ENGINEERING_CO"));
		  engcom.click();                    
		  Thread.sleep(3000);                          
		  WebElement engcomsearch = driver.findElement(By.id("txtSelectFilter"));
		  engcomsearch.sendKeys("Melton"); 
		  driver.findElement(By.xpath("//button[@id='btn_Select']")).click();
		  Thread.sleep(3000); 
		  WebElement engcom1 = driver.findElement(By.id("RelatedDialogGridLNK_ENGINEERING_CO"));
		  Thread.sleep(2000);
		  List<WebElement> engcom2 = engcom1.findElements(By.className("k-master-row"));
		  Thread.sleep(1000);
		  for(WebElement engcom3 : engcom2)
			{
				String stract = engcom3.getText();
				System.out.println(engcom3.getText());
				if(stract.contains("Melton"))
				{
					Thread.sleep(1000);
					engcom3.findElement(By.className("chkbx")).click();
					driver.findElement(By.xpath("//div[@class='modal-body']//button[@id='btnSave']")).click();
					break;
				}
			}		
			
			
			//End user company
			  Thread.sleep(4000);
			  WebElement enduserclick = driver.findElement(By.id("ilbl_LNK_FOR_CO"));
			  enduserclick.click();                    
			  Thread.sleep(3000);                          
			  WebElement enduser = driver.findElement(By.id("txtSelectFilter"));
			  enduser.sendKeys("Melton"); 
			  driver.findElement(By.xpath("//button[@id='btn_Select']")).click();
			  Thread.sleep(3000); 
			  WebElement enduser1 = driver.findElement(By.id("RelatedDialogGridLNK_FOR_CO"));
			   Thread.sleep(2000);
				List<WebElement> enduser2 = enduser1.findElements(By.className("k-master-row"));
				Thread.sleep(1000);
				for(WebElement enduser3 : enduser2)
				{
					String stract = enduser3.getText();
					if(stract.contains("Maven Test"))
					{
						Thread.sleep(1000);
						enduser3.findElement(By.className("chkbx")).click();
						driver.findElement(By.xpath("//div[@class='modal-body']//button[@id='btnSave']")).click();
						break;
					}
				}
				
				  //Contractor company
				  Thread.sleep(4000);
				  WebElement contratcomlink = driver.findElement(By.id("ilbl_LNK_FOR_CO"));
				  contratcomlink.click();                    
				  Thread.sleep(3000);                          
				  WebElement contratcom = driver.findElement(By.id("txtSelectFilter"));
				  contratcom.sendKeys("Melton"); 
				  driver.findElement(By.xpath("//button[@id='btn_Select']")).click();
				  Thread.sleep(3000); 
				  WebElement contratcom1 = driver.findElement(By.id("RelatedDialogGridLNK_FOR_CO"));
				  Thread.sleep(2000);
				  List<WebElement> contratcom2 = contratcom1.findElements(By.className("k-master-row"));
				  Thread.sleep(1000);
				  for(WebElement contratcom3 : contratcom2)
				  {	
					 String stract = contratcom3.getText();
					 System.out.println(contratcom3.getText());
					 if(stract.contains("Melton"))
						{
							Thread.sleep(1000);
							contratcom3.findElement(By.className("chkbx")).click();
							driver.findElement(By.xpath("//div[@class='modal-body']//button[@id='btnSave']")).click();
							break;
						}
					}					
					
					//Expected Bid Date					
					Thread.sleep(3000);
			    	System.out.println("date");
				    WebElement expdate = driver.findElement(By.xpath("//input[@id='DTE_Q50']"));
				    expdate.sendKeys("2023-09-28");	
				    
				    //Total project	
				    Thread.sleep(3000);
				    WebElement totalpro = driver.findElement(By.xpath("//input[@id='CUR_TOTVALUE']"));
				    totalpro.clear();
				    totalpro.sendKeys("290");
				    
				    //save
				    Thread.sleep(3000);
				    WebElement save = driver.findElement(By.id("btnSaveandClose"));
				    save.click();
		}
		catch(Exception e)
		{
			e.printStackTrace();			
		}
	}

}
