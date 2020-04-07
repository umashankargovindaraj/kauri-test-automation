package pageObjects.Automation105.EventInfoSections;

import libs.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EventInfoOffenderInformation105 extends BasePage {

    //Information of Offender
    private @FindBy(xpath = "//div[@data-test-id='2019041610483800415866']//label[text()='Yes']")
    WebElement toggleIknowWhoOffenderIsYes = null;
    private @FindBy(xpath = "//textarea[@data-test-id='201904161055010164243']")
    WebElement textBoxProvideMoreDetailsofOffender = null;
    private @FindBy(xpath = "//select[@data-test-id='2019041613010605623564']")
    WebElement dropDownOffenderRelationship = null;
    private @FindBy(xpath = "//div[@data-test-id='2019041610483800415866']//label[text()='No']")
    WebElement toggleIknowWhoOffenderIsNo = null;
    private @FindBy(xpath = "//input[@data-test-id='201905201749300325102999']")
    WebElement textBoxDescribeHowYouKnowthePerson = null;

    //Offender Description
    private @FindBy(xpath = "//div[@data-test-id='20190527150224046730366']//label[text()='Yes']")
    WebElement toggleDescribeOffenderYes = null;
    private @FindBy(xpath = "//textarea[@data-test-id='20190527150617081032305']")
    WebElement textBoxOffenderDescription = null;
    private @FindBy(xpath = "//div[@data-test-id='20190527150224046730366']//label[text()='No']")
    WebElement toggleDescribeOffenderNo = null;

    //Offender Vehicle
    private @FindBy(xpath = "//div[@data-test-id='20190418114941075437388']//label[text()='Yes']")
    WebElement toggleOffenderUsedAVehicleYes = null;
    private @FindBy(xpath = "//input[@data-test-id='20190418120056069645281']")
    WebElement textBoxOffenderVehicleLicensePlate = null;
    private @FindBy(xpath = "//textarea[@data-test-id='2019041812005606974628']")
    WebElement textBoxOffenderVehicleDescription = null;
    private @FindBy(xpath = "//div[@data-test-id='20190418114941075437388']//label[text()='No']")
    WebElement toggleOffenderUsedAVehicleNo = null;


    //Contact Witness
    private @FindBy(xpath = "//div[@data-test-id='20190417104848064415634']//label[text()='Yes']")
    WebElement toggleWitnessYes = null;
    private @FindBy(xpath = "//textarea[@data-test-id='20190416103351098619556']")
    WebElement textBoxProvideWitnessDetails = null;
    private @FindBy(xpath = "//div[@data-test-id='20190417104848064415634']//label[text()='No']")
    WebElement toggleWitnessNo = null;


    public void clickOnIKnowTheOffenderYes() {
        waitAndclickElementUsingJS(toggleIknowWhoOffenderIsYes);
    }

    public void clickOnIKnowTheOffenderNo() {
        waitAndclickElementUsingJS(toggleIknowWhoOffenderIsNo);
    }


    public void keyInOffenderDetails() {
        sendKeysToWebElement(textBoxProvideMoreDetailsofOffender, _retrieveTestData.extractDataOffDataFile("whoWasInvolved.whoHasDoneThis.detailAboutOffender"));
        String offenderRelationShip = _retrieveTestData.extractDataOffDataFile("whoWasInvolved.whoHasDoneThis.personIs");
        selectFromDropDownbyValue(dropDownOffenderRelationship, offenderRelationShip);
    }

    public void indicateIhaveDescriptionOfOffenderYes() {
        waitAndclickElementUsingJS(toggleDescribeOffenderYes);
    }

    public void indicateIhaveDescriptionOfOffenderNo() {
        waitAndclickElementUsingJS(toggleDescribeOffenderNo);
    }

    public void keyInOffenderDescription() {
        sendKeysToWebElement(textBoxOffenderDescription, _retrieveTestData.extractDataOffDataFile("whoWasInvolved.describePerson.descriptionOfOffender"));
    }

    public void indicateOffenderUsedVehicleYes() {
        waitAndclickElementUsingJS(toggleOffenderUsedAVehicleYes);
    }

    public void indicateOffenderUsedVehicleNo() {
        waitAndclickElementUsingJS(toggleOffenderUsedAVehicleNo);
    }

    public void keyInDataOnOffenderVehicles() {
        sendKeysToWebElement(textBoxOffenderVehicleLicensePlate, _retrieveTestData.extractDataOffDataFile("whoWasInvolved.offenderVehicle.licencePlate"));
        sendKeysToWebElement(textBoxOffenderVehicleDescription, _retrieveTestData.extractDataOffDataFile("whoWasInvolved.offenderVehicle.vehicleLooks"));
    }

    public void indicateThereIsAWitnessYes() {
        waitAndclickElementUsingJS(toggleWitnessYes);
    }

    public void indicateThereIsAWitnessNo() {
        waitAndclickElementUsingJS(toggleWitnessNo);
    }

    public void keyInDataOnWitness() {
        sendKeysToWebElement(textBoxProvideWitnessDetails, _retrieveTestData.extractDataOffDataFile("whoWasInvolved.witnessInformation.witnessDetails"));
    }

}
