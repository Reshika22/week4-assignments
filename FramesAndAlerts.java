package week4.day1;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import selenium.SeleniumHelper;

public class FramesAndAlerts {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeDriver driver = SeleniumHelper.getChromeDriver();
		SeleniumHelper.launchUrlMaximizeSetTimeouts("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_prompt", driver);
		driver.findElement(By.id("accept-choices")).click();
		driver.switchTo().frame("iframeResult");
		driver.findElement(By.xpath("//button[text()='Try it']")).click();
		Alert alert = driver.switchTo().alert();
		alert.sendKeys("Reshika");
		alert.accept();
		String text = driver.findElement(By.xpath("//p[@id='demo']")).getText();
		if(text.contains("Reshika"))
		{
			System.out.println("Reshika is updated in the text");
		}
		driver.close();
	}

}
