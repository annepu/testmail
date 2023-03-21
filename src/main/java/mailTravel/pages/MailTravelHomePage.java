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

    protected WebDriver driver;

    public  MailTravelHomePage(WebDriver webDriver){
        this.driver= webDriver;
        driver.navigate().to(EnvironmentConfiguration.getBaseURL());}

    public String getTitle() throws InterruptedException {
        return  driver.getTitle();}

    public void enterIntoSearchFieldAndEnter(String searchTerm ){
        clickSearchBox();
        Helpers.clearAndSetText(driver,SEARCH_BOX,searchTerm);
        SEARCH_BOX.sendKeys(Keys.ENTER);
        Helpers.waitForIsDisplayed(driver, By.cssSelector("#reset-filters"),20);}

    public void clickSearchBox(){
        SEARCH_BOX.click();}

}
