package week4.day1;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FrameLeafgrounds {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/frame.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.switchTo().frame(0);
		WebElement clickMe = driver.findElement(By.id("Click"));
		File srcFile = clickMe.getScreenshotAs(OutputType.FILE);
		File desFile = new File("./CLICKME.png");
		FileUtils.copyFile(srcFile, desFile);
		clickMe.click();
		driver.switchTo().parentFrame();
		driver.switchTo().frame(1);
		driver.switchTo().frame("frame2");
		driver.findElement(By.id("Click1")).click();
		driver.switchTo().defaultContent();
		List<WebElement> framesCount = driver.findElements(By.tagName("iframe"));
		int count = framesCount.size();
		for (int i = 0; i < framesCount.size(); i++) {
			driver.switchTo().frame(i);
			count += driver.findElements(By.tagName("iframe")).size();
			driver.switchTo().defaultContent();
		}
		System.out.println("Total Number of Frames : "+count);
	}

}
