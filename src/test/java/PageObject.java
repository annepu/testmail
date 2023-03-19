import org.openqa.selenium.WebDriver;

public class PageObject {
    protected WebDriver driver;

    public PageObject(WebDriver driver){
      //  PageFactory.initElements(driver, this);
        System.setProperty("webdriver.chrome.driver",Utils.CHROME_DRIVER_LOCATION);
    }
}
