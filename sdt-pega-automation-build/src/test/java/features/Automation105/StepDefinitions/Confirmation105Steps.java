package features.Automation105.StepDefinitions;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import io.cucumber.datatable.DataTable;
import libs.DriverFactory;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

public class Confirmation105Steps extends DriverFactory {

    private static String narratives = null;
    private static String jsonOutputPayload = "";

    @Then("I should be able to submit the application successfully")
    public void I_should_be_able_to_submit_the_application_successfully() throws InterruptedException {
        String referenceNumber = _confirmationPage105.getReferenceNumber();
        System.out.println("****************************************************************************************************************");
        System.out.println("********************************* REFERENCE NUMBER GENERATED : " + referenceNumber.trim() + " *****************************************");
        System.out.println("****************************************************************************************************************");
        System.out.println("");
        _persistentData.setContext("ReferenceNumber", referenceNumber);
        jsonOutputPayload = _confirmationPage105.getJSONOutputPayloadFromPegaAPI(referenceNumber);
        String onDutyResponseString = _confirmationPage105.retrieveDataFromJsonOutputPayload(jsonOutputPayload, getPropertyValue("ONDUTY_RESPONSE_XPATH"));
        String actualOnDutyResponseCode = _confirmationPage105.retrieveDataFromJsonOutputPayload(onDutyResponseString, getPropertyValue("ONDUTY_RESPONSE_STATUS_XPATH"));
        System.out.println("OnDuty Response Code : " + actualOnDutyResponseCode);
        Assert.assertEquals(actualOnDutyResponseCode, "200");
    }


    @Then("I should be able to verify that the narrative is truncated when it's length is greater than {int}")
    public void iShouldBeAbleToVerifyThatTheNarrativeIsTruncatedWhenItSLengthIsGreaterThan(int expectedNarrativeLength) throws InterruptedException {
        String jsonOutputPayload = _confirmationPage105.getJSONOutputPayloadFromPegaAPI((String) _persistentData.getContext("ReferenceNumber"));
        String narratives = _confirmationPage105.retrieveDataFromJsonOutputPayload(jsonOutputPayload, getPropertyValue("NARRATIVE_XPATH"));
        Assert.assertTrue(narratives.contains("**** TRUNCATED 105 ONLINE REPORT ****"), "**** TRUNCATED 105 ONLINE REPORT **** message in narrative not found");
        Assert.assertEquals(narratives.length(), expectedNarrativeLength);
    }

    @And("the narrative length is {int}")
    public void theNarrativeLengthIs(int expectedNarrativeLength) {
        int actualNarrativeLength = narratives.length();
        Assert.assertEquals(actualNarrativeLength, expectedNarrativeLength, "Narrative length when truncated messgage is displayed is not " + expectedNarrativeLength + ". Actual narrative length : " + actualNarrativeLength);
    }

    @And("I should be able to verify that the priority of submitted report is {string}")
    public void iShouldBeAbleToVerifyThatThePriorityOfSubmittedReportIs(String expectedPriority) throws InterruptedException {
        if (jsonOutputPayload.equals("")) {
            jsonOutputPayload = _confirmationPage105.getJSONOutputPayloadFromPegaAPI((String) _persistentData.getContext("ReferenceNumber"));
        }
        String actualPriority = _confirmationPage105.retrieveDataFromJsonOutputPayload(jsonOutputPayload, getPropertyValue("PRIORITY_XPATH"));
        Assert.assertEquals(actualPriority, expectedPriority, "Expected priority: " + expectedPriority + ". Actual priority : " + actualPriority);
    }

    @And("I should be able to validate submitted report data")
    public void iShouldBeAbleToValidateTheSubmittedReportData() {
         Object jsonOutputPegaCaseInfoObj = _confirmationPage105.retrievePegaCaseAPIContent((String)_persistentData.getContext("ReferenceNumber"));
        _confirmationPage105.verifyReportDataInPegaCaseInfo(jsonOutputPegaCaseInfoObj);
    }
}
