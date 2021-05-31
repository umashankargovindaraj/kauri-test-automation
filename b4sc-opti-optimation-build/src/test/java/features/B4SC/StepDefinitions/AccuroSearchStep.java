package features.B4SC.StepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import libs.DriverFactory;

public class AccuroSearchStep extends DriverFactory {

    @When("perform random search")
    public void performRandomSearch() {
        _AccuroSearchPage.searchOption();

    }

}
