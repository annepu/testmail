package mailTravel.pages;

import mailTravel.framework.TestBase;
import org.openqa.selenium.support.PageFactory;

public class PageBase extends TestBase {

    public MailTravelHomePage mailTravelHomePage(){
        return  PageFactory.initElements(driver,MailTravelHomePage.class);
    }



}
