package features.OnlineReporting.StepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import libs.DriverFactory;
import org.testng.Assert;
import persistence.ScenarioContext;

public class NonEmergencySteps extends DriverFactory {

    private ScenarioContext _scenarioContext ;

    public NonEmergencySteps(ScenarioContext scenarioContext) {
        this._scenarioContext = scenarioContext;
    }

    public ScenarioContext get_scenarioContext() {
        return _scenarioContext;
    }

    @Then("I’m on the online form")
    public void i_m_on_the_online_form() {
        //Assert.assertTrue(_nonEmergency.checkIfOnlinereportingHeaderIsDisplayed(), "Checking if the header is displayed");
    }

    @When("I don’t indicate that the event is not an emergency")
    public void i_don_t_indicate_that_the_event_is_not_an_emergency() {
        _nonEmergency.clickOnContinueButton();
    }

    @Then("I won’t be able to proceed on the form")
    public void i_won_t_be_able_to_proceed_on_the_form() {
        Assert.assertTrue(_nonEmergency.checkIfNonEmergencyErrorIsDisplayed(), "Checking if the user is not able to proceed when non-emergency checkbox is checked");
    }

    @When("I indicate that the event is not an emergency")
    public void i_indicate_that_the_event_is_not_an_emergency() {
        _nonEmergency.clickOnNonEmergencyCheckbox();
    }

    @Then("I will be able to proceed on the form")
    public void i_will_be_able_to_proceed_on_the_form() {
        _nonEmergency.clickOnContinueButton();
    }

    @Given("I'm on the options screens on a non-emergency incident")
    public void i_m_on_the_options_screens_on_a_non_emergency_incident() throws InterruptedException {
        _nonEmergency.clickOnNonEmergencyCheckbox();
        _nonEmergency.clickOnContinueButton();

    }

    @Given("I click click on Continue")
    public void i_click_on_Continue(){
        _nonEmergency.clickOnContinueButton();
    }

    @When("I select Something else option in the online form")
    public void i_select_Something_else_option_in_the_online_form() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }


    @Given("a Protection Order has been breached")
    public void aProtectionOrderHasBeenBreached() {

    }

    @When("I attempt to report this via an Online Form")
    public void iAttemptToReportThisViaAnOnlineForm() {

    }

    @Then("I  can see from the “Let’s get started” page, that I should call 111 instead.")
    public void iCanSeeFromTheLetSGetStartedPageThatIShouldCallInstead() {
        Assert.assertTrue(_nonEmergency.checkMissingPersonInformation(), "Protection Order breached meesage is not displayed");
    }
}
