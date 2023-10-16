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

public class createopportunity extends TestEngine {

	public createopportunity() throws IOException {
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
	public void clickopportunity()
	{
		try
		{
			//Thread.sleep(3000);	
			//driver.navigate().to("https://otctest.selltis.com/DetailsPage/PRP?sPRPId=PRF_D703938F-1549-41D2-8AC5-0FBE25F16A72");
					
			Thread.sleep(8000);
			WebElement clickopportunity = driver.findElement(By.xpath("//div[3]//div[1]//div[1]//div[1]//a[1]"));
			clickopportunity.click();
			
			//Main contact
			 Thread.sleep(8000);
			  WebElement maincontactlink = driver.findElement(By.id("ilbl_LNK_ORIGINATEDBY_CN"));
			  maincontactlink.click();                       
			  Thread.sleep(3000);                          
			  WebElement contactsearch = driver.findElement(By.id("txtSelectFilter"));
			  contactsearch.sendKeys("Vendor contact Test"); 
			  driver.findElement(By.xpath("//button[@id='btn_Select']")).click();
			  Thread.sleep(3000); 
			  WebElement maincontact = driver.findElement(By.id("RelatedDialogGridLNK_ORIGINATEDBY_CN"));
			   Thread.sleep(2000);
				List<WebElement> maincontact1 = maincontact.findElements(By.className("k-master-row"));
				Thread.sleep(1000);
				for(WebElement maincontact2 : maincontact1)
				{
					String stract = maincontact2.getText();
					System.out.println(maincontact2.getText());
					if(stract.contains("Vendor"))
					{
						Thread.sleep(1000);
						maincontact2.findElement(By.className("chkbx")).click();
						driver.findElement(By.xpath("//div[@class='modal-body']//button[@id='btnSave']")).click();
						break;
					}
				}
				
				//Main Account
				/*
				 * Thread.sleep(3000); WebElement mainaccountlink =
				 * driver.findElement(By.xpath("//i[@id='ilbl_LNK_FOR_CO']"));
				 * mainaccountlink.click();
				 * 
				 * Thread.sleep(3000); WebElement mainaccount =
				 * driver.findElement(By.id("txtSelectFilter")); mainaccount.sendKeys("Maven");
				 * Thread.sleep(3000);
				 * driver.findElement(By.xpath("//button[@id='btn_Select']")).click();
				 * Thread.sleep(3000); WebElement mainaccount1 =
				 * driver.findElement(By.id("RelatedDialogGridLNK_FOR_CO")); Thread.sleep(2000);
				 * List<WebElement> mainaccount2 =
				 * mainaccount1.findElements(By.className("k-master-row")); Thread.sleep(1000);
				 * System.out.println("yui"); for(WebElement mainaccount3 : mainaccount2) {
				 * System.out.println("yui222"); String stract = mainaccount3.getText();
				 * System.out.println(mainaccount3.getText()); if(stract.contains("Maven")) {
				 * Thread.sleep(1000); System.out.println("yui5555");
				 * mainaccount3.findElement(By.className("chkbx")).click();
				 * System.out.println("yui888"); driver.findElement(By.xpath(
				 * "//div[@class='modal-body']//button[@id='btnSave']")).click(); break; } }
				 */
				
			
			//Owner
			Thread.sleep(3000);		
			WebElement ownerlink = driver.findElement(By.xpath("//i[@id='ilbl_LNK_CREDITEDTO_US']"));
			ownerlink.click();
			Thread.sleep(3000);
			 WebElement owner = driver.findElement(By.id("txtSelectFilter"));
			 owner.sendKeys("Abby Arens"); 
			 driver.findElement(By.xpath("//button[@id='btn_Select']")).click();
			 Thread.sleep(3000); 
			  WebElement owner1 = driver.findElement(By.id("RelatedDialogGridLNK_CREDITEDTO_US"));
			   Thread.sleep(2000);
				List<WebElement> owner2 = owner1.findElements(By.className("k-master-row"));
				Thread.sleep(1000);
				System.out.println("yui");
				for(WebElement owner3 : owner2)
				{
					String stract = owner3.getText();
					System.out.println(owner3.getText());
					if(stract.contains("Abby Arens"))
					{
						Thread.sleep(1000);
						owner3.findElement(By.className("chkbx")).click();
						driver.findElement(By.xpath("//div[@class='modal-body']//button[@id='btnSave']")).click();
						break;
					}
				}
				
				//Opportunitytype
				WebElement Opportunitytype = driver.findElement(By.xpath("//input[@name='MLS_OPPORTUNITYTYPE_input']"));
				Opportunitytype.click();
				Thread.sleep(3000);
				List<WebElement> select2 = driver.findElements(By.xpath("//ul[@id='MLS_OPPORTUNITYTYPE_listbox']/li"));
				Thread.sleep(3000);
				for(WebElement select : select2)
				{
					//System.out.println("gt2");
					String strsel = select.getText();
					System.out.println(strsel);
					Thread.sleep(1000);
					if(strsel.contains("Rep Order"))
					{
						Thread.sleep(1000);
						select.click();
					}
				}
				
				//Expected Value
				Thread.sleep(3000);
				WebElement expectedvalue = driver.findElement(By.xpath("//input[@id='CUR_EXPECTEDVALUE']"));
				expectedvalue.clear();
				expectedvalue.sendKeys("12");
				
				//Go
				Thread.sleep(3000);
				WebElement govalue = driver.findElement(By.xpath("//input[@id='SR__GO']"));
				govalue.clear();
				govalue.sendKeys("12");
				
					
			   //EXP Closed Date
		    	Thread.sleep(5000);
		    	System.out.println("date");
			    WebElement expdate = driver.findElement(By.xpath("//input[@id='DTE_EXPCLOSEDATE']"));
			    expdate.sendKeys("2023-09-28");	
		    	
		    	//Next Action Date
		    	Thread.sleep(5000);
		    	System.out.println("date");
			    WebElement nxtdate = driver.findElement(By.xpath("//input[@id='DTE_NEXTACTIONDATE']"));
			    nxtdate.sendKeys("2023-08-08");	
			    
			    //Scrolling
			    //JavascriptExecutor js = (JavascriptExecutor) driver;
			    //js.executeScript("arguments[0].scrollIntoView();", Element);		    
			    
			    
			    //Opportunity lines
			    Thread.sleep(3000);
			    WebElement oppline = driver.findElement(By.xpath("//h4[normalize-space()='Opportunity Lines']"));
			    //Scrolling
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].scrollIntoView();", oppline);
			    
			    //Vendor
			    Thread.sleep(3000);
			    WebElement vendorclick = driver.findElement(By.xpath("//i[@id='ilbl_LNK_RELATED_VE']"));
			    vendorclick.click();
			    
			    Thread.sleep(3000);
				 WebElement vendor = driver.findElement(By.id("txtSelectFilter"));
				 vendor.sendKeys("AMT PUMP CO"); 
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
					
				//Scrolling
				//JavascriptExecutor js = (JavascriptExecutor) driver;
				//js.executeScript("arguments[0].scrollIntoView();", vendorclick);	
					
				//Unit Price
				Thread.sleep(5000);
		    	System.out.println("unit");
			    WebElement unitprice = driver.findElement(By.xpath("//input[@id='CUR_LINEUNITPRICE']"));
			    unitprice.clear();
			    unitprice.sendKeys("23");
				    
				//Quantity
				Thread.sleep(3000);
		    	System.out.println("qunty");
			    WebElement Quantity = driver.findElement(By.xpath("//input[@id='SR__LINEQTY']"));
			    Quantity.clear();
			    Quantity.sendKeys("23");
			    
			   //Get
			   Thread.sleep(3000);
		       System.out.println("get");
		 	   WebElement Get = driver.findElement(By.xpath("//input[@id='SR__LINEGET']"));
		 	   Get.clear();
		       Get.sendKeys("23");
		       
		       //Profit
			   Thread.sleep(3000);
		       System.out.println("profit");
		 	   WebElement Profit = driver.findElement(By.xpath("//input[@id='SR__PROFIT']"));
		 	   Profit.clear();
		 	   Profit.sendKeys("23");
		 	  
		 	  //PCAT
		 	  Thread.sleep(3000);
			  WebElement pcatlinkclick = driver.findElement(By.xpath("//i[@id='ilbl_LNK_RELATED_PD']"));
			  pcatlinkclick.click();
			    
			    Thread.sleep(3000);
				 WebElement pcatclick = driver.findElement(By.id("txtSelectFilter"));
				 pcatclick.sendKeys("Albin Pump"); 
				 Thread.sleep(2000); 
				 driver.findElement(By.xpath("//button[@id='btn_Select']")).click();
				 Thread.sleep(2000);
				  WebElement pcatclick1 = driver.findElement(By.id("RelatedDialogGridLNK_RELATED_PD"));
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
					
					//Add Lines
					Thread.sleep(3000);
			    	System.out.println("unit");
				    WebElement addlines = driver.findElement(By.xpath("//button[@id='NDB_BTN_ADDLINE']"));
				    addlines.click();
				    
				    Thread.sleep(3000);
				    WebElement save = driver.findElement(By.xpath("//button[@id='btnSaveandClose']"));
				    save.click();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
}
