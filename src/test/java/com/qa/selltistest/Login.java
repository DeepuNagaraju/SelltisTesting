package com.qa.selltistest;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

//import com.qa.locators.test.*;

import com.qa.test.TestEngine.test.TestEngine;
import com.qa.mainframe.test.ExcelReader;

public class Login extends TestEngine {
	
	public Login() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	public String username;
	public String password;
	public String login;	
	
	public void username(String username) {
		this.username = username;
	}
	
	public void password(String password) {
		this.password = password;
	}
 
	@Test
	public void logintoapp() throws InterruptedException, IOException {
		//TestEngine te = new TestEngine();
		//te.intilization(password, login);
		System.out.println("hi welcome");
		ExcelReader xl = new ExcelReader(System.getProperty("user.dir") +"\\Testdata\\Test.xlsx","Login");
		
		String pp = xl.getcell("OTC");					
		
		System.out.println(pp);
		String[] name = pp.split(",");
		username = name[0];
		password = name[1];	
		
		System.out.println(username);
		System.out.println(password);
		Thread.sleep(3000);	
		System.out.println("enter data in page........");
		driver.findElement(By.xpath("//input[@id='exampleInputEmail1']")).sendKeys(username);
		//us.clear();
		//us.sendKeys(username);
		Thread.sleep(2000);	
				
		driver.findElement(By.xpath("//input[@id='exampleInputPassword1']")).sendKeys(password);
		Thread.sleep(2000);		
				
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		Thread.sleep(2000);	
		
		driver.findElement(By.xpath("//button[@id='BTN_OK']")).click();		
		Thread.sleep(3000);	
		
		TakesScreenshot scrShot =((TakesScreenshot)driver);			
		File Srcfile = scrShot.getScreenshotAs(OutputType.FILE);		
		File DestFile=new File("./Results/img1.png");		
		FileUtils.copyFile(Srcfile, DestFile);			
	}

}
