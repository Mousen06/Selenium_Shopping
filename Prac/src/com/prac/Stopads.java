package com.prac;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Stopads {

	public static void main(String[] args) {
		ChromeOptions opt=new ChromeOptions();
		opt.addExtensions(new File("./Extensions/AdBlocker.crx"));		
		WebDriver driver=new ChromeDriver(opt);
		driver.get("https://automationexercise.com/signup");
	}

}
