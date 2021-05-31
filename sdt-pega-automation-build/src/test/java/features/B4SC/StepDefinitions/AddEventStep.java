package features.B4SC.StepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import libs.DriverFactory;

public class AddEventStep extends DriverFactory {
    @And("click Add Event tab")
    public void clickAddEventTab() {
        _AddEventPage.addEventTabLink();
    }

    @Then("provide values for the fields in add event popup window and click SaveEvent button and assert saved values")
    public void provideValuesForTheFieldsInAddEventPopupWindowAndClickSaveEventButtonAndAssertSavedValues() {
        _AddEventPage.AddEventDetails();
        _AddEventPage.verifyAddEventDetailsSaved();
    }
}
