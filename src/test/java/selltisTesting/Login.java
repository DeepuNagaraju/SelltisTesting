package selltisTesting;

import java.io.IOException;

import org.openqa.selenium.By;
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
	//	TestEng te = new TestEng();
		System.out.println("hi welcome");
		ExcelReader xl = new ExcelReader(System.getProperty("user.dir") +"\\Testdata\\Testdata.xlsx","Login");
		
		String pp = xl.getcell("HR");					
		
		System.out.println(pp);
		String[] name = pp.split(",");
		username = name[0];
		password = name[1];	
		
		System.out.println(username);
		System.out.println(password);
		Thread.sleep(3000);	
		System.out.println("enter data in page........");
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(username);
		//us.clear();
		//us.sendKeys(username);
		Thread.sleep(2000);	
				
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
		Thread.sleep(2000);		
				
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		Thread.sleep(2000);	
		
		//driver.findElement(By.xpath("//span[normalize-space()='Team On Leave']")).click();
		//Thread.sleep(2000);	
		
		//driver.findElement(By.cssSelector("Leave")).click();	
		
	}

}
