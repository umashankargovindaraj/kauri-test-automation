package features.Automation105Mobile.StepDefinitions.EventInfoSectionMobileSteps;

import cucumber.api.java.en.When;
import libs.DriverFactory;

public class EventInfoTimeOfIncident105MobileSteps extends DriverFactory {

    @When("I enter the date and time of the event")
    public void i_enter_the_date_and_time_of_the_event() {
        _eventTime105.selectEventDateTimeFromDataFileMobile();
    }

    @When("I key in the details of Event time and continue to next page")
    public void i_key_in_the_details_of_Event_time_and_continue_to_next_page() {
        _eventTime105.selectEventDateTimeFromDataFileMobile();
        _eventTime105.clickOnContinueButtonMobile();
    }
}
