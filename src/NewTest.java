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
import org.testng.Assert;



public class NewTest {
 
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
	
	
/*	@Test(priority = 2, description = "Login")
	public static void login () throws IOException, InterruptedException
	{
	
	Properties prop = new Properties();
	FileInputStream fis = new FileInputStream(
			"C:\\Users\\admin\\workspace\\Cb Secure\\src\\config.properties");
	prop.load(fis);
	//driver.findElement(By.xpath("//*[@id='UserName']")).sendKeys(prop.getProperty("email"));
	
	   Thread.sleep(5000);
	   
	   driver.findElement(By.xpath("/html/body/form/div/div/div[2]/button")).click();// mandatory validations
	   Thread.sleep(1000);
	   
	    driver.findElement(By.id("UserName")).sendKeys(prop.getProperty("email1"));
		driver.findElement(By.id("Password")).sendKeys(prop.getProperty("password1"));
		driver.findElement(By.xpath("/html/body/form/div/div/div[2]/button")).click();//Invalid Login
		 Thread.sleep(1000);
		
		 
		System.out.println("invalid login");
		
		 Thread.sleep(1000);
		 driver.findElement(By.id("UserName")).sendKeys(Keys.chord(Keys.CONTROL, "a")); 
		 Thread.sleep(1000);
	     driver.findElement(By.id("UserName")).sendKeys(prop.getProperty("email"));
	     driver.findElement(By.id("Password")).sendKeys(prop.getProperty("password"));
	     driver.findElement(By.xpath("/html/body/form/div/div/div[2]/button")).click();// valid login
	
}
	
	@Test(priority = 3, description = "logout from application")
	public static void logout () throws IOException, InterruptedException
	
	{
	   Thread.sleep(5000);
		driver.findElement(By.xpath("/html/body/section/div[2]/div[1]/div[3]/div[2]/button/span[1]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("/html/body/section/div[2]/div[1]/div[3]/div[2]/ul/li[2]/a")).click(); 
	
}*/
	
	@Test(priority = 4, description = "Forgot password")
	
	public static void forgot_password () throws InterruptedException, IOException
	
	{
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\admin\\workspace\\Cb Secure\\src\\config.properties");
		prop.load(fis);
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("/html/body/form/div/div/div[2]/div/a")).click();// forgot password popup is opening
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/button[2]")).click();// verify that forgot password popup is closing by close button
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/form/div/div/div[2]/div/a")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/button")).click();// verify that forgot password popup is closing by cross button
		
		driver.findElement(By.xpath("/html/body/form/div/div/div[2]/div/a")).click();
		driver.findElement(By.id("btnCSend")).click();
		Thread.sleep(1000);
		driver.switchTo().alert().accept();////Check mandatory validation on email
		Thread.sleep(2000);
		
		driver.findElement(By.id("txtEmailid")).sendKeys(prop.getProperty("invalidemail"));
		driver.findElement(By.id("btnCSend")).click();//invalid format of email
		Thread.sleep(2000);
		
		driver.findElement(By.id("txtEmailid")).sendKeys(Keys.chord(Keys.CONTROL, "a")); 
		 Thread.sleep(1000);
	     driver.findElement(By.id("txtEmailid")).sendKeys(prop.getProperty("notregisteredemail"));
	     driver.findElement(By.id("btnCSend")).click();//not registered email
	     Thread.sleep(1000);
	     
	     driver.findElement(By.id("txtEmailid")).sendKeys(Keys.chord(Keys.CONTROL, "a")); 
		 Thread.sleep(1000);
	     driver.findElement(By.id("txtEmailid")).sendKeys(prop.getProperty("email"));
	     driver.findElement(By.id("btnCSend")).click();//registered email
	     
}
}