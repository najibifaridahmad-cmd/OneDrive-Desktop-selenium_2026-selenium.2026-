package variousConcept;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Session5_TestNG {

    WebDriver driver;
    String url;
    String userName;
    String password;
    

    By userNameField = By.id("user-name");
    By passwordField = By.id("password");
    By loginButtonField = By.id("login-button");
    By menuButtonField = By.id("react-burger-menu-btn");

    By addToCartField = By.id("add-to-cart-sauce-labs-backpack");
    By shoppingCartField = By.className("shopping_cart_link");
    By checkoutField = By.id("checkout");

    By firstNameField = By.id("first-name");
    By lastNameField = By.id("last-name");
    By zipField = By.id("postal-code");
    
    @BeforeClass
    public void readConfig() {
    	
   //   these 4 classes allows you to read files in java:    InputStream / FileReader / BufferReader / Scanner
    	
    	try {
    	   
    		InputStream input = new FileInputStream("src\\main\\java\\config\\config.properties");
    		Properties prop = new Properties();
    		prop.load(input);
//    		String url = prop.getProperty("url");
    		url = prop.getProperty("url");
        	System.out.println("Env selected :" + url);
        	
        	userName = prop.getProperty("user");
        	password = prop.getProperty("password");
        	
     		
     		
    		
    	}
    	catch (IOException e) {
    	    
    	}
    	
    }
    	
    

    @BeforeMethod
    public void init() {

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts()
        .implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.saucedemo.com/");
    }
    
    @Test
    public void testLogin() {

        driver.findElement(userNameField)
                .sendKeys(userName);

        driver.findElement(passwordField)
                .sendKeys(password);

        driver.findElement(loginButtonField)
                .click();

        Assert.assertTrue(
                driver.findElement(menuButtonField).isDisplayed(),
                "Menu button was not displayed!"
        );

        Assert.assertEquals(
                driver.getTitle(),
                "Swag Labs",
                "Page title is incorrect!"
        );
    }
    @Test
    public void testShoppingCart() {

        // Login first
        driver.findElement(userNameField)
                .sendKeys("standard_user");

        driver.findElement(passwordField)
                .sendKeys("secret_sauce");

        driver.findElement(loginButtonField)
                .click();

        // Add product to cart
        driver.findElement(addToCartField)
                .click();

        // Open shopping cart
        driver.findElement(shoppingCartField)
                .click();

        // Checkout
        driver.findElement(checkoutField)
                .click();

        // Enter customer information
        driver.findElement(firstNameField)
                .sendKeys("Farid");

        driver.findElement(lastNameField)
                .sendKeys("Najibi");

        driver.findElement(zipField)
                .sendKeys("91942");
    }


    @AfterMethod
    public void tearDown() {

       if (driver != null) {
         driver.quit();
        }
   }
}