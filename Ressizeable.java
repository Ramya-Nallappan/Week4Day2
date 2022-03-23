package Week4Day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Ressizeable {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/resizable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.switchTo().frame(0);
		WebElement element = driver.findElement(
		By.xpath("//div[@class='ui-resizable-handle ui-resizable-se ui-icon ui-icon-gripsmall-diagonal-se']"));
		// WebElement element =
		// driver.findElement(By.xpath("//*[@id=\\\"resizable\\\"]/div[3]"));

		// WebElement element1 = driver.findElement(By.id("resizable"));
		Actions builder = new Actions(driver);
		// Point location = element1.getLocation();
		// int x =location.getX();
		// int y =location.getY();
		builder.dragAndDropBy(element, 80, 80).perform();

	}

}
