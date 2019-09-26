import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class ActionClass {
	public static void main (String args[]) {
		WebDriver driver;
		System.setProperty("webdriver.gecko.driver", "C:\\geckodriver-v0.23.0-win64\\geckodriver.exe");
		driver= new FirefoxDriver();
		driver.get("https://jqueryui.com/droppable/");
		Actions a = new Actions (driver);
		WebElement link= driver.findElement(By.linkText("JS Foundation"));
		a.moveToElement(link).build().perform();
		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
		WebElement draggable= driver.findElement(By.id("draggable"));
		WebElement droppable= driver.findElement(By.id("droppable"));
		a.dragAndDrop(draggable, droppable).build().perform();
		
	
			
	}

}
