package features.B4SC.StepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import libs.DriverFactory;
import pageObjects.BeforeSchool.CreateChildPage;

public class CreateChildSteps extends DriverFactory {

    @When("user enter mandatory child information and save")
    public void userEnterMandatoryChildInformationAndSave() {
        _CreateChildPage.enterMandateChildInformation();
    }
    @And("User select the new child button")
    public void userSelectTheNewChildButton() {
        _CreateChildPage.clickNewChildButton();
    }

    @Then("create new child screen displayed")
    public void createNewChildScreenDisplayed() {

        _CreateChildPage.enterMandateChildInformation();
    }

}
