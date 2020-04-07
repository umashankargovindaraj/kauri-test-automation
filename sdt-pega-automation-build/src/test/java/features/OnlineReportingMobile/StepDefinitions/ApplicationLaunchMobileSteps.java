package features.OnlineReportingMobile.StepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import libs.DriverFactory;

import java.io.IOException;

public class ApplicationLaunchMobileSteps extends DriverFactory {


    @Given("I’m on mobile view of Online Reporting")
    public void i_m_on_mobile_view_of_Online_Reporting() throws IOException {
        _applicationLaunch.launchWebApplication();
    }

    @When("I select that I want to report a crime")
    public void i_select_that_I_want_to_report_a_crime() throws InterruptedException {
        //_pegaLogin.loadReports("onlinereporting");
        //_pegaLogin.switchToFrame();

    }
}
