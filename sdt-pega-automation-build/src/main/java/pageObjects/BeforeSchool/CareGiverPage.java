package pageObjects.BeforeSchool;

import libs.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CareGiverPage extends BasePage {

    //******************************  CAREGIVER  ****************************************************************************
    @FindBy(how = How.XPATH, using = "//a[@id='ctl00__pageContentPlaceHolder__childDetails__caregivers__addNewButton']")
    private WebElement careGiverLink;

    @FindBy(how = How.XPATH, using = "//select[@id='ctl00__pageContentPlaceHolder__caregiver__relationship__comboBox']")
    private WebElement careGiverRelationship;

    @FindBy(how = How.XPATH, using = "//input[@id='ctl00__pageContentPlaceHolder__caregiver__names__preferredName__firstname__textBox']")
    private WebElement careGiverFirstName;

    @FindBy(how = How.XPATH, using = "//input[@id='ctl00__pageContentPlaceHolder__caregiver__names__preferredName__surname__textBox']")
    private WebElement careGiverSurName;

    @FindBy(how = How.XPATH, using = "//a[@id='ctl00__pageContentPlaceHolder__childDetails__caregivers__repeater_ctl00__pageLink__linkButton']")
    private WebElement verifyCareGiverMessage;

    @FindBy(how = How.XPATH, using = "//input[@id='ctl00__saveBtn']")
    private static WebElement careGiverSaveButton;
    //----------------------------------------------------------------------------------------------------------
    //******************* CAREGIVER DETAILS PAGE *********************

    public void careGiverLinkClick(){
        waitAndClickElement(careGiverLink);
    }
    public void fillCareGiverDetailsPage(){
        selectFromDropDownbyValue(careGiverRelationship,getAppData().getElement("CAREGIVER","RELATIONSHIP"));
        sendKeysToWebElement(careGiverFirstName,_CreateChildPage.generateFirstName());
        sendKeysToWebElement(careGiverSurName,_CreateChildPage.generateSurName());
        waitAndClickElement(careGiverSaveButton);
        // waitAndClickElement(_CreateChildPage.saveButtonOnChildInformationPage); /* calling the webelement from SearchPage using public static variable */
    }

    public void verifyCareGiverRecordUpdated(){

        verifyTextPartially(verifyCareGiverMessage,"Mother");
    }

}
