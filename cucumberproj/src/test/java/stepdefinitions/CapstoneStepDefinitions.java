package stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.en.*;

public class CapstoneStepDefinitions extends BaseTest{

    WebDriver driver;

    @Given("I launch the URL {string}")
    public void iLaunchTheURL(String url) {
        System.setProperty("webdriver.chrome.driver", "C:/Users/sivaj/Drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(url);
    }

    @Then("the title of the page should be {string}")
    public void theTitleOfThePageShouldBe(String expectedTitle) {
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @When("I click on the link {string}")
    public void iClickOnTheLink(String linkText) {
        WebElement link = driver.findElement(By.linkText(linkText));
        link.click();
    }

    @Then("the text on the page should be {string}")
    public void theTextOnThePageShouldBe(String expectedText) {
        WebElement body = driver.findElement(By.tagName("body"));
        String actualText = body.getText();
        Assert.assertTrue(actualText.contains(expectedText));
    }

    @And("I navigate back to the Home page")
    public void iNavigateBackToTheHomePage() {
        driver.navigate().back();
    }

    @And("I select {string} from the dropdown")
    public void iSelectFromTheDropdown(String option) {
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        dropdown.click();

        WebElement optionElement = dropdown.findElement(By.xpath("//option[text()='" + option + "']"));
        optionElement.click();
    }

    @Then("{string} should be selected")
    public void shouldBeSelected(String option) {
        WebElement selectedOption = driver.findElement(By.xpath("//option[text()='" + option + "'][@selected='selected']"));
        Assert.assertNotNull(selectedOption);
    }

    @Then("the link {string} should be presented")
    public void theLinkShouldBePresented(String linkText) {
        WebElement link = driver.findElement(By.linkText(linkText));
        Assert.assertNotNull(link);
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }
}
