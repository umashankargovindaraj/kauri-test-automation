package features.OnlineReporting.StepDefinitions.EventInfoSectionsSteps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import libs.DriverFactory;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class EventInfoStolenSteps extends DriverFactory {

    @Given("I have indicated a vehicle was stolen")
    public void i_have_indicated_a_vehicle_was_stolen() {
        _eventStolen.clickOnStolenVehicleToggleYes();
    }

    @Given("I have to key in the details of stolen item")
    public void I_have_to_key_in_the_details_of_stolen_item() {
        _eventStolen.checkIfStolenDetailsSectionIsDisplayed();
    }

    @When("I have answered {string} to the question Who owns it")
    public void I_have_answered_I_do_to_the_question_Who_owns_it(String owner) {
        _eventStolen.selectStolenVehicleOwner(owner);
    }

    @Then("I should be allowed to proceed until I indicate whether I wish to pay, or not, for the vehicle to be towed if it is found")
    public void I_should_be_allowed_to_proceed_until_I_indicate_whether_I_wish_to_pay_or_not_for_the_vehicle_to_be_towed_if_it_is_found() {
        _eventStolen.chooseTowingAuthority("Yes");
        _eventStolen.chooseTowingAuthority("No");
    }

    @Then("I am presented with fields to give details of a stolen vehicle")
    public void i_am_presented_with_fields_to_give_details_of_a_stolen_vehicle() {
        Assert.assertTrue(_eventStolen.checkFieldsToReportStolenVehicleExists(), "Checking all required fields on stolen vehicle exists");
        _eventStolen.keyInStolenVehicleLicensePlate();
        String[] vehicleStolenLocationList = _generateTestData.generateListData("stolenVehicles.stolenLocation");
        _eventStolen.validateStolenVehicleLocationDropDownValues(vehicleStolenLocationList);
        _eventStolen.selectWhereWasTheVehicleStolenFrom();
        String[] stolenVehicleOwnerList = _generateTestData.generateListData("stolenVehicles.owner.value");
        _eventStolen.validateStolenVehicleOwnerDropDownValues(stolenVehicleOwnerList);
        _eventStolen.selectStolenVehicleOwner(_generateTestData.generateValidData("stolenVehicles.owner.value"));
    }

    @When("I select {string} for Stolen vehicles")
    public void I_select_for_Stolen_vehicles(String stolenVehicleToggleChoice) {
        if (stolenVehicleToggleChoice.equalsIgnoreCase("yes")){
            _eventStolen.clickOnStolenVehicleToggleYes();
        } else{
            _eventStolen.clickOnStolenVehicleToggleNo();
        }

    }

    @Then("I should see the Stolen Item turns into a mandatory field")
    public void I_should_see_the_stolen_Item_turns_into_a_mandatory_field() {
        _eventStolen.clickAndTabOutOfStolenItemField();
    }

    @Then("I am able to add additional stolen vehicles")
    public void i_am_able_to_add_additional_stolen_vehicles() {
        List<WebElement> elements = _eventStolen.indicateAddAdditionalStolenVehicle();
        Assert.assertTrue(elements.size() == 2, "Checking if there are two stolen vehicle section");
        _eventStolen.keyInStolenVehicleLicensePlate();
        String[] vehicleStolenLocationList = _generateTestData.generateListData("stolenVehicles.stolenLocation");
        _eventStolen.validateStolenVehicleLocationDropDownValues(vehicleStolenLocationList);
        _eventStolen.selectWhereWasTheVehicleStolenFrom();
        String[] stolenVehicleOwnerList = _generateTestData.generateListData("stolenVehicles.owner.value");
        _eventStolen.validateStolenVehicleOwnerDropDownValues(stolenVehicleOwnerList);
        _eventStolen.selectStolenVehicleOwner(_generateTestData.generateValidData("stolenVehicles.owner.value"));
    }

    @Then("delete additional stolen vehicles")
    public void delete_additional_stolen_vehicles() {
        _eventStolen.clickOnDeleteStolenVehicle();
        List<WebElement> elements = _eventStolen.getRemainingStolenVehiclesSectionAfterDeletion();
        Assert.assertTrue(elements.size() == 1, "Checking if there the stolen vehicle is removed. Objects in page : " + elements.size());
    }

    @When("I have selected the stolen vehicle {string} from the dropdown")
    public void i_have_selected_the_stolen_vehicle_owner_from_the_dropdown_as(String owner) {
        _persistentData.setContext("stolenVehicleOwner", owner);
        _eventStolen.selectStolenVehicleOwner(owner);
    }

    @Then("I will be presented with the relevant questions of stolen Vehicles")
    public void i_will_be_presented_with_the_relevant_questions_of_stolen_Vehicles() {
        Assert.assertTrue(_eventStolen.checkFieldsToReportStolenVehicleExists(), "Checking all required fields on stolen vehicle exists");
        _eventStolen.keyInStolenVehicleLicensePlate();
        String[] vehicleStolenLocationList = _generateTestData.generateListData("stolenVehicles.stolenLocation");
        _eventStolen.validateStolenVehicleLocationDropDownValues(vehicleStolenLocationList);
        _eventStolen.selectWhereWasTheVehicleStolenFrom();
        String[] stolenVehicleOwnerList = _generateTestData.generateListData("stolenVehicles.owner.value");
        _eventStolen.validateStolenVehicleOwnerDropDownValues(stolenVehicleOwnerList);
    }

    @Then("I should be able to key in the Owner details of Stolen Vehicle")
    public void i_should_be_able_to_key_in_the_required_data_on_to_the_fields_related_to_stolen_Vehicle() {
        String owner = (String) _persistentData.getContext("stolenVehicleOwner");
        _eventStolen.keyInRelevantAnswersForStolenVehicleOwner(owner);
    }

    @Then("I am presented with fields to give details of a stolen item")
    public void i_am_presented_with_fields_to_give_details_of_a_stolen_item() {
        _eventStolen.keyInDataOnWhatWasStolen();
        String[] ownerStolenItem = _generateTestData.generateListData("whatWasStolen.owner.value");
        _eventStolen.validateStolenItemOwnerDropDownValues(ownerStolenItem);
        _eventStolen.selectStolenItemOwner(_generateTestData.generateValidData("whatWasStolen.owner.value"));
        _eventStolen.keyInSerialNumberOfStolenItem();
        _eventStolen.keyInValueOfStolenItem();
        _eventStolen.keyInDescribeOfStolenItem();
    }

    @Then("I am able to add additional stolen items")
    public void i_am_able_to_add_additional_stolen_items() {
        List<WebElement> elements = _eventStolen.indicateAddAdditionalStolenItems();
        Assert.assertTrue(elements.size() == 2, "Checking if there are two damaged vehicle section");
        _eventStolen.keyInDataOnWhatWasStolen();
        String[] ownerStolenItem = _generateTestData.generateListData("whatWasStolen.owner.value");
        _eventStolen.validateStolenItemOwnerDropDownValues(ownerStolenItem);
        _eventStolen.selectStolenItemOwner(_generateTestData.generateValidData("whatWasStolen.owner.value"));
        _eventStolen.keyInSerialNumberOfStolenItem();
        _eventStolen.keyInValueOfStolenItem();
        _eventStolen.keyInDescribeOfStolenItem();
    }

    @Then("delete additional stolen items")
    public void delete_additional_stolen_items() {
        _eventStolen.clickOnDeleteStolenItem();
        List<WebElement> elements = _eventStolen.getRemainingStolenItemsSectionAfterDeletion();
        Assert.assertTrue(elements.size() == 1, "Checking if there are two damaged vehicle section");
    }

    @Given("I have indicated somethings been stolen")
    public void i_have_indicated_somethings_been_stolen() {
        _eventStolen.clickOnStolenVehicleToggleYes();
    }

    @When("I have selected the stolen item {string} from the dropdown as")
    public void i_have_selected_the_stolen_item_owner_from_the_dropdown_as(String owner) {
        _persistentData.setContext("stolenItemOwner", owner);
        _eventStolen.selectStolenItemOwnerFromDropDown(owner);
    }

    @Then("I should be able to key in the required data on to the fields related to owner of stolen item")
    public void I_should_be_able_to_key_in_the_required_data_on_to_the_fields_related_to_owner_of_stolen_item() {
        String owner = (String) _persistentData.getContext("stolenItemOwner");
        _eventStolen.keyInRelevantAnswersForStolenItemOwner(owner);
    }


    @Given("I have indicated {string} is the owner for a stolen item")
    public void i_have_indicated_somebody_else_is_the_owner_for_a_stolen_item(String owner) {
        _eventStolen.selectStolenItemOwner(owner);
    }


    @When("I have indicated an owner of the stolen item is an organisation as {string}")
    public void i_have_indicated_an_owner_of_the_stolen_item_is_an_organisation(String owner) {
        _eventStolen.selectStolenItemOwner(owner);
    }

    @When("I indicate that a vehicle has been stolen")
    public void I_indicate_that_a_vehicle_has_been_stolen() {
        _eventStolen.clickOnStolenVehicleToggleYes();
    }

    @When("I key in the details of first stolen vehicle")
    public void i_key_in_the_details_of_first_stolen_vehicle() {
        _eventStolen.keyInStolenVehicleLicensePlate();
        _eventStolen.selectWhereWasTheVehicleStolenFrom();
    }

    @When("I select the owner of first stolen as I do")
    public void i_select_the_owner_of_first_stolen_as_I_do() {
        _eventStolen.selectStolenVehicleOwner("I do");
        _eventStolen.chooseTowingAuthority();
    }

    @When("I add another stolen vehicle")
    public void i_add_another_stolen_vehicle() {
        _eventStolen.indicateAddAdditionalStolenVehicle();
    }

    @When("I key in the details of second stolen vehicle")
    public void i_key_in_the_details_of_second_stolen_vehicle() {
        _eventStolen.keyInStolenVehicleLicensePlate();
        _eventStolen.selectWhereWasTheVehicleStolenFrom();
    }

    @When("I select the owner of the second stolen vehicle as Somebody else does")
    public void i_select_the_owner_of_the_second_stolen_vehicle_as_someone_else_does() {
        _eventStolen.selectStolenVehicleOwner("Somebody else does");
        _eventStolen.chooseTowingAuthority();
    }

    @When("I key in the owner details of the second stolen vehicle")
    public void i_key_in_the_owner_details_of_the_second_stolen_vehicles() {
        _eventStolen.keyInDataOnStolenVehicleOwnerField("Somebody else does");
    }

    @When("I key in the details of third stolen vehicle")
    public void i_key_in_the_details_of_third_stolen_vehicle() {
        _eventStolen.keyInStolenVehicleLicensePlate();
        _eventStolen.selectWhereWasTheVehicleStolenFrom();
    }


    @When("I select the owner of the third stolen vehicle as An Organisation does")
    public void i_select_the_owner_of_the_third_stolen_vehicle_as() {
        _eventStolen.selectStolenVehicleOwner("An organisation does");
        _eventStolen.chooseTowingAuthority();
    }

    @When("I key in the owner details of the third stolen vehicle")
    public void i_key_in_the_owner_details_of_the_third_stolen_vehicles() {
        _eventStolen.keyInDataOnStolenVehicleOwnerField("An organisation does");
    }


    @When("I key in what was the first stolen item")
    public void i_key_in_what_was_the_first_stolen_item() {
        _eventStolen.keyInDataOnWhatWasStolen();
        _eventStolen.keyInSerialNumberOfStolenItem();
        _eventStolen.keyInValueOfStolenItem();
        _eventStolen.keyInDescribeOfStolenItem();
    }

    @When("I select the owner of first stolen item as I do")
    public void i_select_the_owner_of_first_stolen_item_as_I_do() {
        _eventStolen.selectWhoOwnsStolenItem("I do");
    }

    @When("I add another stolen Item")
    public void i_add_another_stolen_Item() {
        _eventStolen.indicateAddAdditionalStolenItems();
    }

    @When("I key in what was the second stolen item")
    public void i_key_in_what_was_the_second_stolen_item() {
        _eventStolen.keyInDataOnWhatWasStolen();
        _eventStolen.keyInSerialNumberOfStolenItem();
        _eventStolen.keyInValueOfStolenItem();
        _eventStolen.keyInDescribeOfStolenItem();
    }

    @When("I select the owner of the second stolen item as Somebody else does")
    public void i_select_the_owner_of_second_stolen_item_as_Somebody_else_does() {
        _eventStolen.selectWhoOwnsStolenItem("Somebody else does");
    }

    @When("I key in the owner details of the second stolen item")
    public void i_key_in_the_owner_detail_of_the_second_stolen_item() {
        _eventStolen.keyInDataOnStolenItemOwnerField("Somebody else does");
    }

    @When("I key in what was the third stolen item")
    public void i_key_in_what_was_the_third_stolen_item() {
        _eventStolen.keyInDataOnWhatWasStolen();
        _eventStolen.keyInSerialNumberOfStolenItem();
        _eventStolen.keyInValueOfStolenItem();
        _eventStolen.keyInDescribeOfStolenItem();
    }

    @When("I select the owner of the third stolen item as An Organisation does")
    public void i_select_the_owner_of_third_stolen_item_as_Organisation_does() {
        _eventStolen.selectWhoOwnsStolenItem("An organisation does");
    }

    @When("I key in the owner details of the third stolen item")
    public void i_key_in_the_owner_detail_of_the_third_stolen_item() {
        _eventStolen.keyInDataOnStolenItemOwnerField("An organisation does");
    }

    @When("I key in more information about what happened regarding stolen items and vehicles")
    public void i_key_in_more_information_about_what_happened_regarding_stolen_items_and_vehicles() {
        _eventInfo.keyInDetailsRelatedToWhatHappened();
    }

    @Then("the system should indicate users about mandatory fields in Stolen Vehicles section and throw appropriate error message when any mandatory fields are not keyed in")
    public void the_system_should_indicate_users_about_mandatory_fields_in_Stolen_Vehicles_section_and_throw_appropriate_error_message_when_any_mandatory_fields_are_not_keyed_in() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Then("I should be able to key in valid data e.g. field length, alphanumeric etc on fields in Stolen Vehicles section and throw appropriate error message otherwise")
    public void i_should_be_able_to_key_in_valid_data_e_g_field_length_alphanumeric_etc_on_fields_in_Stolen_Vehicles_section_and_throw_appropriate_error_message_otherwise() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Then("the text displayed on fields in Stolen Vehicles section should be as expected")
    public void the_text_displayed_on_fields_in_Stolen_Vehicles_section_should_be_as_expected() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Then("the system should indicate users about mandatory fields in What was stolen section and throw appropriate error message when any mandatory fields are not keyed in")
    public void the_system_should_indicate_users_about_mandatory_fields_in_What_was_stolen_section_and_throw_appropriate_error_message_when_any_mandatory_fields_are_not_keyed_in() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Then("I should be able to key in valid data e.g. field length, alphanumeric etc on fields in What was stolen section and throw appropriate error message otherwise")
    public void i_should_be_able_to_key_in_valid_data_e_g_field_length_alphanumeric_etc_on_fields_in_What_was_stolen_section_and_throw_appropriate_error_message_otherwise() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Then("the text displayed on fields in What was stolen section should be as expected")
    public void the_text_displayed_on_fields_in_What_was_stolen_section_should_be_as_expected() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @When("I have indicated {string} is the owner of a stolen vehicle and keyed in owner's name")
    public void i_have_indicated_is_the_owner_of_a_stolen_vehicle_and_keyed_in_owner_s_name(String stolenVehicleOwner) {
        _eventStolen.selectStolenVehicleOwner(stolenVehicleOwner);
        _eventStolen.keyInRelevantAnswersForStolenVehicleOwner(stolenVehicleOwner);
    }

    @When("I have entered required details of stolen vehicle")
    public void i_have_entered_required_details_of_stolen_vehicle() {
        _eventStolen.keyInStolenVehicleLicensePlate();
        _eventStolen.selectWhereWasTheVehicleStolenFrom();
        _eventStolen.chooseTowingAuthority("yes");
    }

    @When("I have indicated {string} is the owner of a stolen item and keyed in owner's name")
    public void i_have_indicated_is_the_owner_of_a_stolen_item_and_keyed_in_owner_s_name(String stolenItemOwner) {
        _eventStolen.selectStolenItemOwnerFromDropDown(stolenItemOwner);
        _eventStolen.keyInRelevantAnswersForStolenItemOwner(stolenItemOwner);
    }

    @When("I have entered required details of stolen item")
    public void i_have_entered_required_details_of_stolen_item() {
        _eventStolen.keyInDataOnWhatWasStolen();
        _eventStolen.keyInSerialNumberOfStolenItem();
        _eventStolen.keyInValueOfStolenItem();
        _eventStolen.keyInDescribeOfStolenItem();

    }


    @When("I indicate {string} for a question asking if an vehicle has been stolen")
    public void I_indicate_No_for_a_question_asking_if_an_vehicle_has_been_stolen(String toggleFlag) {
        if (toggleFlag.equalsIgnoreCase("yes")) {
            _eventStolen.clickOnStolenVehicleToggleYes();
        } else if (toggleFlag.equalsIgnoreCase("no")) {
            _eventStolen.clickOnStolenVehicleToggleNo();
        }
    }

}
