package features.Automation105.StepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import libs.DriverFactory;
import org.testng.Assert;
import persistence.ScenarioContext;

public class NonEmergency105Steps extends DriverFactory {

    private ScenarioContext _scenarioContext;

    public NonEmergency105Steps(ScenarioContext scenarioContext) {
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

    @Given("I am on the Event Info Page after selecting the events {string} to report")
    public void i_am_on_the_Event_Info_page(String eventTypes) {
        boolean hurt = false;
        boolean damaged = false;
        boolean stolen = false;
        boolean lost = false;
        boolean somethingElse = false;
        String[] eventArray = eventTypes.split("\\|");
        Assert.assertTrue(eventArray.length <= 3);
        for (String event : eventArray) {

            switch (event) {
                case "hurt":
                    hurt = true;
                    break;
                case "damaged":
                    damaged = true;
                    break;
                case "stolen":
                    stolen = true;
                    break;
                case "lost":
                    lost = true;
                    break;
                case "somethingElse":
                    somethingElse = true;
                    break;
                default:
                    Assert.fail("Invalid event type entered in Feature files. Should be only Hurt or damaged or Stolen seperated by |. e.g. hurt|damaged|stolen");
            }
        }

        _nonEmergency105.navigateFromNonEmergencyConfirmationPagetoThreeQuestionsPage();
        _whatHappened105.navigateFromThreeQuestionsPageToEventInfoPage(hurt, damaged, stolen, lost, somethingElse);
    }
}
