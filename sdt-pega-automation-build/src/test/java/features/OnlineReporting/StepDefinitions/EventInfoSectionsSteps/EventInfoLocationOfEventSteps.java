package features.OnlineReporting.StepDefinitions.EventInfoSectionsSteps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import libs.DriverFactory;
import org.testng.Assert;

public class EventInfoLocationOfEventSteps extends DriverFactory {

    @When("I select the Event {string} from a dropdown in the Where did it happen section")
    public void i_select_the_Event_Location_from_a_dropdown_in_the_Where_did_it_happen_section(String location) {
        _eventLocation.selectLocation(location);
        _persistentData.setContext("whereDidItHappen.location", location);
    }

    @When("I select the Event Location from a dropdown in the Where did it happen section")
    public void i_select_the_Event_Locations_from_a_dropdown_in_the_Where_did_it_happen_section() {
        String location = _generateTestData.generateValidData("whereDidItHappen.location");
        _persistentData.setContext("whereDidItHappen.location", location);
        _eventLocation.selectLocation(location);
    }

    @Then("I should see sections relevant to Location Type")
    public void i_should_see_sections_relevant_to_Location_Type() {
        String location = (String) _persistentData.getContext("whereDidItHappen.location");
    }


    @When("I key in the details of event location")
    public void I_key_in_the_details_of_event_location() {
        String location = _generateTestData.generateValidData("whereDidItHappen.location");
        _eventLocation.selectLocation(location);
        _eventLocation.keyInRequiredDataOnToWhereDidItHappenSection(location);
    }

    @When("I key in the details of event location with manually keyed in address")
    public void I_key_in_the_details_of_event_location_with_manually_keyed_in_address() {
        String location = _generateTestData.generateValidData("whereDidItHappen.location");
        _eventLocation.selectLocation(location);
        _eventLocation.keyInRequiredDataOnToWhereDidItHappenSection(location, true);
    }


    @When("I indicate that the something is damaged at a location and key in it's details")
    public void i_indicate_that_the_someone_is_damaged_at_a_and_key_in_it_s_details() {
        /*JsonNode jsonData = (JsonNode) _scenarioContext.getContext("testData");
        String location = getRandomValueFromList(getDataFromJson(jsonData, "dropDownLocation"));
        _eventLocation.selectLocation(location);
        _eventLocation.keyInRequiredDataOnToWhereDidItHappenSection(location);*/
    }

    @When("I indicate that the something is stolen at a location and key in it's details")
    public void i_indicate_that_the_someone_is_stolen_at_a_and_key_in_it_s_details() {
        /*JsonNode jsonData = (JsonNode) _scenarioContext.getContext("testData");
        String location = getRandomValueFromList(getDataFromJson(jsonData, "dropDownLocation"));
        _eventLocation.selectLocation(location);
        _eventLocation.keyInRequiredDataOnToWhereDidItHappenSection(location);*/
    }

    @Then("I should be able to key in the required data on to the fields")
    public void i_should_be_able_to_key_in_the_required_data_on_to_the_fields() {
        String location = (String) _persistentData.getContext("whereDidItHappen.location");
        _eventLocation.keyInRequiredDataOnToWhereDidItHappenSection(location);
    }

    @Then("I should be able to see fields to key in stolen item details from vehicle")
    public void I_should_be_able_to_see_fields_to_key_in_stolen_item_details_from_vehicle() {
        _eventLocation.selectDetailsOfStolenItemsFromAVehicle("yes");
    }

    @Then("a dropdown to select it's location")
    public void a_dropdown_to_select_its_location() {
        String[] listValues = _generateTestData.generateListData("whereDidItHappen.stolenFromVehicle.vehicleLocation");
        _eventLocation.verifyAllVehicleLocationList(listValues);

    }

    @Then("the system should indicate users about mandatory fields in Where did it happen section and throw appropriate error message when any mandatory fields are not keyed in")
    public void the_system_should_indicate_users_about_mandatory_fields_in_Where_did_it_happen_section_and_throw_appropriate_error_message_when_any_mandatory_fields_are_not_keyed_in() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Then("I should be able to key in valid data e.g. field length, alphanumeric etc on fields in Where did it happen section and throw appropriate error message otherwise")
    public void i_should_be_able_to_key_in_valid_data_e_g_field_length_alphanumeric_etc_on_fields_in_Where_did_it_happen_section_and_throw_appropriate_error_message_otherwise() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Then("the text displayed on fields in Where did it happen section should be as expected")
    public void the_text_displayed_on_fields_in_Where_did_it_happen_section_should_be_as_expected() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Then("I should see the {string} in Additional information field")
    public void iShouldSeeTheInAdditionalInformationField(String labelText) {
        Assert.assertEquals(_eventLocation.getLocationAdditionalInformationLabel(), labelText);
    }
}
