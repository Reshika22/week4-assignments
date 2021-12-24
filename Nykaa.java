package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Nykaa {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://www.nykaa.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		//mouse on brands and select loreal
		Actions mouse = new Actions(driver);
		mouse.click().pause(2000).perform();
		mouse.moveToElement(driver.findElement(By.xpath("//a[text()='brands']"))).perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='brandSearchBox']")).sendKeys("L'Oreal Paris");
		driver.findElement(By.xpath("//div[@id='scroller-container']//a[text()=\"L'Oreal Paris\"]")).click();
		
		//verify the title of the page
		String title = driver.getTitle();
		if(title.contains("L'Oreal Paris"))
		{
			System.out.println("We are in L'Oreal Paris Page");
		}
		else
		{
			System.out.println("Its not L'Oreal Paris Page");
		}

		//sort by customer top rated
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@class='sort-name']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()='customer top rated']")).click();
		Thread.sleep(1000);

		//category selection
		driver.findElement(By.xpath("//span[text()='Category']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()='Hair']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()='Hair Care']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()='Shampoo']")).click();
		Thread.sleep(1000);

		//concern selection
		driver.findElement(By.xpath("//span[text()='Concern']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()='Color Protection']")).click();
		Thread.sleep(1000);
		
		//filter applied
		String shampoo = driver.findElement(By.xpath("//span[text()='Filters Applied']/..//following-sibling::div/div[1]/span")).getText();
		String colorProt = driver.findElement(By.xpath("//span[text()='Filters Applied']/..//following-sibling::div/div[2]/span")).getText();
		if((shampoo.contains(driver.findElement(By.xpath("//span[text()='Shampoo']")).getText()))
			&&(colorProt.contains(driver.findElement(By.xpath("//span[text()='Color Protection']")).getText())))
		{
			System.out.println("Filters Applied Successfully");
		}
		
		//click on the item
		driver.findElement(By.xpath("(//div/img)[1]")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windowList = new ArrayList<String>(windowHandles);
		driver.switchTo().window(windowList.get(1));
		
		//size of the item dropdown select
		driver.findElement(By.xpath("//select[@title='SIZE']")).click();
		driver.findElement(By.xpath("//select[@title='SIZE']/option[text()='175ml']")).click();
		
		//print MRP
		String cost = driver.findElement(By.xpath("(//span[text()='MRP:']//following-sibling::span)[1]")).getText();
		System.out.println("MRP:Rs. " + cost.replaceAll("[^0-9]", ""));
		
		//ADD TO CART
		driver.findElement(By.xpath("(//span[text()='ADD TO BAG'])[1]")).click();
		
		//**************** Website not loading further due to IRELAND security******************************//
		driver.quit();
	}

}
