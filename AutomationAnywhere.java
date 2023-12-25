import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutomationAnywhere {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:/Users/sivaj/Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.automationanywhere.com/");
		driver.manage().window().maximize();
		WebElement logo = driver.findElement(By.xpath("//img[@alt='Automation Anywhere']"));
		if (logo.isDisplayed()) {
			System.out.println("Automation Anywhere logo is present.");
		} else {
			System.out.println("Automation Anywhere logo is not present.");
		}
		WebElement requestDemoButton = driver.findElement(By.xpath("//a[@title='Request demo']"));
		if (requestDemoButton.isDisplayed()) {
			System.out.println("Request demo button is present.");
			if (requestDemoButton.isEnabled()) {
				System.out.println("Request demo button is clickable.");
			} else {
				System.out.println("Request demo button is not clickable.");
			}
		} else {
			System.out.println("Request demo button is not present.");
		}

	}
}
