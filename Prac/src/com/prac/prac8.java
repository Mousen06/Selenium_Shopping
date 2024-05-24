package com.prac;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class prac8 {
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
		
		
//		Scroll
		
		JavascriptExecutor js=(JavascriptExecutor) driver;
		Thread.sleep(2000);
		js.executeScript("window.scroll(0,500)");
		Thread.sleep(2000);	

		
//		6. The products list is visible
		
		
		
//		7. Click on 'View Product' of first product
		
		driver.findElement(By.xpath("/html/body/section[2]/div/div/div[2]/div/div[2]/div/div[2]/ul/li/a")).click();
		
//		8. User is landed to product detail page
		
		String url=driver.getCurrentUrl();
		System.out.println(url);
		
//		9. Verify that detail detail is visible: product name, category, price, availability, condition, brand
		
		List<WebElement >details=driver.findElements(By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div"));
		WebElement a;
		for(int i=0;i<details.size();i++) {
			a=details.get(i);
			System.out.println(a.getText());
		}
		
		driver.close();
}
}