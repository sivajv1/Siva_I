import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class HomePageVerification {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/sivaj/Drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.automationanywhere.com/");
    }

    @Test(priority = 1, enabled = true, timeOut = 3000)
    public void verifyProductsLink() {
        WebElement productsLink = driver.findElement(By.linkText("Products"));
        Assert.assertTrue(productsLink.isDisplayed());
        productsLink.click();
      }

    @Test(priority = 2, enabled = true, timeOut = 3000)
    public void verifySolutionsLink() {
        WebElement solutionsLink = driver.findElement(By.linkText("Solutions"));
        Assert.assertTrue(solutionsLink.isDisplayed());
        solutionsLink.click();
      }

    @Test(priority = 3, enabled = true, timeOut = 3000)
    public void verifyResourcesLink() {
        WebElement resourcesLink = driver.findElement(By.linkText("Resources"));
        Assert.assertTrue(resourcesLink.isDisplayed());
        resourcesLink.click();
       }

		/*
		 * @Test(priority = 4, enabled = true, timeOut = 3000) public void
		 * verifyBeyondRPALink() { WebElement beyondRPALink =
		 * driver.findElement(By.linkText("Beyond RPA"));
		 * Assert.assertTrue(beyondRPALink.isDisplayed()); beyondRPALink.click(); }
		 */
    @Test(priority = 5, enabled = true, timeOut = 3000)
    public void verifyCompanyLink() {
        WebElement companyLink = driver.findElement(By.linkText("Company"));
        Assert.assertTrue(companyLink.isDisplayed());
        companyLink.click();
        }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
