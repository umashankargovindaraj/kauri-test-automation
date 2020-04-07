package features.OnlineReportingMobile.StepDefinitions.EventInfoSectionsMobileSteps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import libs.DriverFactory;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.awt.*;
import java.util.List;

public class EventInfoDamagedMobileSteps extends DriverFactory {

    @When("I select {string} for Damaged vehicles")
    public void I_select_for_Damaged_vehicles(String damagedVehiclesChoice) {
        if (damagedVehiclesChoice.equalsIgnoreCase("yes")) {
            _eventDamaged.clickOnToggleVehicleDamagedYes();
        } else {
            _eventDamaged.clickOnToggleVehicleDamagedNo();
        }

    }

    @When("I have entered required details of damaged item")
    public void i_have_entered_required_details_of_damaged_item() {
        _eventDamaged.keyInDataOnWhatWasDamaged();
        _eventDamaged.keyInHowWasItDamagedData();
    }

    @When("I have indicated {string} is the owner of damaged item and keyed in owner's name")
    public void i_have_indicated_is_the_owner_of_damaged_item_and_keyed_in_owner_s_name(String damagedItemOwner) {
        _eventDamaged.selectDamagedItemOwnerFromDropDownMobile(damagedItemOwner);
        _eventDamaged.keyInDataOnDamagedItemOwnerFieldMobile(damagedItemOwner);
    }

    @When("I click on continue in the damaged details page and navigate to the next page")
    public void I_click_on_continue_in_the_damged_details_page_and_navigate_to_the_next_page() {
        _eventDamaged.clickOnContinueFromDamagedPageMobile();
    }

    @When("I have indicated {string} is the owner of damaged vehicle and keyed in owner's name")
    public void i_have_indicated_is_the_owner_of_damaged_vehicle_and_keyed_in_owner_s_name(String damagedVehicleOwner) {
        _eventDamaged.selectDamagedVehicleOwnerFromDropDown(damagedVehicleOwner);
        _eventDamaged.keyInDataOnDamagedVehicleOwnerFieldMobile(damagedVehicleOwner);
    }

    @When("I have entered required details of damaged vehicle")
    public void i_have_entered_required_details_of_damaged_vehicle() {
        _eventDamaged.keyInDamagedVehicleLicensePlate();
        _eventDamaged.selectWhereWasVehicleWhenItWasDamaged();
        _eventDamaged.selectDamagedVehicleMovedIndicator();
        _eventDamaged.selectDamagedVehicleIgnitionTamperedIndicator();
        _eventDamaged.keyInHowWasVehicleDamaged();

    }

    @When("I add another damaged vehicle")
    public void i_add_another_damaged_vehicle() {
        _eventDamaged.clickOnButtonAddDamagedVehicle();
    }

    @When("I add another damaged Item")
    public void i_add_another_damaged_Item() {
        _eventDamaged.clickOnAddDamagedItem();
    }

    public void keyInAddressOfSomebodyElseOwner(int index) {
        _contactDetails.keyInAddressOfOwnerSomeOneElse(index);
    }

    @Then("I should be able to add address of the organisation of damaged Item Owner")
    public void i_should_be_able_to_add_address_of_the_organisation_of_damaged_Item_owner() {
        _contactDetails.selectOwnerPhoneTypeMobile();
        _contactDetails.keyInOwnerPhoneNumberMobile();
        _contactDetails.keyInOwnerAddressMobile();
    }


    @And("I have entered required details of damaged vehicle without where was vehicle when field")
    public void iHaveEnteredRequiredDetailsOfDamagedVehicleWithoutWhereWasVehicleWhenField() {
        _eventDamaged.keyInDamagedVehicleLicensePlate();
        _eventDamaged.selectDamagedVehicleMovedIndicator();
        _eventDamaged.selectDamagedVehicleIgnitionTamperedIndicator();
        _eventDamaged.keyInHowWasVehicleDamaged();
    }

    @And("i can close the alert")
    public void iCanCloseTheAlert() {
        try {
            _eventDamaged.closeAlertPopupBox();
        } catch (AWTException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Then("i can verify that mandatory error message is displayed for Where was vehicle when field")
    public void iCanVerifyThatMandatoryErrorMessageIsDisplayedForWhereWasVehicleWhenField() {
        _genericControls.clickOnCloseButtonInPopup();
        _eventDamaged.mandatoryFieldErrorForWhereWasDamamgedVehicle();
    }

    @Then("i can validate the options available for Where was vehicle when field in damaged vehicle")
    public void iCanValidateTheOptionsAvailableForWhereWasVehicleWhenFieldInDamagedVehicle() {
        String[] whereWasDamagedVehicleExpectedData = _generateTestData.generateListData("damagedVehicles.whereWasVehicleWhenDamaged");
        _eventDamaged.validateDropDownWhereWasDamagedvehicleValues(whereWasDamagedVehicleExpectedData);
    }

    @Then("I can validate the placeholder text and label for how and where vehicle damaged text field")
    public void iCanValidateThePlaceholderTextAndLabelForHowAndWhereVehicleDamagedTextField() {
        String fieldLabel = _generateTestData.generateValidData("damagedVehicles.labelHowAndWhereOnTheVehicleWasItDamaged");
        String placeholderText = _generateTestData.generateValidData("damagedVehicles.placeholderHowAndWhereOnTheVehicleWasItDamaged");
        _eventDamaged.validatePlaceholderTextAndLabelForHowAndWhereVehicleDamaged(placeholderText, fieldLabel);
    }


}
