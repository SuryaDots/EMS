package TestNG;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class login {
	
	
static WebDriver driver;
	
	@Test(priority = 1, description = "Environment_setup")
public static void environment_setup () throws IOException
{
		System.out.println("environemnt setup method");
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\admin\\workspace\\Cb Secure\\src\\config.properties");
		prop.load(fis);
		
		System.setProperty("webdriver.gecko.driver","D:\\Setup\\Gecko\\geckodriver-v0.23.0-win64\\geckodriver.exe");
	//WebDriver driver = new ChromeDriver();
	 driver = new FirefoxDriver();
	//driver.get("url");
	driver.get(prop.getProperty("url"));
	driver.manage().window().maximize();

}
	@Test(priority = 2, description = "Login mandatory validations")
	public static void login_mandatory_validations () throws IOException, InterruptedException
	{
	   
	  driver.findElement(By.xpath("/button[@class='btn btn-primary btn-block mrt15']")).click();// mandatory validations
	   
	   
	   Thread.sleep(1000);
	   
	}
	
	 @Test(priority = 3, description = " invalid Login")
	   public static void invalid_login () throws IOException, InterruptedException
	   {
	   
	   Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\admin\\workspace\\Cb Secure\\src\\config.properties");
		prop.load(fis);
	   
	    driver.findElement(By.id("UserName")).sendKeys(prop.getProperty("email1"));
		driver.findElement(By.id("Password")).sendKeys(prop.getProperty("password1"));
		driver.findElement(By.xpath("/html/body/form/div/div/div[2]/button")).click();//Invalid Login
		 Thread.sleep(1000);
		
		 
		System.out.println("invalid login");
		
	   }
	   
	   @Test(priority = 4, description = " valid Login")
	   public static void valid_login () throws IOException, InterruptedException
	   {
		   Properties prop = new Properties();
			FileInputStream fis = new FileInputStream(
					"C:\\Users\\admin\\workspace\\Cb Secure\\src\\config.properties");
			prop.load(fis);
		
		 driver.findElement(By.id("UserName")).sendKeys(Keys.chord(Keys.CONTROL, "a")); 
		 Thread.sleep(1000);
	     driver.findElement(By.id("UserName")).sendKeys(prop.getProperty("email"));
	     driver.findElement(By.id("Password")).sendKeys(prop.getProperty("password"));
	     driver.findElement(By.xpath("/html/body/form/div/div/div[2]/button")).click();// valid login
	
}
}