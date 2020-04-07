package features.OnlineReporting.StepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import libs.DriverFactory;

import java.io.IOException;

public class ApplicationLaunchSteps extends DriverFactory {

    @Given("I’m on the Police website")
    public void i_m_on_the_Police_website() throws IOException {
        _applicationLaunch.launchWebApplication();
    }

}
