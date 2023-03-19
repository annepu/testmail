import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

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

    @AfterTest
    public void cleanUp(){
        driver.manage().deleteAllCookies();
        driver.close();
    }
}
