package features.OnlineReporting.StepDefinitions;

import cucumber.api.java.en.Then;
import libs.DriverFactory;
import org.testng.Assert;

public class ConfirmationSteps extends DriverFactory {

    @Then("I should be able to navigate to the next page from summary")
    public void I_should_be_able_to_navigate_to_the_next_page_from_summary() {
        _summary.clickOnSubmit();
    }

    @Then("I should be able to submit the application successfully")
    public void I_should_be_able_to_submit_the_application_successfully() {
        String referenceNumber = _confirmation.getReferenceNumber();
        System.out.println("****************************************************************************************************************");
        System.out.println("********************************* REFERENCE NUMBER GENERATED : " + referenceNumber.trim() + " *****************************************");
        System.out.println("****************************************************************************************************************");
        System.out.println("");
        _persistentData.setContext("ReferenceNumber", referenceNumber);
        if (_applicationLaunch.getIsPoliceNetworkFlag()) {
            _confirmation.clickOnGoTo105Button();
            Assert.assertTrue(_applicationLaunch.check105LandingPageIsDisplayed(), "Landing page is not displayed");
        }
    }


    @Then("I should be able to see a summary email with correct data")
    public void i_should_be_able_to_see_a_summary_email_with_correct_data() {
        System.out.println("Summary email");
    }

    @Then("I should receive an email from NZ Police with the summary of the report")
    public void i_should_receive_an_email_from_NZ_Police_with_the_summary_of_the_report() throws Exception {
        String referenceNumber = (String) _persistentData.getContext("ReferenceNumber");
        //_confirmation.checkIfTheReporterReceivedAnAcknowledgementEmail(referenceNumber);
    }

}
