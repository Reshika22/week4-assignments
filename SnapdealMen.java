package week4.day1;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List
;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;


import io.github.bonigarcia.wdm.WebDriverManager;

public class SnapdealMen {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		Thread.sleep(5000);
		WebElement menFashion = driver.findElement(By.xpath("//ul[@class='nav smallNav']//span[text()= \"Men's Fashion\"]"));
		WebElement shoe = driver.findElement(By.xpath("(//div[@class='colDataInnerBlk']//span[text()='Sports Shoes'])[1]"));
		Actions builder = new Actions(driver);
		builder.moveToElement(menFashion).pause(1000).click(shoe).perform();
		driver.findElement(By.xpath("//li[@class='child-cat-list cat-list ']//div[text()='Training Shoes']")).click();
		driver.findElement(By.xpath("//div[@class='sort-drop clearfix']//span[text()='Sort by:']")).click();
		driver.findElement(By.xpath("//div[@class='sort-drop clearfix']//span[text()='Sort by:']//following::li[2]")).click();
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		//wait.until(ExpectedConditions.)
		Thread.sleep(1000);
		List<WebElement> priceList = driver.findElements(By.xpath("//span[contains(@class, 'lfloat product-price')]"));
		int prePrice = Integer.MIN_VALUE;
		for (WebElement eachWeb : priceList) {
			int price = Integer.parseInt(eachWeb.getAttribute("display-price"));
			if(price>=prePrice)
			{
				prePrice=price;
				//System.out.println(prePrice);
			}
			else
			{
				System.out.println("Sorting is not working in Snapdeal");
				break;
			}
		}
		String minPrice = "900";
		String maxPrice = "1200";
		WebElement priceTag1 = driver.findElement(By.xpath("(//div[@class='price-text-box'])[1]/input"));
		priceTag1.clear();
		priceTag1.sendKeys(minPrice);
		WebElement priceTag2 = driver.findElement(By.xpath("(//div[@class='price-text-box'])[2]/input"));
		priceTag2.clear();
		priceTag2.sendKeys(maxPrice);
		driver.findElement(By.xpath("//div[contains(text(),'GO')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//button[contains(text(),'View More')])[1]")).click();
		Thread.sleep(2000);
		//input[@value='Navy']
		String colorName = driver.findElement(By.xpath("//a[contains(text(),'Navy')]")).getText();
				
		Thread.sleep(2000);
		driver.findElement(By.xpath("//label[@for='Color_s-Navy']")).click();
		Thread.sleep(2000);
		List<WebElement> filters = driver.findElements(By.xpath("(//div[@class='filters'])[1]//a"));
		for (WebElement webElement : filters) {
			
			String filter = webElement.getText();
			if(filter.contains(colorName)|| (filter.contains(minPrice)&&filter.contains(maxPrice))) 
			{
				System.out.println("Filter "+ filter +" is applied");
			}
			else
			{
				System.out.println("Filters are not applied");
			}
		}
		
		WebElement firstshoe = driver.findElement(By.xpath("(//section[@data-dpdat='pdt_lst'])[1]/div[1]"));
		WebElement quickview = driver.findElement(By.xpath("(//div[@class='clearfix row-disc']/div)[1]"));
		builder.moveToElement(firstshoe)
		.click(quickview)
		.perform();
		Thread.sleep(2000);
		String textprice = driver.findElement(By.xpath("//span[@class='payBlkBig']")).getText();
		String discount = driver.findElement(By.xpath("//span[contains(@class,'percent-desc')]")).getText();
		System.out.println("Price :Rs." +textprice );
		System.out.println("Discount :" +discount );
		//screenshot of the page
		File screenshotAs = driver.getScreenshotAs(OutputType.FILE);
		File desfile = new File("./SnapdealShoesPage.png");
		FileUtils.copyFile(screenshotAs, desfile);
		//snapshots of shoes
		List<WebElement> shoeImgs = driver.findElements(By.xpath("//div[@id='bx-pager-qv-image-panel']//img"));
		for (int i=0;i<shoeImgs.size();i++) {
			File screenshotAs2 = shoeImgs.get(i).getScreenshotAs(OutputType.FILE);
			File desfile2 = new File("./SnapdealShoeSnapshot"+(i+1)+".png");
			FileUtils.copyFile(screenshotAs2, desfile2);
			Thread.sleep(1000);
		}
		
		driver.findElement(By.xpath("(//i[@class='sd-icon sd-icon-delete-sign'])[3]")).click();
		driver.close();
	}

}
