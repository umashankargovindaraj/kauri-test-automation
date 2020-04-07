package pageObjects.Automation105.EventInfoSections;

import io.cucumber.datatable.DataTable;
import libs.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Map;

public class EventInfo105 extends BasePage {

    private @FindBy(xpath = "//textarea[@data-test-id='2019042916543401455481']")
    WebElement textAreaDescriptionOfWhatHappened = null;
    private @FindBy(xpath = "//textarea[@data-test-id='20190611154423034813476']")
    WebElement textAreaReasonWhyTheyDidThis = null;
    private @FindBy(xpath = "//button[@data-test-id='20190506100908067919212']")
    WebElement buttonContinue = null;

    private @FindBy(xpath = "//img[@data-test-id='2014121601304102071215']")
    WebElement buttonAttachment = null;
    private @FindBy(xpath = "//div[contains(@data-test-id,'201909051747390299996-')]")
    List<WebElement> sectionAttachedDocuments = null;
    private @FindBy(xpath = "//input[@title='Select file(s)']")
    WebElement attachmentLocation = null;
    private @FindBy(xpath = "//input[@data-test-id='20190905174730017312812']")
    List<WebElement> textBoxFileName = null;
    private @FindBy(xpath = "//div[@data-test-id='201806291827340895814']//button[@alt='Attach']")
    WebElement buttonSubmitAttachments = null;
    private @FindBy(xpath = "//textarea[@data-test-id='201905240911030172924']")
    WebElement textBoxDescribeCCTVEvidence = null;
    private @FindBy(xpath = "//a[@data-test-id='20170515091207074854872']")
    List<WebElement> buttonAttachedDocumentsDelete = null;

    private String xpathWhatHappenedField = "//textarea[@data-test-id='2019042916543401455481']";


    public void keyInDetailsRelatedToWhatHappenedInDetail5000characters() {
        updateFieldValueUsingJavaScript(xpathWhatHappenedField, _retrieveTestData.extractDataOffDataFile("whatHappened.describeWhatHappened"));
    }

    public void keyInDetailsRelatedToWhatHappenedInDetail() {
        sendKeysToWebElement(textAreaDescriptionOfWhatHappened, _retrieveTestData.extractDataOffDataFile("whatHappened.describeWhatHappened"));
        sendKeysToWebElement(textAreaReasonWhyTheyDidThis, _retrieveTestData.extractDataOffDataFile("whatHappened.reasonWhyTheyDidThis"));
    }

    public void clickOnContinueToReporterPage() {
        waitAndclickElementUsingJS(buttonContinue);
    }

    public void clickOnAddAttachment() {
        waitAndclickElementUsingJS(buttonAttachment);
    }

    public int getAttachmentsCount() {
        waitForPageComponentLoadFluentWait();
        return sectionAttachedDocuments.size();
    }

    public String getFileName() {
        return _retrieveTestData.extractDataOffDataFile("eventInfoGeneric.attachmentFileName");
    }

    public String getFileExtension() {
        return _retrieveTestData.extractDataOffDataFile("eventInfoGeneric.attachmentExtension");
    }

    public int getAttachmentSize() {
        return Integer.parseInt(_retrieveTestData.extractDataOffDataFile("eventInfoGeneric.attachmentSize"));
    }

    public void createFile(String fileName, String fileExtension, int fileSize) {
        generateFilesTypesAndSize(fileName, fileExtension, fileSize);
    }

    public void attachFile(String fileName) {
        waitForPageComponentLoadFluentWait();
        String rootDirectory = System.getProperty("user.dir");
        String fullFileName = rootDirectory + "/" + fileName;
        attachmentLocation.sendKeys(fullFileName);
        _persistentData.setContext("fileName", fileName);
        waitForPageComponentLoadFluentWait();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void keyInAttachedFileName(int fileIndex, String fileName) {
        waitForPageComponentLoadFluentWait();
        WebElement ele = textBoxFileName.get(fileIndex);
        sendKeysToWebElement(ele, fileName);
    }

    public void clickOnSubmitAttachments() {
        waitAndclickElementUsingJS(buttonSubmitAttachments);
    }

    public void enterDetailsOfEvidence() {
        sendKeysToWebElement(textBoxDescribeCCTVEvidence, _retrieveTestData.extractDataOffDataFile("attachmentDescription.description"));
    }

    public boolean checkFilesUploadedSuccessfully() {
        if (isElementListDisplayed(textBoxFileName) && isElementListDisplayed(buttonAttachedDocumentsDelete)) {
            return true;
        } else {
            return false;
        }
    }

    public List<Map<String, String>> getCucumberDataAsList(DataTable dataTable) {
        return getCucumberDataTableAsList(dataTable);
    }
}
