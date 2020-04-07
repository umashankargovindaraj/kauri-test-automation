package features.OnlineReporting.StepDefinitions;

import cucumber.api.java.en.When;
import libs.DriverFactory;

public class Fixtures extends DriverFactory {

    @When("I key in details of the offender who damaged something")
    public void i_key_in_details_of_the_offender_who_damaged_something() {
        _eventOffender.clickOnIKnowTheOffenderYes();
        _eventOffender.keyInOffenderDetails();
        _eventOffender.indicateIhaveDescriptionOfOffenderYes();
        _eventOffender.keyInOffenderDescription();
        _eventOffender.indicateOffenderUsedVehicleYes();
        _eventOffender.keyInDataOnOffenderVehicles();
        _eventOffender.indicateThereIsAWitnessYes();
        _eventOffender.keyInDataOnWitness();
    }

    @When("I key in details of the offender who damaged vehicles and items")
    public void i_key_in_details_of_the_offender_who_damaged_vehicles_and_Items() {
        _eventOffender.clickOnIKnowTheOffenderYes();
        _eventOffender.keyInOffenderDetails();
        _eventOffender.indicateIhaveDescriptionOfOffenderYes();
        _eventOffender.keyInOffenderDescription();
        _eventOffender.indicateOffenderUsedVehicleYes();
        _eventOffender.keyInDataOnOffenderVehicles();
        _eventOffender.indicateThereIsAWitnessYes();
        _eventOffender.keyInDataOnWitness();
    }

    @When("I key in details of the offender who stolen vehicles and items")
    public void i_key_in_details_of_the_offender_who_stolen_vehicles_and_Items() {
        _eventOffender.clickOnIKnowTheOffenderYes();
        _eventOffender.keyInOffenderDetails();
        _eventOffender.indicateIhaveDescriptionOfOffenderYes();
        _eventOffender.keyInOffenderDescription();
        _eventOffender.indicateOffenderUsedVehicleYes();
        _eventOffender.keyInDataOnOffenderVehicles();
        _eventOffender.indicateThereIsAWitnessYes();
        _eventOffender.keyInDataOnWitness();
    }
}
