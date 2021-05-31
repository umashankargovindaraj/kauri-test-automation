package features.B4SC.StepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import libs.DriverFactory;

public class AccuroLoginStep extends DriverFactory{

    @Given("login to accuro home page")
    public void loginToAccuroHomePage() {

        _AccuroLoginPage.launchApplicationAccuro();
        _AccuroLoginPage.enterCredentialAndLoginAccuro();
    }


}
