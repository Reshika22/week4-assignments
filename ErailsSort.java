package week4.day1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import selenium.SeleniumHelper;

public class ErailsSort {

	public static void main(String[] args) throws InterruptedException {

		ChromeDriver driver = SeleniumHelper.getChromeDriver();
		SeleniumHelper.launchUrlMaximizeSetTimeouts("https://erail.in/", driver);
		WebElement fromStation = driver.findElement(By.id("txtStationFrom"));
		fromStation.clear();
		fromStation.sendKeys("ms",Keys.TAB);
		WebElement toStation = driver.findElement(By.id("txtStationTo"));
		toStation.clear();
		toStation.sendKeys("mdu",Keys.TAB);
		driver.findElement(By.id("buttonFromTo")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("chkSelectDateOnly")).click();
		int rowCount = driver.findElements(By.xpath("//table[@class='DataTable TrainList TrainListHeader']//tr")).size();
		List<String> trainNames = new ArrayList<String>();
		//System.out.println(rowCount);
		for (int i = 1; i <= rowCount; i++) {

			String trainName = driver.findElement(By.xpath("//table[@class='DataTable TrainList TrainListHeader']//tr["+i+"]/td[2]")).getText();
			//System.out.println(trainNames);
			trainNames.add(trainName);
			
		}
		Collections.sort(trainNames);
		System.out.println("Sorted Train Names : "+trainNames);
		driver.close();
	}
}


