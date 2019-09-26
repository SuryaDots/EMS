import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Footer_links {
public static void main (String args[]) {
	WebDriver driver;
	System.setProperty("webdriver.gecko.driver", "C:\\geckodriver-v0.23.0-win64\\geckodriver.exe");
	driver= new FirefoxDriver();
	String URL= "https://staging.eprogresstracker.com/";
	driver.get(URL);
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	WebElement footer_driver= driver.findElement(By.className("foot-nav"));
	int link_count= footer_driver.findElements(By.tagName("a")).size();
	System.out.println(footer_driver.findElements(By.tagName("a")).size());
	
	for(int i=1; i<link_count; i++) {
		String clickonlink= Keys.chord(Keys.CONTROL, Keys.ENTER);
		footer_driver.findElements(By.tagName("a")).get(i).sendKeys(clickonlink);
		
	}
	Set <String> ids= driver.getWindowHandles();
	Iterator <String> it=ids.iterator();
	while (it.hasNext()) {
	driver.switchTo().window(it.next());	
	driver.getTitle();
	System.out.println(driver.getTitle());
	}
	
} 
}
