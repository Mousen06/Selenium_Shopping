package com.prac;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Prac4 {

	public static void main(String[] args) throws InterruptedException {
		
//		1. Launch browser
		
		System.setProperty("WebDriver.chrome.driver", "C:\\Users\\User\\Downloads\\chrome-win32\\chrome-win32\\Chrome.exe");
		WebDriver driver=new ChromeDriver();
		
//		2. Navigate to url 'http://automationexercise.com'
		
		driver.get("https://automationexercise.com/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);

//		3. Verify that home page is visible successfully
		String homePage=driver.getTitle();
		System.out.println(homePage);
		
//		4. Click on 'Signup / Login' button
		
		WebElement logIn=driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a"));
		logIn.click();
		
//		5. Verify 'Login to your account' is visible
		
		String heading5=driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/h2")).getText();
		String actualHeading5="Login to your account";
		if(heading5.equals(actualHeading5)==true) {
			System.out.println(heading5);
		}
		
//		6. Enter correct email address and password
		
		driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/input[2]")).sendKeys("mou.sengupta15@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/input[3]")).sendKeys("1234");
		Thread.sleep(2000);
		
//		7. Click 'login' button
		
		WebElement logInButton=driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/button"));
		logInButton.click();
		
//		8. Verify that 'Logged in as username' is visible
		String heading4=driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a/b")).getText();
		String expectedheading4="Moumita";
		if(heading4.equals(expectedheading4)==true) {
			System.out.println(expectedheading4);
		}
		
//		9. Click 'Logout' button
		
		WebElement logOut= driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a"));
		logOut.click();
		
//		10. Verify that user is navigated to login page
		
		String homePage2=driver.getTitle();
		if(homePage2.equals(homePage)) {
			System.out.println(homePage2);
		}
		Thread.sleep(2000);
		driver.close();
	}
	

}
