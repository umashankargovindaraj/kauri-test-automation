package features.OnlineReporting.StepDefinitions.EventInfoSectionsSteps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import libs.DriverFactory;
import org.testng.Assert;

public class EventInfoOffenderInformationSteps extends DriverFactory {

    @Given("I indicate that I know who the offender is")
    public void i_indicate_that_I_know_who_the_offender_is() {
        _eventOffender.clickOnIKnowTheOffenderYes();
    }


    @Then("I should be able to key in the required data on to the Offender section")
    public void i_should_be_able_to_key_in_the_required_data_on_to_the_Offender_details_section() {
        _eventOffender.keyInOffenderDetails();
    }

    @Then("I should be able to verify list values of offender relationship")
    public void i_should_be_able_to_verify_all_data_of_Offender_RelationShip() {
        String[] offenderRelationExpectedList = _generateTestData.generateListData("whoWasInvolved.whoHasDoneThis.personIs");
        _eventOffender.validateOffenderRelationShipDropDownValues(offenderRelationExpectedList);
    }

    @Given("I indicate that I have a description of the offender")
    public void i_indicate_that_I_have_a_description_of_the_offender() {
        _eventOffender.indicateIhaveDescriptionOfOffenderYes();
    }

    @Then("I should see sections relevant to Offender description")
    public void i_should_see_sections_relevant_to_Offender_description() {
        _eventOffender.checkFieldsOfOffenderDescription();
    }

    @When("I choose Family member in offender details")
    public void I_choose_Family_member_in_offender_details(){
        _eventOffender.selectFamilyMemberAsOffender();
    }

    @Then("I should see an indicator that says to reach out to 111 to report family violence")
    public void I_should_see_an_indicator_that_says_to_reach_out_to_111_to_report(){
        Assert.assertEquals(_eventOffender.check111EmergencyIndicationAppearsAndExtractText(), "This may need immediate attention!");
    }

    @Then("I should be able to key in the required data on to the Offender Description")
    public void i_should_be_able_to_key_in_the_required_data_on_to_the_Offender_description_section() {
        _eventOffender.keyInOffenderDescription();
    }

    @Given("I have selected relationship type {string}")
    public void i_have_selected_relationship_type(String relationShipType) {
        _eventOffender.selectRelationShipType(relationShipType);
    }

    @Then("I am able to key in the required data into the ‘Other Specify’ field")
    public void i_am_able_to_key_in_the_required_data_into_the_Other_Specify_field() {
        Assert.assertTrue(_eventOffender.checkDescribeHowYouKnowPersonFieldExists(), "Checking if all fields related to describing how you know person field exists");
        _eventOffender.keyInDataOnDescribeHowYouKnowPersonField();
    }

    @Given("I indicate that I have a description of a vehicle")
    public void i_indicate_that_I_have_a_description_of_a_vehicle() {
        _eventOffender.indicateOffenderUsedVehicleYes();
    }

    @Then("I should see sections relevant to vehicle description")
    public void i_should_see_sections_relevant_to_vehicle_description() {
        _eventOffender.checkFieldsOffenderVehicle();
    }

    @Then("I should be able to key in the required data on to the Offender Vehicle section")
    public void i_should_be_able_to_key_in_the_required_data_on_to_the_Offender_Vehicle_description_section() {
        _eventOffender.keyInDataOnOffenderVehicles();
    }

    @Given("I indicate that I have a witnesses contact details")
    public void i_indicate_that_I_have_a_witnesses_contact_details() {
        _eventOffender.indicateThereIsAWitnessYes();
    }

    @Then("I should see sections relevant to witness contact details")
    public void i_should_see_sections_relevant_to_witness_contact_details() {
        _eventOffender.checkFieldsWitness();
    }

    @Then("I should be able to key in the required data on to the witness section")
    public void i_should_be_able_to_key_in_the_required_data_on_to_the_witness_details_section() {
        _eventOffender.keyInDataOnWitness();
    }

    @Then("the system should indicate users about mandatory fields in Who was involved section and throw appropriate error message when any mandatory fields are not keyed in")
    public void the_system_should_indicate_users_about_mandatory_fields_in_Who_was_involved_section_and_throw_appropriate_error_message_when_any_mandatory_fields_are_not_keyed_in() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Then("I should be able to key in valid data e.g. field length, alphanumeric etc on fields in Who was involved section and throw appropriate error message otherwise")
    public void i_should_be_able_to_key_in_valid_data_e_g_field_length_alphanumeric_etc_on_fields_in_Who_was_involved_section_and_throw_appropriate_error_message_otherwise() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Then("the text displayed on fields in Who was involved section should be as expected")
    public void the_text_displayed_on_fields_in_Who_was_involved_section_should_be_as_expected() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

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
}
