package com.prac;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Prac10 {

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
		
//		4. Scroll down to footer
		
		JavascriptExecutor js=(JavascriptExecutor) driver;
		Thread.sleep(2000);
		js.executeScript("window.scroll(0,20000)");
		Thread.sleep(2000);

//		5. Verify text 'SUBSCRIPTION'
		
		String text=driver.findElement(By.xpath("//*[@id=\"footer\"]/div[1]/div/div/div[2]/div/h2")).getText();
		String actualtext="SUBSCRIPTION";
		if(text.equals(actualtext)==true) {
			System.out.println(text);
		}
		
//		6. Enter email address in input and click arrow button
		
		driver.findElement(By.id("susbscribe_email")).sendKeys("mou.sengupta15@gmail.com");
		Thread.sleep(2000);
		WebElement arrow= driver.findElement(By.xpath("//*[@id=\"subscribe\"]/i"));
		arrow.click();
		Thread.sleep(2000);
		
//		7. Verify success message 'You have been successfully subscribed!' is visible
		
		String msg=driver.findElement(By.cssSelector("#success-subscribe > div")).getText();
		System.out.println(msg);
		
		driver.close();
		
	}

}
