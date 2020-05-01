package pageObjects.BeforeSchool;

import libs.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ConsentPage extends BasePage {

    //****************************** CONSENT ************************************************************************************
    @FindBy(how = How.XPATH, using = "//span[@id='ctl00__mainNav__repeater_ctl00__campaignButton__linkButton__text']")
    private WebElement clickB4schoolLink;

    @FindBy(how = How.XPATH, using = "//input[@id='ctl00__pageContentPlaceHolder__consent__consent__radioButton_0']")
    private WebElement consentGivenRadioButton;

    @FindBy(how = How.XPATH, using = "//input[@id='ctl00__pageContentPlaceHolder__consent__consentType__radioButton_1']")
    private WebElement consentTypeRadioButton;

    @FindBy(how = How.XPATH, using = "//select[@id='ctl00__pageContentPlaceHolder__consent__consentGivenBy__comboBox']")
    private WebElement consentGivenBy;

    @FindBy(how = How.XPATH, using = "//input[@id='ctl00__pageContentPlaceHolder__consent__consentDate__textBox']")
    private WebElement consentDate;

    @FindBy(how = How.XPATH, using = "//div[@id='ctl00_saveDiv']/input")
    private WebElement consentSaveButton;
    //---------------------------------------------------------------------------------------------------

    public void b4SchoolLink(){
        waitAndClickElement(clickB4schoolLink);
    }

    //******************* CONSENT DETAILS PAGE *********************
    public void provideConsentDetails(){
        waitAndClickElement(consentGivenRadioButton);
        waitAndClickElement(consentTypeRadioButton);
        selectFromDropDownbyIndex(consentGivenBy,1);
        sendKeysToWebElement(consentDate,getAppData().getElement("CONSENT","DATE"));
        waitAndClickElement(consentSaveButton);
    }
}
