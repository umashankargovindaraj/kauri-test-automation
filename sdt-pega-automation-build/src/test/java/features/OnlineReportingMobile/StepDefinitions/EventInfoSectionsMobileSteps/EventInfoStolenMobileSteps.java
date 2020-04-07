package features.OnlineReportingMobile.StepDefinitions.EventInfoSectionsMobileSteps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import libs.DriverFactory;

public class EventInfoStolenMobileSteps extends DriverFactory {

    @When("I indicate that a vehicle has been stolen")
    public void I_indicate_that_a_vehicle_has_been_stolen() {
        _eventStolen.clickOnStolenVehicleToggleYes();
    }

    @When("I indicate that a vehicle has not been stolen")
    public void I_indicate_that_a_vehicle_has_not_been_stolen(){
        _eventStolen.clickOnStolenVehicleToggleNo();
    }

    @When("I select the owner of first stolen as I do")
    public void i_select_the_owner_of_first_stolen_as_I_do() {
        _eventStolen.selectStolenVehicleOwner("I do");
        _eventStolen.chooseTowingAuthority();
    }

    @When("I key in the details of first stolen vehicle")
    public void i_key_in_the_details_of_first_stolen_vehicle() {
        _eventStolen.keyInStolenVehicleLicensePlate();
        _eventStolen.selectWhereWasTheVehicleStolenFrom();
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
        _eventStolen.keyInDataOnStolenVehicleOwnerFieldMobile("Somebody else does");
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
        _eventStolen.keyInDataOnStolenVehicleOwnerFieldMobile("An organisation does");
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
        _eventStolen.keyInDataOnStolenItemOwnerFieldMobile("Somebody else does");
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
        _eventStolen.keyInDataOnStolenItemOwnerFieldMobile("An organisation does");
    }

    @When("I click on continue in the stolen details page and navigate to the next page")
    public void I_click_on_continue_in_the_stolen_details_page_and_navigate_to_the_next_page() {
        _eventStolen.clickOnContinueButtonFromStolenPage();
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

    @And("I key in the details of first stolen vehicle without data for where was the vehicle stolen from")
    public void iKeyInTheDetailsOfFirstStolenVehicleWithoutDataForWhereWasTheVehicleStolenFrom() {
        _eventStolen.keyInStolenVehicleLicensePlate();
    }

    @Then("i can verify that mandatory error message is displayed for where was the vehicle stolen from")
    public void iCanVerifyThatMandatoryErrorMessageIsDisplayedForWhereWasTheVehicleStolenFrom() {
        _genericControls.clickOnCloseButtonInPopup();
        _eventStolen.mandatoryFieldErrorForwhereWasTheVehicleStolenFrom();
    }

    @When("i key in details for Where was vehicle when field in damaged vehicle")
    public void iKeyInDetailsForWhereWasVehicleWhenFieldInDamagedVehicle() {
        _eventStolen.selectWhereWasTheVehicleStolenFrom();
    }
}
