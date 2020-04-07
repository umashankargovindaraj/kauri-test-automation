package features.OnlineReportingMobile.StepDefinitions.EventInfoSectionsMobileSteps;

import cucumber.api.java.en.When;
import libs.DriverFactory;

public class EventInfoHurtMobileSteps extends DriverFactory {

    @When("I key in the details of the person being hurt")
    public void i_key_in_the_details_of_the_person_being_hurt() {
        _eventHurt.keyInDataOnHurtRelatedFields();
        //_eventHurtMobile.keyInHurtRelatedDetails();
    }

    @When("I click on Continue to navigate to what happened page")
    public void I_click_on_Continue_to_navigate_to_what_happened_page(){

        _eventHurt.clickOnContinueFromHurtPage();
    }
}
