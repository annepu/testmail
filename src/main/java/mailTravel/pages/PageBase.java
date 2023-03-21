package mailTravel.pages;

import mailTravel.framework.TestBase;
import org.openqa.selenium.support.PageFactory;

public class PageBase extends TestBase {

    public MailTravelHomePage mailTravelHomePage(){
        return  PageFactory.initElements(driver,MailTravelHomePage.class);}

    public MailTravelSearchPage mailTravelSearchPage(){
        return  PageFactory.initElements(driver,MailTravelSearchPage.class);}

    public OverviewPage overviewPage(){
        return  PageFactory.initElements(driver,OverviewPage.class);}

    public PassengerDetailsPage passengerDetailsPage(){
        return  PageFactory.initElements(driver,PassengerDetailsPage.class);}

    public AccommodationPage accommodationPage(){
        return  PageFactory.initElements(driver,AccommodationPage.class);}

    public ConfirmDetailsPage confirmDetailsPage(){
        return  PageFactory.initElements(driver,ConfirmDetailsPage.class);}

}
