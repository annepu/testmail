package mailTravelTests;

import mailTravel.pages.PageBase;
import org.testng.annotations.Test;

public class MailTravelSearchTests extends PageBase {

    @Test
    public void  checkMoreInfo() throws InterruptedException{
        log.info("-- Starting checkMoreInfo --- ");
        mailTravelSearchPage().isTourDescriptionDisplayed();
        mailTravelSearchPage().clickMoreInfo();
    }

}
