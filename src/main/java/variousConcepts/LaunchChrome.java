package variousConcepts;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class LaunchChrome {

	private static Scanner ui;

	//java is associated with ;       Class is associated with: 
	                                 //Variables/ attributes / fields / methods 
	
	/// class  
	///objects 
	



public static void main (String [] args) {
	
	
	
	System.out.println("First Selenium");
	
	Scanner scn = new Scanner (System.in);
	
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
//    WebDriver edgedriver = new EdgeDriver();
	
    

	
//	driver.get("https://www.selenium.dev/");
//	
//	driver.close();
//	ui.close();
	
	driver.get("https://www.saucedemo.com/?utm_source=chatgpt.com");
	driver.findElement(By.id("user-name")).sendKeys("standard_user");
	driver.findElement(By.id("password")).sendKeys("secret_sauce");
	driver.findElement(By.id("login-button")).click();
	
	driver.close();
	
	
}
}


