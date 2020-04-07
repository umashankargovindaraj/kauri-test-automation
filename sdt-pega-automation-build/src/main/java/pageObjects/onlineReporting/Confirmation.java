package pageObjects.onlineReporting;

import libs.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Confirmation extends BasePage {

    private @FindBy(xpath = "//div[@data-test-id='201909302044030509970']//div//strong")
    WebElement labelReferenceNumber = null;
    private @FindBy(xpath = "//div[@data-test-id='2019042917302608989464']//label[text()='Yes']")
    WebElement buttonSurveyYes = null;
    private @FindBy(xpath = "//div[@data-test-id='2019042917302608989464']//label[text()='No']")
    WebElement buttonSurveyNo = null;
    private @FindBy(xpath = "//button[@data-test-id='20190930211750029237504']")
    WebElement buttonGoTo105 = null;

    public void checkIfTheReporterReceivedAnAcknowledgementEmail(String referenceNumber) throws Exception {
        pollForConfirmationEmailToTheReporter(referenceNumber);
    }

    public void clickOnGoTo105Button() {
        new WebDriverWait(_driver, 10).until(ExpectedConditions.elementToBeClickable(buttonGoTo105)).click();
    }


    public String getReferenceNumber() {
        return waitandGetText(labelReferenceNumber);
    }

    public void surveyChoice(String choice) {
        if (choice.equalsIgnoreCase("yes")) {
            waitAndclickElementUsingJS(buttonSurveyYes);
        } else {
            waitAndclickElementUsingJS(buttonSurveyNo);
        }
    }

}
