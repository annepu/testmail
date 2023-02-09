import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

public class TestPlan {

    private static WebDriver driver;

    @BeforeTest
    public static void initialiseDriver() {
        System.setProperty("webdriver.chrome.driver",Utils.CHROME_DRIVER_LOCATION);
        driver = (WebDriver) new ChromeDriver();
    }

    @Test(description="smoke")
    public void submitFormTest(){
        driver.get(Utils.BASE_URL);
        WebForm webForm = new WebForm(driver);
        webForm.enterFirstName();
        webForm.enterLastName();
        webForm.pressSubmitButton();
    }

    @Test(description="googleSearch")
    public void getGoldFromGoogleTest() throws Exception{
        driver.get("https://www.google.co.uk/");
        driver.findElement(By.id("L2AGLb")).click();
        WebElement textBoxElement = driver.findElement(By.cssSelector(".gLFyf"));
        textBoxElement.sendKeys("Gold");
        textBoxElement.sendKeys(Keys.ENTER);
        List<WebElement> searchResults = driver.findElements(By.partialLinkText("Gold"));
        Assert.assertTrue(searchResults.size()>0,"gold is not retrieved");
    }

    @AfterTest
    public void cleanUp(){
        driver.manage().deleteAllCookies();
        driver.close();
    }
}
