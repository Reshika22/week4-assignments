package week4.day1;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Myntra {

	public static void main(String[] args) throws InterruptedException, IOException {

		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://www.myntra.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		//Mouse hover to Men and click Jackets
		WebElement men = driver.findElement(By.xpath("//a[@class='desktop-main'][@data-group='men']"));
		WebElement jacket = driver.findElement(By.xpath("(//a[text()='Jackets'])[1]"));
		Actions mouse = new Actions(driver);
		mouse.moveToElement(men).pause(Duration.ofSeconds(2))
		.click(jacket)
		.perform();

		//Total count check
		String totalCount = driver.findElement(By.xpath("//span[@class='title-count']")).getText();
		int totalIntCount = Integer.parseInt(totalCount.replaceAll("[\\D*]", ""));
		// System.out.println("***"+totalIntCount);
		List<WebElement> countItems = driver.findElements(By.xpath("//span[@class='categories-num']"));
		int total = 0;
		for (WebElement eachItem : countItems) {
			String count = eachItem.getText();
			String newStr = count.replaceAll("[\\D*]", "");
			// System.out.println(newStr);
			total += Integer.parseInt(newStr);
		}
		// System.out.println(total);
		if(total==totalIntCount)
		{
			System.out.println("Total Count of items Matches the whole total");
		}
		else
		{
			System.out.println("Total Count of items not matching the whole total");
		}

		// jackets checkbox
		driver.findElement(By.xpath("(//label[contains(@class, 'common-customCheckbox')])[1]")).click();
		Thread.sleep(1000);

		// more brands
		driver.findElement(By.xpath("//div[@class='brand-more']")).click();
		Thread.sleep(1000);

		// type duke
		driver.findElement(By.xpath("//input[@type='text'][@placeholder='Search brand']")).sendKeys("Duke");

		// Duke checkbox
		driver.findElement(By.xpath("//input[@type='checkbox'][@value='Duke']//..")).click();

		// pop up close button x
		driver.findElement(By.xpath("//span[contains(@class, 'FilterDirectory-close')]")).click();
		Thread.sleep(1000);

		// all producs brand name
		List<WebElement> prodList = driver.findElements(By.xpath("//ul[@class='results-base']//h3[@class='product-brand']"));
		boolean flag = false;
		for (WebElement eachProd : prodList) {
			String prodBrand = eachProd.getText();
			if(prodBrand.contains("Duke"))
			{
				flag = true;
			}			
		}

		if(flag)
		{
			System.out.println("All Products belongs to brand Duke");
		}
		else
		{
			System.out.println("All Products donot belongs to brand Duke");
		}
		
		//sort by Better discount
		driver.findElement(By.xpath("//div[@class='sort-sortBy']")).click();
		driver.findElement(By.xpath("//div[@class='sort-sortBy']//label[text()='Better Discount']")).click();
		
		//first Image click
		driver.findElement(By.xpath("(//picture/img)[1]")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windowList = new ArrayList<String>(windowHandles);
		driver.switchTo().window(windowList.get(1));
		
		//get price
		System.out.println(driver.findElement(By.xpath("//span[@class='pdp-price']/strong")).getText());
		File screenshotAs = driver.getScreenshotAs(OutputType.FILE);
		File desfile = new File("./MyntraJacket.png");
		FileUtils.copyFile(screenshotAs, desfile);
		
		//click wishlist
		driver.findElement(By.xpath("//span[text()='WISHLIST']")).click();
		driver.quit();
	}

}
