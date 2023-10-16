package com.qa.selltistest;import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.openqa.selenium.By;

//import com.qa.locators.test.*;

import com.qa.test.TestEngine.test.TestEngine;
import com.qa.selltistest.Login;
import com.qa.mainframe.test.ExcelReader;

public class createcontact extends TestEngine{

	public createcontact() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	public static By TxnSale;
	
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
	public void clickonaddcontact()
	{
		try		
		{
			
			//WebElement wait =  new WebDriverWait(driver, Duration.ofSeconds(20))
			       // .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='page-content-container']//div[1]//div[1]//div[1]//div[1]//a[1]")));
			
		System.out.println("Conatct");				
		Thread.sleep(10000);	
		WebElement clickonAddcontact = driver.findElement(By.xpath("//div[@class='page-content-container']//div[1]//div[1]//div[1]//div[1]//a[1]"));
		clickonAddcontact.click();		
		Thread.sleep(5000);
		//TxnSale = By.xpath("");
		//TestEngine t = null;
		//t.click(TxnSale);				
		driver.findElement(By.xpath("//input[@name='MLS_SALUTATION_input']")).click();
		
		Thread.sleep(4000);
		List<WebElement> select2 = driver.findElements(By.xpath("//div[@id='MLS_SALUTATION-list']//div[@class='k-list-content k-list-scroller']//ul[@id='MLS_SALUTATION_listbox']//li[@class='k-list-item']//span[@class='k-list-item-text']"));
		
		 Thread.sleep(2000);
		for(WebElement select : select2)
		{
			//System.out.println("gt2");
			String strsel = select.getText();
			System.out.println(strsel);
			Thread.sleep(1000);
			if(strsel.contains("Mr."))
			{
				System.out.println("gt2");
				Thread.sleep(2000);
				select.click();
			}
		}
				
		//Account
		Thread.sleep(2000);
		WebElement Accountlinkbtn = driver.findElement(By.id("ilbl_LNK_RELATED_CO"));
		Thread.sleep(1000);
		Accountlinkbtn.click();
		Thread.sleep(2000);
		WebElement Search = driver.findElement(By.id("txtSelectFilter"));
		Search.sendKeys("Vendor account Test");
		Thread.sleep(2000);
		WebElement Searchbtn = driver.findElement(By.id("btn_Select"));
		Searchbtn.click();
		Thread.sleep(3000);
		
		WebElement Account = driver.findElement(By.id("RelatedDialogGridLNK_RELATED_CO"));
		Thread.sleep(2000);
		List<WebElement> Accountlist = Account.findElements(By.className("k-master-row"));
		Thread.sleep(1000);
		for(WebElement Accountlist1 : Accountlist)
		{
			String stract = Accountlist1.getText();
			System.out.println(Accountlist1.getText());
			if(stract.contains("Vendor"))
			{
				Thread.sleep(1000);
				Accountlist1.findElement(By.className("chkbx")).click();
				driver.findElement(By.xpath("//div[@class='modal-body']//button[@id='btnSave']")).click();
				break;
			}
		}
		
		//Contact of User
		Thread.sleep(2000);
		WebElement Contactlink = driver.findElement(By.xpath("//i[@id='ilbl_LNK_RELATED_US']"));
		Contactlink.click();
		Thread.sleep(1000);
		
		
		Thread.sleep(2000);
		WebElement contSearch = driver.findElement(By.id("txtSelectFilter"));
		contSearch.sendKeys("Abby Arens");
		Thread.sleep(2000);
		WebElement ctSearchbtn = driver.findElement(By.id("btn_Select"));
		ctSearchbtn.click();
		Thread.sleep(3000);
		
		WebElement cont = driver.findElement(By.id("RelatedDialogGridLNK_RELATED_US"));
		Thread.sleep(2000);
		List<WebElement> contact = cont.findElements(By.className("k-master-row"));
		Thread.sleep(1000);
		for(WebElement contact1 : contact)
		{
			String stract = contact1.getText();
			System.out.println(contact1.getText());
			if(stract.contains("Abby Arens"))
			{
				Thread.sleep(1000);
				contact1.findElement(By.className("chkbx")).click();
				driver.findElement(By.xpath("//div[@class='modal-body']//button[@id='btnSave']")).click();
				break;
			}
		}
				
		//FristName
		Thread.sleep(2000);
		WebElement Fristname = driver.findElement(By.id("TXT_NAMEFIRST"));
		Thread.sleep(2000);
		Fristname.sendKeys("Vendor conatct");
		
		//LastName
		Thread.sleep(2000);
		WebElement LastName = driver.findElement(By.id("TXT_NAMELAST"));
		Thread.sleep(2000);
		LastName.sendKeys("Test");
		
		//Email
		Thread.sleep(2000);
		WebElement Email = driver.findElement(By.id("EML_EMAIL"));
		Thread.sleep(2000);
		Email.sendKeys("clienttest@gmail.com");
		
		//save
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='btnSaveandClose']")).click();
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
   }

}
