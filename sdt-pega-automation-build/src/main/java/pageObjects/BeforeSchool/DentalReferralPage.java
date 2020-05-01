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

}
