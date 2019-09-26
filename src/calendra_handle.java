import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class calendra_handle {
	public static void main(String args[]) throws InterruptedException {
		WebDriver driver;
		System.setProperty("webdriver.gecko.driver", "C:\\geckodriver-v0.23.0-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://www.path2usa.com/travel-companions");
		driver.findElement(By.id("travel_date")).click();
		Thread.sleep(3000);
		int Days_count = driver.findElements(By.className("day")).size();
		for (int i = 0; i < Days_count; i++) {
			String Select_days = driver.findElements(By.className("day")).get(i).getText();
			if (Select_days.equalsIgnoreCase("23")) {
				driver.findElements(By.className("day")).get(i).click();

			}

		}

	}

}
