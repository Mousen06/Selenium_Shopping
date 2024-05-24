package com.prac;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Prac2 {
	public static void main(String[] args)  throws InterruptedException{
	System.setProperty("WebDriver.chrome.driver", "C:\\Users\\User\\Downloads\\chrome-win32\\chrome-win32\\Chrome.exe");
	WebDriver driver=new ChromeDriver();
	driver.get("https://automationexercise.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
	
//  4. Click on 'Signup / Login' button
	WebElement logIn=driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a"));
	logIn.click();
	
//	5. Verify 'Login to your account' is visible

	String heading5=driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/h2")).getText();
	String actualHeading5="Login to your account";
	if(heading5.equals(actualHeading5)==true) {
		System.out.println(heading5);
	}
//6. Enter correct email address and password
	driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/input[2]")).sendKeys("mou.sengupta15@gmail.com");
	driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/input[3]")).sendKeys("1234");
	
//	7. Click 'login' button
	WebElement login=driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/button"));
	login.click();
	
//	8. Verify that 'Logged in as username' is visible
	
////	9. Click 'Delete Account' button
//	WebElement delete=driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[5]/a"));
//	delete.click();
//	
////	10. Verify that 'ACCOUNT DELETED!' is visible
//	String message=driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/h2/b")).getText();
//	String actualmessage="ACCOUNT DELETED!";
//	if(message.equals(actualmessage)==true) {
//		System.out.println(message);
//	}
//	driver.close();
	
	}

}
