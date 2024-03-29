package Week4Day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Selectable {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/selectable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.switchTo().frame(0);
		//Select Elements individually
		for(int i=1;i<8;i++)
		driver.findElement(By.xpath("(//ol[@class='ui-selectable']//li)["+i+"]")).click();
		//Select multiple elements using action class
		WebElement item1= driver.findElement(By.xpath("(//ol[@class='ui-selectable']//li)[1]"));
		WebElement item2= driver.findElement(By.xpath("(//ol[@class='ui-selectable']//li)[2]"));
		WebElement item3= driver.findElement(By.xpath("(//ol[@class='ui-selectable']//li)[3]"));
		WebElement item4= driver.findElement(By.xpath("(//ol[@class='ui-selectable']//li)[4]"));
		WebElement item5= driver.findElement(By.xpath("(//ol[@class='ui-selectable']//li)[5]"));
		WebElement item6= driver.findElement(By.xpath("(//ol[@class='ui-selectable']//li)[6]"));
		WebElement item7= driver.findElement(By.xpath("(//ol[@class='ui-selectable']//li)[7]"));
		Actions builder = new Actions(driver);
		builder.keyDown(Keys.CONTROL).click(item1).click(item2).click(item3).click(item4).click(item5).click(item6).click(item7).keyUp(Keys.CONTROL).perform();
	}

}
