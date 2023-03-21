package mailTravelTests;

import mailTravel.pages.PageBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MailTravelHomePageTests extends PageBase {

    private String searchTerm = "India";

    @Test(groups="smoke", description="checkingTitle")
    public void checkTitle() throws InterruptedException{
        log.info("-- Starting CheckTitle --- ");
        String title = mailTravelHomePage().getTitle();
        log.info("title "+ title);
        Assert.assertTrue(title.equalsIgnoreCase("Home Page | Mail Travel"),"Title is incorrect");
    }

    @Test
    public void enterSearchString(){
        // Add to commit
        mailTravelHomePage().enterIntoSearchFieldAndEnter(searchTerm);
    }


}
