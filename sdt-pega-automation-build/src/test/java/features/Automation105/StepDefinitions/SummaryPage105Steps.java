package features.Automation105.StepDefinitions;

import cucumber.api.java.en.Then;
import libs.DriverFactory;

public class SummaryPage105Steps extends DriverFactory {

    @Then("I should be able to navigate to the next page from summary")
    public void I_should_be_able_to_navigate_to_the_next_page_from_summary() {
        _summaryPage105.clickOnSubmit();
    }
}
