package week4.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import selenium.SeleniumHelper;

public class learnWindow {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = SeleniumHelper.getChromeDriver();
		SeleniumHelper.launchUrlMaximizeSetTimeouts("http://www.leafground.com/pages/Window.html", driver);
		driver.findElement(By.id("home")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> listHandles = new ArrayList<String>(windowHandles);
		driver.switchTo().window(listHandles.get(1));
		Thread.sleep(1000);
		driver.close();
		driver.switchTo().window(listHandles.get(0));
		driver.findElement(By.xpath("//button[text()='Open Multiple Windows']")).click();
		
		driver.switchTo().window(listHandles.get(0));
		driver.findElement(By.xpath("//button[text()='Do not close me ']")).click();
		
		windowHandles.clear();
		windowHandles.addAll(driver.getWindowHandles());
		listHandles.clear();
		listHandles.addAll(windowHandles);
		//System.out.println(listHandles);
		for (int i = 1; i < listHandles.size(); i++) {
			driver.switchTo().window(listHandles.get(i));
			driver.close();
		}
		
		driver.switchTo().window(listHandles.get(0));
		driver.findElement(By.xpath("//button[text()='Wait for 5 seconds']")).click();
		driver.quit();
	}

}
