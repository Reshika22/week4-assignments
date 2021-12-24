package week4.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sortable {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/sortable");
		driver.manage().window().maximize();
		driver.switchTo().frame(0);
		WebElement selectElement1 = driver.findElement(By.xpath("//ul[@id='sortable']/li[1]"));
		WebElement selectElement2 = driver.findElement(By.xpath("//ul[@id='sortable']/li[4]"));
		WebElement selectElement3 = driver.findElement(By.xpath("//ul[@id='sortable']/li[6]"));
		WebElement selectElement4 = driver.findElement(By.xpath("//ul[@id='sortable']/li[7]"));
		Actions mouse = new Actions(driver);
		mouse.dragAndDrop(selectElement4, selectElement1).perform();
		mouse.dragAndDrop(selectElement2, selectElement1).perform();
		mouse.dragAndDrop(selectElement3, selectElement1).perform();
		mouse.dragAndDrop(selectElement4, selectElement3).perform();
		
		driver.close();
	}

}
