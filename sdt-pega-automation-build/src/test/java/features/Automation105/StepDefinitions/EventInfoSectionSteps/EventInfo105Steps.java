package features.Automation105.StepDefinitions.EventInfoSectionSteps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import libs.DriverFactory;
import org.testng.Assert;
import persistence.ScenarioContext;

import java.util.List;
import java.util.Map;

public class EventInfo105Steps extends DriverFactory {

    @When("I key in more information about the event and reason for why they did this")
    public void I_key_in_more_information_about_the_event_i_want_to_report() {
        _eventInfo105.keyInDetailsRelatedToWhatHappenedInDetail();
    }

    @And("I key in more information about what happened and how the item was lost - 5000 characters")
    public void iKeyInMoreInformationAboutWhatHappenedAndHowTheItemWasLostCharacters() {
        _eventInfo105.keyInDetailsRelatedToWhatHappenedInDetail5000characters();
    }

    @When("I click on Continue to navigate to Reporter information screen")
    public void I_click_on_continue_to_navigate_to_reporter_information_screen() {
        _eventInfo105.clickOnContinueToReporterPage();
    }

    @When("I add {string} {string} items into the reports")
    public void iAddInTheReport(String count, String eventType) {
        int itemsAlreadyAdded = 1; //1 item already added in previous step
        int expectedItemCount = Integer.parseInt(count);
        for (int i = 0; i < (expectedItemCount - itemsAlreadyAdded); i++) {
            switch (eventType) {
                case "lost":
                    _eventLost105.keyInLostItemSection();
                    break;
                case "stolen":
                    //ToDo
                    break;
                case "damaged":
                    //ToDo
                    break;
            }
        }
    }

    @And("I attach files related to the incident")
    public void iAttachRelatedToTheIncident(DataTable attachmentObjectDatatable) {
        _eventInfo105.clickOnAddAttachment();
        List<Map<String, String>> listAttachmentObjectDataTable = _eventInfo105.getCucumberDataAsList(attachmentObjectDatatable);
        Assert.assertTrue(listAttachmentObjectDataTable.size() >= 1, "Data not found. Please mention the root object name of attachment xpath in a datatable format");

        for (int attachmentCount = 0; attachmentCount < listAttachmentObjectDataTable.size(); attachmentCount++) {
            String attachmentObjectXpathRoot = listAttachmentObjectDataTable.get(attachmentCount).get("files");
            String fileName = getPropertyValue("SAMPLE_FILE_LOCATION") + _retrieveTestData.extractDataOffDataFile(attachmentObjectXpathRoot + ".fileName");
            _eventInfo105.attachFile(fileName);
            Assert.assertTrue(_eventInfo105.getAttachmentsCount() > attachmentCount, "Document attachment failed");
            _eventInfo105.keyInAttachedFileName(attachmentCount, _retrieveTestData.extractDataOffDataFile(attachmentObjectXpathRoot + ".description"));
        }
        _eventInfo105.clickOnSubmitAttachments();
        Assert.assertTrue(_eventInfo105.checkFilesUploadedSuccessfully(), "Files not uploaded successfully");

    }

    @And("I key in description of any other evidence that exists")
    public void iKeyInDescriptionOfAnyOtherEvidenceThatExists() {
        _eventInfo105.enterDetailsOfEvidence();
    }


}
