package week4.day1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();

		//search 
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("oneplus 9 pro",Keys.ENTER);
		Thread.sleep(2000);

		//get price
		String firstCost = driver.findElement(By.xpath("(//a[1]/span[@class='a-price'])[1]//span[@class='a-price-whole']")).getText();
		System.out.println("Deal Price of the first Product : Rs." +firstCost);

		//customer ratings
		String cusRating = driver.findElement(By.xpath("(//div[@class='a-row a-size-small'])[1]/span[2]//span")).getText();
		System.out.println("Number of Customer Ratings for the first Product : " +cusRating);

		//mouse hover on ratings and get percentage for 5%
		WebElement stars = driver.findElement(By.xpath("(//i[@class='a-icon a-icon-star-small a-star-small-4-5 aok-align-bottom'])[1]"));
		Actions mouse = new Actions(driver);
		mouse.click(stars).perform();
		Thread.sleep(1000);
		String star1 = driver.findElement(By.xpath("(//span[@class='a-size-base']/a)[2]")).getText();
		System.out.println("5 star Rating Percentage for the first Product : "+star1);

		//click on the text of first product
		driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windowList = new ArrayList<String>(windowHandles);
		driver.switchTo().window(windowList.get(1));

		//Screenshot
		File screenshotAs = driver.getScreenshotAs(OutputType.FILE);
		File desfile = new File("./Amazon.png");
		FileUtils.copyFile(screenshotAs, desfile);

		//add to cart
		driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
		Thread.sleep(3000);

		//verify the total
		String subTotal = ((driver.findElement(By.xpath("//span[@id='attach-accessory-cart-subtotal']")).getText()).replaceAll("[^0-9]", ""));
		String subCalc = subTotal.substring(0, subTotal.length()-2);
		//System.out.println(subCalc +" , "+firstCost);
		if(subCalc.equals(firstCost.replaceAll("[^0-9]", "")))
		{
			System.out.println("Cart Verified.Proceed to Payment.");
		}
		else
		{
			System.out.println("Check the cart.Amount mismatch");
		}
		driver.quit();
	}

}
