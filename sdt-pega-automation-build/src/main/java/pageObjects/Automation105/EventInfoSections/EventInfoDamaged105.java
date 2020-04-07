package pageObjects.Automation105.EventInfoSections;

import libs.BasePage;
import libs.ExecutionDeviceConfiguration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class EventInfoDamaged105 extends BasePage {

    private @FindBy(xpath = "//div[@data-test-id='20190611143117012945883']//label[text()='Yes']")
    WebElement toggleVehicleDamagedYes = null;
    private @FindBy(xpath = "//div[@data-test-id='20190611143117012945883']//label[text()='No']")
    WebElement toggleVehicleDamagedNo = null;
    private @FindBy(xpath = "//button[@data-test-id='20190611143620043533376']")
    WebElement buttonAddDamagedVehicle = null;
    private @FindBy(xpath = "//select[@data-test-id='2019060711284408547626']")
    List<WebElement> dropDownWhoOwnsDamagedVehicle = null;
    private @FindBy(xpath = "//input[@data-test-id='20190528170032047648357']")
    List<WebElement> textBoxDamagedOrganisationName = null;
    private @FindBy(xpath = "//textarea[@data-test-id='201906071026240649981']")
    List<WebElement> textHowWasVehicleDamaged = null;
    private @FindBy(xpath = "//input[@data-test-id='20190607114859023079571']")
    List<WebElement> textBoxDamagedVehicleOwnerFirstName = null;
    private @FindBy(xpath = "//input[@data-test-id='20190607114859023180130']")
    List<WebElement> textBoxDamagedVehicleOwnerMiddleName = null;
    private @FindBy(xpath = "//input[@data-test-id='20190607114859023181434']")
    List<WebElement> textBoxDamagedVehicleOwnerLastName = null;
    private @FindBy(xpath = "//input[@data-test-id='2019060710262406478129']")
    List<WebElement> textBoxLicencePlateDetails = null;
    private @FindBy(xpath = "//div[@data-test-id='201906111428240778478']//select[@data-test-id='2019052812011802847278']")
    List<WebElement> dropDownWhereWasVehicleWhenDamaged = null;
    private @FindBy(xpath = "//div[@data-test-id='20190618112359011330469']//label[text()='Yes']")
    List<WebElement> toggleWasVehicleMovedYes = null;
    private @FindBy(xpath = "//div[@data-test-id='20190618112359011330469']//label[text()='No']")
    List<WebElement> toggleWasVehicleMovedNo = null;
    private @FindBy(xpath = "//div[@data-test-id='20190618113315048532498']//label[text()='Yes']")
    List<WebElement> toggleWasIgnitionTamperedYes = null;
    private @FindBy(xpath = "//div[@data-test-id='20190618113315048532498']//label[text()='No']")
    List<WebElement> toggleWasIgnitionTamperedNo = null;
    private @FindBy(xpath = "//select[@data-test-id='2019052812011802847278']")
    WebElement dropDownWhereWasDamagedVehicle = null;
    private @FindBy(xpath = "//select[@data-test-id='201911271545550462296319']")
    List<WebElement> dropDownVehicleType = null;
    private @FindBy(xpath = "//input[@data-test-id='20191128133941070122729']")
    List<WebElement> textAreaVehicleMake = null;
    private @FindBy(xpath = "//table[contains(@pl_prop_class, 'Police-Data-NIA-Reference')]//tr[contains(@oaargs,'Make')]")
    List<WebElement> autoCompleteListVehicleMake = null;
    private @FindBy(xpath = "//textarea[@data-test-id='201911271720490196184103']")
    List<WebElement> textAreaIdentifyingFeatures = null;
    private @FindBy(xpath = "//select[@data-test-id='20190517154701027415986']")
    List<WebElement> dropDownWhoOwnsDamagedItem = null;
    private @FindBy(xpath = "//div[@data-test-id='201905221458400688672']//input[@data-test-id='20190412103124008161486']")
    List<WebElement> textBoxWhatwasDamaged = null;
    private @FindBy(xpath = "//input[@data-test-id='20190412103124008161486' and contains(@placeholder, 'item here')]")
    List<WebElement> textBoxWhatwasDamagedManualEntry = null;

    private @FindBy(xpath = "//input[@data-test-id='20190528170032047648357']")
    List<WebElement> textBoxDamagedItemOrganisationName = null;
    private @FindBy(xpath = "//textarea[@data-test-id='20190412103124008057146']")
    List<WebElement> textBoxHowWasitDamaged = null;
    private @FindBy(xpath = "//input[@data-test-id='201905171613100818271397']")
    List<WebElement> textBoxDamagedItemOwnerFirstName = null;
    private @FindBy(xpath = "//input[@data-test-id='201905171613100819272551']")
    List<WebElement> textBoxDamagedItemOwnerMiddleName = null;
    private @FindBy(xpath = "//input[@data-test-id='201905171613100819273605']")
    List<WebElement> textBoxDamagedItemOwnerLastName = null;
    private @FindBy(xpath = "//table[contains(@pl_prop,'D_ItemsList')]//tr[contains(@oaargs, 'Police-SDW-Data-Items')]")
    List<WebElement> whatwasDamagedAutoComplete = null;
    private @FindBy(xpath = "//div[@class='autocomplete-results']//li[contains(@class,'ac-item')]")
    List<WebElement> whatwasDamagedAutoCompleteMobile = null;
    private @FindBy(xpath = "//button[@data-test-id='20190524132600096441931']")
    WebElement buttonAddDamagedItem = null;
    private @FindBy(xpath = "//input[@data-test-id='20190919151250052142317']")
    List<WebElement> checkBoxCantFindAnItem = null;


    public void clickOnToggleVehicleDamagedNo() {
        waitAndclickElementUsingJS(toggleVehicleDamagedNo);
    }

    public void clickOnToggleVehicleDamagedYes() {
        waitAndclickElementUsingJS(toggleVehicleDamagedYes);
    }

    public void clickOnButtonAddDamagedVehicle() {
        waitAndclickElementUsingJS(buttonAddDamagedVehicle);
        int damagedVehiclesCommonFieldsIndex = addAndRetrieveDamagedVehiclesCommonFieldsIndex();
        _persistentData.setContext("damagedVehiclesCommonFieldsIndex", damagedVehiclesCommonFieldsIndex + 1);
    }

    public void selectDamagedItemOwnerFromDropDown(String owner) {
        int damagedItemsCommonFieldsIndex = addAndRetrieveDamagedItemsCommonFieldsIndex();
        selectFromDropDownbyValue(dropDownWhoOwnsDamagedItem.get(damagedItemsCommonFieldsIndex), owner);
        waitAndClickElement(textBoxWhatwasDamaged.get(damagedItemsCommonFieldsIndex));
    }

    public void keyInDataOnDamagedItemOwnerField(String owner, String dataSet) {
        int damagedVehiclesCommonFieldsIndex = addAndRetrieveDamagedItemsCommonFieldsIndex();
        int damagedItemsOwnerSomeOneElseIndex = addAndRetrieveDamagedItemOwnerSomeOneElseIndex();
        switch (owner) {
            case "An organisation does":
                String organisation = _retrieveTestData.extractDataOffDataFile(dataSet + ".owner.organisationName");
                //keyInDamagedItemOwnerOrganisationName(organisation);
                keyInDamagedOwnerOrganisationName(organisation);
                waitAndClickElement(textBoxHowWasitDamaged.get(damagedVehiclesCommonFieldsIndex));
                //waitForOwnerNameToLoadInDropDown(dropDownWhoOwnsDamagedItem.get(damagedVehiclesCommonFieldsIndex), organisation);
                break;
            case "Somebody else does":
                String firstName = _retrieveTestData.extractDataOffDataFile(dataSet + ".owner.firstName");
                keyInDamagedItemOwnerFirstName(firstName);
                waitAndClickElement(textBoxDamagedItemOwnerMiddleName.get(damagedItemsOwnerSomeOneElseIndex));
                //waitForOwnerNameToLoadInDropDown(dropDownWhoOwnsDamagedItem.get(damagedVehiclesCommonFieldsIndex), firstName);
                keyInDamagedItemOwnerMiddleName(_retrieveTestData.extractDataOffDataFile(dataSet + ".owner.middleName"));
                keyInDamagedItemOwnerLastName(_retrieveTestData.extractDataOffDataFile(dataSet + ".owner.lastName"));
                waitAndClickElement(textBoxDamagedItemOwnerMiddleName.get(damagedItemsOwnerSomeOneElseIndex));
                waitForOwnerLastNameToTurnCaps(textBoxDamagedItemOwnerLastName.get(damagedItemsOwnerSomeOneElseIndex));
                break;
        }
    }

    public void keyInDamagedItemOwnerMiddleName(String middleName) {
        int damagedItemsOwnerSomeOneElseIndex = addAndRetrieveDamagedItemOwnerSomeOneElseIndex();
        sendKeysToWebElement(textBoxDamagedItemOwnerMiddleName.get(damagedItemsOwnerSomeOneElseIndex), middleName);
    }

    public void keyInDamagedItemOwnerLastName(String lastName) {
        int damagedItemsOwnerSomeOneElseIndex = addAndRetrieveDamagedItemOwnerSomeOneElseIndex();
        sendKeysToWebElement(textBoxDamagedItemOwnerLastName.get(damagedItemsOwnerSomeOneElseIndex), lastName);
        _persistentData.setContext("damagedItemsOwnerSomeOneElseIndex", damagedItemsOwnerSomeOneElseIndex + 1);
    }

    private void keyInDamagedItemOwnerFirstName(String firstName) {
        int damagedItemsOwnerSomeOneElseIndex = addAndRetrieveDamagedItemOwnerSomeOneElseIndex();
        sendKeysToWebElement(textBoxDamagedItemOwnerFirstName.get(damagedItemsOwnerSomeOneElseIndex), firstName);
    }

    /*private void keyInDamagedItemOwnerOrganisationName(String organisationName) {
        int damagedItemsOrganisationOwnerIndex = addAndRetrieveDamagedItemOrganisationOwnerIndex();
        sendKeysToWebElement(textBoxDamagedItemOrganisationName.get(damagedItemsOrganisationOwnerIndex), organisationName);
        _persistentData.setContext("damagedItemsOrganisationOwnerIndex", damagedItemsOrganisationOwnerIndex + 1);
    }*/

    public void keyInDataOnWhatWasDamaged(String dataSet) {
        executionDeviceConfiguration = new ExecutionDeviceConfiguration(getDeviceKey());
        String deviceType = executionDeviceConfiguration.getDeviceParameters("DEVICE");
        if (deviceType.toLowerCase().contains("tab") || deviceType.equalsIgnoreCase("Google Nexus 9") || deviceType.toLowerCase().contains("ipad")) {
            whatwasDamagedAutoCompleteMobile = whatwasDamagedAutoComplete;
        }
        int damagedItemsCommonFieldsIndex = addAndRetrieveDamagedItemsCommonFieldsIndex();
        if (_platFormName.equalsIgnoreCase("ios") || (_platFormName.equalsIgnoreCase("android"))) {
            selectLookupValue(textBoxWhatwasDamaged.get(damagedItemsCommonFieldsIndex), whatwasDamagedAutoCompleteMobile, _retrieveTestData.extractDataOffDataFile(dataSet + ".damagedItem"), false);
        } else {
            if (_retrieveTestData.extractDataOffDataFile(dataSet + ".damagedItem").equalsIgnoreCase("not found")) {
                keyInDamagedItemManualEntry(dataSet);
            } else {
                selectLookupValue(textBoxWhatwasDamaged.get(damagedItemsCommonFieldsIndex), whatwasDamagedAutoComplete, _retrieveTestData.extractDataOffDataFile(dataSet + ".damagedItem"), false);
            }
        }
    }

    private void keyInDamagedItemManualEntry(String dataSet) {
        int damagedItemCommonFieldsIndex = addAndRetrieveDamagedItemsCommonFieldsIndex();
        waitAndclickElementUsingJS(checkBoxCantFindAnItem.get(damagedItemCommonFieldsIndex));
        sendKeysToWebElement(textBoxWhatwasDamagedManualEntry.get(damagedItemCommonFieldsIndex), _retrieveTestData.extractDataOffDataFile(dataSet + ".damagedItemManual"));

    }

    public void keyInHowWasItDamagedData(String dataSet) {
        int damagedItemsCommonFieldsIndex = addAndRetrieveDamagedItemsCommonFieldsIndex();
        sendKeysToWebElement(textBoxHowWasitDamaged.get(damagedItemsCommonFieldsIndex), _retrieveTestData.extractDataOffDataFile(dataSet + ".howWasItDamaged"));
    }

    public void clickOnAddDamagedItem() {
        waitAndclickElementUsingJS(buttonAddDamagedItem);
        int damagedItemsCommonFieldsIndex = addAndRetrieveDamagedItemsCommonFieldsIndex();
        _persistentData.setContext("damagedItemsCommonFieldsIndex", damagedItemsCommonFieldsIndex + 1);
    }

    private int addAndRetrieveDamagedItemOrganisationOwnerIndex() {
        int damagedItemsOrganisationOwnerIndex = 0;
        try {
            damagedItemsOrganisationOwnerIndex = (int) _persistentData.getContext("damagedItemsOrganisationOwnerIndex");
        } catch (Exception e) {
            _persistentData.setContext("damagedItemsOrganisationOwnerIndex", damagedItemsOrganisationOwnerIndex);
        }
        return damagedItemsOrganisationOwnerIndex;
    }

    private int addAndRetrieveDamagedItemOwnerSomeOneElseIndex() {
        int damagedItemsOwnerSomeOneElseIndex = 0;
        try {
            damagedItemsOwnerSomeOneElseIndex = (int) _persistentData.getContext("damagedItemsOwnerSomeOneElseIndex");
        } catch (Exception e) {
            _persistentData.setContext("damagedItemsOwnerSomeOneElseIndex", damagedItemsOwnerSomeOneElseIndex);
        }
        return damagedItemsOwnerSomeOneElseIndex;
    }

    private int addAndRetrieveDamagedItemsCommonFieldsIndex() {
        int damagedItemsCommonFieldsIndex = 0;
        try {
            damagedItemsCommonFieldsIndex = (int) _persistentData.getContext("damagedItemsCommonFieldsIndex");
        } catch (Exception e) {
            _persistentData.setContext("damagedItemsCommonFieldsIndex", damagedItemsCommonFieldsIndex);
        }
        return damagedItemsCommonFieldsIndex;
    }

    private int addAndRetrieveDamagedVehiclesCommonFieldsIndex() {
        int damagedVehiclesCommonFieldsIndex = 0;
        try {
            damagedVehiclesCommonFieldsIndex = (int) _persistentData.getContext("damagedVehiclesCommonFieldsIndex");
        } catch (Exception e) {
            _persistentData.setContext("damagedVehiclesCommonFieldsIndex", damagedVehiclesCommonFieldsIndex);
        }
        return damagedVehiclesCommonFieldsIndex;
    }

    public void selectDamagedVehicleOwnerFromDropDown(String owner) {
        int damagedVehiclesCommonFieldsIndex = addAndRetrieveDamagedVehiclesCommonFieldsIndex();
        waitForPageComponentLoadFluentWait();
        WebElement ele = dropDownWhoOwnsDamagedVehicle.get(damagedVehiclesCommonFieldsIndex);
        selectFromDropDownbyValue(ele, owner);
    }

    public void keyInDataOnDamagedVehicleOwnerField(String owner, String dataSet) {
        int damagedVehiclesCommonFieldsIndex = addAndRetrieveDamagedVehiclesCommonFieldsIndex();
        int damagedVehiclesOwnerSomeOneElseIndex = addAndRetrieveDamagedVehicleOwnerSomeOneElseIndex();

        switch (owner) {
            case "An organisation does":
                String organisation = _retrieveTestData.extractDataOffDataFile(dataSet + ".owner.organisationName");
                keyInDamagedOwnerOrganisationName(organisation);
                waitAndClickElement(textHowWasVehicleDamaged.get(damagedVehiclesCommonFieldsIndex));
                //waitForOwnerNameToLoadInDropDown(dropDownWhoOwnsDamagedVehicle.get(damagedVehiclesCommonFieldsIndex), organisation);
                break;
            case "Somebody else does":
                String firstName = _retrieveTestData.extractDataOffDataFile(dataSet + ".owner.firstName");
                keyInDamagedVehicleOwnerFirstName(firstName);
                waitAndClickElement(textBoxDamagedVehicleOwnerMiddleName.get(damagedVehiclesOwnerSomeOneElseIndex));
                //waitForOwnerNameToLoadInDropDown(dropDownWhoOwnsDamagedVehicle.get(damagedVehiclesCommonFieldsIndex), firstName);
                keyInDamagedVehicleOwnerMiddleName(_retrieveTestData.extractDataOffDataFile(dataSet + ".owner.middleName"));
                keyInDamagedVehicleOwnerLastName(_retrieveTestData.extractDataOffDataFile(dataSet + ".owner.lastName"));
                break;
        }
    }

    private int addAndRetrieveDamagedVehicleOwnerSomeOneElseIndex() {
        int damagedVehiclesOwnerSomeOneElseIndex = 0;
        try {
            damagedVehiclesOwnerSomeOneElseIndex = (int) _persistentData.getContext("damagedVehiclesOwnerSomeOneElseIndex");
        } catch (Exception e) {
            _persistentData.setContext("damagedVehiclesOwnerSomeOneElseIndex", damagedVehiclesOwnerSomeOneElseIndex);
        }
        return damagedVehiclesOwnerSomeOneElseIndex;
    }

    private void keyInDamagedOwnerOrganisationName(String organisationName) {
        int damagedOrganisationOwnerIndex = addAndRetrieveDamagedOrganisationOwnerIndex();
        sendKeysToWebElement(textBoxDamagedOrganisationName.get(damagedOrganisationOwnerIndex), organisationName);
        _persistentData.setContext("damagedOrganisationOwnerIndex", damagedOrganisationOwnerIndex + 1);
    }

    private int addAndRetrieveDamagedOrganisationOwnerIndex() {
        int damagedOrganisationOwnerIndex = 0;
        try {
            damagedOrganisationOwnerIndex = (int) _persistentData.getContext("damagedOrganisationOwnerIndex");
        } catch (Exception e) {
            _persistentData.setContext("damagedOrganisationOwnerIndex", damagedOrganisationOwnerIndex);
        }
        return damagedOrganisationOwnerIndex;
    }

    private void keyInDamagedVehicleOwnerFirstName(String firstName) {
        int damagedVehiclesOwnerSomeOneElseIndex = addAndRetrieveDamagedVehicleOwnerSomeOneElseIndex();
        sendKeysToWebElement(textBoxDamagedVehicleOwnerFirstName.get(damagedVehiclesOwnerSomeOneElseIndex), firstName);
    }

    private void keyInDamagedVehicleOwnerMiddleName(String middleName) {
        int damagedVehiclesOwnerSomeOneElseIndex = addAndRetrieveDamagedVehicleOwnerSomeOneElseIndex();
        sendKeysToWebElement(textBoxDamagedVehicleOwnerMiddleName.get(damagedVehiclesOwnerSomeOneElseIndex), middleName);
    }

    private void keyInDamagedVehicleOwnerLastName(String lastName) {
        int damagedVehiclesOwnerSomeOneElseIndex = addAndRetrieveDamagedVehicleOwnerSomeOneElseIndex();
        sendKeysToWebElement(textBoxDamagedVehicleOwnerLastName.get(damagedVehiclesOwnerSomeOneElseIndex), lastName);
        waitAndClickElement(textBoxDamagedVehicleOwnerMiddleName.get(damagedVehiclesOwnerSomeOneElseIndex));
        waitForOwnerLastNameToTurnCaps(textBoxDamagedVehicleOwnerLastName.get(damagedVehiclesOwnerSomeOneElseIndex));
        _persistentData.setContext("damagedVehiclesOwnerSomeOneElseIndex", damagedVehiclesOwnerSomeOneElseIndex + 1);
    }

    public void keyInDamagedVehicleLicensePlate(String dataSet) {
        int damagedVehiclesCommonFieldsIndex = addAndRetrieveDamagedVehiclesCommonFieldsIndex();
        sendKeysToWebElement(textBoxLicencePlateDetails.get(damagedVehiclesCommonFieldsIndex), _retrieveTestData.extractDataOffDataFile(dataSet + ".licencePlate"));
    }

    public void selectWhereWasVehicleWhenItWasDamaged(String dataSet) {
        int damagedVehiclesCommonFieldsIndex = addAndRetrieveDamagedVehiclesCommonFieldsIndex();
        String value = _retrieveTestData.extractDataOffDataFile(dataSet + ".whereWasVehicleWhenDamaged");
        selectFromDropDownbyValue(dropDownWhereWasVehicleWhenDamaged.get(damagedVehiclesCommonFieldsIndex), value);
    }

    public void selectDamagedVehicleMovedIndicator(String dataSet) {
        int damagedVehiclesCommonFieldsIndex = addAndRetrieveDamagedVehiclesCommonFieldsIndex();
        String value = _retrieveTestData.extractDataOffDataFile(dataSet + ".vehicleMoved");
        if (value.equalsIgnoreCase("yes")) {
            waitAndclickElementUsingJS(toggleWasVehicleMovedYes.get(damagedVehiclesCommonFieldsIndex));
        } else {
            waitAndclickElementUsingJS(toggleWasVehicleMovedNo.get(damagedVehiclesCommonFieldsIndex));
        }
    }

    public void selectDamagedVehicleIgnitionTamperedIndicator(String dataSet) {
        int damagedVehiclesCommonFieldsIndex = addAndRetrieveDamagedVehiclesCommonFieldsIndex();
        String value = _retrieveTestData.extractDataOffDataFile(dataSet + ".ignitionTampered");
        if (value.equalsIgnoreCase("yes")) {
            waitAndclickElementUsingJS(toggleWasIgnitionTamperedYes.get(damagedVehiclesCommonFieldsIndex));
        } else {
            waitAndclickElementUsingJS(toggleWasIgnitionTamperedNo.get(damagedVehiclesCommonFieldsIndex));
        }
    }

    public void keyInHowWasVehicleDamaged(String dataSet) {
        int damagedVehiclesCommonFieldsIndex = addAndRetrieveDamagedVehiclesCommonFieldsIndex();
        sendKeysToWebElement(textHowWasVehicleDamaged.get(damagedVehiclesCommonFieldsIndex), _retrieveTestData.extractDataOffDataFile(dataSet + ".howWasItDamaged"));
    }

    private void selectDamagedVehicleWherewasIt(int count) {
        selectFromDropDownbyValue(dropDownWhereWasDamagedVehicle, _retrieveTestData.extractDataOffDataFile("damagedVehicles_" + count + ".damagedVehicleLocation"));
    }

    public void keyInIdentifyingFeatures(String dataSet) {
        int damagedVehiclesCommonFieldsIndex = addAndRetrieveDamagedVehiclesCommonFieldsIndex();
        sendKeysToWebElement(textAreaIdentifyingFeatures.get(damagedVehiclesCommonFieldsIndex), _retrieveTestData.extractDataOffDataFile(dataSet + ".identifyingFeatures"));
    }

    public void selectDamagedVehicleType(String dataSet) {
        int damagedVehiclesCommonFieldsIndex = addAndRetrieveDamagedVehiclesCommonFieldsIndex();
        selectFromDropDownbyValue(dropDownVehicleType.get(damagedVehiclesCommonFieldsIndex), _retrieveTestData.extractDataOffDataFile(dataSet + ".vehicleType"));
    }

    public void selectDamagedVehicleMake(String dataSet) {
        int damagedVehiclesCommonFieldsIndex = addAndRetrieveDamagedVehiclesCommonFieldsIndex();
        selectLookupValue(textAreaVehicleMake.get(damagedVehiclesCommonFieldsIndex), autoCompleteListVehicleMake, _retrieveTestData.extractDataOffDataFile(dataSet + ".vehicleMake"), false);
    }
}
