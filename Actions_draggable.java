package Week4Day2;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Actions_draggable {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/draggable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.switchTo().frame(0);
		WebElement element =driver.findElement(By.id("draggable"));
		Point location = element.getLocation();
		int x =location.getX();
		int y =location.getY();
		Actions builder = new Actions(driver);
		builder.dragAndDropBy(element, x+100, y+100).perform();
		
	}

}
