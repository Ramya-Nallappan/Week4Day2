package Week4Day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SortTable {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver =new ChromeDriver();
		driver.get("http://www.leafground.com/pages/sorttable.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        //to find the table locator
		WebElement elementTable = driver.findElement(By.id("table_id"));
		//to find the number of rows
		List<WebElement> rows = elementTable.findElements(By.tagName("tr"));
		//to find the name column 
		System.out.println("The column names before sorting are : ");
		
		List<String> list1 = new ArrayList<String>();
		for (int i=1; i<rows.size();i++) {
			WebElement eachRow = rows.get(i);
			List<WebElement> col = eachRow.findElements(By.tagName("td"));
			String Name = col.get(1).getText();
			System.out.println(Name);
			list1.add(Name);
		}
		
		Collections.sort(list1);
		System.out.println("The column names after sorting are : ");
		System.out.println(list1);
		//click the sort icon under name column
		driver.findElement(By.xpath("//th[text()='Name']")).click();
		List<String> list2 = new ArrayList<String>();
		//to find the number of rows
		List<WebElement> rows2 = elementTable.findElements(By.tagName("tr"));
		for (int i=1; i<rows2.size();i++) {
			WebElement eachRow2 = rows2.get(i);
			List<WebElement> col2 = eachRow2.findElements(By.tagName("td"));
			String Name2 = col2.get(1).getText();
			System.out.println(Name2);
			list2.add(Name2);
		}
		System.out.println(list2);
		
		if (list1.equals(list2))
			System.out.println("List1 and List2 names are same and hence Sorting of Names is working ");	 
		else
			System.out.println("List1 and List2 names are not same and hence Sorting of Names not working ");	
	}

}
