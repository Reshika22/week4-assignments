package week4.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Resizable {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/resizable");
		driver.manage().window().maximize();
		driver.switchTo().frame(0);
		WebElement resizeElement = driver.findElement(By.xpath("//div[@id='resizable']/div[3]"));
		Dimension size = driver.findElement(By.xpath("//div[@id='resizable']/div[3]")).getSize();
		System.out.println(size);
		Actions mouse = new Actions(driver);
		mouse.doubleClick(resizeElement).dragAndDropBy(resizeElement, size.getWidth()+100, size.getHeight()+100).perform();
		//driver.close();
	}

}
