package features.B4SC.StepDefinitions;

import com.sun.tools.xjc.Driver;
import cucumber.api.java.en.Given;
import libs.DriverFactory;

public class LoginSteps extends DriverFactory {

    @Given("^user launch the application$")
    public void userLaunchTheApplication() {
        _loginPage.launchApplication();

    }
}
