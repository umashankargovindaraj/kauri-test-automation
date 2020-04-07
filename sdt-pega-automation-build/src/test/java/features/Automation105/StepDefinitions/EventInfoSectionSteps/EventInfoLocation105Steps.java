package features.Automation105.StepDefinitions.EventInfoSectionSteps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import libs.DriverFactory;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

public class EventInfoLocation105Steps extends DriverFactory {

    @When("I key in the details of event location")
    public void I_key_in_the_details_of_event_location() {
        String location = _retrieveTestData.extractDataOffDataFile("eventLocation.locationType");
        _eventLocation105.selectEventLocation(location);
        _eventLocation105.keyInEventLocationAdditionalInformationAndNameOfApplicableEventsTypes(location);
        _eventLocation105.keyInEventLocationAddressUsingLookUp();
        _eventLocation105.selectProximityToEventLocation();
    }

    @When("I key in the details of event location with manually keyed in address")
    public void I_key_in_the_details_of_event_location_with_manually_keyed_in_address(DataTable locationFields) {
        List<Map<String, String>> listLocationFields = _eventInfo105.getCucumberDataAsList(locationFields);
        Assert.assertTrue(listLocationFields.size() >= 1, "Data not found. Please mention the fields required for manual address entry in a datatable format");
        String location = _retrieveTestData.extractDataOffDataFile("eventLocation.locationType");
        _eventLocation105.selectEventLocation(location);
        _eventLocation105.keyInEventLocationAdditionalInformationAndNameOfApplicableEventsTypes(location);
        _eventLocation105.clickCantFindAddressCheckBox();
        _addressManualEntry105.keyInLocationAddressManually(listLocationFields);
        _eventLocation105.selectProximityToEventLocation();

    }

    /*@And("I key in event location manually for only mandatory detail")
    public void iKeyInEventLocationManuallyForOnlyMandatoryDetail() {
        String location = _retrieveTestData.extractDataOffDataFile("eventLocation.locationType");
        _eventLocation105.selectEventLocation(location);
        _eventLocation105.keyInDetailsForEventTypeOrganisationWithSubburbOnly();
    }*/
}
