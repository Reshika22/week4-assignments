package week4.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Selectable {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/selectable");
		driver.manage().window().maximize();
		driver.switchTo().frame(0);
		WebElement selectElement1 = driver.findElement(By.xpath("//ol/li[1]"));
		WebElement selectElement2 = driver.findElement(By.xpath("//ol/li[3]"));
		WebElement selectElement3 = driver.findElement(By.xpath("//ol/li[5]"));
		WebElement selectElement4 = driver.findElement(By.xpath("//ol/li[7]"));
		Actions mouse = new Actions(driver);
		mouse.moveToElement(selectElement1)
		.clickAndHold()
		.moveToElement(selectElement4)
		.release()
		.perform();
		
		mouse.click(selectElement1)
		.keyDown(Keys.CONTROL)
		.click(selectElement2)
		.click(selectElement3)
		.click(selectElement4)
		.keyUp(Keys.CONTROL)
		.perform();
		driver.close();
	}

}
