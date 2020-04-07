package features.OnlineReporting.StepDefinitions.EventInfoSectionsSteps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import libs.DriverFactory;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class EventInfoDamagedSteps extends DriverFactory {

    @When("I have to indicate that one or more vehicles has been damaged")
    public void i_have_indicate_that_a_vehicle_has_been_damaged() {
        _eventDamaged.clickOnToggleVehicleDamagedYes();
    }

    @When("I have to report about or more damaged items")
    public void i_have_indicate_that_a_Items_has_been_damaged() {
        _eventDamaged.checkDamagedItemSectionExists();
    }

    @Then("I am presented with fields to give details of the damaged vehicle")
    public void i_am_presented_with_fields_to_give_details_of_the_damaged_vehicle() {
        Assert.assertTrue(_eventDamaged.checkFieldsToReportDamagedVehicleExists(), "Checking all required fields on damaged vehicle exists");
        _eventDamaged.keyInDamagedVehicleLicensePlate();
        _eventDamaged.selectDamagedVehicleOwnerFromDropDown();
        _eventDamaged.selectDamagedVehicleMovedIndicator();
        _eventDamaged.selectDamagedVehicleIgnitionTamperedIndicator();
        _eventDamaged.keyInHowWasVehicleDamaged();
    }

    @Then("I am able to add additional damaged vehicle")
    public void i_am_able_to_add_additional_damaged_vehicle() {
        List<WebElement> elements = _eventDamaged.indicateAddAdditionalDamagedVehicle();
        Assert.assertTrue(elements.size() == 2, "Checking if there are two damaged vehicle section");
        _eventDamaged.keyInDamagedVehicleLicensePlate();
        _eventDamaged.selectDamagedVehicleOwnerFromDropDown();
        _eventDamaged.selectDamagedVehicleMovedIndicator();
        _eventDamaged.selectDamagedVehicleIgnitionTamperedIndicator();
        _eventDamaged.keyInHowWasVehicleDamaged();
    }

    @Then("delete additional damaged vehicles")
    public void delete_additional_damaged_vehicles() {
        _eventDamaged.clickOnDeleteVehicle();
        List<WebElement> elements = _eventDamaged.getRemainingDamagedVehiclesSectionAfterDeletion();
        Assert.assertTrue(elements.size() == 1, "Checking if there are two damaged vehicle section");
    }


    @When("I have selected the damaged vehicle {string} from the dropdown as")
    public void i_have_selected_the_damaged_vehicle_owner_from_the_dropdown_as(String owner) {
        String[] ownerList = _generateTestData.generateListData("damagedVehicles.owner.value");
        _eventDamaged.validateDamagedVehicleOwnerDetails(ownerList);
        _persistentData.setContext("damagedVehicleOwner", owner);
        _eventDamaged.selectDamagedVehicleOwnerFromDropDown(owner);
    }


    @Then("I should be able to key in the required data on the details of damaged vehicle owner")
    public void I_should_be_able_to_key_in_the_required_data_on_the_details_of_damaged_vehicle_owner() {
        _eventDamaged.keyInDataOnDamagedVehicleOwnerField((String) _persistentData.getContext("damagedVehicleOwner"));
    }

    @Then("I am able to add details of damaged Items")
    public void I_am_able_to_add_details_of_damaged_Items() {
        _eventDamaged.keyInDataOnWhatWasDamaged();
        String[] damagedItemOwners = _generateTestData.generateListData("whatWasDamaged.owner.value");
        _eventDamaged.validateDamagedItemsOwnerDetails(damagedItemOwners);
        _eventDamaged.selectDamagedItemOwnerFromDropDown();
        _eventDamaged.keyInHowWasItDamagedData();
    }

    @Then("I am able to multiple damaged items to report")
    public void i_am_able_to_add_additional_damaged_items() {
        List<WebElement> elements = _eventDamaged.indicateAddAdditionalDamagedItems();
        Assert.assertTrue(elements.size() == 2, "Checking if there are two damaged vehicle section");
        Assert.assertTrue(_eventDamaged.checkFieldsToReportDamagedItemExists(), "Checking all required fields on damaged vehicle exists");
        _eventDamaged.keyInDataOnWhatWasDamaged();
        String[] damagedItemOwners = _generateTestData.generateListData("whatWasDamaged.owner.value");
        _eventDamaged.validateDamagedItemsOwnerDetails(damagedItemOwners);
        _eventDamaged.selectDamagedItemOwnerFromDropDown();
        _eventDamaged.keyInHowWasItDamagedData();
    }

    @Then("delete additional damaged items")
    public void delete_additional_damaged_items() {
        _eventDamaged.clickOnDeleteDamagedItem();
        List<WebElement> elements = _eventDamaged.getRemainingDamagedItemsSectionAfterDeletion();
        Assert.assertTrue(elements.size() == 1, "Checking if there are two damaged Items section");
    }


    @When("I have selected the damaged item {string} from the dropdown as")
    public void i_have_selected_the_damaged_item_owner_from_the_dropdown_as(String owner) {
        _persistentData.setContext("damagedItemOwner", owner);
        _eventDamaged.selectDamagedItemOwnerFromDropDown(owner);
    }

    @Then("I should be able to key in the required data on to the fields of damaged item owner")
    public void I_should_be_able_to_key_in_the_required_data_on_the_details_of_damaged_item_owner() {
        _eventDamaged.keyInDataOnDamagedItemOwnerField((String) _persistentData.getContext("damagedItemOwner"));
    }

    @When("I select {string} for Damaged vehicles")
    public void I_select_for_Damaged_vehicles(String damagedVehiclesChoice) {
        if (damagedVehiclesChoice.equalsIgnoreCase("yes")) {
            _eventDamaged.clickOnToggleVehicleDamagedYes();
        } else {
            _eventDamaged.clickOnToggleVehicleDamagedNo();
        }

    }

    @Then("I should see the Damaged Item turns into a mandatory field")
    public void I_should_see_the_Damaged_Item_turns_into_a_mandatory_field() {
        _eventDamaged.clickAndTabOutOfDamagedItemField();
    }

    @Then("the system should indicate users about mandatory fields in Damaged Vehicles section and throw appropriate error message when any mandatory fields are not keyed in")
    public void the_system_should_indicate_users_about_mandatory_fields_in_Damaged_Vehicles_section_and_throw_appropriate_error_message_when_any_mandatory_fields_are_not_keyed_in() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Then("I should be able to key in valid data e.g. field length, alphanumeric etc on fields in Damaged Vehicles section and throw appropriate error message otherwise")
    public void i_should_be_able_to_key_in_valid_data_e_g_field_length_alphanumeric_etc_on_fields_in_Damaged_Vehicles_section_and_throw_appropriate_error_message_otherwise() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Then("the text displayed on fields in Damaged Vehicles section should be as expected")
    public void the_text_displayed_on_fields_in_Damaged_Vehicles_section_should_be_as_expected() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Then("the system should indicate users about mandatory fields in What was damaged section and throw appropriate error message when any mandatory fields are not keyed in")
    public void the_system_should_indicate_users_about_mandatory_fields_in_What_was_damaged_section_and_throw_appropriate_error_message_when_any_mandatory_fields_are_not_keyed_in() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Then("I should be able to key in valid data e.g. field length, alphanumeric etc on fields in What was damaged section and throw appropriate error message otherwise")
    public void i_should_be_able_to_key_in_valid_data_e_g_field_length_alphanumeric_etc_on_fields_in_What_was_damaged_section_and_throw_appropriate_error_message_otherwise() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Then("the text displayed on fields in What was damaged section should be as expected")
    public void the_text_displayed_on_fields_in_What_was_damaged_section_should_be_as_expected() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();

    }

    @When("I want to use online forms to submit {string} of an incident where something was damaged")
    public void i_indicate_that_something_has_been_damaged(String testData) {

    }


    @When("I want to use online forms to submit {string} of an incident where some vehicles and items has been damaged")
    public void i_indicate_that_some_vehicles_and_items_has_been_damaged(String testData) {

    }

    @When("I want to use online forms to submit {string} of an incident where some vehicles and items has been stolen")
    public void i_indicate_that_some_vehicles_and_items_has_been_stolen(String testData) {

    }


    @When("I key in the details of damaged item")
    public void i_key_in_the_details_of_damaged_item() {

    }

    @When("I key in how was it damaged for first damaged item")
    public void i_key_in_how_was_it_damaged_for_first_damaged_item() {

    }


    @When("I select the owner of first damaged item as I do")
    public void i_select_the_owner_of_first_damaged_item_as_I_do() {

    }

    @When("I key in how was it damaged for second damaged item")
    public void i_key_in_how_was_it_damaged_for_second_damaged_item() {

    }

    @When("I key in how was it stolen for second stolen item")
    public void i_key_in_how_was_it_stolen_for_second_stolen_item() {
        /*damagedItemCount = (int) _scenarioContext.getContext("damagedItemCount");
        _eventDamaged.keyInDataOnHowWasItDamaged(damagedItemCount, (JsonNode) _scenarioContext.getContext("testData"), "damagedItemHowWasItDamaged2");*/
    }

    @When("I key in how was it damaged for third damaged item")
    public void i_key_in_how_was_it_damaged_for_third_damaged_item() {

    }

    @When("I key in how was it stolen for third stolen item")
    public void i_key_in_how_was_it_stolen_for_third_stolen_item() {
        /*damagedItemCount = (int) _scenarioContext.getContext("damagedItemCount");
        _eventDamaged.keyInDataOnHowWasItDamaged(damagedItemCount, (JsonNode) _scenarioContext.getContext("testData"), "damagedItemHowWasItDamaged3");*/
    }

    @When("I select the owner of the second damaged item as Somebody else does")
    public void i_select_the_owner_of_second_damaged_item_as_Somebody_else_does() {

    }

    @When("I key in the owner details of the second damaged item")
    public void i_key_in_the_owner_detail_of_the_second_damaged_item() {

    }

    @When("I key in the owner details of the third damaged item")
    public void i_key_in_the_owner_detail_of_the_third_damaged_item() {

    }

    @When("I select the owner of the third damaged item as An Organisation does")
    public void i_select_the_owner_of_third_damaged_item_as_Organisation_does() {

    }

    @When("I add another damaged Item")
    public void i_add_another_damaged_Item() {
        _eventDamaged.clickOnAddDamagedItem();
    }


    @When("I select the owner of the second damaged item as {string}")
    public void i_select_the_owner_of_the_second_damaged_item_as(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @When("I select the owner of the third damaged item as {string}")
    public void i_select_the_owner_of_the_third_damaged_item_as(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }


    @Then("I should be able to see details of the owner of second damaged item prepopulated")
    public void i_should_be_able_to_see_details_of_the_owner_of_second_damaged_item_prepopulated() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Then("I should be able to add phone number of the owner of second damaged item")
    public void i_should_be_able_to_add_phone_number_of_the_owner_of_second_damaged_item() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Then("I should be able to see details of the owner of third damaged item prepopulated")
    public void i_should_be_able_to_see_details_of_the_owner_of_third_damaged_item_prepopulated() {

    }


    @When("I key in what was the first damaged item")
    public void i_key_in_what_was_the_first_damaged_item() {

    }

    @When("I key in what was the second damaged item")
    public void i_key_in_what_was_the_second_damaged_item() {


    }

    @When("I key in what was the third damaged item")
    public void i_key_in_what_was_the_third_damaged_item() {

    }

    @When("I indicate that a vehicle has been damaged")
    public void I_indicate_that_a_vehicle_has_been_damaged() {
        _eventDamaged.clickOnToggleVehicleDamagedYes();
    }

    @When("I key in the details of first damaged vehicle")
    public void i_key_in_the_details_of_first_damaged_vehicle() {

    }

    @When("I key in the details of second damaged vehicle")
    public void i_key_in_the_details_of_second_damaged_vehicle() {

    }

    @When("I key in the details of third damaged vehicle")
    public void i_key_in_the_details_of_third_damaged_vehicle() {

    }

    @When("I add another damaged vehicle")
    public void i_add_another_damaged_vehicle() {
        _eventDamaged.clickOnButtonAddDamagedVehicle();
    }


    @When("I select the owner of the second damaged vehicle as Somebody else does")
    public void i_select_the_owner_of_the_second_damaged_vehicle_as_someone_else_does() {

    }

    @When("I key in the owner details of the second damaged vehicle")
    public void i_key_in_the_owner_details_of_the_second_damaged_vehicles() {

    }

    @When("I key in the owner details of the third damaged vehicle")
    public void i_key_in_the_owner_details_of_the_third_damaged_vehicles() {

    }

    @When("I select the owner of the third damaged vehicle as An Organisation does")
    public void i_select_the_owner_of_the_third_damaged_vehicle_as() {

    }


    @Then("I should be able to add details of the owner of second stolen vehicle")
    public void i_should_be_able_to_add_phone_number_of_the_owner_of_second_stolen_vehicle() {
        int index = (int) _persistentData.getContext("someBodyElseOwnerElementIndex");
        _contactDetails.keyInAgeOfOwnerSomeOneElse(index);
        _contactDetails.selectInGenderOfOwnerSomeOneElse(index);
        _contactDetails.selectRelationsShipOfOwnerSomeOneElse(index);
        _contactDetails.selectAddressTypeSomeOneElseOwner(index);
        _contactDetails.keyInEmailAddressOfOwnerSomeOneElse(index);
        _contactDetails.selectPhoneTypeOfOwnerOwnerSomeOneElse(index);
        _contactDetails.keyInPhoneNumberOfOwnerSomeOneElse(index);
        _contactDetails.selectSomeElseOwnerVictimSupportFlag("Yes", index);
    }

    @Then("I should be able to add details of the owner of damaged vehicle")
    public void i_should_be_able_to_add_phone_number_of_the_owner_of_damaged_stolen_vehicle() {
        int index = (int) _persistentData.getContext("someBodyElseOwnerElementIndex");
        _contactDetails.keyInAgeOfOwnerSomeOneElse(index);
        _contactDetails.selectInGenderOfOwnerSomeOneElse(index);
        _contactDetails.keyInEmailAddressOfOwnerSomeOneElse(index);
        _contactDetails.selectPhoneTypeOfOwnerOwnerSomeOneElse(index);
        _contactDetails.keyInPhoneNumberOfOwnerSomeOneElse(index);
    }

    @When("I select the owner of first damaged as I do")
    public void i_select_the_owner_of_first_damaged_as_I_do() {

    }

    @When("I have indicated {string} is the owner of damaged vehicle and keyed in owner's name")
    public void i_have_indicated_is_the_owner_of_damaged_vehicle_and_keyed_in_owner_s_name(String damagedVehicleOwner) {
        _eventDamaged.selectDamagedVehicleOwnerFromDropDown(damagedVehicleOwner);
        _eventDamaged.keyInDataOnDamagedVehicleOwnerField(damagedVehicleOwner);
    }

    @When("I have entered required details of damaged vehicle")
    public void i_have_entered_required_details_of_damaged_vehicle() {
        _eventDamaged.keyInDamagedVehicleLicensePlate();
        _eventDamaged.selectWhereWasVehicleWhenItWasDamaged();
        _eventDamaged.selectDamagedVehicleMovedIndicator();
        _eventDamaged.selectDamagedVehicleIgnitionTamperedIndicator();
        _eventDamaged.keyInHowWasVehicleDamaged();
        _eventDamaged.selectDamagedVehicleWherewasIt();
    }

    @When("I have indicated {string} is the owner of damaged item and keyed in owner's name")
    public void i_have_indicated_is_the_owner_of_damaged_item_and_keyed_in_owner_s_name(String damagedItemOwner) {
        _eventDamaged.selectDamagedItemOwnerFromDropDown(damagedItemOwner);
        _eventDamaged.keyInDataOnDamagedItemOwnerField(damagedItemOwner);
    }

    @When("I have entered required details of damaged item")
    public void i_have_entered_required_details_of_damaged_item() {
        _eventDamaged.keyInDataOnWhatWasDamaged();
        _eventDamaged.keyInHowWasItDamagedData();
    }

}
