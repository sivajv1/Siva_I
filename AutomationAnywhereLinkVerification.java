import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.lang.*;

public class AutomationAnywhereLinkVerification {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:/Users/sivaj/Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.automationanywhere.com/");
		verifyAndClickLink(driver, "Products");
		verifyAndClickLink(driver, "Solutions");
		verifyAndClickLink(driver, "Resources");
		verifyAndClickLink(driver, "Company");
		driver.quit();
	}

	public static void verifyAndClickLink(WebDriver driver, String linkText) {
		WebElement link = driver.findElement(By.xpath("//a[text()='" + linkText + "']"));
		if (link.isDisplayed()) {
			System.out.println("Link '" + linkText + "' is present on the page.");
			link.click();
			System.out.println("Navigated to: " + driver.getCurrentUrl());
		} else {
			System.out.println("Link '" + linkText + "' is not present on the page.");
		}

		driver.navigate().back();
	}
}
