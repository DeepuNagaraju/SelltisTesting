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

public class createquote extends TestEngine{

	public createquote() throws IOException {
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
	public void clickquote()
	{
		try
		{
			//Thread.sleep(3000);	
			//driver.navigate().to("https://otctest.selltis.com/DetailsPage/PRP?sPRPId=PRF_D703938F-1549-41D2-8AC5-0FBE25F16A72");
					
			Thread.sleep(8000);
			WebElement quotelinkclick = driver.findElement(By.xpath("//div[4]//div[1]//div[1]//div[1]//a[1]"));
			quotelinkclick.click();
			
			//Contact
			Thread.sleep(8000);
			WebElement contact = driver.findElement(By.xpath("//i[@id='ilbl_LNK_ORIGINATEDBY_CN']"));
			contact.click();
			
			Thread.sleep(3000);                          
			WebElement contactsearch = driver.findElement(By.id("txtSelectFilter"));
			contactsearch.sendKeys("Vendor contact"); 
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
			 
			//Account
			    Thread.sleep(8000);
				WebElement account = driver.findElement(By.xpath("//i[@id='ilbl_LNK_FOR_CO']"));
				account.click();
				
				Thread.sleep(3000);                          
				WebElement accountsearch = driver.findElement(By.id("txtSelectFilter"));
				accountsearch.sendKeys("Vendor account Test"); 
				driver.findElement(By.xpath("//button[@id='btn_Select']")).click();
				Thread.sleep(3000); 
				WebElement account1 = driver.findElement(By.id("RelatedDialogGridLNK_FOR_CO"));
				Thread.sleep(2000);
				List<WebElement> account2 = account1.findElements(By.className("k-master-row"));
				Thread.sleep(1000);
				for(WebElement account3 : account2)
					{
						String stract = account3.getText();
						System.out.println(account3.getText());
						if(stract.contains("Vendor"))
						{
							Thread.sleep(1000);
							account3.findElement(By.className("chkbx")).click();
							driver.findElement(By.xpath("//div[@class='modal-body']//button[@id='btnSave']")).click();
							break;
						}
					}
				//Description
				Thread.sleep(4000);
				WebElement des = driver.findElement(By.xpath("//input[@id='TXT_DESCRIPTION']"));
				des.clear();
				des.sendKeys("Testing");
				
				
			//Outside Rep
			/*
			 * Thread.sleep(8000); WebElement outside =
			 * driver.findElement(By.xpath("//i[@id='ilbl_LNK_CREDITEDTO_US']"));
			 * outside.click();
			 * 
			 * Thread.sleep(3000); WebElement outsiderep =
			 * driver.findElement(By.id("txtSelectFilter"));
			 * outsiderep.sendKeys("Abby Arens");
			 * driver.findElement(By.xpath("//button[@id='btn_Select']")).click();
			 * Thread.sleep(3000); WebElement outsiderep1 =
			 * driver.findElement(By.id("RelatedDialogGridLNK_FOR_CO")); Thread.sleep(2000);
			 * List<WebElement> outsiderep2 =
			 * outsiderep1.findElements(By.className("k-master-row")); Thread.sleep(1000);
			 * System.out.println("yui"); for(WebElement outsiderep3 : outsiderep2) {
			 * System.out.println("yui222"); String stract = outsiderep3.getText();
			 * System.out.println(outsiderep3.getText()); if(stract.contains("Abby Arens"))
			 * { Thread.sleep(1000); System.out.println("yui5555");
			 * outsiderep3.findElement(By.className("chkbx")).click();
			 * System.out.println("yui888"); driver.findElement(By.xpath(
			 * "//div[@class='modal-body']//button[@id='btnSave']")).click(); break; } }
			 */
			 
			 
			 //Insiderep user
				/*
				 * Thread.sleep(8000); WebElement outside =
				 * driver.findElement(By.xpath("//i[@id='ilbl_LNK_FOR_CO']")); outside.click();
				 * 
				 * Thread.sleep(3000); WebElement outsiderep =
				 * driver.findElement(By.id("txtSelectFilter"));
				 * outsiderep.sendKeys("Abby Arens");
				 * driver.findElement(By.xpath("//button[@id='btn_Select']")).click();
				 * Thread.sleep(3000); WebElement outsiderep1 =
				 * driver.findElement(By.id("RelatedDialogGridLNK_FOR_CO")); Thread.sleep(2000);
				 * List<WebElement> outsiderep2 =
				 * outsiderep1.findElements(By.className("k-master-row")); Thread.sleep(1000);
				 * System.out.println("yui"); for(WebElement outsiderep3 : outsiderep2) {
				 * System.out.println("yui222"); String stract = outsiderep3.getText();
				 * System.out.println(outsiderep3.getText()); if(stract.contains("Abby Arens"))
				 * { Thread.sleep(1000); System.out.println("yui5555");
				 * outsiderep3.findElement(By.className("chkbx")).click();
				 * System.out.println("yui888"); driver.findElement(By.xpath(
				 * "//div[@class='modal-body']//button[@id='btnSave']")).click(); break; } }
				 */
			 
			    //Close Date
		    	Thread.sleep(3000);
		    	System.out.println("date");
			    WebElement expdate = driver.findElement(By.xpath("//input[@id='DTE_TIME']"));
			    expdate.clear();
			    expdate.sendKeys("2023-09-28");	
		    	
		    	//Valid Until Date
		    	Thread.sleep(3000);
		    	System.out.println("date");
			    WebElement nxtdate = driver.findElement(By.xpath("//input[@id='DTE_DATECLOSED']"));
			    nxtdate.clear();
			    nxtdate.sendKeys("2023-10-28");	
			    
			    WebElement element = driver.findElement(By.xpath("//label[@id='NDB_LBL_TERMS']"));
			    
			   //Scrolling
			   //JavascriptExecutor js = (JavascriptExecutor) driver;
			   //js.executeScript("arguments[0].scrollIntoView();", element);	
				
			    //Weeks
			    Thread.sleep(3000);
			    WebElement week = driver.findElement(By.xpath("//input[@id='SI__WEEKS']"));
			    week.clear();
			    week.sendKeys("4");
			    
			    
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
				   
				   //Quantity
				   Thread.sleep(3000);
				   WebElement Quantity = driver.findElement(By.xpath("//input[@id='SR__QTY']"));
				   Quantity.clear();
				   Quantity.sendKeys("34");
				   
				   //Unit price
				   Thread.sleep(2000);
				   WebElement unitprice = driver.findElement(By.xpath("//input[@id='CUR_UNITPRICE']"));
				   unitprice.clear();
				   unitprice.sendKeys("120");
				   
				   //cost
				   Thread.sleep(2000);
				   WebElement cost = driver.findElement(By.xpath("//input[@id='CUR_COST']"));
				   cost.clear();
				   cost.sendKeys("329");
				   
				   Thread.sleep(2000);
				   driver.findElement(By.xpath("//button[@id='NDB_BTN_ADDPROD']")).click();
				   
				   Thread.sleep(3000);
				   driver.findElement(By.xpath("//button[@id='btnSaveandClose']")).click();
				  
		}	
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
				
	}	

}
