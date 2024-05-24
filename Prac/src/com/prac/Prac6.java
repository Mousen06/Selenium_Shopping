package com.prac;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Prac6 {

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
		
//		4. Click on 'Contact Us' button
		
		WebElement contactus=driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[8]/a"));
		contactus.click();
	
		
//		5. Verify 'GET IN TOUCH' is visible
		
		String msg=driver.findElement(By.xpath("//*[@id=\"contact-page\"]/div[2]/div[1]/div/h2")).getText();
		System.out.println(msg);
		
		
		
//		6. Enter name, email, subject and message
		
		driver.findElement(By.xpath("//*[@id=\"contact-us-form\"]/div[1]/input")).sendKeys("Moumita");
		driver.findElement(By.xpath("//*[@id=\"contact-us-form\"]/div[2]/input")).sendKeys("mou.sengupta15@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"contact-us-form\"]/div[3]/input")).sendKeys("To contact");
		driver.findElement(By.xpath("//*[@id=\"message\"]")).sendKeys("want to contact");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"contact-us-form\"]/div[5]/input")).sendKeys("C:\\Users\\User\\Documents\\newfile.txt");
		Thread.sleep(2000);
		
		
//		scroll down
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		Thread.sleep(2000);
		js.executeScript("window.scroll(0,500)");
		Thread.sleep(2000);
		
//		8. Click 'Submit' button
		
		WebElement submit=driver.findElement(By.xpath("//*[@id=\"contact-us-form\"]/div[6]/input"));
		submit.click();
		Thread.sleep(2000);
		
		Alert alert=driver.switchTo().alert();
		alert.accept();
		Thread.sleep(2000);
		
//		Scroll up
		
		JavascriptExecutor js1=(JavascriptExecutor)driver;
		Thread.sleep(2000);
		js1.executeScript("window.scroll(500,0)");
		Thread.sleep(2000);
				
//		10. Verify success message 'Success! Your details have been submitted successfully.' is visible
		
		String msg2=driver.findElement(By.xpath("//*[@id=\"contact-page\"]/div[2]/div[1]/div/div[2]")).getText();
		String actualmsg="Success! Your details have been submitted successfully.";
		if(msg2.equals(actualmsg)==true) {
			System.out.println(msg2);
		}
		
//		11. Click 'Home' button and verify that landed to home page successfully
		
		driver.findElement(By.xpath("//*[@id=\"form-section\"]/a/span")).click();
		Thread.sleep(2000);
		
		String homepage2=driver.getTitle();
		if(homepage2.equals(homePage)==true) {
			System.out.println(homepage2);
			
}
		Thread.sleep(2000);
		
		driver.close();
		
	}

}
