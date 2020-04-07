package features.OnlineReportingMobile.StepDefinitions.EventInfoSectionsMobileSteps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.MobileBy;
import libs.DriverFactory;
import org.openqa.selenium.By;
import org.testng.Assert;

public class EventInfoLocationOfEventMobileSteps extends DriverFactory {

    private static By pickers = MobileBy.className("XCUIElementTypePickerWheel");


    @When("I select the {string} of the event")
    public void i_select_the_location_of_the_event(String location) {
        _eventLocation.selectLocation(location);
        _persistentData.setContext("whereDidItHappen.location", location);
    }

    @When("I select the location and key in the location details")
    public void i_select_the_location_of_the_event_mobile() {
        String location = _generateTestData.generateValidData("whereDidItHappen.location");
        _eventLocation.selectLocation(location);
        _eventLocation.keyInLocationDetails(location);
//        _eventWhereDidItHappenMobile.keyInLocationDetails(location);
    }

    @When("I click on continue in the location page and navigate to the next page")
    public void I_click_on_continue_in_the_location_page_and_navigate_to_the_next_page() {
        _eventLocation.clickOnButtonToContinueToOffenderInformationMobile();
    }

    @Then("I should see sections relevant to Location Type")
    public void i_should_see_sections_relevant_to_Location_Type() {
        String location = (String) _persistentData.getContext("whereDidItHappen.location");
    }

    @Then("I should be able to key in the required data on to the fields")
    public void i_should_be_able_to_key_in_the_required_data_on_to_the_fields() {
        String location = (String) _persistentData.getContext("whereDidItHappen.location");
        _eventLocation.keyInLocationDetails(location);
    }

    @When("I key in the details of event location with manually keyed in address")
    public void I_key_in_the_details_of_event_location_with_manually_keyed_in_address() {
        String location = _generateTestData.generateValidData("whereDidItHappen.location");
        _eventLocation.selectLocation(location);
        _eventLocation.keyInRequiredDataOnToWhereDidItHappenSection(location, true);
    }

    @When("I click on continue to navigate to what happened screen")
    public void I_click_on_continue_to_navigate_to_what_happened_screen_mobile() {
        _eventLocation.clickOnButtonToContinueToOffenderInformationMobile();
    }

    @And("select other location type for event location and i select to key in address manually")
    public void iKeyInAddressManuallyAndSelectOtherLocationTypeForEventLocation() {
        String location = _generateTestData.generateValidData("whereDidItHappen.otherLocation");
        _eventLocation.selectLocation(location);
        _eventLocation.clickCantFindAddressCheckBox();
    }

    @Then("address fields should be displayed")
    public void addressFieldsShouldBeDisplayed() {
        _addressManualEntry.validateManualAddressFields();
    }

    @When("i key in how close to this address")
    public void iKeyInHowCloseToThisAddress() {
        _eventLocation.selectHowCloseToThisAddressDidItHappen(_eventLocation.getDropDownHowCloseToThisOtherAddress(),
                _generateTestData.generateValidData("whereDidItHappen.locationOther.addressHowClose"));
    }

    @Then("error message should be displayed for mandatory town and suburb field")
    public void errorMessageShouldBeDisplayedForMandatoryTownAndSuburbField() {
        _genericControls.clickOnCloseButtonInPopup();
        Assert.assertEquals(_contactDetails.waitandGetText(_eventLocation.getTownSuburbMandatoryErrorMessage()),
                _generateTestData.generateValidData("personalInformation.mandatoryFieldErrorMessage"));
    }

    @When("i key in town and suburb")
    public void iKeyInTownAndSuburb() {
        _addressManualEntry.keyInLocationAddressManually(0);
    }

    @And("I select the location as {string} and key in the location details")
    public void iSelectTheLocationAsHomeAndKeyInTheLocationDetails(String locationType) {
        String location = locationType;
        _eventLocation.selectLocation(location);
        _eventLocation.keyInLocationDetails(location);
    }
}

