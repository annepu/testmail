package mailTravel.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MailTravelSearchPage extends PageBase{

    protected WebDriver driver;

	@FindBy(xpath="//span[contains(text(),'11 Days - Classic Escorted Tours')]")
	private static WebElement TOUR_DESCRIPTION;
	@FindBy(css="a[title='Tour - India']")
	private static WebElement TOUR_INDIA_MORE_INFO;


    public  MailTravelSearchPage(WebDriver webDriver){
        this.driver= webDriver;
    }

    public boolean isTourDescriptionDisplayed(){
        return TOUR_DESCRIPTION.isDisplayed();
    }

    public  void  clickMoreInfo(){
        TOUR_INDIA_MORE_INFO.click();
    }
}

