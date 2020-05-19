package pageObjects.BeforeSchool;

import libs.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class DentalReferralPage extends BasePage {

    @FindBy(how = How.XPATH, using = "//a[@id='ctl00__pageContentPlaceHolder__b4SchoolChecks__dental__assessmentDate__linkButton']")
    private WebElement dentalCreatedDateLink;

    @FindBy(how = How.XPATH, using = "//a[@id='ctl00__pageContentPlaceHolder__referrals__addNewButton']")
    private WebElement liftTheLipReferral_addNewButton;

    @FindBy(how = How.XPATH, using = "//select[@id='ctl00__pageContentPlaceHolder__referral__referredTo__comboBox']")
    private WebElement dental_referredTo;

    @FindBy(how = How.XPATH, using = "//input[@id='ctl00__pageContentPlaceHolder__referral__dateSent__textBox']")
    private WebElement dental_dateReferralSent;

    @FindBy(how = How.XPATH, using = "//textarea[contains(@id,'ctl00__pageContentPlaceHolder__referral__reasonForReferral__textBox')]")
    private WebElement dental_ReasonForReferral;

    @FindBy(how = How.XPATH, using = "//a[@id='ctl00__pageContentPlaceHolder__referrals__repeater_ctl00__pageLink__linkButton']")
    private WebElement dental_StatusInProgressVerify;

    @FindBy(how = How.XPATH, using = "//input[@id='ctl00__saveBtn']")
    private WebElement dental_liftTheLipReferralSaveButton;
//--------------------------------
    @FindBy(how = How.XPATH, using = "//a[@id='ctl00__pageContentPlaceHolder__referrals__repeater_ctl00__pageLink__linkButton']")
    private WebElement liftTheLipReferral_AlreadyAddedLink;

    @FindBy(how = How.XPATH, using = "//select[@id='ctl00__pageContentPlaceHolder__referral__referralStatus__comboBox']")
    private WebElement dental_referralStatus;

    @FindBy(how = How.XPATH, using = "//input[@id='ctl00__pageContentPlaceHolder__referral__dateAcknowledged__textBox']")
    private WebElement dental_dateAckReceived;

    @FindBy(how = How.XPATH, using = "//input[@id='ctl00__pageContentPlaceHolder__referral__dateDue__textBox']")
    private WebElement dental_dateInterventionStarted;

    @FindBy(how = How.XPATH, using = "//input[@id='ctl00__pageContentPlaceHolder__referral__appointmentDate__textBox']")
    private WebElement dental_dateInterventionCompleted;

    @FindBy(how = How.XPATH, using = "//input[@id='ctl00__pageContentPlaceHolder__referral__dateCompleted__textBox']")
    private WebElement dental_dateReferralCompleted;

    //---------------------------
 public void dentalCheckReferralInProgress(){

        waitAndClickElement(dentalCreatedDateLink);
        waitAndClickElement(liftTheLipReferral_addNewButton);
        selectFromDropDownbyValue(dental_referredTo,getAppData().getElement("DENTALREFERRAL","REFERREDTO"));
        sendKeysToWebElement(dental_dateReferralSent,getAppData().getElement("DENTALREFERRAL","DATE"));
        sendKeysToWebElement(dental_ReasonForReferral,getAppData().getElement("DENTALREFERRAL","NOTES"));
        waitAndClickElement(dental_liftTheLipReferralSaveButton);
        verifyTextPartially(dental_StatusInProgressVerify,getAppData().getElement("DENTALREFERRAL","VERIFY"));
        System.out.println("Status Of the Questionnaire:" + dental_StatusInProgressVerify.getText());
    }

    public void dentalCheckReferralCompleted(){

        waitAndClickElement(dentalCreatedDateLink);
        waitAndClickElement(liftTheLipReferral_AlreadyAddedLink);
        selectFromDropDownbyValue(dental_referralStatus,getAppData().getElement("DENTALREFERRAL","REFERRALSTATUS"));

//        sendKeysToWebElement(dental_dateAckReceived,getAppData().getElement("DENTALREFERRAL","DATE"));
        sendKeysToWebElement(dental_dateAckReceived,addOrSubtractDaysFromToday("sub",0));
        sendKeysToWebElement(dental_dateInterventionStarted,addOrSubtractDaysFromToday("sub",0));
        sendKeysToWebElement(dental_dateInterventionCompleted,addOrSubtractDaysFromToday("sub",0));
        sendKeysToWebElement(dental_dateReferralCompleted,addOrSubtractDaysFromToday("sub",0));
        waitAndClickElement(dental_liftTheLipReferralSaveButton);
        verifyTextPartially(dental_StatusInProgressVerify,getAppData().getElement("DENTALREFERRAL","VERIFYWHETHERCOMPLETED"));
        System.out.println("Status Of the Questionnaire:" + dental_StatusInProgressVerify.getText());
    }

}
