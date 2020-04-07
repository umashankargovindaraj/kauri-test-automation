package features.Automation105.StepDefinitions.EventInfoSectionSteps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import libs.BasePage;
import libs.DriverFactory;

public class EventInfoOffenderInformation105Steps extends DriverFactory {
    @When("I key in details of the offender")
    public void i_key_in_details_of_the_offender() {
        if (_retrieveTestData.extractDataOffDataFile("whoWasInvolved.whoHasDoneThis.value").equalsIgnoreCase("yes")) {
            _eventOffender105.clickOnIKnowTheOffenderYes();
            _eventOffender105.keyInOffenderDetails();
        } else {
            _eventOffender105.clickOnIKnowTheOffenderNo();
        }

        if (_retrieveTestData.extractDataOffDataFile("whoWasInvolved.describePerson.value").equalsIgnoreCase("yes")) {
            _eventOffender105.indicateIhaveDescriptionOfOffenderYes();
            _eventOffender105.keyInOffenderDescription();
        } else {
            _eventOffender105.indicateIhaveDescriptionOfOffenderNo();
        }

        if (_retrieveTestData.extractDataOffDataFile("whoWasInvolved.offenderVehicle.value").equalsIgnoreCase("yes")) {
            _eventOffender105.indicateOffenderUsedVehicleYes();
            _eventOffender105.keyInDataOnOffenderVehicles();
        } else {
            _eventOffender105.indicateOffenderUsedVehicleNo();
        }

        if (_retrieveTestData.extractDataOffDataFile("whoWasInvolved.witnessInformation.value").equalsIgnoreCase("yes")) {
            _eventOffender105.indicateThereIsAWitnessYes();
            _eventOffender105.keyInDataOnWitness();
        } else {
            _eventOffender105.indicateThereIsAWitnessNo();
        }
    }

}
