package pageObjects.Accuro;

import libs.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ClosingB4SchoolChildRecordPage extends BasePage {

    //--------------------------- CLOSING B4SCHOOL CHILD RECORD ---------------------------------------

    @FindBy(how = How.XPATH, using = "//select[@id='ctl00__pageContentPlaceHolder__checkLocation__providerLocation__comboBox']")
    private WebElement closeChildB4SchoolCheckRecord_ProviderChecksLocation;

    @FindBy(how = How.XPATH, using = "//select[@id='ctl00__pageContentPlaceHolder__checkLocation__vhtLocation__comboBox']")
    private WebElement closeChildB4SchoolCheckRecord_VHTChecksLocation;

    @FindBy(how = How.XPATH, using = "//input[@id='ctl00__pageContentPlaceHolder__allocation__completeRecord__checkBox']")
    private WebElement closeChildB4SchoolCheckRecord_ChecksCompleted;

    @FindBy(how = How.XPATH, using = "//input[@id='ctl00__pageContentPlaceHolder__allocation__closeRecord__checkBox']")
    private WebElement closeChildB4SchoolCheckRecord_CloseRecord;

    @FindBy(how = How.XPATH, using = "//textarea[contains(@id,'ctl00__pageContentPlaceHolder__allocation__auditNotes__notes__appendedNotes')]")
    private WebElement closeChildB4SchoolCheckRecord_AuditNotes;

    @FindBy(how = How.XPATH, using = "//input[@id='ctl00__saveBtn']")
    private WebElement closeChildB4SchoolCheckRecord_SaveButton;

    @FindBy(how = How.XPATH, using = "//span[@id='ctl00__pageContentPlaceHolder__status']")
    private WebElement closeChildB4SchoolCheckRecord_StatusClosedValidation;

    @FindBy(how = How.XPATH, using = "//label[@id='ctl00__faultInformation__errorMessageLabel']/span")
    private WebElement closeChildB4SchoolCheckRecord_ErrorStatusValidation;

    //--------------------------- CLOSING B4SCHOOL CHILD RECORD ---------------------------------------

    public void closingB4SchoolChildRecord(){
        selectFromDropDownbyValue(closeChildB4SchoolCheckRecord_ProviderChecksLocation,getAppData().getElement("CLOSEB4SCHOOLRECORD","PROVIDERCHECKLOCATION"));
        selectFromDropDownbyValue(closeChildB4SchoolCheckRecord_VHTChecksLocation,getAppData().getElement("CLOSEB4SCHOOLRECORD","VHTCHECKLOCATION"));
        waitAndClickElement(closeChildB4SchoolCheckRecord_ChecksCompleted);
        waitAndClickElement(closeChildB4SchoolCheckRecord_CloseRecord);
        sendKeysToWebElement(closeChildB4SchoolCheckRecord_AuditNotes,getAppData().getElement("CLOSEB4SCHOOLRECORD","NOTES"));
        waitAndClickElement(closeChildB4SchoolCheckRecord_SaveButton);
        verifyText(closeChildB4SchoolCheckRecord_StatusClosedValidation,getAppData().getElement("CLOSEB4SCHOOLRECORD","VERIFYSTATUSCLOSED"));
        System.out.println("Status Of the Questionnaire:" + closeChildB4SchoolCheckRecord_StatusClosedValidation.getText());
    }
    public void closingB4SchoolChildRecordFAILED(){
        _ConsentPage.b4SchoolLink();
        selectFromDropDownbyValue(closeChildB4SchoolCheckRecord_ProviderChecksLocation,getAppData().getElement("CLOSEB4SCHOOLRECORD","PROVIDERCHECKLOCATION"));
        selectFromDropDownbyValue(closeChildB4SchoolCheckRecord_VHTChecksLocation,getAppData().getElement("CLOSEB4SCHOOLRECORD","VHTCHECKLOCATION"));
        waitAndClickElement(closeChildB4SchoolCheckRecord_ChecksCompleted);
        waitAndClickElement(closeChildB4SchoolCheckRecord_CloseRecord);
        sendKeysToWebElement(closeChildB4SchoolCheckRecord_AuditNotes,getAppData().getElement("CLOSEB4SCHOOLRECORD","NOTES"));
        waitAndClickElement(closeChildB4SchoolCheckRecord_SaveButton);
        verifyTextPartially(closeChildB4SchoolCheckRecord_ErrorStatusValidation,getAppData().getElement("CLOSEB4SCHOOLRECORD","VERIFYERROR"));
        System.out.println("Status Of the Questionnaire:" + closeChildB4SchoolCheckRecord_ErrorStatusValidation.getText());
    }

    public void closingB4SchoolChildRecordWithNOConsentAndNoChecksAdded(){
        waitAndClickElement(closeChildB4SchoolCheckRecord_CloseRecord);
        waitAndClickElement(closeChildB4SchoolCheckRecord_SaveButton);
        verifyText(closeChildB4SchoolCheckRecord_StatusClosedValidation,getAppData().getElement("CLOSEB4SCHOOLRECORD","VERIFYSTATUSCLOSED"));
        System.out.println("Status Of the Questionnaire:" + closeChildB4SchoolCheckRecord_StatusClosedValidation.getText());
    }
}