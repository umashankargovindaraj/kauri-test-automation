package features.Automation105Mobile.StepDefinitions.EventInfoSectionMobileSteps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import libs.DriverFactory;

public class EventInfo105MobileSteps extends DriverFactory {

    @And("I key in more information about what happened and how the item was lost - 5000 characters")
    public void iKeyInMoreInformationAboutWhatHappenedAndHowTheItemWasLostCharacters() {
        _eventInfo105.keyInDetailsRelatedToWhatHappenedInDetail5000characters();
    }

    @When("I click on Continue to navigate to Reporter information screen")
    public void I_click_on_continue_to_navigate_to_reporter_information_screen() {
        _eventInfo105.clickOnContinueToReporterPage();
    }
}
