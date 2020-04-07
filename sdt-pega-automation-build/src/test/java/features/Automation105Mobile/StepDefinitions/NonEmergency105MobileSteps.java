package features.Automation105Mobile.StepDefinitions;

import cucumber.api.java.en.Given;
import libs.DriverFactory;
import org.testng.Assert;

public class NonEmergency105MobileSteps extends DriverFactory {

    @Given("I am on the Event Info Page after selecting the events {string} to report")
    public void i_am_on_the_Event_Info_page(String eventTypes) {
        boolean hurt = false;
        boolean damaged = false;
        boolean stolen = false;
        boolean lost = false;
        boolean somethingElse = false;
        String[] eventArray = eventTypes.split("\\|");
        Assert.assertTrue(eventArray.length <= 3);
        for (String event : eventArray) {

            switch (event) {
                case "hurt":
                    hurt = true;
                    break;
                case "damaged":
                    damaged = true;
                    break;
                case "stolen":
                    stolen = true;
                    break;
                case "lost":
                    lost = true;
                    break;
                case "somethingElse":
                    somethingElse = true;
                    break;
                default:
                    Assert.fail("Invalid event type entered in Feature files. Should be only Hurt or damaged or Stolen seperated by |. e.g. hurt|damaged|stolen");
            }
        }

        _nonEmergency105.navigateFromNonEmergencyConfirmationPagetoThreeQuestionsPageMobile();
        _whatHappened105.navigateFromThreeQuestionsPageToEventInfoPageMobile(hurt, damaged, stolen, lost, somethingElse);
    }
}
