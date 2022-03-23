package Week4Day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sortable {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/sortable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.switchTo().frame(0);
		WebElement item1= driver.findElement(By.xpath("(//ul[@class='ui-sortable']//li)[1]"));
		WebElement item2= driver.findElement(By.xpath("(//ul[@class='ui-sortable']//li)[2]"));
		WebElement item3= driver.findElement(By.xpath("(//ul[@class='ui-sortable']//li)[3]"));
		WebElement item4= driver.findElement(By.xpath("(//ul[@class='ui-sortable']//li)[4]"));
		Actions builder= new Actions (driver);
        builder.clickAndHold(item3).moveToElement(item1).release().perform();
        builder.clickAndHold(item2).moveToElement(item4).release().perform();
	}

}
