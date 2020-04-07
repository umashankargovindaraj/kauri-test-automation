package features.OnlineReportingMobile.StepDefinitions.EventInfoSectionsMobileSteps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import libs.DriverFactory;
import org.testng.Assert;

public class EventInfoOffenderInformationMobileSteps extends DriverFactory {

    @When("I key in details of the offender")
    public void i_key_in_details_of_the_offender() {
        if (_generateTestData.generateValidData("whoWasInvolved.whoHasDoneThis.value").equalsIgnoreCase("yes")) {
            _eventOffender.clickOnIKnowTheOffenderYes();
            _eventOffender.keyInOffenderDetails();
        } else {
            _eventOffender.clickOnIKnowTheOffenderNo();
        }

        if (_generateTestData.generateValidData("whoWasInvolved.describePerson.value").equalsIgnoreCase("yes")) {
            _eventOffender.indicateIhaveDescriptionOfOffenderYes();
            _eventOffender.keyInOffenderDescription();
        } else {
            _eventOffender.indicateIhaveDescriptionOfOffenderNo();
        }

        if (_generateTestData.generateValidData("whoWasInvolved.offenderVehicle.value").equalsIgnoreCase("yes")) {
            _eventOffender.indicateOffenderUsedVehicleYes();
            _eventOffender.keyInDataOnOffenderVehicles();
        } else {
            _eventOffender.indicateOffenderUsedVehicleNo();
        }

        if (_generateTestData.generateValidData("whoWasInvolved.witnessInformation.value").equalsIgnoreCase("yes")) {
            _eventOffender.indicateThereIsAWitnessYes();
            _eventOffender.keyInDataOnWitness();
        } else {
            _eventOffender.indicateThereIsAWitnessNo();
        }
    }

    @When("I click on continue to find an error popup that tells about validation errors")
    public void I_click_on_continue_to_find_an_error_popup_that_tells_about_validation_errors() {
        _genericControls.clickOnContinueButtonToFindValidationErrors();
    }

    @When("I click on continue in offender page to navigate to the next page")
    public void I_click_on_continue_to_navigate_to_Hurt_information_page() {
        _eventOffender.clickOnContinueButtonFromOffenderPageMobile();
    }

    @And("I key in details of the offender details without vehicle description")
    public void iKeyInDetailsOfTheOffenderDetailsWithoutVehicleDescription() {
        _eventOffender.clickOnIKnowTheOffenderNo();
        _eventOffender.indicateIhaveDescriptionOfOffenderNo();
        _eventOffender.indicateOffenderUsedVehicleYes();
        //_eventOffender.keyInDataOnOffenderVehicles();
        _eventOffender.indicateThereIsAWitnessNo();
        //_eventOffender.keyInDataOnWitness();
    }

    @When("I key in offender vehicle description")
    public void iKeyInOffenderVehicleDescription() {
        _eventOffender.keyInDataOnOffenderVehicles();
    }

    @Then("error message should be displayed for mandatory vehicle description")
    public void errorMessageShouldBeDisplayedForMandatoryVehicleDescription() {
        _genericControls.clickOnCloseButtonInPopup();
        _eventOffender.getVehicleDescriptionMandatoryErrorMessage();
    }
}
