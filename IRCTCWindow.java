package week4.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import selenium.SeleniumHelper;

public class IRCTCWindow {

	public static void main(String[] args) {
		ChromeDriver driver = SeleniumHelper.getChromeDriver();
		SeleniumHelper.launchUrlMaximizeSetTimeouts("https://www.irctc.co.in/nget/train-search", driver);
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		driver.findElement(By.linkText("FLIGHTS")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> handlesList = new ArrayList<String>(windowHandles);
		String handleName = handlesList.get(1);
		//driver.close();
		driver.switchTo().window(handleName);
		String title = driver.getTitle();
		System.out.println("Title of the Second Page :" + title);
		driver.switchTo().window( handlesList.get(0));
		driver.close();
		
	}

}
