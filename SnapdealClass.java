package week4.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import selenium.SeleniumHelper;

public class SnapdealClass {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = SeleniumHelper.getChromeDriver();
		SeleniumHelper.launchUrlMaximizeSetTimeouts("https://www.snapdeal.com/", driver);
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		Actions builder = new Actions(driver);
		WebElement menFashion = driver.findElement(By.xpath("//li[@navindex='5']//span[@class= 'catText']"));
		WebElement shirt = driver.findElement(By.xpath("(//span[text()='Shirts'])[1]"));
		//builder.moveToElement(menFashion).perform();//.pause(1000).click(shirts).perform();
		Thread.sleep(5000);		
		builder.moveToElement(menFashion).pause(1000).click(shirt).perform();
		WebElement firstShirt = driver.findElement(By.xpath("(//div[@class='product-tuple-image ']//img)[1]"));
		WebElement quickView = driver.findElement(By.xpath("(//div[@class='product-tuple-image ']//img)[1]//following::div[1]/div"));
		builder.moveToElement(firstShirt).click(quickView).perform();
		driver.quit();
	}

}
