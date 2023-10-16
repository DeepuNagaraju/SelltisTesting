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

public class createtask extends TestEngine{

	public createtask() throws IOException {
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
	public void clickontask()
	{
		try
		{
		Thread.sleep(3000);
		WebElement taskclick = driver.findElement(By.xpath("//a[@id='Tasks']"));
		taskclick.click();
		
		Thread.sleep(3000);
		WebElement taskall = driver.findElement(By.xpath("//span[normalize-space()='Tasks All - My']"));
		taskall.click();
		
		Thread.sleep(5000);
		WebElement addproject = driver.findElement(By.xpath("//button[@title='Add new']"));
		addproject.click();
				
		//Assigned To
		// Thread.sleep(8000);
		 //WebElement assignedd = driver.findElement(By.xpath("//div[@id='cdiv_LNK_ASSIGNEDTO_US']//div[@class='k-widget k-grid k-grid-display-block']"));
		 //assignedd.clear();
		 Thread.sleep(8000);
		  WebElement assignedlink = driver.findElement(By.id("ilbl_LNK_ASSIGNEDTO_US"));
		  assignedlink.click();                       
		  Thread.sleep(3000);                          
		  WebElement assignedsearch = driver.findElement(By.id("txtSelectFilter"));
		  assignedsearch.sendKeys("Michael Clark"); 
		  driver.findElement(By.xpath("//button[@id='btn_Select']")).click();
		  Thread.sleep(3000); 
		  WebElement assigned = driver.findElement(By.id("RelatedDialogGridLNK_ASSIGNEDTO_US"));
		   Thread.sleep(2000);
			List<WebElement> assigned1 = assigned.findElements(By.className("k-master-row"));
			Thread.sleep(1000);
			for(WebElement assigned2 : assigned1)
			{
				String stract = assigned2.getText();
				System.out.println(assigned2.getText());
				Thread.sleep(3000);
				if(stract.contains("Michael Clark"))
				{
					Thread.sleep(1000);
					assigned2.findElement(By.className("chkbx")).click();
					driver.findElement(By.xpath("//div[@class='modal-body']//button[@id='btnSave']")).click();
					break;
				}
			}
			
			//Entered Date
	    	Thread.sleep(3000);
	    	System.out.println("date");
		    WebElement entdate = driver.findElement(By.xpath("//input[@id='DTE_ENTEREDDATE']"));
		    entdate.sendKeys("2023-07-26");
		    
		    //Due Date
	    	Thread.sleep(3000);
	    	System.out.println("date");
		    WebElement duedate = driver.findElement(By.xpath("//input[@id='DTE_DUETIME']"));
		    duedate.sendKeys("2023-09-28");
		    
		    //Start Date
	    	Thread.sleep(3000);
	    	System.out.println("date");
		    WebElement startdate = driver.findElement(By.xpath("//input[@id='DTE_STARTDATE']"));
		    startdate.sendKeys("2023-08-28");
		    
		    //Description
		    WebElement des = driver.findElement(By.xpath("//input[@id='TXT_DESCRIPTION']"));
		    des.clear();
		    des.sendKeys("Testing");
		    
		    //Type
		    Thread.sleep(3000);
		    WebElement type = driver.findElement(By.name("MLS_TYPE_input"));
		    type.click();
		    Thread.sleep(3000);
		    List<WebElement> typelist = driver.findElements(By.xpath("//div[@id='MLS_TYPE-list']//ul[@id='MLS_TYPE_listbox']//li"));
		    for(WebElement typlst : typelist)
		    {
		    	String str = typlst.getText();
		    	if(str.contains("Personal"))
		    	{
		    		typlst.click();
		    	}
		    }
 		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
