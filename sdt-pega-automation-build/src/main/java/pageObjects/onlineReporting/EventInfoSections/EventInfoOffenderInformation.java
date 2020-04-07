package pageObjects.onlineReporting.EventInfoSections;

import com.fasterxml.jackson.databind.JsonNode;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.json.Json;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;

public class EventInfoOffenderInformation extends EventInfo {

    private @FindBy(xpath = "//div[@data-test-id='201905221412290348702']")
    WebElement sectionWhoWasInvolved = null;

    //Information of Offender
    private @FindBy(xpath = "//label[@data-test-id='2019041610483800415866-Label']")
    WebElement labelDoIknowWhoOffenderIs = null;
    private @FindBy(xpath = "//div[@data-test-id='2019041610483800415866']//label[text()='Yes']")
    WebElement toggleIknowWhoOffenderIsYes = null;
    private @FindBy(xpath = "//label[@data-test-id='201904161055010164243-Label']")
    WebElement labelProvideMoreDetailsofOffender = null;
    private @FindBy(xpath = "//textarea[@data-test-id='201904161055010164243']")
    WebElement textBoxProvideMoreDetailsofOffender = null;
    private @FindBy(xpath = "//label[@data-test-id='2019041613010605623564-Label']")
    WebElement labelThisPersonIs = null;
    private @FindBy(xpath = "//select[@data-test-id='2019041613010605623564']")
    WebElement dropDownOffenderRelationship = null;
    private @FindBy(xpath = "//div[@data-test-id='2019041610483800415866']//label[text()='No']")
    WebElement toggleIknowWhoOffenderIsNo = null;
    private @FindBy(xpath = "//input[@data-test-id='201905201749300325102999']")
    WebElement textBoxDescribeHowYouKnowthePerson = null;

    //Offender Description
    private @FindBy(xpath = "//label[@data-test-id='20190527150224046730366-Label']")
    WebElement labelDescribeOffender = null;
    private @FindBy(xpath = "//div[@data-test-id='20190527150224046730366']//label[text()='Yes']")
    WebElement toggleDescribeOffenderYes = null;
    private @FindBy(xpath = "//label[@data-test-id='20190527150617081032305-Label']")
    WebElement labelOffenderDescription = null;
    private @FindBy(xpath = "//textarea[@data-test-id='20190527150617081032305']")
    WebElement textBoxOffenderDescription = null;
    private @FindBy(xpath = "//div[@data-test-id='20190527150224046730366']//label[text()='No']")
    WebElement toggleDescribeOffenderNo = null;

    //Offender Vehicle
    private @FindBy(xpath = "//label[@data-test-id='20190418114941075437388-Label']")
    WebElement labelOffenderUsedAVehicle = null;
    private @FindBy(xpath = "//div[@data-test-id='20190418114941075437388']//label[text()='Yes']")
    WebElement toggleOffenderUsedAVehicleYes = null;
    private @FindBy(xpath = "//label[@data-test-id='20190418120056069645281-Label']")
    WebElement labelOffenderVehicleLicensePlate = null;
    private @FindBy(xpath = "//input[@data-test-id='20190418120056069645281']")
    WebElement textBoxOffenderVehicleLicensePlate = null;
    private @FindBy(xpath = "//label[@data-test-id='2019041812005606974628-Label']")
    WebElement labelOffenderVehicleDescription = null;
    private @FindBy(xpath = "//textarea[@data-test-id='2019041812005606974628']")
    WebElement textBoxOffenderVehicleDescription = null;
    private @FindBy(xpath = "//div[@data-test-id='20190418114941075437388']//label[text()='No']")
    WebElement toggleOffenderUsedAVehicleNo = null;
    private @FindBy(xpath = "//div[@id='$PpyWorkPage$pOffender$pVehicleDescriptionError']/span")
    WebElement errorMessageVehicleDescription = null;


    //Contact Witness
    private @FindBy(xpath = "//label[@data-test-id='20190417104848064415634-Label']")
    WebElement labelAnyWitness = null;
    private @FindBy(xpath = "//div[@data-test-id='20190417104848064415634']//label[text()='Yes']")
    WebElement toggleWitnessYes = null;
    private @FindBy(xpath = "//label[@data-test-id='20190416103351098619556-Label']")
    WebElement labelProvideWitnessDetails = null;
    private @FindBy(xpath = "//textarea[@data-test-id='20190416103351098619556']")
    WebElement textBoxProvideWitnessDetails = null;
    private @FindBy(xpath = "//div[@data-test-id='20190417104848064415634']//label[text()='No']")
    WebElement toggleWitnessNo = null;

    private @FindBy(xpath = "//div[@data-test-id='201905220926140061260']//span[contains(text(), 'immediate attention')]")
    WebElement warningCall111FamilyMember = null;

    private @FindBy(xpath = "//button[@data-test-id='20161017110917023176385']")
    WebElement buttonContinueFromOffenderPageMobile = null;

    public boolean checkIfWhoWasInvolvedSectionIsDisplayed() {
        return isElementDisplayed(sectionWhoWasInvolved);
    }

