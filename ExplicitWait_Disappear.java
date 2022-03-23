package Week4Day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicitWait_Disappear {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("http://www.leafground.com/pages/TextChange.html");
        //Wait until the element disappears.
		WebElement element = driver.findElement(By.xpath("//button[contains(text(),'Click ME!')]"));
		System.out.println("The text that changes are " + element.getText());
		WebDriverWait wait = new WebDriverWait (driver,Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(element));
		element.click();
		driver.switchTo().alert().accept();

	}

}
