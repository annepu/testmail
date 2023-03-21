package mailTravel.pages;

import mailTravel.framework.Helpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MailTravelSearchPage extends PageBase{

    protected WebDriver driver;

	@FindBy(xpath="//span[contains(text(),'11 Days - Classic Escorted Tours')]")
	private static WebElement TOUR_DESCRIPTION;

	private static final By TOUR_INDIA_MORE_INFO= By.cssSelector("a[title='Tour - India']");


    public  MailTravelSearchPage(WebDriver webDriver){
        this.driver= webDriver;
    }

    public boolean isTourDescriptionDisplayed(){
        return TOUR_DESCRIPTION.isDisplayed();
    }

    public  void  clickMoreInfo(){
        Helpers.waitForIsDisplayed(driver,TOUR_INDIA_MORE_INFO,20);
        driver.findElement(TOUR_INDIA_MORE_INFO).click();
    }
}

