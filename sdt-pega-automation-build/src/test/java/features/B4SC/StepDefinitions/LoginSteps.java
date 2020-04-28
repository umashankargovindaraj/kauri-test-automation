package features.B4SC.StepDefinitions;

import com.sun.tools.xjc.Driver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import libs.DriverFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.BeforeSchool.LoginPage;

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


}
