package features.Automation105.StepDefinitions;

import cucumber.api.java.en.Given;
import libs.DriverFactory;

import java.io.IOException;

public class ApplicationLaunch105Steps extends DriverFactory {

    @Given("I’m on the Online form")
    public void i_m_on_the_Police_website() throws IOException {
        _applicationLaunch105.launchWebApplication();
    }

}
