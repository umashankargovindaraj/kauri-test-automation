package features.OnlineReporting.StepDefinitions.EventInfoSectionsSteps;

import com.fasterxml.jackson.databind.JsonNode;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import libs.DriverFactory;
import org.testng.Assert;
import persistence.ScenarioContext;

public class EventInfoSteps extends DriverFactory {

    private ScenarioContext _scenarioContext;

    public EventInfoSteps(ScenarioContext scenarioContext) {
        this._scenarioContext = scenarioContext;

    }

    public ScenarioContext get_scenarioContext() {
        return _scenarioContext;
    }

    @Then("I should see the sections EVENT LOCATION DETAILS, ATTACHMENTS and ANYTHING ELSE for all combinations of events except something else")
    public void i_should_see_the_sections_EVENT_LOCATION_DETAILS_ATTACHMENTS_and_ANYTHING_ELSE_for_all_combinations_of_event() {
        Object persistentData = _persistentData.getContext("somethingElseIndicator");
        if (!(persistentData == null)) {
            System.out.println("Event type something else has only a subset of the fields");
        } else {
            Assert.assertTrue(_eventInfo.checkIfWhatHappenedDetailsSectionIsDisplayed(), "Checking if section to key in Details of What happened is displayed");
            Assert.assertTrue(_eventInfo.checkIfAttachmentSectionIsDisplayed(), "Checking if section to submit attachments is displayed");
            Assert.assertTrue(_eventTime.checkIfWhenDidItHappenSectionIsDisplayed(), "Checking if section to key in Details of When did the event happen is displayed");
            Assert.assertTrue(_eventLocation.checkIfWhereDidItHappenSectionIsDisplayed(), "Checking if section to key in Details of Where did the event happen is displayed");
        }
    }


    @Then("I should see only sections WHAT HAPPENED and ATTACHMENTS for something else")
    public void i_should_see_the_sections_WHATHAPPENED_ATTACHMENTS_for_something_else() {
        Object persistentData = _persistentData.getContext("somethingElseIndicator");
        if (!(persistentData == null)) {
            Assert.assertTrue(_eventSomethingElse.checkIfWhatHappenedSomethingElseExists(), "Checking if section to submit details of something else");
            Assert.assertTrue(_eventInfo.checkIfAttachmentSectionIsDisplayed(), "Checking if section to submit attachments is displayed");
        }
    }

    @Given("I am on the Event Info Page after selecting the events {string} to report")
    public void i_am_on_the_Event_Info_page(String eventTypes) {
        boolean hurt = false;
        boolean damaged = false;
        boolean stolen = false;
        boolean lost = false;
        boolean somethingElse = false;
        String[] eventArray = eventTypes.split("\\|");
        Assert.assertTrue(eventArray.length <= 3);
        for (String event : eventArray) {

            switch (event) {
                case "hurt":
                    hurt = true;
                    break;
                case "damaged":
                    damaged = true;
                    break;
                case "stolen":
                    stolen = true;
                    break;
                case "lost":
                    lost = true;
                    break;
                case "somethingElse":
                    somethingElse = true;
                    break;
                default:
                    Assert.assertTrue(false, "Invalid event type entered in Feature files. Should be only Hurt or damaged or Stolen seperated by |. e.g. hurt|damaged|stolen");
            }
        }

        _nonEmergency.navigateFromNonEmergencyConfirmationPagetoThreeQuestionsPage();
        _whatHappened.navigateFromThreeQuestionsPageToEventInfoPage(hurt, damaged, stolen, lost, somethingElse);
    }


    @Then("I am able to view the fields to enter description of what happened")
    public void i_am_able_to_view_the_fields_to_enter_description_of_what_happened() {
        _eventInfo.checkIfFieldRelatedToWhatHappenedIsDisplayed();
    }

    @Then("I am able to key in data related to description of what happened")
    public void i_am_able_to_key_in_data_related_to_description_of_what_happened() {
        _eventInfo.keyInDetailsRelatedToWhatHappened();
    }


    @Given("I have indicated that I am not the {string} of a")
    public void i_have_indicated_that_I_am_not_the_owner_of_a(String owner) {

    }


    @When("I key in all mandatory {string} in the page to continue to event Info page")
    public void I_key_in_all_mandatory_fields_in_the_page_to_continue_to_personal_details_page(String testData) {
        JsonNode jsonData = getDataObject(testData);
        _eventTime.selectEventDateTime();
        _eventHurt.keyInDataOnHurtRelatedFields();
        _eventInfo.clickOnContinueButtonEventInfoPage();
    }

