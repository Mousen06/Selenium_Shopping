package com.prac;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class Prac1 {

	public static void main(String[] args)  throws InterruptedException{

//		ChromeOptions opt=new ChromeOptions();
//		opt.addExtensions(new File("./Extensions/AdBlocker.crx"));		
		System.setProperty("WebDriver.chrome.driver", "C:\\Users\\User\\Downloads\\chrome-win32\\chrome-win32\\Chrome.exe");
		
			
		WebDriver driver=new ChromeDriver();
		
//		2.Nevigate to the url
		
		driver.get("https://automationexercise.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		
//		3.Verify the page is visible successfully
		
		String title= driver.getTitle();
		System.out.println(title);

//		4.click on sign up/login
		driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a")).click();
		Thread.sleep(2000);
		
//		5.verify new user sign up is visible
		
		String heading=driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/h2")).getText();
		String expectedheading="New User Signup!";
		if(heading.equals(expectedheading)==true) {
			System.out.println(expectedheading);
		
		}
		
//		6.enter name and email address
		driver.findElement(By.name("name")).sendKeys("Moumita");
		driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[3]")).sendKeys("mou.sengupta15@gmail.com");
	
//		7.click on sign up button
		driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/button")).click();
		Thread.sleep(2000);
		
//		8.Verify that 'ENTER ACCOUNT INFORMATION' is visible
		
		String heading1=driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div/h2/b")).getText();
		String expectedheading1="ENTER ACCOUNT INFORMATION";
		if(heading1.equals(expectedheading1)==true) {
			System.out.println(expectedheading1);
		
		}
		
//		9. Fill details: Title, Name, Email, Password, Date of birth
		WebElement Mrs=driver.findElement(By.id("id_gender2"));
		if(Mrs.isDisplayed()==true) {
			Mrs.click();
		}
		driver.findElement(By.id("password")).sendKeys("1234");
		
		WebElement day=driver.findElement(By.name("days"));
		day.click();
		Select days=new Select(day);
		days.selectByValue("10");
		
		WebElement month=driver.findElement(By.name("months"));
		month.click();
		Select months=new Select(month);
		months.selectByValue("2");
		
		WebElement year=driver.findElement(By.name("years"));
		year.click();
		Select years=new Select(year);
		years.selectByIndex(3);
		
//		Select checkbox 'Sign up for our newsletter!'
		
		WebElement checkBox=driver.findElement(By.xpath("//*[@id=\"newsletter\"]"));
		checkBox.click();
		
//		11. Select checkbox 'Receive special offers from our partners!'
		
		WebElement checkBox1=driver.findElement(By.xpath("//*[@id=\"optin\"]"));
		checkBox1.click();
		Thread.sleep(2000);
		
//		12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
		
		driver.findElement(By.name("first_name")).sendKeys("Moumita");
		driver.findElement(By.name("last_name")).sendKeys("sengupta");
		driver.findElement(By.name("company")).sendKeys("Infosys");
		driver.findElement(By.id("address1")).sendKeys("Kolkata");
		driver.findElement(By.id("address2")).sendKeys("New barrakpore");
		WebElement country=driver.findElement(By.name("country"));
		country.click();
		Select countryName=new Select(country);
		countryName.selectByIndex(0);
		driver.findElement(By.id("state")).sendKeys("West Bengal");
		driver.findElement(By.id("city")).sendKeys("Kolkata");
		driver.findElement(By.id("zipcode")).sendKeys("100001");
		driver.findElement(By.id("mobile_number")).sendKeys("9876543210");
		Thread.sleep(2000);
		
		
//		13. Click 'Create Account button'
		
		driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div[1]/form/button")).click();
		
		Thread.sleep(2000);
		
////	14. Verify that 'ACCOUNT CREATED!' is visible
		
		String heading3=driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/h2/b")).getText();
		String expectedheading3="ACCOUNT CREATED!";
		if(heading3.equals(expectedheading3)==true) {
			System.out.println(expectedheading3);
		}
		Thread.sleep(2000);
		
//		15. Click 'Continue' button
		
		driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div/a")).click();
		
//		16. Verify that 'Logged in as username' is visible
		
		String heading4=driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a/b")).getText();
		String expectedheading4="Moumita";
		if(heading4.equals(expectedheading4)==true) {
			System.out.println(expectedheading4);
		}
		
}}