package features.B4SC.StepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import libs.DriverFactory;

public class LoginSteps extends DriverFactory {

    @Then("the Before School home page should be displayed")
    public void theBeforeSchoolHomePageShouldBeDisplayed() {
        _loginPage.AssertHomePage();

    }

    @Given("user is logged in as {string}")
    public void userIsLoggedInAs(String userType) {
        _loginPage.launchApplication();
        _loginPage.login(userType);
    }


    @Then("login back as coordinator with organisation {string}")
    public void loginBackAsCoordinatorWithOrganisation(String userType) {
        _loginPage.launchApplication();
        _loginPage.login(userType);
    }

    @And("logout from current user")
    public void logoutFromCurrentUser() throws InterruptedException {
        _loginPage.logoutApplication();
    }


}