    @Then("the system should indicate users about mandatory fields in What happened section and throw appropriate error message when any mandatory fields are not keyed in")
    public void the_system_should_indicate_users_about_mandatory_fields_in_What_happened_section_and_throw_appropriate_error_message_when_any_mandatory_fields_are_not_keyed_in
            () {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Then("I should be able to key in valid data e.g. field length, alphanumeric etc on fields in What happened section and throw appropriate error message otherwise")
    public void i_should_be_able_to_key_in_valid_data_e_g_field_length_alphanumeric_etc_on_fields_in_What_happened_section_and_throw_appropriate_error_message_otherwise
            () {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Then("the text displayed on fields in What happened should be as expected")
    public void the_text_displayed_on_fields_in_What_happened_should_be_as_expected() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Then("the system should indicate users about mandatory fields in Attachments section and throw appropriate error message when any mandatory fields are not keyed in")
    public void the_system_should_indicate_users_about_mandatory_fields_in_Attachments_section_and_throw_appropriate_error_message_when_any_mandatory_fields_are_not_keyed_in
            () {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Then("I should be able to key in valid data e.g. field length, alphanumeric etc on fields in Attachments section and throw appropriate error message otherwise")
    public void i_should_be_able_to_key_in_valid_data_e_g_field_length_alphanumeric_etc_on_fields_in_Attachments_section_and_throw_appropriate_error_message_otherwise
            () {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Then("the text displayed on fields in Attachments should be as expected")
    public void the_text_displayed_on_fields_in_Attachments_should_be_as_expected() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @When("I key in more information about what happened")
    public void i_key_in_more_information_about_what_happened() {
        _eventInfo.keyInDetailsRelatedToWhatHappened();
    }

    @When("I key in more information about the event i want to report")
    public void I_key_in_more_information_about_the_event_i_want_to_report() {
        _eventInfo.keyInDetailsRelatedToWhatHappenedSomethingElseEvent();
    }

    @When("I attach any relevant attachment of the incident")
    public void i_attach_any_relevant_attachment_of_the_incident() {
        _eventInfo.clickOnAddAttachment();
        int attachmentCount = _eventInfo.getAttachmentsCount();
        String fileName = _eventInfo.getFileName();
        String fileExtension = _eventInfo.getFileExtension();
        int attachmentSize = _eventInfo.getAttachmentSize();
        _eventInfo.createFile(fileName, fileExtension, attachmentSize);
        _eventInfo.attachFile(fileName + "." + fileExtension);
        Assert.assertTrue(_eventInfo.getAttachmentsCount() > attachmentCount, "Document attachment failed");
        _eventInfo.keyInAttachedFileName(_eventInfo.getAttachmentsCount(), _eventInfo.getFileName() + _eventInfo.getAttachmentsCount());
        _eventInfo.clickOnSubmitAttachments();
        Assert.assertTrue(_eventInfo.checkFilesUploadedSuccessfully(), "Files not uploaded successfully");
        _eventInfo.enterDetailsOfEvidence();
    }

    @When("I indicate I can't find the address from the address search bar")
    public void i_indicate_I_can_t_find_the_address_from_the_address_search_bar() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Then("I should be able to key in the address in the respective fields")
    public void i_should_be_able_to_key_in_the_address_in_the_respective_fields() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Then("I should see Country New Zealand as non-editable value.")
    public void i_should_see_Country_New_Zealand_as_non_editable_value() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @When("I wish to remove the address choosen for any event")
    public void i_wish_to_remove_the_address_choosen_for_any_event() {
        _eventLocation.selectLocation("A shop/business");
        _eventLocation.chooseShopAddress();
        _eventLocation.checkAddressSuccessfullySelected();
    }

    @Then("I should be able to remove the choosen address")
    public void i_should_be_able_to_remove_the_choosen_address() {
        _eventLocation.removeChoosenShopAddress();
        _eventLocation.checkAddressSuccessfullyRemoved();

    }

    @When("I have already selected the address from the search bar")
    public void i_have_already_selected_the_address_from_the_search_bar() {
        _eventLocation.selectLocation("A shop/business");
        Assert.assertTrue(_eventLocation.checkCantFindAddressIsVisible());
        _eventLocation.chooseShopAddress();
    }

    @When("I have intend to choose the address manually by selecting 'cant find address' checkbox")
    public void I_have_intend_to_choose_the_address_manually_by_selecting_cant_find_the_address() {
        _eventLocation.selectLocation("A shop/business");
        _eventLocation.clickCantFindAddressCheckBox();
    }

    @Then("I should not be allowed to use autocomplete field to key in address")
    public void I_should_not_be_allowed_to_use_autocomplete_field_to_key_in_address() {
        _eventLocation.checkAddressAutoCompleteFieldIsInvisible();
    }

    @Then("I should not be allowed to choose can't find the address checkbox")
    public void i_should_not_be_allowed_to_choose_can_t_find_the_address_checkbox() {
        Assert.assertTrue(_eventLocation.checkCantFindAddressIsInvisible(), "Can't find address checkbox is visible even after address is selected");
    }


    @Given("I have indicated that I am not the owner of an event and choose {string}")
    public void i_have_indicated_that_I_am_not_the_owner_of_an_event_and_choose(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @When("I key in the key name")
    public void i_key_in_the_key_name() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Then("I should be view the first name of the organisation name prepopulated in the dropdown list")
    public void i_should_be_view_the_first_name_of_the_organisation_name_prepopulated_in_the_dropdown_list() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Given("I have a document to attach")
    public void i_have_a_document_to_attach() {
        _eventInfo.clickOnAddAttachment();
        _eventInfo.clickOnSelectFilesForAttachment();
    }


    @Then("I can attach any acceptable document types")
    public void i_can_attach_any_acceptable_document_types() {
        int attachmentCount = _eventInfo.getAttachmentsCount();
        String fileName = "valid";
        String fileExtension = "jpg";
        int fileSize = 1024;
        _eventInfo.createFile(fileName, fileExtension, fileSize);
        _eventInfo.attachFile(fileName + "." + fileExtension);
        Assert.assertTrue(_eventInfo.getAttachmentsCount() > attachmentCount, "Document attachment failed");
        _eventInfo.keyInAttachedFileName(_eventInfo.getAttachmentsCount(), "FileName" + _eventInfo.getAttachmentsCount());
        _eventInfo.clickOnSubmitAttachments();
        Assert.assertTrue(_eventInfo.checkFilesUploadedSuccessfully(), "Files not uploaded successfully");
    }

    @Given("I have selected to upload a file to attach to my report")
    public void i_have_selected_to_upload_a_file_to_attach_to_my_report() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @When("I select to upload a file of a non-permissible file type")
    public void i_select_to_upload_a_file_of_a_non_permissible_file_type() {
        String fileName = "invalidFile";
        String fileExtension = "feature";
        int fileSize = 1024;
        _eventInfo.createFile(fileName, fileExtension, fileSize);
        _eventInfo.attachFile(fileName + "." + fileExtension);
        _eventInfo.keyInAttachedFileName(_eventInfo.getAttachmentsCount(), "FileName" + _eventInfo.getAttachmentsCount());
        _eventInfo.clickOnSubmitAttachments();
    }

    @Then("I will see an error message that indicates it's a non supported file format")
    public void I_will_see_an_error_message_that_indicates_its_a_non_supported_file_format() {
        Assert.assertTrue(_eventInfo.checkErrorMessageDisplayedForAttachment(), "Error message is not displayed for invalid file ");
        Assert.assertEquals(_eventInfo.getErrorMessageDisplayedForAttachment(), "Please attach a valid file.");
    }


    @When("I select two files with the same file name and extension")
    public void iSelectTwoFilesWithTheSameFileNameAndExtension() {
        String fileName = "filename";
        String fileExtension = "jpg";
        int fileSize = 1024;
        for (int i = 1; i <= 2; i++) {
            String file = fileName + String.valueOf(i);
            _eventInfo.createFile(fileName, fileExtension, fileSize);
            _eventInfo.attachFile(fileName + "." + fileExtension);
            _eventInfo.keyInAttachedFileName(_eventInfo.getAttachmentsCount(), "FileName" + _eventInfo.getAttachmentsCount());
        }
        _eventInfo.clickOnSubmitAttachments();
    }

    @Then("I will see an error message that indicates the files attached are duplicates")
    public void iWillSeeAnErrorMessageThatIndicatesTheFilesAttachedAreDuplicates() {
        Assert.assertTrue(_eventInfo.checkErrorMessageDisplayedForAttachment(), "Error message is not displayed for invalid file ");
        Assert.assertEquals(_eventInfo.getErrorMessageDisplayedForAttachment(), "Duplicate Files can't be attached");
    }

    @Then("I will see an error message that indicates it's a file larger than 10MB")
    public void I_will_see_an_error_message_that_indicates_its_a_file_larger_than_10MB() {
        Assert.assertTrue(_eventInfo.checkErrorMessageDisplayedForAttachment(), "Error message is not displayed for large file ");
        Assert.assertEquals(_eventInfo.getErrorMessageDisplayedForAttachment(), "File size should not exceed 5 MB");
    }

    @When("I select to upload a file of a size that is larger than {int}MB")
    public void i_select_to_upload_a_file_of_a_size_that_is_larger_than_MB(Integer file) {
        String fileName = "largeFile";
        String fileExtension = "jpg";
        int fileSize = 13240000;
        _eventInfo.createFile(fileName, fileExtension, fileSize);
        _eventInfo.attachFile(fileName + "." + fileExtension);
    }

    @When("I select to upload more than {int} files")
    public void I_select_to_upload_more_than_x_files(int countOfFiles) {
        String fileName = "filename";
        String fileExtension1 = "jpg";
        int fileSize = 1024;
        for (int i = 1; i <= countOfFiles + 1; i++) {
            String file = fileName + String.valueOf(i);
            _eventInfo.createFile(file, fileExtension1, fileSize);
            _eventInfo.attachFile(file + "." + fileExtension1);
            _eventInfo.keyInAttachedFileName(_eventInfo.getAttachmentsCount(), "FileName" + _eventInfo.getAttachmentsCount());
        }
        _eventInfo.clickOnSubmitAttachments();
    }

    @Then("I will see an error message that indicates more than permitted number of files are uploaded")
    public void I_will_see_an_error_message_that_indicates_more_than_permitted_number_of_files_are_uploaded() {
        try {
            Assert.assertTrue(_eventInfo.checkErrorMessageDisplayedForAttachment(), "Error message is not displayed when user uploads more than 3 file ");
            Assert.assertEquals(_eventInfo.getErrorMessageDisplayedForAttachment(), "Can't upload more than 3 files.");
        }catch (AssertionError e){
            Assert.assertTrue(false, "System is allowing more than expected number of attachments");
        }
    }


    @When("I select to upload a file that contains a virus")
    public void i_select_to_upload_a_file_that_contains_a_virus() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @When("I select to upload a file that is of a permissible type and size, and does not contain a virus")
    public void i_select_to_upload_a_file_that_is_of_a_permissible_type_and_size_and_does_not_contain_a_virus() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Then("I will that file attached to my report")
    public void i_will_that_file_attached_to_my_report() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Given("I am viewing the files attached to my report")
    public void i_am_viewing_the_files_attached_to_my_report() {
        _eventInfo.clickOnAddAttachment();
        _eventInfo.clickOnSelectFilesForAttachment();
        int attachmentCount = _eventInfo.getAttachmentsCount();
        String fileName = "valid";
        String fileExtension = "jpg";
        int fileSize = 1024;
        _eventInfo.createFile(fileName, fileExtension, fileSize);
        _eventInfo.attachFile(fileName + "." + fileExtension);
        Assert.assertTrue(_eventInfo.getAttachmentsCount() > attachmentCount, "Document attachment failed");
        _eventInfo.keyInAttachedFileName(_eventInfo.getAttachmentsCount(), "FileName" + _eventInfo.getAttachmentsCount());
        _scenarioContext.setContext("attachmentCount", _eventInfo.getAttachmentsCount());
        _eventInfo.clickOnSubmitAttachments();
        Assert.assertTrue(_eventInfo.checkFilesUploadedSuccessfully(), "Files not uploaded successfully");

    }

    @When("I select to delete one of the files")
    public void i_select_to_delete_one_of_the_files() {
        int actualAttachmentCount = (int) _scenarioContext.getContext("attachmentCount");
        _eventInfo.clickOnDeleteAttachment(actualAttachmentCount - 1);
        _scenarioContext.setContext("attachmentCount", _eventInfo.getAttachmentsCount());
        Assert.assertEquals(actualAttachmentCount - 1, _eventInfo.getAttachmentsCount(), "Attachment delete button not working");

    }

    @Then("I will see that it is no longer attached to my report")
    public void i_will_see_that_it_is_no_longer_attached_to_my_report() {
        int actualAttachmentCount = (int) _scenarioContext.getContext("attachmentCount");
        Assert.assertEquals(actualAttachmentCount, _eventInfo.getAttachmentsCount(), "Attachment delete button not working");
    }

    @When("I click on Continue to navigate to Reporter information screen")
    public void I_click_on_continue_to_navigate_to_reporter_information_screen() {
        _eventInfo.clickOnContinueToReporterPage();
    }

}
