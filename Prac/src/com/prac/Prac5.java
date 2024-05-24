package com.prac;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Prac5 {

	public static void main(String[] args) throws InterruptedException {
		
//		1. Launch browser
		
		System.setProperty("WebDriver.chrome.driver", "C:\\Users\\User\\Downloads\\chrome-win32\\chrome-win32\\Chrome.exe");
		WebDriver driver=new ChromeDriver();
		
//		2. Navigate to url 'http://automationexercise.com'
		
		driver.get("http://automationexercise.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		
//		3. Verify that home page is visible successfully
		
		String homePage=driver.getTitle();
		System.out.println(homePage);
		
//		4. Click on 'Signup / Login' button
		
		WebElement logIn=driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a"));
		logIn.click();
		
//		5. Verify 'New User Signup!' is visible
		
		String heading=driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/h2")).getText();
		String actualHeading="New User Signup!";
		if(heading.equals(actualHeading)==true) {
			System.out.println(heading);
			
//		6. Enter name and already registered email address
			
		driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[2]")).sendKeys("Moumia");
		driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[3]")).sendKeys("mou.sengupta15@gmail.com");
		Thread.sleep(2000);
		
//		7. Click 'Signup' button
		
		WebElement signup=driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/button"));
		signup.click();
		
//		8. Verify error 'Email Address already exist!' is visible
		
		String msg=driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/p")).getText();
		String actualmsg="Email Address already exist!";
		if(msg.equals(actualmsg)==true) {
			System.out.println(msg);
			
		}
		Thread.sleep(2000);
		
		driver.close();
		}

	}

}
