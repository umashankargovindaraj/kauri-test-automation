package pageObjects.onlineReporting.EventInfoSections;

import libs.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;


public class EventInfo extends BasePage {

    private @FindBy(xpath = "//li[@id='current']")
    WebElement linkEventInfo = null;

    private @FindBy(xpath = "//strong[contains(text(), 'Is this an emergency?')]")
    WebElement labelIsThisNonEmergencyPage = null;

    private @FindBy(xpath = "//div[@data-test-id='201905241028350100241']")
    WebElement sectionWhatHappenedDetails = null;
    private @FindBy(xpath = "//div[@data-test-id='201904291654340145700']//div")
    WebElement labelDescriptionOfWhatHappened = null;
    private @FindBy(xpath = "//textarea[@data-test-id='2019042916543401455481']")
    WebElement textBoxDescriptionOfWhatHappened = null;
    private @FindBy(xpath = "//label[@data-test-id='20190611154423034813476-Label']")
    WebElement labelReasonWhyTheyDidThis = null;
    private @FindBy(xpath = "//textarea[@data-test-id='20190611154423034813476']")
    WebElement textBoxReasonWhyTheyDidThis = null;

    private @FindBy(xpath = "//img[@data-test-id='2014121601304102071215']")
    WebElement buttonAttachment = null;
    private @FindBy(xpath = "//div[@data-test-id='201905240905040227530']")
    WebElement sectionAttachments = null;
    //    private @FindBy(xpath = "//div[@data-test-id='201908051643460108482']//button")
//    WebElement buttonSelectFiles = null;
    private @FindBy(xpath = "//button[@alt='Select file(s)']")
    WebElement buttonSelectFiles = null;
    //    private @FindBy(xpath = "//input[@data-test-id='20170515091207074851281']")
//    List<WebElement> textBoxFileName = null;
    private @FindBy(xpath = "//input[@data-test-id='20190905174730017312812']")
    List<WebElement> textBoxFileName = null;
    private @FindBy(xpath = "//input[@title='Select file(s)']")
    WebElement attachmentLocation = null;
    private @FindBy(xpath = "//tr[contains(@data-test-id, '201705150912070747706-')]//span[@class='iconError']")
    List<WebElement> iconError = null;
    private @FindBy(xpath = "//div[@data-test-id='201806291827340895814']//button[@alt='Attach']")
    WebElement buttonSubmitAttachments = null;
    private @FindBy(xpath = "//div[@data-test-id='201905240905040227530']//input[@data-test-id='20170515091207074851281']")
    List<WebElement> textBoxUploadedFiles = null;
    //    private @FindBy(xpath = "//tr[contains(@data-test-id,'201705150912070747706-R')]")
//    List<WebElement> sectionAttachedDocuments = null;
    private @FindBy(xpath = "//div[contains(@data-test-id,'201909051747390299996-')]")
    List<WebElement> sectionAttachedDocuments = null;

    private @FindBy(xpath = "//a[@data-test-id='20170515091207074854872']")
    List<WebElement> buttonAttachedDocumentsDelete = null;
    private @FindBy(xpath = "//div[@class='custom_text']")
    WebElement labelErrorMessageAttachment = null;
    private @FindBy(xpath = "//textarea[@data-test-id='201905240911030172924']")
    WebElement textBoxDescribeCCTVEvidence = null;

    private @FindBy(xpath = "//button[@data-test-id='20190506100908067919212']")
    WebElement buttonContinue = null;

    private @FindBy(xpath = "//button[@data-test-id='20161017110917023176385']")
    WebElement buttonContinueMobile = null;


    public boolean checkIfWhatHappenedDetailsSectionIsDisplayed() {
        return isElementDisplayed(sectionWhatHappenedDetails);
    }

    public boolean checkIfOnlineReportingPageIsDisplayed() {
        return isElementDisplayed(labelIsThisNonEmergencyPage);
    }

    public boolean checkIfAttachmentSectionIsDisplayed() {
        return isElementDisplayed(sectionAttachments);
    }

