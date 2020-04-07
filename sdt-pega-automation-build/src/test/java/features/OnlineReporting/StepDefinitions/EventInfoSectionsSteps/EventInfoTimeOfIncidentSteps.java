package features.OnlineReporting.StepDefinitions.EventInfoSectionsSteps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import libs.DriverFactory;

public class EventInfoTimeOfIncidentSteps extends DriverFactory {

    @When("I indicate a date and time that is not within the last 24 hours")
    public void I_indicate_a_date_and_time_that_is_not_within_the_last_24_hours() {
        _eventTime.selectEventOlderThan24Hours();
    }

    @Then("the system should indicate users about mandatory fields in When did it happen section and throw appropriate error message when any mandatory fields are not keyed in")
    public void the_system_should_indicate_users_about_mandatory_fields_in_When_did_it_happen_section_and_throw_appropriate_error_message_when_any_mandatory_fields_are_not_keyed_in() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Then("I should be able to key in valid data e.g. field length, alphanumeric etc on fields in When did it happen section and throw appropriate error message otherwise")
    public void i_should_be_able_to_key_in_valid_data_e_g_field_length_alphanumeric_etc_on_fields_in_When_did_it_happen_section_and_throw_appropriate_error_message_otherwise() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Then("the text displayed on fields in When did it happen section should be as expected")
    public void the_text_displayed_on_fields_in_When_did_it_happen_section_should_be_as_expected() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }


    @When("I enter the date and time of the event")
    public void i_enter_the_date_and_time_of_the_event() {
        _eventTime.selectEventDateTime();
    }

}
