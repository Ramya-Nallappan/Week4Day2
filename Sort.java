package Week4Day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sort {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/sortable.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement item1 = driver.findElement(By.xpath("(//li[@class='ui-state-default ui-sortable-handle']/span)[1]"));
		WebElement item6 = driver.findElement(By.xpath("(//li[@class='ui-state-default ui-sortable-handle']/span)[6]"));
		Actions action = new Actions(driver);
		action.clickAndHold(item6).moveToElement(item1).release().perform();

		
				
	}

}
