package week4.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Appear {

	public static void main(String[] args)  {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/appear.html");
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement findElement = driver.findElement(By.xpath("//button[@id='btn']/b"));
		wait.until(ExpectedConditions.visibilityOf(findElement));
		boolean displayed = findElement.isDisplayed();
		String text = findElement.getText();
		if(displayed)
		{
		System.out.println("Text dispalyed is :" + text);
		}
		//Thread.sleep(1000);
		driver.quit();
	}

}