    public boolean checkIfFieldRelatedToWhatHappenedIsDisplayed() {
        isElementDisplayed(labelDescriptionOfWhatHappened);
        isElementDisplayed(textBoxDescriptionOfWhatHappened);
        isElementDisplayed(labelReasonWhyTheyDidThis);
        isElementDisplayed(textBoxReasonWhyTheyDidThis);
        return true;
    }

    public void keyInDetailsRelatedToWhatHappened() {
        sendKeysToWebElement(textBoxDescriptionOfWhatHappened, _generateTestData.generateValidData("eventInfoGeneric.describeWhatHappened"));
        sendKeysToWebElement(textBoxReasonWhyTheyDidThis, _generateTestData.generateValidData("eventInfoGeneric.reason"));
    }

    public void keyInDetailsRelatedToWhatHappenedSomethingElseEvent() {
        sendKeysToWebElement(textBoxDescriptionOfWhatHappened, _generateTestData.generateValidData("eventInfoGeneric.describeWhatHappened"));
    }

    public void clickOnAddAttachment() {
        waitAndclickElementUsingJS(buttonAttachment);
    }

    public void clickOnSelectFilesForAttachment() {
        waitAndclickElementUsingJS(buttonSelectFiles);
    }

    public void clickOnContinueButtonEventInfoPage() {
        waitAndclickElementUsingJS(buttonContinue);
    }

    public void attachFile(String fileName) {
        waitForPageComponentLoadFluentWait();
        String rootDirectory = System.getProperty("user.dir");
        String fileDirectory = rootDirectory + "/files/";
        String fullFileName = fileDirectory + fileName;
        attachmentLocation.sendKeys(fullFileName);
        _persistentData.setContext("fileName", fileName);
        waitForPageComponentLoadFluentWait();
    }

    public int getAttachmentsCount() {
        waitForPageComponentLoadFluentWait();
        return sectionAttachedDocuments.size();
    }

    public void keyInAttachedFileName(int fileIndex, String fileName) {
        waitForPageComponentLoadFluentWait();
        WebElement ele = textBoxFileName.get(fileIndex - 1);
        sendKeysToWebElement(ele, fileName);
    }

    public void clickOnSubmitAttachments() {
        waitAndclickElementUsingJS(buttonSubmitAttachments);
    }

    public void enterDetailsOfEvidence() {
        sendKeysToWebElement(textBoxDescribeCCTVEvidence, _generateTestData.generateValidData("eventInfoGeneric.describeAttachment"));
    }

    public boolean checkFilesUploadedSuccessfully() {
        if (isElementListDisplayed(textBoxFileName) && isElementListDisplayed(buttonAttachedDocumentsDelete)) {
            return true;
        } else {
            return false;
        }
    }

    public void clickOnDeleteAttachment(int index) {
        waitAndclickElementUsingJS(buttonAttachedDocumentsDelete.get(index));
    }

    public boolean checkErrorMessageDisplayedForAttachment() {
        try {
            return isElementDisplayed(labelErrorMessageAttachment);
        } catch (Exception e) {
            System.out.println("More than expected number of attachments are allowed");
        }
        return false;
    }

    public String getErrorMessageDisplayedForAttachment() {
        return waitandGetText(labelErrorMessageAttachment);
    }

    public void createFile(String fileName, String fileExtension, int fileSize) {
        generateFilesTypesAndSize(fileName, fileExtension, fileSize);
    }

    public String getFileName() {
        return _generateTestData.generateValidData("eventInfoGeneric.attachmentFileName");
    }

    public String getFileExtension() {
        return _generateTestData.generateValidData("eventInfoGeneric.attachmentExtension");
    }

    public int getAttachmentSize() {
        return Integer.parseInt(_generateTestData.generateValidData("eventInfoGeneric.attachmentSize"));
    }


    public void clickOnContinueToReporterPage() {
        waitAndclickElementUsingJS(buttonContinue);
    }

    public void clickOnContinueButtonFromEventInfoPageMobile() {
        waitAndclickElementUsingJS(buttonContinueMobile);
    }

    public void clickOnContinueButtonFromAttachmentPageMobile() {
        waitAndclickElementUsingJS(buttonContinueMobile);
    }

    public void attachDocument() {
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

}
