package stepdefinitions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BaseTest {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/sivaj/Drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testVerifyTitle() {
        // 1. Launch the URL and verify the title
        driver.get("http://the-internet.herokuapp.com/");
        String expectedTitle = "The Internet";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Page title doesn't match");
    }

    @Test(dependsOnMethods = "testVerifyTitle")
    public void testABTesting() {
        // 2. Click on A/B Testing link and verify the text
        WebElement abTestingLink = driver.findElement(By.linkText("A/B Testing"));
        abTestingLink.click();
        String expectedText = "A/B Test Variation 1";
        String actualText = driver.findElement(By.tagName("h3")).getText();
        System.out.println("The title of the Page is: " +actualText);
        Assert.assertEquals(actualText, expectedText, "Text on A/B Testing page doesn't match");
    }

    @Test(dependsOnMethods = "testABTesting")
    public void testDropdownSelection() {
        // 3. Navigate back to Home page and click on dropdown link
        driver.navigate().back();
        WebElement dropdownLink = driver.findElement(By.linkText("Dropdown"));
        dropdownLink.click();

        // 4. Select Option1 from the drop-down and confirm if it's selected
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        dropdown.findElement(By.xpath(".//option[text()='Option 1']")).click();
        Assert.assertEquals(dropdown.getAttribute("value"), "1", "Option1 is not selected");
    }

    @Test(dependsOnMethods = "testDropdownSelection")
    public void testFramesPage() {
        // 5. Navigate back to Home Page and Click on Frames
        driver.navigate().back();
        WebElement framesLink = driver.findElement(By.linkText("Frames"));
        framesLink.click();

        // 6. Verify the presence of Nested Frames and iFrame hyperlinks
        WebElement nestedFramesLink = driver.findElement(By.linkText("Nested Frames"));
        WebElement iFrameLink = driver.findElement(By.linkText("iFrame"));

        Assert.assertTrue(nestedFramesLink.isDisplayed(), "Nested Frames link is not displayed");
        Assert.assertTrue(iFrameLink.isDisplayed(), "iFrame link is not displayed");
        
    }
    
}
