package org.test.insureme;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class App 
{
    public static void main( String[] args ) throws InterruptedException, IOException
    {
    	System.out.println("Script Started");
    	//System.setProperty("webdriver.chrome.driver","C:/Users/Nayan/Downloads/chromedriver-win64/chromedriver.exe");
    	WebDriverManager.chromedriver().setup();
    	ChromeOptions chromeOptions = new ChromeOptions();
    	chromeOptions.addArguments("--headless");
    	
    	System.out.println("Driver opening up the url in browser");
    	WebDriver driver = new ChromeDriver(chromeOptions);
    	driver.get("http://15.207.18.152:8081//contact.html");
    	
    	driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
    	System.out.println("Enter details in the form");
    	//input name
    	driver.findElement(By.id("inputName")).sendKeys("Nayan");
    	Thread.sleep(2000);
    	driver.findElement(By.id("inputNumber")).sendKeys("9876543211");
    	Thread.sleep(2000);
    	driver.findElement(By.id("inputMail")).sendKeys("nayan@gmail.com");
    	Thread.sleep(2000);
    	driver.findElement(By.id("inputMessage")).sendKeys("Hi, I am interested in insurance");
    	Thread.sleep(2000);
    	
    	driver.findElement(By.id("my-button")).click();
    	
    	String response = driver.findElement(By.id("response")).getText();
    	
    	System.out.println(response);
    	System.out.println("test script executed");
    	
    	TakesScreenshot scrShot =((TakesScreenshot)driver);
    	
    	File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
    	
    	//File destFile = new File("/Users/Nayan/Documents/test-reports.jpg");
    	File destFile = new File("/var/lib/jenkins/workspace/insure-me-test-scripts/test-reports.jpg");
    
    	FileUtils.copyFile(srcFile, destFile);
    	
    	Thread.sleep(2000);
    	driver.quit();
 
    }
}