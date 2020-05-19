package pageObjects.BeforeSchool;

import libs.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class VisionReferralPage extends BasePage {

    @FindBy(how = How.XPATH, using = "//a[@id='ctl00__pageContentPlaceHolder__b4SchoolChecks__vision__assessmentDate__linkButton']")
    private WebElement dentalCreatedDateLink;

    @FindBy(how = How.XPATH, using = "//a[@id='ctl00__pageContentPlaceHolder__referrals__addNewButton']")
    private WebElement Referral_addNewButton;

    @FindBy(how = How.XPATH, using = "//select[@id='ctl00__pageContentPlaceHolder__referral__referredTo__comboBox']")
    private WebElement vision_referredTo;

    @FindBy(how = How.XPATH, using = "//input[@id='ctl00__pageContentPlaceHolder__referral__dateSent__textBox']")
    private WebElement vision_dateReferralSent;

    @FindBy(how = How.XPATH, using = "//textarea[contains(@id,'ctl00__pageContentPlaceHolder__referral__reasonForReferral__textBox')]")
    private WebElement vision_ReasonForReferral;

    @FindBy(how = How.XPATH, using = "//input[@id='ctl00__saveBtn']")
    private WebElement vision_ReferralSaveButton;

    @FindBy(how = How.XPATH, using = "//a[@id='ctl00__pageContentPlaceHolder__referrals__repeater_ctl00__pageLink__linkButton']")
    private WebElement vision_StatusInProgressVerify;


    public void visionReferralInProgress(){

        waitAndClickElement(dentalCreatedDateLink);
        waitAndClickElement(Referral_addNewButton);
        selectFromDropDownbyValue(vision_referredTo,getAppData().getElement("VISIONREFERRAL","REFERREDTO"));
        sendKeysToWebElement(vision_dateReferralSent,getAppData().getElement("VISIONREFERRAL","DATE"));
        sendKeysToWebElement(vision_ReasonForReferral,getAppData().getElement("VISIONREFERRAL","NOTES"));
        waitAndClickElement(vision_ReferralSaveButton);
        verifyTextPartially(vision_StatusInProgressVerify,getAppData().getElement("VISIONREFERRAL","VERIFY"));
        System.out.println("Status Of the Questionnaire:" + vision_StatusInProgressVerify.getText());
    }

}
