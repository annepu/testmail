package mailTravel.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class OverviewPage extends PageBase{

    protected WebDriver driver;

	@FindBy(linkText="Overview")
	private static WebElement OVERVIEW_TAB;
	@FindBy(linkText="Dates & Prices")
	private static WebElement DATES_PRICES_TAB;
	@FindBy(id="supplier-phone")
	private static WebElement TELEPHONE;
	@FindBy(css=".nbf_tpl_pms_calendar_price .ibecurr")
	private WebElement DEPARTURE_DATE;
	@FindBy(css="..nbf_fancyimg_pms_add_button")
	private static List<WebElement> BOOK_ONLINE_BUTTON;

    public  OverviewPage(WebDriver webDriver){
        this.driver= webDriver;
    }

    public void checkPriceOnOverviewPage(){
        DATES_PRICES_TAB.isDisplayed();
        // TODO check Price info
    }

    public boolean isOverviewTabDisplayed(){
        return  OVERVIEW_TAB.isDisplayed();
    }

    public String  getTelephoneNumber(){
        return TELEPHONE.getText();
    }

    public OverviewPage selectDepartureDate(){
        DEPARTURE_DATE.click();
        return this;
    }

    public OverviewPage clickBookOnlineButton(){
        BOOK_ONLINE_BUTTON.get(0).click();
        return this;
    }

}
