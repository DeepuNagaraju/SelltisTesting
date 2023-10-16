package com.qa.selltistest;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

//import com.qa.locators.test.*;

import com.qa.test.TestEngine.test.TestEngine;
import com.qa.selltistest.Login;
import com.qa.mainframe.test.ExcelReader;

public class createaccount extends TestEngine{

	public createaccount() throws IOException {
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
	public void clickonaccount()
	{
			try 
			{
				System.out.println("Click on Add Account");
				driver.findElement(By.xpath("//a[normalize-space()='Add Account']")).click();								
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
	}
	
	@Test(priority = 2)
	public void createanaccount()
	{
			try 
			{				
 			  Thread.sleep(5000); 
			  System.out.println("Account");
			  driver.findElement(By.xpath("//input[@id='TXT_COMPANYNAME']")).sendKeys("account1 Test");
			  
			  WebElement Accountownerlink = driver.findElement(By.xpath("(//i[@id='ilbl_LNK_TEAMLEADER_US']"));
			  Accountownerlink.click();
				  
			  Thread.sleep(4000);
			  WebElement maintable2 = driver.findElement(By.id("RelatedDialogGridLNK_TEAMLEADER_US"));
			  List<WebElement> maintable = maintable2.findElements(By.className("k-master-row"));
					 
			  for(WebElement element : maintable)
			  {
				  //System.out.println("each element" + element.getText());					 
					  String Str = element.getText(); 
					  if(Str.contains("Adam")) 
					  {
					  System.out.println("each"+element.getAttribute("class"));					  
					  element.findElement(By.className("chkbx")).click();
					  driver.findElement(By.xpath(
					  "//div[@class='modal-body']//button[@id='btnSave']")).click(); 
					  break;
					  }				  
				}
					  
			     //Segment
			  
				 Thread.sleep(2000);
				 WebElement Segmant = driver.findElement(By.xpath("//i[@id='ilbl_LNK_RELATED_BU']"));
				 Segmant.click();
				  
				  Thread.sleep(3000);
				  WebElement ele = driver.findElement(By.id("RelatedDialogGridLNK_RELATED_BU"));
				  List<WebElement> lisele = ele.findElements(By.className("k-master-row"));
				  
				  for(WebElement el : lisele)
				  {
					  System.out.println(el.getText());					  
					  String str2 = el.getText();
					  if(str2.contains("Air"))
					  {
						  el.findElement(By.className("chkbx")).click();
						  driver.findElement(By.xpath("//div[@class='modal-body']//button[@id='btnSave']")).click();
						  break;
					  }
				  }
				  
				//Business Unit
				  
				  Thread.sleep(3000);
				  WebElement Businessunitlinkbtn = driver.findElement(By.xpath("//i[@id='ilbl_LNK_RELATED_BC']"));
				  Businessunitlinkbtn.click();
				  Thread.sleep(3000);
				  WebElement Businessunit = driver.findElement(By.id("RelatedDialogGridLNK_RELATED_BC"));
				  List<WebElement> Businessunitlist = Businessunit.findElements(By.className("k-master-row"));
				  for(WebElement Businessunit1 : Businessunitlist)
				  {
					  String strbus = Businessunit1.getText();
					  if(strbus.contains("CAS"))
					  {
						  Businessunit1.findElement(By.className("chkbx")).click();
						  driver.findElement(By.xpath("//div[@class='modal-body']//button[@id='btnSave']")).click();
						  break;
					  }		
				  }
							  
				  //Branch	
				  
				  Thread.sleep(3000);
				  WebElement branchlinkbtn = driver.findElement(By.xpath("//i[@id='ilbl_LNK_RELATED_BR']"));
				  branchlinkbtn.click();
				  Thread.sleep(3000);
				  WebElement Branch = driver.findElement(By.id("RelatedDialogGridLNK_RELATED_BR"));
				  List<WebElement> Branchlist = Branch.findElements(By.className("k-master-row"));
				  for(WebElement Branchlist1 : Branchlist)
				  {
					  String strbrn = Branchlist1.getText();
					  if(strbrn.contains("AIR TECH CAS-LAFAYETTE"))
					  {
						  Branchlist1.findElement(By.className("chkbx")).click();
						  driver.findElement(By.xpath("//div[@class='modal-body']//button[@id='btnSave']")).click();
						  break;						  
					  }
				  }			 
			    
				  //ParentAccount
				  
				  Thread.sleep(3000);
				  WebElement Parentaccountlinkbtn = driver.findElement(By.xpath("//i[@id='ilbl_LNK_PARENT_CO']"));
				  Parentaccountlinkbtn.click();
				  Thread.sleep(3000);
				  WebElement parentaccount = driver.findElement(By.id("RelatedDialogGridLNK_PARENT_CO"));
				  List<WebElement> parentaccountlist = parentaccount.findElements(By.className("k-master-row"));
				  for(WebElement parentaccountlist1 : parentaccountlist)
				  {
					  String strprt = parentaccountlist1.getText();
					  if(strprt.contains("Western"))
					  {
						  System.out.println("Western");
						  parentaccountlist1.findElement(By.className("chkbx")).click();
						  driver.findElement(By.xpath("//div[@class='modal-body']//button[@id='btnSave']")).click();
						  break;
					  }
				  }
				        
				  //Address				  
				  Thread.sleep(3000);
				  WebElement Address = driver.findElement(By.xpath("//input[@id='TXT_ADDRMAILING']"));
				  Thread.sleep(3000);
				  Address.sendKeys("Texas");
				  
				  //City				  
				  Thread.sleep(2000);
				  WebElement City = driver.findElement(By.xpath("//input[@id='TXT_CITYMAILING']"));
				  Thread.sleep(2000);
				  City.sendKeys("Hyderabad");
				  
				  //State
				  Thread.sleep(2000);
				  WebElement State = driver.findElement(By.xpath("//input[@id='TXT_STATEMAILING']"));
				  Thread.sleep(2000);
				  State.sendKeys("AP");
				  
				  //Zip
				  Thread.sleep(2000);
				  WebElement Zip = driver.findElement(By.xpath("//input[@id='TXT_ZIPMAILING']"));
				  Thread.sleep(2000);
				  Zip.sendKeys("533287");
				  
				  Thread.sleep(2000);
				  driver.findElement(By.xpath("//button[@id='btnSaveandClose']")).click();		
				  
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
	}

}
