package pageObjects.Accuro;

import libs.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class VisionAndHearingCheckPage extends BasePage {

    //--------------------------- VISION AND HEARING CHECKS --------------------------------------------

    @FindBy(how = How.XPATH, using = "//select[@id='ctl00__pageContentPlaceHolder__b4SchoolChecks__vhtConsent__consentGivenBy__comboBox']")
    private WebElement VisionAndHearing_Technician;

    @FindBy(how = How.XPATH, using = "//input[@id='ctl00__pageContentPlaceHolder__b4SchoolChecks__vhtConsent__consent__checkBox']")
    private WebElement VisionAndHearing_ConsentImplied;

    @FindBy(how = How.XPATH, using = "//input[@id='ctl00__pageContentPlaceHolder__b4SchoolChecks__vhtConsent__consentDate__textBox']")
    private WebElement VisionAndHearing_DateConsentImplied;

    @FindBy(how = How.XPATH, using = "//input[@id='ctl00__saveBtn']")
    private WebElement VisionAndHearing_SaveButton;

    //-------------------- Vision and Hearing Checks -------------------------------------------
    public void visionAndHearingChecks(){
        selectFromDropDownbyIndex(VisionAndHearing_Technician,1);
        waitAndClickElement(VisionAndHearing_ConsentImplied);
        sendKeysToWebElement(VisionAndHearing_DateConsentImplied,getAppData().getElement("VISIONANDHEARING","DATECONSENTIMPLIED"));
        waitAndClickElement(VisionAndHearing_SaveButton);
    }
}
