package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafgroundSortable {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/sorttable.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//List1
		List<WebElement> rowCount = driver.findElements(By.xpath("//tbody/tr"));
		List<String> nameList = new ArrayList<String>();
		for (int i = 1; i <= rowCount.size(); i++) 
		{
			String name = driver.findElement(By.xpath("//tbody/tr["+i+"]/td[2]")).getText();
			nameList.add(name);
			Collections.sort(nameList);
		}
		System.out.println("Sorted List 1: " +nameList);
		//List2
		driver.findElement(By.xpath("//th[text()='Name']")).click();
		Thread.sleep(1000);
		List<String> nameList1 = new ArrayList<String>();
		for (int i = 1; i <= rowCount.size(); i++) 
		{
			String name = driver.findElement(By.xpath("//tbody/tr["+i+"]/td[2]")).getText();
			nameList1.add(name);
		}
		System.out.println("Sorted List 2: " +nameList1);
		if(nameList.equals(nameList1))
		{
			System.out.println("Both List are equal");
		}
		else
		{
			System.out.println("Both List are not equal");
		}
		
		//Thread.sleep(1000);
		driver.quit();
	}

}
