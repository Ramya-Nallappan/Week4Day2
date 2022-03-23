package Week4Day2;

import java.util.List;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TrainTable {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://erail.in/");
		driver.findElement(By.id("txtStationFrom")).clear();
		driver.findElement(By.id("txtStationFrom")).sendKeys("TPJ" , Keys.TAB);
		driver.findElement(By.id("txtStationTo")).clear();
		driver.findElement(By.id("txtStationTo")).sendKeys("MS",Keys.TAB);
		driver.findElement(By.id("chkSelectDateOnly")).click();
		//find the WebTable
		WebElement elementTable = driver.findElement(By.xpath("//table[@class='DataTable TrainList TrainListHeader']"));
		Thread.sleep(3000);
		//No. of rows
		List<WebElement> rows = elementTable.findElements(By.tagName("tr"));
		System.out.println("The no. of rows: " + rows.size());
		
		//No. of columns
		WebElement eachRow2 = rows.get(1);
		List<WebElement> Cols = eachRow2.findElements(By.tagName("td"));
		System.out.println("The no. of Columns: " + Cols.size());
		
		/*
		//To retrieve data from row
		System.out.println("The data in the table are :");
		
		for (int i=0;i<rows.size();i++)
		{
			WebElement eachRow = rows.get(i);
			List<WebElement> Col = eachRow.findElements(By.tagName("td"));
			for(int j=0;j<Col.size();j++)
			{
			System.out.println(Col.get(j).getText());
			
		}
		}
		
		*/
		//Retrieve the Train number and Train name if the train name contains "CHENNAI"
		for (int i=1;i<rows.size();i++)
		{
			//String trainNames = driver.findElement(By.xpath("//table[@class='DataTable TrainList TrainListHeader']//tr["+i+"]/td[2]")).getText();            
			String trainNames =elementTable.findElement(By.xpath("//tr["+i+"]/td[2]")).getText();
			String trainNumber =elementTable.findElement(By.xpath("//tr["+i+"]/td[1]")).getText();
			if (trainNames.contains("CHENNAI")) {                
				System.out.println(trainNumber + "  "+ trainNames); 
				
			}
		}
			
	}

}
