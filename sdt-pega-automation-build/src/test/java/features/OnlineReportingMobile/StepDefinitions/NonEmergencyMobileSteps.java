package features.OnlineReportingMobile.StepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import libs.DriverFactory;
import org.testng.Assert;

public class NonEmergencyMobileSteps extends DriverFactory {

    @When("I indicate that the event is an emergency")
    public void I_indicate_that_the_event_is_an_emergency() {
        _nonEmergency.clickOnEmergencyButton("yes");
        _nonEmergency.clickOnContinueButton();
    }

    @When("I don't indicate that the event is an emergency or not")
    public void I_dont_indicate_that_the_event_is_an_emergency_or_not() {
        _nonEmergency.clickOnContinueButton();
    }


    @Then("I won’t be able to proceed on the form and appropriate error message is displayed")
    public void i_won_t_be_able_to_proceed_on_the_form() {
        Assert.assertTrue(_nonEmergency.checkIfNonEmergencyErrorIsDisplayed());
        Assert.assertEquals(_nonEmergency.getNonEmergencyErrorMessage(), "This is to report non-emergency events. Please indicate 'You are not in an emergency' situation.");
    }

    @When("I indicate that the event is not an emergency")
    public void i_indicate_that_the_event_is_not_an_emergency() throws InterruptedException {
        _nonEmergency.clickOnEmergencyButton("no");
        _nonEmergency.clickOnContinueButton();
    }

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
                    Assert.assertTrue(false, "Invalid event type entered in Feature files. Should be only Hurt or damaged or Stolen seperated by |. e.g. hurt|damaged|stolen");
            }
        }

        _nonEmergency.navigateFromNonEmergencyConfirmationPagetoThreeQuestionsPageMobile();
        _whatHappened.navigateFromThreeQuestionsPageToEventInfoPageMobile(hurt, damaged, stolen, lost, somethingElse);
        //Assert.assertEquals(_whatHappened.getCurrentPageName(), getContentData("EventInfoHeaderLink"));
    }

    @When("i am on getting started page")
    public void iAmOnGettingStartedPage() {
        _nonEmergency.isElementDisplayed(_nonEmergency.getTenFiveText());
    }

    @Then("i should be able to verify getting started information")
    public void iShouldBeAbleToVerifyGettingStartedInformation() {
        _nonEmergency.verifyGettingStartedInstructions();
    }

    @Given("a Protection Order has been breached")
    public void aProtectionOrderHasBeenBreached() {

    }

    @When("I attempt to report this via an Online Form")
    public void iAttemptToReportThisViaAnOnlineForm() {

    }

    @Then("I  can see from the “Let’s get started” page, that I should call 111 instead.")
    public void iCanSeeFromTheLetSGetStartedPageThatIShouldCallInstead() {
        Assert.assertTrue(_nonEmergency.checkMissingPersonInformation(), "Protection Order breached meesage is not displayed");
    }
}
