package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click(); 
		driver.findElement(By.linkText("CRM/SFA")).click(); 
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.linkText("Merge Contacts")).click();
		driver.findElement(By.xpath("(//a//img[@alt='Lookup'])[1]")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> listHandles = new ArrayList<String>(windowHandles);
		driver.switchTo().window(listHandles.get(1));
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//td[contains(@class,'x-grid3-col x-grid3-cell x-grid3-td-partyId x-grid3-cell-first')])[1]//a")).click();
		driver.switchTo().window(listHandles.get(0));
		driver.findElement(By.xpath("(//a//img[@alt='Lookup'])[2]")).click();
		windowHandles.addAll(driver.getWindowHandles());
		listHandles.clear();
		listHandles.addAll(windowHandles);
		//System.out.println(listHandles);
		driver.switchTo().window(listHandles.get(2));
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//td[contains(@class,'x-grid3-col x-grid3-cell x-grid3-td-partyId x-grid3-cell-first')])[2]//a")).click();
		driver.switchTo().window(listHandles.get(0));
		driver.findElement(By.linkText("Merge")).click(); 
		Alert alert = driver.switchTo().alert();
		alert.accept();
		String title = driver.getTitle();
		if(title.contains("View Contact")) {
			System.out.println("View Contact page");
		}
		else
		{
			System.out.println("Its not View Contact Page ");
		}
		driver.close();
	}

}
