package features.OnlineReportingMobile.StepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import libs.DriverFactory;
import org.testng.Assert;

public class SummarPageMobileSteps extends DriverFactory {

    @Then("I should be able to verify all the keyed in data in the summary screen")
    public void i_should_be_able_to_verify_all_the_keyed_in_data_in_the_summary_screen() {
        /*validateEventTimeSectionDetails();
        String location = (String) _persistentData.getContext("whereDidItHappen.location");
        validateLocationSectionDetails(location);
        validateOffenderSectionDetails();
        validateDetailsInHurtSectionDetails();
        validateWhatHappendSectionDetails();
        validateAttachmentSectionDetails();
        validateReporterSectionDetails();*/
    }

    @And("I should be able to navigate back to online reporting page")
    public void iShouldBeAbleToNavigateBackToOnlineReportingPage() {
//        _contactDetails.clickBackButtonOnMobile();
//        _contactDetails.verifyContactDetailPage();
        _contactDetails.clickBackButtonOnMobile();
        _eventInfo.checkIfAttachmentSectionIsDisplayed();
        _contactDetails.clickBackButtonOnMobile();
        _eventInfo.checkIfFieldRelatedToWhatHappenedIsDisplayed();
        _contactDetails.clickBackButtonOnMobile();
        _eventStolen.checkFieldsToReportStolenItemExists();
        _contactDetails.clickBackButtonOnMobile();
        _eventOffender.checkFieldsOffenderVehicle();
        _contactDetails.clickBackButtonOnMobile();
        _eventLocation.checkLocationIsDisplayed();
        _contactDetails.clickBackButtonOnMobile();
    }
}
