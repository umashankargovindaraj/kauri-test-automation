package pageObjects.Accuro;

import libs.BasePage;
import org.apache.commons.lang3.RandomStringUtils;
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

    public String generateFirstNameForCareGiver(){
        String firName = RandomStringUtils.randomAlphabetic( 5);
        getAppData().putToMap("careGiversFirstName",firName);
        return firName;
    }
    public String generateSurNameForCareGiver(){
        String suName = RandomStringUtils.randomAlphabetic( 5);
        getAppData().putToMap("careGiversSurName",suName);
        return suName;
    }
    public void fillCareGiverDetailsPage(){

        selectFromDropDownbyValue(careGiverRelationship,getAppData().getElement("CAREGIVER","RELATIONSHIP"));
        sendKeysToWebElement(careGiverFirstName,generateFirstNameForCareGiver());
        sendKeysToWebElement(careGiverSurName,generateSurNameForCareGiver());
        waitAndClickElement(careGiverSaveButton);
        // waitAndClickElement(_CreateChildPage.saveButtonOnChildInformationPage); /* calling the webelement from SearchPage using public static variable */
    }

    public void verifyCareGiverRecordUpdated(){

        verifyTextPartially(verifyCareGiverMessage, getAppData().getFromMap("careGiversFirstName"));
        verifyTextPartially(verifyCareGiverMessage, getAppData().getFromMap("careGiversSurName"));

    }

}
