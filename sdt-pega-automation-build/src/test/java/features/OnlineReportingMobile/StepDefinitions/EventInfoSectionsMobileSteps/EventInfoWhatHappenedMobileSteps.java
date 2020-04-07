package features.OnlineReportingMobile.StepDefinitions.EventInfoSectionsMobileSteps;

import cucumber.api.java.en.When;
import libs.DriverFactory;

public class EventInfoWhatHappenedMobileSteps extends DriverFactory {

    @When("I key in the details of what happened")
    public void i_key_in_the_details_of_what_happened() {
        _eventInfo.keyInDetailsRelatedToWhatHappened();
        //_eventWhatHappenedMobile.keyInWhatHappenedRelatedFields();
    }

    @When("I click on continue to navigate to attachment page")
    public void i_click_on_continue_to_navigate_to_attachment_page() {
        _eventInfo.clickOnContinueButtonFromEventInfoPageMobile();
        //_eventWhatHappenedMobile.clickOnContinueButtonFromEventInfoPage();
    }


    @When("I key in more information about the event i want to report")
    public void I_key_in_more_information_about_the_event_i_want_to_report() {
        _eventInfo.keyInDetailsRelatedToWhatHappenedSomethingElseEvent();
    }


}
