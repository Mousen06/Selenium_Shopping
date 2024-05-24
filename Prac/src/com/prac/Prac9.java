package com.prac;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Prac9 {

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
		
//		4. Click on 'Products' button
		
		driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[2]/a")).click();
		Thread.sleep(2000);
		
//		5. Verify user is navigated to ALL PRODUCTS page successfully
		
		String title=driver.findElement(By.xpath("/html/body/section[2]/div/div/div[2]/div/h2")).getText();
		System.out.println(title);
		
//		6. Enter product name in search input and click search button
		
		driver.findElement(By.id("search_product")).sendKeys("Tops");
		driver.findElement(By.xpath("//*[@id=\"submit_search\"]/i")).click();
		
		driver.close();
		
		

	}

}
