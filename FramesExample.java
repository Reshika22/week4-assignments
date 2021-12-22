package week4.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FramesExample {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.switchTo().frame("frame1");
		driver.findElement(By.xpath("//b[@id='topic']//following-sibling::input")).sendKeys("Selenium");
		driver.switchTo().frame("frame3");
		driver.findElement(By.xpath("//b[text()='Inner Frame Check box :']//following-sibling::input")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("frame2");
		driver.findElement(By.xpath("//b[text()='Animals :']//following-sibling::select/option[4]")).click();
		driver.close();
	}

}
