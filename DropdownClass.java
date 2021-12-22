package week4.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import selenium.SeleniumHelper;

public class DropdownClass {

	public static void main(String[] args) {
		ChromeDriver driver = SeleniumHelper.getChromeDriver();
		SeleniumHelper.launchUrlMaximizeSetTimeouts("http://leafground.com/pages/Dropdown.html", driver);
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		Actions action = new Actions(driver);
		WebElement item1 = driver.findElement(By.xpath("//select[@multiple='']/option[2]"));
		WebElement item2 = driver.findElement(By.xpath("//select[@multiple='']/option[5]"));
		action.keyDown(Keys.CONTROL).click(item1).click(item2).keyUp(Keys.CONTROL).perform();

	}

}
