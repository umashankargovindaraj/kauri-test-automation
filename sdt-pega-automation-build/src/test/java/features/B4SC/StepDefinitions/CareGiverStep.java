package features.B4SC.StepDefinitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import libs.DriverFactory;

public class CareGiverStep extends DriverFactory {

    @Then("click caregiver link in child information page")
    public void clickCaregiverLinkInChildInformationPage() {
        _CareGiverPage.careGiverLinkClick();
    }

    @When("enter caregiver details and click save button")
    public void enterCaregiverDetailsAndClickSaveButton() {
        _CareGiverPage.fillCareGiverDetailsPage();
    }

    @Then("the caregiver entry should be available in the child information page")
    public void theCaregiverEntryShouldBeAvailableInTheChildInformationPage() {
        _CareGiverPage.verifyCareGiverRecordUpdated();
    }
}
