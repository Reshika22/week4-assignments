package week4.day1;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import selenium.SeleniumHelper;

public class LearnAlerts {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeDriver driver = SeleniumHelper.getChromeDriver();
		SeleniumHelper.launchUrlMaximizeSetTimeouts("http://www.leafground.com/pages/Alert.html", driver);
		driver.findElement(By.xpath("//button[text()='Alert Box']")).click();
		Alert simpleAlert = driver.switchTo().alert();
		Thread.sleep(1000);
		simpleAlert.accept();
		driver.findElement(By.xpath("//button[text()='Confirm Box']")).click();
		Alert confirmAlert = driver.switchTo().alert();
		Thread.sleep(1000);
		confirmAlert.dismiss();
		driver.findElement(By.xpath("//button[text()='Prompt Box']")).click();
		Alert promptAlert = driver.switchTo().alert();
		promptAlert.sendKeys("Selenium Institute");
		Thread.sleep(1000);
		promptAlert.accept();
		driver.findElement(By.xpath("//button[text()='Line Breaks?']")).click();
		Alert lineAlert = driver.switchTo().alert();
		Thread.sleep(1000);
		lineAlert.accept();
		driver.findElement(By.xpath("//button[text()='Sweet Alert']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text()='OK']")).click();

	}

}
