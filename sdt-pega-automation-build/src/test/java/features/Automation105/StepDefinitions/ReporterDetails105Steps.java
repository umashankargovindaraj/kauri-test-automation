package features.Automation105.StepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import libs.DriverFactory;

import java.util.List;
import java.util.Map;

public class ReporterDetails105Steps extends DriverFactory {

    @When("I key in my personal information")
    public void i_key_in_my_personal_information() throws InterruptedException {
        _reporterDetails105.keyInDataOnFieldsRelatedToReporterContactDetails();
    }

    @Then("I click on Continue to navigate to Summary Page")
    public void I_click_on_Continue_to_navigate_to_Summary_Page() {
        _reporterDetails105.clickOnContinueToNavigateToSummaryPage();
    }

    @And("answer for victim support")
    public void answerForVictimSupport() {
        _reporterDetails105.selectAnswerForReporterVictimSupport(0);
    }

    @And("I key in my personal information with address keyed in manually and is address international {string}")
    public void iKeyInMyPersonalInformationWithAddressKeyedInManuallyAndIsAddressInternational(String isInternationalAddress) {
        _reporterDetails105.keyInDataOnFieldsRelatedToReporterContactDetailsWithManualAddress(isInternationalAddress);
    }
}
