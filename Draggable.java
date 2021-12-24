package week4.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Draggable {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/draggable");
		driver.manage().window().maximize();
		driver.switchTo().frame(0);
		WebElement dragElement = driver.findElement(By.id("draggable"));
		Point location = driver.findElement(By.id("draggable")).getLocation();
		System.out.println(location.getX()+","+location.getY());
		Actions mouse = new Actions(driver);
		mouse.dragAndDropBy(dragElement, location.getX()+100, location.getY()+10).perform();
		driver.close();
	}

}
