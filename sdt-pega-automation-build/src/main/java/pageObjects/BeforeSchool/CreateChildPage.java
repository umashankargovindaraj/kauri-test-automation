package pageObjects.BeforeSchool;

import libs.BasePage;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CreateChildPage extends BasePage {
    //********************** ADD NEW CHILD *******************************************************************************
    @FindBy(how = How.XPATH, using = "//input[@id='ctl00__pageContentPlaceHolder__createNewClientButton']")
    private WebElement newChildButton;

    @FindBy(how = How.XPATH, using = "//input[@id='ctl00__pageContentPlaceHolder__childDetails__name__preferredName__firstname__textBox']")
    private WebElement firstName;

    @FindBy(how = How.XPATH, using = "//input[@id='ctl00__pageContentPlaceHolder__childDetails__name__preferredName__surname__textBox']")
    private WebElement surName;

    @FindBy(how = How.XPATH, using = "//input[@id='ctl00__pageContentPlaceHolder__childDetails__dob__textBox']")
    private WebElement dob;

    @FindBy(how = How.XPATH, using = "//select[@id='ctl00__pageContentPlaceHolder__childDetails__ethnicity1__comboBox']")
    private WebElement ethnicity1;

    @FindBy(how = How.XPATH, using = "//input[@id='ctl00__pageContentPlaceHolder__childDetails__gender__radioButton_1']")
    private WebElement newChildGender;

    @FindBy(how = How.XPATH, using = "//input[@id='ctl00__saveBtn']")
    private static WebElement saveButtonOnChildInformationPage;

    @FindBy(how = How.XPATH, using = "//input[@id='ctl00__pageContentPlaceHolder__childDetails__addresses__residentialAddress__address__geoCode__useButton']")
    private WebElement geoCodeErrorHandlerButton;
//--------------------------------------------------------------------------------------------------------------------

    public void clickNewChildButton(){
        waitAndClickElement(newChildButton);

}
    //************* ADD NEW CHILD  **************************
    public void enterMandateChildInformation(){

        sendKeysToWebElement(firstName,generateFirstName());
        sendKeysToWebElement(surName,generateSurName());
//        sendKeysToWebElement(dob,addOrSubtractDaysFromToday("sub",0));
        sendKeysToWebElement(dob,getAppData().getElement("CREATE_CHILD","DOB"));
        selectFromDropDownbyValue(ethnicity1,getAppData().getElement("CREATE_CHILD","ETHNICITY1"));
        waitAndClickElement(newChildGender);
        waitAndClickElement(saveButtonOnChildInformationPage);
        //TODO - manage it for UAT env
        waitAndClickElement(geoCodeErrorHandlerButton);

    }
    //********* NAME GENERATOR **********************
    public String generateFirstName(){
        String firstName = RandomStringUtils.randomAlphabetic( 5);
        getAppData().putToMap("FirstName",firstName);
        return firstName;
    }
    public String generateSurName(){
        String surName = RandomStringUtils.randomAlphabetic( 5);
        getAppData().putToMap("SurName",surName);
        return surName;
    }

}
