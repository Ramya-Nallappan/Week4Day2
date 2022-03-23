package Week4Day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicitWait_TextChange {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("http://www.leafground.com/pages/disapper.html");
        //Wait until the element disappears.
		WebElement element = driver.findElement(By.xpath("//b[contains(text(),'going to disappear')]"));
		System.out.println("The text that is gng todisappear is " + element.getText());
		WebDriverWait wait = new WebDriverWait (driver,Duration.ofSeconds(15));
		wait.until(ExpectedConditions.invisibilityOf(element));
		if(element.isDisplayed())
		{
			System.out.println("Button Visible");
		}
		else
		{
			System.out.println("Button disappear");
		}

	}

}