    public void clickOnIKnowTheOffenderYes() {
        waitAndclickElementUsingJS(toggleIknowWhoOffenderIsYes);
    }

    public void clickOnIKnowTheOffenderNo() {
        waitAndclickElementUsingJS(toggleIknowWhoOffenderIsNo);
    }


    public void keyInOffenderDetails() {
        sendKeysToWebElement(textBoxProvideMoreDetailsofOffender, _generateTestData.generateValidData("whoWasInvolved.whoHasDoneThis.detailAboutOffender"));
        String offenderRelationShip = _generateTestData.generateValidData("whoWasInvolved.whoHasDoneThis.personIs");
        selectFromDropDownbyValue(dropDownOffenderRelationship, offenderRelationShip);
    }

    public void validateOffenderRelationShipDropDownValues(String[] expectedList) {
        List<WebElement> dropDownValues = getAllListValuesInDropDown(dropDownOffenderRelationship);
        validateDropDownListValues(dropDownValues, expectedList);
    }

    public String check111EmergencyIndicationAppearsAndExtractText() {
        isElementDisplayed(warningCall111FamilyMember);
        return waitandGetText(warningCall111FamilyMember);
    }

    public void selectRelationShipType(String relationShip) {
        selectFromDropDownbyValue(dropDownOffenderRelationship, relationShip);
    }

    public boolean checkDescribeHowYouKnowPersonFieldExists() {
        isElementDisplayed(textBoxDescribeHowYouKnowthePerson);
        return true;
    }

    public void indicateIhaveDescriptionOfOffenderYes() {
        waitAndclickElementUsingJS(toggleDescribeOffenderYes);
    }

    public void indicateIhaveDescriptionOfOffenderNo() {
        waitAndclickElementUsingJS(toggleDescribeOffenderNo);
    }

    public void checkFieldsOfOffenderDescription() {
        isElementDisplayed(labelOffenderDescription);
        isElementDisplayed(textBoxOffenderDescription);
        isElementDisplayed(toggleDescribeOffenderNo);
        isElementDisplayed(labelDescribeOffender);
    }

    public void selectFamilyMemberAsOffender() {
        waitAndclickElementUsingJS(toggleIknowWhoOffenderIsYes);
        sendKeysToWebElement(textBoxProvideMoreDetailsofOffender, _generateTestData.generateValidData("whoWasInvolved.whoHasDoneThis.detailAboutOffender"));
        selectFromDropDownbyValue(dropDownOffenderRelationship, "Family member/whanau");
    }

    public void keyInOffenderDescription() {
        sendKeysToWebElement(textBoxOffenderDescription, _generateTestData.generateValidData("whoWasInvolved.describePerson.descriptionOfOffender"));
    }

    public void indicateOffenderUsedVehicleYes() {
        waitAndclickElementUsingJS(toggleOffenderUsedAVehicleYes);
    }

    public void indicateOffenderUsedVehicleNo() {
        waitAndclickElementUsingJS(toggleOffenderUsedAVehicleNo);
    }

    public void checkFieldsOffenderVehicle() {
        isElementDisplayed(labelOffenderUsedAVehicle);
        isElementDisplayed(toggleOffenderUsedAVehicleYes);
        isElementDisplayed(labelOffenderVehicleLicensePlate);
        isElementDisplayed(textBoxOffenderVehicleLicensePlate);
        isElementDisplayed(labelOffenderVehicleDescription);
        isElementDisplayed(textBoxOffenderVehicleDescription);
        isElementDisplayed(toggleOffenderUsedAVehicleNo);
    }

    public void keyInDataOnOffenderVehicles() {
        sendKeysToWebElement(textBoxOffenderVehicleLicensePlate, _generateTestData.generateValidData("whoWasInvolved.offenderVehicle.licencePlate"));
        sendKeysToWebElement(textBoxOffenderVehicleDescription, _generateTestData.generateValidData("whoWasInvolved.offenderVehicle.vehicleLooks"));
    }

    public void indicateThereIsAWitnessYes() {
        waitAndclickElementUsingJS(toggleWitnessYes);
    }

    public void indicateThereIsAWitnessNo() {
        waitAndclickElementUsingJS(toggleWitnessNo);
    }

    public void checkFieldsWitness() {
        isElementDisplayed(labelAnyWitness);
        isElementDisplayed(toggleWitnessYes);
        isElementDisplayed(labelProvideWitnessDetails);
        isElementDisplayed(textBoxProvideWitnessDetails);
    }

    public void keyInDataOnWitness() {
        sendKeysToWebElement(textBoxProvideWitnessDetails, _generateTestData.generateValidData("whoWasInvolved.witnessInformation.witnessDetails"));
    }

    public void keyInDataOnDescribeHowYouKnowPersonField() {
        sendKeysToWebElement(textBoxDescribeHowYouKnowthePerson, "whoWasInvolved.whoHasDoneThis.other");
    }

    public void clickOnContinueButtonFromOffenderPageMobile() {
        waitAndclickElementUsingJS(buttonContinueFromOffenderPageMobile);
    }

    public void getVehicleDescriptionMandatoryErrorMessage() {
        isElementDisplayed(errorMessageVehicleDescription);
    }


}
