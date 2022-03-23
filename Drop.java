package Week4Day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Drop {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/drag.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement element = driver.findElement(By.id("draggable"));
		Actions action =new Actions(driver);
		Point location = element.getLocation();
		int x =location.getX();
		int y = location.getY();
		action.dragAndDropBy(element, x+50, y+50).perform();
		//action.dragAndDropBy(element, 100, 100).perform();
		
	}

}
