package features.Automation105.StepDefinitions.EventInfoSectionSteps;

import cucumber.api.java.en.When;
import libs.DriverFactory;

public class EventInfoHurt105Steps extends DriverFactory {
    @When("I key in the details of the person being hurt")
    public void i_key_in_the_details_of_the_person_being_hurt() {
        _eventHurt105.keyInDataOnHurtRelatedFields();
    }
}
