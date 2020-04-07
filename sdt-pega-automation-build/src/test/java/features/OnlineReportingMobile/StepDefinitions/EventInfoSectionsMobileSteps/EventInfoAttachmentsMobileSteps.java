package features.OnlineReportingMobile.StepDefinitions.EventInfoSectionsMobileSteps;

import cucumber.api.java.en.When;
import libs.DriverFactory;

public class EventInfoAttachmentsMobileSteps extends DriverFactory {

    @When("I attach any relevant attachment of the incident")
    public void i_attach_any_relevant_attachment_of_the_incident() {
        //_eventInfo.attachDocument();
        /*_eventInforAttachmentMobile.clickOnButtonAttachments();
        String fileName = _eventInforAttachmentMobile.getFileName();
        String fileExtension = _eventInforAttachmentMobile.getFileExtension();
        int attachmentSize = _eventInforAttachmentMobile.getAttachmentSize();
        _eventInforAttachmentMobile.createFile(fileName, fileExtension, attachmentSize);
        //_eventInforAttachmentMobile.attachFile(fileName + "." + fileExtension);*/
    }

    @When("I click on Continue to navigate to Reporter Page")
    public void I_click_on_Continue_to_navigate_to_Reporter_Page() {
        _eventInfo.clickOnContinueButtonFromAttachmentPageMobile();
        //_eventInforAttachmentMobile.clickOnContinueButtonFromAttachmentPage();
    }
}
