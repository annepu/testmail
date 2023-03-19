package mailTravel.pages;

import mailTravel.framework.EnvironmentConfiguration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MailTravelHomePage  extends PageBase {

    @FindBy(id="searchtext_freetext_search_form")
    public static WebElement SEARCH_BOX;

    protected WebDriver driver;

    public  MailTravelHomePage(WebDriver webDriver){
        this.driver= webDriver;
        driver.navigate().to(EnvironmentConfiguration.getBaseURL());
    }

    public String getTitle() throws InterruptedException {
       // driver.manage().wait(5000);
        return  driver.getTitle();
    }

    private void enterIntoSearchField(String searchTerm ){
        SEARCH_BOX.click();
    }

    private void clickSearch(){

    }

}
