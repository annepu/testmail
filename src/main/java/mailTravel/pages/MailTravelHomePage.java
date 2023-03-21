package mailTravel.pages;

import mailTravel.framework.EnvironmentConfiguration;
import mailTravel.framework.Helpers;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MailTravelHomePage  extends PageBase {

    @FindBy(id="searchtext_freetext_search_form")
    public static WebElement SEARCH_BOX;

    public  static final By MORE_INFO = By.xpath("");

    protected WebDriver driver;

    public  MailTravelHomePage(WebDriver webDriver){
        this.driver= webDriver;
        driver.navigate().to(EnvironmentConfiguration.getBaseURL());
    }

    public String getTitle() throws InterruptedException {
        return  driver.getTitle();
    }

    private void enterIntoSearchFieldAndEnter(String searchTerm ){
        clickSearchBox();
        Helpers.clearAndSetText(driver,SEARCH_BOX,searchTerm);
        SEARCH_BOX.sendKeys(Keys.ENTER);
    }

    private void clickSearchBox(){
        SEARCH_BOX.click();
    }


}
