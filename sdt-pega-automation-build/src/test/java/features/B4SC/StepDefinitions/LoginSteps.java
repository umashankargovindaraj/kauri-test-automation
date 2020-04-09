package features.B4SC.StepDefinitions;

import com.sun.tools.xjc.Driver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import libs.DriverFactory;
import pageObjects.BeforeSchool.LoginPage;

public class LoginSteps extends DriverFactory {

    @Given("^user launch the application$")
    public void userLaunchTheApplication() {
        _loginPage.launchApplication();
    }

    @When("user enter credentials")
    public void userEnterCredentials() {
        _loginPage.login();
    }

    @Then("the Before School home page should be displayed")
    public void theBeforeSchoolHomePageShouldBeDisplayed() {
        _loginPage.AssertHomePage();
    }
}
