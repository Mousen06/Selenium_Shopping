package com.prac;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Prac7 {

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
		
//		4. Click on 'Test Cases' button
		
		driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[5]/a")).click();
		Thread.sleep(2000);
		
//		5. Verify user is navigated to test cases page successfully
		
		String testcases=driver.findElement(By.xpath("//*[@id=\"form\"]/div/div[1]/div/h2/b")).getText();
		System.out.println(testcases);
		Thread.sleep(2000);
		
		driver.close();

	}

}
