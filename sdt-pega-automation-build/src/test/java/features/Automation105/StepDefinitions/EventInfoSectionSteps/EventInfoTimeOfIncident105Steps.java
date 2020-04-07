package features.Automation105.StepDefinitions.EventInfoSectionSteps;

import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import libs.DriverFactory;
import org.testng.Assert;

import javax.xml.crypto.Data;
import java.util.List;
import java.util.Map;

public class EventInfoTimeOfIncident105Steps extends DriverFactory {

    @When("I enter selected fields in event time section")
    public void i_enter_the_date_and_time_of_the_event_with_dataTable() {
        _eventTime105.selectEventDateTimeFromDataFile();
    }

    @When("I enter the date and time of the event")
    public void i_enter_the_date_and_time_of_the_event() {
        _eventTime105.selectEventDateTimeFromDataFile();
    }
}
