package features.OnlineReporting.StepDefinitions.EventInfoSectionsSteps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import libs.DriverFactory;

public class EventInfoHurtSteps extends DriverFactory {

    @Then("I am able to view the fields to enter details related to someone being hurt")
    public void i_am_able_to_view_the_fields_to_enter_details_related_to_someone_being_hurt() {
        _eventHurt.checkHurtRelatedFields();
    }

    @Then("I am able to key in data on to those fields")
    public void i_am_able_to_key_in_data_on_to_those_fields() {
        _eventHurt.keyInDataOnHurtRelatedFields();
    }

    @Then("the system should indicate users about mandatory fields in Who was hurt of threatened section and throw appropriate error message when any mandatory fields are not keyed in")
    public void the_system_should_indicate_users_about_mandatory_fields_in_Who_was_hurt_of_threatened_section_and_throw_appropriate_error_message_when_any_mandatory_fields_are_not_keyed_in() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Then("I should be able to key in valid data e.g. field length, alphanumeric etc on fields in Who was hurt of threatened section and throw appropriate error message otherwise")
    public void i_should_be_able_to_key_in_valid_data_e_g_field_length_alphanumeric_etc_on_fields_in_Who_was_hurt_of_threatened_section_and_throw_appropriate_error_message_otherwise() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Then("the text displayed on fields in What was hurt of threatened should be as expected")
    public void the_text_displayed_on_fields_in_What_was_hurt_of_threatened_should_be_as_expected() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @When("I key in the details of the person being hurt")
    public void i_key_in_the_details_of_the_person_being_hurt() {
        _eventHurt.keyInDataOnHurtRelatedFields();
    }

}
