package features.Automation105Mobile.StepDefinitions.EventInfoSectionMobileSteps;

import cucumber.api.java.en.When;
import libs.DriverFactory;

public class EventInfoLocation105MobileSteps extends DriverFactory {

    @When("I key in the details of event location and continue to next page")
    public void I_key_in_the_details_of_event_location() {
        String location = _retrieveTestData.extractDataOffDataFile("eventLocation.locationType");
        _eventLocation105.selectEventLocation(location);
        _eventLocation105.keyInEventLocationAddressUsingLookUp();
        _eventLocation105.keyInEventLocationAdditionalInformationAndNameOfApplicableEventsTypes(location);
        _eventLocation105.selectProximityToEventLocation();
        _eventLocation105.clickOnContinueButtonFromEventLocationPage();
    }
}
