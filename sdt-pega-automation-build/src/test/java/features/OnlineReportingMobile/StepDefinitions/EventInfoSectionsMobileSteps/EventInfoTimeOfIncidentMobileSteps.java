package features.OnlineReportingMobile.StepDefinitions.EventInfoSectionsMobileSteps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.AppiumDriver;
import libs.DriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class EventInfoTimeOfIncidentMobileSteps extends DriverFactory {

    @When("I key in the details of Event time and continue to next page")
    public void i_key_in_the_details_of_Event_time_and_continue_to_next_page() {
        _eventTime.enterStartDateMobile();
        _eventTime.enterStartTimeMobile();
        _eventTime.clickOnContinueButtonMobile();
    }
}
